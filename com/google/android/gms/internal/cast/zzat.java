package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import l4.H;
import l4.O;
import l4.Q;

public final class zzat extends H {
    private static final Logger zza;
    private final zzao zzb;
    private final zzbf zzc;
    private final zzbn zzd;

    static {
        zzat.zza = new Logger("MediaRouterCallback");
    }

    public zzat(zzao zzao0, zzbf zzbf0, zzbn zzbn0) {
        this.zzb = (zzao)Preconditions.checkNotNull(zzao0);
        this.zzc = zzbf0;
        this.zzd = zzbn0;
    }

    @Override  // l4.H
    public final void onRouteAdded(Q q0, O o0) {
        try {
            this.zzb.zzf(o0.c, o0.s);
        }
        catch(RemoteException remoteException0) {
            zzat.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"onRouteAdded", "zzao"});
        }
        this.zza(q0);
    }

    @Override  // l4.H
    public final void onRouteChanged(Q q0, O o0) {
        if(!o0.g()) {
            return;
        }
        try {
            this.zzb.zzg(o0.c, o0.s);
        }
        catch(RemoteException remoteException0) {
            zzat.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"onRouteChanged", "zzao"});
        }
        this.zza(q0);
    }

    @Override  // l4.H
    public final void onRouteConnected(Q q0, O o0, O o1) {
        String s = o0.c;
        if(o0.l != 1) {
            zzat.zza.i("ignore onRouteConnected for non-remote connected routeId: %s", new Object[]{s});
            return;
        }
        zzat.zza.i("onRouteConnected with connectedRouteId = %s", new Object[]{s});
        this.zzc.zzu(true);
        try {
            zzao zzao0 = this.zzb;
            if(zzao0.zze() >= 251600000) {
                zzao0.zzh(o1.c, s, o0.s);
                return;
            }
            zzao0.zzl(o1.c, s, o0.s);
            return;
        }
        catch(RemoteException remoteException0) {
        }
        zzat.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"onRouteConnected", "zzao"});
    }

    @Override  // l4.H
    public final void onRouteDisconnected(Q q0, O o0, O o1, int v) {
        if(o0 != null) {
            String s = o0.c;
            if(o0.l == 1) {
                Object[] arr_object = {((O)Preconditions.checkNotNull(o0)).c, o1.c, v};
                zzat.zza.i("onRouteDisconnected with disconnectedRouteId = %s, requestedRouteId = %s, reason = %d", arr_object);
                this.zzc.zzu(false);
                try {
                    zzao zzao0 = this.zzb;
                    if(zzao0.zze() >= 251600000) {
                        zzao0.zzi(o1.c, s, o0.s, v);
                        return;
                    }
                    zzao0.zzm(s, o0.s, v);
                    return;
                }
                catch(RemoteException remoteException0) {
                }
                zzat.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"onRouteDisconnected", "zzao"});
                return;
            }
        }
        zzat.zza.i("ignore onRouteDisconnected for invalid or non-remote disconnected route", new Object[0]);
    }

    @Override  // l4.H
    public final void onRouteRemoved(Q q0, O o0) {
        try {
            this.zzb.zzj(o0.c, o0.s);
        }
        catch(RemoteException remoteException0) {
            zzat.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"onRouteRemoved", "zzao"});
        }
        this.zza(q0);
    }

    @Override  // l4.H
    public final void onRouteSelected(Q q0, O o0, int v, O o1) {
        String s = o0.c;
        if(o0.l != 1) {
            zzat.zza.i("ignore onRouteSelected for non-remote selected routeId: %s", new Object[]{s});
            return;
        }
        zzat.zza.i("onRouteSelected with reason = %d, routeId = %s", new Object[]{v, s});
        try {
            zzao zzao0 = this.zzb;
            if(zzao0.zze() >= 220400000) {
                zzao0.zzl(o1.c, s, o0.s);
            }
            else {
                zzao0.zzk(o1.c, o0.s);
            }
        }
        catch(RemoteException remoteException0) {
            zzat.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"onRouteSelected", "zzao"});
        }
        this.zza(q0);
    }

    @Override  // l4.H
    public final void onRouteUnselected(Q q0, O o0, int v) {
        String s = o0.c;
        if(o0.l != 1) {
            zzat.zza.i("ignore onRouteUnselected for non-remote routeId: %s", new Object[]{s});
            return;
        }
        zzat.zza.i("onRouteUnselected with reason = %d, routeId = %s", new Object[]{v, s});
        try {
            this.zzb.zzm(s, o0.s, v);
        }
        catch(RemoteException remoteException0) {
            zzat.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"onRouteUnselected", "zzao"});
        }
        this.zza(q0);
    }

    private final void zza(Q q0) {
        zzbn zzbn0 = this.zzd;
        if(zzbn0 != null) {
            zzbn0.zzo(q0);
        }
    }
}

