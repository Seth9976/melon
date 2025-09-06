package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class SpliceNullCommand extends SpliceCommand {
    public static final Parcelable.Creator CREATOR;

    static {
        SpliceNullCommand.CREATOR = new Parcelable.Creator() {
            public SpliceNullCommand createFromParcel(Parcel parcel0) {
                return new SpliceNullCommand();
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public SpliceNullCommand[] newArray(int v) {
                return new SpliceNullCommand[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
    }
}

