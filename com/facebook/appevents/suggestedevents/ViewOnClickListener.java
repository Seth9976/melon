package com.facebook.appevents.suggestedevents;

import D5.a;
import D5.b;
import Tf.v;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.ml.ModelManager.Task;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001C2\u00020\u0001:\u0001\u001CB!\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000BJ\'\u0010\u0010\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001A\u0004\u0018\u00010\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001A\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001A\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001A\u0010\u0019R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001B¨\u0006\u001D"}, d2 = {"Lcom/facebook/appevents/suggestedevents/ViewOnClickListener;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "hostView", "rootView", "", "activityName", "<init>", "(Landroid/view/View;Landroid/view/View;Ljava/lang/String;)V", "Lie/H;", "process", "()V", "pathID", "buttonText", "Lorg/json/JSONObject;", "viewData", "predictAndProcess", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "view", "onClick", "(Landroid/view/View;)V", "baseListener", "Landroid/view/View$OnClickListener;", "Ljava/lang/ref/WeakReference;", "rootViewWeakReference", "Ljava/lang/ref/WeakReference;", "hostViewWeakReference", "Ljava/lang/String;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ViewOnClickListener implements View.OnClickListener {
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\b\u001A\u00020\u00072\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\'\u0010\u000E\u001A\u00020\r2\u0006\u0010\n\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\u000E\u0010\u000FJ\'\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\u0011\u0010\u000FJ\'\u0010\u0018\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\u0004H\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001B\u001A\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001B\u0010\u001AR\u001A\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u001D0\u001C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001E\u0010\u001F¨\u0006 "}, d2 = {"Lcom/facebook/appevents/suggestedevents/ViewOnClickListener$Companion;", "", "<init>", "()V", "", "pathID", "buttonText", "", "queryHistoryAndProcess", "(Ljava/lang/String;Ljava/lang/String;)Z", "predictedEvent", "", "dense", "Lie/H;", "processPredictedResult", "(Ljava/lang/String;Ljava/lang/String;[F)V", "eventToPost", "sendPredictedResult", "Landroid/view/View;", "hostView", "rootView", "activityName", "attachListener$facebook_core_release", "(Landroid/view/View;Landroid/view/View;Ljava/lang/String;)V", "attachListener", "API_ENDPOINT", "Ljava/lang/String;", "OTHER_EVENT", "", "", "viewsAttachedListener", "Ljava/util/Set;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static final void access$processPredictedResult(Companion viewOnClickListener$Companion0, String s, String s1, float[] arr_f) {
            viewOnClickListener$Companion0.processPredictedResult(s, s1, arr_f);
        }

        public static final boolean access$queryHistoryAndProcess(Companion viewOnClickListener$Companion0, String s, String s1) {
            return viewOnClickListener$Companion0.queryHistoryAndProcess(s, s1);
        }

        public final void attachListener$facebook_core_release(@NotNull View view0, @NotNull View view1, @NotNull String s) {
            q.g(view0, "hostView");
            q.g(view1, "rootView");
            q.g(s, "activityName");
            int v = view0.hashCode();
            if(!ViewOnClickListener.access$getViewsAttachedListener$cp().contains(v)) {
                ViewHierarchy.setOnClickListener(view0, new ViewOnClickListener(view0, view1, s, null));
                ViewOnClickListener.access$getViewsAttachedListener$cp().add(v);
            }
        }

        private final void processPredictedResult(String s, String s1, float[] arr_f) {
            if(SuggestedEventsManager.isProductionEvents$facebook_core_release(s)) {
                new InternalAppEventsLogger(FacebookSdk.getApplicationContext()).logEventFromSE(s, s1);
                return;
            }
            if(SuggestedEventsManager.isEligibleEvents$facebook_core_release(s)) {
                this.sendPredictedResult(s, s1, arr_f);
            }
        }

        private final boolean queryHistoryAndProcess(String s, String s1) {
            String s2 = PredictionHistoryManager.queryEvent(s);
            if(s2 == null) {
                return false;
            }
            if(!s2.equals("other")) {
                Utility.runOnNonUiThread(new b(s2, s1, 0));
            }
            return true;
        }

        private static final void queryHistoryAndProcess$lambda$0(String s, String s1) {
            q.g(s, "$queriedEvent");
            q.g(s1, "$buttonText");
            ViewOnClickListener.Companion.processPredictedResult(s, s1, new float[0]);
        }

        private final void sendPredictedResult(String s, String s1, float[] arr_f) {
            Bundle bundle0 = new Bundle();
            try {
                bundle0.putString("event_name", s);
                JSONObject jSONObject0 = new JSONObject();
                StringBuilder stringBuilder0 = new StringBuilder();
                for(int v = 0; v < arr_f.length; ++v) {
                    stringBuilder0.append(arr_f[v]);
                    stringBuilder0.append(",");
                }
                jSONObject0.put("dense", stringBuilder0.toString());
                jSONObject0.put("button_text", s1);
                bundle0.putString("metadata", jSONObject0.toString());
                String s2 = String.format(Locale.US, "%s/suggested_events", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
                GraphRequest graphRequest0 = GraphRequest.Companion.newPostRequest(null, s2, null, null);
                graphRequest0.setParameters(bundle0);
                graphRequest0.executeAndWait();
            }
            catch(JSONException unused_ex) {
            }
        }
    }

    @NotNull
    private static final String API_ENDPOINT = "%s/suggested_events";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String OTHER_EVENT = "other";
    @NotNull
    private final String activityName;
    @Nullable
    private final View.OnClickListener baseListener;
    @NotNull
    private final WeakReference hostViewWeakReference;
    @NotNull
    private final WeakReference rootViewWeakReference;
    @NotNull
    private static final Set viewsAttachedListener;

    static {
        ViewOnClickListener.Companion = new Companion(null);
        ViewOnClickListener.viewsAttachedListener = new HashSet();
    }

    private ViewOnClickListener(View view0, View view1, String s) {
        this.baseListener = ViewHierarchy.getExistingOnClickListener(view0);
        this.rootViewWeakReference = new WeakReference(view1);
        this.hostViewWeakReference = new WeakReference(view0);
        String s1 = s.toLowerCase();
        q.f(s1, "this as java.lang.String).toLowerCase()");
        this.activityName = v.p0(s1, "activity", "");
    }

    public ViewOnClickListener(View view0, View view1, String s, DefaultConstructorMarker defaultConstructorMarker0) {
        this(view0, view1, s);
    }

    // 去混淆评级： 低(20)
    public static final Set access$getViewsAttachedListener$cp() {
        return CrashShieldHandler.isObjectCrashing(ViewOnClickListener.class) ? null : ViewOnClickListener.viewsAttachedListener;
    }

    public static final void attachListener$facebook_core_release(@NotNull View view0, @NotNull View view1, @NotNull String s) {
        Class class0 = ViewOnClickListener.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            ViewOnClickListener.Companion.attachListener$facebook_core_release(view0, view1, s);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(@NotNull View view0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            q.g(view0, "view");
            View.OnClickListener view$OnClickListener0 = this.baseListener;
            if(view$OnClickListener0 != null) {
                view$OnClickListener0.onClick(view0);
            }
            this.process();
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private final void predictAndProcess(String s, String s1, JSONObject jSONObject0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Utility.runOnNonUiThread(new a(jSONObject0, s1, this, s));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private static final void predictAndProcess$lambda$0(JSONObject jSONObject0, String s, ViewOnClickListener viewOnClickListener0, String s1) {
        Class class0 = ViewOnClickListener.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            try {
                q.g(jSONObject0, "$viewData");
                q.g(s, "$buttonText");
                q.g(viewOnClickListener0, "this$0");
                q.g(s1, "$pathID");
                try {
                    String s2 = Utility.getAppName(FacebookSdk.getApplicationContext()).toLowerCase();
                    q.f(s2, "this as java.lang.String).toLowerCase()");
                    float[] arr_f = FeatureExtractor.getDenseFeatures(jSONObject0, s2);
                    String s3 = FeatureExtractor.getTextFeature(s, viewOnClickListener0.activityName, s2);
                    if(arr_f != null) {
                        String[] arr_s = ModelManager.predict(Task.MTML_APP_EVENT_PREDICTION, new float[][]{arr_f}, new String[]{s3});
                        if(arr_s != null) {
                            String s4 = arr_s[0];
                            PredictionHistoryManager.addPrediction(s1, s4);
                            if(!q.b(s4, "other")) {
                                Companion.access$processPredictedResult(ViewOnClickListener.Companion, s4, s, arr_f);
                            }
                        }
                    }
                }
                catch(Exception unused_ex) {
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, class0);
            }
        }
    }

    private final void process() {
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                View view0 = (View)this.rootViewWeakReference.get();
                View view1 = (View)this.hostViewWeakReference.get();
                if(view0 != null && view1 != null) {
                    try {
                        String s = SuggestedEventViewHierarchy.getTextOfViewRecursively(view1);
                        String s1 = PredictionHistoryManager.getPathID(view1, s);
                        if(s1 != null && !Companion.access$queryHistoryAndProcess(ViewOnClickListener.Companion, s1, s)) {
                            JSONObject jSONObject0 = new JSONObject();
                            jSONObject0.put("view", SuggestedEventViewHierarchy.getDictionaryOfView(view0, view1));
                            jSONObject0.put("screenname", this.activityName);
                            this.predictAndProcess(s1, s, jSONObject0);
                        }
                    }
                    catch(Exception unused_ex) {
                    }
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
            }
        }
    }
}

