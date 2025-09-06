package com.google.android.gms.cast.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class zzd extends zzq {
    private final List zzb;

    public zzd(String s, String s1, String s2) {
        super(s, "MediaControlChannel", null);
        this.zzb = Collections.synchronizedList(new ArrayList());
    }

    public final List zza() {
        return this.zzb;
    }

    public final void zzb() {
        List list0 = this.zzb;
        synchronized(list0) {
            for(Object object0: list0) {
                ((zzav)object0).zzc(2002);
            }
        }
    }

    public final void zzc(zzav zzav0) {
        this.zzb.add(zzav0);
    }
}

