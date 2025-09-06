package com.facebook.gamingservices;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class GamingPayload {
    private static final String KEY_APPLINK_DATA = "al_applink_data";
    private static final String KEY_CONTEXT_TOKEN_ID = "context_token_id";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_GAME_REQUEST_ID = "game_request_id";
    private static final String KEY_PAYLOAD = "payload";
    private static final String KEY_TOURNAMENT_ID = "tournament_id";
    private static final String TAG = "GamingPayload";
    private static Map payloadData;

    public static String getGameRequestID() {
        Map map0 = GamingPayload.payloadData;
        if(map0 == null) {
            return null;
        }
        return map0.containsKey("game_request_id") ? ((String)GamingPayload.payloadData.get("game_request_id")) : null;
    }

    public static String getPayload() {
        Map map0 = GamingPayload.payloadData;
        if(map0 == null) {
            return null;
        }
        return map0.containsKey("payload") ? ((String)GamingPayload.payloadData.get("payload")) : null;
    }

    public static String getTournamentId() {
        Map map0 = GamingPayload.payloadData;
        if(map0 == null) {
            return null;
        }
        return map0.containsKey("tournament_id") ? ((String)GamingPayload.payloadData.get("tournament_id")) : null;
    }

    public static void loadPayloadFromCloudGame(String s) {
        HashMap hashMap0 = new HashMap();
        try {
            JSONObject jSONObject0 = new JSONObject(s);
            hashMap0.put("game_request_id", jSONObject0.optString("game_request_id"));
            hashMap0.put("payload", jSONObject0.optString("payload"));
            hashMap0.put("tournament_id", jSONObject0.optString("tournament_id"));
            GamingPayload.payloadData = hashMap0;
        }
        catch(JSONException jSONException0) {
            Log.e("GamingPayload", jSONException0.toString(), jSONException0);
        }
    }

    public static void loadPayloadFromIntent(Intent intent0) {
        HashMap hashMap0 = new HashMap();
        if(intent0 != null) {
            Bundle bundle0 = intent0.getExtras();
            if(bundle0 != null && bundle0.containsKey("al_applink_data")) {
                Bundle bundle1 = bundle0.getBundle("al_applink_data").getBundle("extras");
                if(bundle1 != null) {
                    String s = bundle1.getString("game_request_id");
                    String s1 = bundle1.getString("payload");
                    String s2 = bundle1.getString("context_token_id");
                    String s3 = bundle1.getString("tournament_id");
                    if(s2 != null) {
                        GamingContext.setCurrentGamingContext(new GamingContext(s2));
                    }
                    hashMap0.put("game_request_id", s);
                    hashMap0.put("payload", s1);
                    hashMap0.put("tournament_id", s3);
                    GamingPayload.payloadData = hashMap0;
                }
            }
        }
    }
}

