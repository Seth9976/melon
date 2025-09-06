package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.List;

public interface ICustomTabsService extends IInterface {
    public static class Default implements ICustomTabsService {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public Bundle extraCommand(String s, Bundle bundle0) {
            return null;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean isEngagementSignalsApiAvailable(ICustomTabsCallback iCustomTabsCallback0, Bundle bundle0) {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean mayLaunchUrl(ICustomTabsCallback iCustomTabsCallback0, Uri uri0, Bundle bundle0, List list0) {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean newSession(ICustomTabsCallback iCustomTabsCallback0) {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean newSessionWithExtras(ICustomTabsCallback iCustomTabsCallback0, Bundle bundle0) {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public int postMessage(ICustomTabsCallback iCustomTabsCallback0, String s, Bundle bundle0) {
            return 0;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean receiveFile(ICustomTabsCallback iCustomTabsCallback0, Uri uri0, int v, Bundle bundle0) {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean requestPostMessageChannel(ICustomTabsCallback iCustomTabsCallback0, Uri uri0) {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean requestPostMessageChannelWithExtras(ICustomTabsCallback iCustomTabsCallback0, Uri uri0, Bundle bundle0) {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean setEngagementSignalsCallback(ICustomTabsCallback iCustomTabsCallback0, IBinder iBinder0, Bundle bundle0) {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean updateVisuals(ICustomTabsCallback iCustomTabsCallback0, Bundle bundle0) {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean validateRelationship(ICustomTabsCallback iCustomTabsCallback0, int v, Uri uri0, Bundle bundle0) {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean warmup(long v) {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements ICustomTabsService {
        static class Proxy implements ICustomTabsService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // android.support.customtabs.ICustomTabsService
            public Bundle extraCommand(String s, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcel0.writeString(s);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
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
                return "android.support.customtabs.ICustomTabsService";
            }

            @Override  // android.support.customtabs.ICustomTabsService
            public boolean isEngagementSignalsApiAvailable(ICustomTabsCallback iCustomTabsCallback0, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcel0.writeStrongInterface(iCustomTabsCallback0);
                    boolean z = false;
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(13, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        z = true;
                    }
                    return z;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsService
            public boolean mayLaunchUrl(ICustomTabsCallback iCustomTabsCallback0, Uri uri0, Bundle bundle0, List list0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcel0.writeStrongInterface(iCustomTabsCallback0);
                    boolean z = false;
                    _Parcel.writeTypedObject(parcel0, uri0, 0);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    _Parcel.writeTypedList(parcel0, list0, 0);
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        z = true;
                    }
                    return z;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsService
            public boolean newSession(ICustomTabsCallback iCustomTabsCallback0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcel0.writeStrongInterface(iCustomTabsCallback0);
                    boolean z = false;
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        z = true;
                    }
                    return z;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsService
            public boolean newSessionWithExtras(ICustomTabsCallback iCustomTabsCallback0, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcel0.writeStrongInterface(iCustomTabsCallback0);
                    boolean z = false;
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(10, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        z = true;
                    }
                    return z;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsService
            public int postMessage(ICustomTabsCallback iCustomTabsCallback0, String s, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcel0.writeStrongInterface(iCustomTabsCallback0);
                    parcel0.writeString(s);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(8, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsService
            public boolean receiveFile(ICustomTabsCallback iCustomTabsCallback0, Uri uri0, int v, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcel0.writeStrongInterface(iCustomTabsCallback0);
                    boolean z = false;
                    _Parcel.writeTypedObject(parcel0, uri0, 0);
                    parcel0.writeInt(v);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(12, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        z = true;
                    }
                    return z;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsService
            public boolean requestPostMessageChannel(ICustomTabsCallback iCustomTabsCallback0, Uri uri0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcel0.writeStrongInterface(iCustomTabsCallback0);
                    boolean z = false;
                    _Parcel.writeTypedObject(parcel0, uri0, 0);
                    this.mRemote.transact(7, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        z = true;
                    }
                    return z;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsService
            public boolean requestPostMessageChannelWithExtras(ICustomTabsCallback iCustomTabsCallback0, Uri uri0, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcel0.writeStrongInterface(iCustomTabsCallback0);
                    boolean z = false;
                    _Parcel.writeTypedObject(parcel0, uri0, 0);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(11, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        z = true;
                    }
                    return z;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsService
            public boolean setEngagementSignalsCallback(ICustomTabsCallback iCustomTabsCallback0, IBinder iBinder0, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcel0.writeStrongInterface(iCustomTabsCallback0);
                    parcel0.writeStrongBinder(iBinder0);
                    boolean z = false;
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(14, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        z = true;
                    }
                    return z;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsService
            public boolean updateVisuals(ICustomTabsCallback iCustomTabsCallback0, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcel0.writeStrongInterface(iCustomTabsCallback0);
                    boolean z = false;
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(6, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        z = true;
                    }
                    return z;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsService
            public boolean validateRelationship(ICustomTabsCallback iCustomTabsCallback0, int v, Uri uri0, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcel0.writeStrongInterface(iCustomTabsCallback0);
                    parcel0.writeInt(v);
                    boolean z = false;
                    _Parcel.writeTypedObject(parcel0, uri0, 0);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(9, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        z = true;
                    }
                    return z;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsService
            public boolean warmup(long v) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcel0.writeLong(v);
                    boolean z = false;
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        z = true;
                    }
                    return z;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_extraCommand = 5;
        static final int TRANSACTION_isEngagementSignalsApiAvailable = 13;
        static final int TRANSACTION_mayLaunchUrl = 4;
        static final int TRANSACTION_newSession = 3;
        static final int TRANSACTION_newSessionWithExtras = 10;
        static final int TRANSACTION_postMessage = 8;
        static final int TRANSACTION_receiveFile = 12;
        static final int TRANSACTION_requestPostMessageChannel = 7;
        static final int TRANSACTION_requestPostMessageChannelWithExtras = 11;
        static final int TRANSACTION_setEngagementSignalsCallback = 14;
        static final int TRANSACTION_updateVisuals = 6;
        static final int TRANSACTION_validateRelationship = 9;
        static final int TRANSACTION_warmup = 2;

        public Stub() {
            this.attachInterface(this, "android.support.customtabs.ICustomTabsService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICustomTabsService asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("android.support.customtabs.ICustomTabsService");
            return iInterface0 != null && iInterface0 instanceof ICustomTabsService ? ((ICustomTabsService)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("android.support.customtabs.ICustomTabsService");
            }
            if(v == 0x5F4E5446) {
                parcel1.writeString("android.support.customtabs.ICustomTabsService");
                return true;
            }
            switch(v) {
                case 2: {
                    boolean z = this.warmup(parcel0.readLong());
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z));
                    return true;
                }
                case 3: {
                    boolean z1 = this.newSession(android.support.customtabs.ICustomTabsCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z1));
                    return true;
                }
                case 4: {
                    ICustomTabsCallback iCustomTabsCallback0 = android.support.customtabs.ICustomTabsCallback.Stub.asInterface(parcel0.readStrongBinder());
                    Uri uri0 = (Uri)_Parcel.readTypedObject(parcel0, Uri.CREATOR);
                    Parcelable.Creator parcelable$Creator0 = Bundle.CREATOR;
                    boolean z2 = this.mayLaunchUrl(iCustomTabsCallback0, uri0, ((Bundle)_Parcel.readTypedObject(parcel0, parcelable$Creator0)), parcel0.createTypedArrayList(parcelable$Creator0));
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z2));
                    return true;
                }
                case 5: {
                    Bundle bundle0 = this.extraCommand(parcel0.readString(), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    _Parcel.writeTypedObject(parcel1, bundle0, 1);
                    return true;
                }
                case 6: {
                    boolean z3 = this.updateVisuals(android.support.customtabs.ICustomTabsCallback.Stub.asInterface(parcel0.readStrongBinder()), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z3));
                    return true;
                }
                case 7: {
                    boolean z4 = this.requestPostMessageChannel(android.support.customtabs.ICustomTabsCallback.Stub.asInterface(parcel0.readStrongBinder()), ((Uri)_Parcel.readTypedObject(parcel0, Uri.CREATOR)));
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z4));
                    return true;
                }
                case 8: {
                    int v2 = this.postMessage(android.support.customtabs.ICustomTabsCallback.Stub.asInterface(parcel0.readStrongBinder()), parcel0.readString(), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    parcel1.writeInt(v2);
                    return true;
                }
                case 9: {
                    boolean z5 = this.validateRelationship(android.support.customtabs.ICustomTabsCallback.Stub.asInterface(parcel0.readStrongBinder()), parcel0.readInt(), ((Uri)_Parcel.readTypedObject(parcel0, Uri.CREATOR)), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z5));
                    return true;
                }
                case 10: {
                    boolean z6 = this.newSessionWithExtras(android.support.customtabs.ICustomTabsCallback.Stub.asInterface(parcel0.readStrongBinder()), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z6));
                    return true;
                }
                case 11: {
                    boolean z7 = this.requestPostMessageChannelWithExtras(android.support.customtabs.ICustomTabsCallback.Stub.asInterface(parcel0.readStrongBinder()), ((Uri)_Parcel.readTypedObject(parcel0, Uri.CREATOR)), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z7));
                    return true;
                }
                case 12: {
                    boolean z8 = this.receiveFile(android.support.customtabs.ICustomTabsCallback.Stub.asInterface(parcel0.readStrongBinder()), ((Uri)_Parcel.readTypedObject(parcel0, Uri.CREATOR)), parcel0.readInt(), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z8));
                    return true;
                }
                case 13: {
                    boolean z9 = this.isEngagementSignalsApiAvailable(android.support.customtabs.ICustomTabsCallback.Stub.asInterface(parcel0.readStrongBinder()), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z9));
                    return true;
                }
                case 14: {
                    boolean z10 = this.setEngagementSignalsCallback(android.support.customtabs.ICustomTabsCallback.Stub.asInterface(parcel0.readStrongBinder()), parcel0.readStrongBinder(), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z10));
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

        private static void writeTypedList(Parcel parcel0, List list0, int v) {
            if(list0 == null) {
                parcel0.writeInt(-1);
                return;
            }
            int v1 = list0.size();
            parcel0.writeInt(v1);
            for(int v2 = 0; v2 < v1; ++v2) {
                _Parcel.writeTypedObject(parcel0, ((Parcelable)list0.get(v2)), v);
            }
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
        ICustomTabsService.DESCRIPTOR = "android.support.customtabs.ICustomTabsService";
    }

    Bundle extraCommand(String arg1, Bundle arg2);

    boolean isEngagementSignalsApiAvailable(ICustomTabsCallback arg1, Bundle arg2);

    boolean mayLaunchUrl(ICustomTabsCallback arg1, Uri arg2, Bundle arg3, List arg4);

    boolean newSession(ICustomTabsCallback arg1);

    boolean newSessionWithExtras(ICustomTabsCallback arg1, Bundle arg2);

    int postMessage(ICustomTabsCallback arg1, String arg2, Bundle arg3);

    boolean receiveFile(ICustomTabsCallback arg1, Uri arg2, int arg3, Bundle arg4);

    boolean requestPostMessageChannel(ICustomTabsCallback arg1, Uri arg2);

    boolean requestPostMessageChannelWithExtras(ICustomTabsCallback arg1, Uri arg2, Bundle arg3);

    boolean setEngagementSignalsCallback(ICustomTabsCallback arg1, IBinder arg2, Bundle arg3);

    boolean updateVisuals(ICustomTabsCallback arg1, Bundle arg2);

    boolean validateRelationship(ICustomTabsCallback arg1, int arg2, Uri arg3, Bundle arg4);

    boolean warmup(long arg1);
}

