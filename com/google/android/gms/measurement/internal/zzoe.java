package com.google.android.gms.measurement.internal;

import B7.b;
import I6.V;
import I6.Y;
import I6.b0;
import I6.u0;
import I6.w;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzko;
import com.google.android.gms.internal.measurement.zzkp;
import java.util.Map;

public final class zzoe {
    static final V zza;
    public static final int zzb;

    static {
        zzoe.zza = V.v("Version", "GoogleConsent", "VendorConsent", "VendorLegitimateInterest", "gdprApplies", "EnableAdvertiserConsentMode", "PolicyVersion", "PurposeConsents", "PurposeOneTreatment", "Purpose1", "Purpose3", "Purpose4", new String[]{"Purpose7", "CmpSdkID", "PublisherCC", "PublisherRestrictions1", "PublisherRestrictions3", "PublisherRestrictions4", "PublisherRestrictions7", "AuthorizePurpose1", "AuthorizePurpose3", "AuthorizePurpose4", "AuthorizePurpose7", "PurposeDiagnostics"});
    }

    public static String zza(SharedPreferences sharedPreferences0, String s) {
        try {
            return sharedPreferences0.getString(s, "");
        }
        catch(ClassCastException unused_ex) {
            return "";
        }
    }

    public static int zzb(SharedPreferences sharedPreferences0, String s) {
        try {
            return sharedPreferences0.getInt(s, -1);
        }
        catch(ClassCastException unused_ex) {
            return -1;
        }
    }

    public static final boolean zzc(zzko zzko0, Y y0, Y y1, b0 b00, char[] arr_c, int v, int v1, int v2, int v3, int v4, String s, String s1, String s2, boolean z, boolean z1, boolean z2) {
        char c;
        int v7;
        int v6;
        int v5 = zzoe.zze(zzko0, y0, y1, b00, arr_c, v, v1, v2, v3, v4, s, s1, s2, z, z1, z2);
        if(v5 <= 0) {
            v6 = v2;
            v7 = v1;
        }
        else if(v2 != 1) {
            arr_c[v5] = '2';
            v6 = v2;
            v7 = v1;
        }
        else if(v1 != 1) {
            arr_c[v5] = '2';
            v6 = 1;
            v7 = v1;
        }
        else {
            v7 = 1;
            v6 = 1;
        }
        if(zzoe.zzi(zzko0, y0, y1, b00, arr_c, v, v7, v6, v3, v4, s, s1, s2, z, z1, z2) == zzkp.zza) {
            c = '3';
        }
        else {
            int v8 = v4;
            if(zzko0 == zzko.zzb && v8 == 1) {
                if(b00.contains(s)) {
                    if(v5 > 0 && arr_c[v5] != 50) {
                        arr_c[v5] = '1';
                    }
                    return true;
                }
                v8 = 1;
            }
            if(y0.containsKey(zzko0)) {
                zzod zzod0 = (zzod)y0.get(zzko0);
                if(zzod0 == null) {
                    c = '0';
                }
                else {
                    switch(zzod0.ordinal()) {
                        case 0: {
                            if(zzoe.zzi(zzko0, y0, y1, b00, arr_c, v, v7, v6, v3, v8, s, s1, s2, z, z1, z2) != zzkp.zzc) {
                                return zzoe.zzg(zzko0, y0, y1, b00, arr_c, v, v7, v6, v3, v8, s, s1, s2, z, z1, z2);
                            }
                            c = '8';
                            break;
                        }
                        case 1: {
                            if(zzoe.zzi(zzko0, y0, y1, b00, arr_c, v, v7, v6, v3, v8, s, s1, s2, z, z1, z2) == zzkp.zzb) {
                                c = '8';
                                break;
                            }
                            return zzoe.zzh(zzko0, y0, y1, b00, arr_c, v, v7, v6, v3, v8, s, s1, s2, z, z1, z2);
                        }
                        case 2: {
                            return zzoe.zzi(zzko0, y0, y1, b00, arr_c, v, v7, v6, v3, v8, s, s1, s2, z, z1, z2) == zzkp.zzc ? zzoe.zzh(zzko0, y0, y1, b00, arr_c, v, v7, v6, v3, v8, s, s1, s2, z, z1, z2) : zzoe.zzg(zzko0, y0, y1, b00, arr_c, v, v7, v6, v3, v8, s, s1, s2, z, z1, z2);
                        }
                        case 3: {
                            return zzoe.zzi(zzko0, y0, y1, b00, arr_c, v, v7, v6, v3, v8, s, s1, s2, z, z1, z2) == zzkp.zzb ? zzoe.zzg(zzko0, y0, y1, b00, arr_c, v, v7, v6, v3, v8, s, s1, s2, z, z1, z2) : zzoe.zzh(zzko0, y0, y1, b00, arr_c, v, v7, v6, v3, v8, s, s1, s2, z, z1, z2);
                        }
                        default: {
                            c = '0';
                            break;
                        }
                    }
                }
            }
            else {
                c = '0';
            }
        }
        if(v5 > 0 && arr_c[v5] != 50) {
            arr_c[v5] = c;
        }
        return false;
    }

