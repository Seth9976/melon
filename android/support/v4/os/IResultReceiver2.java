package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public interface IResultReceiver2 extends IInterface {
    public static class Default implements IResultReceiver2 {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // android.support.v4.os.IResultReceiver2
        public void send(int v, Bundle bundle0) {
        }
    }

    public static abstract class Stub extends Binder implements IResultReceiver2 {
        static class Proxy implements IResultReceiver2 {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.support.v4.os.IResultReceiver2";
            }

            @Override  // android.support.v4.os.IResultReceiver2
            public void send(int v, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.os.IResultReceiver2");
                    parcel0.writeInt(v);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_send = 1;

        public Stub() {
            this.attachInterface(this, "android.support.v4.os.IResultReceiver2");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IResultReceiver2 asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("android.support.v4.os.IResultReceiver2");
            return iInterface0 != null && iInterface0 instanceof IResultReceiver2 ? ((IResultReceiver2)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("android.support.v4.os.IResultReceiver2");
            }
            switch(v) {
                case 1: {
                    this.send(parcel0.readInt(), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    return true;
                }
                case 0x5F4E5446: {
                    parcel1.writeString("android.support.v4.os.IResultReceiver2");
                    return true;
                }
                default: {
                    return super.onTransact(v, parcel0, parcel1, v1);
                }
            }
        }
    }

    public static class _Parcel {
        private static Object readTypedObject(Parcel parcel0, Parcelable.Creator parcelable$Creator0) {
            return parcel0.readInt() == 0 ? null : parcelable$Creator0.createFromParcel(parcel0);
        }

        private static void writeTypedObject(Parcel parcel0, Parcelable parcelable0, int v) {
            if(parcelable0 != null) {
                parcel0.writeInt(1);
                parcelable0.writeToParcel(parcel0, v);
                return;
            }
            parcel0.writeInt(0);
        }
    }

    public static final String DESCRIPTOR;

    static {
        IResultReceiver2.DESCRIPTOR = "android.support.v4.os.IResultReceiver2";
    }

    void send(int arg1, Bundle arg2);
}

