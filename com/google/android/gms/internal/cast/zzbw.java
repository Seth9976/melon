package com.google.android.gms.internal.cast;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzbw {
    public static final int zza;
    private static final Logger zzb;
    private final long zzc;
    private final Handler zzd;
    private final zzfd zze;

    static {
        zzbw.zzb = new Logger("AnalyticsConsent");
    }

    public zzbw(Context context0, long v) {
        this.zze = new zzfd(context0, new zzfi());
        this.zzc = v;
        this.zzd = new zzet(Looper.getMainLooper());
    }

    public final Task zza() {
        TaskCompletionSource taskCompletionSource0;
        synchronized(this) {
            taskCompletionSource0 = new TaskCompletionSource();
            TaskApiCall taskApiCall0 = TaskApiCall.builder().run(new zzfb(this.zze)).setMethodKey(4501).build();
            this.zze.doRead(taskApiCall0).addOnSuccessListener(new zzbt(taskCompletionSource0)).addOnFailureListener((Exception exception0) -> {
                zzbw.zzb.d(exception0, "get checkbox consent failed", new Object[0]);
                taskCompletionSource0.trySetResult(Boolean.FALSE);
            });
            zzbv zzbv0 = () -> {
                zzbw.zzb.d("get checkbox consent timed out", new Object[0]);
                taskCompletionSource0.trySetResult(Boolean.FALSE);
            };
            this.zzd.postDelayed(zzbv0, this.zzc * 1000L);
        }
        return taskCompletionSource0.getTask();
    }

    // 检测为 Lambda 实现
    public static void zzb(TaskCompletionSource taskCompletionSource0, Exception exception0) [...]

    // 检测为 Lambda 实现
    public static void zzc(TaskCompletionSource taskCompletionSource0) [...]
}

