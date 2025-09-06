package com.facebook.internal;

import Tf.o;
import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.android.installreferrer.api.a;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000F\u0010\n\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003R\u0014\u0010\f\u001A\u00020\u000B8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000F\u001A\u00020\u000E8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/facebook/internal/InstallReferrerUtil;", "", "<init>", "()V", "Lcom/facebook/internal/InstallReferrerUtil$Callback;", "callback", "Lie/H;", "tryUpdateReferrerInfo", "(Lcom/facebook/internal/InstallReferrerUtil$Callback;)V", "tryConnectReferrerInfo", "updateReferrer", "", "IS_REFERRER_UPDATED", "Ljava/lang/String;", "", "isUpdated", "()Z", "Callback", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class InstallReferrerUtil {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/InstallReferrerUtil$Callback;", "", "", "s", "Lie/H;", "onReceiveReferrerUrl", "(Ljava/lang/String;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface Callback {
        void onReceiveReferrerUrl(@Nullable String arg1);
    }

    @NotNull
    public static final InstallReferrerUtil INSTANCE = null;
    @NotNull
    private static final String IS_REFERRER_UPDATED = "is_referrer_updated";

    static {
        InstallReferrerUtil.INSTANCE = new InstallReferrerUtil();
    }

    private final boolean isUpdated() {
        return FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("is_referrer_updated", false);
    }

    private final void tryConnectReferrerInfo(Callback installReferrerUtil$Callback0) {
        InstallReferrerClient installReferrerClient0 = new a(FacebookSdk.getApplicationContext()).a();
        com.facebook.internal.InstallReferrerUtil.tryConnectReferrerInfo.installReferrerStateListener.1 installReferrerUtil$tryConnectReferrerInfo$installReferrerStateListener$10 = new InstallReferrerStateListener() {
            @Override  // com.android.installreferrer.api.InstallReferrerStateListener
            public void onInstallReferrerServiceDisconnected() {
            }

            @Override  // com.android.installreferrer.api.InstallReferrerStateListener
            public void onInstallReferrerSetupFinished(int v) {
                ReferrerDetails referrerDetails0;
                if(!CrashShieldHandler.isObjectCrashing(this)) {
                    switch(v) {
                        case 0: {
                            try {
                                try {
                                    referrerDetails0 = installReferrerUtil$Callback0.b();
                                }
                                catch(RemoteException unused_ex) {
                                    return;
                                }
                                String s = referrerDetails0.a.getString("install_referrer");
                                if(s != null && (o.v0(s, "fb", false) || o.v0(s, "facebook", false))) {
                                    this.$callback.onReceiveReferrerUrl(s);
                                }
                                InstallReferrerUtil.INSTANCE.updateReferrer();
                                goto label_10;
                            label_9:
                                InstallReferrerUtil.INSTANCE.updateReferrer();
                                try {
                                label_10:
                                    installReferrerUtil$Callback0.a();
                                }
                                catch(Exception unused_ex) {
                                }
                                return;
                            }
                            catch(Throwable throwable0) {
                                break;
                            }
                        }
                        case 2: {
                            goto label_9;
                        }
                        default: {
                            goto label_10;
                        }
                    }
                    CrashShieldHandler.handleThrowable(throwable0, this);
                }
            }
        };
        try {
            installReferrerClient0.c(installReferrerUtil$tryConnectReferrerInfo$installReferrerStateListener$10);
        }
        catch(Exception unused_ex) {
        }
    }

    public static final void tryUpdateReferrerInfo(@NotNull Callback installReferrerUtil$Callback0) {
        q.g(installReferrerUtil$Callback0, "callback");
        InstallReferrerUtil installReferrerUtil0 = InstallReferrerUtil.INSTANCE;
        if(!installReferrerUtil0.isUpdated()) {
            installReferrerUtil0.tryConnectReferrerInfo(installReferrerUtil$Callback0);
        }
    }

    private final void updateReferrer() {
        FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putBoolean("is_referrer_updated", true).apply();
    }
}

