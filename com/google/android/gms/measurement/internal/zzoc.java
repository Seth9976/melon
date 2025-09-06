package com.google.android.gms.measurement.internal;

import I6.V;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class zzoc {
    private final Map zza;

    public zzoc(Map map0) {
        HashMap hashMap0 = new HashMap();
        this.zza = hashMap0;
        hashMap0.putAll(map0);
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof zzoc ? this.zza().equalsIgnoreCase(((zzoc)object0).zza()) : false;
    }

    @Override
    public final int hashCode() {
        return this.zza().hashCode();
    }

    @Override
    public final String toString() {
        return this.zza();
    }

    public final String zza() {
        StringBuilder stringBuilder0 = new StringBuilder();
        V v0 = zzoe.zza;
        int v1 = v0.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            String s = (String)v0.get(v2);
            Map map0 = this.zza;
            if(map0.containsKey(s)) {
                if(stringBuilder0.length() > 0) {
                    stringBuilder0.append(";");
                }
                stringBuilder0.append(s);
                stringBuilder0.append("=");
                stringBuilder0.append(((String)map0.get(s)));
            }
        }
        return stringBuilder0.toString();
    }

    public final Bundle zzb() {
        zzfw zzfw0 = zzfx.zzaZ;
        if(!((Boolean)zzfw0.zzb(null)).booleanValue()) {
            if("1".equals(this.zza.get("GoogleConsent")) && "1".equals(this.zza.get("gdprApplies")) && "1".equals(this.zza.get("EnableAdvertiserConsentMode"))) {
            label_5:
                if(!((Boolean)zzfw0.zzb(null)).booleanValue()) {
                    return this.zzf();
                }
                Map map0 = this.zza;
                if(map0.get("Version") == null) {
                    return this.zzf();
                }
                if(this.zzg() >= 0) {
                    Bundle bundle0 = new Bundle();
                    String s = "granted";
                    bundle0.putString("ad_storage", (Objects.equals(map0.get("AuthorizePurpose1"), "1") ? "granted" : "denied"));
                    bundle0.putString("ad_personalization", (!Objects.equals(map0.get("AuthorizePurpose3"), "1") || !Objects.equals(map0.get("AuthorizePurpose4"), "1") ? "denied" : "granted"));
                    if(this.zzg() >= 4) {
                        if(!Objects.equals(map0.get("AuthorizePurpose1"), "1") || !Objects.equals(map0.get("AuthorizePurpose7"), "1")) {
                            s = "denied";
                        }
                        bundle0.putString("ad_user_data", s);
                    }
                    return bundle0;
                }
            }
        }
        else if("1".equals(this.zza.get("gdprApplies")) && "1".equals(this.zza.get("EnableAdvertiserConsentMode"))) {
            goto label_5;
        }
        return Bundle.EMPTY;
    }

    public final String zzc() {
        String s = (String)this.zza.get("PurposeDiagnostics");
        return TextUtils.isEmpty(s) ? "200000" : s;
    }

    public final String zzd(zzoc zzoc0) {
        String s = "0";
        String s1 = zzoc0.zza.isEmpty() || ((String)zzoc0.zza.get("Version")) != null ? "0" : "1";
        Bundle bundle0 = this.zzb();
        Bundle bundle1 = zzoc0.zzb();
        if(bundle0.size() != bundle1.size() || !Objects.equals(bundle0.getString("ad_storage"), bundle1.getString("ad_storage")) || !Objects.equals(bundle0.getString("ad_personalization"), bundle1.getString("ad_personalization")) || !Objects.equals(bundle0.getString("ad_user_data"), bundle1.getString("ad_user_data"))) {
            s = "1";
        }
        return s1 + s;
    }

    public final String zze() {
        StringBuilder stringBuilder0 = new StringBuilder("1");
        int v = -1;
        try {
            String s = (String)this.zza.get("CmpSdkID");
            if(!TextUtils.isEmpty(s)) {
                v = Integer.parseInt(s);
            }
        }
        catch(NumberFormatException unused_ex) {
        }
        if(v < 0 || v > 0xFFF) {
            stringBuilder0.append("00");
        }
        else {
            stringBuilder0.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(v >> 6));
            stringBuilder0.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(v & 0x3F));
        }
        int v1 = this.zzg();
        if(v1 < 0 || v1 > 0x3F) {
            stringBuilder0.append("0");
        }
        else {
            stringBuilder0.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(v1));
        }
        Preconditions.checkArgument(true);
        int v2 = "1".equals(this.zza.get("gdprApplies")) ? 2 : 0;
        stringBuilder0.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(("1".equals(this.zza.get("EnableAdvertiserConsentMode")) ? v2 | 12 : v2 | 4)));
        return stringBuilder0.toString();
    }

    private final Bundle zzf() {
        Map map0 = this.zza;
        if("1".equals(map0.get("GoogleConsent"))) {
            int v = this.zzg();
            if(v >= 0) {
                String s = (String)map0.get("PurposeConsents");
                if(!TextUtils.isEmpty(s)) {
                    Bundle bundle0 = new Bundle();
                    String s1 = "denied";
                    if(s.length() > 0) {
                        bundle0.putString("ad_storage", (s.charAt(0) == 49 ? "granted" : "denied"));
                    }
                    if(s.length() > 3) {
                        bundle0.putString("ad_personalization", (s.charAt(2) != 49 || s.charAt(3) != 49 ? "denied" : "granted"));
                    }
                    if(s.length() > 6 && v >= 4) {
                        if(s.charAt(0) == 49 && s.charAt(6) == 49) {
                            s1 = "granted";
                        }
                        bundle0.putString("ad_user_data", s1);
                    }
                    return bundle0;
                }
            }
        }
        return Bundle.EMPTY;
    }

    private final int zzg() {
        try {
            String s = (String)this.zza.get("PolicyVersion");
            return TextUtils.isEmpty(s) ? -1 : Integer.parseInt(s);
        }
        catch(NumberFormatException unused_ex) {
        }
        return -1;
    }
}

