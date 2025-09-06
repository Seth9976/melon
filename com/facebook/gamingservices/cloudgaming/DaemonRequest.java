package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import android.content.Intent;
import com.facebook.FacebookRequestError;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.json.JSONException;
import org.json.JSONObject;

public class DaemonRequest {
    public interface Callback {
        void onCompleted(GraphResponse arg1);
    }

    private Callback mCallback;
    private Context mContext;
    private SDKLogger mLogger;
    private JSONObject mParameters;
    private ConcurrentHashMap mRequestStore;

    public DaemonRequest(Context context0, JSONObject jSONObject0, Callback daemonRequest$Callback0) {
        this.mContext = context0;
        this.mParameters = jSONObject0;
        this.mCallback = daemonRequest$Callback0;
        this.mRequestStore = DaemonReceiver.getInstance(context0).getRequestStore();
        this.mLogger = SDKLogger.getInstance(context0);
    }

    private CompletableFuture createRequest() {
        return CompletableFuture.supplyAsync(new Supplier() {
            public GraphResponse get() {
                try {
                    DaemonRequest.this.mParameters.put("requestID", "a4084b10-5661-4260-b48a-6933487f7ee4");
                    Intent intent0 = new Intent();
                    String s = DaemonRequest.this.mParameters.getString("type");
                    DaemonRequest.this.mLogger.logPreparingRequest(s, "a4084b10-5661-4260-b48a-6933487f7ee4", DaemonRequest.this.mParameters);
                    if(!s.equals("getAccessToken") && !s.equals("isEnvReady")) {
                        String s1 = DaemonRequest.this.mContext.getSharedPreferences("com.facebook.gamingservices.cloudgaming:preferences", 0).getString("daemonPackageName", null);
                        if(s1 == null) {
                            return DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request with a secure connection"), "a4084b10-5661-4260-b48a-6933487f7ee4");
                        }
                        intent0.setPackage(s1);
                    }
                    intent0.setAction("com.facebook.gamingservices.DAEMON_REQUEST");
                    Iterator iterator0 = DaemonRequest.this.mParameters.keys();
                    while(iterator0.hasNext()) {
                        Object object0 = iterator0.next();
                        intent0.putExtra(((String)object0), DaemonRequest.this.mParameters.getString(((String)object0)));
                    }
                    CompletableFuture completableFuture0 = new CompletableFuture();
                    DaemonRequest.this.mRequestStore.put("a4084b10-5661-4260-b48a-6933487f7ee4", completableFuture0);
                    DaemonRequest.this.mContext.sendBroadcast(intent0);
                    DaemonRequest.this.mLogger.logSentRequest(s, "a4084b10-5661-4260-b48a-6933487f7ee4", DaemonRequest.this.mParameters);
                    return (GraphResponse)completableFuture0.get();
                }
                catch(JSONException | InterruptedException | ExecutionException unused_ex) {
                    return DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), "a4084b10-5661-4260-b48a-6933487f7ee4");
                }
            }

            @Override
            public Object get() {
                return this.get();
            }
        });
    }

    private GraphResponse executeAndWait() {
        return (GraphResponse)this.createRequest().get();
    }

    private GraphResponse executeAndWait(int v) {
        return (GraphResponse)this.createRequest().get(((long)v), TimeUnit.SECONDS);
    }

    public static GraphResponse executeAndWait(Context context0, JSONObject jSONObject0, SDKMessageEnum sDKMessageEnum0) {
        try {
            return new DaemonRequest(context0, (jSONObject0 == null ? new JSONObject().put("type", sDKMessageEnum0.toString()) : jSONObject0.put("type", sDKMessageEnum0.toString())), null).executeAndWait();
        }
        catch(JSONException | ExecutionException | InterruptedException unused_ex) {
            return DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), null);
        }
    }

    public static GraphResponse executeAndWait(Context context0, JSONObject jSONObject0, SDKMessageEnum sDKMessageEnum0, int v) {
        try {
            return new DaemonRequest(context0, (jSONObject0 == null ? new JSONObject().put("type", sDKMessageEnum0.toString()) : jSONObject0.put("type", sDKMessageEnum0.toString())), null).executeAndWait(v);
        }
        catch(JSONException | ExecutionException | InterruptedException | TimeoutException unused_ex) {
            return DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), null);
        }
    }

    private void executeAsync() {
        this.createRequest().thenAccept(new Consumer() {
            public void accept(GraphResponse graphResponse0) {
                if(DaemonRequest.this.mCallback != null) {
                    DaemonRequest.this.mCallback.onCompleted(graphResponse0);
                }
            }

            @Override
            public void accept(Object object0) {
                this.accept(((GraphResponse)object0));
            }
        });
    }

    public static void executeAsync(Context context0, JSONObject jSONObject0, Callback daemonRequest$Callback0, SDKMessageEnum sDKMessageEnum0) {
        try {
            new DaemonRequest(context0, (jSONObject0 == null ? new JSONObject().put("type", sDKMessageEnum0.toString()) : jSONObject0.put("type", sDKMessageEnum0.toString())), daemonRequest$Callback0).executeAsync();
        }
        catch(JSONException | ExecutionException | InterruptedException unused_ex) {
            if(daemonRequest$Callback0 != null) {
                daemonRequest$Callback0.onCompleted(DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), null));
            }
        }
    }

    public static void executeAsync(Context context0, JSONObject jSONObject0, Callback daemonRequest$Callback0, String s) {
        try {
            new DaemonRequest(context0, (jSONObject0 == null ? new JSONObject().put("type", s) : jSONObject0.put("type", s)), daemonRequest$Callback0).executeAsync();
        }
        catch(JSONException | ExecutionException | InterruptedException unused_ex) {
            if(daemonRequest$Callback0 != null) {
                daemonRequest$Callback0.onCompleted(DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), null));
            }
        }
    }
}

