package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import d3.g;
import ie.j;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import we.a;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001D\u0010\r\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0014\u001A\u00020\u000F¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001A\u00020\u00062\u0006\u0010\u0018\u001A\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001AR\u001B\u0010 \u001A\u00020\u001B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001F¨\u0006\""}, d2 = {"Lcom/facebook/appevents/internal/AppLinkManager;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "Lie/H;", "handleURL", "(Landroid/app/Activity;)V", "Landroid/net/Uri;", "uri", "Landroid/content/Intent;", "intent", "processCampaignIds", "(Landroid/net/Uri;Landroid/content/Intent;)V", "", "getCampaignIDFromUri", "(Landroid/net/Uri;)Ljava/lang/String;", "getCampaignIDFromIntentExtra", "(Landroid/content/Intent;)Ljava/lang/String;", "key", "getInfo", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/app/Application;", "application", "setupLifecycleListener", "(Landroid/app/Application;)V", "Landroid/content/SharedPreferences;", "preferences$delegate", "Lie/j;", "getPreferences", "()Landroid/content/SharedPreferences;", "preferences", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AppLinkManager {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001A\u0004\u0018\u00010\bR\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/appevents/internal/AppLinkManager$Companion;", "", "()V", "APPLINK_DATA_KEY", "", "APPLINK_INFO", "CAMPAIGN_IDS_KEY", "instance", "Lcom/facebook/appevents/internal/AppLinkManager;", "getInstance", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @Nullable
        public final AppLinkManager getInstance() {
            AppLinkManager appLinkManager0 = AppLinkManager.access$getInstance$cp();
            if(appLinkManager0 == null) {
                synchronized(this) {
                    if(!FacebookSdk.isInitialized()) {
                        return null;
                    }
                    AppLinkManager appLinkManager1 = AppLinkManager.access$getInstance$cp();
                    if(appLinkManager1 == null) {
                        appLinkManager1 = new AppLinkManager(null);
                        AppLinkManager.access$setInstance$cp(appLinkManager1);
                    }
                    return appLinkManager1;
                }
            }
            return appLinkManager0;
        }
    }

    @NotNull
    public static final String APPLINK_DATA_KEY = "al_applink_data";
    @NotNull
    public static final String APPLINK_INFO = "com.facebook.sdk.APPLINK_INFO";
    @NotNull
    public static final String CAMPAIGN_IDS_KEY = "campaign_ids";
    @NotNull
    public static final Companion Companion;
    @Nullable
    private static volatile AppLinkManager instance;
    @NotNull
    private final j preferences$delegate;

    static {
        AppLinkManager.Companion = new Companion(null);
    }

    private AppLinkManager() {
        this.preferences$delegate = g.Q(com.facebook.appevents.internal.AppLinkManager.preferences.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001A\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 0x30)
        final class com.facebook.appevents.internal.AppLinkManager.preferences.2 extends r implements a {
            public static final com.facebook.appevents.internal.AppLinkManager.preferences.2 INSTANCE;

            static {
                com.facebook.appevents.internal.AppLinkManager.preferences.2.INSTANCE = new com.facebook.appevents.internal.AppLinkManager.preferences.2();
            }

            public com.facebook.appevents.internal.AppLinkManager.preferences.2() {
                super(0);
            }

            public final SharedPreferences invoke() {
                return FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.APPLINK_INFO", 0);
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public AppLinkManager(DefaultConstructorMarker defaultConstructorMarker0) {
    }

    // 去混淆评级： 低(20)
    public static final AppLinkManager access$getInstance$cp() {
        return CrashShieldHandler.isObjectCrashing(AppLinkManager.class) ? null : AppLinkManager.instance;
    }

    public static final void access$setInstance$cp(AppLinkManager appLinkManager0) {
        if(CrashShieldHandler.isObjectCrashing(AppLinkManager.class)) {
            return;
        }
        AppLinkManager.instance = appLinkManager0;
    }

    @Nullable
    public final String getCampaignIDFromIntentExtra(@NotNull Intent intent0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            q.g(intent0, "intent");
            Bundle bundle0 = intent0.getBundleExtra("al_applink_data");
            return bundle0 == null ? null : bundle0.getString("campaign_ids");
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    @Nullable
    public final String getCampaignIDFromUri(@NotNull Uri uri0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            q.g(uri0, "uri");
            String s = uri0.getQueryParameter("al_applink_data");
            if(s == null) {
                return null;
            }
            try {
                return new JSONObject(s).getString("campaign_ids");
            }
            catch(Exception unused_ex) {
                Log.d("AppLinkManager", "Fail to parse Applink data from Uri");
                return null;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    @Nullable
    public final String getInfo(@NotNull String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            q.g(s, "key");
            return this.getPreferences().getString(s, null);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    private final SharedPreferences getPreferences() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Object object0 = this.preferences$delegate.getValue();
            q.f(object0, "<get-preferences>(...)");
            return (SharedPreferences)object0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    public final void handleURL(@NotNull Activity activity0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                q.g(activity0, "activity");
                Uri uri0 = activity0.getIntent().getData();
                if(uri0 != null) {
                    Intent intent0 = activity0.getIntent();
                    q.f(intent0, "activity.intent");
                    this.processCampaignIds(uri0, intent0);
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    public final void processCampaignIds(@NotNull Uri uri0, @NotNull Intent intent0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                q.g(uri0, "uri");
                q.g(intent0, "intent");
                String s = this.getCampaignIDFromUri(uri0);
                if(s == null) {
                    s = this.getCampaignIDFromIntentExtra(intent0);
                }
                if(s != null) {
                    this.getPreferences().edit().putString("campaign_ids", s).apply();
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    public final void setupLifecycleListener(@NotNull Application application0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            q.g(application0, "application");
            application0.registerActivityLifecycleCallbacks(new com.facebook.appevents.internal.AppLinkManager.setupLifecycleListener.1());
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }

        @Metadata(d1 = {"\u0000\u001D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000B\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u000B\u0010\nJ\u0017\u0010\f\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\r\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\nJ\u001F\u0010\u000E\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u000E\u0010\bJ\u0017\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u000F\u0010\n¨\u0006\u0010"}, d2 = {"com/facebook/appevents/internal/AppLinkManager$setupLifecycleListener$1", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", "activity", "Landroid/os/Bundle;", "bundle", "Lie/H;", "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityStarted", "(Landroid/app/Activity;)V", "onActivityResumed", "onActivityPaused", "onActivityStopped", "onActivitySaveInstanceState", "onActivityDestroyed", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public final class com.facebook.appevents.internal.AppLinkManager.setupLifecycleListener.1 implements Application.ActivityLifecycleCallbacks {
            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityCreated(@NotNull Activity activity0, @Nullable Bundle bundle0) {
                q.g(activity0, "activity");
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityDestroyed(@NotNull Activity activity0) {
                q.g(activity0, "activity");
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityPaused(@NotNull Activity activity0) {
                q.g(activity0, "activity");
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityResumed(@NotNull Activity activity0) {
                q.g(activity0, "activity");
                AppLinkManager appLinkManager0 = AppLinkManager.Companion.getInstance();
                if(appLinkManager0 != null) {
                    appLinkManager0.handleURL(activity0);
                }
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(@NotNull Activity activity0, @NotNull Bundle bundle0) {
                q.g(activity0, "activity");
                q.g(bundle0, "bundle");
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityStarted(@NotNull Activity activity0) {
                q.g(activity0, "activity");
                AppLinkManager appLinkManager0 = AppLinkManager.Companion.getInstance();
                if(appLinkManager0 != null) {
                    appLinkManager0.handleURL(activity0);
                }
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityStopped(@NotNull Activity activity0) {
                q.g(activity0, "activity");
            }
        }

    }
}

