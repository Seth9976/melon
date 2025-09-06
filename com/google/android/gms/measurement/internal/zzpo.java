package com.google.android.gms.measurement.internal;

import M6.B;
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.compose.foundation.w;
import androidx.privacysandbox.ads.adservices.measurement.MeasurementManagerApi33Ext5Impl;
import b3.Z;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcu;
import com.google.android.material.internal.F;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import k8.Y;
import kotlin.jvm.internal.q;
import l4.P;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import r4.a;
import r4.b;
import t4.d;
import t4.e;
import u4.c;

public final class zzpo extends zzje {
    public static final int zza;
    private static final String[] zzb;
    private static final String[] zzc;
    private SecureRandom zzd;
    private final AtomicLong zze;
    private int zzf;
    private e zzg;
    private Boolean zzh;
    private Integer zzi;

    static {
        zzpo.zzb = new String[]{"firebase_", "google_", "ga_"};
        zzpo.zzc = new String[]{"_err"};
    }

    public zzpo(zzib zzib0) {
        super(zzib0);
        this.zzi = null;
        this.zze = new AtomicLong(0L);
    }

    public final boolean zzA(String s) {
        if(!TextUtils.isEmpty(s)) {
            Preconditions.checkNotNull(s);
            if(!s.matches("^1:\\d+:android:[a-f0-9]+$")) {
                this.zzu.zzaV().zzd().zzb("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzgt.zzl(s));
                return false;
            }
            return true;
        }
        this.zzu.zzaV().zzd().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
        return false;
    }

    public final boolean zzB(String s, String s1) {
        if(!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1)) {
            Preconditions.checkNotNull(s);
            return !s.equals(s1);
        }
        return false;
    }

    public final String zzC(String s, int v, boolean z) {
        if(s == null) {
            return null;
        }
        if(s.codePointCount(0, s.length()) > v) {
            return z ? s.substring(0, s.offsetByCodePoints(0, v)) + "..." : null;
        }
        return s;
    }

