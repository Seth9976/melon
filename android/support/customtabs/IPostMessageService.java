package android.support.customtabs;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public interface IPostMessageService extends IInterface {
    public static class Default implements IPostMessageService {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // android.support.customtabs.IPostMessageService
        public void onMessageChannelReady(ICustomTabsCallback iCustomTabsCallback0, Bundle bundle0) {
        }

        @Override  // android.support.customtabs.IPostMessageService
        public void onPostMessage(ICustomTabsCallback iCustomTabsCallback0, String s, Bundle bundle0) {
        }
    }

    public static abstract class Stub extends Binder implements IPostMessageService {
        static class Proxy implements IPostMessageService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.support.customtabs.IPostMessageService";
            }

            @Override  // android.support.customtabs.IPostMessageService
            public void onMessageChannelReady(ICustomTabsCallback iCustomTabsCallback0, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.IPostMessageService");
                    parcel0.writeStrongInterface(iCustomTabsCallback0);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.IPostMessageService
            public void onPostMessage(ICustomTabsCallback iCustomTabsCallback0, String s, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.IPostMessageService");
                    parcel0.writeStrongInterface(iCustomTabsCallback0);
                    parcel0.writeString(s);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_onMessageChannelReady = 2;
        static final int TRANSACTION_onPostMessage = 3;

        public Stub() {
            this.attachInterface(this, "android.support.customtabs.IPostMessageService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IPostMessageService asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("android.support.customtabs.IPostMessageService");
            return iInterface0 != null && iInterface0 instanceof IPostMessageService ? ((IPostMessageService)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("android.support.customtabs.IPostMessageService");
            }
            switch(v) {
                case 2: {
                    this.onMessageChannelReady(android.support.customtabs.ICustomTabsCallback.Stub.asInterface(parcel0.readStrongBinder()), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    return true;
                }
                case 3: {
                    this.onPostMessage(android.support.customtabs.ICustomTabsCallback.Stub.asInterface(parcel0.readStrongBinder()), parcel0.readString(), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    return true;
                }
                case 0x5F4E5446: {
                    parcel1.writeString("android.support.customtabs.IPostMessageService");
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
        IPostMessageService.DESCRIPTOR = "android.support.customtabs.IPostMessageService";
    }

    void onMessageChannelReady(ICustomTabsCallback arg1, Bundle arg2);

    void onPostMessage(ICustomTabsCallback arg1, String arg2, Bundle arg3);
}

