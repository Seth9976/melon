package com.iloen.melon.utils;

import android.text.TextUtils;
import com.iloen.melon.types.BasicNameValuePair;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ContentValuesEncodedUtils {
    public static String format(NameValuePairList nameValuePairList0, String s) {
        String s5;
        String s4;
        StringBuilder stringBuilder0 = new StringBuilder();
        for(Object object0: nameValuePairList0) {
            String s1 = ((BasicNameValuePair)object0).b;
            if(stringBuilder0.length() > 0) {
                stringBuilder0.append("&");
            }
            String s2 = ((BasicNameValuePair)object0).a;
            String s3 = "ISO-8859-1";
            try {
                s4 = URLEncoder.encode(s2, (s == null ? "ISO-8859-1" : s));
            }
            catch(UnsupportedEncodingException unsupportedEncodingException0) {
                throw new IllegalArgumentException(unsupportedEncodingException0);
            }
            stringBuilder0.append(s4);
            stringBuilder0.append("=");
            if(TextUtils.isEmpty(s1)) {
                s5 = "";
            }
            else {
                if(s != null) {
                    s3 = s;
                }
                try {
                    s5 = URLEncoder.encode(s1, s3);
                }
                catch(UnsupportedEncodingException unsupportedEncodingException1) {
                    throw new IllegalArgumentException(unsupportedEncodingException1);
                }
            }
            stringBuilder0.append(s5);
        }
        return stringBuilder0.toString();
    }
}

