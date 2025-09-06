package com.google.android.gms.internal.measurement;

import H6.a;
import H6.f;
import H6.i;
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

public final class zzjy {
    private static volatile f zza;

    public static f zza(Context context0) {
        a a1;
        zzjs zzjs0;
        a a0;
        File file0;
        f f0 = zzjy.zza;
        if(f0 == null) {
            synchronized(zzjy.class) {
                f f1 = zzjy.zza;
                if(f1 == null) {
                    if((Build.TYPE.equals("eng") || Build.TYPE.equals("userdebug")) && (Build.TAGS.contains("dev-keys") || Build.TAGS.contains("test-keys"))) {
                        Context context1 = context0.isDeviceProtectedStorage() ? context0 : context0.createDeviceProtectedStorageContext();
                        StrictMode.ThreadPolicy strictMode$ThreadPolicy0 = StrictMode.allowThreadDiskReads();
                        try {
                            StrictMode.allowThreadDiskWrites();
                            try {
                                file0 = new File(context1.getDir("phenotype_hermetic", 0), "overrides.txt");
                            }
                            catch(RuntimeException runtimeException0) {
                                Log.e("HermeticFileOverrides", "no data dir", runtimeException0);
                                a0 = a.a;
                                goto label_23;
                            }
                            a0 = file0.exists() ? new i(file0) : a.a;
                        label_23:
                            if(a0.b()) {
                                File file1 = (File)a0.a();
                                try(BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(new FileInputStream(file1)))) {
                                    V v1 = new V(0);
                                    HashMap hashMap0 = new HashMap();
                                    String s;
                                    while((s = bufferedReader0.readLine()) != null) {
                                        String[] arr_s = s.split(" ", 3);
                                        if(arr_s.length == 3) {
                                            String s1 = new String(arr_s[0]);
                                            String s2 = Uri.decode(new String(arr_s[1]));
                                            String s3 = (String)hashMap0.get(arr_s[2]);
                                            if(s3 == null) {
                                                String s4 = new String(arr_s[2]);
                                                s3 = Uri.decode(s4);
                                                if(s3.length() < 0x400 || s3 == s4) {
                                                    hashMap0.put(s4, s3);
                                                }
                                            }
                                            V v2 = (V)v1.get(s1);
                                            if(v2 == null) {
                                                v2 = new V(0);
                                                v1.put(s1, v2);
                                            }
                                            v2.put(s2, s3);
                                        }
                                        else {
                                            Log.e("HermeticFileOverrides", "Invalid: " + s);
                                        }
                                    }
                                    Log.w("HermeticFileOverrides", "Parsed " + file1.toString() + " for Android package " + "com.iloen.melon");
                                    zzjs0 = new zzjs(v1);
                                }
                                catch(IOException iOException0) {
                                    throw new RuntimeException(iOException0);
                                }
                                a1 = new i(zzjs0);
                            }
                            else {
                                a1 = a.a;
                            }
                        }
                        catch(Throwable throwable0) {
                            StrictMode.setThreadPolicy(strictMode$ThreadPolicy0);
                            throw throwable0;
                        }
                        StrictMode.setThreadPolicy(strictMode$ThreadPolicy0);
                        f1 = a1;
                    }
                    else {
                        f1 = a.a;
                    }
                    zzjy.zza = f1;
                }
                return f1;
            }
        }
        return f0;
    }
}

