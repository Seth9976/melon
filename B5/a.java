package b5;

import U4.w;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker.broadcastReceiver.1;

public final class a extends e {
    public final BroadcastReceiverConstraintTracker.broadcastReceiver.1 f;
    public final int g;

    public a(Context context0, f5.a a0, int v) {
        this.g = v;
        super(context0, a0);
        this.f = new BroadcastReceiverConstraintTracker.broadcastReceiver.1(this);
    }

    @Override  // b5.e
    public final Object a() {
        switch(this.g) {
            case 0: {
                IntentFilter intentFilter1 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
                Intent intent1 = this.b.registerReceiver(null, intentFilter1);
                if(intent1 == null) {
                    w.e().c("WM-BatteryChrgTracker", "getInitialState - null intent received");
                    return false;
                }
                switch(intent1.getIntExtra("status", -1)) {
                    case 2: 
                    case 5: {
                        return true;
                    }
                    default: {
                        return false;
                    }
                }
            }
            case 1: {
                boolean z1 = true;
                IntentFilter intentFilter2 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
                Intent intent2 = this.b.registerReceiver(null, intentFilter2);
                if(intent2 == null) {
                    w.e().c("WM-BatteryNotLowTracker", "getInitialState - null intent received");
                    return false;
                }
                if(intent2.getIntExtra("status", -1) != 1 && ((float)intent2.getIntExtra("level", -1)) / ((float)intent2.getIntExtra("scale", -1)) <= 0.15f) {
                    z1 = false;
                }
                return Boolean.valueOf(z1);
            }
            default: {
                IntentFilter intentFilter0 = this.e();
                Intent intent0 = this.b.registerReceiver(null, intentFilter0);
                boolean z = true;
                if(intent0 != null && intent0.getAction() != null) {
                    String s = intent0.getAction();
                    if(s == null || s.hashCode() != -730838620 || !s.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                        z = false;
                    }
                }
                return Boolean.valueOf(z);
            }
        }
    }

    @Override  // b5.e
    public final void c() {
        w.e().a("WM-BrdcstRcvrCnstrntTrc", this.getClass().getSimpleName() + ": registering receiver");
        IntentFilter intentFilter0 = this.e();
        this.b.registerReceiver(this.f, intentFilter0);
    }

    @Override  // b5.e
    public final void d() {
        w.e().a("WM-BrdcstRcvrCnstrntTrc", this.getClass().getSimpleName() + ": unregistering receiver");
        this.b.unregisterReceiver(this.f);
    }

    public final IntentFilter e() {
        switch(this.g) {
            case 0: {
                IntentFilter intentFilter1 = new IntentFilter();
                intentFilter1.addAction("android.os.action.CHARGING");
                intentFilter1.addAction("android.os.action.DISCHARGING");
                return intentFilter1;
            }
            case 1: {
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.BATTERY_OKAY");
                intentFilter2.addAction("android.intent.action.BATTERY_LOW");
                return intentFilter2;
            }
            default: {
                IntentFilter intentFilter0 = new IntentFilter();
                intentFilter0.addAction("android.intent.action.DEVICE_STORAGE_OK");
                intentFilter0.addAction("android.intent.action.DEVICE_STORAGE_LOW");
                return intentFilter0;
            }
        }
    }
}

