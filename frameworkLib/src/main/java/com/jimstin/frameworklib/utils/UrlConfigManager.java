package com.jimstin.frameworklib.utils;

import android.content.Context;
import android.content.res.XmlResourceParser;
import com.jimstin.frameworklib.R;
import com.jimstin.frameworklib.net.UrlData;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by jim on 16-2-17.
 */
public class UrlConfigManager {
    public static UrlData findUrlDate(Context context, String name) {
        UrlData urldata = new UrlData();
        parseXml(context);
        return urldata;
    }

    private static void parseXml(Context context) {
        try {
            XmlResourceParser xmlParser = context.getResources().getXml(R.xml.url);
            int eventType = xmlParser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (xmlParser.getName().equals("node")) {
                            String c = xmlParser.nextText();
                        }
                        break;

                }
                eventType = xmlParser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
