package androidx.car.app.navigation;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.car.app.IOnDoneCallback;

public interface INavigationManager extends IInterface {
    public static class Default implements INavigationManager {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // androidx.car.app.navigation.INavigationManager
        public void onStopNavigation(IOnDoneCallback iOnDoneCallback0) {
        }
    }

    public static abstract class Stub extends Binder implements INavigationManager {
        static class Proxy implements INavigationManager {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "androidx.car.app.navigation.INavigationManager";
            }

            @Override  // androidx.car.app.navigation.INavigationManager
            public void onStopNavigation(IOnDoneCallback iOnDoneCallback0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.navigation.INavigationManager");
                    parcel0.writeStrongInterface(iOnDoneCallback0);
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_onStopNavigation = 2;

        public Stub() {
            this.attachInterface(this, "androidx.car.app.navigation.INavigationManager");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static INavigationManager asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("androidx.car.app.navigation.INavigationManager");
            return iInterface0 != null && iInterface0 instanceof INavigationManager ? ((INavigationManager)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("androidx.car.app.navigation.INavigationManager");
            }
            switch(v) {
                case 2: {
                    this.onStopNavigation(androidx.car.app.IOnDoneCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    return true;
                }
                case 0x5F4E5446: {
                    parcel1.writeString("androidx.car.app.navigation.INavigationManager");
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
        INavigationManager.DESCRIPTOR = "androidx.car.app.navigation.INavigationManager";
    }

    void onStopNavigation(IOnDoneCallback arg1);
}

