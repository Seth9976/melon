package androidx.car.app.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.car.app.IOnDoneCallback;

public interface IOnCheckedChangeListener extends IInterface {
    public static class Default implements IOnCheckedChangeListener {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // androidx.car.app.model.IOnCheckedChangeListener
        public void onCheckedChange(boolean z, IOnDoneCallback iOnDoneCallback0) {
        }
    }

    public static abstract class Stub extends Binder implements IOnCheckedChangeListener {
        static class Proxy implements IOnCheckedChangeListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "androidx.car.app.model.IOnCheckedChangeListener";
            }

            @Override  // androidx.car.app.model.IOnCheckedChangeListener
            public void onCheckedChange(boolean z, IOnDoneCallback iOnDoneCallback0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.model.IOnCheckedChangeListener");
                    parcel0.writeInt(((int)z));
                    parcel0.writeStrongInterface(iOnDoneCallback0);
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_onCheckedChange = 2;

        public Stub() {
            this.attachInterface(this, "androidx.car.app.model.IOnCheckedChangeListener");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IOnCheckedChangeListener asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("androidx.car.app.model.IOnCheckedChangeListener");
            return iInterface0 != null && iInterface0 instanceof IOnCheckedChangeListener ? ((IOnCheckedChangeListener)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("androidx.car.app.model.IOnCheckedChangeListener");
            }
            switch(v) {
                case 2: {
                    this.onCheckedChange(parcel0.readInt() != 0, androidx.car.app.IOnDoneCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    return true;
                }
                case 0x5F4E5446: {
                    parcel1.writeString("androidx.car.app.model.IOnCheckedChangeListener");
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
        IOnCheckedChangeListener.DESCRIPTOR = "androidx.car.app.model.IOnCheckedChangeListener";
    }

    void onCheckedChange(boolean arg1, IOnDoneCallback arg2);
}

