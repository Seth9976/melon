package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzjl implements zzjh {
    private final AtomicBoolean zza;
    private HashMap zzb;
    private final HashMap zzc;
    private final HashMap zzd;
    private final HashMap zze;
    private final HashMap zzf;
    private Object zzg;
    private boolean zzh;
    private final String[] zzi;

    public zzjl() {
        this.zza = new AtomicBoolean();
        this.zzb = null;
        this.zzc = new HashMap(16, 1.0f);
        this.zzd = new HashMap(16, 1.0f);
        this.zze = new HashMap(16, 1.0f);
        this.zzf = new HashMap(16, 1.0f);
        this.zzg = null;
        this.zzh = false;
        this.zzi = new String[0];
    }

    @Override  // com.google.android.gms.internal.measurement.zzjh
    public final String zza(ContentResolver contentResolver0, String s, String s1) {
        String s4;
        ContentProviderClient contentProviderClient0;
        Uri uri0;
        if(contentResolver0 == null) {
            throw new IllegalStateException("ContentResolver needed with GservicesDelegateSupplier.init()");
        }
        String s2 = null;
        synchronized(this) {
            if(this.zzb == null) {
                this.zza.set(false);
                this.zzb = new HashMap(16, 1.0f);
                this.zzg = new Object();
                zzjj zzjj0 = new zzjj(this, null);
                contentResolver0.registerContentObserver(zzjg.zza, true, zzjj0);
            }
            else if(this.zza.getAndSet(false)) {
                this.zzb.clear();
                this.zzc.clear();
                this.zzd.clear();
                this.zze.clear();
                this.zzf.clear();
                this.zzg = new Object();
                this.zzh = false;
            }
            Object object0 = this.zzg;
            if(this.zzb.containsKey(s)) {
                String s3 = (String)this.zzb.get(s);
                if(s3 != null) {
                    s2 = s3;
                }
                return s2;
            }
            goto label_29;
        }
        return s2;
    label_29:
        try {
            uri0 = zzjg.zza;
            contentProviderClient0 = contentResolver0.acquireUnstableContentProviderClient(uri0);
            if(contentProviderClient0 != null) {
                goto label_33;
            }
        }
        catch(zzjk unused_ex) {
        }
        return null;
        try {
            try {
            label_33:
                try(Cursor cursor0 = contentProviderClient0.query(uri0, null, null, new String[]{s}, null)) {
                    if(cursor0 == null) {
                        throw new zzjk("ContentProvider query returned null cursor");
                    }
                    if(cursor0.moveToFirst()) {
                        s4 = cursor0.getString(1);
                        goto label_47;
                    }
                    else {
                        goto label_49;
                    }
                }
            }
            catch(RemoteException remoteException0) {
                throw new zzjk("ContentProvider query failed", remoteException0);
            }
        }
        catch(Throwable throwable1) {
            try {
                contentProviderClient0.release();
                throw throwable1;
            label_47:
                contentProviderClient0.release();
                goto label_51;
            label_49:
                contentProviderClient0.release();
                s4 = null;
            }
            catch(zzjk unused_ex) {
                return null;
            }
        }
    label_51:
        if(s4 != null && s4.equals(null)) {
            s4 = null;
        }
        synchronized(this) {
            if(object0 == this.zzg) {
                this.zzb.put(s, s4);
            }
        }
        return s4 == null ? null : s4;
    }

    public final AtomicBoolean zzb() {
        return this.zza;
    }
}

