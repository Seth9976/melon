package com.google.android.gms.internal.cast;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import androidx.appcompat.app.o;
import com.google.android.gms.cast.CastMediaControlIntent;
import com.google.android.gms.cast.internal.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import l4.G;
import l4.H;
import l4.O;
import l4.Q;

public final class zzay extends H {
    public final zzax zza;
    private static final Logger zzb;
    private final Set zzc;
    private final Map zzd;
    private final LinkedHashSet zze;
    private final zzbg zzf;

    static {
        zzay.zzb = new Logger("MRDiscoveryCallback");
    }

    public zzay(Context context0) {
        this.zzf = new zzbg(context0);
        this.zzd = Collections.synchronizedMap(new HashMap());
        this.zze = new LinkedHashSet();
        this.zzc = Collections.synchronizedSet(new LinkedHashSet());
        this.zza = new zzax(this);
    }

    @Override  // l4.H
    public final void onRouteAdded(Q q0, O o0) {
        zzay.zzb.d("MediaRouterDiscoveryCallback.onRouteAdded.", new Object[0]);
        this.zzf(o0, true);
    }

    @Override  // l4.H
    public final void onRouteChanged(Q q0, O o0) {
        zzay.zzb.d("MediaRouterDiscoveryCallback.onRouteChanged.", new Object[0]);
        this.zzf(o0, true);
    }

    @Override  // l4.H
    public final void onRouteRemoved(Q q0, O o0) {
        zzay.zzb.d("MediaRouterDiscoveryCallback.onRouteRemoved.", new Object[0]);
        this.zzf(o0, false);
    }

    public final void zza(List list0) {
        Logger logger0 = zzay.zzb;
        logger0.d(o.j(list0.size(), "SetRouteDiscovery for ", " IDs"), new Object[0]);
        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
        for(Object object0: list0) {
            linkedHashSet0.add(zzgk.zza(((String)object0)));
        }
        Map map0 = this.zzd;
        logger0.d("resetting routes. appIdToRouteInfo has these appId route keys: " + map0.keySet(), new Object[0]);
        HashMap hashMap0 = new HashMap();
        synchronized(map0) {
            for(Object object1: linkedHashSet0) {
                String s = (String)object1;
                zzaw zzaw0 = (zzaw)map0.get(zzgk.zza(s));
                if(zzaw0 != null) {
                    hashMap0.put(s, zzaw0);
                }
            }
            map0.clear();
            map0.putAll(hashMap0);
        }
        logger0.d("Routes reset. appIdToRouteInfo has these appId route keys: " + map0.keySet(), new Object[0]);
        synchronized(this.zze) {
            this.zze.clear();
            this.zze.addAll(linkedHashSet0);
        }
        this.zzb();
    }

    public final void zzb() {
        zzay.zzb.d(o.j(this.zze.size(), "Starting RouteDiscovery with ", " IDs"), new Object[0]);
        String s = "appIdToRouteInfo has these appId route keys: " + this.zzd.keySet();
        zzay.zzb.d(s, new Object[0]);
        if(Looper.myLooper() == Looper.getMainLooper()) {
            this.zzc();
            return;
        }
        new zzet(Looper.getMainLooper()).post(() -> {
            zzbg zzbg0 = this.zzf;
            zzbg0.zzc(this);
            LinkedHashSet linkedHashSet0 = this.zze;
            synchronized(linkedHashSet0) {
                for(Object object0: linkedHashSet0) {
                    String s = (String)object0;
                    String s1 = CastMediaControlIntent.categoryForCast(s);
                    if(s1 == null) {
                        throw new IllegalArgumentException("category must not be null");
                    }
                    ArrayList arrayList0 = new ArrayList();
                    if(!arrayList0.contains(s1)) {
                        arrayList0.add(s1);
                    }
                    Bundle bundle0 = new Bundle();
                    bundle0.putStringArrayList("controlCategories", arrayList0);
                    G g0 = new G(bundle0, arrayList0);
                    Map map0 = this.zzd;
                    if(((zzaw)map0.get(s)) == null) {
                        map0.put(s, new zzaw(g0));
                    }
                    String s2 = CastMediaControlIntent.categoryForCast(s);
                    zzay.zzb.d("Adding mediaRouter callback for control category " + s2, new Object[0]);
                    zzbg0.zzb(g0, this, 4);
                }
            }
            String s3 = "appIdToRouteInfo has these appId route keys: " + this.zzd.keySet();
            zzay.zzb.d(s3, new Object[0]);
        });
    }

    // 检测为 Lambda 实现
    public final void zzc() [...]

    public final void zzd() {
        zzay.zzb.d("Stopping RouteDiscovery.", new Object[0]);
        this.zzd.clear();
        if(Looper.myLooper() == Looper.getMainLooper()) {
            this.zzf.zzc(this);
            return;
        }
        new zzet(Looper.getMainLooper()).post(() -> this.zzf.zzc(this));
    }

    // 检测为 Lambda 实现
    public final void zze() [...]

    public final void zzf(O o0, boolean z) {
        Logger logger0 = zzay.zzb;
        logger0.d("MediaRouterDiscoveryCallback.updateRouteToAppIds (add=%b) route %s", new Object[]{Boolean.valueOf(z), o0});
        Map map0 = this.zzd;
        synchronized(map0) {
            logger0.d("appIdToRouteInfo has these appId route keys: " + map0.keySet(), new Object[0]);
            boolean z1 = false;
            for(Object object0: map0.entrySet()) {
                String s = (String)((Map.Entry)object0).getKey();
                zzaw zzaw0 = (zzaw)((Map.Entry)object0).getValue();
                if(!o0.h(zzaw0.zzb)) {
                }
                else if(z) {
                    logger0.d("Adding/updating route for appId " + s, new Object[0]);
                    z1 = zzaw0.zza.add(o0);
                    if(z1) {
                        continue;
                    }
                    logger0.w("Route " + o0 + " already exists for appId " + s, new Object[0]);
                }
                else {
                    logger0.d("Removing route for appId " + s, new Object[0]);
                    z1 = zzaw0.zza.remove(o0);
                    if(!z1) {
                        logger0.w("Route " + o0 + " already removed from appId " + s, new Object[0]);
                    }
                }
            }
        }
        if(z1) {
            zzay.zzb.d("Invoking callback.onRouteUpdated.", new Object[0]);
            synchronized(this.zzc) {
                HashMap hashMap0 = new HashMap();
                Map map1 = this.zzd;
                synchronized(map1) {
                    for(Object object1: map1.keySet()) {
                        String s1 = (String)object1;
                        zzaw zzaw1 = (zzaw)map1.get(zzgk.zza(s1));
                        zzhk zzhk0 = zzaw1 == null ? zzhk.zzk() : zzhk.zzj(zzaw1.zza);
                        if(!zzhk0.isEmpty()) {
                            hashMap0.put(s1, zzhk0);
                        }
                    }
                }
                zzhj.zzc(hashMap0.entrySet());
                for(Object object2: this.zzc) {
                    ((com.google.android.gms.cast.framework.zzbg)object2).zza();
                }
            }
        }
    }
}

