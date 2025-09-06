package com.kakao.sdk.common.util;

import A3.c;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.List;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.d;
import p.k;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001A\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u001D\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014R\u001A\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\b0\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/kakao/sdk/common/util/KakaoCustomTabsClient;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", "", "resolveCustomTabsPackage", "(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;", "packageName", "", "isPackageNameChrome", "(Ljava/lang/String;)Z", "Landroid/content/ServiceConnection;", "openWithDefault", "(Landroid/content/Context;Landroid/net/Uri;)Landroid/content/ServiceConnection;", "Lie/H;", "open", "(Landroid/content/Context;Landroid/net/Uri;)V", "", "chromePackageNames", "[Ljava/lang/String;", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class KakaoCustomTabsClient {
    @NotNull
    public static final KakaoCustomTabsClient INSTANCE;
    @NotNull
    private static final String[] chromePackageNames;

    static {
        KakaoCustomTabsClient.INSTANCE = new KakaoCustomTabsClient();
        KakaoCustomTabsClient.chromePackageNames = new String[]{"com.android.chrome", "com.chrome.beta", "com.chrome.dev"};
    }

    private final boolean isPackageNameChrome(String s) {
        return n.Q(KakaoCustomTabsClient.chromePackageNames, s);
    }

    public final void open(@NotNull Context context0, @NotNull Uri uri0) {
        q.g(context0, "context");
        q.g(uri0, "uri");
        c c0 = new c(7, false);
        ((Intent)c0.b).putExtra("android.support.customtabs.extra.ENABLE_URLBAR_HIDING", true);
        ((Intent)c0.b).putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", 1);
        ea.c c1 = c0.a();
        Intent intent0 = (Intent)c1.b;
        intent0.setData(uri0);
        P1.c.startActivity(context0, intent0, ((Bundle)c1.c));
    }

    @Nullable
    public final ServiceConnection openWithDefault(@NotNull Context context0, @NotNull Uri uri0) {
        q.g(context0, "context");
        q.g(uri0, "uri");
        String s = this.resolveCustomTabsPackage(context0, uri0);
        if(s == null) {
            throw new UnsupportedOperationException();
        }
        SdkLog.Companion.d("Choosing " + s + " as custom tabs browser");
        ServiceConnection serviceConnection0 = new k() {
            @Override  // p.k
            public void onCustomTabsServiceConnected(@NotNull ComponentName componentName0, @NotNull d d0) {
                q.g(componentName0, "name");
                q.g(d0, "client");
                c c0 = new c(7, false);
                ((Intent)c0.b).putExtra("android.support.customtabs.extra.ENABLE_URLBAR_HIDING", true);
                ((Intent)c0.b).putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", 1);
                Intent intent0 = (Intent)c0.a().b;
                intent0.setData(s);
                intent0.setPackage(context0);
                this.$context.startActivity(intent0);
            }

            @Override  // android.content.ServiceConnection
            public void onServiceDisconnected(@Nullable ComponentName componentName0) {
                SdkLog.Companion.d("onServiceDisconnected: " + componentName0);
            }
        };
        return d.a(context0, s, ((k)serviceConnection0)) ? serviceConnection0 : null;
    }

    private final String resolveCustomTabsPackage(Context context0, Uri uri0) {
        String s3;
        Intent intent0 = new Intent("android.intent.action.VIEW", uri0);
        int v = Build.VERSION.SDK_INT;
        ResolveInfo resolveInfo0 = v < 33 ? context0.getPackageManager().resolveActivity(intent0, 0x10000) : a.e(context0.getPackageManager(), intent0, a.d());
        Intent intent1 = new Intent().setAction("android.support.customtabs.action.CustomTabsService");
        q.f(intent1, "Intent().setAction(Custo…N_CUSTOM_TABS_CONNECTION)");
        List list0 = v < 33 ? context0.getPackageManager().queryIntentServices(intent1, 0) : a.j(context0.getPackageManager(), intent1, a.m());
        q.f(list0, "if (Build.VERSION.SDK_IN…rviceIntent, 0)\n        }");
        String s = null;
        for(Object object0: list0) {
            ResolveInfo resolveInfo1 = (ResolveInfo)object0;
            if(s == null) {
                String s1 = resolveInfo1.serviceInfo.packageName;
                q.f(s1, "info.serviceInfo.packageName");
                if(this.isPackageNameChrome(s1)) {
                    s = resolveInfo1.serviceInfo.packageName;
                }
            }
            String s2 = resolveInfo1.serviceInfo.packageName;
            if(resolveInfo0 == null) {
                s3 = null;
            }
            else {
                ActivityInfo activityInfo0 = resolveInfo0.activityInfo;
                if(activityInfo0 != null) {
                    s3 = activityInfo0.packageName;
                }
            }
            if(q.b(s2, s3)) {
                if(resolveInfo0 == null) {
                    break;
                }
                ActivityInfo activityInfo1 = resolveInfo0.activityInfo;
                if(activityInfo1 == null) {
                    break;
                }
                return activityInfo1.packageName != null || s == null ? activityInfo1.packageName : s;
            }
            if(false) {
                break;
            }
        }
        return s == null ? null : s;
    }
}

