package com.jimstin.frameworklib.net;

import android.os.Handler;
import com.jimstin.frameworklib.app.FrameworkApp;
import com.jimstin.frameworklib.entity.BaseEntity;
import com.jimstin.frameworklib.utils.DebugUtil;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpProtocolParams;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jim on 16-2-13.
 */
public class HttpRequest implements Runnable, Serializable {

    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    private final String ENCODE_UTF_8 = "utf-8";

    private boolean isRemoved;
    /**
     * GET 或 POST
     */
    private String method;
    private RequestInPack inpack;
    private Response response;
    private Handler handler;

    public HttpRequest(String method, RequestInPack inpack,
                       RequestManager requestManager) {
        this.method = method.toUpperCase();
        this.inpack = inpack;
        requestManager.getRequestList().add(this);
        response = new Response();
        handler = new Handler(FrameworkApp.getContext().getMainLooper());
    }

    /**
     * 发起网络访问
     */
    public void startRequest() {
        DefaultThreadPool.getInstance().startRequest(this);
    }

    public void abort() {
        isRemoved = DefaultThreadPool.getInstance().getTaskQuene().remove(this);
    }

    @Override
    public void run() {
        String result = getResponse(inpack, ENCODE_UTF_8);
        if(!isRemoved) {
            BaseEntity baseEntity = inpack.getBaseEntity().doParse(result);
            response.setResult(baseEntity);
            response.setErrorMessage("");
            handler.post(new Runnable() {
                @Override
                public void run() {
                    if(response.isError()) {
                        response.setErrorType(-1);
                        inpack.getCallback().onFail(response);
                        DebugUtil.logError("onFail");
                    } else {
                        response.setErrorType(0);
                        inpack.getCallback().onSuccess(response);
                        DebugUtil.logInfo("onSuccess");

                    }
                }
            });
        }
    }

    private String getResponse(RequestInPack inpack, String encode) {

        String result = "";

        HttpEntity entity = null;
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

        List<NameValuePair> list = new ArrayList<NameValuePair>();
        UrlData urlData = inpack.getUrlData();
        String url = urlData.getUrl();
        ArrayList<RequestParameter> parameters = inpack.getParameters();

        DebugUtil.logInfo("url->" + url);
        if (parameters != null && !parameters.isEmpty()) {
            for (RequestParameter parameter : parameters) {
                list.add(new BasicNameValuePair(parameter.getKey(), parameter
                        .getValue()));
                DebugUtil.logInfo(parameter.getKey() + ":" + parameter.getValue() + "\n");
                builder.addTextBody(parameter.getKey(), parameter.getValue(),
                        ContentType.create("text/plain", "utf-8"));
            }
        }
        ArrayList<String> filePath = inpack.getFilePath();
        if (filePath != null && filePath.size() > 0) {
            for (String path : filePath) {
                File file = new File(path);
                builder.addBinaryBody("images[]", file, ContentType.create("image/jpeg", "utf-8"), path);
                DebugUtil.logInfo("filePath" + path);
            }
        }

        entity = builder.build();
        try {
            HttpPost httpPost = new HttpPost(url);
            BasicHttpParams httpParams = new BasicHttpParams();
            String userAgent = "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2) Gecko/20100115 Firefox/3.6";
            HttpProtocolParams.setUserAgent(httpParams, userAgent);
            HttpClientParams.setRedirecting(httpParams, true);
            httpPost.setEntity(entity);
            DefaultHttpClient client = new DefaultHttpClient(httpParams);

            HttpResponse httpResponse = client.execute(httpPost);
            int code = httpResponse.getStatusLine().getStatusCode();
            if (code == 200) {
                InputStream inputStream = httpResponse.getEntity().getContent();
                response.setIsError(false);
                result = getResponse(inputStream, encode);
            } else {
                response.setIsError(true);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return result;
    }

    private String getResponse(InputStream inputStream, String encode) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        String result = "";
        if (inputStream != null) {
            try {
                while ((len = inputStream.read(data)) != -1) {
                    outputStream.write(data, 0, len);
                }
                result = new String(outputStream.toByteArray(), encode);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                inputStream.close();
            }
        }

        DebugUtil.logInfo(result);

        return result;
    }
}
