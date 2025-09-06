package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.internal.location.zzer;
import java.util.Arrays;
import org.checkerframework.dataflow.qual.Pure;

@Class(creator = "DeviceOrientationCreator")
@Reserved({2, 3})
public class DeviceOrientation extends AbstractSafeParcelable {
    public static final class Builder {
        private final float[] zza;
        private float zzb;
        private float zzc;
        private long zzd;
        private byte zze;
        private float zzf;
        private float zzg;

        public Builder(DeviceOrientation deviceOrientation0) {
            this.zze = 0;
            DeviceOrientation.zzj(deviceOrientation0.zzc());
            this.zza = Arrays.copyOf(deviceOrientation0.zzc(), deviceOrientation0.zzc().length);
            this.setHeadingDegrees(deviceOrientation0.zzd());
            this.setHeadingErrorDegrees(deviceOrientation0.zze());
            this.setConservativeHeadingErrorDegrees(deviceOrientation0.zzi());
            this.setElapsedRealtimeNs(deviceOrientation0.zzf());
            this.zzf = deviceOrientation0.zzh();
            this.zze = deviceOrientation0.zzg();
        }

        public Builder(float[] arr_f, float f, float f1, long v) {
            this.zze = 0;
            DeviceOrientation.zzj(arr_f);
            this.zza = Arrays.copyOf(arr_f, arr_f.length);
            this.setHeadingDegrees(f);
            this.setHeadingErrorDegrees(f1);
            this.setElapsedRealtimeNs(v);
            this.zzf = 0.0f;
            this.zzg = 180.0f;
            this.zze = 0;
        }

        public DeviceOrientation build() {
            return new DeviceOrientation(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
        }

        public Builder clearConservativeHeadingErrorDegrees() {
            this.zzg = 180.0f;
            this.zzf = 0.0f;
            this.zze = (byte)(((byte)(this.zze & -65)) & -33);
            return this;
        }

        public Builder setAttitude(float[] arr_f) {
            DeviceOrientation.zzj(arr_f);
            System.arraycopy(arr_f, 0, this.zza, 0, arr_f.length);
            return this;
        }

        public Builder setConservativeHeadingErrorDegrees(float f) {
            float f1 = 0.0f;
            zzer.zzb(Float.compare(f, 0.0f) >= 0 && f <= 180.0f, "conservativeHeadingErrorDegrees should be between 0 and 180.");
            this.zzg = f;
            this.zze = (byte)(this.zze | 0x40);
            if(f < 180.0f) {
                f1 = (float)(2.0 / (1.0 - Math.cos(Math.toRadians(f))));
            }
            this.zzf = f1;
            this.zze = (byte)(this.zze | 0x20);
            return this;
        }

        public Builder setElapsedRealtimeNs(long v) {
            zzer.zzb(v >= 0L, "elapsedRealtimeNs should be greater than or equal to 0.");
            this.zzd = v;
            return this;
        }

        public Builder setHeadingDegrees(float f) {
            zzer.zzb(Float.compare(f, 0.0f) >= 0 && f < 360.0f, "headingDegrees should be greater than or equal to 0 and less than 360.");
            this.zzb = f;
            return this;
        }

        public Builder setHeadingErrorDegrees(float f) {
            zzer.zzb(Float.compare(f, 0.0f) >= 0 && f <= 180.0f, "headingErrorDegrees should be between 0 and 180.");
            this.zzc = f;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getAttitude", id = 1)
    private final float[] zza;
    @Field(getter = "getHeadingDegrees", id = 4)
    private final float zzb;
    @Field(getter = "getHeadingErrorDegrees", id = 5)
    private final float zzc;
    @Field(getter = "getElapsedRealtimeNs", id = 6)
    private final long zzd;
    @Field(getter = "getFieldMask", id = 7)
    private final byte zze;
    @Field(getter = "getConservativeHeadingErrorVonMisesKappa", id = 8)
    private final float zzf;
    @Field(getter = "getConservativeHeadingErrorDegrees", id = 9)
    private final float zzg;

    static {
        DeviceOrientation.CREATOR = new zzm();
    }

    @Constructor
    public DeviceOrientation(@Param(id = 1) float[] arr_f, @Param(id = 4) float f, @Param(id = 5) float f1, @Param(id = 6) long v, @Param(id = 7) byte b, @Param(id = 8) float f2, @Param(id = 9) float f3) {
        DeviceOrientation.zzj(arr_f);
        boolean z = true;
        zzer.zza(Float.compare(f, 0.0f) >= 0 && f < 360.0f);
        zzer.zza(Float.compare(f1, 0.0f) >= 0 && f1 <= 180.0f);
        zzer.zza(f3 >= 0.0f && f3 <= 180.0f);
        if(v < 0L) {
            z = false;
        }
        zzer.zza(z);
        this.zza = arr_f;
        this.zzb = f;
        this.zzc = f1;
        this.zzf = f2;
        this.zzg = f3;
        this.zzd = v;
        this.zze = (byte)(((byte)(((byte)(b | 16)) | 4)) | 8);
    }

    @Override
    @Pure
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof DeviceOrientation)) {
            return false;
        }
        boolean z = this.zza() == ((DeviceOrientation)object0).zza() && (!this.zza() || Float.compare(this.zzf, ((DeviceOrientation)object0).zzf) == 0);
        boolean z1 = this.hasConservativeHeadingErrorDegrees() == ((DeviceOrientation)object0).hasConservativeHeadingErrorDegrees() && (!this.hasConservativeHeadingErrorDegrees() || Float.compare(this.getConservativeHeadingErrorDegrees(), ((DeviceOrientation)object0).getConservativeHeadingErrorDegrees()) == 0);
        return Float.compare(this.zzb, ((DeviceOrientation)object0).zzb) == 0 && Float.compare(this.zzc, ((DeviceOrientation)object0).zzc) == 0 && z && z1 && this.zzd == ((DeviceOrientation)object0).zzd && Arrays.equals(this.zza, ((DeviceOrientation)object0).zza);
    }

