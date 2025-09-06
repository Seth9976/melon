package com.facebook.appevents.codeless;

import android.app.Activity;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import b.l;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.cloudbridge.a;
import com.facebook.appevents.codeless.internal.UnityReflection;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001E2\u00020\u0001:\u0002\u001E\u001FB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000B\u001A\u00020\b¢\u0006\u0004\b\u000B\u0010\fJ\r\u0010\r\u001A\u00020\b¢\u0006\u0004\b\r\u0010\fJ!\u0010\u0011\u001A\u00020\b2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001A\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001A\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001A\u001A\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u0018\u0010\u001C\u001A\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001C\u0010\u001D¨\u0006 "}, d2 = {"Lcom/facebook/appevents/codeless/ViewIndexer;", "", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "", "tree", "Lie/H;", "sendToServer", "(Ljava/lang/String;)V", "schedule", "()V", "unschedule", "Lcom/facebook/GraphRequest;", "request", "currentDigest", "processRequest", "(Lcom/facebook/GraphRequest;Ljava/lang/String;)V", "Landroid/os/Handler;", "uiThreadHandler", "Landroid/os/Handler;", "Ljava/lang/ref/WeakReference;", "activityReference", "Ljava/lang/ref/WeakReference;", "Ljava/util/Timer;", "indexingTimer", "Ljava/util/Timer;", "previousDigest", "Ljava/lang/String;", "Companion", "ScreenshotTaker", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ViewIndexer {
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ7\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\t\u001A\u0004\u0018\u00010\u00042\b\u0010\u000B\u001A\u0004\u0018\u00010\n2\b\u0010\f\u001A\u0004\u0018\u00010\u00042\u0006\u0010\r\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0011\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0018\u0010\u0019\u001A\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2 = {"Lcom/facebook/appevents/codeless/ViewIndexer$Companion;", "", "<init>", "()V", "", "tree", "Lie/H;", "sendToServerUnityInstance", "(Ljava/lang/String;)V", "appIndex", "Lcom/facebook/AccessToken;", "accessToken", "appId", "requestType", "Lcom/facebook/GraphRequest;", "buildAppIndexingRequest", "(Ljava/lang/String;Lcom/facebook/AccessToken;Ljava/lang/String;Ljava/lang/String;)Lcom/facebook/GraphRequest;", "APP_VERSION_PARAM", "Ljava/lang/String;", "PLATFORM_PARAM", "REQUEST_TYPE", "SUCCESS", "TAG", "TREE_PARAM", "Lcom/facebook/appevents/codeless/ViewIndexer;", "instance", "Lcom/facebook/appevents/codeless/ViewIndexer;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static void a(GraphResponse graphResponse0) {
            Companion.buildAppIndexingRequest$lambda$0(graphResponse0);
        }

        @Nullable
        public final GraphRequest buildAppIndexingRequest(@Nullable String s, @Nullable AccessToken accessToken0, @Nullable String s1, @NotNull String s2) {
            q.g(s2, "requestType");
            if(s == null) {
                return null;
            }
            String s3 = String.format(Locale.US, "%s/app_indexing", Arrays.copyOf(new Object[]{s1}, 1));
            GraphRequest graphRequest0 = GraphRequest.Companion.newPostRequest(accessToken0, s3, null, null);
            Bundle bundle0 = graphRequest0.getParameters();
            if(bundle0 == null) {
                bundle0 = new Bundle();
            }
            bundle0.putString("tree", s);
            bundle0.putString("app_version", AppEventUtility.getAppVersion());
            bundle0.putString("platform", "android");
            bundle0.putString("request_type", s2);
            if(s2.equals("app_indexing")) {
                bundle0.putString("device_session_id", "dfed3bb0-1539-420b-b6fd-f15543876142");
            }
            graphRequest0.setParameters(bundle0);
            graphRequest0.setCallback(new a(1));
            return graphRequest0;
        }

        private static final void buildAppIndexingRequest$lambda$0(GraphResponse graphResponse0) {
            q.g(graphResponse0, "it");
            String s = ViewIndexer.access$getTAG$cp();
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, s, "App index sent to FB!");
        }

        public final void sendToServerUnityInstance(@NotNull String s) {
            q.g(s, "tree");
            ViewIndexer viewIndexer0 = ViewIndexer.access$getInstance$cp();
            if(viewIndexer0 != null) {
                ViewIndexer.access$sendToServer(viewIndexer0, s);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0007\u001A\u00020\u0002H\u0016R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/codeless/ViewIndexer$ScreenshotTaker;", "Ljava/util/concurrent/Callable;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "Ljava/lang/ref/WeakReference;", "call", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class ScreenshotTaker implements Callable {
        @NotNull
        private final WeakReference rootView;

        public ScreenshotTaker(@NotNull View view0) {
            q.g(view0, "rootView");
            super();
            this.rootView = new WeakReference(view0);
        }

        @Override
        public Object call() {
            return this.call();
        }

        @NotNull
        public String call() {
            View view0 = (View)this.rootView.get();
            if(view0 != null && view0.getWidth() != 0 && view0.getHeight() != 0) {
                Bitmap bitmap0 = Bitmap.createBitmap(view0.getWidth(), view0.getHeight(), Bitmap.Config.RGB_565);
                q.f(bitmap0, "createBitmap(view.width,…t, Bitmap.Config.RGB_565)");
                view0.draw(new Canvas(bitmap0));
                ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
                bitmap0.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream0);
                String s = Base64.encodeToString(byteArrayOutputStream0.toByteArray(), 2);
                q.f(s, "encodeToString(outputStr…eArray(), Base64.NO_WRAP)");
                return s;
            }
            return "";
        }
    }

    @NotNull
    private static final String APP_VERSION_PARAM = "app_version";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String PLATFORM_PARAM = "platform";
    @NotNull
    private static final String REQUEST_TYPE = "request_type";
    @NotNull
    private static final String SUCCESS = "success";
    @NotNull
    private static final String TAG = null;
    @NotNull
    private static final String TREE_PARAM = "tree";
    @NotNull
    private final WeakReference activityReference;
    @Nullable
    private Timer indexingTimer;
    @Nullable
    private static ViewIndexer instance;
    @Nullable
    private String previousDigest;
    @NotNull
    private final Handler uiThreadHandler;

    static {
        ViewIndexer.Companion = new Companion(null);
        ViewIndexer.TAG = ViewIndexer.class.getCanonicalName() == null ? "" : ViewIndexer.class.getCanonicalName();
    }

    public ViewIndexer(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        super();
        this.activityReference = new WeakReference(activity0);
        this.previousDigest = null;
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        ViewIndexer.instance = this;
    }

    public static void a(String s, ViewIndexer viewIndexer0) {
        ViewIndexer.sendToServer$lambda$1(s, viewIndexer0);
    }

    // 去混淆评级： 低(20)
    public static final WeakReference access$getActivityReference$p(ViewIndexer viewIndexer0) {
        return CrashShieldHandler.isObjectCrashing(ViewIndexer.class) ? null : viewIndexer0.activityReference;
    }

    // 去混淆评级： 低(20)
    public static final ViewIndexer access$getInstance$cp() {
        return CrashShieldHandler.isObjectCrashing(ViewIndexer.class) ? null : ViewIndexer.instance;
    }

    // 去混淆评级： 低(20)
    public static final String access$getTAG$cp() {
        return CrashShieldHandler.isObjectCrashing(ViewIndexer.class) ? null : ViewIndexer.TAG;
    }

    // 去混淆评级： 低(20)
    public static final Handler access$getUiThreadHandler$p(ViewIndexer viewIndexer0) {
        return CrashShieldHandler.isObjectCrashing(ViewIndexer.class) ? null : viewIndexer0.uiThreadHandler;
    }

    public static final void access$sendToServer(ViewIndexer viewIndexer0, String s) {
        Class class0 = ViewIndexer.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            viewIndexer0.sendToServer(s);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static void b(ViewIndexer viewIndexer0, com.facebook.appevents.codeless.ViewIndexer.schedule.indexingTask.1 viewIndexer$schedule$indexingTask$10) {
        ViewIndexer.schedule$lambda$0(viewIndexer0, viewIndexer$schedule$indexingTask$10);
    }

    @Nullable
    public static final GraphRequest buildAppIndexingRequest(@Nullable String s, @Nullable AccessToken accessToken0, @Nullable String s1, @NotNull String s2) {
        Class class0 = ViewIndexer.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            return ViewIndexer.Companion.buildAppIndexingRequest(s, accessToken0, s1, s2);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    public final void processRequest(@Nullable GraphRequest graphRequest0, @Nullable String s) {
        if(!CrashShieldHandler.isObjectCrashing(this) && graphRequest0 != null) {
            try {
                GraphResponse graphResponse0 = graphRequest0.executeAndWait();
                try {
                    JSONObject jSONObject0 = graphResponse0.getJSONObject();
                    if(jSONObject0 == null) {
                        Log.e(ViewIndexer.TAG, "Error sending UI component tree to Facebook: " + graphResponse0.getError());
                        return;
                    }
                    if("true".equals(jSONObject0.optString("success"))) {
                        Logger.Companion.log(LoggingBehavior.APP_EVENTS, ViewIndexer.TAG, "Successfully send UI component tree to server");
                        this.previousDigest = s;
                    }
                    if(jSONObject0.has("is_app_indexing_enabled")) {
                        CodelessManager.updateAppIndexing$facebook_core_release(jSONObject0.getBoolean("is_app_indexing_enabled"));
                        return;
                    }
                    return;
                }
                catch(JSONException jSONException0) {
                }
                Log.e(ViewIndexer.TAG, "Error decoding server response.", jSONException0);
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final void schedule() {
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                com.facebook.appevents.codeless.ViewIndexer.schedule.indexingTask.1 viewIndexer$schedule$indexingTask$10 = new TimerTask() {
                    @Override
                    public void run() {
                        String s1;
                        FutureTask futureTask0;
                        String s;
                        View view0;
                        try {
                            Activity activity0 = (Activity)ViewIndexer.access$getActivityReference$p(ViewIndexer.this).get();
                            view0 = AppEventUtility.getRootView(activity0);
                            if(activity0 != null && view0 != null) {
                                s = activity0.getClass().getSimpleName();
                                if(CodelessManager.getIsAppIndexingEnabled$facebook_core_release()) {
                                    if(InternalSettings.isUnityApp()) {
                                        UnityReflection.captureViewHierarchy();
                                        return;
                                    }
                                    futureTask0 = new FutureTask(new ScreenshotTaker(view0));
                                    ViewIndexer.access$getUiThreadHandler$p(ViewIndexer.this).post(futureTask0);
                                    s1 = "";
                                    s1 = (String)futureTask0.get(1L, TimeUnit.SECONDS);
                                    goto label_15;
                                }
                            }
                        }
                        catch(Exception exception0) {
                            Log.e(ViewIndexer.access$getTAG$cp(), "UI Component tree indexing failure!", exception0);
                        }
                        return;
                        try {
                            s1 = (String)futureTask0.get(1L, TimeUnit.SECONDS);
                            goto label_15;
                        }
                        catch(Exception exception1) {
                            try {
                                Log.e(ViewIndexer.access$getTAG$cp(), "Failed to take screenshot.", exception1);
                            label_15:
                                JSONObject jSONObject0 = new JSONObject();
                                try {
                                    jSONObject0.put("screenname", s);
                                    jSONObject0.put("screenshot", s1);
                                    JSONArray jSONArray0 = new JSONArray();
                                    jSONArray0.put(ViewHierarchy.getDictionaryOfView(view0));
                                    jSONObject0.put("view", jSONArray0);
                                }
                                catch(JSONException unused_ex) {
                                    Log.e(ViewIndexer.access$getTAG$cp(), "Failed to create JSONObject");
                                }
                                String s2 = jSONObject0.toString();
                                q.f(s2, "viewTree.toString()");
                                ViewIndexer.access$sendToServer(ViewIndexer.this, s2);
                                return;
                            }
                            catch(Exception exception0) {
                            }
                        }
                        Log.e(ViewIndexer.access$getTAG$cp(), "UI Component tree indexing failure!", exception0);
                    }
                };
                try {
                    FacebookSdk.getExecutor().execute(new l(10, this, viewIndexer$schedule$indexingTask$10));
                }
                catch(RejectedExecutionException rejectedExecutionException0) {
                    Log.e(ViewIndexer.TAG, "Error scheduling indexing job", rejectedExecutionException0);
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
            }
        }
    }

    private static final void schedule$lambda$0(ViewIndexer viewIndexer0, TimerTask timerTask0) {
        Exception exception1;
        Throwable throwable1;
        Class class0 = ViewIndexer.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            try {
                q.g(viewIndexer0, "this$0");
                q.g(timerTask0, "$indexingTask");
                try {
                    Timer timer0 = viewIndexer0.indexingTimer;
                    if(timer0 != null) {
                        timer0.cancel();
                    }
                    viewIndexer0.previousDigest = null;
                    Timer timer1 = new Timer();
                    timer1.scheduleAtFixedRate(timerTask0, 0L, 1000L);
                    viewIndexer0.indexingTimer = timer1;
                    return;
                label_16:
                    exception1 = exception0;
                }
                catch(Exception exception0) {
                    goto label_16;
                }
                Log.e(ViewIndexer.TAG, "Error scheduling indexing job", exception1);
                return;
            }
            catch(Throwable throwable0) {
                throwable1 = throwable0;
            }
            CrashShieldHandler.handleThrowable(throwable1, class0);
        }
    }

    private final void sendToServer(String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FacebookSdk.getExecutor().execute(new l(11, s, this));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private static final void sendToServer$lambda$1(String s, ViewIndexer viewIndexer0) {
        Class class0 = ViewIndexer.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(s, "$tree");
                q.g(viewIndexer0, "this$0");
                String s1 = Utility.md5hash(s);
                AccessToken accessToken0 = AccessToken.Companion.getCurrentAccessToken();
                if(s1 == null || !s1.equals(viewIndexer0.previousDigest)) {
                    String s2 = FacebookSdk.getApplicationId();
                    viewIndexer0.processRequest(ViewIndexer.Companion.buildAppIndexingRequest(s, accessToken0, s2, "app_indexing"), s1);
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    public static final void sendToServerUnityInstance(@NotNull String s) {
        Class class0 = ViewIndexer.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            ViewIndexer.Companion.sendToServerUnityInstance(s);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public final void unschedule() {
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if(((Activity)this.activityReference.get()) != null) {
                    try {
                        Timer timer0 = this.indexingTimer;
                        if(timer0 != null) {
                            timer0.cancel();
                        }
                        this.indexingTimer = null;
                        return;
                    }
                    catch(Exception exception0) {
                    }
                    Log.e(ViewIndexer.TAG, "Error unscheduling indexing job", exception0);
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }
}

