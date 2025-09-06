package com.google.android.gms.measurement.internal;

import B7.b;
import I6.E0;
import I6.G0;
import I6.Y;
import I6.b0;
import I6.u0;
import M6.B;
import M6.u;
import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.V;
import androidx.collection.f;
import b3.Z;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zzko;
import com.google.android.gms.internal.measurement.zzkp;
import com.google.android.gms.internal.measurement.zzql;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import t4.e;

public final class zzli extends zzg {
    protected zzkx zza;
    final zzx zzb;
    protected boolean zzc;
    private zzjo zzd;
    private final Set zze;
    private boolean zzf;
    private final AtomicReference zzg;
    private final Object zzh;
    private boolean zzi;
    private int zzj;
    private zzay zzk;
    private zzay zzl;
    private PriorityQueue zzm;
    private boolean zzn;
    private zzjk zzo;
    private final AtomicLong zzp;
    private long zzq;
    private zzay zzr;
    private SharedPreferences.OnSharedPreferenceChangeListener zzs;
    private zzay zzt;
    private final zzpn zzv;

    public zzli(zzib zzib0) {
        super(zzib0);
        this.zze = new CopyOnWriteArraySet();
        this.zzh = new Object();
        this.zzi = false;
        this.zzj = 1;
        this.zzc = true;
        this.zzv = new zzkm(this);
        this.zzg = new AtomicReference();
        this.zzo = zzjk.zza;
        this.zzq = -1L;
        this.zzp = new AtomicLong(0L);
        this.zzb = new zzx(zzib0);
    }

    public final void zzA(zzjk zzjk0) {
        boolean z;
        this.zzg();
        if(zzjk0.zzo(zzjj.zzb) && zzjk0.zzo(zzjj.zza)) {
            z = true;
        }
        else if(!this.zzu.zzt().zzO()) {
            z = false;
        }
        else {
            z = true;
        }
        zzib zzib0 = this.zzu;
        if(z != zzib0.zzE()) {
            zzib0.zzD(z);
            zzhg zzhg0 = this.zzu.zzd();
            zzhg0.zzg();
            Boolean boolean0 = zzhg0.zzd().contains("measurement_enabled_from_api") ? Boolean.valueOf(zzhg0.zzd().getBoolean("measurement_enabled_from_api", true)) : null;
            if(!z || boolean0 == null || boolean0.booleanValue()) {
                this.zzar(Boolean.valueOf(z), false);
            }
        }
    }

    public final void zzB(String s, String s1, Bundle bundle0) {
        this.zzC(s, s1, bundle0, true, true, this.zzu.zzaZ().currentTimeMillis());
    }

    public final void zzC(String s, String s1, Bundle bundle0, boolean z, boolean z1, long v) {
        if(bundle0 == null) {
            bundle0 = new Bundle();
        }
        boolean z2 = true;
        if(Objects.equals(s1, "screen_view")) {
            this.zzu.zzs().zzj(bundle0, v);
            return;
        }
        if(z1 && this.zzd != null && !zzpo.zzZ(s1)) {
            z2 = false;
        }
        if(s == null) {
            s = "app";
        }
        this.zzJ(s, s1, v, bundle0, z1, z2, z, null);
    }

