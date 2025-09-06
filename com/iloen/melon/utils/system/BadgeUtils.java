package com.iloen.melon.utils.system;

import Tf.v;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.iloen.melon.utils.log.LogU;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001J!\u0010\u0007\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/iloen/melon/utils/system/BadgeUtils;", "", "Landroid/content/Context;", "context", "", "count", "Lie/H;", "setBadge", "(Landroid/content/Context;I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class BadgeUtils {
    public static final int $stable;
    @NotNull
    public static final BadgeUtils INSTANCE;
    public static final String[] a;

    static {
        BadgeUtils.INSTANCE = new BadgeUtils();  // 初始化器: Ljava/lang/Object;-><init>()V
        BadgeUtils.a = new String[]{"android.intent.action.BADGE_COUNT_UPDATE", "com.sec.intent.action.BADGE_COUNT_UPDATE"};
        BadgeUtils.$stable = 8;
    }

    public static final void setBadge(@Nullable Context context0, int v) {
        if(context0 == null) {
            LogU.Companion.w("BadgeUtils", "context is null on setBadge()");
            return;
        }
        for(int v1 = 0; v1 < 2; ++v1) {
            Intent intent0 = new Intent(BadgeUtils.a[v1]);
            BadgeUtils.INSTANCE.getClass();
            String s = context0.getApplicationInfo().packageName;
            q.d(s);
            PackageManager packageManager0 = context0.getPackageManager();
            Intent intent1 = new Intent("android.intent.action.MAIN");
            intent1.addCategory("android.intent.category.LAUNCHER");
            CharSequence charSequence0 = null;
            try {
                List list0 = null;
                list0 = packageManager0.queryIntentActivities(intent1, 0x10000);
            }
            catch(Exception unused_ex) {
            }
            if(list0 == null) {
                LogU.Companion.w("BadgeUtils", "getLauncherClassName() invalid infos");
            }
            else {
                for(Object object0: list0) {
                    ResolveInfo resolveInfo0 = (ResolveInfo)object0;
                    String s1 = resolveInfo0.activityInfo.applicationInfo.packageName;
                    if(v.j0(s1, s, true)) {
                        charSequence0 = resolveInfo0.activityInfo.name;
                        LogU.Companion.v("BadgeUtils", "getLauncherClassName() pkgName:" + s1);
                        break;
                    }
                    if(false) {
                        break;
                    }
                }
            }
            if(TextUtils.isEmpty(charSequence0)) {
                LogU.Companion.w("BadgeUtils", "notifyUpdate() invalid launcherClassName");
            }
            else {
                intent0.putExtra("badge_count", v);
                intent0.putExtra("badge_count_package_name", s);
                intent0.putExtra("badge_count_class_name", ((String)charSequence0));
                context0.sendBroadcast(intent0);
            }
        }
    }
}

