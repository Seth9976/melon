package androidx.work.impl.constraints.trackers;

import U4.w;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import b5.a;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"androidx/work/impl/constraints/trackers/BroadcastReceiverConstraintTracker$broadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class BroadcastReceiverConstraintTracker.broadcastReceiver.1 extends BroadcastReceiver {
    public final a a;

    public BroadcastReceiverConstraintTracker.broadcastReceiver.1(a a0) {
        this.a = a0;
        super();
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        q.g(context0, "context");
        q.g(intent0, "intent");
        a a0 = this.a;
        switch(a0.g) {
            case 0: {
                String s1 = intent0.getAction();
                if(s1 != null) {
                    w.e().a("WM-BatteryChrgTracker", "Received " + s1);
                    switch(s1) {
                        case "android.intent.action.ACTION_POWER_CONNECTED": {
                            a0.b(Boolean.TRUE);
                            return;
                        }
                        case "android.intent.action.ACTION_POWER_DISCONNECTED": {
                            a0.b(Boolean.FALSE);
                            return;
                        }
                        case "android.os.action.CHARGING": {
                            a0.b(Boolean.TRUE);
                            return;
                        }
                        case "android.os.action.DISCHARGING": {
                            a0.b(Boolean.FALSE);
                            return;
                        }
                        default: {
                            return;
                        }
                    }
                }
                break;
            }
            case 1: {
                if(intent0.getAction() != null) {
                    w.e().a("WM-BatteryNotLowTracker", "Received " + intent0.getAction());
                    String s2 = intent0.getAction();
                    if(s2 != null) {
                        switch(s2) {
                            case "android.intent.action.BATTERY_LOW": {
                                a0.b(Boolean.FALSE);
                                return;
                            }
                            case "android.intent.action.BATTERY_OKAY": {
                                a0.b(Boolean.TRUE);
                                return;
                            }
                            default: {
                                return;
                            }
                        }
                    }
                }
                break;
            }
            default: {
                if(intent0.getAction() != null) {
                    w.e().a("WM-StorageNotLowTracker", "Received " + intent0.getAction());
                    String s = intent0.getAction();
                    if(s != null) {
                        switch(s) {
                            case "android.intent.action.DEVICE_STORAGE_LOW": {
                                a0.b(Boolean.FALSE);
                                return;
                            }
                            case "android.intent.action.DEVICE_STORAGE_OK": {
                                a0.b(Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }
    }
}