    public final void zzD() {
        zzoc zzoc1;
        zzoc zzoc0;
        zzkp zzkp0;
        this.zzg();
        zzib zzib0 = this.zzu;
        this.zzu.zzaV().zzj().zza("Handle tcf update.");
        SharedPreferences sharedPreferences0 = this.zzu.zzd().zze();
        HashMap hashMap0 = new HashMap();
        zzfw zzfw0 = zzfx.zzaZ;
        if(((Boolean)zzfw0.zzb(null)).booleanValue()) {
            Objects.requireNonNull(zzko.zzb);
            Objects.requireNonNull(zzod.zza);
            AbstractMap.SimpleImmutableEntry abstractMap$SimpleImmutableEntry0 = new AbstractMap.SimpleImmutableEntry(zzko.zzb, zzod.zza);
            Objects.requireNonNull(zzko.zzc);
            Objects.requireNonNull(zzod.zzd);
            AbstractMap.SimpleImmutableEntry abstractMap$SimpleImmutableEntry1 = new AbstractMap.SimpleImmutableEntry(zzko.zzc, zzod.zzd);
            Objects.requireNonNull(zzko.zzd);
            AbstractMap.SimpleImmutableEntry abstractMap$SimpleImmutableEntry2 = new AbstractMap.SimpleImmutableEntry(zzko.zzd, zzod.zza);
            Objects.requireNonNull(zzko.zze);
            AbstractMap.SimpleImmutableEntry abstractMap$SimpleImmutableEntry3 = new AbstractMap.SimpleImmutableEntry(zzko.zze, zzod.zza);
            Objects.requireNonNull(zzko.zzh);
            AbstractMap.SimpleImmutableEntry abstractMap$SimpleImmutableEntry4 = new AbstractMap.SimpleImmutableEntry(zzko.zzh, zzod.zzd);
            Objects.requireNonNull(zzko.zzj);
            AbstractMap.SimpleImmutableEntry abstractMap$SimpleImmutableEntry5 = new AbstractMap.SimpleImmutableEntry(zzko.zzj, zzod.zzd);
            Objects.requireNonNull(zzko.zzk);
            Collection collection0 = Arrays.asList(new Map.Entry[]{abstractMap$SimpleImmutableEntry0, abstractMap$SimpleImmutableEntry1, abstractMap$SimpleImmutableEntry2, abstractMap$SimpleImmutableEntry3, abstractMap$SimpleImmutableEntry4, abstractMap$SimpleImmutableEntry5, new AbstractMap.SimpleImmutableEntry(zzko.zzk, zzod.zzd)});
            b b0 = new b((collection0 instanceof Collection ? collection0.size() : 4));
            b0.x(collection0);
            u0 u00 = (u0)b0.g();
            E0 e00 = new E0("CH");
            char[] arr_c = new char[5];
            boolean z = sharedPreferences0.contains("IABTCF_TCString");
            int v = zzoe.zzb(sharedPreferences0, "IABTCF_CmpSdkID");
            int v1 = zzoe.zzb(sharedPreferences0, "IABTCF_PolicyVersion");
            int v2 = zzoe.zzb(sharedPreferences0, "IABTCF_gdprApplies");
            int v3 = zzoe.zzb(sharedPreferences0, "IABTCF_PurposeOneTreatment");
            int v4 = zzoe.zzb(sharedPreferences0, "IABTCF_EnableAdvertiserConsentMode");
            String s = zzoe.zza(sharedPreferences0, "IABTCF_PublisherCC");
            b b1 = new b(4);
            b0 b00 = u00.b;
            if(b00 == null) {
                b00 = u00.c();
                u00.b = b00;
            }
            G0 g00 = b00.k();
            while(g00.hasNext()) {
                Object object0 = g00.next();
                String s1 = zzoe.zza(sharedPreferences0, "IABTCF_PublisherRestrictions" + ((zzko)object0).zza());
                if(TextUtils.isEmpty(s1) || s1.length() < 0x2F3) {
                    zzkp0 = zzkp.zzd;
                }
                else {
                    int v5 = Character.digit(s1.charAt(0x2F2), 10);
                    if(v5 >= 0 && v5 <= zzkp.values().length) {
                        switch(v5) {
                            case 0: {
                                break;
                            }
                            case 1: {
                                zzkp0 = zzkp.zzb;
                                goto label_57;
                            }
                            case 2: {
                                zzkp0 = zzkp.zzc;
                                goto label_57;
                            }
                            default: {
                                zzkp0 = zzkp.zzd;
                                goto label_57;
                            }
                        }
                    }
                    zzkp0 = zzkp.zza;
                }
            label_57:
                b1.v(((zzko)object0), zzkp0);
            }
            Y y0 = b1.g();
            String s2 = zzoe.zza(sharedPreferences0, "IABTCF_PurposeConsents");
            String s3 = zzoe.zza(sharedPreferences0, "IABTCF_VendorConsents");
            boolean z1 = !TextUtils.isEmpty(s3) && s3.length() >= 0x2F3 && s3.charAt(0x2F2) == 49;
            String s4 = zzoe.zza(sharedPreferences0, "IABTCF_PurposeLegitimateInterests");
            String s5 = zzoe.zza(sharedPreferences0, "IABTCF_VendorLegitimateInterests");
            boolean z2 = !TextUtils.isEmpty(s5) && s5.length() >= 0x2F3 && s5.charAt(0x2F2) == 49;
            arr_c[0] = '2';
            zzoc0 = new zzoc(zzoe.zzd(u00, y0, e00, arr_c, v, v4, v2, v1, v3, s, s2, s4, z1, z2, z));
        }
        else {
            String s6 = zzoe.zza(sharedPreferences0, "IABTCF_VendorConsents");
            if(!"".equals(s6) && s6.length() > 0x2F2) {
                hashMap0.put("GoogleConsent", String.valueOf(s6.charAt(0x2F2)));
            }
            int v6 = zzoe.zzb(sharedPreferences0, "IABTCF_gdprApplies");
            if(v6 != -1) {
                hashMap0.put("gdprApplies", String.valueOf(v6));
            }
            int v7 = zzoe.zzb(sharedPreferences0, "IABTCF_EnableAdvertiserConsentMode");
            if(v7 != -1) {
                hashMap0.put("EnableAdvertiserConsentMode", String.valueOf(v7));
            }
            int v8 = zzoe.zzb(sharedPreferences0, "IABTCF_PolicyVersion");
            if(v8 != -1) {
                hashMap0.put("PolicyVersion", String.valueOf(v8));
            }
            String s7 = zzoe.zza(sharedPreferences0, "IABTCF_PurposeConsents");
            if(!"".equals(s7)) {
                hashMap0.put("PurposeConsents", s7);
            }
            int v9 = zzoe.zzb(sharedPreferences0, "IABTCF_CmpSdkID");
            if(v9 != -1) {
                hashMap0.put("CmpSdkID", String.valueOf(v9));
            }
            zzoc0 = new zzoc(hashMap0);
        }
        zzib0.zzaV().zzk().zzb("Tcf preferences read", zzoc0);
        if(zzib0.zzc().zzp(null, zzfw0)) {
            zzhg zzhg0 = zzib0.zzd();
            zzhg0.zzg();
            String s8 = zzhg0.zzd().getString("stored_tcf_param", "");
            HashMap hashMap1 = new HashMap();
            if(!TextUtils.isEmpty(s8)) {
                String[] arr_s = s8.split(";");
                for(int v10 = 0; v10 < arr_s.length; ++v10) {
                    String[] arr_s1 = arr_s[v10].split("=");
                    if(arr_s1.length >= 2 && zzoe.zza.contains(arr_s1[0])) {
                        hashMap1.put(arr_s1[0], arr_s1[1]);
                    }
                }
            }
            zzoc1 = new zzoc(hashMap1);
            if(zzib0.zzd().zzm(zzoc0)) {
                Bundle bundle0 = zzoc0.zzb();
                zzib0.zzaV().zzk().zzb("Consent generated from Tcf", bundle0);
                if(bundle0 != Bundle.EMPTY) {
                    this.zzp(bundle0, -30, zzib0.zzaZ().currentTimeMillis());
                }
                Bundle bundle1 = new Bundle();
                bundle1.putString("_tcfm", zzoc0.zzd(zzoc1));
                bundle1.putString("_tcfd2", zzoc0.zzc());
                bundle1.putString("_tcfd", zzoc0.zze());
                this.zzF("auto", "_tcf", bundle1);
            }
        }
        else if(zzib0.zzd().zzm(zzoc0)) {
            Bundle bundle2 = zzoc0.zzb();
            zzib0.zzaV().zzk().zzb("Consent generated from Tcf", bundle2);
            if(bundle2 != Bundle.EMPTY) {
                this.zzp(bundle2, -30, zzib0.zzaZ().currentTimeMillis());
            }
            Bundle bundle3 = new Bundle();
            bundle3.putString("_tcfd", zzoc0.zze());
            this.zzF("auto", "_tcf", bundle3);
        }
    }

    public final void zzE() {
        this.zzg();
        zzib zzib0 = this.zzu;
        zzib0.zzaV().zzj().zza("Register tcfPrefChangeListener.");
        if(this.zzs == null) {
            this.zzt = new zzka(this, this.zzu);
            this.zzs = (SharedPreferences sharedPreferences0, String s) -> {
                zzib zzib0 = this.zzu;
                if(!zzib0.zzc().zzp(null, zzfx.zzaZ)) {
                    if(!Objects.equals(s, "IABTCF_TCString")) {
                        return;
                    }
                    zzib0.zzaV().zzk().zza("IABTCF_TCString change picked up in listener.");
                    ((zzay)Preconditions.checkNotNull(this.zzt)).zzb(500L);
                    return;
                }
                if(!Objects.equals(s, "IABTCF_TCString") && !Objects.equals(s, "IABTCF_gdprApplies") && !Objects.equals(s, "IABTCF_EnableAdvertiserConsentMode")) {
                    return;
                }
                zzib0.zzaV().zzk().zza("IABTCF_TCString change picked up in listener.");
                ((zzay)Preconditions.checkNotNull(this.zzt)).zzb(500L);
            };
        }
        zzib0.zzd().zze().registerOnSharedPreferenceChangeListener(this.zzs);
    }

    public final void zzF(String s, String s1, Bundle bundle0) {
        this.zzg();
        this.zzG(s, s1, this.zzu.zzaZ().currentTimeMillis(), bundle0);
    }

    public final void zzG(String s, String s1, long v, Bundle bundle0) {
        this.zzg();
        this.zzH(s, s1, v, bundle0, true, this.zzd == null || zzpo.zzZ(s1), true, null);
    }

