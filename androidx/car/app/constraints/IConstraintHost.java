package androidx.car.app.constraints;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface IConstraintHost extends IInterface {
    public static class Default implements IConstraintHost {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // androidx.car.app.constraints.IConstraintHost
        public int getContentLimit(int v) {
            return 0;
        }

        @Override  // androidx.car.app.constraints.IConstraintHost
        public boolean isAppDrivenRefreshEnabled() {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IConstraintHost {
        static class Proxy implements IConstraintHost {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // androidx.car.app.constraints.IConstraintHost
            public int getContentLimit(int v) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.constraints.IConstraintHost");
                    parcel0.writeInt(v);
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "androidx.car.app.constraints.IConstraintHost";
            }

            @Override  // androidx.car.app.constraints.IConstraintHost
            public boolean isAppDrivenRefreshEnabled() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.constraints.IConstraintHost");
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
        }

        static final int TRANSACTION_getContentLimit = 2;
        static final int TRANSACTION_isAppDrivenRefreshEnabled = 3;

        public Stub() {
            this.attachInterface(this, "androidx.car.app.constraints.IConstraintHost");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IConstraintHost asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("androidx.car.app.constraints.IConstraintHost");
            return iInterface0 != null && iInterface0 instanceof IConstraintHost ? ((IConstraintHost)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("androidx.car.app.constraints.IConstraintHost");
            }
            switch(v) {
                case 2: {
                    int v2 = this.getContentLimit(parcel0.readInt());
                    parcel1.writeNoException();
                    parcel1.writeInt(v2);
                    return true;
                }
                case 3: {
                    boolean z = this.isAppDrivenRefreshEnabled();
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z));
                    return true;
                }
                case 0x5F4E5446: {
                    parcel1.writeString("androidx.car.app.constraints.IConstraintHost");
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
        IConstraintHost.DESCRIPTOR = "androidx.car.app.constraints.IConstraintHost";
    }

    int getContentLimit(int arg1);

    boolean isAppDrivenRefreshEnabled();
}

