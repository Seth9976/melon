package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Comparator;

@Class(creator = "DetectedActivityCreator")
@Reserved({1000})
public class DetectedActivity extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = null;
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int RUNNING = 8;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;
    public static final int WALKING = 7;
    public static final Comparator zza;
    @Field(id = 1)
    final int zzb;
    @Field(id = 2)
    final int zzc;

    static {
        DetectedActivity.zza = new zzk();
        DetectedActivity.CREATOR = new zzl();
    }

    @Constructor
    public DetectedActivity(@Param(id = 1) int v, @Param(id = 2) int v1) {
        this.zzb = v;
        this.zzc = v1;
    }

    @Override
    @ShowFirstParty
    public final boolean equals(Object object0) {
        return object0 instanceof DetectedActivity && this.zzb == ((DetectedActivity)object0).zzb && this.zzc == ((DetectedActivity)object0).zzc;
    }

    public int getConfidence() {
        return this.zzc;
    }

    public int getType() {
        return this.zzb > 22 || this.zzb < 0 ? 4 : this.zzb;
    }

    @Override
    @ShowFirstParty
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzb, this.zzc});
    }

    // 去混淆评级： 低(30)
    @Override
    public String toString() {
        int v = this.getType();
        switch(v) {
            case 0: {
                return "DetectedActivity [type=IN_VEHICLE, confidence=" + this.zzc + "]";
            }
            case 1: {
                return "DetectedActivity [type=ON_BICYCLE, confidence=" + this.zzc + "]";
            }
            case 2: {
                return "DetectedActivity [type=ON_FOOT, confidence=" + this.zzc + "]";
            }
            case 3: {
                return "DetectedActivity [type=STILL, confidence=" + this.zzc + "]";
            }
            case 4: {
                return "DetectedActivity [type=UNKNOWN, confidence=" + this.zzc + "]";
            }
            case 5: {
                return "DetectedActivity [type=TILTING, confidence=" + this.zzc + "]";
            }
            case 7: {
                return "DetectedActivity [type=WALKING, confidence=" + this.zzc + "]";
            }
            case 8: {
                return "DetectedActivity [type=RUNNING, confidence=" + this.zzc + "]";
            }
            case 16: {
                return "DetectedActivity [type=IN_ROAD_VEHICLE, confidence=" + this.zzc + "]";
            }
            case 17: {
                return "DetectedActivity [type=IN_RAIL_VEHICLE, confidence=" + this.zzc + "]";
            }
            default: {
                return "DetectedActivity [type=" + Integer.toString(v) + ", confidence=" + this.zzc + "]";
            }
        }
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        Preconditions.checkNotNull(parcel0);
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zzb);
        SafeParcelWriter.writeInt(parcel0, 2, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

