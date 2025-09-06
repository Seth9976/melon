package com.google.android.gms.internal.cast;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.tasks.Task;

public final class zzbs {
    public static PendingResult zza(Task task0, zzbr zzbr0, zzbr zzbr1) {
        PendingResult pendingResult0 = new zzbq(zzbr1);
        task0.addOnSuccessListener(new zzbo(((zzbq)pendingResult0), zzbr0)).addOnFailureListener(new zzbp(((zzbq)pendingResult0), zzbr1));
        return pendingResult0;
    }
}

