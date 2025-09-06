package androidx.car.app;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public interface ICarHost extends IInterface {
    public static class Default implements ICarHost {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // androidx.car.app.ICarHost
        public void finish() {
        }

        @Override  // androidx.car.app.ICarHost
        public IBinder getHost(String s) {
            return null;
        }

        @Override  // androidx.car.app.ICarHost
        public void startCarApp(Intent intent0) {
        }
    }

    public static abstract class Stub extends Binder implements ICarHost {
        static class Proxy implements ICarHost {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // androidx.car.app.ICarHost
            public void finish() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.ICarHost");
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.ICarHost
            public IBinder getHost(String s) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.ICarHost");
                    parcel0.writeString(s);
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readStrongBinder();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "androidx.car.app.ICarHost";
            }

            @Override  // androidx.car.app.ICarHost
            public void startCarApp(Intent intent0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.ICarHost");
                    if(intent0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        intent0.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_finish = 4;
        static final int TRANSACTION_getHost = 3;
        static final int TRANSACTION_startCarApp = 2;

        public Stub() {
            this.attachInterface(this, "androidx.car.app.ICarHost");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarHost asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("androidx.car.app.ICarHost");
            return iInterface0 != null && iInterface0 instanceof ICarHost ? ((ICarHost)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("androidx.car.app.ICarHost");
            }
            switch(v) {
                case 2: {
                    Parcelable.Creator parcelable$Creator0 = Intent.CREATOR;
                    this.startCarApp(((Intent)(parcel0.readInt() == 0 ? null : parcelable$Creator0.createFromParcel(parcel0))));
                    parcel1.writeNoException();
                    return true;
                }
                case 3: {
                    IBinder iBinder0 = this.getHost(parcel0.readString());
                    parcel1.writeNoException();
                    parcel1.writeStrongBinder(iBinder0);
                    return true;
                }
                case 4: {
                    this.finish();
                    parcel1.writeNoException();
                    return true;
                }
                case 0x5F4E5446: {
                    parcel1.writeString("androidx.car.app.ICarHost");
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
        ICarHost.DESCRIPTOR = "androidx.car.app.ICarHost";
    }

    void finish();

    IBinder getHost(String arg1);

    void startCarApp(Intent arg1);
}

