package androidx.car.app.navigation;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.car.app.serialization.Bundleable;

public interface INavigationHost extends IInterface {
    public static class Default implements INavigationHost {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // androidx.car.app.navigation.INavigationHost
        public void navigationEnded() {
        }

        @Override  // androidx.car.app.navigation.INavigationHost
        public void navigationStarted() {
        }

        @Override  // androidx.car.app.navigation.INavigationHost
        public void updateTrip(Bundleable bundleable0) {
        }
    }

    public static abstract class Stub extends Binder implements INavigationHost {
        static class Proxy implements INavigationHost {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "androidx.car.app.navigation.INavigationHost";
            }

            @Override  // androidx.car.app.navigation.INavigationHost
            public void navigationEnded() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.navigation.INavigationHost");
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.navigation.INavigationHost
            public void navigationStarted() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.navigation.INavigationHost");
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.navigation.INavigationHost
            public void updateTrip(Bundleable bundleable0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.navigation.INavigationHost");
                    if(bundleable0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        bundleable0.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_navigationEnded = 3;
        static final int TRANSACTION_navigationStarted = 2;
        static final int TRANSACTION_updateTrip = 4;

        public Stub() {
            this.attachInterface(this, "androidx.car.app.navigation.INavigationHost");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static INavigationHost asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("androidx.car.app.navigation.INavigationHost");
            return iInterface0 != null && iInterface0 instanceof INavigationHost ? ((INavigationHost)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("androidx.car.app.navigation.INavigationHost");
            }
            switch(v) {
                case 2: {
                    this.navigationStarted();
                    parcel1.writeNoException();
                    return true;
                }
                case 3: {
                    this.navigationEnded();
                    parcel1.writeNoException();
                    return true;
                }
                case 4: {
                    this.updateTrip(((Bundleable)(parcel0.readInt() == 0 ? null : Bundleable.CREATOR.createFromParcel(parcel0))));
                    parcel1.writeNoException();
                    return true;
                }
                case 0x5F4E5446: {
                    parcel1.writeString("androidx.car.app.navigation.INavigationHost");
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
        INavigationHost.DESCRIPTOR = "androidx.car.app.navigation.INavigationHost";
    }

    void navigationEnded();

    void navigationStarted();

    void updateTrip(Bundleable arg1);
}

