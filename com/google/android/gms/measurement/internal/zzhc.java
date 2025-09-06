package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import b3.Z;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzql;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzhc {
    final zzhg zza;
    private final String zzb;
    private final Bundle zzc;
    private Bundle zzd;

    public zzhc(zzhg zzhg0, String s, Bundle bundle0) {
        Objects.requireNonNull(zzhg0);
        this.zza = zzhg0;
        super();
        Preconditions.checkNotEmpty(s);
        this.zzb = s;
        this.zzc = new Bundle();
    }

    // This method was un-flattened
    public final Bundle zza() {
        if(this.zzd == null) {
            zzhg zzhg0 = this.zza;
            String s = zzhg0.zzd().getString(this.zzb, null);
            if(s != null) {
                try {
                    Bundle bundle0 = new Bundle();
                    JSONArray jSONArray0 = new JSONArray(s);
                    for(int v = 0; true; ++v) {
                        if(v >= jSONArray0.length()) {
                            this.zzd = bundle0;
                            break;
                        }
                        try {
                            JSONObject jSONObject0 = jSONArray0.getJSONObject(v);
                            String s1 = jSONObject0.getString("n");
                            String s2 = jSONObject0.getString("t");
                            switch(s2) {
                                case "d": {
                                    bundle0.putDouble(s1, Double.parseDouble(jSONObject0.getString("v")));
                                    break;
                                }
                                case "ia": {
                                    zzql.zza();
                                    if(zzhg0.zzu.zzc().zzp(null, zzfx.zzaQ)) {
                                        JSONArray jSONArray1 = new JSONArray(jSONObject0.getString("v"));
                                        int v1 = jSONArray1.length();
                                        int[] arr_v = new int[v1];
                                        for(int v2 = 0; v2 < v1; ++v2) {
                                            arr_v[v2] = jSONArray1.optInt(v2);
                                        }
                                        bundle0.putIntArray(s1, arr_v);
                                    }
                                    break;
                                }
                                case "l": {
                                    bundle0.putLong(s1, Long.parseLong(jSONObject0.getString("v")));
                                    break;
                                }
                                case "la": {
                                    zzql.zza();
                                    if(zzhg0.zzu.zzc().zzp(null, zzfx.zzaQ)) {
                                        JSONArray jSONArray2 = new JSONArray(jSONObject0.getString("v"));
                                        int v3 = jSONArray2.length();
                                        long[] arr_v1 = new long[v3];
                                        for(int v4 = 0; v4 < v3; ++v4) {
                                            arr_v1[v4] = jSONArray2.optLong(v4);
                                        }
                                        bundle0.putLongArray(s1, arr_v1);
                                    }
                                    break;
                                }
                                case "s": {
                                    bundle0.putString(s1, jSONObject0.getString("v"));
                                    break;
                                }
                                default: {
                                    zzhg0.zzu.zzaV().zzb().zzb("Unrecognized persisted bundle type. Type", s2);
                                }
                            }
                        }
                        catch(JSONException | NumberFormatException unused_ex) {
                            this.zza.zzu.zzaV().zzb().zza("Error reading value from SharedPreferences. Value dropped");
                        }
                    }
                }
                catch(JSONException unused_ex) {
                    Z.u(this.zza.zzu, "Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if(this.zzd == null) {
                this.zzd = this.zzc;
            }
        }
        return new Bundle(((Bundle)Preconditions.checkNotNull(this.zzd)));
    }

    public final void zzb(Bundle bundle0) {
        Bundle bundle1 = bundle0 == null ? new Bundle() : new Bundle(bundle0);
        zzhg zzhg0 = this.zza;
        SharedPreferences.Editor sharedPreferences$Editor0 = zzhg0.zzd().edit();
        if(bundle1.size() == 0) {
            sharedPreferences$Editor0.remove(this.zzb);
        }
        else {
            String s = this.zzb;
            JSONArray jSONArray0 = new JSONArray();
            for(Object object0: bundle1.keySet()) {
                String s1 = (String)object0;
                Object object1 = bundle1.get(s1);
                if(object1 != null) {
                    try {
                        JSONObject jSONObject0 = new JSONObject();
                        jSONObject0.put("n", s1);
                        zzql.zza();
                        boolean z = zzhg0.zzu.zzc().zzp(null, zzfx.zzaQ);
                        zzib zzib0 = zzhg0.zzu;
                        if(z) {
                            if(!(object1 instanceof String)) {
                                if(!(object1 instanceof Long)) {
                                    if(!(object1 instanceof int[])) {
                                        if(object1 instanceof long[]) {
                                            jSONObject0.put("v", Arrays.toString(((long[])object1)));
                                            jSONObject0.put("t", "la");
                                            jSONArray0.put(jSONObject0);
                                        }
                                        else if(object1 instanceof Double) {
                                            jSONObject0.put("v", object1.toString());
                                            jSONObject0.put("t", "d");
                                            jSONArray0.put(jSONObject0);
                                        }
                                        else {
                                            zzib0.zzaV().zzb().zzb("Cannot serialize bundle value to SharedPreferences. Type", object1.getClass());
                                        }
                                        continue;
                                    }
                                    jSONObject0.put("v", Arrays.toString(((int[])object1)));
                                    jSONObject0.put("t", "ia");
                                    jSONArray0.put(jSONObject0);
                                    continue;
                                }
                                jSONObject0.put("v", object1.toString());
                                jSONObject0.put("t", "l");
                                jSONArray0.put(jSONObject0);
                                continue;
                            }
                            jSONObject0.put("v", object1.toString());
                            jSONObject0.put("t", "s");
                            jSONArray0.put(jSONObject0);
                            continue;
                        }
                        else {
                            jSONObject0.put("v", object1.toString());
                            if(object1 instanceof String) {
                                jSONObject0.put("t", "s");
                            }
                            else {
                                if(object1 instanceof Long) {
                                    jSONObject0.put("t", "l");
                                    jSONArray0.put(jSONObject0);
                                }
                                else if(object1 instanceof Double) {
                                    jSONObject0.put("t", "d");
                                    jSONArray0.put(jSONObject0);
                                }
                                else {
                                    zzib0.zzaV().zzb().zzb("Cannot serialize bundle value to SharedPreferences. Type", object1.getClass());
                                }
                                continue;
                            }
                        }
                        jSONArray0.put(jSONObject0);
                        continue;
                    }
                    catch(JSONException jSONException0) {
                    }
                    this.zza.zzu.zzaV().zzb().zzb("Cannot serialize bundle value to SharedPreferences", jSONException0);
                }
            }
            sharedPreferences$Editor0.putString(s, jSONArray0.toString());
        }
        sharedPreferences$Editor0.apply();
        this.zzd = bundle1;
    }
}

