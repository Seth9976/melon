package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import b3.Z;
import com.google.android.gms.internal.measurement.zzql;

public final class zzw extends BroadcastReceiver {
    private final zzib zza;

    public zzw(zzib zzib0) {
        this.zza = zzib0;
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        if(intent0 == null) {
            Z.A(this.zza, "App receiver called with null intent");
            return;
        }
        String s = intent0.getAction();
        if(s == null) {
            Z.A(this.zza, "App receiver called with null action");
            return;
        }
        switch(s) {
            case "com.google.android.gms.measurement.BATCHES_AVAILABLE": {
                this.zza.zzaV().zzk().zza("[sgtm] App Receiver notified batches are available");
                this.zza.zzaW().zzj(() -> this.zza.zzx().zzh(((long)(((Long)zzfx.zzC.zzb(null))))));
                return;
            }
            case "com.google.android.gms.measurement.TRIGGERS_AVAILABLE": {
                zzib zzib0 = this.zza;
                zzql.zza();
                if(!zzib0.zzc().zzp(null, zzfx.zzaQ)) {
                    return;
                }
                zzib0.zzaV().zzk().zza("App receiver notified triggers are available");
                zzib0.zzaW().zzj(new zzu(zzib0));
                return;
            }
            default: {
                Z.A(this.zza, "App receiver called with unknown action");
            }
        }
    }

    // 检测为 Lambda 实现
    public final void zza() [...]
}

