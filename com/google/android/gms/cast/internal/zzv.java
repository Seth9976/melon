package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.Cast.MessageReceivedCallback;

final class zzv implements Runnable {
    final zzx zza;
    final String zzb;
    final String zzc;

    public zzv(zzw zzw0, zzx zzx0, String s, String s1) {
        this.zza = zzx0;
        this.zzb = s;
        this.zzc = s1;
        super();
    }

    @Override
    public final void run() {
        MessageReceivedCallback cast$MessageReceivedCallback0;
        synchronized(zzx.zzA(this.zza)) {
            cast$MessageReceivedCallback0 = (MessageReceivedCallback)zzx.zzA(this.zza).get(this.zzb);
        }
        if(cast$MessageReceivedCallback0 != null) {
            cast$MessageReceivedCallback0.onMessageReceived(zzx.zzv(this.zza), this.zzb, this.zzc);
            return;
        }
        zzx.zzw().d("Discarded message for unknown namespace \'%s\'", new Object[]{this.zzb});
    }
}