    @Pure
    public float[] getAttitude() {
        return (float[])this.zza.clone();
    }

    @Pure
    public float getConservativeHeadingErrorDegrees() {
        return this.zzg;
    }

    @Pure
    public long getElapsedRealtimeNs() {
        return this.zzd;
    }

    @Pure
    public float getHeadingDegrees() {
        return this.zzb;
    }

    @Pure
    public float getHeadingErrorDegrees() {
        return this.zzc;
    }

    @Pure
    public boolean hasConservativeHeadingErrorDegrees() {
        return (this.zze & 0x40) != 0;
    }

    @Override
    @Pure
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zzb, this.zzc, this.zzg, this.zzd, this.zza, this.zze});
    }

    @Override
    @Pure
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("DeviceOrientation[attitude=");
        stringBuilder0.append(Arrays.toString(this.zza));
        stringBuilder0.append(", headingDegrees=");
        stringBuilder0.append(this.zzb);
        stringBuilder0.append(", headingErrorDegrees=");
        stringBuilder0.append(this.zzc);
        if(this.hasConservativeHeadingErrorDegrees()) {
            stringBuilder0.append(", conservativeHeadingErrorDegrees=");
            stringBuilder0.append(this.zzg);
        }
        stringBuilder0.append(", elapsedRealtimeNs=");
        stringBuilder0.append(this.zzd);
        stringBuilder0.append(']');
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeFloatArray(parcel0, 1, this.getAttitude(), false);
        SafeParcelWriter.writeFloat(parcel0, 4, this.getHeadingDegrees());
        SafeParcelWriter.writeFloat(parcel0, 5, this.getHeadingErrorDegrees());
        SafeParcelWriter.writeLong(parcel0, 6, this.getElapsedRealtimeNs());
        SafeParcelWriter.writeByte(parcel0, 7, this.zze);
        SafeParcelWriter.writeFloat(parcel0, 8, this.zzf);
        SafeParcelWriter.writeFloat(parcel0, 9, this.getConservativeHeadingErrorDegrees());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    @Pure
    public final boolean zza() {
        return (this.zze & 0x20) != 0;
    }

    public final float[] zzc() {
        return this.zza;
    }

    public final float zzd() {
        return this.zzb;
    }

    public final float zze() {
        return this.zzc;
    }

    public final long zzf() {
        return this.zzd;
    }

    public final byte zzg() {
        return this.zze;
    }

    public final float zzh() {
        return this.zzf;
    }

    public final float zzi() {
        return this.zzg;
    }

    private static void zzj(float[] arr_f) {
        boolean z = true;
        zzer.zzb(arr_f != null && arr_f.length == 4, "Input attitude array should be of length 4.");
        if(Float.isNaN(arr_f[0]) || Float.isNaN(arr_f[1]) || Float.isNaN(arr_f[2]) || Float.isNaN(arr_f[3])) {
            z = false;
        }
        zzer.zzb(z, "Input attitude cannot contain NaNs.");
    }
}

