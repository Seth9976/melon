package com.google.android.gms.internal.cast;

import H0.b;
import M6.B;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import va.e;

public abstract class zzux extends zzuy {
    @Override  // com.google.android.gms.internal.cast.zzuy
    public final void addListener(Runnable runnable0, Executor executor0) {
        zzgo.zzc(runnable0, "Runnable was null.");
        zzgo.zzc(executor0, "Executor was null.");
        if(!this.isDone()) {
            zzux.zzd zzux$zzd0 = this.listenersField;
            if(zzux$zzd0 != zzux.zzd.zza) {
                zzux.zzd zzux$zzd1 = new zzux.zzd(runnable0, executor0);
                do {
                    zzux$zzd1.next = zzux$zzd0;
                    if(this.zzm(zzux$zzd0, zzux$zzd1)) {
                        return;
                    }
                    zzux$zzd0 = this.listenersField;
                }
                while(zzux$zzd0 != zzux.zzd.zza);
            }
        }
        zzux.zzs(runnable0, executor0);
    }

    @Override
    public final boolean cancel(boolean z) {
        zzux.zza zzux$zza0;
        Object object0 = this.valueField;
        if((object0 instanceof zzux.zzb | object0 == null) != 0) {
            if(zzuy.zzc) {
                zzux$zza0 = new zzux.zza(z, new CancellationException("Future.cancel() was called."));
            }
            else {
                zzux$zza0 = z ? zzux.zza.zza : zzux.zza.zzb;
                Objects.requireNonNull(zzux$zza0);
            }
            zzux zzux0 = this;
            boolean z1 = false;
            while(true) {
                if(zzuy.zzn(zzux0, object0, zzux$zza0)) {
                    zzux.zzr(zzux0, z);
                    if(object0 instanceof zzux.zzb) {
                        B b0 = ((zzux.zzb)object0).zzb;
                        if(b0 instanceof zzux.zze) {
                            zzux0 = (zzux)b0;
                            object0 = zzux0.valueField;
                            if((object0 == null | object0 instanceof zzux.zzb) != 0) {
                                z1 = true;
                                continue;
                            }
                            return true;
                        }
                        else {
                            b0.cancel(z);
                        }
                    }
                    return true;
                }
                object0 = zzux0.valueField;
                if(zzux.zze(object0)) {
                    break;
                }
            }
            return z1;
        }
        return false;
    }

    @Override
    public final Object get() {
        return this.zzi();
    }

    @Override
    public final Object get(long v, TimeUnit timeUnit0) {
        return this.zzj(v, timeUnit0);
    }

    @Override
    public final boolean isCancelled() {
        return this.valueField instanceof zzux.zza;
    }

    @Override
    public final boolean isDone() {
        Object object0 = this.valueField;
        boolean z = zzux.zze(object0);
        return object0 != null ? true & z : false;
    }

    @Override
    public final String toString() {
        String s;
        StringBuilder stringBuilder0 = new StringBuilder();
        if(this.getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            stringBuilder0.append(this.getClass().getSimpleName());
        }
        else {
            stringBuilder0.append(this.getClass().getName());
        }
        stringBuilder0.append('@');
        stringBuilder0.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder0.append("[status=");
        if(this.valueField instanceof zzux.zza) {
            stringBuilder0.append("CANCELLED");
        }
        else if(this.isDone()) {
            this.zzq(stringBuilder0);
        }
        else {
            int v = stringBuilder0.length();
            stringBuilder0.append("PENDING");
            Object object0 = this.valueField;
            if(object0 instanceof zzux.zzb) {
                stringBuilder0.append(", setFuture=[");
                B b0 = ((zzux.zzb)object0).zzb;
                try {
                    if(b0 == this) {
                        stringBuilder0.append("this future");
                    }
                    else {
                        stringBuilder0.append(b0);
                    }
                }
                catch(Throwable throwable0) {
                    zzvv.zza(throwable0);
                    stringBuilder0.append("Exception thrown from implementation: ");
                    stringBuilder0.append(throwable0.getClass());
                }
                stringBuilder0.append("]");
            }
            else {
                try {
                    s = this.zzb();
                    if(s == null || s.isEmpty()) {
                        s = null;
                    }
                }
                catch(Throwable throwable1) {
                    zzvv.zza(throwable1);
                    s = "Exception thrown from implementation: " + throwable1.getClass();
                }
                if(s != null) {
                    e.g(stringBuilder0, ", info=[", s, "]");
                }
            }
            if(this.isDone()) {
                stringBuilder0.delete(v, stringBuilder0.length());
                this.zzq(stringBuilder0);
            }
        }
        stringBuilder0.append("]");
        return stringBuilder0.toString();
    }

    public static Object zza(Object object0) {
        if(!(object0 instanceof zzux.zza)) {
            if(object0 instanceof zzux.zzc) {
                throw new ExecutionException(((zzux.zzc)object0).zzb);
            }
            return object0 == zzuy.zza ? null : object0;
        }
        CancellationException cancellationException0 = new CancellationException("Task was cancelled.");
        cancellationException0.initCause(((zzux.zza)object0).zzd);
        throw cancellationException0;
    }

    // 去混淆评级： 低(20)
    public String zzb() {
        return this instanceof ScheduledFuture ? b.g(((ScheduledFuture)this).getDelay(TimeUnit.MILLISECONDS), "remaining delay=[", " ms]") : null;
    }

    @Override  // com.google.android.gms.internal.cast.zzvy
    public final Throwable zzc() {
        if(this instanceof zzux.zze) {
            return this.valueField instanceof zzux.zzc ? ((zzux.zzc)this.valueField).zzb : null;
        }
        return null;
    }

