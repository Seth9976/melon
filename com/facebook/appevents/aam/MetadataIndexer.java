package com.facebook.appevents.aam;

import A5.a;
import android.app.Activity;
import android.content.Context;
import com.facebook.FacebookSdk;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000F\u0010\n\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u0003R\u001C\u0010\r\u001A\n \f*\u0004\u0018\u00010\u000B0\u000B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000ER\u0016\u0010\u0010\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/facebook/appevents/aam/MetadataIndexer;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "Lie/H;", "onActivityResumed", "(Landroid/app/Activity;)V", "updateRules", "enable", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "", "enabled", "Z", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class MetadataIndexer {
    @NotNull
    public static final MetadataIndexer INSTANCE;
    private static final String TAG;
    private static boolean enabled;

    static {
        MetadataIndexer.INSTANCE = new MetadataIndexer();
        MetadataIndexer.TAG = MetadataIndexer.class.getCanonicalName();
    }

    public static final void enable() {
        Class class0 = MetadataIndexer.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            try {
                try {
                    FacebookSdk.getExecutor().execute(new a(0));
                }
                catch(Exception exception0) {
                    Utility.logd(MetadataIndexer.TAG, exception0);
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, class0);
            }
        }
    }

    private static final void enable$lambda$0() {
        Class class0 = MetadataIndexer.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                Context context0 = FacebookSdk.getApplicationContext();
                if(!AttributionIdentifiers.Companion.isTrackingLimited(context0)) {
                    MetadataIndexer.INSTANCE.updateRules();
                    MetadataIndexer.enabled = true;
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    public static final void onActivityResumed(@NotNull Activity activity0) {
        Class class0 = MetadataIndexer.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            try {
                q.g(activity0, "activity");
                try {
                    if(MetadataIndexer.enabled && !MetadataRule.Companion.getRules().isEmpty()) {
                        MetadataViewObserver.Companion.startTrackingActivity(activity0);
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

    private final void updateRules() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if(fetchedAppSettings0 != null) {
                    String s = fetchedAppSettings0.getRawAamRules();
                    if(s != null) {
                        MetadataRule.Companion.updateRules(s);
                        return;
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }
}

