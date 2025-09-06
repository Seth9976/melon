package android.support.customtabs.trusted;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public interface ITrustedWebActivityService extends IInterface {
    public static class Default implements ITrustedWebActivityService {
        @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle areNotificationsEnabled(Bundle bundle0) {
            return null;
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
        public void cancelNotification(Bundle bundle0) {
        }

        @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle extraCommand(String s, Bundle bundle0, IBinder iBinder0) {
            return null;
        }

        @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle getActiveNotifications() {
            return null;
        }

        @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle getSmallIconBitmap() {
            return null;
        }

        @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
        public int getSmallIconId() {
            return 0;
        }

        @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle notifyNotificationWithChannel(Bundle bundle0) {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ITrustedWebActivityService {
        static class Proxy implements ITrustedWebActivityService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
            public Bundle areNotificationsEnabled(Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(6, parcel0, parcel1, 0);
                    parcel1.readException();
                    return (Bundle)_Parcel.readTypedObject(parcel1, Bundle.CREATOR);
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
            public void cancelNotification(Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
            public Bundle extraCommand(String s, Bundle bundle0, IBinder iBinder0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    parcel0.writeString(s);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    parcel0.writeStrongBinder(iBinder0);
                    this.mRemote.transact(9, parcel0, parcel1, 0);
                    parcel1.readException();
                    return (Bundle)_Parcel.readTypedObject(parcel1, Bundle.CREATOR);
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
            public Bundle getActiveNotifications() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    this.mRemote.transact(5, parcel0, parcel1, 0);
                    parcel1.readException();
                    return (Bundle)_Parcel.readTypedObject(parcel1, Bundle.CREATOR);
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "android.support.customtabs.trusted.ITrustedWebActivityService";
            }

            @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
            public Bundle getSmallIconBitmap() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    this.mRemote.transact(7, parcel0, parcel1, 0);
                    parcel1.readException();
                    return (Bundle)_Parcel.readTypedObject(parcel1, Bundle.CREATOR);
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
            public int getSmallIconId() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
            public Bundle notifyNotificationWithChannel(Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                    return (Bundle)_Parcel.readTypedObject(parcel1, Bundle.CREATOR);
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_areNotificationsEnabled = 6;
        static final int TRANSACTION_cancelNotification = 3;
        static final int TRANSACTION_extraCommand = 9;
        static final int TRANSACTION_getActiveNotifications = 5;
        static final int TRANSACTION_getSmallIconBitmap = 7;
        static final int TRANSACTION_getSmallIconId = 4;
        static final int TRANSACTION_notifyNotificationWithChannel = 2;

        public Stub() {
            this.attachInterface(this, "android.support.customtabs.trusted.ITrustedWebActivityService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ITrustedWebActivityService asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
            return iInterface0 != null && iInterface0 instanceof ITrustedWebActivityService ? ((ITrustedWebActivityService)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
            }
            if(v == 0x5F4E5446) {
                parcel1.writeString("android.support.customtabs.trusted.ITrustedWebActivityService");
                return true;
            }
            switch(v) {
                case 2: {
                    Bundle bundle0 = this.notifyNotificationWithChannel(((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    _Parcel.writeTypedObject(parcel1, bundle0, 1);
                    return true;
                }
                case 3: {
                    this.cancelNotification(((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    return true;
                }
                case 4: {
                    int v2 = this.getSmallIconId();
                    parcel1.writeNoException();
                    parcel1.writeInt(v2);
                    return true;
                }
                case 5: {
                    Bundle bundle1 = this.getActiveNotifications();
                    parcel1.writeNoException();
                    _Parcel.writeTypedObject(parcel1, bundle1, 1);
                    return true;
                }
                case 6: {
                    Bundle bundle2 = this.areNotificationsEnabled(((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    _Parcel.writeTypedObject(parcel1, bundle2, 1);
                    return true;
                }
                case 7: {
                    Bundle bundle3 = this.getSmallIconBitmap();
                    parcel1.writeNoException();
                    _Parcel.writeTypedObject(parcel1, bundle3, 1);
                    return true;
                }
                case 9: {
                    Bundle bundle4 = this.extraCommand(parcel0.readString(), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)), parcel0.readStrongBinder());
                    parcel1.writeNoException();
                    _Parcel.writeTypedObject(parcel1, bundle4, 1);
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
        ITrustedWebActivityService.DESCRIPTOR = "android.support.customtabs.trusted.ITrustedWebActivityService";
    }

    Bundle areNotificationsEnabled(Bundle arg1);

    void cancelNotification(Bundle arg1);

    Bundle extraCommand(String arg1, Bundle arg2, IBinder arg3);

    Bundle getActiveNotifications();

    Bundle getSmallIconBitmap();

    int getSmallIconId();

    Bundle notifyNotificationWithChannel(Bundle arg1);
}

