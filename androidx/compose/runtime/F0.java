package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

public final class f0 implements Parcelable.ClassLoaderCreator {
    public static ParcelableSnapshotMutableState a(Parcel parcel0, ClassLoader classLoader0) {
        if(classLoader0 == null) {
            classLoader0 = f0.class.getClassLoader();
        }
        Object object0 = parcel0.readValue(classLoader0);
        int v = parcel0.readInt();
        switch(v) {
            case 0: {
                return new ParcelableSnapshotMutableState(object0, V.c);  // 初始化器: Landroidx/compose/runtime/O0;-><init>(Ljava/lang/Object;Landroidx/compose/runtime/P0;)V
            }
            case 1: {
                return new ParcelableSnapshotMutableState(object0, V.f);  // 初始化器: Landroidx/compose/runtime/O0;-><init>(Ljava/lang/Object;Landroidx/compose/runtime/P0;)V
            }
            case 2: {
                return new ParcelableSnapshotMutableState(object0, V.d);  // 初始化器: Landroidx/compose/runtime/O0;-><init>(Ljava/lang/Object;Landroidx/compose/runtime/P0;)V
            }
            default: {
                throw new IllegalStateException("Unsupported MutableState policy " + v + " was restored");
            }
        }
    }

    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        return f0.a(parcel0, null);
    }

    @Override  // android.os.Parcelable$ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel0, ClassLoader classLoader0) {
        return f0.a(parcel0, classLoader0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new ParcelableSnapshotMutableState[v];
    }
}

