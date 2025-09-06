package com.google.android.gms.internal.location;

import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

final class zzbc implements OnCompleteListener {
    private final AtomicReference zza;
    private final CountDownLatch zzb;

    public zzbc(AtomicReference atomicReference0, CountDownLatch countDownLatch0) {
        this.zza = atomicReference0;
        this.zzb = countDownLatch0;
    }

    @Override  // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task0) {
        if(task0.isSuccessful()) {
            LocationAvailability locationAvailability0 = (LocationAvailability)task0.getResult();
            this.zza.set(locationAvailability0);
        }
        this.zzb.countDown();
    }
}

