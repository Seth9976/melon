package androidx.car.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface IOnRequestPermissionsListener extends IInterface {
    public static class Default implements IOnRequestPermissionsListener {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // androidx.car.app.IOnRequestPermissionsListener
        public void onRequestPermissionsResult(String[] arr_s, String[] arr_s1) {
        }
    }

    public static abstract class Stub extends Binder implements IOnRequestPermissionsListener {
        static class Proxy implements IOnRequestPermissionsListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "androidx.car.app.IOnRequestPermissionsListener";
            }

            @Override  // androidx.car.app.IOnRequestPermissionsListener
            public void onRequestPermissionsResult(String[] arr_s, String[] arr_s1) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.IOnRequestPermissionsListener");
                    parcel0.writeStringArray(arr_s);
                    parcel0.writeStringArray(arr_s1);
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_onRequestPermissionsResult = 2;

        public Stub() {
            this.attachInterface(this, "androidx.car.app.IOnRequestPermissionsListener");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IOnRequestPermissionsListener asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("androidx.car.app.IOnRequestPermissionsListener");
            return iInterface0 != null && iInterface0 instanceof IOnRequestPermissionsListener ? ((IOnRequestPermissionsListener)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("androidx.car.app.IOnRequestPermissionsListener");
            }
            switch(v) {
                case 2: {
                    this.onRequestPermissionsResult(parcel0.createStringArray(), parcel0.createStringArray());
                    parcel1.writeNoException();
                    return true;
                }
                case 0x5F4E5446: {
                    parcel1.writeString("androidx.car.app.IOnRequestPermissionsListener");
                    return true;
                }
                default: {
                    return super.onTransact(v, parcel0, parcel1, v1);
                }
            }
        }
    }

    public static final String DESCRIPTOR;

    static {
        IOnRequestPermissionsListener.DESCRIPTOR = "androidx.car.app.IOnRequestPermissionsListener";
    }

    void onRequestPermissionsResult(String[] arg1, String[] arg2);
}

