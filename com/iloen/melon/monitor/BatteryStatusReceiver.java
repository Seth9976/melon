package com.iloen.melon.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.iloen.melon.utils.log.BatteryFileLog;
import com.iloen.melon.utils.log.LogU;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/monitor/BatteryStatusReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class BatteryStatusReceiver extends BroadcastReceiver {
    public long a;
    public int b;

    public BatteryStatusReceiver() {
        this.a = System.currentTimeMillis();
        this.b = 16;
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        q.g(context0, "context");
        q.g(intent0, "intent");
        int v = intent0.getIntExtra("level", 0);
        long v1 = System.currentTimeMillis();
        LogU.Companion.d("BatteryStatusReceiver", "onReceive() >> cnt: " + this.b + ", batteryLevel: " + v);
        if(this.a > 0L && v1 - this.a > 1800000L) {
            try {
                BatteryFileLog.INSTANCE.write("=> Battery: " + v);
            }
            catch(Exception exception0) {
                LogU.Companion.w("BatteryStatusReceiver", "saveBatteryInfo() >> Err: " + exception0);
            }
            finally {
                --this.b;
            }
            this.a = v1;
            if(this.b < 1) {
                LogU.Companion.d("BatteryStatusReceiver", "onReceive() >> Logging Finished");
                context0.unregisterReceiver(this);
            }
        }
    }
}

