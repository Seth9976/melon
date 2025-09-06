package com.google.android.gms.cloudmessaging;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;

public final class zzf implements OnCompleteListener {
    public final CountDownLatch zza;

    public zzf(CountDownLatch countDownLatch0) {
        this.zza = countDownLatch0;
    }

    @Override  // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task0) {
        this.zza.countDown();
    }
}

