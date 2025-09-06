package androidx.car.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface IAppManager extends IInterface {
    public static class Default implements IAppManager {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // androidx.car.app.IAppManager
        public void getTemplate(IOnDoneCallback iOnDoneCallback0) {
        }

        @Override  // androidx.car.app.IAppManager
        public void onBackPressed(IOnDoneCallback iOnDoneCallback0) {
        }

        @Override  // androidx.car.app.IAppManager
        public void startLocationUpdates(IOnDoneCallback iOnDoneCallback0) {
        }

        @Override  // androidx.car.app.IAppManager
        public void stopLocationUpdates(IOnDoneCallback iOnDoneCallback0) {
        }
    }

    public static abstract class Stub extends Binder implements IAppManager {
        static class Proxy implements IAppManager {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "androidx.car.app.IAppManager";
            }

            @Override  // androidx.car.app.IAppManager
            public void getTemplate(IOnDoneCallback iOnDoneCallback0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.IAppManager");
                    parcel0.writeStrongInterface(iOnDoneCallback0);
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.IAppManager
            public void onBackPressed(IOnDoneCallback iOnDoneCallback0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.IAppManager");
                    parcel0.writeStrongInterface(iOnDoneCallback0);
                    this.mRemote.transact(3, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.IAppManager
            public void startLocationUpdates(IOnDoneCallback iOnDoneCallback0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.IAppManager");
                    parcel0.writeStrongInterface(iOnDoneCallback0);
                    this.mRemote.transact(4, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.IAppManager
            public void stopLocationUpdates(IOnDoneCallback iOnDoneCallback0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.IAppManager");
                    parcel0.writeStrongInterface(iOnDoneCallback0);
                    this.mRemote.transact(5, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_getTemplate = 2;
        static final int TRANSACTION_onBackPressed = 3;
        static final int TRANSACTION_startLocationUpdates = 4;
        static final int TRANSACTION_stopLocationUpdates = 5;

        public Stub() {
            this.attachInterface(this, "androidx.car.app.IAppManager");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IAppManager asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("androidx.car.app.IAppManager");
            return iInterface0 != null && iInterface0 instanceof IAppManager ? ((IAppManager)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("androidx.car.app.IAppManager");
            }
            switch(v) {
                case 2: {
                    this.getTemplate(androidx.car.app.IOnDoneCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    return true;
                }
                case 3: {
                    this.onBackPressed(androidx.car.app.IOnDoneCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    return true;
                }
                case 4: {
                    this.startLocationUpdates(androidx.car.app.IOnDoneCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    return true;
                }
                case 5: {
                    this.stopLocationUpdates(androidx.car.app.IOnDoneCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    return true;
                }
                case 0x5F4E5446: {
                    parcel1.writeString("androidx.car.app.IAppManager");
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
        IAppManager.DESCRIPTOR = "androidx.car.app.IAppManager";
    }

    void getTemplate(IOnDoneCallback arg1);

    void onBackPressed(IOnDoneCallback arg1);

    void startLocationUpdates(IOnDoneCallback arg1);

    void stopLocationUpdates(IOnDoneCallback arg1);
}

