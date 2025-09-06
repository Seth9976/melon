package androidx.car.app;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.car.app.serialization.Bundleable;
import com.google.firebase.b;

public interface IAppHost extends IInterface {
    public static class Default implements IAppHost {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // androidx.car.app.IAppHost
        public void dismissAlert(int v) {
        }

        @Override  // androidx.car.app.IAppHost
        public void invalidate() {
        }

        @Override  // androidx.car.app.IAppHost
        public Bundleable openMicrophone(Bundleable bundleable0) {
            return null;
        }

        @Override  // androidx.car.app.IAppHost
        public void sendLocation(Location location0) {
        }

        @Override  // androidx.car.app.IAppHost
        public void setSurfaceCallback(ISurfaceCallback iSurfaceCallback0) {
        }

        @Override  // androidx.car.app.IAppHost
        public void showAlert(Bundleable bundleable0) {
        }

        @Override  // androidx.car.app.IAppHost
        public void showToast(CharSequence charSequence0, int v) {
        }
    }

    public static abstract class Stub extends Binder implements IAppHost {
        static class Proxy implements IAppHost {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // androidx.car.app.IAppHost
            public void dismissAlert(int v) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.IAppHost");
                    parcel0.writeInt(v);
                    this.mRemote.transact(7, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "androidx.car.app.IAppHost";
            }

            @Override  // androidx.car.app.IAppHost
            public void invalidate() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.IAppHost");
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.IAppHost
            public Bundleable openMicrophone(Bundleable bundleable0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.IAppHost");
                    b.q(parcel0, bundleable0, 0);
                    this.mRemote.transact(8, parcel0, parcel1, 0);
                    parcel1.readException();
                    return (Bundleable)b.p(parcel1, Bundleable.CREATOR);
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.IAppHost
            public void sendLocation(Location location0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.IAppHost");
                    b.q(parcel0, location0, 0);
                    this.mRemote.transact(5, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.IAppHost
            public void setSurfaceCallback(ISurfaceCallback iSurfaceCallback0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.IAppHost");
                    parcel0.writeStrongInterface(iSurfaceCallback0);
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.IAppHost
            public void showAlert(Bundleable bundleable0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.IAppHost");
                    b.q(parcel0, bundleable0, 0);
                    this.mRemote.transact(6, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.IAppHost
            public void showToast(CharSequence charSequence0, int v) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.IAppHost");
                    if(charSequence0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        TextUtils.writeToParcel(charSequence0, parcel0, 0);
                    }
                    parcel0.writeInt(v);
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_dismissAlert = 7;
        static final int TRANSACTION_invalidate = 2;
        static final int TRANSACTION_openMicrophone = 8;
        static final int TRANSACTION_sendLocation = 5;
        static final int TRANSACTION_setSurfaceCallback = 4;
        static final int TRANSACTION_showAlert = 6;
        static final int TRANSACTION_showToast = 3;

        public Stub() {
            this.attachInterface(this, "androidx.car.app.IAppHost");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IAppHost asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("androidx.car.app.IAppHost");
            return iInterface0 != null && iInterface0 instanceof IAppHost ? ((IAppHost)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("androidx.car.app.IAppHost");
            }
            if(v == 0x5F4E5446) {
                parcel1.writeString("androidx.car.app.IAppHost");
                return true;
            }
            switch(v) {
                case 2: {
                    this.invalidate();
                    parcel1.writeNoException();
                    return true;
                }
                case 3: {
                    this.showToast(((CharSequence)b.p(parcel0, TextUtils.CHAR_SEQUENCE_CREATOR)), parcel0.readInt());
                    parcel1.writeNoException();
                    return true;
                }
                case 4: {
                    this.setSurfaceCallback(androidx.car.app.ISurfaceCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    parcel1.writeNoException();
                    return true;
                }
                case 5: {
                    this.sendLocation(((Location)b.p(parcel0, Location.CREATOR)));
                    parcel1.writeNoException();
                    return true;
                }
                case 6: {
                    this.showAlert(((Bundleable)b.p(parcel0, Bundleable.CREATOR)));
                    parcel1.writeNoException();
                    return true;
                }
                case 7: {
                    this.dismissAlert(parcel0.readInt());
                    parcel1.writeNoException();
                    return true;
                }
                case 8: {
                    Bundleable bundleable0 = this.openMicrophone(((Bundleable)b.p(parcel0, Bundleable.CREATOR)));
                    parcel1.writeNoException();
                    b.q(parcel1, bundleable0, 1);
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
        IAppHost.DESCRIPTOR = "androidx.car.app.IAppHost";
    }

    void dismissAlert(int arg1);

    void invalidate();

    Bundleable openMicrophone(Bundleable arg1);

    void sendLocation(Location arg1);

    void setSurfaceCallback(ISurfaceCallback arg1);

    void showAlert(Bundleable arg1);

    void showToast(CharSequence arg1, int arg2);
}

