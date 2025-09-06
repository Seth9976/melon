package com.google.android.gms.cast.internal;

import android.os.Handler;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.cast.zzet;
import java.util.concurrent.atomic.AtomicReference;

final class zzw extends zzai {
    private final AtomicReference zza;
    private final Handler zzb;

    public zzw(zzx zzx0) {
        this.zza = new AtomicReference(zzx0);
        this.zzb = new zzet(zzx0.getLooper());
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzb(ApplicationMetadata applicationMetadata0, String s, String s1, boolean z) {
        zzx zzx0 = (zzx)this.zza.get();
        if(zzx0 == null) {
            return;
        }
        zzx0.zzh = applicationMetadata0;
        zzx0.zzy = applicationMetadata0.getApplicationId();
        zzx0.zzz = s1;
        zzx0.zzo = s;
        synchronized(zzx.zzf) {
            if(zzx0.zzC != null) {
                zzx0.zzC.setResult(new zzr(new Status(0), applicationMetadata0, s, s1, z));
                zzx.zzF(zzx0, null);
            }
        }
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzc(int v) {
        zzx zzx0 = (zzx)this.zza.get();
        if(zzx0 == null) {
            return;
        }
        zzx0.zzR(v);
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzd(int v) {
        zzx zzx0 = (zzx)this.zza.get();
        if(zzx0 != null) {
            zzx.zzD(zzx0, null);
            zzx.zzE(zzx0, null);
            zzx.zzK(zzx0, v);
            if(zzx.zzu(zzx0) != null) {
                zzs zzs0 = new zzs(this, zzx0, v);
                this.zzb.post(zzs0);
            }
        }
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zze(int v) {
        zzx zzx0 = (zzx)this.zza.get();
        if(zzx0 == null) {
            return;
        }
        zzx.zzK(zzx0, v);
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzf(zza zza0) {
        zzx zzx0 = (zzx)this.zza.get();
        if(zzx0 == null) {
            return;
        }
        zzx.zzw().d("onApplicationStatusChanged", new Object[0]);
        zzu zzu0 = new zzu(this, zzx0, zza0);
        this.zzb.post(zzu0);
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzg(int v) {
        zzx zzx0 = (zzx)this.zza.get();
        if(zzx0 == null) {
            return;
        }
        zzx.zzK(zzx0, v);
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzh(String s, byte[] arr_b) {
        if(((zzx)this.zza.get()) == null) {
            return;
        }
        zzx.zzw().d("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", new Object[]{s, ((int)arr_b.length)});
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzi(int v) {
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzj(zzac zzac0) {
        zzx zzx0 = (zzx)this.zza.get();
        if(zzx0 == null) {
            return;
        }
        zzx.zzw().d("onDeviceStatusChanged", new Object[0]);
        zzt zzt0 = new zzt(this, zzx0, zzac0);
        this.zzb.post(zzt0);
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzk(int v) {
        zzx zzx0 = this.zzq();
        if(zzx0 != null) {
            zzx.zzw().d("ICastDeviceControllerListener.onDisconnected: %d", new Object[]{v});
            if(v != 0) {
                zzx0.triggerConnectionSuspended(2);
            }
        }
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzl(String s, long v) {
        zzx zzx0 = (zzx)this.zza.get();
        if(zzx0 == null) {
            return;
        }
        zzx.zzJ(zzx0, v, 0);
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzm(String s, long v, int v1) {
        zzx zzx0 = (zzx)this.zza.get();
        if(zzx0 == null) {
            return;
        }
        zzx.zzJ(zzx0, v, v1);
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzn(String s, double f, boolean z) {
        zzx.zzw().d("Deprecated callback: \"onStatusreceived\"", new Object[0]);
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzo(int v) {
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzp(String s, String s1) {
        zzx zzx0 = (zzx)this.zza.get();
        if(zzx0 == null) {
            return;
        }
        zzx.zzw().d("Receive (type=text, ns=%s) %s", new Object[]{s, s1});
        zzv zzv0 = new zzv(this, zzx0, s, s1);
        this.zzb.post(zzv0);
    }

    public final zzx zzq() {
        zzx zzx0 = (zzx)this.zza.getAndSet(null);
        if(zzx0 == null) {
            return null;
        }
        zzx0.zzY();
        return zzx0;
    }

    public final boolean zzr() {
        return this.zza.get() == null;
    }
}

