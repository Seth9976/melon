package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.CountDownLatch;

public final class zzg implements Runnable {
    public final Context zza;
    public final CloudMessage zzb;
    public final CountDownLatch zzc;

    public zzg(Context context0, CloudMessage cloudMessage0, CountDownLatch countDownLatch0) {
        this.zza = context0;
        this.zzb = cloudMessage0;
        this.zzc = countDownLatch0;
    }

    @Override
    public final void run() {
        Task task0;
        CloudMessage cloudMessage0 = this.zzb;
        if(TextUtils.isEmpty(cloudMessage0.getMessageId())) {
            task0 = Tasks.forResult(null);
        }
        else {
            Bundle bundle0 = new Bundle();
            bundle0.putString("google.message_id", cloudMessage0.getMessageId());
            Integer integer0 = cloudMessage0.zza();
            if(integer0 != null) {
                bundle0.putInt("google.product_id", ((int)integer0));
            }
            bundle0.putBoolean("supports_message_handled", true);
            task0 = zzv.zzb(this.zza).zzc(2, bundle0);
        }
        zzf zzf0 = new zzf(this.zzc);
        task0.addOnCompleteListener((zze this) -> runnable0.run(), zzf0);
    }
}

