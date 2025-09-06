package com.facebook;

import W2.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\b&\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J#\u0010\t\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\b\u001A\u0004\u0018\u00010\u0006H$¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000B\u001A\u00020\u0004¢\u0006\u0004\b\u000B\u0010\u0003J\r\u0010\f\u001A\u00020\u0004¢\u0006\u0004\b\f\u0010\u0003R\u0014\u0010\u000E\u001A\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0011\u001A\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R$\u0010\u0015\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00138\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0015\u0010\u0017¨\u0006\u001A"}, d2 = {"Lcom/facebook/AccessTokenTracker;", "", "<init>", "()V", "Lie/H;", "addBroadcastReceiver", "Lcom/facebook/AccessToken;", "oldAccessToken", "currentAccessToken", "onCurrentAccessTokenChanged", "(Lcom/facebook/AccessToken;Lcom/facebook/AccessToken;)V", "startTracking", "stopTracking", "Landroid/content/BroadcastReceiver;", "receiver", "Landroid/content/BroadcastReceiver;", "LW2/b;", "broadcastManager", "LW2/b;", "", "<set-?>", "isTracking", "Z", "()Z", "Companion", "CurrentAccessTokenBroadcastReceiver", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public abstract class AccessTokenTracker {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/AccessTokenTracker$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/facebook/AccessTokenTracker$CurrentAccessTokenBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "(Lcom/facebook/AccessTokenTracker;)V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Lie/H;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class CurrentAccessTokenBroadcastReceiver extends BroadcastReceiver {
        @Override  // android.content.BroadcastReceiver
        public void onReceive(@NotNull Context context0, @NotNull Intent intent0) {
            q.g(context0, "context");
            q.g(intent0, "intent");
            if("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED".equals(intent0.getAction())) {
                Utility.logd("AccessTokenTracker", "AccessTokenChanged");
                AccessToken accessToken0 = (AccessToken)intent0.getParcelableExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN");
                AccessToken accessToken1 = (AccessToken)intent0.getParcelableExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN");
                AccessTokenTracker.this.onCurrentAccessTokenChanged(accessToken0, accessToken1);
            }
        }
    }

    @NotNull
    public static final Companion Companion;
    private static final String TAG;
    @NotNull
    private final b broadcastManager;
    private boolean isTracking;
    @NotNull
    private final BroadcastReceiver receiver;

    static {
        AccessTokenTracker.Companion = new Companion(null);
        AccessTokenTracker.TAG = "AccessTokenTracker";
    }

    public AccessTokenTracker() {
        Validate.sdkInitialized();
        this.receiver = new CurrentAccessTokenBroadcastReceiver(this);
        b b0 = b.a(FacebookSdk.getApplicationContext());
        q.f(b0, "getInstance(FacebookSdk.getApplicationContext())");
        this.broadcastManager = b0;
        this.startTracking();
    }

    // 去混淆评级： 低(20)
    public static final String access$getTAG$cp() [...] // 潜在的解密器

    private final void addBroadcastReceiver() {
        IntentFilter intentFilter0 = new IntentFilter();
        intentFilter0.addAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        this.broadcastManager.b(this.receiver, intentFilter0);
    }

    public final boolean isTracking() {
        return this.isTracking;
    }

    public abstract void onCurrentAccessTokenChanged(@Nullable AccessToken arg1, @Nullable AccessToken arg2);

    public final void startTracking() {
        if(this.isTracking) {
            return;
        }
        this.addBroadcastReceiver();
        this.isTracking = true;
    }

    public final void stopTracking() {
        if(!this.isTracking) {
            return;
        }
        this.broadcastManager.d(this.receiver);
        this.isTracking = false;
    }
}

