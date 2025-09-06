package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

public final class o extends Binder implements f {
    public final p a;

    public o(p p0) {
        this.a = p0;
        super();
        this.attachInterface(this, "androidx.room.IMultiInstanceInvalidationCallback");
    }

    @Override  // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override  // androidx.room.f
    public final void g(String[] arr_s) {
        q.g(arr_s, "tables");
        n n0 = new n(arr_s, this.a, null);
        BuildersKt__Builders_commonKt.launch$default(this.a.d, null, null, n0, 3, null);
    }

    @Override  // android.os.Binder
    public final boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v >= 1 && v <= 0xFFFFFF) {
            parcel0.enforceInterface("androidx.room.IMultiInstanceInvalidationCallback");
        }
        switch(v) {
            case 1: {
                this.g(parcel0.createStringArray());
                return true;
            }
            case 0x5F4E5446: {
                parcel1.writeString("androidx.room.IMultiInstanceInvalidationCallback");
                return true;
            }
            default: {
                return super.onTransact(v, parcel0, parcel1, v1);
            }
        }
    }
}

