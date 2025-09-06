package com.google.android.gms.internal.auth;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.V;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public final class zzcp {
    private static volatile zzdh zza;

    public static zzdh zza(Context context0) {
        zzdh zzdh2;
        zzci zzci0;
        zzdh zzdh1;
        File file0;
        StrictMode.ThreadPolicy strictMode$ThreadPolicy0;
        zzdh zzdh0;
        synchronized(zzcp.class) {
            zzdh0 = zzcp.zza;
            if(zzdh0 == null) {
                String s = Build.TAGS;
                if(!Build.TYPE.equals("eng") && !Build.TYPE.equals("userdebug")) {
                    zzdh2 = zzdh.zzc();
                    zzdh0 = zzdh2;
                    zzcp.zza = zzdh0;
                    return zzdh0;
                }
                else if(s.contains("dev-keys") || s.contains("test-keys")) {
                    if(!context0.isDeviceProtectedStorage()) {
                        context0 = context0.createDeviceProtectedStorageContext();
                    }
                    strictMode$ThreadPolicy0 = StrictMode.allowThreadDiskReads();
                    goto label_10;
                }
                else {
                    zzdh2 = zzdh.zzc();
                }
                zzdh0 = zzdh2;
                zzcp.zza = zzdh0;
                return zzdh0;
            }
            return zzdh0;
        }
    label_10:
        StrictMode.allowThreadDiskWrites();
        try {
            file0 = new File(context0.getDir("phenotype_hermetic", 0), "overrides.txt");
        }
        catch(RuntimeException runtimeException0) {
            Log.e("HermeticFileOverrides", "no data dir", runtimeException0);
            zzdh1 = zzdh.zzc();
            goto label_18;
        }
        zzdh1 = file0.exists() ? zzdh.zzd(file0) : zzdh.zzc();
    label_18:
        if(zzdh1.zzb()) {
            Object object0 = zzdh1.zza();
            try(BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(new FileInputStream(((File)object0))))) {
                V v0 = new V(0);
                HashMap hashMap0 = new HashMap();
                String s1;
                while((s1 = bufferedReader0.readLine()) != null) {
                    String[] arr_s = s1.split(" ", 3);
                    if(arr_s.length == 3) {
                        String s2 = new String(arr_s[0]);
                        String s3 = Uri.decode(new String(arr_s[1]));
                        String s4 = (String)hashMap0.get(arr_s[2]);
                        if(s4 == null) {
                            String s5 = new String(arr_s[2]);
                            s4 = Uri.decode(s5);
                            if(s4.length() < 0x400 || s4 == s5) {
                                hashMap0.put(s5, s4);
                            }
                        }
                        if(!v0.containsKey(s2)) {
                            v0.put(s2, new V(0));
                        }
                        ((V)v0.get(s2)).put(s3, s4);
                    }
                    else {
                        Log.e("HermeticFileOverrides", "Invalid: " + s1);
                    }
                }
                Log.w("HermeticFileOverrides", "Parsed " + object0.toString() + " for Android package " + "com.iloen.melon");
                zzci0 = new zzci(v0);
            }
            catch(IOException iOException0) {
                throw new RuntimeException(iOException0);
            }
            zzdh2 = zzdh.zzd(zzci0);
        }
        else {
            zzdh2 = zzdh.zzc();
        }
        StrictMode.setThreadPolicy(strictMode$ThreadPolicy0);
        zzdh0 = zzdh2;
        zzcp.zza = zzdh0;
        return zzdh0;
    }
}

