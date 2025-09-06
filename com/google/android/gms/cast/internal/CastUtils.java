package com.google.android.gms.cast.internal;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.iloen.melon.utils.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@KeepForSdk
public final class CastUtils {
    public static final int zza;
    private static final Pattern zzb;
    private static final Random zzc;

    static {
        CastUtils.zzb = Pattern.compile("urn:x-cast:[-A-Za-z0-9_]+(\\.[-A-Za-z0-9_]+)*");
        CastUtils.zzc = new Random(SystemClock.elapsedRealtime());
    }

    @KeepForSdk
    public static JSONObject jsonStringToJsonObject(String s) {
        if(s == null) {
            return null;
        }
        try {
            return new JSONObject(s);
        }
        catch(JSONException unused_ex) {
            return null;
        }
    }

    @KeepForSdk
    public static double millisecToSec(long v) [...] // Inlined contents

    @KeepForSdk
    public static String optStringOrNull(JSONObject jSONObject0, String s) {
        return jSONObject0 == null || !jSONObject0.has(s) ? null : jSONObject0.optString(s);
    }

    @KeepForSdk
    public static long secToMillisec(double f) [...] // Inlined contents

    @KeepForSdk
    public static long secToMillisec(long v) [...] // Inlined contents

    @KeepForSdk
    public static void throwIfInvalidNamespace(String s) {
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException("Namespace cannot be null or empty");
        }
        if(s.length() > 0x80) {
            throw new IllegalArgumentException("Invalid namespace length");
        }
        if(!s.startsWith("urn:x-cast:")) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\"");
        }
        if(s.length() == 11) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\" and have non-empty suffix");
        }
    }

    @KeepForSdk
    public static long[] toLongArray(Collection collection0) {
        long[] arr_v = new long[collection0.size()];
        int v = 0;
        for(Object object0: collection0) {
            arr_v[v] = (long)(((Long)object0));
            ++v;
        }
        return arr_v;
    }

    @KeepForSdk
    public static long[] toLongArraySafely(JSONArray jSONArray0) {
        try {
            return CastUtils.zzg(jSONArray0);
        }
        catch(JSONException unused_ex) {
            return null;
        }
    }

    public static long zza() {
        return CastUtils.zzc.nextLong();
    }

    public static String zzb(Locale locale0) {
        StringBuilder stringBuilder0 = new StringBuilder(20);
        stringBuilder0.append(locale0.getLanguage());
        String s = locale0.getCountry();
        if(!TextUtils.isEmpty(s)) {
            stringBuilder0.append('-');
            stringBuilder0.append(s);
        }
        String s1 = locale0.getVariant();
        if(!TextUtils.isEmpty(s1)) {
            stringBuilder0.append('-');
            stringBuilder0.append(s1);
        }
        return stringBuilder0.toString();
    }

    public static String zzc(String s) {
        if(CastUtils.zzb.matcher(s).matches()) {
            return s;
        }
        StringBuilder stringBuilder0 = new StringBuilder(s.length());
        for(int v = 0; v < s.length(); ++v) {
            int v1 = s.charAt(v);
            if(v1 >= 65 && v1 <= 90 || v1 >= 97 && v1 <= 0x7A || v1 >= 0x30 && v1 <= 57 || (v1 == 45 || v1 == 46 || v1 == 58 || v1 == 0x5F)) {
                stringBuilder0.append(((char)v1));
            }
            else {
                stringBuilder0.append(String.format("%%%04x", v1));
            }
        }
        return stringBuilder0.toString();
    }

    public static List zzd(int[] arr_v) {
        List list0 = new ArrayList();
        for(int v = 0; v < arr_v.length; v = a.d(arr_v[v], v, 1, ((ArrayList)list0))) {
        }
        return list0;
    }

    public static boolean zze(Object object0, Object object1) {
        return object0 != null || object1 != null ? object0 != null && object1 != null && object0.equals(object1) : true;
    }

    public static int[] zzf(Collection collection0) {
        int[] arr_v = new int[collection0.size()];
        int v = 0;
        for(Object object0: collection0) {
            arr_v[v] = (int)(((Integer)object0));
            ++v;
        }
        return arr_v;
    }

    public static long[] zzg(JSONArray jSONArray0) {
        if(jSONArray0 == null) {
            return null;
        }
        long[] arr_v = new long[jSONArray0.length()];
        for(int v = 0; v < jSONArray0.length(); ++v) {
            arr_v[v] = jSONArray0.getLong(v);
        }
        return arr_v;
    }
}

