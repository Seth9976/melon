package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class MlltFrame extends Id3Frame {
    public static final Parcelable.Creator CREATOR = null;
    public static final String ID = "MLLT";
    public final int bytesBetweenReference;
    public final int[] bytesDeviations;
    public final int millisecondsBetweenReference;
    public final int[] millisecondsDeviations;
    public final int mpegFramesBetweenReference;

    static {
        MlltFrame.CREATOR = new Parcelable.Creator() {
            public MlltFrame createFromParcel(Parcel parcel0) {
                return new MlltFrame(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public MlltFrame[] newArray(int v) {
                return new MlltFrame[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public MlltFrame(int v, int v1, int v2, int[] arr_v, int[] arr_v1) {
        super("MLLT");
        this.mpegFramesBetweenReference = v;
        this.bytesBetweenReference = v1;
        this.millisecondsBetweenReference = v2;
        this.bytesDeviations = arr_v;
        this.millisecondsDeviations = arr_v1;
    }

    public MlltFrame(Parcel parcel0) {
        super("MLLT");
        this.mpegFramesBetweenReference = parcel0.readInt();
        this.bytesBetweenReference = parcel0.readInt();
        this.millisecondsBetweenReference = parcel0.readInt();
        this.bytesDeviations = (int[])Util.castNonNull(parcel0.createIntArray());
        this.millisecondsDeviations = (int[])Util.castNonNull(parcel0.createIntArray());
    }

    @Override  // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public int describeContents() {
        return 0;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return MlltFrame.class == class0 && this.mpegFramesBetweenReference == ((MlltFrame)object0).mpegFramesBetweenReference && this.bytesBetweenReference == ((MlltFrame)object0).bytesBetweenReference && this.millisecondsBetweenReference == ((MlltFrame)object0).millisecondsBetweenReference && Arrays.equals(this.bytesDeviations, ((MlltFrame)object0).bytesDeviations) && Arrays.equals(this.millisecondsDeviations, ((MlltFrame)object0).millisecondsDeviations);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int v = Arrays.hashCode(this.bytesDeviations);
        return Arrays.hashCode(this.millisecondsDeviations) + (v + (((this.mpegFramesBetweenReference + 0x20F) * 0x1F + this.bytesBetweenReference) * 0x1F + this.millisecondsBetweenReference) * 0x1F) * 0x1F;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.mpegFramesBetweenReference);
        parcel0.writeInt(this.bytesBetweenReference);
        parcel0.writeInt(this.millisecondsBetweenReference);
        parcel0.writeIntArray(this.bytesDeviations);
        parcel0.writeIntArray(this.millisecondsDeviations);
    }
}

