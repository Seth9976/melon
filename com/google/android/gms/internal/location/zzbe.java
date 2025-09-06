package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

final class zzbe implements OnCompleteListener {
    private final AtomicReference zza;
    private final CountDownLatch zzb;

    public zzbe(AtomicReference atomicReference0, CountDownLatch countDownLatch0) {
        this.zza = atomicReference0;
        this.zzb = countDownLatch0;
    }

    @Override  // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task0) {
        if(task0.isSuccessful()) {
            Location location0 = (Location)task0.getResult();
            this.zza.set(location0);
        }
        this.zzb.countDown();
    }
}

