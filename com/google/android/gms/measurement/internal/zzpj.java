package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import b3.Z;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfh;
import com.google.android.gms.internal.measurement.zzfl;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzha;
import com.google.android.gms.internal.measurement.zzhe;
import com.google.android.gms.internal.measurement.zzhg;
import com.google.android.gms.internal.measurement.zzhl;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhq;
import com.google.android.gms.internal.measurement.zzhr;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhv;
import com.google.android.gms.internal.measurement.zzhw;
import com.google.android.gms.internal.measurement.zzic;
import com.google.android.gms.internal.measurement.zzid;
import com.google.android.gms.internal.measurement.zzii;
import com.google.android.gms.internal.measurement.zzik;
import com.google.android.gms.internal.measurement.zzis;
import com.google.android.gms.internal.measurement.zzit;
import com.google.android.gms.internal.measurement.zziu;
import com.google.android.gms.internal.measurement.zzlq;
import com.google.android.gms.internal.measurement.zznk;
import com.google.android.gms.internal.measurement.zzql;
import com.google.android.gms.internal.measurement.zzqu;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import k8.Y;

public final class zzpj extends zzor {
    public zzpj(zzpf zzpf0) {
        super(zzpf0);
    }

    public final zzbg zzA(zzaa zzaa0) {
        String s;
        Bundle bundle0 = this.zzB(zzaa0.zzf(), true);
        if(bundle0.containsKey("_o")) {
            Object object0 = bundle0.get("_o");
            s = object0 == null ? "app" : object0.toString();
        }
        else {
            s = "app";
        }
        String s1 = zzjl.zzb(zzaa0.zzb());
        if(s1 == null) {
            s1 = zzaa0.zzb();
        }
        return new zzbg(s1, new zzbe(bundle0), s, zzaa0.zza());
    }

    public final Bundle zzB(Map map0, boolean z) {
        Bundle bundle0 = new Bundle();
        for(Object object0: map0.keySet()) {
            String s = (String)object0;
            Object object1 = map0.get(s);
            if(object1 == null) {
                bundle0.putString(s, null);
            }
            else if(object1 instanceof Long) {
                bundle0.putLong(s, ((long)(((Long)object1))));
            }
            else if(object1 instanceof Double) {
                bundle0.putDouble(s, ((double)(((Double)object1))));
            }
            else if(!(object1 instanceof ArrayList)) {
                bundle0.putString(s, object1.toString());
            }
            else if(z) {
                ArrayList arrayList0 = (ArrayList)object1;
                ArrayList arrayList1 = new ArrayList();
                int v = arrayList0.size();
                for(int v1 = 0; v1 < v; ++v1) {
                    arrayList1.add(this.zzB(((Map)arrayList0.get(v1)), false));
                }
                bundle0.putParcelableArray(s, ((Parcelable[])arrayList1.toArray(new Parcelable[0])));
            }
        }
        return bundle0;
    }

    public static final void zzC(zzhr zzhr0, String s, Object object0) {
        List list0 = zzhr0.zza();
        int v;
        for(v = 0; true; ++v) {
            if(v >= list0.size()) {
                v = -1;
                break;
            }
            if(s.equals("")) {
                break;
            }
        }
        zzhv zzhv0 = zzhw.zzn();
        zzhv0.zzb(s);
        zzhv0.zzf(((long)(((Long)object0))));
        if(v >= 0) {
            zzhr0.zze(v, zzhv0);
            return;
        }
        zzhr0.zzg(zzhv0);
    }

    public static final boolean zzD(zzbg zzbg0, zzr zzr0) {
        Preconditions.checkNotNull(zzbg0);
        Preconditions.checkNotNull(zzr0);
        return !TextUtils.isEmpty(zzr0.zzb);
    }

    public static final Bundle zzE(List list0) {
        Bundle bundle0 = new Bundle();
        for(Object object0: list0) {
            zzhw zzhw0 = (zzhw)object0;
            if(zzhw0.zzi()) {
                bundle0.putDouble("", zzhw0.zzj());
            }
            else if(zzhw0.zzg()) {
                bundle0.putFloat("", zzhw0.zzh());
            }
            else if(zzhw0.zzc()) {
                bundle0.putString("", "");
            }
            else if(zzhw0.zze()) {
                bundle0.putLong("", zzhw0.zzf());
            }
        }
        return bundle0;
    }

