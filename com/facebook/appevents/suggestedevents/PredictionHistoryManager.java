package com.facebook.appevents.suggestedevents;

import android.content.SharedPreferences;
import android.view.View;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import je.C;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u001F\u0010\t\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000E\u001A\u0004\u0018\u00010\u00062\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\u000E\u0010\u000FJ\u0019\u0010\u0010\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\u0011R \u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001A\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001A\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0019\u001A\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001C\u001A\u00020\u001B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001C\u0010\u001D¨\u0006\u001E"}, d2 = {"Lcom/facebook/appevents/suggestedevents/PredictionHistoryManager;", "", "<init>", "()V", "Lie/H;", "initAndWait", "", "pathID", "predictedEvent", "addPrediction", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/view/View;", "view", "text", "getPathID", "(Landroid/view/View;Ljava/lang/String;)Ljava/lang/String;", "queryEvent", "(Ljava/lang/String;)Ljava/lang/String;", "", "clickedViewPaths", "Ljava/util/Map;", "SUGGESTED_EVENTS_HISTORY", "Ljava/lang/String;", "CLICKED_PATH_STORE", "Landroid/content/SharedPreferences;", "shardPreferences", "Landroid/content/SharedPreferences;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class PredictionHistoryManager {
    @NotNull
    private static final String CLICKED_PATH_STORE = "com.facebook.internal.SUGGESTED_EVENTS_HISTORY";
    @NotNull
    public static final PredictionHistoryManager INSTANCE = null;
    @NotNull
    private static final String SUGGESTED_EVENTS_HISTORY = "SUGGESTED_EVENTS_HISTORY";
    @NotNull
    private static final Map clickedViewPaths;
    @NotNull
    private static final AtomicBoolean initialized;
    private static SharedPreferences shardPreferences;

    static {
        PredictionHistoryManager.INSTANCE = new PredictionHistoryManager();
        PredictionHistoryManager.clickedViewPaths = new LinkedHashMap();
        PredictionHistoryManager.initialized = new AtomicBoolean(false);
    }

    public static final void addPrediction(@NotNull String s, @NotNull String s1) {
        Class class0 = PredictionHistoryManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(s, "pathID");
            q.g(s1, "predictedEvent");
            if(!PredictionHistoryManager.initialized.get()) {
                PredictionHistoryManager.INSTANCE.initAndWait();
            }
            Map map0 = PredictionHistoryManager.clickedViewPaths;
            map0.put(s, s1);
            SharedPreferences sharedPreferences0 = PredictionHistoryManager.shardPreferences;
            if(sharedPreferences0 != null) {
                sharedPreferences0.edit().putString("SUGGESTED_EVENTS_HISTORY", Utility.mapToJsonStr(C.Z(map0))).apply();
                return;
            }
            q.m("shardPreferences");
            throw null;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    @Nullable
    public static final String getPathID(@NotNull View view0, @NotNull String s) {
        Class class0 = PredictionHistoryManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(view0, "view");
            q.g(s, "text");
            JSONObject jSONObject0 = new JSONObject();
            try {
                jSONObject0.put("text", s);
                JSONArray jSONArray0 = new JSONArray();
                while(view0 != null) {
                    jSONArray0.put(view0.getClass().getSimpleName());
                    view0 = ViewHierarchy.getParentOfView(view0);
                }
                jSONObject0.put("classname", jSONArray0);
            }
            catch(JSONException unused_ex) {
            }
            return Utility.sha256hash(jSONObject0.toString());
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    private final void initAndWait() {
        String s = "";
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                AtomicBoolean atomicBoolean0 = PredictionHistoryManager.initialized;
                if(!atomicBoolean0.get()) {
                    SharedPreferences sharedPreferences0 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.SUGGESTED_EVENTS_HISTORY", 0);
                    q.f(sharedPreferences0, "getApplicationContext()\n…RE, Context.MODE_PRIVATE)");
                    PredictionHistoryManager.shardPreferences = sharedPreferences0;
                    Map map0 = PredictionHistoryManager.clickedViewPaths;
                    String s1 = sharedPreferences0.getString("SUGGESTED_EVENTS_HISTORY", "");
                    if(s1 != null) {
                        s = s1;
                    }
                    map0.putAll(Utility.jsonStrToMap(s));
                    atomicBoolean0.set(true);
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    @Nullable
    public static final String queryEvent(@NotNull String s) {
        Class class0 = PredictionHistoryManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(s, "pathID");
            return PredictionHistoryManager.clickedViewPaths.containsKey(s) ? ((String)PredictionHistoryManager.clickedViewPaths.get(s)) : null;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }
}