    public static final Map zzd(Y y0, Y y1, b0 b00, char[] arr_c, int v, int v1, int v2, int v3, int v4, String s, String s1, String s2, boolean z, boolean z1, boolean z2) {
        String s9;
        zzko zzko4;
        String s8;
        zzko zzko3;
        if(((Boolean)zzfx.zzba.zzb(null)).booleanValue() && !z2) {
            return u0.g;
        }
        zzkp zzkp0 = (zzkp)y1.get(zzko.zzb);
        zzko zzko0 = zzko.zzd;
        zzkp zzkp1 = (zzkp)y1.get(zzko0);
        zzko zzko1 = zzko.zze;
        zzkp zzkp2 = (zzkp)y1.get(zzko1);
        zzko zzko2 = zzko.zzh;
        zzkp zzkp3 = (zzkp)y1.get(zzko2);
        b b0 = new b(4);
        b0.v("Version", "2");
        String s3 = "1";
        b0.v("VendorConsent", (z ? "1" : "0"));
        b0.v("VendorLegitimateInterest", (z1 ? "1" : "0"));
        b0.v("gdprApplies", (v2 == 1 ? "1" : "0"));
        b0.v("EnableAdvertiserConsentMode", (v1 == 1 ? "1" : "0"));
        b0.v("PolicyVersion", String.valueOf(v3));
        b0.v("CmpSdkID", String.valueOf(v));
        b0.v("PurposeOneTreatment", (v4 == 1 ? "1" : "0"));
        b0.v("PublisherCC", s);
        b0.v("PublisherRestrictions1", String.valueOf((zzkp0 == null ? zzkp.zzd.zza() : zzkp0.zza())));
        b0.v("PublisherRestrictions3", String.valueOf((zzkp1 == null ? zzkp.zzd.zza() : zzkp1.zza())));
        b0.v("PublisherRestrictions4", String.valueOf((zzkp2 == null ? zzkp.zzd.zza() : zzkp2.zza())));
        b0.v("PublisherRestrictions7", String.valueOf((zzkp3 == null ? zzkp.zzd.zza() : zzkp3.zza())));
        String s4 = zzoe.zzf(zzko.zzb, y0, y1, b00, arr_c, v, v1, v2, v3, v4, s, s1, s2, z, z1, z2);
        String s5 = zzoe.zzf(zzko0, y0, y1, b00, arr_c, v, v1, v2, v3, v4, s, s1, s2, z, z1, z2);
        String s6 = zzoe.zzf(zzko1, y0, y1, b00, arr_c, v, v1, v2, v3, v4, s, s1, s2, z, z1, z2);
        String s7 = zzoe.zzf(zzko2, y0, y1, b00, arr_c, v, v1, v2, v3, v4, s, s1, s2, z, z1, z2);
        w.b("Purpose1", s4);
        w.b("Purpose3", s5);
        w.b("Purpose4", s6);
        w.b("Purpose7", s7);
        b b1 = b0.w(u0.g(4, new Object[]{"Purpose1", s4, "Purpose3", s5, "Purpose4", s6, "Purpose7", s7}, null));
        if(zzoe.zzc(zzko.zzb, y0, y1, b00, arr_c, v, v1, v2, v3, v4, s, s1, s2, z, z1, z2)) {
            zzko3 = zzko0;
            s8 = "1";
        }
        else {
            zzko3 = zzko0;
            s8 = "0";
        }
        if(zzoe.zzc(zzko3, y0, y1, b00, arr_c, v, v1, v2, v3, v4, s, s1, s2, z, z1, z2)) {
            zzko4 = zzko1;
            s9 = "1";
        }
        else {
            zzko4 = zzko1;
            s9 = "0";
        }
        String s10 = zzoe.zzc(zzko4, y0, y1, b00, arr_c, v, v1, v2, v3, v4, s, s1, s2, z, z1, z2) ? "1" : "0";
        if(!zzoe.zzc(zzko2, y0, y1, b00, arr_c, v, v1, v2, v3, v4, s, s1, s2, z, z1, z2)) {
            s3 = "0";
        }
        return b1.w(u0.g(5, new Object[]{"AuthorizePurpose1", s8, "AuthorizePurpose3", s9, "AuthorizePurpose4", s10, "AuthorizePurpose7", s3, "PurposeDiagnostics", new String(arr_c)}, null)).g();
    }

