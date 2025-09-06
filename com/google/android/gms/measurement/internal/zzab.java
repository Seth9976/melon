package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfl;
import com.google.android.gms.internal.measurement.zzfr;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

abstract class zzab {
    final String zzb;
    final int zzc;
    Boolean zzd;
    Boolean zze;
    Long zzf;
    Long zzg;

    public zzab(String s, int v) {
        this.zzb = s;
        this.zzc = v;
    }

    public abstract int zza();

    public abstract boolean zzb();

    public abstract boolean zzc();

    private static Boolean zzd(String s, int v, boolean z, String s1, List list0, String s2, zzgt zzgt0) {
        if(v == 7) {
            if(list0 == null || list0.isEmpty()) {
                return null;
            }
        }
        else if(s1 == null) {
            return null;
        }
        if(!z && v != 2) {
            s = s.toUpperCase(Locale.ENGLISH);
        }
        switch(v - 1) {
            case 1: {
                if(s2 == null) {
                    return null;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(s2, (z ? 0 : 66)).matcher(s).matches());
                }
                catch(PatternSyntaxException unused_ex) {
                    if(zzgt0 != null) {
                        zzgt0.zze().zzb("Invalid regular expression in REGEXP audience filter. expression", s2);
                    }
                    return null;
                }
            }
            case 2: {
                return Boolean.valueOf(s.startsWith(s1));
            }
            case 3: {
                return Boolean.valueOf(s.endsWith(s1));
            }
            case 4: {
                return Boolean.valueOf(s.contains(s1));
            }
            case 5: {
                return Boolean.valueOf(s.equals(s1));
            }
            case 6: {
                return list0 == null ? null : Boolean.valueOf(list0.contains(s));
            }
            default: {
                return null;
            }
        }
    }

    public static Boolean zze(Boolean boolean0, boolean z) {
        if(boolean0 == null) {
            return null;
        }
        return boolean0.booleanValue() == z ? false : true;
    }

    public static Boolean zzf(String s, zzfr zzfr0, zzgt zzgt0) {
        Preconditions.checkNotNull(zzfr0);
        if(s != null && zzfr0.zza() && zzfr0.zzj() != 1) {
            if(zzfr0.zzj() != 7) {
                if(zzfr0.zzb()) {
                label_6:
                    int v = zzfr0.zzj();
                    boolean z = zzfr0.zze();
                    if(zzfr0.zzg() == 0) {
                        return v == 2 ? zzab.zzd(s, 2, z, "", null, "", zzgt0) : zzab.zzd(s, v, z, "", null, null, zzgt0);
                    }
                    List list0 = zzfr0.zzf();
                    if(!z) {
                        ArrayList arrayList0 = new ArrayList(list0.size());
                        for(Object object0: list0) {
                            arrayList0.add(((String)object0).toUpperCase(Locale.ENGLISH));
                        }
                        list0 = Collections.unmodifiableList(arrayList0);
                    }
                    return v == 2 ? zzab.zzd(s, 2, z, "", list0, "", zzgt0) : zzab.zzd(s, v, z, "", list0, null, zzgt0);
                }
            }
            else if(zzfr0.zzg() != 0) {
                goto label_6;
            }
        }
        return null;
    }

    public static Boolean zzg(long v, zzfl zzfl0) {
        try {
            return zzab.zzj(new BigDecimal(v), zzfl0, 0.0);
        }
        catch(NumberFormatException unused_ex) {
            return null;
        }
    }

    public static Boolean zzh(double f, zzfl zzfl0) {
        try {
            return zzab.zzj(new BigDecimal(f), zzfl0, Math.ulp(f));
        }
        catch(NumberFormatException unused_ex) {
            return null;
        }
    }

    public static Boolean zzi(String s, zzfl zzfl0) {
        if(!zzpj.zzm(s)) {
            return null;
        }
        try {
            return zzab.zzj(new BigDecimal(s), zzfl0, 0.0);
        }
        catch(NumberFormatException unused_ex) {
            return null;
        }
    }

    // 去混淆评级： 低(31)
    public static Boolean zzj(BigDecimal bigDecimal0, zzfl zzfl0, double f) {
        Preconditions.checkNotNull(zzfl0);
        if(zzfl0.zza()) {
            switch(zzfl0.zzm()) {
                case 1: {
                    break;
                }
                case 5: {
                    if(!zzfl0.zzf() || !zzfl0.zzh()) {
                        return null;
                    }
                    return zzfl0.zzm() == 5 ? null : null;
                }
                default: {
                    if(!zzfl0.zzd()) {
                        return null;
                    }
                    return zzfl0.zzm() == 5 ? null : null;
                }
            }
        }
        return null;
    }
}

