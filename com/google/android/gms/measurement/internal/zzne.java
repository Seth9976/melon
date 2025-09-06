package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.Objects;

public final class zzne implements ServiceConnection, BaseConnectionCallbacks, BaseOnConnectionFailedListener {
    final zznk zza;
    private volatile boolean zzb;
    private volatile zzgn zzc;

    public zzne(zznk zznk0) {
        Objects.requireNonNull(zznk0);
        this.zza = zznk0;
        super();
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks
    public final void onConnected(Bundle bundle0) {
        this.zza.zzu.zzaW().zzd();
        synchronized(this) {
            try {
                Preconditions.checkNotNull(this.zzc);
                zzga zzga0 = (zzga)this.zzc.getService();
                this.zza.zzu.zzaW().zzj(new zzmz(this, zzga0));
            }
            catch(DeadObjectException | IllegalStateException unused_ex) {
                this.zzc = null;
                this.zzb = false;
            }
        }
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult0) {
        this.zza.zzu.zzaW().zzd();
        zzgt zzgt0 = this.zza.zzu.zzf();
        if(zzgt0 != null) {
            zzgt0.zzk().zzb("Service connection failed", connectionResult0);
        }
        synchronized(this) {
            this.zzb = false;
            this.zzc = null;
        }
        this.zza.zzu.zzaW().zzj(new zznd(this, connectionResult0));
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks
    public final void onConnectionSuspended(int v) {
        this.zza.zzu.zzaW().zzd();
        this.zza.zzu.zzaV().zzj().zza("Service connection suspended");
        this.zza.zzu.zzaW().zzj(new zzna(this));
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName0, IBinder iBinder0) {
        zzga zzga0;
        this.zza.zzu.zzaW().zzd();
        synchronized(this) {
            if(iBinder0 == null) {
                this.zzb = false;
                this.zza.zzu.zzaV().zzb().zza("Service connected with null binder");
                return;
            }
            try {
                zzga0 = null;
                String s = iBinder0.getInterfaceDescriptor();
                if("com.google.android.gms.measurement.internal.IMeasurementService".equals(s)) {
                    IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    zzga zzga1 = iInterface0 instanceof zzga ? ((zzga)iInterface0) : new zzfy(iBinder0);
                    zzga0 = zzga1;
                    this.zza.zzu.zzaV().zzk().zza("Bound to IMeasurementService interface");
                }
                else {
                    this.zza.zzu.zzaV().zzb().zzb("Got binder with a wrong descriptor", s);
                }
            }
            catch(RemoteException unused_ex) {
                this.zza.zzu.zzaV().zzb().zza("Service connect failed to get IMeasurementService");
            }
            if(zzga0 == null) {
                try {
                    this.zzb = false;
                    ConnectionTracker.getInstance().unbindService(this.zza.zzu.zzaY(), this.zza.zzY());
                }
                catch(IllegalArgumentException unused_ex) {
                }
            }
            else {
                this.zza.zzu.zzaW().zzj(new zzmx(this, zzga0));
            }
        }
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName0) {
        this.zza.zzu.zzaW().zzd();
        this.zza.zzu.zzaV().zzj().zza("Service disconnected");
        this.zza.zzu.zzaW().zzj(new zzmy(this, componentName0));
    }

    public final void zza(Intent intent0) {
        this.zza.zzg();
        Context context0 = this.zza.zzu.zzaY();
        ConnectionTracker connectionTracker0 = ConnectionTracker.getInstance();
        synchronized(this) {
            if(this.zzb) {
                this.zza.zzu.zzaV().zzk().zza("Connection attempt already in progress");
                return;
            }
            this.zza.zzu.zzaV().zzk().zza("Using local app measurement service");
            this.zzb = true;
            connectionTracker0.bindService(context0, intent0, this.zza.zzY(), 0x81);
        }
    }

    public final void zzb() {
        if(this.zzc != null && (this.zzc.isConnected() || this.zzc.isConnecting())) {
            this.zzc.disconnect();
        }
        this.zzc = null;
    }

    public final void zzc() {
        this.zza.zzg();
        Context context0 = this.zza.zzu.zzaY();
        synchronized(this) {
            if(this.zzb) {
                this.zza.zzu.zzaV().zzk().zza("Connection attempt already in progress");
                return;
            }
            if(this.zzc != null && (this.zzc.isConnecting() || this.zzc.isConnected())) {
                this.zza.zzu.zzaV().zzk().zza("Already awaiting connection attempt");
                return;
            }
            this.zzc = new zzgn(context0, Looper.getMainLooper(), this, this);
            this.zza.zzu.zzaV().zzk().zza("Connecting to remote service");
            this.zzb = true;
            Preconditions.checkNotNull(this.zzc);
            this.zzc.checkAvailabilityAndConnect();
        }
    }

    public final void zzd(boolean z) {
        this.zzb = false;
    }
}

