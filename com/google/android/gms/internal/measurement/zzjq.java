package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.RemoteException;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzjq implements zzju {
    public static final String[] zza;
    private static final Map zzb;
    private final ContentResolver zzc;
    private final Uri zzd;
    private final Runnable zze;
    private final ContentObserver zzf;
    private final Object zzg;
    private volatile Map zzh;
    private final List zzi;

    static {
        zzjq.zzb = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        zzjq.zza = new String[]{"key", "value"};
    }

    private zzjq(ContentResolver contentResolver0, Uri uri0, Runnable runnable0) {
        this.zzg = new Object();
        this.zzi = new ArrayList();
        contentResolver0.getClass();
        uri0.getClass();
        this.zzc = contentResolver0;
        this.zzd = uri0;
        this.zze = runnable0;
        this.zzf = new zzjo(this, null);
    }

    public static zzjq zza(ContentResolver contentResolver0, Uri uri0, Runnable runnable0) {
        synchronized(zzjq.class) {
            Map map0 = zzjq.zzb;
            zzjq zzjq0 = (zzjq)map0.get(uri0);
            if(zzjq0 == null) {
                try {
                    zzjq zzjq1 = new zzjq(contentResolver0, uri0, runnable0);
                    try {
                        contentResolver0.registerContentObserver(uri0, false, zzjq1.zzf);
                        map0.put(uri0, zzjq1);
                    }
                    catch(SecurityException unused_ex) {
                    }
                    zzjq0 = zzjq1;
                }
                catch(SecurityException unused_ex) {
                }
            }
            return zzjq0;
        }
    }

    public final Map zzb() {
        Map map1;
        Map map0 = this.zzh;
        if(map0 == null) {
            synchronized(this.zzg) {
                map0 = this.zzh;
                if(map0 == null) {
                    StrictMode.ThreadPolicy strictMode$ThreadPolicy0 = StrictMode.allowThreadDiskReads();
                    try {
                        try {
                            map1 = (Map)zzju.zzg(() -> {
                                Map map1;
                                Uri uri0 = this.zzd;
                                ContentProviderClient contentProviderClient0 = this.zzc.acquireUnstableContentProviderClient(uri0);
                                if(contentProviderClient0 == null) {
                                    Log.w("ConfigurationContentLdr", "Unable to acquire ContentProviderClient, using default values");
                                    return Collections.EMPTY_MAP;
                                }
                                try(Cursor cursor0 = contentProviderClient0.query(uri0, zzjq.zza, null, null, null)) {
                                    if(cursor0 != null) {
                                        int v1 = cursor0.getCount();
                                        if(v1 == 0) {
                                            return Collections.EMPTY_MAP;
                                        }
                                        map1 = v1 <= 0x100 ? new f(v1) : new HashMap(v1, 1.0f);  // 初始化器: Landroidx/collection/V;-><init>(I)V
                                        while(true) {
                                            if(!cursor0.moveToNext()) {
                                                break;
                                            }
                                            map1.put(cursor0.getString(0), cursor0.getString(1));
                                        }
                                        if(!cursor0.isAfterLast()) {
                                            Log.w("ConfigurationContentLdr", "Cursor read incomplete (ContentProvider dead?), using default values");
                                            return Collections.EMPTY_MAP;
                                        }
                                        return map1;
                                    }
                                    Log.w("ConfigurationContentLdr", "ContentProvider query returned null cursor, using default values");
                                    return Collections.EMPTY_MAP;
                                }
                                catch(RemoteException remoteException0) {
                                    Log.w("ConfigurationContentLdr", "ContentProvider query failed, using default values", remoteException0);
                                    return Collections.EMPTY_MAP;
                                }
                                finally {
                                    contentProviderClient0.release();
                                }
                            });
                        }
                        catch(SecurityException | SQLiteException | IllegalStateException securityException0) {
                            Log.w("ConfigurationContentLdr", "Unable to query ContentProvider, using default values", securityException0);
                            map1 = Collections.EMPTY_MAP;
                        }
                    }
                    catch(Throwable throwable0) {
                        StrictMode.setThreadPolicy(strictMode$ThreadPolicy0);
                        throw throwable0;
                    }
                    StrictMode.setThreadPolicy(strictMode$ThreadPolicy0);
                    this.zzh = map1;
                    map0 = map1;
                }
            }
        }
        return map0 == null ? Collections.EMPTY_MAP : map0;
    }

    public final void zzc() {
        synchronized(this.zzg) {
            this.zzh = null;
            this.zze.run();
        }
        synchronized(this) {
            for(Object object0: this.zzi) {
                ((zzjr)object0).zza();
            }
        }
    }

    public static void zzd() {
        synchronized(zzjq.class) {
            Map map0 = zzjq.zzb;
            for(Object object0: map0.values()) {
                ((zzjq)object0).zzc.unregisterContentObserver(((zzjq)object0).zzf);
            }
            map0.clear();
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzju
    public final Object zze(String s) {
        return (String)this.zzb().get(s);
    }

    // 检测为 Lambda 实现
    public final Map zzf() [...]
}

