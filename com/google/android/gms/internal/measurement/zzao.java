package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

public interface zzao {
    public static final zzao zzf;
    public static final zzao zzg;
    public static final zzao zzh;
    public static final zzao zzi;
    public static final zzao zzj;
    public static final zzao zzk;
    public static final zzao zzl;
    public static final zzao zzm;

    static {
        zzao.zzf = new zzat();
        zzao.zzg = new zzam();
        zzao.zzh = new zzag("continue");
        zzao.zzi = new zzag("break");
        zzao.zzj = new zzag("return");
        zzao.zzk = new zzaf(Boolean.TRUE);
        zzao.zzl = new zzaf(Boolean.FALSE);
        zzao.zzm = new zzas("");
    }

    String zzc();

    zzao zzcA(String arg1, zzg arg2, List arg3);

    Double zzd();

    Boolean zze();

    Iterator zzf();

    zzao zzt();
}