    public final int zzD(String s, String s1, String s2, Object object0, Bundle bundle0, List list0, boolean z, boolean z1) {
        int v1;
        int v;
        this.zzg();
        if(this.zzt(object0)) {
            if(!z1) {
                return 21;
            }
            if(!zzpo.zzaA(s2, zzjm.zzc)) {
                return 20;
            }
            zznk zznk0 = this.zzu.zzt();
            zznk0.zzg();
            zznk0.zzb();
            if(zznk0.zzK() && zznk0.zzu.zzk().zzah() < 200900) {
                return 25;
            }
            zzib zzib0 = this.zzu;
            if(object0 instanceof Parcelable[]) {
                v = ((Parcelable[])object0).length;
                goto label_16;
            }
            else if(object0 instanceof ArrayList) {
                v = ((ArrayList)object0).size();
            label_16:
                if(v > 200) {
                    zzib0.zzaV().zzh().zzd("Parameter array is too long; discarded. Value kind, name, array length", "param", s2, v);
                    if(!(object0 instanceof Parcelable[])) {
                        if(object0 instanceof ArrayList && ((ArrayList)object0).size() > 200) {
                            bundle0.putParcelableArrayList(s2, new ArrayList(((ArrayList)object0).subList(0, 200)));
                        }
                    }
                    else if(((Parcelable[])object0).length > 200) {
                        bundle0.putParcelableArray(s2, ((Parcelable[])Arrays.copyOf(((Parcelable[])object0), 200)));
                    }
                    v1 = 17;
                }
                else {
                    v1 = 0;
                }
            }
            else {
                v1 = 0;
            }
        }
        else {
            v1 = 0;
        }
        if(!this.zzu("param", s2, (zzpo.zzZ(s1) || zzpo.zzZ(s2) ? this.zzu.zzc().zzf(null, false) : this.zzu.zzc().zze(null, false)), object0)) {
            if(z1) {
                if(object0 instanceof Bundle) {
                    this.zzz(s, s1, s2, ((Bundle)object0), list0, z);
                    return v1;
                }
                if(object0 instanceof Parcelable[]) {
                    for(int v2 = 0; v2 < ((Parcelable[])object0).length; ++v2) {
                        Parcelable parcelable0 = ((Parcelable[])object0)[v2];
                        if(!(parcelable0 instanceof Bundle)) {
                            this.zzu.zzaV().zzh().zzc("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable0.getClass(), s2);
                            return 4;
                        }
                        this.zzz(s, s1, s2, ((Bundle)parcelable0), list0, z);
                    }
                    return v1;
                }
                if(object0 instanceof ArrayList) {
                    int v3 = ((ArrayList)object0).size();
                    for(int v4 = 0; v4 < v3; ++v4) {
                        Object object1 = ((ArrayList)object0).get(v4);
                        if(!(object1 instanceof Bundle)) {
                            zzgr zzgr0 = this.zzu.zzaV().zzh();
                            Class class0 = object1 == null ? "null" : object1.getClass();
                            zzgr0.zzc("All ArrayList elements must be of type Bundle. Value type, name", class0, s2);
                            return 4;
                        }
                        this.zzz(s, s1, s2, ((Bundle)object1), list0, z);
                    }
                    return v1;
                }
            }
            return 4;
        }
        return v1;
    }

    public final Object zzE(String s, Object object0) {
        if("_ev".equals(s)) {
            return this.zzay(this.zzu.zzc().zzf(null, false), object0, true, true, null);
        }
        return zzpo.zzZ(s) ? this.zzay(this.zzu.zzc().zzf(null, false), object0, false, true, null) : this.zzay(this.zzu.zzc().zze(null, false), object0, false, true, null);
    }

    public final Bundle zzF(String s, String s1, Bundle bundle0, List list0, boolean z) {
        String s3;
        int v2;
        boolean z1 = zzpo.zzaA(s1, zzjl.zzd);
        if(bundle0 != null) {
            Bundle bundle1 = new Bundle(bundle0);
            zzib zzib0 = this.zzu;
            int v = zzib0.zzc().zzc();
            int v1 = 0;
            boolean z2 = false;
            for(Object object0: new TreeSet(bundle0.keySet())) {
                String s2 = (String)object0;
                if(list0 == null || !list0.contains(s2)) {
                    int v3 = z ? 0 : this.zzq(s2);
                    v2 = v3 == 0 ? this.zzs(s2) : v3;
                }
                else {
                    v2 = 0;
                }
                switch(v2) {
                    case 0: {
                        int v4 = this.zzD(s, s1, s2, bundle0.get(s2), bundle1, list0, z, z1);
                        if(v4 == 17) {
                            this.zzJ(bundle1, 17, s2, Boolean.FALSE);
                        }
                        else if(v4 != 0 && !"_ev".equals(s2)) {
                            this.zzJ(bundle1, v4, (v4 == 21 ? s1 : s2), bundle0.get(s2));
                            bundle1.remove(s2);
                            continue;
                        }
                        if(!zzpo.zzh(s2)) {
                            continue;
                        }
                        ++v1;
                        if(v1 <= v) {
                            continue;
                        }
                        if(!zzib0.zzc().zzp(null, zzfx.zzbf) || !z2) {
                            zzib0.zzaV().zzd().zzc("Event can\'t contain more than " + v + " params", zzib0.zzl().zza(s1), zzib0.zzl().zze(bundle0));
                        }
                        zzpo.zzax(bundle1, 5);
                        bundle1.remove(s2);
                        z2 = true;
                        continue;
                    }
                    case 3: {
                        s3 = s2;
                        break;
                    }
                    default: {
                        s3 = null;
                    }
                }
                this.zzJ(bundle1, v2, s2, s3);
                bundle1.remove(s2);
            }
            return bundle1;
        }
        return null;
    }

    public final void zzG(zzgu zzgu0, int v) {
        Bundle bundle0 = zzgu0.zzd;
        int v1 = 0;
        boolean z = false;
        for(Object object0: new TreeSet(bundle0.keySet())) {
            String s = (String)object0;
            if(zzpo.zzh(s)) {
                ++v1;
                if(v1 > v) {
                    zzib zzib0 = this.zzu;
                    if(!zzib0.zzc().zzp(null, zzfx.zzbf) || !z) {
                        zzib0.zzaV().zzd().zzc("Event can\'t contain more than " + v + " params", zzib0.zzl().zza(zzgu0.zza), zzib0.zzl().zze(bundle0));
                        zzpo.zzax(bundle0, 5);
                    }
                    bundle0.remove(s);
                    z = true;
                }
            }
        }
    }

    public final void zzH(Parcelable[] arr_parcelable, int v) {
        Preconditions.checkNotNull(arr_parcelable);
        for(int v1 = 0; v1 < arr_parcelable.length; ++v1) {
            Bundle bundle0 = (Bundle)arr_parcelable[v1];
            int v2 = 0;
            boolean z = false;
            for(Object object0: new TreeSet(bundle0.keySet())) {
                String s = (String)object0;
                if(zzpo.zzh(s) && !zzpo.zzaA(s, zzjm.zzd)) {
                    ++v2;
                    if(v2 > v) {
                        zzib zzib0 = this.zzu;
                        if(!zzib0.zzc().zzp(null, zzfx.zzbf) || !z) {
                            zzib0.zzaV().zzd().zzc("Param can\'t contain more than " + v + " item-scoped custom parameters", zzib0.zzl().zzb(s), zzib0.zzl().zze(bundle0));
                        }
                        zzpo.zzax(bundle0, 28);
                        bundle0.remove(s);
                        z = true;
                    }
                }
            }
        }
    }

    public final void zzI(Bundle bundle0, Bundle bundle1) {
        if(bundle1 != null) {
            for(Object object0: bundle1.keySet()) {
                String s = (String)object0;
                if(!bundle0.containsKey(s)) {
                    this.zzu.zzk().zzM(bundle0, s, bundle1.get(s));
                }
            }
        }
    }

    public final void zzJ(Bundle bundle0, int v, String s, Object object0) {
        if(zzpo.zzax(bundle0, v)) {
            bundle0.putString("_ev", this.zzC(s, 40, true));
            if(object0 != null) {
                Preconditions.checkNotNull(bundle0);
                if(object0 instanceof String || object0 instanceof CharSequence) {
                    bundle0.putLong("_el", ((long)object0.toString().length()));
                }
            }
        }
    }

    // 去混淆评级： 低(40)
    public final int zzK(String s, Object object0) {
        return ("_ldl".equals(s) ? this.zzu("user property referrer", s, this.zzaz(s), object0) : this.zzu("user property", s, this.zzaz(s), object0)) ? 0 : 7;
    }

    // 去混淆评级： 低(20)
    public final Object zzL(String s, Object object0) {
        return "_ldl".equals(s) ? this.zzay(this.zzaz(s), object0, true, false, null) : this.zzay(this.zzaz(s), object0, false, false, null);
    }

    public final void zzM(Bundle bundle0, String s, Object object0) {
        if(bundle0 != null) {
            if(object0 instanceof Long) {
                bundle0.putLong(s, ((long)(((Long)object0))));
                return;
            }
            if(object0 instanceof String) {
                bundle0.putString(s, String.valueOf(object0));
                return;
            }
            if(object0 instanceof Double) {
                bundle0.putDouble(s, ((double)(((Double)object0))));
                return;
            }
            if(object0 instanceof Bundle[]) {
                bundle0.putParcelableArray(s, ((Bundle[])object0));
                return;
            }
            if(s != null) {
                String s1 = object0 == null ? null : object0.getClass().getSimpleName();
                this.zzu.zzaV().zzh().zzc("Not putting event parameter. Invalid value type. name, type", this.zzu.zzl().zzb(s), s1);
            }
        }
    }

    public final void zzN(zzpn zzpn0, String s, int v, String s1, String s2, int v1) {
        Bundle bundle0 = new Bundle();
        zzpo.zzax(bundle0, v);
        if(!TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s2)) {
            bundle0.putString(s1, s2);
        }
        if(v == 2 || v == 6 || v == 7) {
            bundle0.putLong("_el", ((long)v1));
        }
        zzpn0.zza(s, "_err", bundle0);
    }

