package com.google.android.gms.measurement.internal;

import A7.d;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import k8.Y;

public final class zzbb {
    final String zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final zzbe zzf;

    public zzbb(zzib zzib0, String s, String s1, String s2, long v, long v1, Bundle bundle0) {
        Preconditions.checkNotEmpty(s1);
        zzbe zzbe0;
        Preconditions.checkNotEmpty(s2);
        this.zza = s1;
        this.zzb = s2;
        if(TextUtils.isEmpty(s)) {
            s = null;
        }
        this.zzc = s;
        this.zzd = v;
        this.zze = v1;
        if(v1 != 0L && v1 > v) {
            zzib0.zzaV().zze().zzb("Event created with reverse previous/current timestamps. appId", zzgt.zzl(s1));
        }
        if(bundle0 == null || bundle0.isEmpty()) {
            zzbe0 = new zzbe(new Bundle());
        }
        else {
            Bundle bundle1 = new Bundle(bundle0);
            Iterator iterator0 = bundle1.keySet().iterator();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                String s3 = (String)object0;
                if(s3 == null) {
                    zzib0.zzaV().zzb().zza("Param name can\'t be null");
                    iterator0.remove();
                }
                else {
                    Object object1 = zzib0.zzk().zzE(s3, bundle1.get(s3));
                    if(object1 == null) {
                        zzib0.zzaV().zze().zzb("Param value can\'t be null", zzib0.zzl().zzb(s3));
                        iterator0.remove();
                    }
                    else {
                        zzib0.zzk().zzM(bundle1, s3, object1);
                    }
                }
            }
            zzbe0 = new zzbe(bundle1);
        }
        this.zzf = zzbe0;
    }

    private zzbb(zzib zzib0, String s, String s1, String s2, long v, long v1, zzbe zzbe0) {
        Preconditions.checkNotEmpty(s1);
        Preconditions.checkNotEmpty(s2);
        Preconditions.checkNotNull(zzbe0);
        this.zza = s1;
        this.zzb = s2;
        if(TextUtils.isEmpty(s)) {
            s = null;
        }
        this.zzc = s;
        this.zzd = v;
        this.zze = v1;
        if(v1 != 0L && v1 > v) {
            zzib0.zzaV().zze().zzc("Event created with reverse previous/current timestamps. appId, name", zzgt.zzl(s1), zzgt.zzl(s2));
        }
        this.zzf = zzbe0;
    }

    @Override
    public final String toString() {
        String s = this.zzf.toString();
        StringBuilder stringBuilder0 = new StringBuilder(String.valueOf(this.zza).length() + 22 + String.valueOf(this.zzb).length() + 10 + s.length() + 1);
        d.u(stringBuilder0, "Event{appId=\'", this.zza, "\', name=\'", this.zzb);
        return Y.l(stringBuilder0, "\', params=", s, "}");
    }

    public final zzbb zza(zzib zzib0, long v) {
        return new zzbb(zzib0, this.zzc, this.zza, this.zzb, this.zzd, v, this.zzf);
    }
}

