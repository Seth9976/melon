package com.iloen.melon.fragments.settings.alarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.l1;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventConfirmDialog;
import com.iloen.melon.fragments.detail.viewholder.r;
import com.iloen.melon.utils.system.ToastManager;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/fragments/settings/alarm/AlarmPermissionHelper;", "", "<init>", "()V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AlarmPermissionHelper {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ=\u0010\r\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\f\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0007¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/settings/alarm/AlarmPermissionHelper$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "isNeedAllowPermission", "(Landroid/content/Context;)Z", "Lkotlin/Function0;", "Lie/H;", "onPositiveButtonClick", "onNegativeButtonClick", "canScheduleExactAlarms", "(Landroid/content/Context;Lwe/a;Lwe/a;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static void a(a a0, a a1, Context context0, DialogInterface dialogInterface0, int v) {
            Companion.canScheduleExactAlarms$lambda$2$lambda$1(a0, a1, context0, dialogInterface0, v);
        }

        public final boolean canScheduleExactAlarms(@Nullable Context context0) {
            return Companion.canScheduleExactAlarms$default(this, context0, null, null, 6, null);
        }

        public final boolean canScheduleExactAlarms(@Nullable Context context0, @Nullable a a0) {
            return Companion.canScheduleExactAlarms$default(this, context0, a0, null, 4, null);
        }

        public final boolean canScheduleExactAlarms(@Nullable Context context0, @Nullable a a0, @Nullable a a1) {
            if(context0 != null && AlarmPermissionHelper.Companion.isNeedAllowPermission(context0)) {
                r r0 = new r(a0, a1, context0, 1);
                EventBusHelper.post(new EventConfirmDialog("안내", l1.m("안내", "getString(...)", Y.a(MelonAppBase.Companion), 0x7F1307E5, "getString(...)"), r0));  // string:permission_alarm_message "알람 및 예약정지 기능을 사용하려면 멜론앱에서 알람 및 리마인더\n권한을 허용해주세요"
                if(!(context0 instanceof Activity)) {
                    ToastManager.show(0x7F1307E6);  // string:permission_alarm_message_toast "알람 및 리마인더\n권한을 허용해주세요"
                }
                return false;
            }
            return true;
        }

        public static boolean canScheduleExactAlarms$default(Companion alarmPermissionHelper$Companion0, Context context0, a a0, a a1, int v, Object object0) {
            if((v & 2) != 0) {
                a0 = null;
            }
            if((v & 4) != 0) {
                a1 = null;
            }
            return alarmPermissionHelper$Companion0.canScheduleExactAlarms(context0, a0, a1);
        }

        private static final void canScheduleExactAlarms$lambda$2$lambda$1(a a0, a a1, Context context0, DialogInterface dialogInterface0, int v) {
            if(-1 == v) {
                Intent intent0 = new Intent("android.settings.REQUEST_SCHEDULE_EXACT_ALARM");
                intent0.addFlags(0x10000000);
                intent0.setData(Uri.parse("package:com.iloen.melon"));
                context0.startActivity(intent0);
                if(a0 != null) {
                    a0.invoke();
                }
            }
            else if(-2 == v && a1 != null) {
                a1.invoke();
            }
            dialogInterface0.dismiss();
        }

        private final boolean isNeedAllowPermission(Context context0) {
            Object object0 = context0.getSystemService("alarm");
            AlarmManager alarmManager0 = object0 instanceof AlarmManager ? ((AlarmManager)object0) : null;
            return alarmManager0 != null && !alarmManager0.canScheduleExactAlarms();
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;

    static {
        AlarmPermissionHelper.Companion = new Companion(null);
    }

    public static final boolean canScheduleExactAlarms(@Nullable Context context0) {
        return AlarmPermissionHelper.Companion.canScheduleExactAlarms(context0);
    }

    public static final boolean canScheduleExactAlarms(@Nullable Context context0, @Nullable a a0) {
        return AlarmPermissionHelper.Companion.canScheduleExactAlarms(context0, a0);
    }

    public static final boolean canScheduleExactAlarms(@Nullable Context context0, @Nullable a a0, @Nullable a a1) {
        return AlarmPermissionHelper.Companion.canScheduleExactAlarms(context0, a0, a1);
    }
}

