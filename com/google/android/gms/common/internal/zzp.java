package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;
import java.util.Objects;

final class zzp implements Handler.Callback {
    final zzq zza;

    public zzp(zzq zzq0, byte[] arr_b) {
        Objects.requireNonNull(zzq0);
        this.zza = zzq0;
        super();
    }

    @Override  // android.os.Handler$Callback
    public final boolean handleMessage(Message message0) {
        switch(message0.what) {
            case 0: {
                zzq zzq0 = this.zza;
                HashMap hashMap0 = zzq0.zzf();
                synchronized(hashMap0) {
                    zzn zzn0 = (zzn)message0.obj;
                    zzo zzo0 = (zzo)zzq0.zzf().get(zzn0);
                    if(zzo0 != null && zzo0.zzg()) {
                        if(zzo0.zzd()) {
                            zzo0.zza("GmsClientSupervisor");
                        }
                        zzq0.zzf().remove(zzn0);
                    }
                    return true;
                }
            }
            case 1: {
                HashMap hashMap1 = this.zza.zzf();
                synchronized(hashMap1) {
                    zzn zzn1 = (zzn)message0.obj;
                    zzo zzo1 = (zzo)this.zza.zzf().get(zzn1);
                    if(zzo1 != null && zzo1.zze() == 3) {
                        Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + zzn1, new Exception());
                        ComponentName componentName0 = zzo1.zzi() == null ? zzn1.zzc() : zzo1.zzi();
                        if(componentName0 == null) {
                            String s = zzn1.zzb();
                            Preconditions.checkNotNull(s);
                            componentName0 = new ComponentName(s, "unknown");
                        }
                        zzo1.onServiceDisconnected(componentName0);
                    }
                    return true;
                }
            }
            default: {
                return false;
            }
        }
    }
}

