package com.google.android.gms.internal.cast;

import U4.x;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import va.e;

abstract class zzvn extends AtomicReference implements Runnable {
    private static final Runnable zza;
    private static final Runnable zzb;

    static {
        zzvn.zza = new zzvl(null);
        zzvn.zzb = new zzvl(null);
    }

    @Override
    public final void run() {
        Thread thread0 = Thread.currentThread();
        Object object0 = null;
        if(this.compareAndSet(null, thread0)) {
            boolean z = this.zzf();
            if(!z) {
                try {
                    object0 = this.zza();
                }
                catch(Throwable throwable0) {
                    if(throwable0 instanceof InterruptedException) {
                        try {
                            Thread.currentThread().interrupt();
                        }
                        catch(Throwable throwable1) {
                            if(!this.compareAndSet(thread0, zzvn.zza)) {
                                this.zzg(thread0);
                            }
                            this.zzd(null);
                            throw throwable1;
                        }
                    }
                    if(!this.compareAndSet(thread0, zzvn.zza)) {
                        this.zzg(thread0);
                    }
                    this.zzc(throwable0);
                    return;
                }
            }
            if(!this.compareAndSet(thread0, zzvn.zza)) {
                this.zzg(thread0);
            }
            if(!z) {
                this.zzd(object0);
            }
        }
    }

    @Override
    public final String toString() {
        Runnable runnable0 = (Runnable)this.get();
        if(runnable0 == zzvn.zza) {
            return e.c("running=[DONE]", ", ", this.zzb());
        }
        if(runnable0 instanceof zzvk) {
            return e.c("running=[INTERRUPTED]", ", ", this.zzb());
        }
        return runnable0 instanceof Thread ? e.c(x.k("running=[RUNNING ON ", ((Thread)runnable0).getName(), "]"), ", ", this.zzb()) : e.c("running=[NOT STARTED YET]", ", ", this.zzb());
    }

    public abstract Object zza();

    public abstract String zzb();

    public abstract void zzc(Throwable arg1);

    public abstract void zzd(Object arg1);

    public final void zze() {
        Thread thread0;
        Runnable runnable0 = (Runnable)this.get();
        if(runnable0 instanceof Thread) {
            zzvk zzvk0 = new zzvk(this, null);
            zzvk0.setExclusiveOwnerThread(Thread.currentThread());
            if(this.compareAndSet(runnable0, zzvk0)) {
                try {
                    thread0 = (Thread)runnable0;
                    thread0.interrupt();
                }
                catch(Throwable throwable0) {
                    if(((Runnable)this.getAndSet(zzvn.zza)) == zzvn.zzb) {
                        LockSupport.unpark(((Thread)runnable0));
                    }
                    throw throwable0;
                }
                if(((Runnable)this.getAndSet(zzvn.zza)) == zzvn.zzb) {
                    LockSupport.unpark(thread0);
                }
            }
        }
    }

    public abstract boolean zzf();

    private final void zzg(Thread thread0) {
        Runnable runnable0 = (Runnable)this.get();
        zzvk zzvk0 = null;
        boolean z = false;
        int v = 0;
        while(true) {
            if(runnable0 instanceof zzvk) {
                zzvk0 = (zzvk)runnable0;
            }
            else if(runnable0 != zzvn.zzb) {
                break;
            }
            ++v;
            if(v <= 1000) {
                Thread.yield();
            }
            else if(runnable0 == zzvn.zzb || this.compareAndSet(runnable0, zzvn.zzb)) {
                z = Thread.interrupted() || z;
                LockSupport.park(zzvk0);
            }
            runnable0 = (Runnable)this.get();
        }
        if(z) {
            thread0.interrupt();
        }
    }
}

