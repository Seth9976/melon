package androidx.car.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.car.app.serialization.Bundleable;

public interface IOnDoneCallback extends IInterface {
    public static class Default implements IOnDoneCallback {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // androidx.car.app.IOnDoneCallback
        public void onFailure(Bundleable bundleable0) {
        }

        @Override  // androidx.car.app.IOnDoneCallback
        public void onSuccess(Bundleable bundleable0) {
        }
    }

    public static abstract class Stub extends Binder implements IOnDoneCallback {
        static class Proxy implements IOnDoneCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "androidx.car.app.IOnDoneCallback";
            }

            @Override  // androidx.car.app.IOnDoneCallback
            public void onFailure(Bundleable bundleable0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.IOnDoneCallback");
                    if(bundleable0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        parcel0.writeBundle(bundleable0.a);
                    }
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.IOnDoneCallback
            public void onSuccess(Bundleable bundleable0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.IOnDoneCallback");
                    if(bundleable0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        parcel0.writeBundle(bundleable0.a);
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

        static final int TRANSACTION_onFailure = 3;
        static final int TRANSACTION_onSuccess = 2;

        public Stub() {
            this.attachInterface(this, "androidx.car.app.IOnDoneCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IOnDoneCallback asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("androidx.car.app.IOnDoneCallback");
            return iInterface0 != null && iInterface0 instanceof IOnDoneCallback ? ((IOnDoneCallback)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("androidx.car.app.IOnDoneCallback");
            }
            Object object0 = null;
            if(v == 0x5F4E5446) {
                parcel1.writeString("androidx.car.app.IOnDoneCallback");
                return true;
            }
            switch(v) {
                case 2: {
                    Parcelable.Creator parcelable$Creator0 = Bundleable.CREATOR;
                    if(parcel0.readInt() != 0) {
                        object0 = parcelable$Creator0.createFromParcel(parcel0);
                    }
                    this.onSuccess(((Bundleable)object0));
                    parcel1.writeNoException();
                    return true;
                }
                case 3: {
                    Parcelable.Creator parcelable$Creator1 = Bundleable.CREATOR;
                    if(parcel0.readInt() != 0) {
                        object0 = parcelable$Creator1.createFromParcel(parcel0);
                    }
                    this.onFailure(((Bundleable)object0));
                    parcel1.writeNoException();
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
        IOnDoneCallback.DESCRIPTOR = "androidx.car.app.IOnDoneCallback";
    }

    void onFailure(Bundleable arg1);

    void onSuccess(Bundleable arg1);
}

