package androidx.car.app.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.car.app.IOnDoneCallback;

public interface IOnSelectedListener extends IInterface {
    public static class Default implements IOnSelectedListener {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // androidx.car.app.model.IOnSelectedListener
        public void onSelected(int v, IOnDoneCallback iOnDoneCallback0) {
        }
    }

    public static abstract class Stub extends Binder implements IOnSelectedListener {
        static class Proxy implements IOnSelectedListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "androidx.car.app.model.IOnSelectedListener";
            }

            @Override  // androidx.car.app.model.IOnSelectedListener
            public void onSelected(int v, IOnDoneCallback iOnDoneCallback0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.model.IOnSelectedListener");
                    parcel0.writeInt(v);
                    parcel0.writeStrongInterface(iOnDoneCallback0);
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_onSelected = 2;

        public Stub() {
            this.attachInterface(this, "androidx.car.app.model.IOnSelectedListener");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IOnSelectedListener asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("androidx.car.app.model.IOnSelectedListener");
            return iInterface0 != null && iInterface0 instanceof IOnSelectedListener ? ((IOnSelectedListener)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("androidx.car.app.model.IOnSelectedListener");
            }
            switch(v) {
                case 2: {
                    this.onSelected(parcel0.readInt(), androidx.car.app.IOnDoneCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    return true;
                }
                case 0x5F4E5446: {
                    parcel1.writeString("androidx.car.app.model.IOnSelectedListener");
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
        IOnSelectedListener.DESCRIPTOR = "androidx.car.app.model.IOnSelectedListener";
    }

    void onSelected(int arg1, IOnDoneCallback arg2);
}

