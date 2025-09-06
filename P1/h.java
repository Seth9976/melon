package P1;

import O1.a;
import O1.b;
import O1.c;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.core.content.UnusedAppRestrictionsBackportService;

public final class h extends Binder implements c {
    public final UnusedAppRestrictionsBackportService a;

    public h(UnusedAppRestrictionsBackportService unusedAppRestrictionsBackportService0) {
        this.a = unusedAppRestrictionsBackportService0;
        super();
        this.attachInterface(this, "androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService");
    }

    @Override  // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override  // android.os.Binder
    public final boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
        b b0;
        if(v >= 1 && v <= 0xFFFFFF) {
            parcel0.enforceInterface("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService");
        }
        switch(v) {
            case 1: {
                IBinder iBinder0 = parcel0.readStrongBinder();
                if(iBinder0 == null) {
                    b0 = null;
                }
                else {
                    IInterface iInterface0 = iBinder0.queryLocalInterface("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback");
                    if(iInterface0 == null || !(iInterface0 instanceof b)) {
                        a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                        a0.a = iBinder0;
                        b0 = a0;
                    }
                    else {
                        b0 = (b)iInterface0;
                    }
                }
                if(b0 == null) {
                    return true;
                }
                this.a.a();
                return true;
            }
            case 0x5F4E5446: {
                parcel1.writeString("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService");
                return true;
            }
            default: {
                return super.onTransact(v, parcel0, parcel1, v1);
            }
        }
    }
}

