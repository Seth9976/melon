package o8;

import P4.a;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.alarm.AlarmReceiver;
import com.iloen.melon.fragments.settings.alarm.AlarmPermissionHelper.Companion;
import com.iloen.melon.fragments.settings.alarm.AlarmPermissionHelper;
import com.iloen.melon.utils.DateUtils;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import java.util.Calendar;
import k8.Y;
import k8.t;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

public final class c {
    static {
    }

    public static final void a(Context context0, PendingIntent pendingIntent0) {
        if(context0 != null && pendingIntent0 != null) {
            Object object0 = context0.getSystemService("alarm");
            AlarmManager alarmManager0 = object0 instanceof AlarmManager ? ((AlarmManager)object0) : null;
            if(alarmManager0 != null) {
                alarmManager0.cancel(pendingIntent0);
            }
            return;
        }
        LogU.Companion.w("AlarmTrigger", "cancelAlarm() invalid parameter.");
    }

    public static void b(int v) {
        c.a(Y.a(MelonAppBase.Companion), c.c(v));
    }

    public static PendingIntent c(int v) {
        Context context0 = Y.a(MelonAppBase.Companion);
        Intent intent0 = new Intent(context0, AlarmReceiver.class);
        intent0.putExtra("id", v);
        intent0.setAction("com.iloen.melon.intent.action.AUTO_PLAY_TIMER");
        PendingIntent pendingIntent0 = PendingIntent.getBroadcast(context0, v, intent0, 0x1C000000);
        q.f(pendingIntent0, "getBroadcast(...)");
        return pendingIntent0;
    }

    public static final void d() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new b(2, null), 3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
    }

    public static final boolean e(Context context0, PendingIntent pendingIntent0, long v) {
        if(context0 != null && pendingIntent0 != null) {
            if(v < System.currentTimeMillis()) {
                LogU.Companion.w("AlarmTrigger", "setExactAlarm() >> invalid triggerAtTime.");
                return false;
            }
            Object object0 = context0.getSystemService("alarm");
            AlarmManager alarmManager0 = object0 instanceof AlarmManager ? ((AlarmManager)object0) : null;
            if(alarmManager0 != null) {
                if(!alarmManager0.canScheduleExactAlarms()) {
                    ToastManager.show(0x7F1307E6);  // string:permission_alarm_message_toast "알람 및 리마인더\n권한을 허용해주세요"
                    return false;
                }
                String s = DateUtils.convertDateFormat(v);
                alarmManager0.setExactAndAllowWhileIdle(0, v, pendingIntent0);
                Y.w("setExactAlarm() >> setExactAndAllowWhileIdle() triggerAtTime: ", s, LogU.Companion, "AlarmTrigger");
                return true;
            }
            return false;
        }
        LogU.Companion.w("AlarmTrigger", "setExactAlarm() >> invalid parameter.");
        return false;
    }

    public static boolean f(long v, int v1, boolean z) {
        String s;
        c.b(v1);
        boolean z1 = c.e(Y.a(MelonAppBase.Companion), c.c(v1), v);
        if(z1 && z) {
            StringBuilder stringBuilder0 = new StringBuilder();
            long[] arr_v = new long[4];
            try {
                long v2 = (v - System.currentTimeMillis()) / 1000L;
                String[] arr_s = t.a().getContext().getResources().getStringArray(0x7F030005);  // array:auto_play_time_array
                q.f(arr_s, "getStringArray(...)");
                arr_v[0] = v2 / 86400L;
                arr_v[1] = v2 % 86400L / 3600L;
                long v3 = v2 % 86400L % 3600L;
                arr_v[2] = v3 / 60L;
                arr_v[3] = v3 % 60L;
                for(int v4 = 0; v4 < 4; ++v4) {
                    long v5 = arr_v[v4];
                    if(v5 > 0L) {
                        stringBuilder0.append(v5);
                        stringBuilder0.append(arr_s[v4]);
                        if(v4 != 3) {
                            stringBuilder0.append(" ");
                        }
                    }
                }
                if(stringBuilder0.length() > 0) {
                    MelonAppBase.Companion.getClass();
                    stringBuilder0.append("후에 알람이 울립니다.");
                }
                s = stringBuilder0.toString();
                q.d(s);
            }
            catch(Exception exception0) {
                LogU.Companion.e("AlarmTrigger", exception0.toString());
                MelonAppBase.Companion.getClass();
                s = "알람이 설정 되었습니다.";
                q.d("알람이 설정 되었습니다.");
            }
            ToastManager.show(s);
        }
        return z1;
    }

    public static final void g(Context context0, int v, boolean z) {
        PendingIntent pendingIntent0 = null;
        Class class0 = AlarmReceiver.class;
        if(z) {
            if(Companion.canScheduleExactAlarms$default(AlarmPermissionHelper.Companion, context0, null, null, 6, null)) {
                Calendar calendar0 = Calendar.getInstance();
                calendar0.setTimeInMillis(System.currentTimeMillis());
                long v1 = calendar0.getTimeInMillis();
                long v2 = a.a * ((long)v) + v1;
                MelonSettingInfo.setMelonTimer(v2);
                if(context0 == null || TextUtils.isEmpty("com.iloen.melon.intent.action.PLAYBACK_STOP_TIMER")) {
                    LogU.Companion.w("AlarmTrigger", "getPendingBroadcastIntent() invalid parameter.");
                }
                else {
                    Intent intent0 = new Intent(context0, class0);
                    intent0.setAction("com.iloen.melon.intent.action.PLAYBACK_STOP_TIMER");
                    pendingIntent0 = PendingIntent.getBroadcast(context0, 0, intent0, 0x1C000000);
                    q.f(pendingIntent0, "getBroadcast(...)");
                }
                c.a(context0, pendingIntent0);
                c.e(context0, pendingIntent0, v2);
            }
            return;
        }
        MelonSettingInfo.setMelonTimer(0L);
        if(context0 == null || TextUtils.isEmpty("com.iloen.melon.intent.action.PLAYBACK_STOP_TIMER")) {
            LogU.Companion.w("AlarmTrigger", "getPendingBroadcastIntent() invalid parameter.");
        }
        else {
            Intent intent1 = new Intent(context0, class0);
            intent1.setAction("com.iloen.melon.intent.action.PLAYBACK_STOP_TIMER");
            pendingIntent0 = PendingIntent.getBroadcast(context0, 0, intent1, 0x1C000000);
            q.f(pendingIntent0, "getBroadcast(...)");
        }
        c.a(context0, pendingIntent0);
    }
}

