package com.iloen.melon.alarm;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU;
import java.util.Calendar;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import o8.c;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/alarm/AlarmPermissionSettingReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AlarmPermissionSettingReceiver extends BroadcastReceiver {
    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        PendingIntent pendingIntent0;
        c.d();
        Context context1 = Y.a(MelonAppBase.Companion);
        if(context1 != null) {
            long v = MelonSettingInfo.getMelonTimer();
            if(v > 0L && v > Calendar.getInstance().getTimeInMillis()) {
                if(TextUtils.isEmpty("com.iloen.melon.intent.action.PLAYBACK_STOP_TIMER")) {
                    LogU.Companion.w("AlarmTrigger", "getPendingBroadcastIntent() invalid parameter.");
                    pendingIntent0 = null;
                }
                else {
                    Intent intent1 = new Intent(context1, AlarmReceiver.class);
                    intent1.setAction("com.iloen.melon.intent.action.PLAYBACK_STOP_TIMER");
                    pendingIntent0 = PendingIntent.getBroadcast(context1, 0, intent1, 0x1C000000);
                    q.f(pendingIntent0, "getBroadcast(...)");
                }
                c.a(context1, pendingIntent0);
                c.e(context1, pendingIntent0, v);
            }
        }
    }
}

