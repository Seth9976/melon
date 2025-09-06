package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import b3.Z;
import com.google.android.gms.common.internal.Preconditions;
import com.iloen.melon.utils.a;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class zzgt extends zzje {
    private char zza;
    private long zzb;
    private String zzc;
    private final zzgr zzd;
    private final zzgr zze;
    private final zzgr zzf;
    private final zzgr zzg;
    private final zzgr zzh;
    private final zzgr zzi;
    private final zzgr zzj;
    private final zzgr zzk;
    private final zzgr zzl;

    public zzgt(zzib zzib0) {
        super(zzib0);
        this.zza = '\u0000';
        this.zzb = -1L;
        this.zzd = new zzgr(this, 6, false, false);
        this.zze = new zzgr(this, 6, true, false);
        this.zzf = new zzgr(this, 6, false, true);
        this.zzg = new zzgr(this, 5, false, false);
        this.zzh = new zzgr(this, 5, true, false);
        this.zzi = new zzgr(this, 5, false, true);
        this.zzj = new zzgr(this, 4, false, false);
        this.zzk = new zzgr(this, 3, false, false);
        this.zzl = new zzgr(this, 2, false, false);
    }

    @Override  // com.google.android.gms.measurement.internal.zzje
    public final boolean zza() {
        return false;
    }

    public final zzgr zzb() {
        return this.zzd;
    }

    public final zzgr zzc() {
        return this.zze;
    }

    public final zzgr zzd() {
        return this.zzf;
    }

    public final zzgr zze() {
        return this.zzg;
    }

    public final zzgr zzf() {
        return this.zzh;
    }

    public final zzgr zzh() {
        return this.zzi;
    }

    public final zzgr zzi() {
        return this.zzj;
    }

    public final zzgr zzj() {
        return this.zzk;
    }

    public final zzgr zzk() {
        return this.zzl;
    }

    public static Object zzl(String s) {
        return s == null ? null : new zzgs(s);
    }

    public final void zzm(int v, boolean z, boolean z1, String s, Object object0, Object object1, Object object2) {
        if(!z && Log.isLoggable(this.zzn(), v)) {
            String s1 = zzgt.zzo(false, s, object0, object1, object2);
            Log.println(v, this.zzn(), s1);
        }
        if(!z1 && v >= 5) {
            Preconditions.checkNotNull(s);
            zzhy zzhy0 = this.zzu.zzi();
            if(zzhy0 == null) {
                Log.println(6, this.zzn(), "Scheduler not set. Not logging error/warn");
                return;
            }
            if(!zzhy0.zzv()) {
                Log.println(6, this.zzn(), "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if(v >= 9) {
                v = 8;
            }
            zzhy0.zzj(new zzgq(this, v, s, object0, object1, object2));
        }
    }

    @EnsuresNonNull({"logTagDoNotUseDirectly"})
    public final String zzn() {
        synchronized(this) {
            if(this.zzc == null) {
                this.zzc = this.zzu.zzc().zzb();
            }
            Preconditions.checkNotNull(this.zzc);
            return this.zzc;
        }
    }

    public static String zzo(boolean z, String s, Object object0, Object object1, Object object2) {
        String s1 = zzgt.zzp(z, object0);
        String s2 = zzgt.zzp(z, object1);
        String s3 = zzgt.zzp(z, object2);
        StringBuilder stringBuilder0 = new StringBuilder();
        String s4 = "";
        if(s == null) {
            s = "";
        }
        if(!TextUtils.isEmpty(s)) {
            stringBuilder0.append(s);
            s4 = ": ";
        }
        String s5 = ", ";
        if(!TextUtils.isEmpty(s1)) {
            stringBuilder0.append(s4);
            stringBuilder0.append(s1);
            s4 = ", ";
        }
        if(TextUtils.isEmpty(s2)) {
            s5 = s4;
        }
        else {
            stringBuilder0.append(s4);
            stringBuilder0.append(s2);
        }
        if(!TextUtils.isEmpty(s3)) {
            stringBuilder0.append(s5);
            stringBuilder0.append(s3);
        }
        return stringBuilder0.toString();
    }

    public static String zzp(boolean z, Object object0) {
        String s = "";
        if(object0 == null) {
            return "";
        }
        if(object0 instanceof Integer) {
            object0 = (long)(((int)(((Integer)object0))));
        }
        if(object0 instanceof Long) {
            if(!z) {
                return object0.toString();
            }
            if(Math.abs(((long)(((Long)object0)))) < 100L) {
                return object0.toString();
            }
            String s1 = String.valueOf(Math.abs(((long)(((Long)object0)))));
            long v1 = Math.round(Math.pow(10.0, s1.length() - 1));
            long v2 = Math.round(Math.pow(10.0, s1.length()) - 1.0);
            int v3 = String.valueOf(v1).length();
            if(object0.toString().charAt(0) == 45) {
                s = "-";
            }
            StringBuilder stringBuilder0 = new StringBuilder(Z.d(s.length() + v3 + 3, String.valueOf(v2).length(), s));
            a.s(v1, s, "...", stringBuilder0);
            stringBuilder0.append(s);
            stringBuilder0.append(v2);
            return stringBuilder0.toString();
        }
        if(object0 instanceof Boolean) {
            return object0.toString();
        }
        if(object0 instanceof Throwable) {
            StringBuilder stringBuilder1 = new StringBuilder((z ? ((Throwable)object0).getClass().getName() : ((Throwable)object0).toString()));
            String s2 = zzgt.zzq(zzib.class.getCanonicalName());
            StackTraceElement[] arr_stackTraceElement = ((Throwable)object0).getStackTrace();
            for(int v = 0; v < arr_stackTraceElement.length; ++v) {
                StackTraceElement stackTraceElement0 = arr_stackTraceElement[v];
                if(!stackTraceElement0.isNativeMethod()) {
                    String s3 = stackTraceElement0.getClassName();
                    if(s3 != null && zzgt.zzq(s3).equals(s2)) {
                        stringBuilder1.append(": ");
                        stringBuilder1.append(stackTraceElement0);
                        return stringBuilder1.toString();
                    }
                }
            }
            return stringBuilder1.toString();
        }
        if(object0 instanceof zzgs) {
            return ((zzgs)object0).zza();
        }
        return z ? "-" : object0.toString();
    }

    public static String zzq(String s) {
        if(TextUtils.isEmpty(s)) {
            return "";
        }
        int v = s.lastIndexOf(46);
        return v == -1 ? "" : s.substring(0, v);
    }

    public final char zzr() {
        return this.zza;
    }

    public final void zzs(char c) {
        this.zza = c;
    }

    public final long zzt() {
        return this.zzb;
    }

    public final void zzu(long v) {
        this.zzb = 130000L;
    }
}

