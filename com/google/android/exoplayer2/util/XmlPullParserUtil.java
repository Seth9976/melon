package com.google.android.exoplayer2.util;

import org.xmlpull.v1.XmlPullParser;

public final class XmlPullParserUtil {
    public static String getAttributeValue(XmlPullParser xmlPullParser0, String s) {
        int v = xmlPullParser0.getAttributeCount();
        for(int v1 = 0; v1 < v; ++v1) {
            if(xmlPullParser0.getAttributeName(v1).equals(s)) {
                return xmlPullParser0.getAttributeValue(v1);
            }
        }
        return null;
    }

    public static String getAttributeValueIgnorePrefix(XmlPullParser xmlPullParser0, String s) {
        int v = xmlPullParser0.getAttributeCount();
        for(int v1 = 0; v1 < v; ++v1) {
            if(XmlPullParserUtil.stripPrefix(xmlPullParser0.getAttributeName(v1)).equals(s)) {
                return xmlPullParser0.getAttributeValue(v1);
            }
        }
        return null;
    }

    public static boolean isEndTag(XmlPullParser xmlPullParser0) {
        return xmlPullParser0.getEventType() == 3;
    }

    // 去混淆评级： 低(20)
    public static boolean isEndTag(XmlPullParser xmlPullParser0, String s) {
        return XmlPullParserUtil.isEndTag(xmlPullParser0) && xmlPullParser0.getName().equals(s);
    }

    public static boolean isStartTag(XmlPullParser xmlPullParser0) {
        return xmlPullParser0.getEventType() == 2;
    }

    // 去混淆评级： 低(20)
    public static boolean isStartTag(XmlPullParser xmlPullParser0, String s) {
        return XmlPullParserUtil.isStartTag(xmlPullParser0) && xmlPullParser0.getName().equals(s);
    }

    // 去混淆评级： 低(20)
    public static boolean isStartTagIgnorePrefix(XmlPullParser xmlPullParser0, String s) {
        return XmlPullParserUtil.isStartTag(xmlPullParser0) && XmlPullParserUtil.stripPrefix(xmlPullParser0.getName()).equals(s);
    }

    private static String stripPrefix(String s) {
        int v = s.indexOf(58);
        return v == -1 ? s : s.substring(v + 1);
    }
}