    public void zzd() {
    }

    public static boolean zze(Object object0) {
        return !(object0 instanceof zzux.zzb);
    }

    public final boolean zzf(Object object0) {
        if(object0 == null) {
            object0 = zzuy.zza;
        }
        if(zzuy.zzn(this, null, object0)) {
            zzux.zzr(this, false);
            return true;
        }
        return false;
    }

    public final boolean zzg(Throwable throwable0) {
        if(zzuy.zzn(this, null, new zzux.zzc(throwable0))) {
            zzux.zzr(this, false);
            return true;
        }
        return false;
    }

    private static Object zzo(B b0) {
        Object object0;
        if(b0 instanceof zzux.zze) {
            zzux.zza zzux$zza0 = ((zzux)b0).valueField;
            if(zzux$zza0 instanceof zzux.zza && zzux$zza0.zzc) {
                zzux$zza0 = zzux$zza0.zzd == null ? zzux.zza.zzb : new zzux.zza(false, zzux$zza0.zzd);
            }
            Objects.requireNonNull(zzux$zza0);
            return zzux$zza0;
        }
        if(b0 instanceof zzvy) {
            Throwable throwable0 = ((zzvy)b0).zzc();
            if(throwable0 != null) {
                return new zzux.zzc(throwable0);
            }
        }
        boolean z = b0.isCancelled();
        if((!zzuy.zzc & z) != 0) {
            Objects.requireNonNull(zzux.zza.zzb);
            return zzux.zza.zzb;
        }
        try {
            object0 = zzux.zzp(b0);
            if(z) {
                return new zzux.zza(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + b0));
            }
            return object0 == null ? zzuy.zza : object0;
        }
        catch(ExecutionException executionException0) {
            return z ? new zzux.zza(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + b0, executionException0)) : new zzux.zzc(executionException0.getCause());
        }
        catch(CancellationException cancellationException0) {
            return !z ? new zzux.zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + b0, cancellationException0)) : new zzux.zza(false, cancellationException0);
        }
        catch(Exception | Error throwable1) {
            return new zzux.zzc(throwable1);
        }
        return new zzux.zza(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + b0, executionException0));
    }

    private static Object zzp(Future future0) {
        Object object0;
        boolean z = false;
        while(true) {
            try {
                object0 = future0.get();
                break;
            }
            catch(InterruptedException unused_ex) {
                z = true;
            }
            catch(Throwable throwable0) {
                if(z) {
                    Thread.currentThread().interrupt();
                }
                throw throwable0;
            }
        }
        if(z) {
            Thread.currentThread().interrupt();
        }
        return object0;
    }

    private final void zzq(StringBuilder stringBuilder0) {
        try {
            Object object0 = zzux.zzp(this);
            stringBuilder0.append("SUCCESS, result=[");
            if(object0 == null) {
                stringBuilder0.append("null");
            }
            else if(object0 == this) {
                stringBuilder0.append("this future");
            }
            else {
                stringBuilder0.append(object0.getClass().getName());
                stringBuilder0.append("@");
                stringBuilder0.append(Integer.toHexString(System.identityHashCode(object0)));
            }
            stringBuilder0.append("]");
            return;
        }
        catch(ExecutionException executionException0) {
        }
        catch(CancellationException unused_ex) {
            stringBuilder0.append("CANCELLED");
            return;
        }
        catch(Exception exception0) {
            stringBuilder0.append("UNKNOWN, cause=[");
            stringBuilder0.append(exception0.getClass());
            stringBuilder0.append(" thrown from get()]");
            return;
        }
        stringBuilder0.append("FAILURE, cause=[");
        stringBuilder0.append(executionException0.getCause());
        stringBuilder0.append("]");
    }

    private static void zzr(zzux zzux0, boolean z) {
        Runnable runnable0;
        zzux.zzd zzux$zzd4;
        zzux.zzd zzux$zzd2;
        zzux.zzd zzux$zzd0 = null;
        while(true) {
            zzux0.zzl();
            zzux0.zzd();
            zzux.zzd zzux$zzd1 = zzux0.zzh(zzux.zzd.zza);
            zzux$zzd2 = zzux$zzd0;
            while(zzux$zzd1 != null) {
                zzux.zzd zzux$zzd3 = zzux$zzd1.next;
                zzux$zzd1.next = zzux$zzd2;
                zzux$zzd2 = zzux$zzd1;
                zzux$zzd1 = zzux$zzd3;
            }
        label_11:
            if(zzux$zzd2 != null) {
                zzux$zzd4 = zzux$zzd2.next;
                Objects.requireNonNull(zzux$zzd2.zzb);
                runnable0 = zzux$zzd2.zzb;
                if(runnable0 instanceof zzux.zzb) {
                    zzux0 = ((zzux.zzb)runnable0).zza;
                    if(zzux0.valueField == ((zzux.zzb)runnable0) && zzuy.zzn(zzux0, ((zzux.zzb)runnable0), zzux.zzo(((zzux.zzb)runnable0).zzb))) {
                        zzux$zzd0 = zzux$zzd4;
                        continue;
                    }
                }
                else {
                    break;
                }
                zzux$zzd2 = zzux$zzd4;
                goto label_11;
            }
            return;
        }
        Objects.requireNonNull(zzux$zzd2.zzc);
        zzux.zzs(runnable0, zzux$zzd2.zzc);
        zzux$zzd2 = zzux$zzd4;
        goto label_11;
    }

    private static void zzs(Runnable runnable0, Executor executor0) {
        try {
            executor0.execute(runnable0);
        }
        catch(Exception exception0) {
            zzuy.zzb.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + runnable0 + " with executor " + executor0, exception0);
        }
    }
}

