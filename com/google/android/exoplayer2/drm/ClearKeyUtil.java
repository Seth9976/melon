package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class ClearKeyUtil {
    private static final String TAG = "ClearKeyUtil";

    public static byte[] adjustRequestData(byte[] arr_b) {
        return Util.SDK_INT < 27 ? Util.getUtf8Bytes(ClearKeyUtil.base64ToBase64Url(Util.fromUtf8Bytes(arr_b))) : arr_b;
    }

    public static byte[] adjustResponseData(byte[] arr_b) {
        if(Util.SDK_INT >= 27) {
            return arr_b;
        }
        try {
            JSONObject jSONObject0 = new JSONObject(Util.fromUtf8Bytes(arr_b));
            StringBuilder stringBuilder0 = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray0 = jSONObject0.getJSONArray("keys");
            for(int v = 0; v < jSONArray0.length(); ++v) {
                if(v != 0) {
                    stringBuilder0.append(",");
                }
                JSONObject jSONObject1 = jSONArray0.getJSONObject(v);
                stringBuilder0.append("{\"k\":\"");
                stringBuilder0.append(ClearKeyUtil.base64UrlToBase64(jSONObject1.getString("k")));
                stringBuilder0.append("\",\"kid\":\"");
                stringBuilder0.append(ClearKeyUtil.base64UrlToBase64(jSONObject1.getString("kid")));
                stringBuilder0.append("\",\"kty\":\"");
                stringBuilder0.append(jSONObject1.getString("kty"));
                stringBuilder0.append("\"}");
            }
            stringBuilder0.append("]}");
            return Util.getUtf8Bytes(stringBuilder0.toString());
        }
        catch(JSONException jSONException0) {
        }
        String s = Util.fromUtf8Bytes(arr_b);
        Log.e("ClearKeyUtil", (s.length() == 0 ? new String("Failed to adjust response data: ") : "Failed to adjust response data: " + s), jSONException0);
        return arr_b;
    }

    private static String base64ToBase64Url(String s) {
        return s.replace('+', '-').replace('/', '_');
    }

    private static String base64UrlToBase64(String s) {
        return s.replace('-', '+').replace('_', '/');
    }
}