    public static MessageDigest zzO() {
        for(int v = 0; v < 2; ++v) {
            try {
                MessageDigest messageDigest0 = MessageDigest.getInstance("MD5");
                if(messageDigest0 != null) {
                    return messageDigest0;
                }
            }
            catch(NoSuchAlgorithmException unused_ex) {
            }
        }
        return null;
    }

    public static long zzP(byte[] arr_b) {
        Preconditions.checkNotNull(arr_b);
        int v = 0;
        Preconditions.checkState(arr_b.length > 0);
        int v1 = arr_b.length - 1;
        long v2 = 0L;
        while(v1 >= 0 && v1 >= arr_b.length - 8) {
            v2 += (((long)arr_b[v1]) & 0xFFL) << v;
            v += 8;
            --v1;
        }
        return v2;
    }

    public static boolean zzQ(Context context0, boolean z) {
        Preconditions.checkNotNull(context0);
        return zzpo.zzR(context0, "com.google.android.gms.measurement.AppMeasurementJobService");
    }

    public static boolean zzR(Context context0, String s) {
        try {
            PackageManager packageManager0 = context0.getPackageManager();
            if(packageManager0 == null) {
                return false;
            }
            ServiceInfo serviceInfo0 = packageManager0.getServiceInfo(new ComponentName(context0, s), 0);
            if(serviceInfo0 != null) {
                return serviceInfo0.enabled;
            }
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
        }
        return false;
    }

    public final boolean zzS() {
        this.zzg();
        return this.zzV() == 1L;
    }

    public final e zzT() {
        Object object0;
        c c0;
        if(this.zzg == null) {
            Context context0 = this.zzu.zzaY();
            q.g(context0, "context");
            int v = Build.VERSION.SDK_INT;
            int v1 = 0;
            Log.d("MeasurementManager", "AdServicesInfo.version=" + (v < 33 ? 0 : b.a.a()));
            d d0 = null;
            if((v < 33 ? 0 : b.a.a()) >= 5) {
                c0 = new MeasurementManagerApi33Ext5Impl(context0);
            }
            else {
                a a0 = a.a;
                if((v == 0x1F || v == 0x20 ? a0.a() : 0) >= 9) {
                    w w0 = new w(context0, 23);
                    try {
                        object0 = w0.invoke(context0);
                    }
                    catch(NoClassDefFoundError unused_ex) {
                        StringBuilder stringBuilder0 = new StringBuilder("Unable to find adservices code, check manifest for uses-library tag, versionS=");
                        if(Build.VERSION.SDK_INT == 0x1F || Build.VERSION.SDK_INT == 0x20) {
                            v1 = a0.a();
                        }
                        stringBuilder0.append(v1);
                        Log.d("MeasurementManager", stringBuilder0.toString());
                        object0 = null;
                    }
                    c0 = (c)object0;
                }
                else {
                    c0 = null;
                }
            }
            if(c0 != null) {
                d0 = new d(c0);
            }
            this.zzg = d0;
        }
        return this.zzg;
    }

    public final int zzU() {
        return Build.VERSION.SDK_INT < 30 || F.x() <= 3 ? 0 : P.q();
    }

    public final long zzV() {
        long v;
        this.zzg();
        if(!this.zzX(this.zzu.zzv().zzj())) {
            return 0L;
        }
        if(Build.VERSION.SDK_INT < 30) {
            v = 4L;
        }
        else if(F.x() < 4) {
            v = 8L;
        }
        else {
            v = this.zzU() >= ((int)(((Integer)zzfx.zzal.zzb(null)))) ? 0L : 16L;
        }
        if(!this.zzY("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")) {
            v |= 2L;
        }
        if(v == 0L && !this.zzW()) {
            v = 0x40L;
        }
        return v == 0L ? 1L : v;
    }

    @TargetApi(30)
    public final boolean zzW() {
        CancellationException cancellationException1;
        Integer integer0;
        if(this.zzh == null) {
            e e0 = this.zzT();
            boolean z = false;
            if(e0 == null) {
                return false;
            }
            B b0 = e0.a();
            try {
                integer0 = (Integer)b0.get(10000L, TimeUnit.MILLISECONDS);
            }
            catch(CancellationException | ExecutionException | InterruptedException | TimeoutException cancellationException0) {
                cancellationException1 = cancellationException0;
                integer0 = null;
                this.zzu.zzaV().zze().zzb("Measurement manager api exception", cancellationException1);
                this.zzh = Boolean.FALSE;
                this.zzu.zzaV().zzk().zzb("Measurement manager api status result", integer0);
                return this.zzh.booleanValue();
            }
            if(integer0 == null) {
                this.zzh = Boolean.valueOf(z);
                goto label_20;
            }
            else {
                try {
                    if(((int)integer0) == 1) {
                        z = true;
                    }
                    this.zzh = Boolean.valueOf(z);
                    goto label_20;
                }
                catch(CancellationException | ExecutionException | InterruptedException | TimeoutException cancellationException1) {
                }
            }
            this.zzu.zzaV().zze().zzb("Measurement manager api exception", cancellationException1);
            this.zzh = Boolean.FALSE;
        label_20:
            this.zzu.zzaV().zzk().zzb("Measurement manager api status result", integer0);
        }
        return this.zzh.booleanValue();
    }

