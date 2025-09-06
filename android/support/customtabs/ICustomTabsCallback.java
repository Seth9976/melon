package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public interface ICustomTabsCallback extends IInterface {
    public static class Default implements ICustomTabsCallback {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // android.support.customtabs.ICustomTabsCallback
        public void extraCallback(String s, Bundle bundle0) {
        }

        @Override  // android.support.customtabs.ICustomTabsCallback
        public Bundle extraCallbackWithResult(String s, Bundle bundle0) {
            return null;
        }

        @Override  // android.support.customtabs.ICustomTabsCallback
        public void onActivityLayout(int v, int v1, int v2, int v3, int v4, Bundle bundle0) {
        }

        @Override  // android.support.customtabs.ICustomTabsCallback
        public void onActivityResized(int v, int v1, Bundle bundle0) {
        }

        @Override  // android.support.customtabs.ICustomTabsCallback
        public void onMessageChannelReady(Bundle bundle0) {
        }

        @Override  // android.support.customtabs.ICustomTabsCallback
        public void onMinimized(Bundle bundle0) {
        }

        @Override  // android.support.customtabs.ICustomTabsCallback
        public void onNavigationEvent(int v, Bundle bundle0) {
        }

        @Override  // android.support.customtabs.ICustomTabsCallback
        public void onPostMessage(String s, Bundle bundle0) {
        }

        @Override  // android.support.customtabs.ICustomTabsCallback
        public void onRelationshipValidationResult(int v, Uri uri0, boolean z, Bundle bundle0) {
        }

        @Override  // android.support.customtabs.ICustomTabsCallback
        public void onUnminimized(Bundle bundle0) {
        }

        @Override  // android.support.customtabs.ICustomTabsCallback
        public void onWarmupCompleted(Bundle bundle0) {
        }
    }

    public static abstract class Stub extends Binder implements ICustomTabsCallback {
        static class Proxy implements ICustomTabsCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // android.support.customtabs.ICustomTabsCallback
            public void extraCallback(String s, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
                    parcel0.writeString(s);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(3, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsCallback
            public Bundle extraCallbackWithResult(String s, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
                    parcel0.writeString(s);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(7, parcel0, parcel1, 0);
                    parcel1.readException();
                    return (Bundle)_Parcel.readTypedObject(parcel1, Bundle.CREATOR);
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "android.support.customtabs.ICustomTabsCallback";
            }

            @Override  // android.support.customtabs.ICustomTabsCallback
            public void onActivityLayout(int v, int v1, int v2, int v3, int v4, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
                    parcel0.writeInt(v);
                    parcel0.writeInt(v1);
                    parcel0.writeInt(v2);
                    parcel0.writeInt(v3);
                    parcel0.writeInt(v4);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(10, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsCallback
            public void onActivityResized(int v, int v1, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
                    parcel0.writeInt(v);
                    parcel0.writeInt(v1);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(8, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsCallback
            public void onMessageChannelReady(Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsCallback
            public void onMinimized(Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(11, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsCallback
            public void onNavigationEvent(int v, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
                    parcel0.writeInt(v);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsCallback
            public void onPostMessage(String s, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
                    parcel0.writeString(s);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(5, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsCallback
            public void onRelationshipValidationResult(int v, Uri uri0, boolean z, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
                    parcel0.writeInt(v);
                    _Parcel.writeTypedObject(parcel0, uri0, 0);
                    parcel0.writeInt(((int)z));
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(6, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsCallback
            public void onUnminimized(Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(12, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsCallback
            public void onWarmupCompleted(Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(9, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_extraCallback = 3;
        static final int TRANSACTION_extraCallbackWithResult = 7;
        static final int TRANSACTION_onActivityLayout = 10;
        static final int TRANSACTION_onActivityResized = 8;
        static final int TRANSACTION_onMessageChannelReady = 4;
        static final int TRANSACTION_onMinimized = 11;
        static final int TRANSACTION_onNavigationEvent = 2;
        static final int TRANSACTION_onPostMessage = 5;
        static final int TRANSACTION_onRelationshipValidationResult = 6;
        static final int TRANSACTION_onUnminimized = 12;
        static final int TRANSACTION_onWarmupCompleted = 9;

        public Stub() {
            this.attachInterface(this, "android.support.customtabs.ICustomTabsCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICustomTabsCallback asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("android.support.customtabs.ICustomTabsCallback");
            return iInterface0 != null && iInterface0 instanceof ICustomTabsCallback ? ((ICustomTabsCallback)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("android.support.customtabs.ICustomTabsCallback");
            }
            if(v == 0x5F4E5446) {
                parcel1.writeString("android.support.customtabs.ICustomTabsCallback");
                return true;
            }
            switch(v) {
                case 2: {
                    this.onNavigationEvent(parcel0.readInt(), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    return true;
                }
                case 3: {
                    this.extraCallback(parcel0.readString(), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    return true;
                }
                case 4: {
                    this.onMessageChannelReady(((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    return true;
                }
                case 5: {
                    this.onPostMessage(parcel0.readString(), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    return true;
                }
                case 6: {
                    this.onRelationshipValidationResult(parcel0.readInt(), ((Uri)_Parcel.readTypedObject(parcel0, Uri.CREATOR)), parcel0.readInt() != 0, ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    return true;
                }
                case 7: {
                    Bundle bundle0 = this.extraCallbackWithResult(parcel0.readString(), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    _Parcel.writeTypedObject(parcel1, bundle0, 1);
                    return true;
                }
                case 8: {
                    this.onActivityResized(parcel0.readInt(), parcel0.readInt(), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    return true;
                }
                case 9: {
                    this.onWarmupCompleted(((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    return true;
                }
                case 10: {
                    this.onActivityLayout(parcel0.readInt(), parcel0.readInt(), parcel0.readInt(), parcel0.readInt(), parcel0.readInt(), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    return true;
                }
                case 11: {
                    this.onMinimized(((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    return true;
                }
                case 12: {
                    this.onUnminimized(((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
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
        ICustomTabsCallback.DESCRIPTOR = "android.support.customtabs.ICustomTabsCallback";
    }

    void extraCallback(String arg1, Bundle arg2);

    Bundle extraCallbackWithResult(String arg1, Bundle arg2);

    void onActivityLayout(int arg1, int arg2, int arg3, int arg4, int arg5, Bundle arg6);

    void onActivityResized(int arg1, int arg2, Bundle arg3);

    void onMessageChannelReady(Bundle arg1);

    void onMinimized(Bundle arg1);

    void onNavigationEvent(int arg1, Bundle arg2);

    void onPostMessage(String arg1, Bundle arg2);

    void onRelationshipValidationResult(int arg1, Uri arg2, boolean arg3, Bundle arg4);

    void onUnminimized(Bundle arg1);

    void onWarmupCompleted(Bundle arg1);
}

