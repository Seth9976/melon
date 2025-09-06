package com.google.android.gms.cast.framework.media.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.internal.cast.zzag;

public final class zze extends AsyncTask {
    private static final Logger zza;
    private final zzh zzb;
    private final zzb zzc;

    static {
        zze.zza = new Logger("FetchBitmapTask");
    }

    public zze(Context context0, int v, int v1, boolean z, long v2, int v3, int v4, int v5, zzb zzb0) {
        this.zzc = zzb0;
        this.zzb = zzag.zze(context0.getApplicationContext(), this, new zzc(this, null), v, v1, false, 0x200000L, 5, 333, 10000);
    }

    @Override  // android.os.AsyncTask
    public final Object doInBackground(Object[] arr_object) {
        if(((Uri[])arr_object).length == 1) {
            Uri uri0 = ((Uri[])arr_object)[0];
            if(uri0 == null) {
                return null;
            }
            zzh zzh0 = this.zzb;
            if(zzh0 == null) {
                return null;
            }
            try {
                return zzh0.zze(uri0);
            }
            catch(RemoteException remoteException0) {
                zze.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"doFetch", "zzh"});
            }
        }
        return null;
    }

    @Override  // android.os.AsyncTask
    public final void onPostExecute(Object object0) {
        zzb zzb0 = this.zzc;
        if(zzb0 != null) {
            zzb0.zzb(((Bitmap)object0));
        }
    }

    public static void zza(zze zze0, Object[] arr_object) {
        zze0.publishProgress(arr_object);
    }
}

