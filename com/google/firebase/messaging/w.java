package com.google.firebase.messaging;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public final class w {
    public final String a;
    public final String b;
    public final long c;
    public static final long d;

    static {
        w.d = TimeUnit.DAYS.toMillis(7L);
    }

    public w(String s, String s1, long v) {
        this.a = s;
        this.b = s1;
        this.c = v;
    }

    public static String a(long v, String s, String s1) {
        try {
            JSONObject jSONObject0 = new JSONObject();
            jSONObject0.put("token", s);
            jSONObject0.put("appVersion", s1);
            jSONObject0.put("timestamp", v);
            return jSONObject0.toString();
        }
        catch(JSONException jSONException0) {
            Log.w("FirebaseMessaging", "Failed to encode token: " + jSONException0);
            return null;
        }
    }

    public static w b(String s) {
        if(TextUtils.isEmpty(s)) {
            return null;
        }
        if(s.startsWith("{")) {
            try {
                JSONObject jSONObject0 = new JSONObject(s);
                return new w(jSONObject0.getString("token"), jSONObject0.getString("appVersion"), jSONObject0.getLong("timestamp"));
            }
            catch(JSONException jSONException0) {
                Log.w("FirebaseMessaging", "Failed to parse token: " + jSONException0);
                return null;
            }
        }
        return new w(s, null, 0L);
    }
}

