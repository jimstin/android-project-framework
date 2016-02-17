package com.jimstin.frameworklib.utils;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.jimstin.frameworklib.R;
import com.jimstin.frameworklib.net.UrlData;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by jim on 16-2-17.
 */
public class UrlConfigManager {

    private static final String TAG_NODE = "node";

    public static UrlData findUrlData(Context context, String key) {
        UrlData urlData = new UrlData();
        try {
            XmlResourceParser xmlParser = context.getResources().getXml(R.xml.url);
            int eventType = xmlParser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (xmlParser.getName().equals(TAG_NODE)) {
                            int count = xmlParser.getAttributeCount();
                            for (int i = 0; i < count; i++) {
                                String value = xmlParser.getAttributeValue(i);
                                switch (i) {
                                    case 0:
                                        urlData.setName(value);
                                        break;
                                    case 1:
                                        urlData.setMethod(value);
                                        break;
                                    case 2:
                                        urlData.setApi(value);
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if (!TextUtils.isEmpty(urlData.getName()) && urlData.getName().equals(key)) {
                            return urlData;
                        }
                        break;

                }
                eventType = xmlParser.next();
            }
            xmlParser.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
