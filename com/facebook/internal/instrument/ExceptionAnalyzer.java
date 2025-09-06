package com.facebook.internal.instrument;

import E5.a;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.internal.FeatureManager.Feature;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0007\u001A\u00020\u0004H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\t\u001A\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\u0003J\u0019\u0010\f\u001A\u00020\b2\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\bH\u0001¢\u0006\u0004\b\u000E\u0010\u0003R\u0016\u0010\u0010\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/facebook/internal/instrument/ExceptionAnalyzer;", "", "<init>", "()V", "", "isDebug$facebook_core_release", "()Z", "isDebug", "Lie/H;", "enable", "", "e", "execute", "(Ljava/lang/Throwable;)V", "sendExceptionAnalysisReports$facebook_core_release", "sendExceptionAnalysisReports", "enabled", "Z", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ExceptionAnalyzer {
    @NotNull
    public static final ExceptionAnalyzer INSTANCE;
    private static boolean enabled;

    static {
        ExceptionAnalyzer.INSTANCE = new ExceptionAnalyzer();
    }

    public static void a(InstrumentData instrumentData0, GraphResponse graphResponse0) {
        ExceptionAnalyzer.sendExceptionAnalysisReports$lambda$1(instrumentData0, graphResponse0);
    }

    public static final void enable() {
        ExceptionAnalyzer.enabled = true;
        if(FacebookSdk.getAutoLogAppEventsEnabled()) {
            ExceptionAnalyzer.INSTANCE.sendExceptionAnalysisReports$facebook_core_release();
        }
    }

    public static final void execute(@Nullable Throwable throwable0) {
        if(ExceptionAnalyzer.enabled && throwable0 != null) {
            HashSet hashSet0 = new HashSet();
            StackTraceElement[] arr_stackTraceElement = throwable0.getStackTrace();
            q.f(arr_stackTraceElement, "e.stackTrace");
            for(int v = 0; v < arr_stackTraceElement.length; ++v) {
                String s = arr_stackTraceElement[v].getClassName();
                q.f(s, "it.className");
                Feature featureManager$Feature0 = FeatureManager.getFeature(s);
                if(featureManager$Feature0 != Feature.Unknown) {
                    FeatureManager.disableFeature(featureManager$Feature0);
                    hashSet0.add(featureManager$Feature0.toString());
                }
            }
            if(FacebookSdk.getAutoLogAppEventsEnabled() && !hashSet0.isEmpty()) {
                Builder.build(new JSONArray(hashSet0)).save();
            }
        }
    }

    public static final boolean isDebug$facebook_core_release() [...] // Inlined contents

    public final void sendExceptionAnalysisReports$facebook_core_release() {
        if(!Utility.isDataProcessingRestricted()) {
            File[] arr_file = InstrumentUtility.listExceptionAnalysisReportFiles();
            ArrayList arrayList0 = new ArrayList();
            for(int v = 0; v < arr_file.length; ++v) {
                InstrumentData instrumentData0 = Builder.load(arr_file[v]);
                if(instrumentData0.isValid()) {
                    JSONObject jSONObject0 = new JSONObject();
                    try {
                        jSONObject0.put("crash_shield", instrumentData0.toString());
                        String s = String.format("%s/instruments", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
                        a a0 = new a(instrumentData0, 0);
                        arrayList0.add(GraphRequest.Companion.newPostRequest(null, s, jSONObject0, a0));
                    }
                    catch(JSONException unused_ex) {
                    }
                }
            }
            if(!arrayList0.isEmpty()) {
                new GraphRequestBatch(arrayList0).executeAsync();
            }
        }
    }

    private static final void sendExceptionAnalysisReports$lambda$1(InstrumentData instrumentData0, GraphResponse graphResponse0) {
        q.g(instrumentData0, "$instrumentData");
        q.g(graphResponse0, "response");
        try {
            if(graphResponse0.getError() == null) {
                JSONObject jSONObject0 = graphResponse0.getJsonObject();
                if(jSONObject0 != null && jSONObject0.getBoolean("success")) {
                    instrumentData0.clear();
                }
            }
        }
        catch(JSONException unused_ex) {
        }
    }
}

