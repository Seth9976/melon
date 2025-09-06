package com.google.android.gms.internal.cast;

import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastMediaControlIntent;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.zzq;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import l4.G;

@ShowFirstParty
public final class zzdq {
    public static final int zza;
    private static zzdq zzb;
    private static final Logger zzc;
    private final CastOptions zzd;
    private final zzaf zze;
    private final zzbg zzf;
    private final zzdo zzg;
    private final Set zzh;
    private final zzdm zzi;
    private final Map zzj;
    private final Map zzk;
    private final PowerManager zzl;
    private final Object zzm;
    private final Object zzn;
    private boolean zzo;

    static {
        zzdq.zzc = new Logger("RemoteConnectionManager");
    }

    private zzdq(Context context0, CastOptions castOptions0, zzaf zzaf0, zzbg zzbg0) {
        this.zzm = new Object();
        this.zzn = new Object();
        this.zzd = castOptions0;
        this.zzh = Collections.newSetFromMap(new ConcurrentHashMap());
        this.zzf = zzbg0;
        this.zzg = new zzdo(this, null);
        zzdm zzdm0 = new zzdm(this, null);
        this.zzi = zzdm0;
        this.zze = zzaf0;
        zzaf0.zze(zzdm0);
        this.zzj = new ConcurrentHashMap();
        this.zzk = new ConcurrentHashMap();
        this.zzl = (PowerManager)context0.getSystemService("power");
        new zzdn(this, null);
    }

    public static zzdq zza(Context context0, CastOptions castOptions0, zzaf zzaf0) {
        if(zzdq.zzb == null) {
            zzdq.zzb = new zzdq(context0, castOptions0, zzaf0, new zzbg(context0));
        }
        return zzdq.zzb;
    }

    public static void zzd(zzdq zzdq0, Bundle bundle0) {
        if(bundle0 != null) {
            CastDevice castDevice0 = CastDevice.getFromBundle(bundle0);
            if(castDevice0 != null) {
                String s = bundle0.getString("com.google.android.gms.cast.EXTRA_RUNNING_RECEIVER_APP_ID");
                if(zzdq0.zzj.containsKey(castDevice0.getDeviceId()) && ((zzdi)zzdq0.zzj.get(castDevice0.getDeviceId())) != null) {
                    throw null;
                }
                String s1 = zzdq0.zzd.getReceiverApplicationId();
                if(s == null || s1.isEmpty() || !s.equals(s1)) {
                    zzdq0.zzj(castDevice0);
                }
                else {
                    String s2 = castDevice0.getDeviceId();
                    zzdl zzdl0 = new zzdl(castDevice0, s);
                    zzdk zzdk0 = (zzdk)zzdq0.zzk.computeIfAbsent(s2, zzdl0);
                    Set set0 = zzdq0.zzh;
                    if(!set0.isEmpty()) {
                        Object object0 = zzdq0.zzm;
                        synchronized(object0) {
                            Iterator iterator0 = set0.iterator();
                            if(!iterator0.hasNext()) {
                                return;
                            }
                            Object object1 = iterator0.next();
                            zzdh zzdh0 = (zzdh)object1;
                        }
                        throw null;
                    }
                }
            }
        }
    }

    public static void zze(zzdq zzdq0) {
        synchronized(zzdq0.zzn) {
            Iterator iterator0 = zzdq0.zzj.values().iterator();
            if(!iterator0.hasNext()) {
                return;
            }
            Object object1 = iterator0.next();
            zzdi zzdi0 = (zzdi)object1;
        }
        throw null;
    }

    public static void zzg(zzdq zzdq0) {
        synchronized(zzdq0.zzn) {
            for(Object object1: zzdq0.zzj.values()) {
                ((zzdi)object1).zzb(zzdq0.zze.zzf(), zzdq0.zzl != null && !zzdq0.zzl.isInteractive());
            }
        }
    }

    public static void zzh(zzdq zzdq0) {
        G g0;
        if(!zzdq0.zze.zzf() && !zzdq0.zzh.isEmpty()) {
            if(!zzdq0.zzo) {
                Logger logger0 = zzdq.zzc;
                logger0.d("Starting RemoteConnectionManager discovery.", new Object[0]);
                zzbg zzbg0 = zzdq0.zzf;
                zzdo zzdo0 = zzdq0.zzg;
                zzbg0.zzc(zzdo0);
                String s = zzdq0.zzd.getReceiverApplicationId();
                if(s.isEmpty()) {
                    logger0.d("Failed to create MediaRouteSelector. No target receiver app ID has been set.", new Object[0]);
                    g0 = null;
                }
                else {
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
                    g0 = new G(bundle0, arrayList0);
                }
                if(g0 == null) {
                    logger0.d("Skipping starting discovery. No target receiver app ID has been set.", new Object[0]);
                    return;
                }
                zzdq0.zzo = true;
                logger0.d("Adding mediaRouter callback for control category " + g0.c(), new Object[0]);
                zzbg0.zzb(g0, zzdo0, 4);
            }
        }
        else if(zzdq0.zzo) {
            zzdq0.zzo = false;
            zzdq.zzc.d("Stopping RemoteConnectionManager discovery.", new Object[0]);
            zzdq0.zzf.zzc(zzdq0.zzg);
        }
    }

    public final void zzi(zzq zzq0) {
        synchronized(this.zzn) {
            Iterator iterator0 = this.zzj.entrySet().iterator();
            if(!iterator0.hasNext()) {
                return;
            }
            Object object1 = iterator0.next();
            zzdi zzdi0 = (zzdi)((Map.Entry)object1).getValue();
        }
        throw null;
    }

    private final void zzj(CastDevice castDevice0) {
        String s = castDevice0.getDeviceId();
        if(((zzdk)this.zzk.remove(s)) != null) {
            synchronized(this.zzm) {
                Iterator iterator0 = this.zzh.iterator();
                if(!iterator0.hasNext()) {
                    return;
                }
                Object object1 = iterator0.next();
                zzdh zzdh0 = (zzdh)object1;
            }
            throw null;
        }
    }
}