    // 去混淆评级： 中等(100)
    public final boolean zzX(String s) {
        return Arrays.asList(new String[]{"com.labpixies.flood"}).contains(s);
    }

    public final boolean zzY(String s) {
        this.zzg();
        zzib zzib0 = this.zzu;
        if(Wrappers.packageManager(zzib0.zzaY()).checkCallingOrSelfPermission(s) == 0) {
            return true;
        }
        zzib0.zzaV().zzj().zzb("Permission not granted", s);
        return false;
    }

    // 去混淆评级： 低(20)
    public static boolean zzZ(String s) {
        return !TextUtils.isEmpty(s) && s.startsWith("_");
    }

    @Override  // com.google.android.gms.measurement.internal.zzje
    public final boolean zza() {
        return true;
    }

    private static boolean zzaA(String s, String[] arr_s) {
        Preconditions.checkNotNull(arr_s);
        for(int v = 0; v < arr_s.length; ++v) {
            if(Objects.equals(s, arr_s[v])) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzaa(String s, String s1) {
        if(!TextUtils.isEmpty(s1)) {
            return true;
        }
        return TextUtils.isEmpty(s) ? false : this.zzu.zzc().zzA().equals(s);
    }

    public final Bundle zzab(Bundle bundle0, String s) {
        Bundle bundle1 = new Bundle();
        if(bundle0 != null) {
            for(Object object0: bundle0.keySet()) {
                String s1 = (String)object0;
                Object object1 = this.zzE(s1, bundle0.get(s1));
                if(object1 == null) {
                    this.zzu.zzaV().zzh().zzb("Param value can\'t be null", this.zzu.zzl().zzb(s1));
                }
                else {
                    this.zzM(bundle1, s1, object1);
                }
            }
        }
        return bundle1;
    }

    public final zzbg zzac(String s, String s1, Bundle bundle0, String s2, long v, boolean z, boolean z1) {
        if(TextUtils.isEmpty(s1)) {
            return null;
        }
        if(this.zzn(s1) == 0) {
            Bundle bundle1 = bundle0 == null ? new Bundle() : new Bundle(bundle0);
            bundle1.putString("_o", s2);
            Bundle bundle2 = this.zzF(s, s1, bundle1, CollectionUtils.listOf("_o"), true);
            if(z) {
                bundle2 = this.zzab(bundle2, s);
            }
            Preconditions.checkNotNull(bundle2);
            return new zzbg(s1, new zzbe(bundle2), s2, v);
        }
        this.zzu.zzaV().zzb().zzb("Invalid conditional property event name", this.zzu.zzl().zzc(s1));
        throw new IllegalArgumentException();
    }

    public final boolean zzad(Context context0, String s) {
        X500Principal x500Principal0 = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo0 = Wrappers.packageManager(context0).getPackageInfo(s, 0x40);
            if(packageInfo0 != null) {
                Signature[] arr_signature = packageInfo0.signatures;
                if(arr_signature != null && arr_signature.length > 0) {
                    Signature signature0 = arr_signature[0];
                    return ((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signature0.toByteArray()))).getSubjectX500Principal().equals(x500Principal0);
                }
            }
        }
        catch(CertificateException certificateException0) {
            this.zzu.zzaV().zzb().zzb("Error obtaining certificate", certificateException0);
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            this.zzu.zzaV().zzb().zzb("Package name not found", packageManager$NameNotFoundException0);
        }
        return true;
    }

    public final byte[] zzae(Parcelable parcelable0) {
        if(parcelable0 == null) {
            return null;
        }
        Parcel parcel0 = Parcel.obtain();
        try {
            parcelable0.writeToParcel(parcel0, 0);
            return parcel0.marshall();
        }
        finally {
            parcel0.recycle();
        }
    }

    // 去混淆评级： 低(30)
    public static boolean zzaf(String s) {
        return !"_err".equals(s);
    }

    public final boolean zzag(int v, boolean z) {
        Boolean boolean0 = this.zzu.zzt().zzJ();
        return this.zzah() >= v / 1000 || boolean0 != null && !boolean0.booleanValue();
    }

