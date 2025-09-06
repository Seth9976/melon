package com.facebook.gamingservices.cloudgaming;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class DaemonReceiver {
    static class DaemonBroadcastReceiver extends BroadcastReceiver {
        private DaemonBroadcastReceiver() {
        }

        public DaemonBroadcastReceiver(com.facebook.gamingservices.cloudgaming.DaemonReceiver.1 daemonReceiver$10) {
        }

        @Override  // android.content.BroadcastReceiver
        public void onReceive(Context context0, Intent intent0) {
            try {
                JSONObject jSONObject0 = new JSONObject(intent0.getStringExtra("returnPayload"));
                String s = jSONObject0.getString("requestID");
                if(DaemonReceiver.requestStore.containsKey(s)) {
                    CompletableFuture completableFuture0 = (CompletableFuture)DaemonReceiver.requestStore.remove(s);
                    if(completableFuture0 != null) {
                        completableFuture0.complete(DaemonReceiver.processResponse(jSONObject0, s));
                    }
                }
            }
            catch(JSONException unused_ex) {
            }
        }
    }

    private static SDKLogger mLogger;
    private static ConcurrentHashMap requestStore;
    private static DaemonReceiver single_instance;

    private DaemonReceiver(Context context0) {
        IntentFilter intentFilter0 = new IntentFilter("com.facebook.gamingservices.DAEMON_RESPONSE");
        HandlerThread handlerThread0 = new HandlerThread("com.facebook.gamingservices.DAEMON_RESPONSE_HANDLER");
        handlerThread0.start();
        context0.registerReceiver(new DaemonBroadcastReceiver(null), intentFilter0, null, new Handler(handlerThread0.getLooper()));
        DaemonReceiver.requestStore = new ConcurrentHashMap();
        DaemonReceiver.mLogger = SDKLogger.getInstance(context0);
    }

    private static GraphResponse createDefaultErrorResponse(String s) {
        return DaemonReceiver.createErrorResponse(new FacebookRequestError(20, "UNSUPPORTED_FORMAT", "The response format is invalid."), s);
    }

    public static GraphResponse createErrorResponse(FacebookRequestError facebookRequestError0, String s) {
        DaemonReceiver.mLogger.logSendingErrorResponse(facebookRequestError0, s);
        return new GraphResponse(new GraphRequest(), null, facebookRequestError0);
    }

    private static GraphResponse createErrorResponse(JSONObject jSONObject0, String s) {
        JSONObject jSONObject1 = jSONObject0.optJSONObject("error");
        return jSONObject1 == null ? DaemonReceiver.createDefaultErrorResponse(s) : DaemonReceiver.createErrorResponse(new FacebookRequestError(jSONObject1.optInt("code"), jSONObject1.optString("type"), jSONObject1.optString("message")), s);
    }

    private static GraphResponse createSuccessResponse(JSONObject jSONObject0, String s) {
        if(jSONObject0.optJSONObject("success") != null) {
            DaemonReceiver.mLogger.logSendingSuccessResponse(s);
            return new GraphResponse(new GraphRequest(), null, "", jSONObject0.optJSONObject("success"));
        }
        if(jSONObject0.optJSONArray("success") != null) {
            DaemonReceiver.mLogger.logSendingSuccessResponse(s);
            return new GraphResponse(new GraphRequest(), null, "", jSONObject0.optJSONArray("success"));
        }
        return DaemonReceiver.createDefaultErrorResponse(s);
    }

    public static DaemonReceiver getInstance(Context context0) {
        synchronized(DaemonReceiver.class) {
            if(DaemonReceiver.single_instance == null) {
                DaemonReceiver.single_instance = new DaemonReceiver(context0);
            }
            return DaemonReceiver.single_instance;
        }
    }

    public ConcurrentHashMap getRequestStore() {
        synchronized(this) {
        }
        return DaemonReceiver.requestStore;
    }

    private static GraphResponse processResponse(JSONObject jSONObject0, String s) {
        if(!jSONObject0.isNull("success")) {
            return DaemonReceiver.createSuccessResponse(jSONObject0, s);
        }
        return jSONObject0.isNull("error") ? DaemonReceiver.createDefaultErrorResponse(s) : DaemonReceiver.createErrorResponse(jSONObject0, s);
    }

    class com.facebook.gamingservices.cloudgaming.DaemonReceiver.1 {
    }

}

