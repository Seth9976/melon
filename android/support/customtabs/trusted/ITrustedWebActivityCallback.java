package android.support.customtabs.trusted;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public interface ITrustedWebActivityCallback extends IInterface {
    public static class Default implements ITrustedWebActivityCallback {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // android.support.customtabs.trusted.ITrustedWebActivityCallback
        public void onExtraCallback(String s, Bundle bundle0) {
        }
    }

    public static abstract class Stub extends Binder implements ITrustedWebActivityCallback {
        static class Proxy implements ITrustedWebActivityCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.support.customtabs.trusted.ITrustedWebActivityCallback";
            }

            @Override  // android.support.customtabs.trusted.ITrustedWebActivityCallback
            public void onExtraCallback(String s, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityCallback");
                    parcel0.writeString(s);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_onExtraCallback = 2;

        public Stub() {
            this.attachInterface(this, "android.support.customtabs.trusted.ITrustedWebActivityCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ITrustedWebActivityCallback asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("android.support.customtabs.trusted.ITrustedWebActivityCallback");
            return iInterface0 != null && iInterface0 instanceof ITrustedWebActivityCallback ? ((ITrustedWebActivityCallback)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityCallback");
            }
            switch(v) {
                case 2: {
                    this.onExtraCallback(parcel0.readString(), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    return true;
                }
                case 0x5F4E5446: {
                    parcel1.writeString("android.support.customtabs.trusted.ITrustedWebActivityCallback");
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
        ITrustedWebActivityCallback.DESCRIPTOR = "android.support.customtabs.trusted.ITrustedWebActivityCallback";
    }

    void onExtraCallback(String arg1, Bundle arg2);
}

