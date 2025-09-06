package com.google.android.gms.cast;

import A7.d;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.zzaa;
import com.google.android.gms.cast.internal.zzp;
import com.google.android.gms.cast.internal.zzz;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Class(creator = "CastDeviceCreator")
@Reserved({1})
public class CastDevice extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final int CAPABILITY_AUDIO_IN = 8;
    public static final int CAPABILITY_AUDIO_OUT = 4;
    public static final int CAPABILITY_MULTIZONE_GROUP = 0x20;
    public static final int CAPABILITY_VIDEO_IN = 2;
    public static final int CAPABILITY_VIDEO_OUT = 1;
    public static final Parcelable.Creator CREATOR;
    @Field(id = 3)
    final String zza;
    @Field(getter = "isSelfDevice", id = 20)
    final Boolean zzb;
    @Field(getter = "getDeviceIdRaw", id = 2)
    private final String zzc;
    private InetAddress zzd;
    @Field(getter = "getFriendlyName", id = 4)
    private final String zze;
    @Field(getter = "getModelName", id = 5)
    private final String zzf;
    @Field(getter = "getDeviceVersion", id = 6)
    private final String zzg;
    @Field(getter = "getServicePort", id = 7)
    private final int zzh;
    @Field(getter = "getIcons", id = 8)
    private final List zzi;
    private final zzp zzj;
    @Field(defaultValue = "-1", getter = "getStatus", id = 10)
    private final int zzk;
    @Field(getter = "getServiceInstanceName", id = 11)
    private final String zzl;
    @Field(getter = "getReceiverMetricsId", id = 12)
    private final String zzm;
    @Field(getter = "getRcnEnabledStatus", id = 13)
    private final int zzn;
    @Field(getter = "getHotspotBssid", id = 14)
    private final String zzo;
    @Field(getter = "getIpLowestTwoBytes", id = 15)
    private final byte[] zzp;
    @Field(getter = "getCloudDeviceId", id = 16)
    private final String zzq;
    @Field(getter = "isCloudOnlyDevice", id = 17)
    private final boolean zzr;
    @Field(getter = "getCastEurekaInfo", id = 18)
    private final zzaa zzs;
    @Field(getter = "getWakeupServicePort", id = 19)
    private final Integer zzt;

    static {
        CastDevice.CREATOR = new zzs();
    }

    @Constructor
    public CastDevice(@Param(id = 2) String s, @Param(id = 3) String s1, @Param(id = 4) String s2, @Param(id = 5) String s3, @Param(id = 6) String s4, @Param(id = 7) int v, @Param(id = 8) List list0, @Param(id = 9) int v1, @Param(id = 10) int v2, @Param(id = 11) String s5, @Param(id = 12) String s6, @Param(id = 13) int v3, @Param(id = 14) String s7, @Param(id = 15) byte[] arr_b, @Param(id = 16) String s8, @Param(id = 17) boolean z, @Param(id = 18) zzaa zzaa0, @Param(id = 19) Integer integer0, @Param(id = 20) Boolean boolean0) {
        this.zzc = CastDevice.zzf(s);
        String s9 = CastDevice.zzf(s1);
        this.zza = s9;
        if(!TextUtils.isEmpty(s9)) {
            try {
                this.zzd = InetAddress.getByName(s9);
            }
            catch(UnknownHostException unknownHostException0) {
                Log.i("CastDevice", "Unable to convert host address (" + this.zza + ") to ipaddress: " + unknownHostException0.getMessage());
            }
        }
        this.zze = CastDevice.zzf(s2);
        this.zzf = CastDevice.zzf(s3);
        this.zzg = CastDevice.zzf(s4);
        this.zzh = v;
        if(list0 == null) {
            list0 = new ArrayList();
        }
        this.zzi = list0;
        this.zzk = v2;
        this.zzl = CastDevice.zzf(s5);
        this.zzm = s6;
        this.zzn = v3;
        this.zzo = s7;
        this.zzp = arr_b;
        this.zzq = s8;
        this.zzr = z;
        this.zzs = zzaa0;
        this.zzt = integer0;
        this.zzb = boolean0;
        this.zzj = new zzp(v1, zzaa0);
    }

    // 去混淆评级： 低(31)
    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof CastDevice)) {
            return false;
        }
        CastDevice castDevice0 = (CastDevice)object0;
        return this.zzc == null ? castDevice0.zzc == null : CastUtils.zze(this.zzc, castDevice0.zzc) && CastUtils.zze(this.zzd, castDevice0.zzd) && CastUtils.zze(this.zzf, castDevice0.zzf) && CastUtils.zze(this.zze, castDevice0.zze) && (CastUtils.zze(this.zzg, castDevice0.zzg) && (this.zzh == castDevice0.zzh && CastUtils.zze(this.zzi, castDevice0.zzi) && this.zzj.zza() == castDevice0.zzj.zza() && this.zzk == castDevice0.zzk && CastUtils.zze(this.zzl, castDevice0.zzl) && CastUtils.zze(this.zzn, castDevice0.zzn) && CastUtils.zze(this.zzo, castDevice0.zzo) && CastUtils.zze(this.zzm, castDevice0.zzm) && CastUtils.zze(this.zzg, castDevice0.getDeviceVersion()) && this.zzh == castDevice0.getServicePort()) && ((this.zzp == null && castDevice0.zzp == null || Arrays.equals(this.zzp, castDevice0.zzp)) && CastUtils.zze(this.zzq, castDevice0.zzq) && this.zzr == castDevice0.zzr && CastUtils.zze(this.zzc(), castDevice0.zzc()) && CastUtils.zze(Boolean.valueOf(this.zze()), Boolean.valueOf(castDevice0.zze()))));
    }

    // 去混淆评级： 低(20)
    public String getDeviceId() {
        return this.zzc.startsWith("__cast_nearby__") ? this.zzc.substring(16) : this.zzc;
    }

    public String getDeviceVersion() {
        return this.zzg;
    }

    public String getFriendlyName() {
        return this.zze;
    }

    public static CastDevice getFromBundle(Bundle bundle0) {
        if(bundle0 != null) {
            ClassLoader classLoader0 = CastDevice.class.getClassLoader();
            if(classLoader0 != null) {
                bundle0.setClassLoader(classLoader0);
                return (CastDevice)bundle0.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
            }
        }
        return null;
    }

    public WebImage getIcon(int v, int v1) {
        List list0 = this.zzi;
        WebImage webImage0 = null;
        if(list0.isEmpty()) {
            return null;
        }
        if(v > 0 && v1 > 0) {
            WebImage webImage1 = null;
            for(Object object0: list0) {
                WebImage webImage2 = (WebImage)object0;
                int v2 = webImage2.getWidth();
                int v3 = webImage2.getHeight();
                if(v2 >= v && v3 >= v1) {
                    if(webImage0 != null && (webImage0.getWidth() <= v2 || webImage0.getHeight() <= v3)) {
                        continue;
                    }
                    webImage0 = webImage2;
                }
                else if(v2 < v && v3 < v1 && (webImage1 == null || webImage1.getWidth() < v2 && webImage1.getHeight() < v3)) {
                    webImage1 = webImage2;
                }
            }
            if(webImage0 != null) {
                return webImage0;
            }
            return webImage1 == null ? ((WebImage)list0.get(0)) : webImage1;
        }
        return (WebImage)list0.get(0);
    }

    public List getIcons() {
        return Collections.unmodifiableList(this.zzi);
    }

    public InetAddress getInetAddress() {
        return this.zzd;
    }

    // 去混淆评级： 低(20)
    @Deprecated
    public Inet4Address getIpAddress() {
        return this.hasIPv4Address() ? ((Inet4Address)this.zzd) : null;
    }

    public String getModelName() {
        return this.zzf;
    }

    public int getServicePort() {
        return this.zzh;
    }

    public boolean hasCapabilities(int[] arr_v) {
        if(arr_v == null) {
            return false;
        }
        for(int v = 0; v < arr_v.length; ++v) {
            if(!this.zzj.zzb(arr_v[v])) {
                return false;
            }
        }
        return true;
    }

    public boolean hasCapability(int v) {
        return this.zzj.zzb(v);
    }

    public boolean hasIPv4Address() {
        return this.getInetAddress() instanceof Inet4Address;
    }

    public boolean hasIPv6Address() {
        return this.getInetAddress() instanceof Inet6Address;
    }

    public boolean hasIcons() {
        return !this.zzi.isEmpty();
    }

    @Override
    public int hashCode() {
        return this.zzc == null ? 0 : this.zzc.hashCode();
    }

    // 去混淆评级： 低(20)
    public boolean isOnLocalNetwork() {
        return !this.zzc.startsWith("__cast_nearby__") && !this.zzr;
    }

    public boolean isSameDevice(CastDevice castDevice0) {
        if(castDevice0 != null) {
            if(!TextUtils.isEmpty(this.getDeviceId()) && !this.getDeviceId().startsWith("__cast_ble__") && !TextUtils.isEmpty(castDevice0.getDeviceId()) && !castDevice0.getDeviceId().startsWith("__cast_ble__")) {
                return CastUtils.zze(this.getDeviceId(), castDevice0.getDeviceId());
            }
            String s = this.zzo;
            if(!TextUtils.isEmpty(s)) {
                return TextUtils.isEmpty(castDevice0.zzo) ? false : CastUtils.zze(s, castDevice0.zzo);
            }
        }
        return false;
    }

    public void putInBundle(Bundle bundle0) {
        if(bundle0 == null) {
            return;
        }
        bundle0.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
    }

    @Override
    public String toString() {
        String s;
        zzp zzp0 = this.zzj;
        if(zzp0.zzb(0x40)) {
            s = "[dynamic group]";
        }
        else if(zzp0.zzc()) {
            s = "[static group]";
        }
        else {
            s = zzp0.zzd() ? "[speaker pair]" : "";
        }
        if(zzp0.zzb(0x40000)) {
            s = s + "[cast connect]";
        }
        String s1 = this.zze;
        Locale locale0 = Locale.ROOT;
        if(!TextUtils.isEmpty(s1)) {
            int v = s1.length();
            if(v > 2) {
                s1 = String.format(locale0, "%c%d%c", Character.valueOf(s1.charAt(0)), ((int)(v - 2)), Character.valueOf(s1.charAt(v - 1)));
            }
            else if(v == 2) {
                s1 = "xx";
            }
            else {
                s1 = "x";
            }
        }
        StringBuilder stringBuilder0 = d.o("\"", s1, "\" (", this.zzc, ") ");
        stringBuilder0.append(s);
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 2, this.zzc, false);
        SafeParcelWriter.writeString(parcel0, 3, this.zza, false);
        SafeParcelWriter.writeString(parcel0, 4, this.getFriendlyName(), false);
        SafeParcelWriter.writeString(parcel0, 5, this.getModelName(), false);
        SafeParcelWriter.writeString(parcel0, 6, this.getDeviceVersion(), false);
        SafeParcelWriter.writeInt(parcel0, 7, this.getServicePort());
        SafeParcelWriter.writeTypedList(parcel0, 8, this.getIcons(), false);
        SafeParcelWriter.writeInt(parcel0, 9, this.zzj.zza());
        SafeParcelWriter.writeInt(parcel0, 10, this.zzk);
        SafeParcelWriter.writeString(parcel0, 11, this.zzl, false);
        SafeParcelWriter.writeString(parcel0, 12, this.zzm, false);
        SafeParcelWriter.writeInt(parcel0, 13, this.zzn);
        SafeParcelWriter.writeString(parcel0, 14, this.zzo, false);
        SafeParcelWriter.writeByteArray(parcel0, 15, this.zzp, false);
        SafeParcelWriter.writeString(parcel0, 16, this.zzq, false);
        SafeParcelWriter.writeBoolean(parcel0, 17, this.zzr);
        SafeParcelWriter.writeParcelable(parcel0, 18, this.zzc(), v, false);
        SafeParcelWriter.writeIntegerObject(parcel0, 19, this.zzt, false);
        SafeParcelWriter.writeBooleanObject(parcel0, 20, Boolean.valueOf(this.zze()), false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    @ShowFirstParty
    public final int zza() {
        return this.zzj.zza();
    }

    public final int zzb() {
        zzp zzp0 = this.zzj;
        if(!zzp0.zzb(0x40)) {
            if(!zzp0.zzc()) {
                if(zzp0.zzd()) {
                    return 5;
                }
                return this.hasCapability(1) ? 2 : 1;
            }
            return 3;
        }
        return 4;
    }

    public final zzaa zzc() {
        return this.zzs != null || !this.zzj.zzd() ? this.zzs : zzz.zza(1);
    }

    @ShowFirstParty
    public final String zzd() {
        return this.zzm;
    }

    @ShowFirstParty
    public final boolean zze() {
        return this.zzb == null ? this.zzk != -1 && (this.zzk & 2) > 0 : this.zzb.booleanValue();
    }

    private static String zzf(String s) {
        return s == null ? "" : s;
    }
}

