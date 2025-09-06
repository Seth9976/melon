package b3;

import B0.s;
import I6.Q;
import I6.V;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public final class g extends Binder {
    public final V a;
    public static final int b;

    static {
        g.b = s.b();
    }

    public g(List list0) {
        this.a = V.p(list0);
    }

    public static V a(IBinder iBinder0) {
        if(iBinder0 instanceof g) {
            return ((g)iBinder0).a;
        }
        Q q0 = V.o();
        int v = 0;
        for(int v1 = 1; v1 != 0; v1 = v3) {
            Parcel parcel0 = Parcel.obtain();
            Parcel parcel1 = Parcel.obtain();
            try {
                parcel0.writeInt(v);
                try {
                    iBinder0.transact(1, parcel0, parcel1, 0);
                }
                catch(RemoteException remoteException0) {
                    throw new RuntimeException(remoteException0);
                }
                int v3;
                while((v3 = parcel1.readInt()) == 1) {
                    Bundle bundle0 = parcel1.readBundle();
                    bundle0.getClass();
                    q0.a(bundle0);
                    ++v;
                }
            }
            finally {
                parcel1.recycle();
                parcel0.recycle();
            }
        }
        return q0.g();
    }

    @Override  // android.os.Binder
    public final boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
        int v2 = 0;
        if(v != 1) {
            return super.onTransact(v, parcel0, parcel1, v1);
        }
        if(parcel1 == null) {
            return false;
        }
        V v3 = this.a;
        int v4 = v3.size();
        int v5;
        for(v5 = parcel0.readInt(); v5 < v4 && parcel1.dataSize() < g.b; ++v5) {
            parcel1.writeInt(1);
            parcel1.writeBundle(((Bundle)v3.get(v5)));
        }
        if(v5 < v4) {
            v2 = 2;
        }
        parcel1.writeInt(v2);
        return true;
    }
}

