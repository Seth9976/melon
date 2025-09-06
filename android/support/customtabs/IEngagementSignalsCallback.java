package android.support.customtabs;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public interface IEngagementSignalsCallback extends IInterface {
    public static class Default implements IEngagementSignalsCallback {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // android.support.customtabs.IEngagementSignalsCallback
        public void onGreatestScrollPercentageIncreased(int v, Bundle bundle0) {
        }

        @Override  // android.support.customtabs.IEngagementSignalsCallback
        public void onSessionEnded(boolean z, Bundle bundle0) {
        }

        @Override  // android.support.customtabs.IEngagementSignalsCallback
        public void onVerticalScrollEvent(boolean z, Bundle bundle0) {
        }
    }

    public static abstract class Stub extends Binder implements IEngagementSignalsCallback {
        static class Proxy implements IEngagementSignalsCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.support.customtabs.IEngagementSignalsCallback";
            }

            @Override  // android.support.customtabs.IEngagementSignalsCallback
            public void onGreatestScrollPercentageIncreased(int v, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.IEngagementSignalsCallback");
                    parcel0.writeInt(v);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(3, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.IEngagementSignalsCallback
            public void onSessionEnded(boolean z, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.IEngagementSignalsCallback");
                    parcel0.writeInt(((int)z));
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(4, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.IEngagementSignalsCallback
            public void onVerticalScrollEvent(boolean z, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.IEngagementSignalsCallback");
                    parcel0.writeInt(((int)z));
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_onGreatestScrollPercentageIncreased = 3;
        static final int TRANSACTION_onSessionEnded = 4;
        static final int TRANSACTION_onVerticalScrollEvent = 2;

        public Stub() {
            this.attachInterface(this, "android.support.customtabs.IEngagementSignalsCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IEngagementSignalsCallback asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("android.support.customtabs.IEngagementSignalsCallback");
            return iInterface0 != null && iInterface0 instanceof IEngagementSignalsCallback ? ((IEngagementSignalsCallback)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("android.support.customtabs.IEngagementSignalsCallback");
            }
            boolean z = false;
            if(v == 0x5F4E5446) {
                parcel1.writeString("android.support.customtabs.IEngagementSignalsCallback");
                return true;
            }
            switch(v) {
                case 2: {
                    if(parcel0.readInt() != 0) {
                        z = true;
                    }
                    this.onVerticalScrollEvent(z, ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    return true;
                }
                case 3: {
                    this.onGreatestScrollPercentageIncreased(parcel0.readInt(), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    return true;
                }
                case 4: {
                    if(parcel0.readInt() != 0) {
                        z = true;
                    }
                    this.onSessionEnded(z, ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
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
        IEngagementSignalsCallback.DESCRIPTOR = "android.support.customtabs.IEngagementSignalsCallback";
    }

    void onGreatestScrollPercentageIncreased(int arg1, Bundle arg2);

    void onSessionEnded(boolean arg1, Bundle arg2);

    void onVerticalScrollEvent(boolean arg1, Bundle arg2);
}

