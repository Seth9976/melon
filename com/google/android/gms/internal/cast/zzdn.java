package com.google.android.gms.internal.cast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class zzdn extends BroadcastReceiver {
    final zzdq zza;

    public zzdn(zzdq zzdq0, zzdp zzdp0) {
        this.zza = zzdq0;
        super();
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        String s = intent0.getAction();
        if(s != null) {
            if(s.equals("android.intent.action.SCREEN_ON")) {
                zzdq.zze(this.zza);
                return;
            }
            if(s.equals("android.intent.action.SCREEN_OFF")) {
                zzdq.zzg(this.zza);
            }
        }
    }
}

