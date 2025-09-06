package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;

final class zzha extends BroadcastReceiver {
    private final zzpf zza;
    private boolean zzb;
    private boolean zzc;

    public zzha(zzpf zzpf0) {
        Preconditions.checkNotNull(zzpf0);
        this.zza = zzpf0;
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        zzpf zzpf0 = this.zza;
        zzpf0.zzu();
        String s = intent0.getAction();
        zzpf0.zzaV().zzk().zzb("NetworkBroadcastReceiver received action", s);
        if("android.net.conn.CONNECTIVITY_CHANGE".equals(s)) {
            boolean z = zzpf0.zzi().zzb();
            if(this.zzc != z) {
                this.zzc = z;
                zzpf0.zzaW().zzj(new zzgz(this, z));
            }
            return;
        }
        zzpf0.zzaV().zze().zzb("NetworkBroadcastReceiver received unknown action", s);
    }

    public final void zza() {
        zzpf zzpf0 = this.zza;
        zzpf0.zzu();
        zzpf0.zzaW().zzg();
        if(this.zzb) {
            return;
        }
        zzpf0.zzaY().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.zzc = zzpf0.zzi().zzb();
        zzpf0.zzaV().zzk().zzb("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzc));
        this.zzb = true;
    }

    public final void zzb() {
        zzpf zzpf0 = this.zza;
        zzpf0.zzu();
        zzpf0.zzaW().zzg();
        zzpf0.zzaW().zzg();
        if(!this.zzb) {
            return;
        }
        zzpf0.zzaV().zzk().zza("Unregistering connectivity change receiver");
        this.zzb = false;
        this.zzc = false;
        Context context0 = zzpf0.zzaY();
        try {
            context0.unregisterReceiver(this);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            this.zza.zzaV().zzb().zzb("Failed to unregister the network broadcast receiver", illegalArgumentException0);
        }
    }

    public final zzpf zzc() {
        return this.zza;
    }
}

