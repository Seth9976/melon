package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final class zzab implements Continuation {
    public static final zzab zza;

    static {
        zzab.zza = new zzab();
    }

    @Override  // com.google.android.gms.tasks.Continuation
    public final Object then(Task task0) {
        Intent intent0 = (Intent)((Bundle)task0.getResult()).getParcelable("notification_data");
        return intent0 != null ? new CloudMessage(intent0) : null;
    }
}

