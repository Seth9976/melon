package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import jeb.synthetic.FIN;

final class zzhx extends Thread {
    final zzhy zza;
    private final Object zzb;
    private final BlockingQueue zzc;
    private boolean zzd;

    public zzhx(zzhy zzhy0, String s, BlockingQueue blockingQueue0) {
        Objects.requireNonNull(zzhy0);
        this.zza = zzhy0;
        super();
        this.zzd = false;
        Preconditions.checkNotNull(s);
        Preconditions.checkNotNull(blockingQueue0);
        this.zzb = new Object();
        this.zzc = blockingQueue0;
        this.setName(s);
    }

    @Override
    public final void run() {
        for(boolean z = false; !z; z = true) {
            try {
                this.zza.zzs().acquire();
            }
            catch(InterruptedException interruptedException0) {
                this.zzc(interruptedException0);
            }
        }
        int v = FIN.finallyOpen$NT();
        int v1 = Process.getThreadPriority(Process.myTid());
        while(true) {
            BlockingQueue blockingQueue0 = this.zzc;
            zzhw zzhw0 = (zzhw)blockingQueue0.poll();
            if(zzhw0 == null) {
                Object object0 = this.zzb;
                __monitor_enter(object0);
                try {
                    if(blockingQueue0.peek() == null) {
                        try {
                            object0.wait(30000L);
                        }
                        catch(InterruptedException interruptedException1) {
                            this.zzc(interruptedException1);
                        }
                    }
                }
                catch(Throwable throwable0) {
                    __monitor_exit(object0);
                    FIN.finallyExec$NT(v);
                    throw throwable0;
                }
                __monitor_exit(object0);
                Object object1 = this.zza.zzr();
                __monitor_enter(object1);
                try {
                    if(this.zzc.peek() == null) {
                        this.zzb();
                        goto label_38;
                    }
                    goto label_43;
                }
                catch(Throwable throwable1) {
                    __monitor_exit(object1);
                    FIN.finallyExec$NT(v);
                    throw throwable1;
                }
            label_38:
                __monitor_exit(object1);
                FIN.finallyCodeBegin$NT(v);
                this.zzb();
                FIN.finallyCodeEnd$NT(v);
                return;
            label_43:
                __monitor_exit(object1);
            }
            else {
                Process.setThreadPriority((zzhw0.zza ? v1 : 10));
                zzhw0.run();
            }
        }
    }

    public final void zza() {
        synchronized(this.zzb) {
            this.zzb.notifyAll();
        }
    }

    private final void zzb() {
        zzhy zzhy0 = this.zza;
        synchronized(zzhy0.zzr()) {
            if(!this.zzd) {
                zzhy0.zzs().release();
                zzhy0.zzr().notifyAll();
                if(this == zzhy0.zzn()) {
                    zzhy0.zzo(null);
                }
                else if(this == zzhy0.zzp()) {
                    zzhy0.zzq(null);
                }
                else {
                    zzhy0.zzu.zzaV().zzb().zza("Current scheduler thread is neither worker nor network");
                }
                this.zzd = true;
            }
        }
    }

    private final void zzc(InterruptedException interruptedException0) {
        this.zza.zzu.zzaV().zze().zzb(this.getName() + " was interrupted", interruptedException0);
    }
}

