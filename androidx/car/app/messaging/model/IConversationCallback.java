package androidx.car.app.messaging.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.car.app.IOnDoneCallback;

public interface IConversationCallback extends IInterface {
    public static class Default implements IConversationCallback {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // androidx.car.app.messaging.model.IConversationCallback
        public void onMarkAsRead(IOnDoneCallback iOnDoneCallback0) {
        }

        @Override  // androidx.car.app.messaging.model.IConversationCallback
        public void onTextReply(IOnDoneCallback iOnDoneCallback0, String s) {
        }
    }

    public static abstract class Stub extends Binder implements IConversationCallback {
        static class Proxy implements IConversationCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "androidx.car.app.messaging.model.IConversationCallback";
            }

            @Override  // androidx.car.app.messaging.model.IConversationCallback
            public void onMarkAsRead(IOnDoneCallback iOnDoneCallback0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.messaging.model.IConversationCallback");
                    parcel0.writeStrongInterface(iOnDoneCallback0);
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.messaging.model.IConversationCallback
            public void onTextReply(IOnDoneCallback iOnDoneCallback0, String s) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.messaging.model.IConversationCallback");
                    parcel0.writeStrongInterface(iOnDoneCallback0);
                    parcel0.writeString(s);
                    this.mRemote.transact(3, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_onMarkAsRead = 2;
        static final int TRANSACTION_onTextReply = 3;

        public Stub() {
            this.attachInterface(this, "androidx.car.app.messaging.model.IConversationCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IConversationCallback asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("androidx.car.app.messaging.model.IConversationCallback");
            return iInterface0 != null && iInterface0 instanceof IConversationCallback ? ((IConversationCallback)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("androidx.car.app.messaging.model.IConversationCallback");
            }
            switch(v) {
                case 2: {
                    this.onMarkAsRead(androidx.car.app.IOnDoneCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    return true;
                }
                case 3: {
                    this.onTextReply(androidx.car.app.IOnDoneCallback.Stub.asInterface(parcel0.readStrongBinder()), parcel0.readString());
                    return true;
                }
                case 0x5F4E5446: {
                    parcel1.writeString("androidx.car.app.messaging.model.IConversationCallback");
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
        IConversationCallback.DESCRIPTOR = "androidx.car.app.messaging.model.IConversationCallback";
    }

    void onMarkAsRead(IOnDoneCallback arg1);

    void onTextReply(IOnDoneCallback arg1, String arg2);
}

