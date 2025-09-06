package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.flags.zzd;

@DynamiteApi
public class FlagProviderImpl extends zzd {
    private boolean zza;
    private SharedPreferences zzb;

    public FlagProviderImpl() {
        this.zza = false;
    }

    @Override  // com.google.android.gms.flags.zze
    public boolean getBooleanFlagValue(String s, boolean z, int v) {
        Boolean boolean0;
        if(!this.zza) {
            return z;
        }
        try {
            boolean0 = Boolean.valueOf(z);
            return ((Boolean)com.google.android.gms.internal.flags.zzd.zza(new zza(this.zzb, s, boolean0))).booleanValue();
        }
        catch(Exception exception0) {
            String s1 = exception0.getMessage();
            Log.w("FlagDataUtils", (s1.length() == 0 ? new String("Flag value not available, returning default: ") : "Flag value not available, returning default: " + s1));
            return boolean0.booleanValue();
        }
    }

    @Override  // com.google.android.gms.flags.zze
    public int getIntFlagValue(String s, int v, int v1) {
        Integer integer0;
        if(!this.zza) {
            return v;
        }
        try {
            integer0 = v;
            return (int)(((Integer)com.google.android.gms.internal.flags.zzd.zza(new zzb(this.zzb, s, integer0))));
        }
        catch(Exception exception0) {
            String s1 = exception0.getMessage();
            Log.w("FlagDataUtils", (s1.length() == 0 ? new String("Flag value not available, returning default: ") : "Flag value not available, returning default: " + s1));
            return (int)integer0;
        }
    }

    @Override  // com.google.android.gms.flags.zze
    public long getLongFlagValue(String s, long v, int v1) {
        Long long0;
        if(!this.zza) {
            return v;
        }
        try {
            long0 = v;
            return (long)(((Long)com.google.android.gms.internal.flags.zzd.zza(new zzc(this.zzb, s, long0))));
        }
        catch(Exception exception0) {
            String s1 = exception0.getMessage();
            Log.w("FlagDataUtils", (s1.length() == 0 ? new String("Flag value not available, returning default: ") : "Flag value not available, returning default: " + s1));
            return (long)long0;
        }
    }

    @Override  // com.google.android.gms.flags.zze
    public String getStringFlagValue(String s, String s1, int v) {
        if(!this.zza) {
            return s1;
        }
        try {
            return (String)com.google.android.gms.internal.flags.zzd.zza(new com.google.android.gms.flags.impl.zzd(this.zzb, s, s1));
        }
        catch(Exception exception0) {
            String s2 = exception0.getMessage();
            Log.w("FlagDataUtils", (s2.length() == 0 ? new String("Flag value not available, returning default: ") : "Flag value not available, returning default: " + s2));
            return s1;
        }
    }

    @Override  // com.google.android.gms.flags.zze
    public void init(IObjectWrapper iObjectWrapper0) {
        Context context0 = (Context)ObjectWrapper.unwrap(iObjectWrapper0);
        if(!this.zza) {
            try {
                this.zzb = zzf.zza(context0.createPackageContext("com.google.android.gms", 0));
                this.zza = true;
                return;
            }
            catch(PackageManager.NameNotFoundException exception0) {
            }
            catch(Exception unused_ex) {
                return;
            }
            String s = exception0.getMessage();
            Log.w("FlagProviderImpl", (s.length() == 0 ? new String("Could not retrieve sdk flags, continuing with defaults: ") : "Could not retrieve sdk flags, continuing with defaults: " + s));
        }
    }
}

