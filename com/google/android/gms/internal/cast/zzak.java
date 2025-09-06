package com.google.android.gms.internal.cast;

import android.os.IInterface;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.media.internal.zzh;
import com.google.android.gms.cast.framework.media.internal.zzj;
import com.google.android.gms.cast.framework.zzag;
import com.google.android.gms.cast.framework.zzaj;
import com.google.android.gms.cast.framework.zzat;
import com.google.android.gms.cast.framework.zzaw;
import com.google.android.gms.cast.framework.zzbe;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

public interface zzak extends IInterface {
    int zze();

    zzaj zzf(IObjectWrapper arg1, CastOptions arg2, zzam arg3, Map arg4);

    com.google.android.gms.cast.framework.zzam zzg(CastOptions arg1, IObjectWrapper arg2, zzag arg3);

    zzat zzh(IObjectWrapper arg1, IObjectWrapper arg2, IObjectWrapper arg3);

    zzaw zzi(String arg1, String arg2, zzbe arg3);

    zzh zzj(IObjectWrapper arg1, zzj arg2, int arg3, int arg4, boolean arg5, long arg6, int arg7, int arg8, int arg9);

    zzh zzk(IObjectWrapper arg1, IObjectWrapper arg2, zzj arg3, int arg4, int arg5, boolean arg6, long arg7, int arg8, int arg9, int arg10);
}

