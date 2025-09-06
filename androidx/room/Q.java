package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import jeb.synthetic.FIN;

public final class q extends Binder implements h {
    public final MultiInstanceInvalidationService a;
    public static final int b;

    public q(MultiInstanceInvalidationService multiInstanceInvalidationService0) {
        this.a = multiInstanceInvalidationService0;
        super();
        this.attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
    }

    @Override  // androidx.room.h
    public final void D(int v, String[] arr_s) {
        int v4;
        kotlin.jvm.internal.q.g(arr_s, "tables");
        MultiInstanceInvalidationService multiInstanceInvalidationService0 = this.a;
        synchronized(multiInstanceInvalidationService0.c) {
            String s = (String)multiInstanceInvalidationService0.b.get(v);
            if(s == null) {
                Log.w("ROOM", "Remote invalidation client ID not registered");
                return;
            }
            int v2 = multiInstanceInvalidationService0.c.beginBroadcast();
            v4 = FIN.finallyOpen$NT();
            for(int v3 = 0; v3 < v2; ++v3) {
                Object object0 = multiInstanceInvalidationService0.c.getBroadcastCookie(v3);
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.Int");
                if(v != ((int)(((Integer)object0))) && s.equals(((String)multiInstanceInvalidationService0.b.get(((Integer)object0))))) {
                    try {
                        ((f)multiInstanceInvalidationService0.c.getBroadcastItem(v3)).g(arr_s);
                    }
                    catch(RemoteException remoteException0) {
                        Log.w("ROOM", "Error invoking a remote callback", remoteException0);
                    }
                }
            }
            FIN.finallyCodeBegin$NT(v4);
            multiInstanceInvalidationService0.c.finishBroadcast();
        }
        FIN.finallyCodeEnd$NT(v4);
    }

    @Override  // androidx.room.h
    public final int X(f f0, String s) {
        kotlin.jvm.internal.q.g(f0, "callback");
        int v = 0;
        if(s == null) {
            return 0;
        }
        MultiInstanceInvalidationService multiInstanceInvalidationService0 = this.a;
        synchronized(multiInstanceInvalidationService0.c) {
            int v2 = multiInstanceInvalidationService0.a + 1;
            multiInstanceInvalidationService0.a = v2;
            if(multiInstanceInvalidationService0.c.register(f0, v2)) {
                multiInstanceInvalidationService0.b.put(v2, s);
                v = v2;
            }
            else {
                --multiInstanceInvalidationService0.a;
            }
            return v;
        }
    }

    @Override  // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override  // android.os.Binder
    public final boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v >= 1 && v <= 0xFFFFFF) {
            parcel0.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
        }
        f f0 = null;
        if(v == 0x5F4E5446) {
            parcel1.writeString("androidx.room.IMultiInstanceInvalidationService");
            return true;
        }
        switch(v) {
            case 1: {
                IBinder iBinder0 = parcel0.readStrongBinder();
                if(iBinder0 != null) {
                    IInterface iInterface0 = iBinder0.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
                    if(iInterface0 == null || !(iInterface0 instanceof f)) {
                        f0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
                        f0.a = iBinder0;
                    }
                    else {
                        f0 = (f)iInterface0;
                    }
                }
                int v2 = this.X(f0, parcel0.readString());
                parcel1.writeNoException();
                parcel1.writeInt(v2);
                return true;
            }
            case 2: {
                IBinder iBinder1 = parcel0.readStrongBinder();
                if(iBinder1 != null) {
                    IInterface iInterface1 = iBinder1.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
                    if(iInterface1 == null || !(iInterface1 instanceof f)) {
                        f0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
                        f0.a = iBinder1;
                    }
                    else {
                        f0 = (f)iInterface1;
                    }
                }
                this.y0(f0, parcel0.readInt());
                parcel1.writeNoException();
                return true;
            }
            case 3: {
                this.D(parcel0.readInt(), parcel0.createStringArray());
                return true;
            }
            default: {
                return super.onTransact(v, parcel0, parcel1, v1);
            }
        }
    }

    @Override  // androidx.room.h
    public final void y0(f f0, int v) {
        kotlin.jvm.internal.q.g(f0, "callback");
        synchronized(this.a.c) {
            this.a.c.unregister(f0);
            String s = (String)this.a.b.remove(v);
        }
    }
}