    private static final int zze(zzko zzko0, Y y0, Y y1, b0 b00, char[] arr_c, int v, int v1, int v2, int v3, int v4, String s, String s1, String s2, boolean z, boolean z1, boolean z2) {
        if(zzko0 == zzko.zzb) {
            return 1;
        }
        if(zzko0 == zzko.zzd) {
            return 2;
        }
        if(zzko0 == zzko.zze) {
            return 3;
        }
        return zzko0 == zzko.zzh ? 4 : -1;
    }

    private static final String zzf(zzko zzko0, Y y0, Y y1, b0 b00, char[] arr_c, int v, int v1, int v2, int v3, int v4, String s, String s1, String s2, boolean z, boolean z1, boolean z2) {
        String s3 = "0";
        String s4 = TextUtils.isEmpty(s1) || s1.length() < zzko0.zza() ? "0" : String.valueOf(s1.charAt(zzko0.zza() - 1));
        if(!TextUtils.isEmpty(s2) && s2.length() >= zzko0.zza()) {
            s3 = String.valueOf(s2.charAt(zzko0.zza() - 1));
        }
        return s4 + s3;
    }

    private static final boolean zzg(zzko zzko0, Y y0, Y y1, b0 b00, char[] arr_c, int v, int v1, int v2, int v3, int v4, String s, String s1, String s2, boolean z, boolean z1, boolean z2) {
        char c;
        int v5 = zzoe.zze(zzko0, y0, y1, b00, arr_c, v, v1, v2, v3, v4, s, s1, s2, z, z1, z2);
        boolean z3 = false;
        boolean z4 = false;
        if(!z) {
            z4 = true;
            c = '4';
        }
        else if(s1.length() < zzko0.zza()) {
            z4 = true;
            c = '0';
        }
        if(z4) {
            if(v5 > 0 && arr_c[v5] != 50) {
                arr_c[v5] = c;
            }
            return false;
        }
        int v6 = s1.charAt(zzko0.zza() - 1);
        char c1 = '1';
        if(v6 == 49) {
            z3 = true;
        }
        if(v5 > 0 && arr_c[v5] != 50) {
            if(v6 != 49) {
                c1 = '6';
            }
            arr_c[v5] = c1;
        }
        return z3;
    }

    private static final boolean zzh(zzko zzko0, Y y0, Y y1, b0 b00, char[] arr_c, int v, int v1, int v2, int v3, int v4, String s, String s1, String s2, boolean z, boolean z1, boolean z2) {
        char c;
        int v5 = zzoe.zze(zzko0, y0, y1, b00, arr_c, v, v1, v2, v3, v4, s, s1, s2, z, z1, z2);
        boolean z3 = false;
        boolean z4 = false;
        if(!z1) {
            z4 = true;
            c = '5';
        }
        else if(s2.length() < zzko0.zza()) {
            z4 = true;
            c = '0';
        }
        if(z4) {
            if(v5 > 0 && arr_c[v5] != 50) {
                arr_c[v5] = c;
            }
            return false;
        }
        int v6 = s2.charAt(zzko0.zza() - 1);
        char c1 = '1';
        if(v6 == 49) {
            z3 = true;
        }
        if(v5 > 0 && arr_c[v5] != 50) {
            if(v6 != 49) {
                c1 = '7';
            }
            arr_c[v5] = c1;
        }
        return z3;
    }

    private static final zzkp zzi(zzko zzko0, Y y0, Y y1, b0 b00, char[] arr_c, int v, int v1, int v2, int v3, int v4, String s, String s1, String s2, boolean z, boolean z1, boolean z2) {
        zzkp zzkp0 = zzkp.zzd;
        Object object0 = y1.get(zzko0);
        return object0 != null ? object0 : zzkp0;
    }
}