    public final void zzH(String s, String s1, long v, Bundle bundle0, boolean z, boolean z1, boolean z2, String s2) {
        Bundle[] arr_bundle;
        long v6;
        zzib zzib5;
        boolean z5;
        Preconditions.checkNotEmpty(s);
        Preconditions.checkNotNull(bundle0);
        this.zzg();
        this.zzb();
        zzib zzib0 = this.zzu;
        if(zzib0.zzB()) {
            List list0 = this.zzu.zzv().zzp();
            if(list0 != null && !list0.contains(s1)) {
                this.zzu.zzaV().zzj().zzc("Dropping non-safelisted event. event name, origin", s1, s);
                return;
            }
            if(!this.zzf) {
                try {
                    this.zzf = true;
                    Class class0 = zzib0.zzp() ? Class.forName("com.google.android.gms.tagmanager.TagManagerService") : Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, this.zzu.zzaY().getClassLoader());
                    try {
                        class0.getDeclaredMethod("initialize", Context.class).invoke(null, this.zzu.zzaY());
                    }
                    catch(Exception exception0) {
                        this.zzu.zzaV().zze().zzb("Failed to invoke Tag Manager\'s initialize() method", exception0);
                    }
                }
                catch(ClassNotFoundException unused_ex) {
                    this.zzu.zzaV().zzi().zza("Tag Manager is not found and thus will not be used");
                }
            }
            zzib zzib1 = this.zzu;
            if(!zzib1.zzc().zzp(null, zzfx.zzbg) && "_cmp".equals(s1) && bundle0.containsKey("gclid")) {
                this.zzN("auto", "_lgclid", bundle0.getString("gclid"), zzib1.zzaZ().currentTimeMillis());
            }
            if(z && zzpo.zzaf(s1)) {
                zzib1.zzk().zzI(bundle0, zzib1.zzd().zzt.zza());
            }
            int v1 = 0;
            if(!z2 && !"_iap".equals(s1)) {
                zzib zzib2 = this.zzu;
                zzpo zzpo0 = zzib2.zzk();
                int v2 = 2;
                if(zzpo0.zzj("event", s1)) {
                    if(!zzpo0.zzl("event", zzjl.zza, zzjl.zzb, s1)) {
                        v2 = 13;
                    }
                    else if(zzpo0.zzm("event", 40, s1)) {
                        v2 = 0;
                    }
                }
                if(v2 != 0) {
                    zzib1.zzaV().zzd().zzb("Invalid public event name. Event will not be logged (FE)", zzib1.zzl().zza(s1));
                    String s3 = zzib2.zzk().zzC(s1, 40, true);
                    if(s1 != null) {
                        v1 = s1.length();
                    }
                    zzib2.zzk().zzN(this.zzv, null, v2, "_ev", s3, v1);
                    return;
                }
            }
            zzib zzib3 = this.zzu;
            zzlt zzlt0 = zzib3.zzs().zzh(false);
            if(zzlt0 != null && !bundle0.containsKey("_sc")) {
                zzlt0.zzd = true;
            }
            zzpo.zzav(zzlt0, bundle0, z && !z2);
            boolean z3 = "am".equals(s);
            boolean z4 = zzpo.zzZ(s1);
            if(!z || this.zzd == null || z4) {
                z5 = z3;
            }
            else {
                if(z3) {
                    z5 = true;
                    goto label_58;
                }
                zzib1.zzaV().zzj().zzc("Passing event to registered event handler (FE)", zzib1.zzl().zza(s1), zzib1.zzl().zze(bundle0));
                Preconditions.checkNotNull(this.zzd);
                this.zzd.interceptEvent(s, s1, bundle0, v);
                return;
            }
        label_58:
            zzib zzib4 = this.zzu;
            if(zzib4.zzH()) {
                int v3 = zzib1.zzk().zzn(s1);
                if(v3 != 0) {
                    zzib1.zzaV().zzd().zzb("Invalid event name. Event will not be logged (FE)", zzib1.zzl().zza(s1));
                    String s4 = zzib1.zzk().zzC(s1, 40, true);
                    if(s1 != null) {
                        v1 = s1.length();
                    }
                    zzib4.zzk().zzN(this.zzv, s2, v3, "_ev", s4, v1);
                    return;
                }
                List list1 = CollectionUtils.listOf(new String[]{"_o", "_sn", "_sc", "_si"});
                Bundle bundle1 = zzib1.zzk().zzF(s2, s1, bundle0, list1, z2);
                Preconditions.checkNotNull(bundle1);
                if(zzib3.zzs().zzh(false) == null || !"_ae".equals(s1)) {
                    zzib5 = zzib3;
                }
                else {
                    zzob zzob0 = zzib3.zzh();
                    long v4 = zzob0.zzb.zzc.zzu.zzaZ().elapsedRealtime();
                    zzib5 = zzib3;
                    long v5 = v4 - zzob0.zzb.zzb;
                    zzob0.zzb.zzb = v4;
                    if(v5 > 0L) {
                        zzib1.zzk().zzak(bundle1, v5);
                    }
                }
                if(!"auto".equals(s) && "_ssr".equals(s1)) {
                    zzpo zzpo1 = zzib1.zzk();
                    String s5 = bundle1.getString("_ffr");
                    if(Strings.isEmptyOrWhitespace(s5)) {
                        s5 = null;
                    }
                    else if(s5 != null) {
                        s5 = s5.trim();
                    }
                    zzib zzib6 = zzpo1.zzu;
                    if(!Objects.equals(s5, zzib6.zzd().zzq.zza())) {
                        zzib6.zzd().zzq.zzb(s5);
                        goto label_99;
                    }
                    zzib6.zzaV().zzj().zza("Not logging duplicate session_start_with_rollout event");
                    return;
                }
                else if("_ae".equals(s1)) {
                    String s6 = zzib1.zzk().zzu.zzd().zzq.zza();
                    if(!TextUtils.isEmpty(s6)) {
                        bundle1.putString("_ffr", s6);
                    }
                }
            label_99:
                ArrayList arrayList0 = new ArrayList();
                arrayList0.add(bundle1);
                boolean z6 = zzib1.zzc().zzp(null, zzfx.zzaU) ? zzib5.zzh().zzi() : zzib1.zzd().zzn.zza();
                if(zzib1.zzd().zzk.zza() > 0L && zzib1.zzd().zzp(v) && z6) {
                    zzib1.zzaV().zzk().zza("Current session is expired, remove the session number, ID, and engagement time");
                    this.zzN("auto", "_sid", null, zzib1.zzaZ().currentTimeMillis());
                    this.zzN("auto", "_sno", null, zzib1.zzaZ().currentTimeMillis());
                    this.zzN("auto", "_se", null, zzib1.zzaZ().currentTimeMillis());
                    zzib1.zzd().zzl.zzb(0L);
                }
                if(bundle1.getLong("extend_session", 0L) == 1L) {
                    zzib1.zzaV().zzk().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                    v6 = v;
                    zzib4.zzh().zza.zzb(v6, true);
                }
                else {
                    v6 = v;
                }
                ArrayList arrayList1 = new ArrayList(bundle1.keySet());
                Collections.sort(arrayList1);
                int v7 = arrayList1.size();
                for(int v8 = 0; v8 < v7; ++v8) {
                    String s7 = (String)arrayList1.get(v8);
                    if(s7 != null) {
                        zzib1.zzk();
                        Object object0 = bundle1.get(s7);
                        if(object0 instanceof Bundle) {
                            arr_bundle = new Bundle[]{((Bundle)object0)};
                        }
                        else if(object0 instanceof Parcelable[]) {
                            arr_bundle = (Bundle[])Arrays.copyOf(((Parcelable[])object0), ((Parcelable[])object0).length, Bundle[].class);
                        }
                        else {
                            arr_bundle = object0 instanceof ArrayList ? ((Bundle[])((ArrayList)object0).toArray(new Bundle[((ArrayList)object0).size()])) : null;
                        }
                        if(arr_bundle != null) {
                            bundle1.putParcelableArray(s7, arr_bundle);
                        }
                    }
                }
                int v9 = 0;
                while(v9 < arrayList0.size()) {
                    Bundle bundle2 = (Bundle)arrayList0.get(v9);
                    bundle2.putString("_o", s);
                    if(z1) {
                        bundle2 = zzib1.zzk().zzab(bundle2, null);
                    }
                    Bundle bundle3 = bundle2;
                    zzbg zzbg0 = new zzbg((v9 == 0 ? s1 : "_ep"), new zzbe(bundle3), s, v6);
                    zzib5.zzt().zzn(zzbg0, s2);
                    if(!z5) {
                        for(Object object1: this.zze) {
                            ((zzjp)object1).onEvent(s, s1, new Bundle(bundle3), v);
                        }
                    }
                    ++v9;
                    v6 = v;
                }
                if(zzib5.zzs().zzh(false) != null && "_ae".equals(s1)) {
                    zzob zzob1 = zzib5.zzh();
                    long v10 = zzib1.zzaZ().elapsedRealtime();
                    zzob1.zzb.zzd(true, true, v10);
                }
            }
            return;
        }
        this.zzu.zzaV().zzj().zza("Event not sent since app measurement is disabled");
    }

    public final void zzI(String s, String s1, Bundle bundle0, String s2) {
        zzib.zzL();
        this.zzJ("auto", s1, this.zzu.zzaZ().currentTimeMillis(), bundle0, false, true, true, s2);
    }

    public final void zzJ(String s, String s1, long v, Bundle bundle0, boolean z, boolean z1, boolean z2, String s2) {
        Bundle bundle1 = new Bundle(bundle0);
        Iterator iterator0 = bundle1.keySet().iterator();
        while(iterator0.hasNext()) {
            int v1 = 0;
            Object object0 = iterator0.next();
            String s3 = (String)object0;
            Object object1 = bundle1.get(s3);
            if(object1 instanceof Bundle) {
                bundle1.putBundle(s3, new Bundle(((Bundle)object1)));
            }
            else if(object1 instanceof Parcelable[]) {
                Parcelable[] arr_parcelable = (Parcelable[])object1;
                while(v1 < arr_parcelable.length) {
                    Parcelable parcelable0 = arr_parcelable[v1];
                    if(parcelable0 instanceof Bundle) {
                        arr_parcelable[v1] = new Bundle(((Bundle)parcelable0));
                    }
                    ++v1;
                }
            }
            else if(object1 instanceof List) {
                List list0 = (List)object1;
                while(v1 < list0.size()) {
                    Object object2 = list0.get(v1);
                    if(object2 instanceof Bundle) {
                        list0.set(v1, new Bundle(((Bundle)object2)));
                    }
                    ++v1;
                }
            }
        }
        this.zzu.zzaW().zzj(new zzkb(this, s, s1, v, bundle1, z, z1, z2, s2));
    }

    public final void zzK(String s, String s1, Object object0, boolean z) {
        this.zzL("auto", "_ldl", object0, true, this.zzu.zzaZ().currentTimeMillis());
    }

    public final void zzL(String s, String s1, Object object0, boolean z, long v) {
        int v2;
        int v1 = 0;
        if(z) {
            v2 = this.zzu.zzk().zzp(s1);
        }
        else {
            zzpo zzpo0 = this.zzu.zzk();
            if(!zzpo0.zzj("user property", s1)) {
                v2 = 6;
            }
            else if(!zzpo0.zzl("user property", zzjn.zza, null, s1)) {
                v2 = 15;
            }
            else if(zzpo0.zzm("user property", 24, s1)) {
                v2 = 0;
            }
            else {
                v2 = 6;
            }
        }
        if(v2 != 0) {
            String s2 = this.zzu.zzk().zzC(s1, 24, true);
            if(s1 != null) {
                v1 = s1.length();
            }
            this.zzu.zzk().zzN(this.zzv, null, v2, "_ev", s2, v1);
            return;
        }
        String s3 = s == null ? "app" : s;
        if(object0 != null) {
            zzib zzib0 = this.zzu;
            int v3 = zzib0.zzk().zzK(s1, object0);
            if(v3 != 0) {
                String s4 = zzib0.zzk().zzC(s1, 24, true);
                if(object0 instanceof String || object0 instanceof CharSequence) {
                    v1 = object0.toString().length();
                }
                this.zzu.zzk().zzN(this.zzv, null, v3, "_ev", s4, v1);
                return;
            }
            Object object1 = zzib0.zzk().zzL(s1, object0);
            if(object1 != null) {
                this.zzM(s3, s1, v, object1);
            }
            return;
        }
        this.zzM(s3, s1, v, null);
    }

    public final void zzM(String s, String s1, long v, Object object0) {
        this.zzu.zzaW().zzj(new zzkc(this, s, s1, object0, v));
    }

    public final void zzN(String s, String s1, Object object0, long v) {
        String s2 = "false";
        Preconditions.checkNotEmpty(s);
        Preconditions.checkNotEmpty(s1);
        this.zzg();
        this.zzb();
        if("allow_personalized_ads".equals(s1)) {
            if(object0 instanceof String && !TextUtils.isEmpty(((String)object0))) {
                object0 = (long)("false".equals(((String)object0).toLowerCase(Locale.ENGLISH)) ? 1L : 0L);
                zzhf zzhf0 = this.zzu.zzd().zzh;
                if(((long)(((Long)object0))) == 1L) {
                    s2 = "true";
                }
                zzhf0.zzb(s2);
                s1 = "_npa";
            }
            else if(object0 == null) {
                this.zzu.zzd().zzh.zzb("unset");
                s1 = "_npa";
            }
            this.zzu.zzaV().zzk().zzc("Setting user property(FE)", "non_personalized_ads(_npa)", object0);
        }
        zzib zzib0 = this.zzu;
        if(!zzib0.zzB()) {
            this.zzu.zzaV().zzk().zza("User property not set since app measurement is disabled");
            return;
        }
        if(!zzib0.zzH()) {
            return;
        }
        zzpk zzpk0 = new zzpk(s1, v, object0, s);
        this.zzu.zzt().zzA(zzpk0);
    }

    public final List zzO(boolean z) {
        this.zzb();
        zzib zzib0 = this.zzu;
        zzib0.zzaV().zzk().zza("Getting user properties (FE)");
        if(!zzib0.zzaW().zze()) {
            if(zzae.zza()) {
                Z.u(zzib0, "Cannot get all user properties from main thread");
                return Collections.EMPTY_LIST;
            }
            AtomicReference atomicReference0 = new AtomicReference();
            this.zzu.zzaW().zzk(atomicReference0, 5000L, "get user properties", new zzke(this, atomicReference0, z));
            List list0 = (List)atomicReference0.get();
            if(list0 == null) {
                zzib0.zzaV().zzb().zzb("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.EMPTY_LIST;
            }
            return list0;
        }
        Z.u(zzib0, "Cannot get all user properties from analytics worker thread");
        return Collections.EMPTY_LIST;
    }

    public final Map zzP(String s, String s1, boolean z) {
        zzib zzib0 = this.zzu;
        if(zzib0.zzaW().zze()) {
            Z.u(zzib0, "Cannot get user properties from analytics worker thread");
            return Collections.EMPTY_MAP;
        }
        if(zzae.zza()) {
            Z.u(zzib0, "Cannot get user properties from main thread");
            return Collections.EMPTY_MAP;
        }
        AtomicReference atomicReference0 = new AtomicReference();
        this.zzu.zzaW().zzk(atomicReference0, 5000L, "get user properties", new zzkk(this, atomicReference0, null, s, s1, z));
        List list0 = (List)atomicReference0.get();
        if(list0 == null) {
            zzib0.zzaV().zzb().zzb("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.EMPTY_MAP;
        }
        Map map0 = new f(list0.size());  // 初始化器: Landroidx/collection/V;-><init>(I)V
        for(Object object0: list0) {
            zzpk zzpk0 = (zzpk)object0;
            Object object1 = zzpk0.zza();
            if(object1 != null) {
                ((V)map0).put(zzpk0.zzb, object1);
            }
        }
        return map0;
    }

    public final String zzQ() {
        return (String)this.zzg.get();
    }

    public final void zzR(String s) {
        this.zzg.set(s);
    }

    // 检测为 Lambda 实现
    public final void zzS() [...]

    public final void zzT(long v) {
        this.zzg.set(null);
        this.zzu.zzaW().zzj(new zzkg(this, v));
    }

    public final void zzU() {
        this.zzg();
        this.zzb();
        if(this.zzu.zzH()) {
            zzib zzib0 = this.zzu;
            Boolean boolean0 = zzib0.zzc().zzr("google_analytics_deferred_deep_link_enabled");
            if(boolean0 != null && boolean0.booleanValue()) {
                zzib0.zzaV().zzj().zza("Deferred Deep Link feature enabled.");
                zzib0.zzaW().zzj(() -> {
                    this.zzg();
                    zzib zzib0 = this.zzu;
                    if(!zzib0.zzd().zzo.zza()) {
                        long v = zzib0.zzd().zzp.zza();
                        zzib0.zzd().zzp.zzb(v + 1L);
                        if(v >= 5L) {
                            zzib0.zzaV().zze().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                            zzib0.zzd().zzo.zzb(true);
                            return;
                        }
                        if(this.zzr == null) {
                            this.zzr = new zzkf(this, this.zzu);
                        }
                        this.zzr.zzb(0L);
                        return;
                    }
                    zzib0.zzaV().zzj().zza("Deferred Deep Link already retrieved. Not fetching again.");
                });
            }
            this.zzu.zzt().zzE();
            this.zzc = false;
            zzhg zzhg0 = zzib0.zzd();
            zzhg0.zzg();
            String s = zzhg0.zzd().getString("previous_os_version", null);
            zzhg0.zzu.zzu().zzw();
            String s1 = Build.VERSION.RELEASE;
            if(!TextUtils.isEmpty(s1) && !s1.equals(s)) {
                SharedPreferences.Editor sharedPreferences$Editor0 = zzhg0.zzd().edit();
                sharedPreferences$Editor0.putString("previous_os_version", s1);
                sharedPreferences$Editor0.apply();
            }
            if(!TextUtils.isEmpty(s)) {
                zzib0.zzu().zzw();
                if(!s.equals(s1)) {
                    Bundle bundle0 = new Bundle();
                    bundle0.putString("_po", s);
                    this.zzF("auto", "_ou", bundle0);
                }
            }
        }
    }

    public final void zzV(zzjo zzjo0) {
        this.zzg();
        this.zzb();
        if(zzjo0 != null) {
            zzjo zzjo1 = this.zzd;
            if(zzjo0 != zzjo1) {
                Preconditions.checkState(zzjo1 == null, "EventInterceptor already set.");
            }
        }
        this.zzd = zzjo0;
    }

    public final void zzW(zzjp zzjp0) {
        this.zzb();
        Preconditions.checkNotNull(zzjp0);
        if(!this.zze.add(zzjp0)) {
            Z.A(this.zzu, "OnEventListener already registered");
        }
    }

    public final void zzX(zzjp zzjp0) {
        this.zzb();
        Preconditions.checkNotNull(zzjp0);
        if(!this.zze.remove(zzjp0)) {
            Z.A(this.zzu, "OnEventListener had not been registered");
        }
    }

    public final int zzY(String s) {
        Preconditions.checkNotEmpty(s);
        return 25;
    }

    public final void zzZ(Bundle bundle0) {
        this.zzaa(bundle0, this.zzu.zzaZ().currentTimeMillis());
    }

    public final void zzaa(Bundle bundle0, long v) {
        Preconditions.checkNotNull(bundle0);
        Bundle bundle1 = new Bundle(bundle0);
        if(!TextUtils.isEmpty(bundle1.getString("app_id"))) {
            Z.A(this.zzu, "Package name should be null when calling setConditionalUserProperty");
        }
        bundle1.remove("app_id");
        Preconditions.checkNotNull(bundle1);
        zzjg.zzb(bundle1, "app_id", String.class, null);
        zzjg.zzb(bundle1, "origin", String.class, null);
        zzjg.zzb(bundle1, "name", String.class, null);
        zzjg.zzb(bundle1, "value", Object.class, null);
        zzjg.zzb(bundle1, "trigger_event_name", String.class, null);
        zzjg.zzb(bundle1, "trigger_timeout", Long.class, 0L);
        zzjg.zzb(bundle1, "timed_out_event_name", String.class, null);
        zzjg.zzb(bundle1, "timed_out_event_params", Bundle.class, null);
        zzjg.zzb(bundle1, "triggered_event_name", String.class, null);
        zzjg.zzb(bundle1, "triggered_event_params", Bundle.class, null);
        zzjg.zzb(bundle1, "time_to_live", Long.class, 0L);
        zzjg.zzb(bundle1, "expired_event_name", String.class, null);
        zzjg.zzb(bundle1, "expired_event_params", Bundle.class, null);
        Preconditions.checkNotEmpty(bundle1.getString("name"));
        Preconditions.checkNotEmpty(bundle1.getString("origin"));
        Preconditions.checkNotNull(bundle1.get("value"));
        bundle1.putLong("creation_timestamp", v);
        String s = bundle1.getString("name");
        Object object0 = bundle1.get("value");
        zzib zzib0 = this.zzu;
        if(zzib0.zzk().zzp(s) == 0) {
            if(zzib0.zzk().zzK(s, object0) == 0) {
                Object object1 = zzib0.zzk().zzL(s, object0);
                if(object1 == null) {
                    zzib0.zzaV().zzb().zzc("Unable to normalize conditional user property value", zzib0.zzl().zzc(s), object0);
                    return;
                }
                zzjg.zza(bundle1, object1);
                long v1 = bundle1.getLong("trigger_timeout");
                if(!TextUtils.isEmpty(bundle1.getString("trigger_event_name")) && (v1 > 15552000000L || v1 < 1L)) {
                    zzib0.zzaV().zzb().zzc("Invalid conditional user property timeout", zzib0.zzl().zzc(s), v1);
                    return;
                }
                long v2 = bundle1.getLong("time_to_live");
                if(v2 <= 15552000000L && v2 >= 1L) {
                    zzib0.zzaW().zzj(new zzkh(this, bundle1));
                    return;
                }
                zzib0.zzaV().zzb().zzc("Invalid conditional user property time to live", zzib0.zzl().zzc(s), v2);
                return;
            }
            zzib0.zzaV().zzb().zzc("Invalid conditional user property value", zzib0.zzl().zzc(s), object0);
            return;
        }
        zzib0.zzaV().zzb().zzb("Invalid conditional user property name", zzib0.zzl().zzc(s));
    }

    public final void zzab(String s, String s1, Bundle bundle0) {
        zzib zzib0 = this.zzu;
        long v = zzib0.zzaZ().currentTimeMillis();
        Preconditions.checkNotEmpty(s);
        Bundle bundle1 = new Bundle();
        bundle1.putString("name", s);
        bundle1.putLong("creation_timestamp", v);
        if(s1 != null) {
            bundle1.putString("expired_event_name", s1);
            bundle1.putBundle("expired_event_params", bundle0);
        }
        zzib0.zzaW().zzj(new zzki(this, bundle1));
    }

    public final ArrayList zzac(String s, String s1) {
        zzib zzib0 = this.zzu;
        if(zzib0.zzaW().zze()) {
            zzib0.zzaV().zzb().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        if(zzae.zza()) {
            zzib0.zzaV().zzb().zza("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference0 = new AtomicReference();
        this.zzu.zzaW().zzk(atomicReference0, 5000L, "get conditional user properties", new zzkj(this, atomicReference0, null, s, s1));
        List list0 = (List)atomicReference0.get();
        if(list0 == null) {
            zzib0.zzaV().zzb().zzb("Timed out waiting for get conditional user properties", null);
            return new ArrayList();
        }
        return zzpo.zzas(list0);
    }

    public final String zzad() {
        zzlt zzlt0 = this.zzu.zzs().zzl();
        return zzlt0 == null ? null : zzlt0.zza;
    }

    public final String zzae() {
        zzlt zzlt0 = this.zzu.zzs().zzl();
        return zzlt0 == null ? null : zzlt0.zzb;
    }

    // 检测为 Lambda 实现
    public final void zzaf(SharedPreferences sharedPreferences0, String s) [...]

    public final void zzag(Bundle bundle0) {
        int v;
        Bundle bundle1;
        if(bundle0.isEmpty()) {
            bundle1 = bundle0;
        }
        else {
            zzib zzib0 = this.zzu;
            bundle1 = new Bundle(zzib0.zzd().zzt.zza());
            Iterator iterator0 = bundle0.keySet().iterator();
            while(true) {
                v = 0;
                if(!iterator0.hasNext()) {
                    break;
                }
                Object object0 = iterator0.next();
                String s = (String)object0;
                Object object1 = bundle0.get(s);
                if(object1 != null && !(object1 instanceof String) && !(object1 instanceof Long) && !(object1 instanceof Double)) {
                    if(zzib0.zzk().zzt(object1)) {
                        zzib0.zzk().zzN(this.zzv, null, 27, null, null, 0);
                    }
                    zzib0.zzaV().zzh().zzc("Invalid default event parameter type. Name, value", s, object1);
                }
                else if(zzpo.zzZ(s)) {
                    zzib0.zzaV().zzh().zzb("Invalid default event parameter name. Name", s);
                }
                else if(object1 == null) {
                    bundle1.remove(s);
                }
                else if(zzib0.zzk().zzu("param", s, zzib0.zzc().zze(null, false), object1)) {
                    zzib0.zzk().zzM(bundle1, s, object1);
                }
            }
            zzib0.zzk();
            int v1 = zzib0.zzc().zzc();
            if(bundle1.size() > v1) {
                for(Object object2: new TreeSet(bundle1.keySet())) {
                    String s1 = (String)object2;
                    ++v;
                    if(v > v1) {
                        bundle1.remove(s1);
                    }
                }
                zzib0.zzk().zzN(this.zzv, null, 26, null, null, 0);
                zzib0.zzaV().zzh().zza("Too many default event parameters set. Discarding beyond event parameter limit");
            }
        }
        this.zzu.zzd().zzt.zzb(bundle1);
        if(bundle0.isEmpty() && !this.zzu.zzc().zzp(null, zzfx.zzaW)) {
            return;
        }
        this.zzu.zzt().zzH(bundle1);
    }

    public final void zzah(int v) {
        if(this.zzk == null) {
            this.zzk = new zzjw(this, this.zzu);
        }
        this.zzk.zzb(((long)v) * 1000L);
    }

    public final void zzai(Boolean boolean0, boolean z) {
        this.zzar(boolean0, true);
    }

    public final void zzaj(zzjk zzjk0, long v, boolean z, boolean z1) {
        this.zzg();
        this.zzb();
        zzib zzib0 = this.zzu;
        zzjk zzjk1 = zzib0.zzd().zzl();
        if(v <= this.zzq && zzjk.zzu(zzjk1.zzb(), zzjk0.zzb())) {
            zzib0.zzaV().zzi().zzb("Dropped out-of-date consent setting, proposed settings", zzjk0);
            return;
        }
        zzhg zzhg0 = zzib0.zzd();
        zzhg0.zzg();
        int v1 = zzjk0.zzb();
        if(zzhg0.zzk(v1)) {
            zzib zzib1 = this.zzu;
            SharedPreferences.Editor sharedPreferences$Editor0 = zzhg0.zzd().edit();
            sharedPreferences$Editor0.putString("consent_settings", zzjk0.zzl());
            sharedPreferences$Editor0.putInt("consent_source", v1);
            sharedPreferences$Editor0.apply();
            zzib0.zzaV().zzk().zzb("Setting storage consent(FE)", zzjk0);
            this.zzq = v;
            if(zzib1.zzt().zzP()) {
                zzib1.zzt().zzk(z);
            }
            else {
                zzib1.zzt().zzj(z);
            }
            if(z1) {
                zzib1.zzt().zzC(new AtomicReference());
            }
            return;
        }
        zzib0.zzaV().zzi().zzb("Lower precedence consent source ignored, proposed source", zzjk0.zzb());
    }

    public final void zzak() {
        this.zzas();
    }

    public final void zzal(boolean z) {
        this.zzi = false;
    }

    public final int zzam() {
        return this.zzj;
    }

    public final void zzan(int v) {
        this.zzj = v;
    }

    public final zzay zzao() {
        return this.zzr;
    }

    public final int zzap(Throwable throwable0) {
        String s = throwable0.getMessage();
        this.zzn = false;
        if(s == null) {
            return 2;
        }
        if(!(throwable0 instanceof IllegalStateException) && !s.contains("garbage collected") && !throwable0.getClass().getSimpleName().equals("ServiceUnavailableException")) {
            return throwable0 instanceof SecurityException && !s.endsWith("READ_DEVICE_CONFIG") ? 3 : 2;
        }
        if(!s.contains("Background")) {
            return 1;
        }
        this.zzn = true;
        return 1;
    }

    private final zzlq zzaq(zzol zzol0) {
        URL uRL0;
        try {
            uRL0 = new URI(zzol0.zzc).toURL();
        }
        catch(URISyntaxException | MalformedURLException uRISyntaxException0) {
            this.zzu.zzaV().zzb().zzd("[sgtm] Bad upload url for row_id", zzol0.zzc, zzol0.zza, uRISyntaxException0);
            return zzlq.zzc;
        }
        AtomicReference atomicReference0 = new AtomicReference();
        String s = this.zzu.zzv().zzl();
        zzib zzib0 = this.zzu;
        zzgr zzgr0 = zzib0.zzaV().zzk();
        Long long0 = zzol0.zza;
        zzgr0.zzd("[sgtm] Uploading data from app. row_id, url, uncompressed size", long0, zzol0.zzc, ((int)zzol0.zzb.length));
        if(!TextUtils.isEmpty(zzol0.zzg)) {
            zzib0.zzaV().zzk().zzc("[sgtm] Uploading data from app. row_id", long0, zzol0.zzg);
        }
        HashMap hashMap0 = new HashMap();
        Bundle bundle0 = zzol0.zzd;
        for(Object object0: bundle0.keySet()) {
            String s1 = (String)object0;
            String s2 = bundle0.getString(s1);
            if(!TextUtils.isEmpty(s2)) {
                hashMap0.put(s1, s2);
            }
        }
        zzln zzln0 = zzib0.zzn();
        byte[] arr_b = zzol0.zzb;
        zzky zzky0 = new zzky(this, atomicReference0, zzol0);
        zzln0.zzw();
        Preconditions.checkNotNull(uRL0);
        Preconditions.checkNotNull(arr_b);
        Preconditions.checkNotNull(zzky0);
        zzln0.zzu.zzaW().zzm(new zzlm(zzln0, s, uRL0, arr_b, hashMap0, zzky0));
        try {
            zzib zzib1 = zzib0.zzk().zzu;
            long v = zzib1.zzaZ().currentTimeMillis();
            synchronized(atomicReference0) {
                for(long v1 = 60000L; atomicReference0.get() == null && v1 > 0L; v1 = v + 60000L - zzib1.zzaZ().currentTimeMillis()) {
                    atomicReference0.wait(v1);
                }
            }
            return atomicReference0.get() == null ? zzlq.zza : ((zzlq)atomicReference0.get());
        }
        catch(InterruptedException unused_ex) {
            Z.A(this.zzu, "[sgtm] Interrupted waiting for uploading batch");
            return atomicReference0.get() == null ? zzlq.zza : ((zzlq)atomicReference0.get());
        }
    }

    private final void zzar(Boolean boolean0, boolean z) {
        this.zzg();
        this.zzb();
        zzib zzib0 = this.zzu;
        zzib0.zzaV().zzj().zzb("Setting app measurement enabled (FE)", boolean0);
        zzib0.zzd().zzh(boolean0);
        if(z) {
            zzhg zzhg0 = zzib0.zzd();
            zzhg0.zzg();
            SharedPreferences.Editor sharedPreferences$Editor0 = zzhg0.zzd().edit();
            if(boolean0 == null) {
                sharedPreferences$Editor0.remove("measurement_enabled_from_api");
            }
            else {
                sharedPreferences$Editor0.putBoolean("measurement_enabled_from_api", boolean0.booleanValue());
            }
            sharedPreferences$Editor0.apply();
        }
        if(!this.zzu.zzE() && (boolean0 == null || boolean0.booleanValue())) {
            return;
        }
        this.zzas();
    }

    private final void zzas() {
        this.zzg();
        zzib zzib0 = this.zzu;
        String s = zzib0.zzd().zzh.zza();
        if(s != null) {
            if("unset".equals(s)) {
                this.zzN("app", "_npa", null, zzib0.zzaZ().currentTimeMillis());
            }
            else {
                this.zzN("app", "_npa", ((long)("true".equals(s) ? 1L : 0L)), zzib0.zzaZ().currentTimeMillis());
            }
        }
        if(this.zzu.zzB() && this.zzc) {
            zzib0.zzaV().zzj().zza("Recording app launch after enabling measurement for the first time (FE)");
            this.zzU();
            this.zzu.zzh().zza.zza();
            zzib0.zzaW().zzj(new zzjy(this));
            return;
        }
        zzib0.zzaV().zzj().zza("Updating Scion state (FE)");
        this.zzu.zzt().zzi();
    }

    @Override  // com.google.android.gms.measurement.internal.zzg
    public final boolean zze() {
        return false;
    }

    public final void zzh() {
        zzib zzib0 = this.zzu;
        if(zzib0.zzaY().getApplicationContext() instanceof Application && this.zza != null) {
            ((Application)zzib0.zzaY().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    public final Boolean zzi() {
        AtomicReference atomicReference0 = new AtomicReference();
        return (Boolean)this.zzu.zzaW().zzk(atomicReference0, 15000L, "boolean test flag value", new zzkd(this, atomicReference0));
    }

    public final String zzj() {
        AtomicReference atomicReference0 = new AtomicReference();
        return (String)this.zzu.zzaW().zzk(atomicReference0, 15000L, "String test flag value", new zzkn(this, atomicReference0));
    }

    public final Long zzk() {
        AtomicReference atomicReference0 = new AtomicReference();
        return (Long)this.zzu.zzaW().zzk(atomicReference0, 15000L, "long test flag value", new com.google.android.gms.measurement.internal.zzko(this, atomicReference0));
    }

    public final Integer zzl() {
        AtomicReference atomicReference0 = new AtomicReference();
        return (Integer)this.zzu.zzaW().zzk(atomicReference0, 15000L, "int test flag value", new com.google.android.gms.measurement.internal.zzkp(this, atomicReference0));
    }

    public final Double zzm() {
        AtomicReference atomicReference0 = new AtomicReference();
        return (Double)this.zzu.zzaW().zzk(atomicReference0, 15000L, "double test flag value", new zzkq(this, atomicReference0));
    }

    public final void zzn(Boolean boolean0) {
        this.zzb();
        this.zzu.zzaW().zzj(new zzkr(this, boolean0));
    }

    public final void zzp(Bundle bundle0, int v, long v1) {
        Object object0;
        this.zzb();
        zzjj[] arr_zzjj = zzji.zza.zzb();
        for(int v2 = 0; true; ++v2) {
            object0 = null;
            if(v2 >= arr_zzjj.length) {
                break;
            }
            String s = arr_zzjj[v2].zze;
            if(bundle0.containsKey(s)) {
                String s1 = bundle0.getString(s);
                if(s1 != null && !s1.equals("granted")) {
                    if(s1.equals("denied")) {
                        object0 = Boolean.FALSE;
                    }
                    if(object0 == null) {
                        object0 = s1;
                        break;
                    }
                }
            }
        }
        if(object0 != null) {
            this.zzu.zzaV().zzh().zzb("Ignoring invalid consent setting", object0);
            this.zzu.zzaV().zzh().zza("Valid consent values are \'granted\', \'denied\'");
        }
        boolean z = this.zzu.zzaW().zze();
        zzjk zzjk0 = zzjk.zze(bundle0, v);
        if(zzjk0.zzc()) {
            this.zzs(zzjk0, z);
        }
        zzaz zzaz0 = zzaz.zzh(bundle0, v);
        if(zzaz0.zzd()) {
            this.zzq(zzaz0, z);
        }
        Boolean boolean0 = zzaz.zzi(bundle0);
        if(boolean0 != null) {
            String s2 = v == -30 ? "tcf" : "app";
            if(z) {
                this.zzN(s2, "allow_personalized_ads", boolean0.toString(), v1);
                return;
            }
            this.zzL(s2, "allow_personalized_ads", boolean0.toString(), false, v1);
        }
    }

    public final void zzq(zzaz zzaz0, boolean z) {
        zzks zzks0 = new zzks(this, zzaz0);
        if(z) {
            this.zzg();
            zzks0.run();
            return;
        }
        this.zzu.zzaW().zzj(zzks0);
    }

    public final void zzs(zzjk zzjk0, boolean z) {
        Throwable throwable2;
        boolean z3;
        boolean z2;
        this.zzb();
        int v = zzjk0.zzb();
        if(v != -10 && (zzjk0.zzp() == zzjh.zza && zzjk0.zzq() == zzjh.zza)) {
            this.zzu.zzaV().zzh().zza("Ignoring empty consent settings");
            return;
        }
        boolean z1 = false;
        Object object0 = this.zzh;
        __monitor_enter(object0);
        try {
            if(zzjk.zzu(v, this.zzo.zzb())) {
                goto label_9;
            }
            else {
                goto label_20;
            }
            goto label_22;
        }
        catch(Throwable throwable0) {
            goto label_25;
        }
        try {
        label_9:
            z2 = zzjk0.zzr(this.zzo);
            if(zzjk0.zzo(zzjj.zzb) && !this.zzo.zzo(zzjj.zzb)) {
                z1 = true;
            }
            zzjk0 = zzjk0.zzt(this.zzo);
            this.zzo = zzjk0;
            z3 = z1;
            z1 = true;
            goto label_22;
        }
        catch(Throwable throwable1) {
            throwable2 = throwable1;
            goto label_26;
        }
    label_20:
        z2 = false;
        z3 = false;
        try {
        label_22:
            __monitor_exit(object0);
            goto label_28;
        label_25:
            throwable2 = throwable0;
        label_26:
            __monitor_exit(object0);
        }
        catch(Throwable throwable0) {
            goto label_25;
        }
        throw throwable2;
    label_28:
        if(!z1) {
            this.zzu.zzaV().zzi().zzb("Ignoring lower-priority consent settings, proposed settings", zzjk0);
            return;
        }
        long v1 = this.zzp.getAndIncrement();
        if(z2) {
            this.zzg.set(null);
            zzkt zzkt0 = new zzkt(this, zzjk0, v1, z3);
            if(z) {
                this.zzg();
                zzkt0.run();
                return;
            }
            this.zzu.zzaW().zzl(zzkt0);
            return;
        }
        zzku zzku0 = new zzku(this, zzjk0, v1, z3);
        if(z) {
            this.zzg();
            zzku0.run();
            return;
        }
        if(v != -10 && v != 30) {
            this.zzu.zzaW().zzj(zzku0);
            return;
        }
        this.zzu.zzaW().zzl(zzku0);
    }

    // This method was un-flattened
    public final void zzt(Runnable runnable0) {
        this.zzb();
        zzib zzib0 = this.zzu;
        if(!zzib0.zzaW().zze()) {
            if(!zzib0.zzaW().zzf()) {
                if(!zzae.zza()) {
                    zzib0.zzaV().zzk().zza("[sgtm] Started client-side batch upload work.");
                    int v = 0;
                    int v1 = 0;
                    while(true) {
                        zzib0.zzaV().zzk().zza("[sgtm] Getting upload batches from service (FE)");
                        AtomicReference atomicReference0 = new AtomicReference();
                        zzib0.zzaW().zzk(atomicReference0, 10000L, "[sgtm] Getting upload batches", new zzlh(this, atomicReference0));
                        zzop zzop0 = (zzop)atomicReference0.get();
                        if(zzop0 == null) {
                            break;
                        }
                        List list0 = zzop0.zza;
                        if(list0.isEmpty()) {
                            break;
                        }
                        zzib0.zzaV().zzk().zzb("[sgtm] Retrieved upload batches. count", list0.size());
                        v += list0.size();
                        Iterator iterator0 = list0.iterator();
                    label_18:
                        if(!iterator0.hasNext()) {
                            continue;
                        }
                        Object object0 = iterator0.next();
                        zzlq zzlq0 = this.zzaq(((zzol)object0));
                        if(zzlq0 == zzlq.zzb) {
                            ++v1;
                        }
                        else if(zzlq0 == zzlq.zzd) {
                            break;
                        }
                        goto label_18;
                    }
                    zzib0.zzaV().zzk().zzc("[sgtm] Completed client-side batch upload work. total, success", v, v1);
                    runnable0.run();
                    return;
                }
                Z.u(zzib0, "Cannot retrieve and upload batches from main thread");
                return;
            }
            Z.u(zzib0, "Cannot retrieve and upload batches from analytics network thread");
            return;
        }
        Z.u(zzib0, "Cannot retrieve and upload batches from analytics worker thread");
    }

    public final void zzu(long v) {
        this.zzg();
        if(this.zzl == null) {
            this.zzl = new zzjt(this, this.zzu);
        }
        this.zzl.zzb(v);
    }

    public final void zzv() {
        this.zzg();
        zzay zzay0 = this.zzl;
        if(zzay0 != null) {
            zzay0.zzd();
        }
    }

    public final void zzw() {
        zzql.zza();
        zzib zzib0 = this.zzu;
        if(zzib0.zzc().zzp(null, zzfx.zzaQ)) {
            if(!zzib0.zzaW().zze()) {
                if(!zzae.zza()) {
                    this.zzb();
                    zzib0.zzaV().zzk().zza("Getting trigger URIs (FE)");
                    AtomicReference atomicReference0 = new AtomicReference();
                    zzib0.zzaW().zzk(atomicReference0, 10000L, "get trigger URIs", new zzkz(this, atomicReference0));
                    List list0 = (List)atomicReference0.get();
                    if(list0 == null) {
                        zzib0.zzaV().zzd().zza("Timed out waiting for get trigger URIs");
                        return;
                    }
                    zzib0.zzaW().zzj(new zzla(this, list0));
                    return;
                }
                Z.u(zzib0, "Cannot get trigger URIs from main thread");
                return;
            }
            Z.u(zzib0, "Cannot get trigger URIs from analytics worker thread");
        }
    }

    public final boolean zzx() {
        return this.zzn;
    }

    @TargetApi(30)
    public final PriorityQueue zzy() {
        if(this.zzm == null) {
            this.zzm = new PriorityQueue(Comparator.comparing((Object object0) -> ((zzog)object0).zzb, (zzlc this, Object object0) -> Long.compare(((long)(((Long)object0))), ((long)(((Long)object1))))));
        }
        return this.zzm;
    }

    @TargetApi(30)
    public final void zzz() {
        this.zzg();
        this.zzn = false;
        if(!this.zzy().isEmpty() && !this.zzi) {
            zzog zzog0 = (zzog)this.zzy().poll();
            if(zzog0 != null) {
                zzib zzib0 = this.zzu;
                e e0 = zzib0.zzk().zzT();
                if(e0 != null) {
                    this.zzi = true;
                    zzib0.zzaV().zzk().zzb("Registering trigger URI", zzog0.zza);
                    B b0 = e0.b(Uri.parse(zzog0.zza));
                    if(b0 == null) {
                        this.zzi = false;
                        this.zzy().add(zzog0);
                        return;
                    }
                    zzju zzju0 = new zzju(this);
                    b0.addListener(new u(0, b0, new zzjv(this, zzog0)), zzju0);
                }
            }
        }
    }
}

