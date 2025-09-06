package com.facebook.login;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsService;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.c;
import p.d;
import p.k;
import p.l;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000F"}, d2 = {"Lcom/facebook/login/CustomTabPrefetchHelper;", "Lp/k;", "<init>", "()V", "Landroid/content/ComponentName;", "name", "Lp/d;", "newClient", "Lie/H;", "onCustomTabsServiceConnected", "(Landroid/content/ComponentName;Lp/d;)V", "componentName", "onServiceDisconnected", "(Landroid/content/ComponentName;)V", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CustomTabPrefetchHelper extends k {
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\u000B\u0010\fR\u0018\u0010\u000E\u001A\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0011\u001A\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001A\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/facebook/login/CustomTabPrefetchHelper$Companion;", "", "<init>", "()V", "Lie/H;", "prepareSession", "Landroid/net/Uri;", "url", "mayLaunchUrl", "(Landroid/net/Uri;)V", "Lp/l;", "getPreparedSessionOnce", "()Lp/l;", "Lp/d;", "client", "Lp/d;", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "session", "Lp/l;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static final void access$prepareSession(Companion customTabPrefetchHelper$Companion0) {
            customTabPrefetchHelper$Companion0.prepareSession();
        }

        @Nullable
        public final l getPreparedSessionOnce() {
            CustomTabPrefetchHelper.lock.lock();
            CustomTabPrefetchHelper.session = null;
            CustomTabPrefetchHelper.lock.unlock();
            return CustomTabPrefetchHelper.session;
        }

        public final void mayLaunchUrl(@NotNull Uri uri0) {
            q.g(uri0, "url");
            this.prepareSession();
            CustomTabPrefetchHelper.lock.lock();
            l l0 = CustomTabPrefetchHelper.session;
            if(l0 != null) {
                Bundle bundle0 = new Bundle();
                try {
                    l0.a.mayLaunchUrl(l0.b, uri0, bundle0, null);
                }
                catch(RemoteException unused_ex) {
                }
            }
            CustomTabPrefetchHelper.lock.unlock();
        }

        private final void prepareSession() {
            CustomTabPrefetchHelper.lock.lock();
            if(CustomTabPrefetchHelper.session == null) {
                d d0 = CustomTabPrefetchHelper.client;
                if(d0 != null) {
                    ICustomTabsService iCustomTabsService0 = d0.a;
                    c c0 = new c();  // 初始化器: Landroid/support/customtabs/ICustomTabsCallback$Stub;-><init>()V
                    new Handler(Looper.getMainLooper());
                    l l0 = null;
                    try {
                        if(iCustomTabsService0.newSession(c0)) {
                            goto label_9;
                        }
                    }
                    catch(RemoteException unused_ex) {
                    }
                    CustomTabPrefetchHelper.session = l0;
                    CustomTabPrefetchHelper.lock.unlock();
                    return;
                label_9:
                    l0 = new l(iCustomTabsService0, c0, d0.b);
                    CustomTabPrefetchHelper.session = l0;
                }
            }
            CustomTabPrefetchHelper.lock.unlock();
        }
    }

    @NotNull
    public static final Companion Companion;
    @Nullable
    private static d client;
    @NotNull
    private static final ReentrantLock lock;
    @Nullable
    private static l session;

    static {
        CustomTabPrefetchHelper.Companion = new Companion(null);
        CustomTabPrefetchHelper.lock = new ReentrantLock();
    }

    @Nullable
    public static final l getPreparedSessionOnce() {
        return CustomTabPrefetchHelper.Companion.getPreparedSessionOnce();
    }

    public static final void mayLaunchUrl(@NotNull Uri uri0) {
        CustomTabPrefetchHelper.Companion.mayLaunchUrl(uri0);
    }

    @Override  // p.k
    public void onCustomTabsServiceConnected(@NotNull ComponentName componentName0, @NotNull d d0) {
        q.g(componentName0, "name");
        q.g(d0, "newClient");
        try {
            d0.a.warmup(0L);
        }
        catch(RemoteException unused_ex) {
        }
        CustomTabPrefetchHelper.client = d0;
        Companion.access$prepareSession(CustomTabPrefetchHelper.Companion);
    }

    @Override  // android.content.ServiceConnection
    public void onServiceDisconnected(@NotNull ComponentName componentName0) {
        q.g(componentName0, "componentName");
    }
}