    @EnsuresNonNull({"this.apkVersion"})
    public final int zzah() {
        if(this.zzi == null) {
            this.zzi = (int)(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzu.zzaY()) / 1000);
        }
        return (int)this.zzi;
    }

    public final int zzai(int v) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(this.zzu.zzaY(), 12451000);
    }

    public final long zzaj(long v, long v1) {
        return (v1 * 60000L + v) / 86400000L;
    }

    public final void zzak(Bundle bundle0, long v) {
        long v1 = bundle0.getLong("_et");
        if(v1 == 0L) {
            v1 = 0L;
        }
        else {
            this.zzu.zzaV().zze().zzb("Params already contained engagement", v1);
        }
        bundle0.putLong("_et", v + v1);
    }

    public final void zzal(zzcu zzcu0, String s) {
        Bundle bundle0 = Y.b("r", s);
        try {
            zzcu0.zzb(bundle0);
        }
        catch(RemoteException remoteException0) {
            this.zzu.zzaV().zze().zzb("Error returning string value to wrapper", remoteException0);
        }
    }

    public final void zzam(zzcu zzcu0, long v) {
        Bundle bundle0 = new Bundle();
        bundle0.putLong("r", v);
        try {
            zzcu0.zzb(bundle0);
        }
        catch(RemoteException remoteException0) {
            this.zzu.zzaV().zze().zzb("Error returning long value to wrapper", remoteException0);
        }
    }

    public final void zzan(zzcu zzcu0, int v) {
        Bundle bundle0 = new Bundle();
        bundle0.putInt("r", v);
        try {
            zzcu0.zzb(bundle0);
        }
        catch(RemoteException remoteException0) {
            this.zzu.zzaV().zze().zzb("Error returning int value to wrapper", remoteException0);
        }
    }

    public final void zzao(zzcu zzcu0, byte[] arr_b) {
        Bundle bundle0 = new Bundle();
        bundle0.putByteArray("r", arr_b);
        try {
            zzcu0.zzb(bundle0);
        }
        catch(RemoteException remoteException0) {
            this.zzu.zzaV().zze().zzb("Error returning byte array to wrapper", remoteException0);
        }
    }

    public final void zzap(zzcu zzcu0, boolean z) {
        Bundle bundle0 = new Bundle();
        bundle0.putBoolean("r", z);
        try {
            zzcu0.zzb(bundle0);
        }
        catch(RemoteException remoteException0) {
            this.zzu.zzaV().zze().zzb("Error returning boolean value to wrapper", remoteException0);
        }
    }

    public final void zzaq(zzcu zzcu0, Bundle bundle0) {
        try {
            zzcu0.zzb(bundle0);
        }
        catch(RemoteException remoteException0) {
            this.zzu.zzaV().zze().zzb("Error returning bundle value to wrapper", remoteException0);
        }
    }

    public final void zzar(zzcu zzcu0, ArrayList arrayList0) {
        Bundle bundle0 = new Bundle();
        bundle0.putParcelableArrayList("r", arrayList0);
        try {
            zzcu0.zzb(bundle0);
        }
        catch(RemoteException remoteException0) {
            this.zzu.zzaV().zze().zzb("Error returning bundle list to wrapper", remoteException0);
        }
    }

    public static ArrayList zzas(List list0) {
        if(list0 == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList0 = new ArrayList(list0.size());
        for(Object object0: list0) {
            Bundle bundle0 = new Bundle();
            bundle0.putString("app_id", ((zzah)object0).zza);
            bundle0.putString("origin", ((zzah)object0).zzb);
            bundle0.putLong("creation_timestamp", ((zzah)object0).zzd);
            bundle0.putString("name", ((zzah)object0).zzc.zzb);
            zzjg.zza(bundle0, Preconditions.checkNotNull(((zzah)object0).zzc.zza()));
            bundle0.putBoolean("active", ((zzah)object0).zze);
            String s = ((zzah)object0).zzf;
            if(s != null) {
                bundle0.putString("trigger_event_name", s);
            }
            zzbg zzbg0 = ((zzah)object0).zzg;
            if(zzbg0 != null) {
                bundle0.putString("timed_out_event_name", zzbg0.zza);
                zzbe zzbe0 = zzbg0.zzb;
                if(zzbe0 != null) {
                    bundle0.putBundle("timed_out_event_params", zzbe0.zzf());
                }
            }
            bundle0.putLong("trigger_timeout", ((zzah)object0).zzh);
            zzbg zzbg1 = ((zzah)object0).zzi;
            if(zzbg1 != null) {
                bundle0.putString("triggered_event_name", zzbg1.zza);
                zzbe zzbe1 = zzbg1.zzb;
                if(zzbe1 != null) {
                    bundle0.putBundle("triggered_event_params", zzbe1.zzf());
                }
            }
            bundle0.putLong("triggered_timestamp", ((zzah)object0).zzc.zzc);
            bundle0.putLong("time_to_live", ((zzah)object0).zzj);
            zzbg zzbg2 = ((zzah)object0).zzk;
            if(zzbg2 != null) {
                bundle0.putString("expired_event_name", zzbg2.zza);
                zzbe zzbe2 = zzbg2.zzb;
                if(zzbe2 != null) {
                    bundle0.putBundle("expired_event_params", zzbe2.zzf());
                }
            }
            arrayList0.add(bundle0);
        }
        return arrayList0;
    }

    public final URL zzat(long v, String s, String s1, long v1, String s2) {
        try {
            Preconditions.checkNotEmpty(s1);
            Preconditions.checkNotEmpty(s);
            String s3 = "https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=" + ("v130000." + this.zzah()) + "&rdid=" + s1 + "&bundleid=" + s + "&retry=" + v1;
            if(s.equals(this.zzu.zzc().zzB())) {
                s3 = s3 + "&ddl_test=1";
            }
            if(!s2.isEmpty()) {
                if(s2.charAt(0) != 38) {
                    s3 = s3 + "&";
                }
                s3 = s3 + s2;
            }
            return new URL(s3);
        }
        catch(MalformedURLException | IllegalArgumentException malformedURLException0) {
        }
        this.zzu.zzaV().zzb().zzb("Failed to create BOW URL for Deferred Deep Link. exception", malformedURLException0.getMessage());
        return null;
    }

    public static boolean zzau(Context context0) {
        Preconditions.checkNotNull(context0);
        try {
            PackageManager packageManager0 = context0.getPackageManager();
            if(packageManager0 == null) {
                return false;
            }
            ActivityInfo activityInfo0 = packageManager0.getReceiverInfo(new ComponentName(context0, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0);
            if(activityInfo0 != null) {
                return activityInfo0.enabled;
            }
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
        }
        return false;
    }

    public static void zzav(zzlt zzlt0, Bundle bundle0, boolean z) {
        if(bundle0 != null && zzlt0 != null) {
            if(bundle0.containsKey("_sc") && !z) {
                z = false;
                goto label_16;
            }
            String s = zzlt0.zza;
            if(s == null) {
                bundle0.remove("_sn");
            }
            else {
                bundle0.putString("_sn", s);
            }
            String s1 = zzlt0.zzb;
            if(s1 == null) {
                bundle0.remove("_sc");
            }
            else {
                bundle0.putString("_sc", s1);
            }
            bundle0.putLong("_si", zzlt0.zzc);
            return;
        }
    label_16:
        if(bundle0 != null && zzlt0 == null && z) {
            bundle0.remove("_sn");
            bundle0.remove("_sc");
            bundle0.remove("_si");
        }
    }

    public final String zzaw() {
        byte[] arr_b = new byte[16];
        this.zzf().nextBytes(arr_b);
        return String.format(Locale.US, "%032x", new BigInteger(1, arr_b));
    }

    public static final boolean zzax(Bundle bundle0, int v) {
        if(bundle0 != null && bundle0.getLong("_err") == 0L) {
            bundle0.putLong("_err", ((long)v));
            return true;
        }
        return false;
    }

    private final Object zzay(int v, Object object0, boolean z, boolean z1, String s) {
        if(object0 == null) {
            return null;
        }
        if(object0 instanceof Long || object0 instanceof Double) {
            return object0;
        }
        if(object0 instanceof Integer) {
            return (long)(((int)(((Integer)object0))));
        }
        if(object0 instanceof Byte) {
            return (long)(((byte)(((Byte)object0))));
        }
        if(object0 instanceof Short) {
            return (long)(((short)(((Short)object0))));
        }
        if(object0 instanceof Boolean) {
            return ((Boolean)object0).booleanValue() ? 1L : 0L;
        }
        if(object0 instanceof Float) {
            return ((Float)object0).doubleValue();
        }
        if(!(object0 instanceof String) && !(object0 instanceof Character) && !(object0 instanceof CharSequence)) {
            if(z1 && (object0 instanceof Bundle[] || object0 instanceof Parcelable[])) {
                ArrayList arrayList0 = new ArrayList();
                for(int v1 = 0; v1 < ((Parcelable[])object0).length; ++v1) {
                    Parcelable parcelable0 = ((Parcelable[])object0)[v1];
                    if(parcelable0 instanceof Bundle) {
                        Bundle bundle0 = this.zzab(((Bundle)parcelable0), null);
                        if(!bundle0.isEmpty()) {
                            arrayList0.add(bundle0);
                        }
                    }
                }
                return arrayList0.toArray(new Bundle[arrayList0.size()]);
            }
            return null;
        }
        return this.zzC(object0.toString(), v, z);
    }

    private final int zzaz(String s) {
        if("_ldl".equals(s)) {
            return 0x800;
        }
        if("_id".equals(s)) {
            return 0x100;
        }
        return "_lgclid".equals(s) ? 100 : 36;
    }

    @Override  // com.google.android.gms.measurement.internal.zzje
    public final void zzba() {
        this.zzg();
        SecureRandom secureRandom0 = new SecureRandom();
        long v = secureRandom0.nextLong();
        if(v == 0L) {
            v = secureRandom0.nextLong();
            if(v == 0L) {
                Z.A(this.zzu, "Utils falling back to Random for random id");
            }
        }
        this.zze.set(v);
    }

    public final long zzd() {
        int v2;
        long v1;
        AtomicLong atomicLong0 = this.zze;
        if(atomicLong0.get() == 0L) {
            synchronized(atomicLong0) {
                v1 = new Random(System.nanoTime() ^ this.zzu.zzaZ().currentTimeMillis()).nextLong();
                v2 = this.zzf + 1;
                this.zzf = v2;
            }
            return v1 + ((long)v2);
        }
        synchronized(this.zze) {
            this.zze.compareAndSet(-1L, 1L);
        }
        return this.zze.getAndIncrement();
    }

    @EnsuresNonNull({"this.secureRandom"})
    public final SecureRandom zzf() {
        this.zzg();
        if(this.zzd == null) {
            this.zzd = new SecureRandom();
        }
        return this.zzd;
    }

    public static boolean zzh(String s) {
        Preconditions.checkNotEmpty(s);
        return s.charAt(0) != 0x5F || s.equals("_ep");
    }

    public final Bundle zzi(Uri uri0) {
        String s8;
        String s7;
        String s6;
        String s5;
        String s4;
        String s3;
        String s2;
        String s1;
        String s;
        if(uri0 != null) {
            try {
                if(uri0.isHierarchical()) {
                    s = uri0.getQueryParameter("utm_campaign");
                    s1 = uri0.getQueryParameter("utm_source");
                    s2 = uri0.getQueryParameter("utm_medium");
                    s3 = uri0.getQueryParameter("gclid");
                    s4 = uri0.getQueryParameter("gbraid");
                    s5 = uri0.getQueryParameter("utm_id");
                    s6 = uri0.getQueryParameter("dclid");
                    s7 = uri0.getQueryParameter("srsltid");
                    s8 = uri0.getQueryParameter("sfmc_id");
                }
                else {
                    s = null;
                    s1 = null;
                    s2 = null;
                    s3 = null;
                    s4 = null;
                    s5 = null;
                    s6 = null;
                    s7 = null;
                    s8 = null;
                }
            }
            catch(UnsupportedOperationException unsupportedOperationException0) {
                this.zzu.zzaV().zze().zzb("Install referrer url isn\'t a hierarchical URI", unsupportedOperationException0);
                return null;
            }
            if(TextUtils.isEmpty(s) && TextUtils.isEmpty(s1) && TextUtils.isEmpty(s2) && TextUtils.isEmpty(s3) && TextUtils.isEmpty(s4) && TextUtils.isEmpty(s5) && TextUtils.isEmpty(s6) && TextUtils.isEmpty(s7) && TextUtils.isEmpty(s8)) {
                return null;
            }
            Bundle bundle0 = new Bundle();
            if(!TextUtils.isEmpty(s)) {
                bundle0.putString("campaign", s);
            }
            if(!TextUtils.isEmpty(s1)) {
                bundle0.putString("source", s1);
            }
            if(!TextUtils.isEmpty(s2)) {
                bundle0.putString("medium", s2);
            }
            if(!TextUtils.isEmpty(s3)) {
                bundle0.putString("gclid", s3);
            }
            if(!TextUtils.isEmpty(s4)) {
                bundle0.putString("gbraid", s4);
            }
            String s9 = uri0.getQueryParameter("gad_source");
            if(!TextUtils.isEmpty(s9)) {
                bundle0.putString("gad_source", s9);
            }
            String s10 = uri0.getQueryParameter("utm_term");
            if(!TextUtils.isEmpty(s10)) {
                bundle0.putString("term", s10);
            }
            String s11 = uri0.getQueryParameter("utm_content");
            if(!TextUtils.isEmpty(s11)) {
                bundle0.putString("content", s11);
            }
            String s12 = uri0.getQueryParameter("aclid");
            if(!TextUtils.isEmpty(s12)) {
                bundle0.putString("aclid", s12);
            }
            String s13 = uri0.getQueryParameter("cp1");
            if(!TextUtils.isEmpty(s13)) {
                bundle0.putString("cp1", s13);
            }
            String s14 = uri0.getQueryParameter("anid");
            if(!TextUtils.isEmpty(s14)) {
                bundle0.putString("anid", s14);
            }
            if(!TextUtils.isEmpty(s5)) {
                bundle0.putString("campaign_id", s5);
            }
            if(!TextUtils.isEmpty(s6)) {
                bundle0.putString("dclid", s6);
            }
            String s15 = uri0.getQueryParameter("utm_source_platform");
            if(!TextUtils.isEmpty(s15)) {
                bundle0.putString("source_platform", s15);
            }
            String s16 = uri0.getQueryParameter("utm_creative_format");
            if(!TextUtils.isEmpty(s16)) {
                bundle0.putString("creative_format", s16);
            }
            String s17 = uri0.getQueryParameter("utm_marketing_tactic");
            if(!TextUtils.isEmpty(s17)) {
                bundle0.putString("marketing_tactic", s17);
            }
            if(!TextUtils.isEmpty(s7)) {
                bundle0.putString("srsltid", s7);
            }
            if(!TextUtils.isEmpty(s8)) {
                bundle0.putString("sfmc_id", s8);
            }
            for(Object object0: uri0.getQueryParameterNames()) {
                String s18 = (String)object0;
                if(s18.startsWith("gad_")) {
                    String s19 = uri0.getQueryParameter(s18);
                    if(!TextUtils.isEmpty(s19)) {
                        bundle0.putString(s18, s19);
                    }
                }
            }
            return bundle0;
        }
        return null;
    }

    public final boolean zzj(String s, String s1) {
        if(s1 == null) {
            this.zzu.zzaV().zzd().zzb("Name is required and can\'t be null. Type", s);
            return false;
        }
        if(s1.length() == 0) {
            this.zzu.zzaV().zzd().zzb("Name is required and can\'t be empty. Type", s);
            return false;
        }
        int v = s1.codePointAt(0);
        if(!Character.isLetter(v)) {
            this.zzu.zzaV().zzd().zzc("Name must start with a letter. Type, name", s, s1);
            return false;
        }
        int v1 = s1.length();
        for(int v2 = Character.charCount(v); v2 < v1; v2 += Character.charCount(v3)) {
            int v3 = s1.codePointAt(v2);
            if(v3 != 0x5F && !Character.isLetterOrDigit(v3)) {
                this.zzu.zzaV().zzd().zzc("Name must consist of letters, digits or _ (underscores). Type, name", s, s1);
                return false;
            }
        }
        return true;
    }

    public final boolean zzk(String s, String s1) {
        if(s1 == null) {
            this.zzu.zzaV().zzd().zzb("Name is required and can\'t be null. Type", s);
            return false;
        }
        if(s1.length() == 0) {
            this.zzu.zzaV().zzd().zzb("Name is required and can\'t be empty. Type", s);
            return false;
        }
        int v = s1.codePointAt(0);
        if(!Character.isLetter(v)) {
            if(v == 0x5F) {
                v = 0x5F;
                goto label_13;
            }
            this.zzu.zzaV().zzd().zzc("Name must start with a letter or _ (underscore). Type, name", s, s1);
            return false;
        }
    label_13:
        int v1 = s1.length();
        for(int v2 = Character.charCount(v); v2 < v1; v2 += Character.charCount(v3)) {
            int v3 = s1.codePointAt(v2);
            if(v3 != 0x5F && !Character.isLetterOrDigit(v3)) {
                this.zzu.zzaV().zzd().zzc("Name must consist of letters, digits or _ (underscores). Type, name", s, s1);
                return false;
            }
        }
        return true;
    }

    public final boolean zzl(String s, String[] arr_s, String[] arr_s1, String s1) {
        if(s1 == null) {
            this.zzu.zzaV().zzd().zzb("Name is required and can\'t be null. Type", s);
            return false;
        }
        Preconditions.checkNotNull(s1);
        String[] arr_s2 = zzpo.zzb;
        for(int v = 0; v < 3; ++v) {
            if(s1.startsWith(arr_s2[v])) {
                this.zzu.zzaV().zzd().zzc("Name starts with reserved prefix. Type, name", s, s1);
                return false;
            }
        }
        if(arr_s != null && zzpo.zzaA(s1, arr_s) && (arr_s1 == null || !zzpo.zzaA(s1, arr_s1))) {
            this.zzu.zzaV().zzd().zzc("Name is reserved. Type, name", s, s1);
            return false;
        }
        return true;
    }

    public final boolean zzm(String s, int v, String s1) {
        if(s1 == null) {
            this.zzu.zzaV().zzd().zzb("Name is required and can\'t be null. Type", s);
            return false;
        }
        if(s1.codePointCount(0, s1.length()) > v) {
            this.zzu.zzaV().zzd().zzd("Name is too long. Type, maximum supported length, name", s, v, s1);
            return false;
        }
        return true;
    }

    public final int zzn(String s) {
        if(!this.zzk("event", s)) {
            return 2;
        }
        if(!this.zzl("event", zzjl.zza, zzjl.zzb, s)) {
            return 13;
        }
        return this.zzm("event", 40, s) ? 0 : 2;
    }

    public final int zzp(String s) {
        if(!this.zzk("user property", s)) {
            return 6;
        }
        if(!this.zzl("user property", zzjn.zza, null, s)) {
            return 15;
        }
        return this.zzm("user property", 24, s) ? 0 : 6;
    }

    public final int zzq(String s) {
        if(!this.zzj("event param", s)) {
            return 3;
        }
        if(!this.zzl("event param", null, null, s)) {
            return 14;
        }
        return this.zzm("event param", 40, s) ? 0 : 3;
    }

    public final int zzs(String s) {
        if(!this.zzk("event param", s)) {
            return 3;
        }
        if(!this.zzl("event param", null, null, s)) {
            return 14;
        }
        return this.zzm("event param", 40, s) ? 0 : 3;
    }

    // 去混淆评级： 低(30)
    public final boolean zzt(Object object0) {
        return object0 instanceof Parcelable[] || object0 instanceof ArrayList || object0 instanceof Bundle;
    }

    public final boolean zzu(String s, String s1, int v, Object object0) {
        if(object0 == null) {
            return true;
        }
        if(!(object0 instanceof Long) && !(object0 instanceof Float) && !(object0 instanceof Integer) && !(object0 instanceof Byte) && !(object0 instanceof Short) && !(object0 instanceof Boolean) && !(object0 instanceof Double)) {
            if(!(object0 instanceof String) && !(object0 instanceof Character) && !(object0 instanceof CharSequence)) {
                return false;
            }
            String s2 = object0.toString();
            if(s2.codePointCount(0, s2.length()) > v) {
                this.zzu.zzaV().zzh().zzd("Value is too long; discarded. Value kind, name, value length", s, s1, s2.length());
                return false;
            }
        }
        return true;
    }

    public final void zzz(String s, String s1, String s2, Bundle bundle0, List list0, boolean z) {
        int v4;
        int v2;
        if(bundle0 != null) {
            zzib zzib0 = this.zzu;
            int v = zzib0.zzc().zzu.zzk().zzag(231100000, true) ? 35 : 0;
            int v1 = 0;
            boolean z1 = false;
            for(Object object0: new TreeSet(bundle0.keySet())) {
                String s3 = (String)object0;
                if(list0 == null || !list0.contains(s3)) {
                    int v3 = z ? 0 : this.zzq(s3);
                    v2 = v3 == 0 ? this.zzs(s3) : v3;
                }
                else {
                    v2 = 0;
                }
                String s4 = null;
                switch(v2) {
                    case 0: {
                        if(this.zzt(bundle0.get(s3))) {
                            zzib0.zzaV().zzh().zzd("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", s1, s2, s3);
                            v4 = 22;
                        }
                        else {
                            v4 = this.zzD(s, s1, s3, bundle0.get(s3), bundle0, list0, z, false);
                        }
                        if(v4 == 0 || "_ev".equals(s3)) {
                            if(!zzpo.zzh(s3) || zzpo.zzaA(s3, zzjm.zzd)) {
                                continue;
                            }
                            ++v1;
                            if(this.zzag(231100000, true)) {
                                if(v1 <= v) {
                                    continue;
                                }
                                if(!zzib0.zzc().zzp(null, zzfx.zzbf) || !z1) {
                                    zzib0.zzaV().zzd().zzc("Item can\'t contain more than " + v + " item-scoped custom params", zzib0.zzl().zza(s1), zzib0.zzl().zze(bundle0));
                                }
                                zzpo.zzax(bundle0, 28);
                                bundle0.remove(s3);
                                z1 = true;
                            }
                            else {
                                zzib0.zzaV().zzd().zzc("Item array not supported on client\'s version of Google Play Services (Android Only)", zzib0.zzl().zza(s1), zzib0.zzl().zze(bundle0));
                                zzpo.zzax(bundle0, 23);
                                bundle0.remove(s3);
                            }
                        }
                        else {
                            this.zzJ(bundle0, v4, s3, bundle0.get(s3));
                            bundle0.remove(s3);
                        }
                        continue;
                    }
                    case 3: {
                        s4 = s3;
                    }
                }
                this.zzJ(bundle0, v2, s3, s4);
                bundle0.remove(s3);
            }
        }
    }
}

