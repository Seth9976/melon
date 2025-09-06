package com.google.android.gms.internal.cast;

import P1.c;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkRequest.Builder;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzdv implements zzds {
    public final Set zza;
    private static final Logger zzb;
    private final zzvp zzc;
    private final ConnectivityManager.NetworkCallback zzd;
    private final ConnectivityManager zze;
    private final Map zzf;
    private final List zzg;
    private boolean zzh;
    private final Context zzi;
    private final Object zzj;

    static {
        zzdv.zzb = new Logger("ConnectivityMonitor");
    }

    @TargetApi(23)
    public zzdv(Context context0, zzvp zzvp0) {
        this.zzj = new Object();
        this.zza = Collections.synchronizedSet(new HashSet());
        this.zzc = zzvp0;
        this.zzi = context0;
        this.zze = (ConnectivityManager)context0.getSystemService("connectivity");
        this.zzf = Collections.synchronizedMap(new HashMap());
        this.zzg = Collections.synchronizedList(new ArrayList());
        this.zzd = new zzdu(this);
    }

    @Override  // com.google.android.gms.internal.cast.zzds
    @TargetApi(23)
    public final void zza() {
        zzdv.zzb.d("Start monitoring connectivity changes", new Object[0]);
        if(!this.zzh) {
            ConnectivityManager connectivityManager0 = this.zze;
            if(connectivityManager0 != null && c.checkSelfPermission(this.zzi, "android.permission.ACCESS_NETWORK_STATE") == 0) {
                Network network0 = connectivityManager0.getActiveNetwork();
                if(network0 != null) {
                    LinkProperties linkProperties0 = connectivityManager0.getLinkProperties(network0);
                    if(linkProperties0 != null) {
                        this.zzf(network0, linkProperties0);
                    }
                }
                connectivityManager0.registerNetworkCallback(new NetworkRequest.Builder().addTransportType(1).build(), this.zzd);
                this.zzh = true;
            }
        }
    }

    // 检测为 Lambda 实现
    public static void zzb(zzdv zzdv0, zzdr zzdr0) [...]

    public static void zzc(zzdv zzdv0, Network network0, LinkProperties linkProperties0) {
        zzdv0.zzf(network0, linkProperties0);
    }

    public static void zzd(zzdv zzdv0) {
        synchronized(Preconditions.checkNotNull(zzdv0.zzj)) {
            Map map0 = zzdv0.zzf;
            if(map0 != null) {
                List list0 = zzdv0.zzg;
                if(list0 != null) {
                    zzdv.zzb.d("all networks are unavailable.", new Object[0]);
                    map0.clear();
                    list0.clear();
                    zzdv0.zzg();
                }
            }
        }
    }

    public static void zze(zzdv zzdv0, Network network0) {
        synchronized(Preconditions.checkNotNull(zzdv0.zzj)) {
            Map map0 = zzdv0.zzf;
            if(map0 != null) {
                List list0 = zzdv0.zzg;
                if(list0 != null) {
                    zzdv.zzb.d("the network is lost", new Object[0]);
                    if(list0.remove(network0)) {
                        map0.remove(network0);
                    }
                    zzdv0.zzg();
                }
            }
        }
    }

    private final void zzf(Network network0, LinkProperties linkProperties0) {
        synchronized(Preconditions.checkNotNull(this.zzj)) {
            Map map0 = this.zzf;
            if(map0 != null) {
                List list0 = this.zzg;
                if(list0 != null) {
                    zzdv.zzb.d("a new network is available", new Object[0]);
                    if(map0.containsKey(network0)) {
                        list0.remove(network0);
                    }
                    map0.put(network0, linkProperties0);
                    list0.add(network0);
                    this.zzg();
                }
            }
        }
    }

    private final void zzg() {
        zzvp zzvp0 = this.zzc;
        if(zzvp0 == null) {
            return;
        }
        Set set0 = this.zza;
        synchronized(set0) {
            for(Object object0: set0) {
                zzdr zzdr0 = (zzdr)object0;
                if(!zzvp0.isShutdown()) {
                    zzvp0.execute(() -> {
                        List list0 = this.zzg;
                        if(list0 != null) {
                            list0.isEmpty();
                        }
                        zzdr0.zza();
                    });
                }
            }
        }
    }
}

