package com.google.android.gms.internal.cast;

import M6.B;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class zzuy extends zzvy implements B {
    volatile zzux.zzd listenersField;
    volatile Object valueField;
    volatile zzuy.zze waitersField;
    static final Object zza;
    static final zzvo zzb;
    static final boolean zzc;
    private static final zzuy.zza zzd;

    static {
        Throwable throwable1;
        Throwable throwable0;
        zzuy.zzd zzuy$zzd0;
        zzuy.zza = new Object();
        zzuy.zzb = new zzvo(zzux.class);
        zzuy.zzc = false;
        try {
            zzuy$zzd0 = new zzuy.zzd(null);
            throwable0 = null;
            throwable1 = null;
        }
        catch(Exception | Error exception0) {
            try {
                zzuy$zzd0 = new zzuy.zzb(null);
                throwable0 = null;
                throwable1 = exception0;
            }
            catch(Exception | Error exception1) {
                throwable0 = exception1;
                throwable1 = exception0;
                zzuy$zzd0 = new zzuy.zzc(null);
            }
        }
        zzuy.zzd = zzuy$zzd0;
        if(throwable0 != null) {
            Logger logger0 = zzuy.zzb.zza();
            Level level0 = Level.SEVERE;
            logger0.logp(level0, "com.google.common.util.concurrent.AbstractFutureState", "<clinit>", "UnsafeAtomicHelper is broken!", throwable1);
            zzuy.zzb.zza().logp(level0, "com.google.common.util.concurrent.AbstractFutureState", "<clinit>", "AtomicReferenceFieldUpdaterAtomicHelper is broken!", throwable0);
        }
    }

    @Override  // M6.B
    public abstract void addListener(Runnable arg1, Executor arg2);

    private final void zza(zzuy.zze zzuy$zze0) {
        zzuy$zze0.thread = null;
    alab1:
        zzuy.zze zzuy$zze1;
        while((zzuy$zze1 = this.waitersField) != zzuy.zze.zza) {
            zzuy.zze zzuy$zze2 = null;
            while(true) {
                if(zzuy$zze1 == null) {
                    break alab1;
                }
                zzuy.zze zzuy$zze3 = zzuy$zze1.next;
                if(zzuy$zze1.thread != null) {
                    zzuy$zze2 = zzuy$zze1;
                }
                else if(zzuy$zze2 == null) {
                    if(zzuy.zzd.zzg(this, zzuy$zze1, zzuy$zze3)) {
                        zzuy$zze1 = zzuy$zze3;
                        continue;
                    }
                    break;
                }
                else {
                    zzuy$zze2.next = zzuy$zze3;
                    if(zzuy$zze2.thread == null) {
                        break;
                    }
                }
                zzuy$zze1 = zzuy$zze3;
            }
        }
    }

    public final zzux.zzd zzh(zzux.zzd zzux$zzd0) {
        return zzuy.zzd.zza(this, zzux$zzd0);
    }

    public final Object zzi() {
        if(Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object object0 = this.valueField;
        if((object0 != null & zzux.zze(object0)) != 0) {
            return zzux.zza(object0);
        }
        zzuy.zze zzuy$zze0 = this.waitersField;
        if(zzuy$zze0 != zzuy.zze.zza) {
            zzuy.zze zzuy$zze1 = new zzuy.zze();
            while(true) {
                zzuy.zzd.zzc(zzuy$zze1, zzuy$zze0);
                if(zzuy.zzd.zzg(this, zzuy$zze0, zzuy$zze1)) {
                    while(true) {
                        LockSupport.park(this);
                        if(Thread.interrupted()) {
                            break;
                        }
                        Object object1 = this.valueField;
                        if((object1 != null & zzux.zze(object1)) != 0) {
                            return zzux.zza(object1);
                        }
                    }
                    this.zza(zzuy$zze1);
                    throw new InterruptedException();
                }
                zzuy$zze0 = this.waitersField;
                if(zzuy$zze0 == zzuy.zze.zza) {
                    break;
                }
            }
        }
        Object object2 = this.valueField;
        Objects.requireNonNull(object2);
        return zzux.zza(object2);
    }

    public final Object zzj(long v, TimeUnit timeUnit0) {
        long v1 = timeUnit0.toNanos(v);
        if(Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object object0 = this.valueField;
        boolean z = true;
        if((object0 != null & zzux.zze(object0)) != 0) {
            return zzux.zza(object0);
        }
        long v2 = v1 <= 0L ? 0L : System.nanoTime() + v1;
        if(v1 >= 1000L) {
            zzuy.zze zzuy$zze0 = this.waitersField;
            if(zzuy$zze0 != zzuy.zze.zza) {
                zzuy.zze zzuy$zze1 = new zzuy.zze();
                while(true) {
                    zzuy.zzd.zzc(zzuy$zze1, zzuy$zze0);
                    if(zzuy.zzd.zzg(this, zzuy$zze0, zzuy$zze1)) {
                        do {
                            LockSupport.parkNanos(this, Math.min(v1, 0x1DCD64FFFFFFFFFFL));
                            if(Thread.interrupted()) {
                                this.zza(zzuy$zze1);
                                throw new InterruptedException();
                            }
                            Object object1 = this.valueField;
                            if((object1 != null & zzux.zze(object1)) != 0) {
                                return zzux.zza(object1);
                            }
                            v1 = v2 - System.nanoTime();
                        }
                        while(v1 >= 1000L);
                        this.zza(zzuy$zze1);
                        goto label_29;
                    }
                    zzuy$zze0 = this.waitersField;
                    if(zzuy$zze0 == zzuy.zze.zza) {
                        break;
                    }
                }
            }
            Object object2 = this.valueField;
            Objects.requireNonNull(object2);
            return zzux.zza(object2);
        }
    label_29:
        while(v1 > 0L) {
            Object object3 = this.valueField;
            if((object3 != null & zzux.zze(object3)) != 0) {
                return zzux.zza(object3);
            }
            if(Thread.interrupted()) {
                throw new InterruptedException();
            }
            v1 = v2 - System.nanoTime();
        }
        String s = this.toString();
        Locale locale0 = Locale.ROOT;
        String s1 = timeUnit0.toString().toLowerCase(locale0);
        String s2 = "Waited " + v + " " + timeUnit0.toString().toLowerCase(locale0);
        if(v1 + 1000L < 0L) {
            String s3 = s2 + " (plus ";
            long v3 = timeUnit0.convert(-v1, TimeUnit.NANOSECONDS);
            long v4 = -v1 - timeUnit0.toNanos(v3);
            int v5 = Long.compare(v3, 0L);
            if(v5 != 0 && v4 <= 1000L) {
                z = false;
            }
            if(v5 > 0) {
                s3 = (z ? s3 + v3 + " " + s1 + "," : s3 + v3 + " " + s1) + " ";
            }
            if(z) {
                s3 = s3 + v4 + " nanoseconds ";
            }
            s2 = s3 + "delay)";
        }
        throw this.isDone() ? new TimeoutException(s2 + " but future completed as timeout expired") : new TimeoutException(s2 + " for " + s);
    }

    public static void zzk(zzuy.zze zzuy$zze0, Thread thread0) {
        zzuy.zzd.zzd(zzuy$zze0, thread0);
    }

    public final void zzl() {
        for(zzuy.zze zzuy$zze0 = zzuy.zzd.zzb(this, zzuy.zze.zza); zzuy$zze0 != null; zzuy$zze0 = zzuy$zze0.next) {
            Thread thread0 = zzuy$zze0.thread;
            if(thread0 != null) {
                zzuy$zze0.thread = null;
                LockSupport.unpark(thread0);
            }
        }
    }

    public final boolean zzm(zzux.zzd zzux$zzd0, zzux.zzd zzux$zzd1) {
        return zzuy.zzd.zze(this, zzux$zzd0, zzux$zzd1);
    }

    public static boolean zzn(zzuy zzuy0, Object object0, Object object1) {
        return zzuy.zzd.zzf(zzuy0, object0, object1);
    }
}

