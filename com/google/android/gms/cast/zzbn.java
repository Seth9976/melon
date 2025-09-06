package com.google.android.gms.cast;

public final class zzbn implements Runnable {
    public final zzbq zza;
    public final String zzb;
    public final String zzc;

    public zzbn(zzbq zzbq0, String s, String s1) {
        this.zza = zzbq0;
        this.zzb = s;
        this.zzc = s1;
    }

    @Override
    public final void run() {
        MessageReceivedCallback cast$MessageReceivedCallback0;
        zzbq zzbq0 = this.zza;
        String s = this.zzb;
        synchronized(zzbq0.zza.zze) {
            cast$MessageReceivedCallback0 = (MessageReceivedCallback)zzbq0.zza.zze.get(s);
        }
        if(cast$MessageReceivedCallback0 != null) {
            cast$MessageReceivedCallback0.onMessageReceived(zzbr.zzq(zzbq0.zza), s, this.zzc);
            return;
        }
        zzbr.zzr().d("Discarded message for unknown namespace \'%s\'", new Object[]{s});
    }
}

