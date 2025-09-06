package com.google.android.gms.measurement.internal;

import b3.Z;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zzhy extends zzje {
    private zzhx zza;
    private zzhx zzb;
    private final PriorityBlockingQueue zzc;
    private final BlockingQueue zzd;
    private final Thread.UncaughtExceptionHandler zze;
    private final Thread.UncaughtExceptionHandler zzf;
    private final Object zzg;
    private final Semaphore zzh;
    private volatile boolean zzi;
    private static final AtomicLong zzj;

    static {
        zzhy.zzj = new AtomicLong(0x8000000000000000L);
    }

    public zzhy(zzib zzib0) {
        super(zzib0);
        this.zzg = new Object();
        this.zzh = new Semaphore(2);
        this.zzc = new PriorityBlockingQueue();
        this.zzd = new LinkedBlockingQueue();
        this.zze = new zzhv(this, "Thread death: Uncaught exception on worker thread");
        this.zzf = new zzhv(this, "Thread death: Uncaught exception on network thread");
    }

    @Override  // com.google.android.gms.measurement.internal.zzje
    public final boolean zza() {
        return false;
    }

    @Override  // com.google.android.gms.measurement.internal.zzjd
    public final void zzaX() {
        if(Thread.currentThread() != this.zzb) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final void zzd() {
        if(Thread.currentThread() == this.zza) {
            throw new IllegalStateException("Call not expected from worker thread");
        }
    }

    public final boolean zze() {
        return Thread.currentThread() == this.zza;
    }

    public final boolean zzf() {
        return Thread.currentThread() == this.zzb;
    }

    @Override  // com.google.android.gms.measurement.internal.zzjd
    public final void zzg() {
        if(Thread.currentThread() != this.zza) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final Future zzh(Callable callable0) {
        this.zzw();
        Preconditions.checkNotNull(callable0);
        Future future0 = new zzhw(this, callable0, false, "Task exception on worker thread");
        if(Thread.currentThread() == this.zza) {
            if(!this.zzc.isEmpty()) {
                Z.A(this.zzu, "Callable skipped the worker queue.");
            }
            ((FutureTask)future0).run();
            return future0;
        }
        this.zzz(((zzhw)future0));
        return future0;
    }

    public final Future zzi(Callable callable0) {
        this.zzw();
        Preconditions.checkNotNull(callable0);
        Future future0 = new zzhw(this, callable0, true, "Task exception on worker thread");
        if(Thread.currentThread() == this.zza) {
            ((FutureTask)future0).run();
            return future0;
        }
        this.zzz(((zzhw)future0));
        return future0;
    }

    public final void zzj(Runnable runnable0) {
        this.zzw();
        Preconditions.checkNotNull(runnable0);
        this.zzz(new zzhw(this, runnable0, false, "Task exception on worker thread"));
    }

    public final Object zzk(AtomicReference atomicReference0, long v, String s, Runnable runnable0) {
        synchronized(atomicReference0) {
            this.zzu.zzaW().zzj(runnable0);
            try {
                atomicReference0.wait(v);
            }
            catch(InterruptedException unused_ex) {
                this.zzu.zzaV().zze().zza("Interrupted waiting for " + s);
                return null;
            }
        }
        Object object0 = atomicReference0.get();
        if(object0 == null) {
            this.zzu.zzaV().zze().zza("Timed out waiting for " + s);
        }
        return object0;
    }

    public final void zzl(Runnable runnable0) {
        this.zzw();
        Preconditions.checkNotNull(runnable0);
        this.zzz(new zzhw(this, runnable0, true, "Task exception on worker thread"));
    }

    public final void zzm(Runnable runnable0) {
        this.zzw();
        Preconditions.checkNotNull(runnable0);
        zzhw zzhw0 = new zzhw(this, runnable0, false, "Task exception on network thread");
        synchronized(this.zzg) {
            BlockingQueue blockingQueue0 = this.zzd;
            blockingQueue0.add(zzhw0);
            zzhx zzhx0 = this.zzb;
            if(zzhx0 == null) {
                zzhx zzhx1 = new zzhx(this, "Measurement Network", blockingQueue0);
                this.zzb = zzhx1;
                zzhx1.setUncaughtExceptionHandler(this.zzf);
                this.zzb.start();
            }
            else {
                zzhx0.zza();
            }
        }
    }

    public final zzhx zzn() {
        return this.zza;
    }

    public final void zzo(zzhx zzhx0) {
        this.zza = null;
    }

    public final zzhx zzp() {
        return this.zzb;
    }

    public final void zzq(zzhx zzhx0) {
        this.zzb = null;
    }

    public final Object zzr() {
        return this.zzg;
    }

    public final Semaphore zzs() {
        return this.zzh;
    }

    public final boolean zzt() [...] // Inlined contents

    public static AtomicLong zzu() {
        return zzhy.zzj;
    }

    private final void zzz(zzhw zzhw0) {
        synchronized(this.zzg) {
            PriorityBlockingQueue priorityBlockingQueue0 = this.zzc;
            priorityBlockingQueue0.add(zzhw0);
            zzhx zzhx0 = this.zza;
            if(zzhx0 == null) {
                zzhx zzhx1 = new zzhx(this, "Measurement Worker", priorityBlockingQueue0);
                this.zza = zzhx1;
                zzhx1.setUncaughtExceptionHandler(this.zze);
                this.zza.start();
            }
            else {
                zzhx0.zza();
            }
        }
    }
}

