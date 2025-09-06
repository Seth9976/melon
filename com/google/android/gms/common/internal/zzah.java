package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.net.Uri.Builder;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import k8.Y;

public final class zzah {
    private static final Uri zza;

    static {
        zzah.zza = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();
    }

    public static Intent zza(Context context0, zzn zzn0) {
        Bundle bundle1;
        Intent intent0 = null;
        String s = zzn0.zza();
        if(s == null) {
            return new Intent().setComponent(zzn0.zzc());
        }
        if(zzn0.zzd()) {
            Bundle bundle0 = Y.b("serviceActionBundleKey", s);
            try {
                ContentProviderClient contentProviderClient0 = context0.getContentResolver().acquireUnstableContentProviderClient(zzah.zza);
                if(contentProviderClient0 == null) {
                    throw new RemoteException("Failed to acquire ContentProviderClient");
                }
                try {
                    bundle1 = contentProviderClient0.call("serviceIntentCall", null, bundle0);
                }
                finally {
                    contentProviderClient0.release();
                }
            }
            catch(RemoteException | IllegalArgumentException remoteException0) {
                Log.w("ServiceBindIntentUtils", "Dynamic intent resolution failed: " + remoteException0.toString());
                bundle1 = null;
            }
            if(bundle1 != null) {
                Intent intent1 = (Intent)bundle1.getParcelable("serviceResponseIntentKey");
                if(intent1 == null) {
                    PendingIntent pendingIntent0 = (PendingIntent)bundle1.getParcelable("serviceMissingResolutionIntentKey");
                    if(pendingIntent0 != null) {
                        Log.w("ServiceBindIntentUtils", "Dynamic lookup for intent failed for action " + s + " but has possible resolution");
                        throw new zzaf(new ConnectionResult(25, pendingIntent0));
                    }
                }
                else {
                    intent0 = intent1;
                }
            }
            if(intent0 == null) {
                Log.w("ServiceBindIntentUtils", "Dynamic lookup for intent failed for action: " + s);
                return new Intent(s).setPackage(zzn0.zzb());
            }
        }
        return intent0 == null ? new Intent(s).setPackage(zzn0.zzb()) : intent0;
    }
}

