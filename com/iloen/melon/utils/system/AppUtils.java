package com.iloen.melon.utils.system;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.view.accessibility.AccessibilityManager;
import androidx.fragment.app.I;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.log.LogU;
import java.util.ArrayList;
import java.util.List;
import je.w;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001A\u00020\u00072\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0003\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0011\u001A\u00020\u000BH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0017\u001A\u00020\u000E2\b\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010\u0016\u001A\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00070\u0019¢\u0006\u0004\b\u001A\u0010\u001B¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/utils/system/AppUtils;", "", "Landroid/content/Context;", "context", "", "getVersionCode", "(Landroid/content/Context;)I", "", "getVersionName", "(Landroid/content/Context;)Ljava/lang/String;", "strPackageName", "", "checkExistApplication", "(Landroid/content/Context;Ljava/lang/String;)Z", "Lie/H;", "restart", "(Landroid/content/Context;)V", "isAccessibilityTalkbackOn", "()Z", "Landroidx/fragment/app/I;", "fragment", "Landroid/net/Uri;", "uri", "notifyContentChange", "(Landroidx/fragment/app/I;Landroid/net/Uri;)V", "", "getAccessibilityTalkbackOnInfos", "()Ljava/util/List;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AppUtils {
    public static final int $stable;
    @NotNull
    public static final AppUtils INSTANCE;

    static {
        AppUtils.INSTANCE = new AppUtils();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static final boolean checkExistApplication(@NotNull Context context0, @NotNull String s) {
        PackageInfo packageInfo0;
        q.g(context0, "context");
        q.g(s, "strPackageName");
        try {
            packageInfo0 = context0.getPackageManager().getPackageInfo(s, 0);
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            packageManager$NameNotFoundException0.printStackTrace();
            packageInfo0 = null;
        }
        if(packageInfo0 != null) {
            LogU.Companion.i("AppUtils", "checkExistApplication() true");
            return true;
        }
        LogU.Companion.i("AppUtils", "checkExistApplication() false");
        return false;
    }

    @NotNull
    public final List getAccessibilityTalkbackOnInfos() {
        MelonAppBase.Companion.getClass();
        Object object0 = t.a().getContext().getSystemService("accessibility");
        q.e(object0, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        if(((AccessibilityManager)object0).isEnabled()) {
            List list0 = ((AccessibilityManager)object0).getEnabledAccessibilityServiceList(1);
            q.f(list0, "getEnabledAccessibilityServiceList(...)");
            List list1 = new ArrayList(je.q.Q(10, list0));
            for(Object object1: list0) {
                ((ArrayList)list1).add(((AccessibilityServiceInfo)object1).toString());
            }
            return list1;
        }
        return w.a;
    }

    public static final int getVersionCode(@Nullable Context context0) {
        if(context0 != null) {
            try {
                return (int)context0.getPackageManager().getPackageInfo("com.iloen.melon", 0).getLongVersionCode();
            }
            catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            }
            catch(NullPointerException nullPointerException0) {
                LogU.Companion.e("AppUtils", "getVersionCode() " + nullPointerException0);
                return 0;
            }
            LogU.Companion.e("AppUtils", "getVersionCode() " + packageManager$NameNotFoundException0);
            return 0;
        }
        return 0;
    }

    @NotNull
    public static final String getVersionName(@Nullable Context context0) {
        if(context0 != null) {
            try {
                String s = context0.getPackageManager().getPackageInfo("com.iloen.melon", 0).versionName;
                q.d(s);
                return s;
            }
            catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                LogU.Companion.e("AppUtils", "getVersionName() " + packageManager$NameNotFoundException0);
                return "";
            }
            catch(NullPointerException nullPointerException0) {
                LogU.Companion.e("AppUtils", "getVersionName() " + nullPointerException0);
                return "";
            }
        }
        return "";
    }

    public static final boolean isAccessibilityTalkbackOn() {
        MelonAppBase.Companion.getClass();
        Object object0 = t.a().getContext().getSystemService("accessibility");
        q.e(object0, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        if(((AccessibilityManager)object0).isEnabled()) {
            List list0 = ((AccessibilityManager)object0).getEnabledAccessibilityServiceList(1);
            q.f(list0, "getEnabledAccessibilityServiceList(...)");
            return !list0.isEmpty();
        }
        return false;
    }

    public final void notifyContentChange(@Nullable I i0, @Nullable Uri uri0) {
        if(i0 != null && uri0 != null) {
            Context context0 = i0.getContext();
            if(context0 != null) {
                ContentResolver contentResolver0 = context0.getContentResolver();
                if(contentResolver0 != null) {
                    contentResolver0.notifyChange(uri0, null);
                }
            }
        }
    }

    public static final void restart(@NotNull Context context0) {
        q.g(context0, "context");
        Intent intent0 = context0.getPackageManager().getLaunchIntentForPackage("com.iloen.melon");
        if(intent0 != null) {
            context0.startActivity(Intent.makeRestartActivityTask(intent0.getComponent()));
        }
        Runtime.getRuntime().exit(0);
    }
}

