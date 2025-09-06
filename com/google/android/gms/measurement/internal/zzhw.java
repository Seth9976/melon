package com.google.android.gms.measurement.internal;

import b3.Z;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class zzhw extends FutureTask implements Comparable {
    final boolean zza;
    final zzhy zzb;
    private final long zzc;
    private final String zzd;

    public zzhw(zzhy zzhy0, Runnable runnable0, boolean z, String s) {
        Objects.requireNonNull(zzhy0);
        this.zzb = zzhy0;
        super(runnable0, null);
        Preconditions.checkNotNull(s);
        long v = zzhy.zzu().getAndIncrement();
        this.zzc = v;
        this.zzd = s;
        this.zza = z;
        if(v == 0x7FFFFFFFFFFFFFFFL) {
            Z.u(zzhy0.zzu, "Tasks index overflow");
        }
    }

    public zzhw(zzhy zzhy0, Callable callable0, boolean z, String s) {
        Objects.requireNonNull(zzhy0);
        this.zzb = zzhy0;
        super(callable0);
        Preconditions.checkNotNull("Task exception on worker thread");
        long v = zzhy.zzu().getAndIncrement();
        this.zzc = v;
        this.zzd = "Task exception on worker thread";
        this.zza = z;
        if(v == 0x7FFFFFFFFFFFFFFFL) {
            Z.u(zzhy0.zzu, "Tasks index overflow");
        }
    }

    @Override
    public final int compareTo(Object object0) {
        boolean z = this.zza;
        if(z != ((zzhw)object0).zza) {
            return z ? -1 : 1;
        }
        long v = this.zzc;
        int v1 = Long.compare(v, ((zzhw)object0).zzc);
        if(v1 < 0) {
            return -1;
        }
        if(v1 > 0) {
            return 1;
        }
        this.zzb.zzu.zzaV().zzc().zzb("Two tasks share the same index. index", v);
        return 0;
    }

    @Override
    public final void setException(Throwable throwable0) {
        this.zzb.zzu.zzaV().zzb().zzb(this.zzd, throwable0);
        if(throwable0 instanceof zzhu) {
            Thread.UncaughtExceptionHandler thread$UncaughtExceptionHandler0 = Thread.getDefaultUncaughtExceptionHandler();
            if(thread$UncaughtExceptionHandler0 != null) {
                thread$UncaughtExceptionHandler0.uncaughtException(Thread.currentThread(), throwable0);
            }
        }
        super.setException(throwable0);
    }
}

