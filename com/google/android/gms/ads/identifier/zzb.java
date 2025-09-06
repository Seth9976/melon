package com.google.android.gms.ads.identifier;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class zzb extends Thread {
    final CountDownLatch zza;
    private final WeakReference zzb;
    private final long zzc;

    public zzb(AdvertisingIdClient advertisingIdClient0, long v) {
        super("AdIdClientAutoDisconnectThread");
        this.zzb = new WeakReference(advertisingIdClient0);
        this.zzc = v;
        this.zza = new CountDownLatch(1);
        this.start();
    }

    @Override
    public final void run() {
        try {
            if(!this.zza.await(this.zzc, TimeUnit.MILLISECONDS)) {
                this.zza();
            }
        }
        catch(InterruptedException unused_ex) {
            this.zza();
        }
    }

    private final void zza() {
        AdvertisingIdClient advertisingIdClient0 = (AdvertisingIdClient)this.zzb.get();
        if(advertisingIdClient0 != null) {
            advertisingIdClient0.zza();
        }
    }
}

