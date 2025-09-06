package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.common.zzg;
import com.iloen.melon.utils.a;
import java.util.Objects;

final class zzb extends zzg {
    final BaseGmsClient zza;

    public zzb(BaseGmsClient baseGmsClient0, Looper looper0) {
        Objects.requireNonNull(baseGmsClient0);
        this.zza = baseGmsClient0;
        super(looper0);
    }

    @Override  // android.os.Handler
    public final void handleMessage(Message message0) {
        BaseGmsClient baseGmsClient0 = this.zza;
        if(baseGmsClient0.zzd.get() != message0.arg1) {
            if(zzb.zzb(message0)) {
                zzb.zza(message0);
            }
            return;
        }
        if(message0.what != 1 && message0.what != 4 && message0.what != 7 && message0.what != 5 || baseGmsClient0.isConnecting()) {
            PendingIntent pendingIntent0 = null;
            switch(message0.what) {
                case 2: {
                    if(!baseGmsClient0.isConnected()) {
                        zzb.zza(message0);
                        return;
                    }
                    break;
                }
                case 3: {
                    Object object0 = message0.obj;
                    if(object0 instanceof PendingIntent) {
                        pendingIntent0 = (PendingIntent)object0;
                    }
                    ConnectionResult connectionResult2 = new ConnectionResult(message0.arg2, pendingIntent0);
                    baseGmsClient0.zzc.onReportServiceBinding(connectionResult2);
                    baseGmsClient0.onConnectionFailed(connectionResult2);
                    return;
                }
                case 4: {
                    baseGmsClient0.zzn(new ConnectionResult(message0.arg2));
                    if(baseGmsClient0.zzg() && !baseGmsClient0.zzo()) {
                        baseGmsClient0.zzd(3, null);
                        return;
                    }
                    ConnectionResult connectionResult0 = baseGmsClient0.zzm() == null ? new ConnectionResult(8) : baseGmsClient0.zzm();
                    baseGmsClient0.zzc.onReportServiceBinding(connectionResult0);
                    baseGmsClient0.onConnectionFailed(connectionResult0);
                    return;
                }
                case 5: {
                    ConnectionResult connectionResult1 = baseGmsClient0.zzm() == null ? new ConnectionResult(8) : baseGmsClient0.zzm();
                    baseGmsClient0.zzc.onReportServiceBinding(connectionResult1);
                    baseGmsClient0.onConnectionFailed(connectionResult1);
                    return;
                }
                case 6: {
                    baseGmsClient0.zzd(5, null);
                    if(baseGmsClient0.zzk() != null) {
                        baseGmsClient0.zzk().onConnectionSuspended(message0.arg2);
                    }
                    baseGmsClient0.onConnectionSuspended(message0.arg2);
                    baseGmsClient0.zze(5, 1, null);
                    return;
                }
            }
            if(zzb.zzb(message0)) {
                ((zzc)message0.obj).zzd();
                return;
            }
            Log.wtf("GmsClient", a.k(message0.what, "Don\'t know how to handle message: ", new StringBuilder(String.valueOf(message0.what).length() + 34)), new Exception());
            return;
        }
        zzb.zza(message0);
    }

    private static final void zza(Message message0) {
        zzc zzc0 = (zzc)message0.obj;
        if(zzc0 != null) {
            zzc0.zze();
        }
    }

    private static final boolean zzb(Message message0) {
        return message0.what == 1 || message0.what == 2 || message0.what == 7;
    }
}

