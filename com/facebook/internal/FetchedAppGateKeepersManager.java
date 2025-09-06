package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.c;
import com.facebook.appevents.ondeviceprocessing.a;
import com.facebook.internal.gatekeeper.GateKeeper;
import com.facebook.internal.gatekeeper.GateKeeperRuntimeCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00C7\u0002\u0018\u00002\u00020\u0001:\u0001AB\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\t\u0010\u0003J\u001F\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0007\u00A2\u0006\u0004\b\u000F\u0010\u0010J)\u0010\u0013\u001A\u00020\f2\u0006\u0010\u0011\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001A\u00020\fH\u0007\u00A2\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001A\u00020\u00062\b\b\u0002\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0016\u001A\u00020\u0015H\u0007\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u0019\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\u0019\u0010\u0003J\u0017\u0010\u001A\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\u001A\u0010\u001BJ!\u0010\u001F\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\n2\b\u0010\u001C\u001A\u0004\u0018\u00010\u000EH\u0001\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0019\u0010\"\u001A\u00020\f2\b\u0010!\u001A\u0004\u0018\u00010 H\u0002\u00A2\u0006\u0004\b\"\u0010#J\r\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\u0007\u0010\u0003J#\u0010%\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0$2\b\u0010\u000B\u001A\u0004\u0018\u00010\n\u00A2\u0006\u0004\b%\u0010&R\u0016\u0010\'\u001A\u0004\u0018\u00010\n8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\'\u0010(R\u0014\u0010)\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010*\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010+\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b+\u0010(R\u0014\u0010,\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b,\u0010(R\u0014\u0010-\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b-\u0010(R\u0014\u0010.\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b.\u0010(R\u0014\u0010/\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b/\u0010(R\u0014\u00100\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b0\u0010(R\u0014\u00101\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b1\u0010(R\u0014\u00103\u001A\u0002028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b3\u00104R\u001A\u00106\u001A\b\u0012\u0004\u0012\u00020\u0004058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b6\u00107R \u00109\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000E088\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010;\u001A\u00020 8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010!\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b!\u0010=R\u0018\u0010?\u001A\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b?\u0010@\u00A8\u0006B"}, d2 = {"Lcom/facebook/internal/FetchedAppGateKeepersManager;", "", "<init>", "()V", "Lcom/facebook/internal/FetchedAppGateKeepersManager$Callback;", "callback", "Lie/H;", "loadAppGateKeepersAsync", "(Lcom/facebook/internal/FetchedAppGateKeepersManager$Callback;)V", "pollCallbacks", "", "applicationId", "", "forceRequery", "Lorg/json/JSONObject;", "queryAppGateKeepers", "(Ljava/lang/String;Z)Lorg/json/JSONObject;", "name", "defaultValue", "getGateKeeperForKey", "(Ljava/lang/String;Ljava/lang/String;Z)Z", "Lcom/facebook/internal/gatekeeper/GateKeeper;", "gateKeeper", "setRuntimeGateKeeper", "(Ljava/lang/String;Lcom/facebook/internal/gatekeeper/GateKeeper;)V", "resetRuntimeGateKeeperCache", "getAppGateKeepersQueryResponse", "(Ljava/lang/String;)Lorg/json/JSONObject;", "gateKeepersJSON", "parseAppGateKeepersFromJSON$facebook_core_release", "(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;", "parseAppGateKeepersFromJSON", "", "timestamp", "isTimestampValid", "(Ljava/lang/Long;)Z", "", "getGateKeepersForApplication", "(Ljava/lang/String;)Ljava/util/Map;", "TAG", "Ljava/lang/String;", "APP_GATEKEEPERS_PREFS_STORE", "APP_GATEKEEPERS_PREFS_KEY_FORMAT", "APP_PLATFORM", "APPLICATION_GATEKEEPER_EDGE", "APPLICATION_GATEKEEPER_FIELD", "APPLICATION_GRAPH_DATA", "APPLICATION_FIELDS", "APPLICATION_PLATFORM", "APPLICATION_SDK_VERSION", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isLoading", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "callbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "", "fetchedAppGateKeepers", "Ljava/util/Map;", "APPLICATION_GATEKEEPER_CACHE_TIMEOUT", "J", "Ljava/lang/Long;", "Lcom/facebook/internal/gatekeeper/GateKeeperRuntimeCache;", "gateKeeperRuntimeCache", "Lcom/facebook/internal/gatekeeper/GateKeeperRuntimeCache;", "Callback", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FetchedAppGateKeepersManager {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/internal/FetchedAppGateKeepersManager$Callback;", "", "Lie/H;", "onCompleted", "()V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface Callback {
        void onCompleted();
    }

    @NotNull
    private static final String APPLICATION_FIELDS = "fields";
    private static final long APPLICATION_GATEKEEPER_CACHE_TIMEOUT = 3600000L;
    @NotNull
    private static final String APPLICATION_GATEKEEPER_EDGE = "mobile_sdk_gk";
    @NotNull
    private static final String APPLICATION_GATEKEEPER_FIELD = "gatekeepers";
    @NotNull
    private static final String APPLICATION_GRAPH_DATA = "data";
    @NotNull
    private static final String APPLICATION_PLATFORM = "platform";
    @NotNull
    private static final String APPLICATION_SDK_VERSION = "sdk_version";
    @NotNull
    private static final String APP_GATEKEEPERS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_GATEKEEPERS.%s";
    @NotNull
    private static final String APP_GATEKEEPERS_PREFS_STORE = "com.facebook.internal.preferences.APP_GATEKEEPERS";
    @NotNull
    private static final String APP_PLATFORM = "android";
    @NotNull
    public static final FetchedAppGateKeepersManager INSTANCE;
    @Nullable
    private static final String TAG;
    @NotNull
    private static final ConcurrentLinkedQueue callbacks;
    @NotNull
    private static final Map fetchedAppGateKeepers;
    @Nullable
    private static GateKeeperRuntimeCache gateKeeperRuntimeCache;
    @NotNull
    private static final AtomicBoolean isLoading;
    @Nullable
    private static Long timestamp;

    static {
        FetchedAppGateKeepersManager.INSTANCE = new FetchedAppGateKeepersManager();
        FetchedAppGateKeepersManager.TAG = I.a.b(FetchedAppGateKeepersManager.class).m();
        FetchedAppGateKeepersManager.isLoading = new AtomicBoolean(false);
        FetchedAppGateKeepersManager.callbacks = new ConcurrentLinkedQueue();
        FetchedAppGateKeepersManager.fetchedAppGateKeepers = new ConcurrentHashMap();
    }

    public static void a(Context context0, String s, String s1) {
        FetchedAppGateKeepersManager.loadAppGateKeepersAsync$lambda$0(s, context0, s1);
    }

    public static void b(Callback fetchedAppGateKeepersManager$Callback0) {
        FetchedAppGateKeepersManager.pollCallbacks$lambda$1(fetchedAppGateKeepersManager$Callback0);
    }

    private final JSONObject getAppGateKeepersQueryResponse(String s) {
        Bundle bundle0 = Y.b("platform", "android");
        bundle0.putString("sdk_version", "18.1.3");
        bundle0.putString("fields", "gatekeepers");
        GraphRequest graphRequest0 = GraphRequest.Companion.newGraphPathRequest(null, "app/mobile_sdk_gk", null);
        graphRequest0.setParameters(bundle0);
        JSONObject jSONObject0 = graphRequest0.executeAndWait().getJsonObject();
        return jSONObject0 == null ? new JSONObject() : jSONObject0;
    }

    public static final boolean getGateKeeperForKey(@NotNull String s, @Nullable String s1, boolean z) {
        q.g(s, "name");
        Map map0 = FetchedAppGateKeepersManager.INSTANCE.getGateKeepersForApplication(s1);
        if(map0.containsKey(s)) {
            Boolean boolean0 = (Boolean)map0.get(s);
            return boolean0 == null ? z : boolean0.booleanValue();
        }
        return z;
    }

    @NotNull
    public final Map getGateKeepersForApplication(@Nullable String s) {
        this.loadAppGateKeepersAsync();
        if(s != null) {
            Map map0 = FetchedAppGateKeepersManager.fetchedAppGateKeepers;
            if(map0.containsKey(s)) {
                List list0 = FetchedAppGateKeepersManager.gateKeeperRuntimeCache == null ? null : FetchedAppGateKeepersManager.gateKeeperRuntimeCache.dumpGateKeepers(s);
                if(list0 != null) {
                    Map map1 = new HashMap();
                    for(Object object0: list0) {
                        map1.put(((GateKeeper)object0).getName(), Boolean.valueOf(((GateKeeper)object0).getValue()));
                    }
                    return map1;
                }
                Map map2 = new HashMap();
                JSONObject jSONObject0 = (JSONObject)map0.get(s);
                if(jSONObject0 == null) {
                    jSONObject0 = new JSONObject();
                }
                Iterator iterator1 = jSONObject0.keys();
                while(iterator1.hasNext()) {
                    Object object1 = iterator1.next();
                    q.f(((String)object1), "key");
                    map2.put(((String)object1), Boolean.valueOf(jSONObject0.optBoolean(((String)object1))));
                }
                GateKeeperRuntimeCache gateKeeperRuntimeCache0 = FetchedAppGateKeepersManager.gateKeeperRuntimeCache == null ? new GateKeeperRuntimeCache() : FetchedAppGateKeepersManager.gateKeeperRuntimeCache;
                ArrayList arrayList0 = new ArrayList(map2.size());
                for(Object object2: map2.entrySet()) {
                    arrayList0.add(new GateKeeper(((String)((Map.Entry)object2).getKey()), ((Boolean)((Map.Entry)object2).getValue()).booleanValue()));
                }
                gateKeeperRuntimeCache0.setGateKeepers(s, arrayList0);
                FetchedAppGateKeepersManager.gateKeeperRuntimeCache = gateKeeperRuntimeCache0;
                return map2;
            }
        }
        return new HashMap();
    }

    private final boolean isTimestampValid(Long long0) [...] // 潜在的解密器

    public static final void loadAppGateKeepersAsync(@Nullable Callback fetchedAppGateKeepersManager$Callback0) {
        synchronized(FetchedAppGateKeepersManager.class) {
            if(fetchedAppGateKeepersManager$Callback0 != null) {
                FetchedAppGateKeepersManager.callbacks.add(fetchedAppGateKeepersManager$Callback0);
            }
            String s = FacebookSdk.getApplicationId();
            Context context0 = FacebookSdk.getApplicationContext();
            String s1 = String.format("com.facebook.internal.APP_GATEKEEPERS.%s", Arrays.copyOf(new Object[]{s}, 1));
            if(context0 == null) {
                return;
            }
            JSONObject jSONObject0 = null;
            String s2 = context0.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).getString(s1, null);
            if(!Utility.isNullOrEmpty(s2)) {
                try {
                    jSONObject0 = new JSONObject(s2);
                }
                catch(JSONException jSONException0) {
                    Utility.logd("FacebookSDK", jSONException0);
                }
                if(jSONObject0 != null) {
                    FetchedAppGateKeepersManager.parseAppGateKeepersFromJSON$facebook_core_release(s, jSONObject0);
                }
            }
            Executor executor0 = FacebookSdk.getExecutor();
            if(executor0 == null) {
                return;
            }
            if(!FetchedAppGateKeepersManager.isLoading.compareAndSet(false, true)) {
                return;
            }
            executor0.execute(new a(context0, s, s1));
        }
    }

    public final void loadAppGateKeepersAsync() {
        FetchedAppGateKeepersManager.loadAppGateKeepersAsync(null);
    }

    private static final void loadAppGateKeepersAsync$lambda$0(String s, Context context0, String s1) {
        q.g(s, "$applicationId");
        q.g(context0, "$context");
        q.g(s1, "$gateKeepersKey");
        FetchedAppGateKeepersManager fetchedAppGateKeepersManager0 = FetchedAppGateKeepersManager.INSTANCE;
        JSONObject jSONObject0 = fetchedAppGateKeepersManager0.getAppGateKeepersQueryResponse(s);
        if(jSONObject0.length() != 0) {
            FetchedAppGateKeepersManager.parseAppGateKeepersFromJSON$facebook_core_release(s, jSONObject0);
            context0.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).edit().putString(s1, jSONObject0.toString()).apply();
            FetchedAppGateKeepersManager.timestamp = System.currentTimeMillis();
        }
        fetchedAppGateKeepersManager0.pollCallbacks();
        FetchedAppGateKeepersManager.isLoading.set(false);
    }

    @NotNull
    public static final JSONObject parseAppGateKeepersFromJSON$facebook_core_release(@NotNull String s, @Nullable JSONObject jSONObject0) {
        JSONObject jSONObject2;
        synchronized(FetchedAppGateKeepersManager.class) {
            q.g(s, "applicationId");
            JSONObject jSONObject1 = (JSONObject)FetchedAppGateKeepersManager.fetchedAppGateKeepers.get(s);
            if(jSONObject1 == null) {
                jSONObject1 = new JSONObject();
            }
            if(jSONObject0 == null) {
                jSONObject2 = null;
            }
            else {
                JSONArray jSONArray0 = jSONObject0.optJSONArray("data");
                jSONObject2 = jSONArray0 == null ? null : jSONArray0.optJSONObject(0);
            }
            if(jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            JSONArray jSONArray1 = jSONObject2.optJSONArray("gatekeepers");
            if(jSONArray1 == null) {
                jSONArray1 = new JSONArray();
            }
            int v2 = jSONArray1.length();
            for(int v1 = 0; v1 < v2; ++v1) {
                try {
                    JSONObject jSONObject3 = jSONArray1.getJSONObject(v1);
                    jSONObject1.put(jSONObject3.getString("key"), jSONObject3.getBoolean("value"));
                }
                catch(JSONException jSONException0) {
                    Utility.logd("FacebookSDK", jSONException0);
                }
            }
            FetchedAppGateKeepersManager.fetchedAppGateKeepers.put(s, jSONObject1);
            return jSONObject1;
        }
    }

    private final void pollCallbacks() {
        Handler handler0 = new Handler(Looper.getMainLooper());
        while(true) {
            ConcurrentLinkedQueue concurrentLinkedQueue0 = FetchedAppGateKeepersManager.callbacks;
            if(concurrentLinkedQueue0.isEmpty()) {
                break;
            }
            Callback fetchedAppGateKeepersManager$Callback0 = (Callback)concurrentLinkedQueue0.poll();
            if(fetchedAppGateKeepersManager$Callback0 != null) {
                handler0.post(new c(fetchedAppGateKeepersManager$Callback0, 6));
            }
        }
    }

    private static final void pollCallbacks$lambda$1(Callback fetchedAppGateKeepersManager$Callback0) {
        fetchedAppGateKeepersManager$Callback0.onCompleted();
    }

    @NotNull
    public static final JSONObject queryAppGateKeepers(@NotNull String s, boolean z) {
        q.g(s, "applicationId");
        if(!z) {
            Map map0 = FetchedAppGateKeepersManager.fetchedAppGateKeepers;
            if(map0.containsKey(s)) {
                JSONObject jSONObject0 = (JSONObject)map0.get(s);
                return jSONObject0 == null ? new JSONObject() : jSONObject0;
            }
        }
        JSONObject jSONObject1 = FetchedAppGateKeepersManager.INSTANCE.getAppGateKeepersQueryResponse(s);
        Context context0 = FacebookSdk.getApplicationContext();
        String s1 = String.format("com.facebook.internal.APP_GATEKEEPERS.%s", Arrays.copyOf(new Object[]{s}, 1));
        context0.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).edit().putString(s1, jSONObject1.toString()).apply();
        return FetchedAppGateKeepersManager.parseAppGateKeepersFromJSON$facebook_core_release(s, jSONObject1);
    }

    public static final void resetRuntimeGateKeeperCache() {
        GateKeeperRuntimeCache gateKeeperRuntimeCache0 = FetchedAppGateKeepersManager.gateKeeperRuntimeCache;
        if(gateKeeperRuntimeCache0 != null) {
            GateKeeperRuntimeCache.resetCache$default(gateKeeperRuntimeCache0, null, 1, null);
        }
    }

    public static final void setRuntimeGateKeeper(@NotNull String s, @NotNull GateKeeper gateKeeper0) {
        q.g(s, "applicationId");
        q.g(gateKeeper0, "gateKeeper");
        if((FetchedAppGateKeepersManager.gateKeeperRuntimeCache == null ? null : FetchedAppGateKeepersManager.gateKeeperRuntimeCache.getGateKeeper(s, gateKeeper0.getName())) != null) {
            GateKeeperRuntimeCache gateKeeperRuntimeCache0 = FetchedAppGateKeepersManager.gateKeeperRuntimeCache;
            if(gateKeeperRuntimeCache0 != null) {
                gateKeeperRuntimeCache0.setGateKeeper(s, gateKeeper0);
            }
            return;
        }
        Log.w(FetchedAppGateKeepersManager.TAG, "Missing gatekeeper runtime cache");
    }

    public static void setRuntimeGateKeeper$default(String s, GateKeeper gateKeeper0, int v, Object object0) {
        if((v & 1) != 0) {
            s = FacebookSdk.getApplicationId();
        }
        FetchedAppGateKeepersManager.setRuntimeGateKeeper(s, gateKeeper0);
    }
}

