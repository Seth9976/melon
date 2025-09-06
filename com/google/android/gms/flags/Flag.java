package com.google.android.gms.flags;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@Deprecated
public abstract class Flag {
    @Deprecated
    public static class BooleanFlag extends Flag {
        public BooleanFlag(int v, String s, Boolean boolean0) {
            super(v, s, boolean0, null);
        }

        @Override  // com.google.android.gms.flags.Flag
        public final Object zza(zze zze0) {
            try {
                return Boolean.valueOf(zze0.getBooleanFlagValue(this.zzd(), ((Boolean)this.zzc()).booleanValue(), this.zzb()));
            }
            catch(RemoteException unused_ex) {
                return (Boolean)this.zzc();
            }
        }
    }

    @KeepForSdk
    @Deprecated
    public static class IntegerFlag extends Flag {
        public IntegerFlag(int v, String s, Integer integer0) {
            super(v, s, integer0, null);
        }

        @Override  // com.google.android.gms.flags.Flag
        public final Object zza(zze zze0) {
            try {
                return zze0.getIntFlagValue(this.zzd(), ((int)(((Integer)this.zzc()))), this.zzb());
            }
            catch(RemoteException unused_ex) {
                return (Integer)this.zzc();
            }
        }
    }

    @KeepForSdk
    @Deprecated
    public static class LongFlag extends Flag {
        public LongFlag(int v, String s, Long long0) {
            super(v, s, long0, null);
        }

        @Override  // com.google.android.gms.flags.Flag
        public final Object zza(zze zze0) {
            try {
                return zze0.getLongFlagValue(this.zzd(), ((long)(((Long)this.zzc()))), this.zzb());
            }
            catch(RemoteException unused_ex) {
                return (Long)this.zzc();
            }
        }
    }

    @KeepForSdk
    @Deprecated
    public static class StringFlag extends Flag {
        public StringFlag(int v, String s, String s1) {
            super(v, s, s1, null);
        }

        @Override  // com.google.android.gms.flags.Flag
        public final Object zza(zze zze0) {
            try {
                return zze0.getStringFlagValue(this.zzd(), ((String)this.zzc()), this.zzb());
            }
            catch(RemoteException unused_ex) {
                return (String)this.zzc();
            }
        }
    }

    private final int zza;
    private final String zzb;
    private final Object zzc;

    public Flag(int v, String s, Object object0, zza zza0) {
        this.zza = v;
        this.zzb = s;
        this.zzc = object0;
        Singletons.flagRegistry().zza(this);
    }

    @KeepForSdk
    @Deprecated
    public static BooleanFlag define(int v, String s, Boolean boolean0) {
        return new BooleanFlag(v, s, boolean0);
    }

    @KeepForSdk
    @Deprecated
    public static IntegerFlag define(int v, String s, int v1) {
        return new IntegerFlag(v, s, v1);
    }

    @KeepForSdk
    @Deprecated
    public static LongFlag define(int v, String s, long v1) {
        return new LongFlag(v, s, v1);
    }

    @KeepForSdk
    @Deprecated
    public static StringFlag define(int v, String s, String s1) {
        return new StringFlag(v, s, s1);
    }

    @KeepForSdk
    public Object get() {
        return Singletons.zza().zza(this);
    }

    public abstract Object zza(zze arg1);

    @Deprecated
    public final int zzb() {
        return this.zza;
    }

    public final Object zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzb;
    }
}

