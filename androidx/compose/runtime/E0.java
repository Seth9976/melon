package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import p0.c;
import p0.h;
import p0.m;

public final class e0 implements Parcelable.Creator {
    public final int a;

    public e0(int v) {
        this.a = v;
        super();
    }

    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        switch(this.a) {
            case 0: {
                double f = parcel0.readDouble();
                ParcelableSnapshotMutableDoubleState parcelableSnapshotMutableDoubleState0 = new ParcelableSnapshotMutableDoubleState();  // 初始化器: Lp0/u;-><init>()V
                h h0 = m.k();
                F0 f00 = new F0(h0.g(), f);
                if(!(h0 instanceof c)) {
                    f00.b = new F0(1L, f);
                }
                parcelableSnapshotMutableDoubleState0.b = f00;
                return parcelableSnapshotMutableDoubleState0;
            }
            case 1: {
                return new ParcelableSnapshotMutableFloatState(parcel0.readFloat());
            }
            case 2: {
                return new ParcelableSnapshotMutableIntState(parcel0.readInt());
            }
            default: {
                return new ParcelableSnapshotMutableLongState(parcel0.readLong());
            }
        }
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        switch(this.a) {
            case 0: {
                return new ParcelableSnapshotMutableDoubleState[v];
            }
            case 1: {
                return new ParcelableSnapshotMutableFloatState[v];
            }
            case 2: {
                return new ParcelableSnapshotMutableIntState[v];
            }
            default: {
                return new ParcelableSnapshotMutableLongState[v];
            }
        }
    }
}

