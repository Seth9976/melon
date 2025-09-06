package com.google.android.exoplayer2.util;

import android.net.Uri.Builder;
import android.net.Uri;
import android.text.TextUtils;

public final class UriUtil {
    private static final int FRAGMENT = 3;
    private static final int INDEX_COUNT = 4;
    private static final int PATH = 1;
    private static final int QUERY = 2;
    private static final int SCHEME_COLON;

    private static int[] getUriIndices(String s) {
        int v5;
        int[] arr_v = new int[4];
        if(TextUtils.isEmpty(s)) {
            arr_v[0] = -1;
            return arr_v;
        }
        int v = s.length();
        int v1 = s.indexOf(35);
        if(v1 != -1) {
            v = v1;
        }
        int v2 = s.indexOf(0x3F);
        v2 = v2 != -1 && v2 <= v ? s.indexOf(0x3F) : v;
        int v3 = s.indexOf(0x2F);
        int v4 = s.indexOf(58) <= (v3 != -1 && v3 <= v2 ? s.indexOf(0x2F) : v2) ? s.indexOf(58) : -1;
        if(v4 + 2 >= v2 || s.charAt(v4 + 1) != 0x2F || s.charAt(v4 + 2) != 0x2F) {
            v5 = v4 + 1;
        }
        else {
            v5 = s.indexOf(0x2F, v4 + 3);
            if(v5 == -1 || v5 > v2) {
                v5 = v2;
            }
        }
        arr_v[0] = v4;
        arr_v[1] = v5;
        arr_v[2] = v2;
        arr_v[3] = v;
        return arr_v;
    }

    private static String removeDotSegments(StringBuilder stringBuilder0, int v, int v1) {
        int v5;
        int v4;
        if(v >= v1) {
            return stringBuilder0.toString();
        }
        if(stringBuilder0.charAt(v) == 0x2F) {
            ++v;
        }
        int v2 = v;
        int v3 = v2;
        while(v2 <= v1) {
            if(v2 == v1) {
                v4 = v2;
            }
            else if(stringBuilder0.charAt(v2) == 0x2F) {
                v4 = v2 + 1;
            }
            else {
                goto label_26;
            }
            if(v2 != v3 + 1 || stringBuilder0.charAt(v3) != 46) {
                if(v2 != v3 + 2 || stringBuilder0.charAt(v3) != 46 || stringBuilder0.charAt(v3 + 1) != 46) {
                    v5 = v2 + 1;
                }
                else {
                    v5 = stringBuilder0.lastIndexOf("/", v3 - 2) + 1;
                    int v6 = v5 <= v ? v : v5;
                    stringBuilder0.delete(v6, v4);
                    v1 -= v4 - v6;
                }
                v3 = v5;
            }
            else {
                stringBuilder0.delete(v3, v4);
                v1 -= v4 - v3;
            }
            v2 = v3;
            continue;
        label_26:
            ++v2;
        }
        return stringBuilder0.toString();
    }

    public static Uri removeQueryParameter(Uri uri0, String s) {
        Uri.Builder uri$Builder0 = uri0.buildUpon();
        uri$Builder0.clearQuery();
        for(Object object0: uri0.getQueryParameterNames()) {
            String s1 = (String)object0;
            if(!s1.equals(s)) {
                for(Object object1: uri0.getQueryParameters(s1)) {
                    uri$Builder0.appendQueryParameter(s1, ((String)object1));
                }
            }
        }
        return uri$Builder0.build();
    }

    public static String resolve(String s, String s1) {
        StringBuilder stringBuilder0 = new StringBuilder();
        if(s == null) {
            s = "";
        }
        if(s1 == null) {
            s1 = "";
        }
        int[] arr_v = UriUtil.getUriIndices(s1);
        if(arr_v[0] != -1) {
            stringBuilder0.append(s1);
            UriUtil.removeDotSegments(stringBuilder0, arr_v[1], arr_v[2]);
            return stringBuilder0.toString();
        }
        int[] arr_v1 = UriUtil.getUriIndices(s);
        if(arr_v[3] == 0) {
            stringBuilder0.append(s, 0, arr_v1[3]);
            stringBuilder0.append(s1);
            return stringBuilder0.toString();
        }
        if(arr_v[2] == 0) {
            stringBuilder0.append(s, 0, arr_v1[2]);
            stringBuilder0.append(s1);
            return stringBuilder0.toString();
        }
        if(arr_v[1] != 0) {
            int v = arr_v1[0] + 1;
            stringBuilder0.append(s, 0, v);
            stringBuilder0.append(s1);
            return UriUtil.removeDotSegments(stringBuilder0, arr_v[1] + v, v + arr_v[2]);
        }
        if(s1.charAt(0) == 0x2F) {
            stringBuilder0.append(s, 0, arr_v1[1]);
            stringBuilder0.append(s1);
            int v1 = arr_v1[1];
            return UriUtil.removeDotSegments(stringBuilder0, v1, arr_v[2] + v1);
        }
        int v2 = arr_v1[0] + 2;
        int v3 = arr_v1[1];
        if(v2 < v3 && v3 == arr_v1[2]) {
            stringBuilder0.append(s, 0, v3);
            stringBuilder0.append('/');
            stringBuilder0.append(s1);
            int v4 = arr_v1[1];
            return UriUtil.removeDotSegments(stringBuilder0, v4, arr_v[2] + v4 + 1);
        }
        int v5 = s.lastIndexOf(0x2F, arr_v1[2] - 1);
        int v6 = v5 == -1 ? arr_v1[1] : v5 + 1;
        stringBuilder0.append(s, 0, v6);
        stringBuilder0.append(s1);
        return UriUtil.removeDotSegments(stringBuilder0, arr_v1[1], v6 + arr_v[2]);
    }

    public static Uri resolveToUri(String s, String s1) {
        return Uri.parse(UriUtil.resolve(s, s1));
    }
}

