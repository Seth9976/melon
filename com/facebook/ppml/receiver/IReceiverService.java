package com.facebook.ppml.receiver;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public interface IReceiverService extends IInterface {
    public static class Default implements IReceiverService {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // com.facebook.ppml.receiver.IReceiverService
        public int sendEvents(Bundle bundle0) {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IReceiverService {
        static class Proxy implements IReceiverService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.facebook.ppml.receiver.IReceiverService";
            }

            @Override  // com.facebook.ppml.receiver.IReceiverService
            public int sendEvents(Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.facebook.ppml.receiver.IReceiverService");
                    _Parcel.access$100(parcel0, bundle0, 0);
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_sendEvents = 1;

        public Stub() {
            this.attachInterface(this, "com.facebook.ppml.receiver.IReceiverService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IReceiverService asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.facebook.ppml.receiver.IReceiverService");
            return iInterface0 != null && iInterface0 instanceof IReceiverService ? ((IReceiverService)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("com.facebook.ppml.receiver.IReceiverService");
            }
            switch(v) {
                case 1: {
                    int v2 = this.sendEvents(((Bundle)_Parcel.access$000(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    parcel1.writeInt(v2);
                    return true;
                }
                case 0x5F4E5446: {
                    parcel1.writeString("com.facebook.ppml.receiver.IReceiverService");
                    return true;
                }
                default: {
                    return super.onTransact(v, parcel0, parcel1, v1);
                }
            }
        }
    }

    public static class _Parcel {
        public static Object access$000(Parcel parcel0, Parcelable.Creator parcelable$Creator0) {
            return _Parcel.readTypedObject(parcel0, parcelable$Creator0);
        }

        public static void access$100(Parcel parcel0, Parcelable parcelable0, int v) {
            _Parcel.writeTypedObject(parcel0, parcelable0, v);
        }

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

    public static final String DESCRIPTOR = "com.facebook.ppml.receiver.IReceiverService";

    int sendEvents(Bundle arg1);
}