    public static final zzhw zzF(zzhs zzhs0, String s) {
        for(Object object0: zzhs0.zza()) {
            zzhw zzhw0 = (zzhw)object0;
            if("".equals(s)) {
                return zzhw0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    public static final Map zzG(zzhs zzhs0, String[] arr_s) {
        Map map0 = new HashMap();
        for(Object object0: zzhs0.zza()) {
            zzhw zzhw0 = (zzhw)object0;
            if(Arrays.asList(arr_s).contains("")) {
                Object object1 = zzpj.zzP(zzhw0);
                if(object1 != null) {
                    ((HashMap)map0).put("", object1);
                }
            }
        }
        return map0;
    }

    public static final Map zzH(zzhs zzhs0, String s) {
        Map map0 = new HashMap();
        for(Object object0: zzhs0.zza()) {
            zzhw zzhw0 = (zzhw)object0;
        }
        return map0;
    }

    public static final Object zzI(zzhs zzhs0, String s) {
        zzhw zzhw0 = zzpj.zzF(zzhs0, s);
        return zzhw0 == null ? null : zzpj.zzP(zzhw0);
    }

    public static final Object zzJ(zzhs zzhs0, String s, Object object0) {
        Object object1 = zzpj.zzI(zzhs0, s);
        return object1 == null ? object0 : object1;
    }

    private final void zzK(StringBuilder stringBuilder0, int v, List list0) {
        if(list0 != null) {
            for(Object object0: list0) {
                zzhw zzhw0 = (zzhw)object0;
                if(zzhw0 != null) {
                    zzpj.zzM(stringBuilder0, v + 1);
                    stringBuilder0.append("param {\n");
                    Double double0 = null;
                    zzpj.zzS(stringBuilder0, v + 1, "name", (zzhw0.zza() ? this.zzu.zzl().zzb("") : null));
                    zzpj.zzS(stringBuilder0, v + 1, "string_value", (zzhw0.zzc() ? "" : null));
                    zzpj.zzS(stringBuilder0, v + 1, "int_value", (zzhw0.zze() ? zzhw0.zzf() : null));
                    if(zzhw0.zzi()) {
                        double0 = zzhw0.zzj();
                    }
                    zzpj.zzS(stringBuilder0, v + 1, "double_value", double0);
                    if(zzhw0.zzm() > 0) {
                        this.zzK(stringBuilder0, v + 1, zzhw0.zzk());
                    }
                    zzpj.zzM(stringBuilder0, v + 1);
                    stringBuilder0.append("}\n");
                }
            }
        }
    }

    private final void zzL(StringBuilder stringBuilder0, int v, zzfh zzfh0) {
        String s;
        if(zzfh0 == null) {
            return;
        }
        zzpj.zzM(stringBuilder0, v);
        stringBuilder0.append("filter {\n");
        if(zzfh0.zze()) {
            zzpj.zzS(stringBuilder0, v, "complement", Boolean.valueOf(zzfh0.zzf()));
        }
        if(zzfh0.zzg()) {
            zzpj.zzS(stringBuilder0, v, "param_name", this.zzu.zzl().zzb(""));
        }
        if(zzfh0.zza()) {
            zzfr zzfr0 = zzfh0.zzb();
            if(zzfr0 != null) {
                zzpj.zzM(stringBuilder0, v + 1);
                stringBuilder0.append("string_filter {\n");
                if(zzfr0.zza()) {
                    switch(zzfr0.zzj()) {
                        case 1: {
                            s = "UNKNOWN_MATCH_TYPE";
                            break;
                        }
                        case 2: {
                            s = "REGEXP";
                            break;
                        }
                        case 3: {
                            s = "BEGINS_WITH";
                            break;
                        }
                        case 4: {
                            s = "ENDS_WITH";
                            break;
                        }
                        case 5: {
                            s = "PARTIAL";
                            break;
                        }
                        case 6: {
                            s = "EXACT";
                            break;
                        }
                        default: {
                            s = "IN_LIST";
                        }
                    }
                    zzpj.zzS(stringBuilder0, v + 1, "match_type", s);
                }
                if(zzfr0.zzb()) {
                    zzpj.zzS(stringBuilder0, v + 1, "expression", "");
                }
                if(zzfr0.zzd()) {
                    zzpj.zzS(stringBuilder0, v + 1, "case_sensitive", Boolean.valueOf(zzfr0.zze()));
                }
                if(zzfr0.zzg() > 0) {
                    zzpj.zzM(stringBuilder0, v + 2);
                    stringBuilder0.append("expression_list {\n");
                    for(Object object0: zzfr0.zzf()) {
                        zzpj.zzM(stringBuilder0, v + 3);
                        stringBuilder0.append(((String)object0));
                        stringBuilder0.append("\n");
                    }
                    stringBuilder0.append("}\n");
                }
                zzpj.zzM(stringBuilder0, v + 1);
                stringBuilder0.append("}\n");
            }
        }
        if(zzfh0.zzc()) {
            zzpj.zzT(stringBuilder0, v + 1, "number_filter", zzfh0.zzd());
        }
        zzpj.zzM(stringBuilder0, v);
        stringBuilder0.append("}\n");
    }

    private static final void zzM(StringBuilder stringBuilder0, int v) {
        for(int v1 = 0; v1 < v; ++v1) {
            stringBuilder0.append("  ");
        }
    }

    private static final void zzN(Uri.Builder uri$Builder0, String s, String s1, Set set0) {
        if(!set0.contains(s) && !TextUtils.isEmpty(s1)) {
            uri$Builder0.appendQueryParameter(s, s1);
        }
    }

    private static final String zzO(boolean z, boolean z1, boolean z2) {
        StringBuilder stringBuilder0 = new StringBuilder();
        if(z) {
            stringBuilder0.append("Dynamic ");
        }
        if(z1) {
            stringBuilder0.append("Sequence ");
        }
        if(z2) {
            stringBuilder0.append("Session-Scoped ");
        }
        return stringBuilder0.toString();
    }

    private static final Object zzP(zzhw zzhw0) {
        if(zzhw0.zzc()) {
            return "";
        }
        if(zzhw0.zze()) {
            return zzhw0.zzf();
        }
        if(zzhw0.zzi()) {
            return zzhw0.zzj();
        }
        return zzhw0.zzm() > 0 ? zzpj.zzy(zzhw0.zzk()) : null;
    }

    private static final void zzQ(Uri.Builder uri$Builder0, String[] arr_s, Bundle bundle0, Set set0) {
        for(int v = 0; v < arr_s.length; ++v) {
            String[] arr_s1 = arr_s[v].split(",");
            String s = arr_s1[0];
            String s1 = arr_s1[arr_s1.length - 1];
            String s2 = bundle0.getString(s);
            if(s2 != null) {
                zzpj.zzN(uri$Builder0, s1, s2, set0);
            }
        }
    }

    private static final void zzR(StringBuilder stringBuilder0, int v, String s, zzii zzii0) {
        if(zzii0 == null) {
            return;
        }
        zzpj.zzM(stringBuilder0, 3);
        stringBuilder0.append(s);
        stringBuilder0.append(" {\n");
        if(zzii0.zzd() != 0) {
            zzpj.zzM(stringBuilder0, 4);
            stringBuilder0.append("results: ");
            int v1 = 0;
            for(Object object0: zzii0.zzc()) {
                if(v1 != 0) {
                    stringBuilder0.append(", ");
                }
                stringBuilder0.append(((Long)object0));
                ++v1;
            }
            stringBuilder0.append('\n');
        }
        if(zzii0.zzb() != 0) {
            zzpj.zzM(stringBuilder0, 4);
            stringBuilder0.append("status: ");
            int v2 = 0;
            for(Object object1: zzii0.zza()) {
                if(v2 != 0) {
                    stringBuilder0.append(", ");
                }
                stringBuilder0.append(((Long)object1));
                ++v2;
            }
            stringBuilder0.append('\n');
        }
        if(zzii0.zzf() != 0) {
            zzpj.zzM(stringBuilder0, 4);
            stringBuilder0.append("dynamic_filter_timestamps: {");
            int v3 = 0;
            for(Object object2: zzii0.zze()) {
                zzhq zzhq0 = (zzhq)object2;
                if(v3 != 0) {
                    stringBuilder0.append(", ");
                }
                stringBuilder0.append((zzhq0.zza() ? zzhq0.zzb() : null));
                stringBuilder0.append(":");
                stringBuilder0.append((zzhq0.zzc() ? zzhq0.zzd() : null));
                ++v3;
            }
            stringBuilder0.append("}\n");
        }
        if(zzii0.zzh() != 0) {
            zzpj.zzM(stringBuilder0, 4);
            stringBuilder0.append("sequence_filter_timestamps: {");
            int v4 = 0;
            for(Object object3: zzii0.zzg()) {
                zzik zzik0 = (zzik)object3;
                if(v4 != 0) {
                    stringBuilder0.append(", ");
                }
                stringBuilder0.append((zzik0.zza() ? zzik0.zzb() : null));
                stringBuilder0.append(": [");
                int v5 = 0;
                for(Object object4: zzik0.zzc()) {
                    long v6 = (long)(((Long)object4));
                    if(v5 != 0) {
                        stringBuilder0.append(", ");
                    }
                    stringBuilder0.append(v6);
                    ++v5;
                }
                stringBuilder0.append("]");
                ++v4;
            }
            stringBuilder0.append("}\n");
        }
        zzpj.zzM(stringBuilder0, 3);
        stringBuilder0.append("}\n");
    }

    private static final void zzS(StringBuilder stringBuilder0, int v, String s, Object object0) {
        if(object0 == null) {
            return;
        }
        zzpj.zzM(stringBuilder0, v + 1);
        stringBuilder0.append(s);
        stringBuilder0.append(": ");
        stringBuilder0.append(object0);
        stringBuilder0.append('\n');
    }

    private static final void zzT(StringBuilder stringBuilder0, int v, String s, zzfl zzfl0) {
        String s1;
        if(zzfl0 == null) {
            return;
        }
        zzpj.zzM(stringBuilder0, v);
        stringBuilder0.append(s);
        stringBuilder0.append(" {\n");
        if(zzfl0.zza()) {
            switch(zzfl0.zzm()) {
                case 1: {
                    s1 = "UNKNOWN_COMPARISON_TYPE";
                    break;
                }
                case 2: {
                    s1 = "LESS_THAN";
                    break;
                }
                case 3: {
                    s1 = "GREATER_THAN";
                    break;
                }
                case 4: {
                    s1 = "EQUAL";
                    break;
                }
                default: {
                    s1 = "BETWEEN";
                }
            }
            zzpj.zzS(stringBuilder0, v, "comparison_type", s1);
        }
        if(zzfl0.zzb()) {
            zzpj.zzS(stringBuilder0, v, "match_as_float", Boolean.valueOf(zzfl0.zzc()));
        }
        if(zzfl0.zzd()) {
            zzpj.zzS(stringBuilder0, v, "comparison_value", "");
        }
        if(zzfl0.zzf()) {
            zzpj.zzS(stringBuilder0, v, "min_comparison_value", "");
        }
        if(zzfl0.zzh()) {
            zzpj.zzS(stringBuilder0, v, "max_comparison_value", "");
        }
        zzpj.zzM(stringBuilder0, v);
        stringBuilder0.append("}\n");
    }

    @Override  // com.google.android.gms.measurement.internal.zzor
    public final boolean zzbb() {
        return false;
    }

    public final void zzc(zzit zzit0, Object object0) {
        Preconditions.checkNotNull(object0);
        zzit0.zzd();
        zzit0.zzf();
        zzit0.zzh();
        if(object0 instanceof String) {
            zzit0.zzc(((String)object0));
            return;
        }
        if(object0 instanceof Long) {
            zzit0.zze(((long)(((Long)object0))));
            return;
        }
        if(object0 instanceof Double) {
            zzit0.zzg(((double)(((Double)object0))));
            return;
        }
        this.zzu.zzaV().zzb().zzb("Ignoring invalid (type) user attribute value", object0);
    }

    public final void zzd(zzhv zzhv0, Object object0) {
        Preconditions.checkNotNull(object0);
        zzhv0.zze();
        zzhv0.zzg();
        zzhv0.zzi();
        zzhv0.zzm();
        if(object0 instanceof String) {
            zzhv0.zzd(((String)object0));
            return;
        }
        if(object0 instanceof Long) {
            zzhv0.zzf(((long)(((Long)object0))));
            return;
        }
        if(object0 instanceof Double) {
            zzhv0.zzh(((double)(((Double)object0))));
            return;
        }
        if(object0 instanceof Bundle[]) {
            ArrayList arrayList0 = new ArrayList();
            int v = 0;
            while(v < ((Bundle[])object0).length) {
                Bundle bundle0 = ((Bundle[])object0)[v];
                if(bundle0 != null) {
                    zzhv zzhv1 = zzhw.zzn();
                    for(Object object1: bundle0.keySet()) {
                        zzhv zzhv2 = zzhw.zzn();
                        zzhv2.zzb(((String)object1));
                        Object object2 = bundle0.get(((String)object1));
                        if(object2 instanceof Long) {
                            zzhv2.zzf(((long)(((Long)object2))));
                        }
                        else if(object2 instanceof String) {
                            zzhv2.zzd(((String)object2));
                        }
                        else {
                            if(!(object2 instanceof Double)) {
                                continue;
                            }
                            zzhv2.zzh(((double)(((Double)object2))));
                        }
                        zzhv1.zzk(zzhv2);
                    }
                    if(zzhv1.zzj() > 0) {
                        arrayList0.add(((zzhw)zzhv1.zzbc()));
                    }
                }
                ++v;
            }
            zzhv0.zzl(arrayList0);
            return;
        }
        this.zzu.zzaV().zzb().zzb("Ignoring invalid (type) event param value", object0);
    }

    @TargetApi(30)
    public final zzog zzf(String s, zzic zzic0, zzhr zzhr0, String s1) {
        zzql.zza();
        zzib zzib0 = this.zzu;
        if(zzib0.zzc().zzp(s, zzfx.zzaP)) {
            long v = zzib0.zzaZ().currentTimeMillis();
            String[] arr_s = zzib0.zzc().zzk(s, zzfx.zzau).split(",");
            HashSet hashSet0 = new HashSet(arr_s.length);
            for(int v1 = 0; v1 < arr_s.length; ++v1) {
                String s2 = arr_s[v1];
                Objects.requireNonNull(s2);
                if(!hashSet0.add(s2)) {
                    throw new IllegalArgumentException("duplicate element: " + s2);
                }
            }
            Set set0 = Collections.unmodifiableSet(hashSet0);
            zzpf zzpf0 = this.zzg;
            zzot zzot0 = zzpf0.zzf();
            String s3 = zzot0.zzg.zzh().zzc(s);
            Uri.Builder uri$Builder0 = new Uri.Builder();
            zzib zzib1 = zzot0.zzu;
            uri$Builder0.scheme(zzib1.zzc().zzk(s, zzfx.zzan));
            if(TextUtils.isEmpty(s3)) {
                uri$Builder0.authority(zzib1.zzc().zzk(s, zzfx.zzao));
            }
            else {
                uri$Builder0.authority(s3 + "." + zzib1.zzc().zzk(s, zzfx.zzao));
            }
            uri$Builder0.path(zzib1.zzc().zzk(s, zzfx.zzap));
            zzpj.zzN(uri$Builder0, "gmp_app_id", zzic0.zzac(), set0);
            zzib0.zzc().zzi();
            zzpj.zzN(uri$Builder0, "gmp_version", "130000", set0);
            String s4 = zzic0.zzV();
            zzfw zzfw0 = zzfx.zzaS;
            if(zzib0.zzc().zzp(s, zzfw0) && zzpf0.zzh().zzt(s)) {
                s4 = "";
            }
            zzpj.zzN(uri$Builder0, "app_instance_id", s4, set0);
            zzpj.zzN(uri$Builder0, "rdid", zzic0.zzP(), set0);
            zzpj.zzN(uri$Builder0, "bundle_id", zzic0.zzK(), set0);
            String s5 = zzhr0.zzk();
            String s6 = zzjl.zza(s5);
            if(!TextUtils.isEmpty(s6)) {
                s5 = s6;
            }
            zzpj.zzN(uri$Builder0, "app_event_name", s5, set0);
            zzpj.zzN(uri$Builder0, "app_version", String.valueOf(zzic0.zzai()), set0);
            String s7 = zzic0.zzD();
            if(zzib0.zzc().zzp(s, zzfw0) && zzpf0.zzh().zzq(s) && !TextUtils.isEmpty(s7)) {
                int v2 = s7.indexOf(".");
                if(v2 != -1) {
                    s7 = s7.substring(0, v2);
                }
            }
            zzpj.zzN(uri$Builder0, "os_version", s7, set0);
            zzpj.zzN(uri$Builder0, "timestamp", String.valueOf(zzhr0.zzn()), set0);
            String s8 = "1";
            if(zzic0.zzS()) {
                zzpj.zzN(uri$Builder0, "lat", "1", set0);
            }
            zzpj.zzN(uri$Builder0, "privacy_sandbox_version", String.valueOf(zzic0.zzaG()), set0);
            zzpj.zzN(uri$Builder0, "trigger_uri_source", "1", set0);
            zzpj.zzN(uri$Builder0, "trigger_uri_timestamp", String.valueOf(v), set0);
            zzpj.zzN(uri$Builder0, "request_uuid", s1, set0);
            List list0 = zzhr0.zza();
            Bundle bundle0 = new Bundle();
            for(Object object0: list0) {
                zzhw zzhw0 = (zzhw)object0;
                if(zzhw0.zzi()) {
                    bundle0.putString("", String.valueOf(zzhw0.zzj()));
                }
                else if(zzhw0.zzg()) {
                    bundle0.putString("", String.valueOf(zzhw0.zzh()));
                }
                else if(zzhw0.zzc()) {
                    bundle0.putString("", "");
                }
                else if(zzhw0.zze()) {
                    bundle0.putString("", String.valueOf(zzhw0.zzf()));
                }
            }
            zzpj.zzQ(uri$Builder0, zzib0.zzc().zzk(s, zzfx.zzat).split("\\|"), bundle0, set0);
            List list1 = zzic0.zzk();
            Bundle bundle1 = new Bundle();
            for(Object object1: list1) {
                zziu zziu0 = (zziu)object1;
                if(zziu0.zzj()) {
                    bundle1.putString("", String.valueOf(zziu0.zzk()));
                }
                else if(zziu0.zzh()) {
                    bundle1.putString("", String.valueOf(zziu0.zzi()));
                }
                else if(zziu0.zzd()) {
                    bundle1.putString("", "");
                }
                else if(zziu0.zzf()) {
                    bundle1.putString("", String.valueOf(zziu0.zzg()));
                }
            }
            zzpj.zzQ(uri$Builder0, zzib0.zzc().zzk(s, zzfx.zzas).split("\\|"), bundle1, set0);
            if(!zzic0.zzaC()) {
                s8 = "0";
            }
            zzpj.zzN(uri$Builder0, "dma", s8, set0);
            if(!zzic0.zzaE().isEmpty()) {
                zzpj.zzN(uri$Builder0, "dma_cps", zzic0.zzaE(), set0);
            }
            if(zzic0.zzaK()) {
                zzha zzha0 = zzic0.zzaL();
                if(zzha0.zzh() > 0L) {
                    zzpj.zzN(uri$Builder0, "dl_ss_ts", String.valueOf(zzha0.zzh()), set0);
                }
                if(zzha0.zzq() > 0L) {
                    zzpj.zzN(uri$Builder0, "mr_click_ts", String.valueOf(zzha0.zzq()), set0);
                }
            }
            return new zzog(uri$Builder0.build().toString(), v, 1);
        }
        return null;
    }

    public final zzhs zzh(zzbb zzbb0) {
        zzhr zzhr0 = zzhs.zzk();
        zzhr0.zzq(zzbb0.zze);
        zzbe zzbe0 = zzbb0.zzf;
        zzbd zzbd0 = new zzbd(zzbe0);
        while(zzbd0.hasNext()) {
            String s = zzbd0.zza();
            zzhv zzhv0 = zzhw.zzn();
            zzhv0.zzb(s);
            Object object0 = zzbe0.zza(s);
            Preconditions.checkNotNull(object0);
            this.zzd(zzhv0, object0);
            zzhr0.zzg(zzhv0);
        }
        String s1 = zzbb0.zzc;
        if(!TextUtils.isEmpty(s1) && zzbe0.zza("_o") == null) {
            zzhv zzhv1 = zzhw.zzn();
            zzhv1.zzb("_o");
            zzhv1.zzd(s1);
            zzhr0.zzf(((zzhw)zzhv1.zzbc()));
        }
        return (zzhs)zzhr0.zzbc();
    }

    public final String zzi(com.google.android.gms.internal.measurement.zzib zzib0) {
        String s3;
        String s2;
        String s1;
        String s;
        if(zzib0 == null) {
            return "";
        }
        StringBuilder stringBuilder0 = Y.p("\nbatch {\n");
        if(zzib0.zzf()) {
            zzpj.zzS(stringBuilder0, 0, "upload_subdomain", "");
        }
        if(zzib0.zzd()) {
            zzpj.zzS(stringBuilder0, 0, "sgtm_join_id", "");
        }
        for(Object object0: zzib0.zza()) {
            zzid zzid0 = (zzid)object0;
            if(zzid0 != null) {
                zzpj.zzM(stringBuilder0, 1);
                stringBuilder0.append("bundle {\n");
                if(zzid0.zza()) {
                    zzpj.zzS(stringBuilder0, 1, "protocol_version", zzid0.zzb());
                }
                zzqu.zza();
                zzib zzib1 = this.zzu;
                if(zzib1.zzc().zzp("", zzfx.zzaM) && zzid0.zzag()) {
                    zzpj.zzS(stringBuilder0, 1, "session_stitching_token", "");
                }
                zzpj.zzS(stringBuilder0, 1, "platform", "");
                if(zzid0.zzC()) {
                    zzpj.zzS(stringBuilder0, 1, "gmp_version", zzid0.zzD());
                }
                if(zzid0.zzE()) {
                    zzpj.zzS(stringBuilder0, 1, "uploading_gmp_version", zzid0.zzF());
                }
                if(zzid0.zzac()) {
                    zzpj.zzS(stringBuilder0, 1, "dynamite_version", zzid0.zzad());
                }
                if(zzid0.zzW()) {
                    zzpj.zzS(stringBuilder0, 1, "config_version", zzid0.zzX());
                }
                zzpj.zzS(stringBuilder0, 1, "gmp_app_id", "");
                zzpj.zzS(stringBuilder0, 1, "app_id", "");
                zzpj.zzS(stringBuilder0, 1, "app_version", "");
                if(zzid0.zzU()) {
                    zzpj.zzS(stringBuilder0, 1, "app_version_major", zzid0.zzV());
                }
                zzpj.zzS(stringBuilder0, 1, "firebase_instance_id", "");
                if(zzid0.zzK()) {
                    zzpj.zzS(stringBuilder0, 1, "dev_cert_hash", zzid0.zzL());
                }
                zzpj.zzS(stringBuilder0, 1, "app_store", "");
                if(zzid0.zzi()) {
                    zzpj.zzS(stringBuilder0, 1, "upload_timestamp_millis", zzid0.zzj());
                }
                if(zzid0.zzk()) {
                    zzpj.zzS(stringBuilder0, 1, "start_timestamp_millis", zzid0.zzm());
                }
                if(zzid0.zzn()) {
                    zzpj.zzS(stringBuilder0, 1, "end_timestamp_millis", zzid0.zzo());
                }
                if(zzid0.zzp()) {
                    zzpj.zzS(stringBuilder0, 1, "previous_bundle_start_timestamp_millis", zzid0.zzq());
                }
                if(zzid0.zzr()) {
                    zzpj.zzS(stringBuilder0, 1, "previous_bundle_end_timestamp_millis", zzid0.zzs());
                }
                zzpj.zzS(stringBuilder0, 1, "app_instance_id", "");
                zzpj.zzS(stringBuilder0, 1, "resettable_device_id", "");
                zzpj.zzS(stringBuilder0, 1, "ds_id", "");
                if(zzid0.zzH()) {
                    zzpj.zzS(stringBuilder0, 1, "limited_ad_tracking", Boolean.valueOf(zzid0.zzI()));
                }
                zzpj.zzS(stringBuilder0, 1, "os_version", "");
                zzpj.zzS(stringBuilder0, 1, "device_model", "");
                zzpj.zzS(stringBuilder0, 1, "user_default_language", "");
                if(zzid0.zzx()) {
                    zzpj.zzS(stringBuilder0, 1, "time_zone_offset_minutes", zzid0.zzy());
                }
                if(zzid0.zzM()) {
                    zzpj.zzS(stringBuilder0, 1, "bundle_sequential_index", zzid0.zzN());
                }
                if(zzid0.zzau()) {
                    zzpj.zzS(stringBuilder0, 1, "delivery_index", zzid0.zzav());
                }
                if(zzid0.zzQ()) {
                    zzpj.zzS(stringBuilder0, 1, "service_upload", Boolean.valueOf(zzid0.zzR()));
                }
                zzpj.zzS(stringBuilder0, 1, "health_monitor", "");
                if(zzid0.zzaa()) {
                    zzpj.zzS(stringBuilder0, 1, "retry_counter", zzid0.zzab());
                }
                if(zzid0.zzae()) {
                    zzpj.zzS(stringBuilder0, 1, "consent_signals", "");
                }
                if(zzid0.zzan()) {
                    zzpj.zzS(stringBuilder0, 1, "is_dma_region", Boolean.valueOf(zzid0.zzao()));
                }
                if(zzid0.zzap()) {
                    zzpj.zzS(stringBuilder0, 1, "core_platform_services", "");
                }
                if(zzid0.zzal()) {
                    zzpj.zzS(stringBuilder0, 1, "consent_diagnostics", "");
                }
                if(zzid0.zzai()) {
                    zzpj.zzS(stringBuilder0, 1, "target_os_version", zzid0.zzaj());
                }
                zzql.zza();
                if(zzib1.zzc().zzp("", zzfx.zzaP)) {
                    zzpj.zzS(stringBuilder0, 1, "ad_services_version", zzid0.zzar());
                    if(zzid0.zzas()) {
                        zzhe zzhe0 = zzid0.zzat();
                        if(zzhe0 != null) {
                            zzpj.zzM(stringBuilder0, 2);
                            stringBuilder0.append("attribution_eligibility_status {\n");
                            zzpj.zzS(stringBuilder0, 2, "eligible", Boolean.valueOf(zzhe0.zza()));
                            zzpj.zzS(stringBuilder0, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(zzhe0.zzb()));
                            zzpj.zzS(stringBuilder0, 2, "pre_r", Boolean.valueOf(zzhe0.zzc()));
                            zzpj.zzS(stringBuilder0, 2, "r_extensions_too_old", Boolean.valueOf(zzhe0.zzd()));
                            zzpj.zzS(stringBuilder0, 2, "adservices_extension_too_old", Boolean.valueOf(zzhe0.zze()));
                            zzpj.zzS(stringBuilder0, 2, "ad_storage_not_allowed", Boolean.valueOf(zzhe0.zzf()));
                            zzpj.zzS(stringBuilder0, 2, "measurement_manager_disabled", Boolean.valueOf(zzhe0.zzg()));
                            zzpj.zzM(stringBuilder0, 2);
                            stringBuilder0.append("}\n");
                        }
                    }
                }
                if(zzid0.zzaw()) {
                    zzha zzha0 = zzid0.zzax();
                    zzpj.zzM(stringBuilder0, 2);
                    stringBuilder0.append("ad_campaign_info {\n");
                    if(zzha0.zza()) {
                        zzpj.zzS(stringBuilder0, 2, "deep_link_gclid", "");
                    }
                    if(zzha0.zzc()) {
                        zzpj.zzS(stringBuilder0, 2, "deep_link_gbraid", "");
                    }
                    if(zzha0.zze()) {
                        zzpj.zzS(stringBuilder0, 2, "deep_link_gad_source", "");
                    }
                    if(zzha0.zzg()) {
                        zzpj.zzS(stringBuilder0, 2, "deep_link_session_millis", zzha0.zzh());
                    }
                    if(zzha0.zzi()) {
                        zzpj.zzS(stringBuilder0, 2, "market_referrer_gclid", "");
                    }
                    if(zzha0.zzk()) {
                        zzpj.zzS(stringBuilder0, 2, "market_referrer_gbraid", "");
                    }
                    if(zzha0.zzn()) {
                        zzpj.zzS(stringBuilder0, 2, "market_referrer_gad_source", "");
                    }
                    if(zzha0.zzp()) {
                        zzpj.zzS(stringBuilder0, 2, "market_referrer_click_millis", zzha0.zzq());
                    }
                    zzpj.zzM(stringBuilder0, 2);
                    stringBuilder0.append("}\n");
                }
                if(zzid0.zzaA()) {
                    zzpj.zzS(stringBuilder0, 1, "batching_timestamp_millis", zzid0.zzaB());
                }
                if(zzid0.zzay()) {
                    zzis zzis0 = zzid0.zzaz();
                    zzpj.zzM(stringBuilder0, 2);
                    stringBuilder0.append("sgtm_diagnostics {\n");
                    switch(zzis0.zzf()) {
                        case 1: {
                            s = "UPLOAD_TYPE_UNKNOWN";
                            break;
                        }
                        case 2: {
                            s = "GA_UPLOAD";
                            break;
                        }
                        case 3: {
                            s = "SDK_CLIENT_UPLOAD";
                            break;
                        }
                        case 4: {
                            s = "PACKAGE_SERVICE_UPLOAD";
                            break;
                        }
                        default: {
                            s = "SDK_SERVICE_UPLOAD";
                        }
                    }
                    zzpj.zzS(stringBuilder0, 2, "upload_type", s);
                    zzpj.zzS(stringBuilder0, 2, "client_upload_eligibility", zzis0.zza().name());
                    int v = zzis0.zzg();
                    switch(v) {
                        case 1: {
                            s1 = "SERVICE_UPLOAD_ELIGIBILITY_UNKNOWN";
                            break;
                        }
                        case 2: {
                            s1 = "SERVICE_UPLOAD_ELIGIBLE";
                            break;
                        }
                        case 3: {
                            s1 = "NOT_IN_ROLLOUT";
                            break;
                        }
                        case 4: {
                            s1 = "MISSING_SGTM_SETTINGS";
                            break;
                        }
                        default: {
                            s1 = v == 5 ? "MISSING_SGTM_PROXY_INFO" : "NON_PLAY_MISSING_SGTM_SERVER_URL";
                        }
                    }
                    zzpj.zzS(stringBuilder0, 2, "service_upload_eligibility", s1);
                    zzpj.zzM(stringBuilder0, 2);
                    stringBuilder0.append("}\n");
                }
                if(zzid0.zzaC()) {
                    zzho zzho0 = zzid0.zzaD();
                    zzpj.zzM(stringBuilder0, 2);
                    stringBuilder0.append("consent_info_extra {\n");
                    for(Object object1: zzho0.zza()) {
                        zzpj.zzM(stringBuilder0, 3);
                        stringBuilder0.append("limited_data_modes {\n");
                        switch(((zzhl)object1).zzc()) {
                            case 1: {
                                s2 = "CONSENT_TYPE_UNSPECIFIED";
                                break;
                            }
                            case 2: {
                                s2 = "AD_STORAGE";
                                break;
                            }
                            case 3: {
                                s2 = "ANALYTICS_STORAGE";
                                break;
                            }
                            case 4: {
                                s2 = "AD_USER_DATA";
                                break;
                            }
                            default: {
                                s2 = "AD_PERSONALIZATION";
                            }
                        }
                        zzpj.zzS(stringBuilder0, 3, "type", s2);
                        switch(((zzhl)object1).zzd()) {
                            case 1: {
                                s3 = "NOT_LIMITED";
                                break;
                            }
                            case 2: {
                                s3 = "LIMITED_MODE";
                                break;
                            }
                            default: {
                                s3 = "NO_DATA_MODE";
                            }
                        }
                        zzpj.zzS(stringBuilder0, 3, "mode", s3);
                        zzpj.zzM(stringBuilder0, 3);
                        stringBuilder0.append("}\n");
                    }
                    zzpj.zzM(stringBuilder0, 2);
                    stringBuilder0.append("}\n");
                }
                List list0 = zzid0.zzf();
                if(list0 != null) {
                    for(Object object2: list0) {
                        zziu zziu0 = (zziu)object2;
                        if(zziu0 != null) {
                            zzpj.zzM(stringBuilder0, 2);
                            stringBuilder0.append("user_property {\n");
                            Double double0 = null;
                            zzpj.zzS(stringBuilder0, 2, "set_timestamp_millis", (zziu0.zza() ? zziu0.zzb() : null));
                            zzpj.zzS(stringBuilder0, 2, "name", zzib1.zzl().zzc(""));
                            zzpj.zzS(stringBuilder0, 2, "string_value", "");
                            zzpj.zzS(stringBuilder0, 2, "int_value", (zziu0.zzf() ? zziu0.zzg() : null));
                            if(zziu0.zzj()) {
                                double0 = zziu0.zzk();
                            }
                            zzpj.zzS(stringBuilder0, 2, "double_value", double0);
                            zzpj.zzM(stringBuilder0, 2);
                            stringBuilder0.append("}\n");
                        }
                    }
                }
                List list1 = zzid0.zzS();
                if(list1 != null) {
                    for(Object object3: list1) {
                        zzhg zzhg0 = (zzhg)object3;
                        if(zzhg0 != null) {
                            zzpj.zzM(stringBuilder0, 2);
                            stringBuilder0.append("audience_membership {\n");
                            if(zzhg0.zza()) {
                                zzpj.zzS(stringBuilder0, 2, "audience_id", zzhg0.zzb());
                            }
                            if(zzhg0.zzf()) {
                                zzpj.zzS(stringBuilder0, 2, "new_audience", Boolean.valueOf(zzhg0.zzg()));
                            }
                            zzpj.zzR(stringBuilder0, 2, "current_data", zzhg0.zzc());
                            if(zzhg0.zzd()) {
                                zzpj.zzR(stringBuilder0, 2, "previous_data", zzhg0.zze());
                            }
                            zzpj.zzM(stringBuilder0, 2);
                            stringBuilder0.append("}\n");
                        }
                    }
                }
                List list2 = zzid0.zzc();
                if(list2 != null) {
                    for(Object object4: list2) {
                        zzhs zzhs0 = (zzhs)object4;
                        if(zzhs0 != null) {
                            zzpj.zzM(stringBuilder0, 2);
                            stringBuilder0.append("event {\n");
                            zzpj.zzS(stringBuilder0, 2, "name", zzib1.zzl().zza(""));
                            if(zzhs0.zze()) {
                                zzpj.zzS(stringBuilder0, 2, "timestamp_millis", zzhs0.zzf());
                            }
                            if(zzhs0.zzg()) {
                                zzpj.zzS(stringBuilder0, 2, "previous_timestamp_millis", zzhs0.zzh());
                            }
                            if(zzhs0.zzi()) {
                                zzpj.zzS(stringBuilder0, 2, "count", zzhs0.zzj());
                            }
                            if(zzhs0.zzb() != 0) {
                                this.zzK(stringBuilder0, 2, zzhs0.zza());
                            }
                            zzpj.zzM(stringBuilder0, 2);
                            stringBuilder0.append("}\n");
                        }
                    }
                }
                zzpj.zzM(stringBuilder0, 1);
                stringBuilder0.append("}\n");
            }
        }
        stringBuilder0.append("} // End-of-batch\n");
        return stringBuilder0.toString();
    }

    public final String zzj(zzff zzff0) {
        if(zzff0 == null) {
            return "null";
        }
        StringBuilder stringBuilder0 = Y.p("\nevent_filter {\n");
        if(zzff0.zza()) {
            zzpj.zzS(stringBuilder0, 0, "filter_id", zzff0.zzb());
        }
        zzpj.zzS(stringBuilder0, 0, "event_name", this.zzu.zzl().zza(""));
        String s = zzpj.zzO(zzff0.zzi(), zzff0.zzj(), zzff0.zzm());
        if(!s.isEmpty()) {
            zzpj.zzS(stringBuilder0, 0, "filter_type", s);
        }
        if(zzff0.zzg()) {
            zzpj.zzT(stringBuilder0, 1, "event_count_filter", zzff0.zzh());
        }
        if(zzff0.zze() > 0) {
            stringBuilder0.append("  filters {\n");
            for(Object object0: zzff0.zzd()) {
                this.zzL(stringBuilder0, 2, ((zzfh)object0));
            }
        }
        zzpj.zzM(stringBuilder0, 1);
        stringBuilder0.append("}\n}\n");
        return stringBuilder0.toString();
    }

    public final String zzk(zzfn zzfn0) {
        if(zzfn0 == null) {
            return "null";
        }
        StringBuilder stringBuilder0 = Y.p("\nproperty_filter {\n");
        if(zzfn0.zza()) {
            zzpj.zzS(stringBuilder0, 0, "filter_id", zzfn0.zzb());
        }
        zzpj.zzS(stringBuilder0, 0, "property_name", this.zzu.zzl().zzc(""));
        String s = zzpj.zzO(zzfn0.zze(), zzfn0.zzf(), zzfn0.zzh());
        if(!s.isEmpty()) {
            zzpj.zzS(stringBuilder0, 0, "filter_type", s);
        }
        this.zzL(stringBuilder0, 1, zzfn0.zzd());
        stringBuilder0.append("}\n");
        return stringBuilder0.toString();
    }

    public final Parcelable zzl(byte[] arr_b, Parcelable.Creator parcelable$Creator0) {
        Parcelable parcelable0 = null;
        if(arr_b == null) {
            return null;
        }
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.unmarshall(arr_b, 0, arr_b.length);
            parcel0.setDataPosition(0);
            parcelable0 = (Parcelable)parcelable$Creator0.createFromParcel(parcel0);
        }
        catch(ParseException unused_ex) {
            this.zzu.zzaV().zzb().zza("Failed to load parcelable from buffer");
        }
        finally {
            parcel0.recycle();
        }
        return parcelable0;
    }

    public static boolean zzm(String s) [...] // 潜在的解密器

    public static boolean zzn(List list0, int v) {
        return v < list0.size() * 0x40 && (1L << v % 0x40 & ((long)(((Long)list0.get(v / 0x40))))) != 0L;
    }

    public static List zzp(BitSet bitSet0) {
        int v = (bitSet0.length() + 0x3F) / 0x40;
        List list0 = new ArrayList(v);
        for(int v1 = 0; v1 < v; ++v1) {
            long v2 = 0L;
            for(int v3 = 0; v3 < 0x40; ++v3) {
                int v4 = v1 * 0x40 + v3;
                if(v4 >= bitSet0.length()) {
                    break;
                }
                if(bitSet0.get(v4)) {
                    v2 |= 1L << v3;
                }
            }
            ((ArrayList)list0).add(v2);
        }
        return list0;
    }

    public final List zzq(List list0, List list1) {
        int v3;
        ArrayList arrayList0 = new ArrayList(list0);
        for(Object object0: list1) {
            Integer integer0 = (Integer)object0;
            if(((int)integer0) < 0) {
                this.zzu.zzaV().zze().zzb("Ignoring negative bit index to be cleared", integer0);
            }
            else {
                int v = ((int)integer0) / 0x40;
                if(v >= arrayList0.size()) {
                    this.zzu.zzaV().zze().zzc("Ignoring bit index greater than bitSet size", integer0, arrayList0.size());
                }
                else {
                    arrayList0.set(v, ((long)(((long)(((Long)arrayList0.get(v)))) & ~(1L << ((int)integer0) % 0x40))));
                }
            }
        }
        int v1 = arrayList0.size();
        for(int v2 = arrayList0.size() - 1; true; v2 = v1 - 1) {
            v3 = v1;
            v1 = v2;
            if(v1 < 0 || ((long)(((Long)arrayList0.get(v1)))) != 0L) {
                break;
            }
        }
        return arrayList0.subList(0, v3);
    }

    public final boolean zzs(long v, long v1) {
        return v == 0L || v1 <= 0L || Math.abs(this.zzu.zzaZ().currentTimeMillis() - v) > v1;
    }

    public final long zzt(byte[] arr_b) {
        Preconditions.checkNotNull(arr_b);
        zzib zzib0 = this.zzu;
        zzib0.zzk().zzg();
        MessageDigest messageDigest0 = zzpo.zzO();
        if(messageDigest0 == null) {
            Z.u(zzib0, "Failed to get MD5");
            return 0L;
        }
        return zzpo.zzP(messageDigest0.digest(arr_b));
    }

    // 去混淆评级： 低(20)
    public final long zzu(String s) {
        return TextUtils.isEmpty(s) ? 0L : this.zzt(s.getBytes(Charset.forName("UTF-8")));
    }

    public final byte[] zzv(byte[] arr_b) {
        try {
            ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream0 = new GZIPOutputStream(byteArrayOutputStream0);
            gZIPOutputStream0.write(arr_b);
            gZIPOutputStream0.close();
            byteArrayOutputStream0.close();
            return byteArrayOutputStream0.toByteArray();
        }
        catch(IOException iOException0) {
            this.zzu.zzaV().zzb().zzb("Failed to gzip content", iOException0);
            throw iOException0;
        }
    }

    public static zznk zzw(zznk zznk0, byte[] arr_b) {
        zzlq zzlq0 = zzlq.zza();
        return zzlq0 == null ? zznk0.zzaW(arr_b) : zznk0.zzaV(arr_b, zzlq0);
    }

    public static int zzx(zzic zzic0, String s) {
        for(int v = 0; v < zzic0.zzl(); ++v) {
            if(s.equals("")) {
                return v;
            }
        }
        return -1;
    }

    public static Bundle[] zzy(List list0) {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            zzhw zzhw0 = (zzhw)object0;
            if(zzhw0 != null) {
                Bundle bundle0 = new Bundle();
                for(Object object1: zzhw0.zzk()) {
                    zzhw zzhw1 = (zzhw)object1;
                    if(zzhw1.zzc()) {
                        bundle0.putString("", "");
                    }
                    else if(zzhw1.zze()) {
                        bundle0.putLong("", zzhw1.zzf());
                    }
                    else if(zzhw1.zzi()) {
                        bundle0.putDouble("", zzhw1.zzj());
                    }
                }
                if(!bundle0.isEmpty()) {
                    arrayList0.add(bundle0);
                }
            }
        }
        return (Bundle[])arrayList0.toArray(new Bundle[arrayList0.size()]);
    }

    public final Map zzz(Bundle bundle0, boolean z) {
        Map map0 = new HashMap();
        for(Object object0: bundle0.keySet()) {
            String s = (String)object0;
            Object object1 = bundle0.get(s);
            boolean z1 = object1 instanceof Parcelable[];
            if(!z1 && !(object1 instanceof ArrayList) && !(object1 instanceof Bundle)) {
                if(object1 == null) {
                    continue;
                }
                ((HashMap)map0).put(s, object1);
            }
            else if(z) {
                ArrayList arrayList0 = new ArrayList();
                if(z1) {
                    Parcelable[] arr_parcelable = (Parcelable[])object1;
                    for(int v = 0; v < arr_parcelable.length; ++v) {
                        Parcelable parcelable0 = arr_parcelable[v];
                        if(parcelable0 instanceof Bundle) {
                            arrayList0.add(this.zzz(((Bundle)parcelable0), false));
                        }
                    }
                }
                else if(object1 instanceof ArrayList) {
                    ArrayList arrayList1 = (ArrayList)object1;
                    int v1 = arrayList1.size();
                    for(int v2 = 0; v2 < v1; ++v2) {
                        Object object2 = arrayList1.get(v2);
                        if(object2 instanceof Bundle) {
                            arrayList0.add(this.zzz(((Bundle)object2), false));
                        }
                    }
                }
                else if(object1 instanceof Bundle) {
                    arrayList0.add(this.zzz(((Bundle)object1), false));
                }
                ((HashMap)map0).put(s, arrayList0);
            }
        }
        return map0;
    }
}

