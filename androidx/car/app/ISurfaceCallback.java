package androidx.car.app;

import android.graphics.Rect;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.car.app.serialization.Bundleable;
import h7.u0;

public interface ISurfaceCallback extends IInterface {
    public static class Default implements ISurfaceCallback {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // androidx.car.app.ISurfaceCallback
        public void onClick(float f, float f1) {
        }

        @Override  // androidx.car.app.ISurfaceCallback
        public void onFling(float f, float f1) {
        }

        @Override  // androidx.car.app.ISurfaceCallback
        public void onScale(float f, float f1, float f2) {
        }

        @Override  // androidx.car.app.ISurfaceCallback
        public void onScroll(float f, float f1) {
        }

        @Override  // androidx.car.app.ISurfaceCallback
        public void onStableAreaChanged(Rect rect0, IOnDoneCallback iOnDoneCallback0) {
        }

        @Override  // androidx.car.app.ISurfaceCallback
        public void onSurfaceAvailable(Bundleable bundleable0, IOnDoneCallback iOnDoneCallback0) {
        }

        @Override  // androidx.car.app.ISurfaceCallback
        public void onSurfaceDestroyed(Bundleable bundleable0, IOnDoneCallback iOnDoneCallback0) {
        }

        @Override  // androidx.car.app.ISurfaceCallback
        public void onVisibleAreaChanged(Rect rect0, IOnDoneCallback iOnDoneCallback0) {
        }
    }

    public static abstract class Stub extends Binder implements ISurfaceCallback {
        static class Proxy implements ISurfaceCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "androidx.car.app.ISurfaceCallback";
            }

            @Override  // androidx.car.app.ISurfaceCallback
            public void onClick(float f, float f1) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.ISurfaceCallback");
                    parcel0.writeFloat(f);
                    parcel0.writeFloat(f1);
                    this.mRemote.transact(9, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.ISurfaceCallback
            public void onFling(float f, float f1) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.ISurfaceCallback");
                    parcel0.writeFloat(f);
                    parcel0.writeFloat(f1);
                    this.mRemote.transact(7, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.ISurfaceCallback
            public void onScale(float f, float f1, float f2) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.ISurfaceCallback");
                    parcel0.writeFloat(f);
                    parcel0.writeFloat(f1);
                    parcel0.writeFloat(f2);
                    this.mRemote.transact(8, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.ISurfaceCallback
            public void onScroll(float f, float f1) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.ISurfaceCallback");
                    parcel0.writeFloat(f);
                    parcel0.writeFloat(f1);
                    this.mRemote.transact(6, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.ISurfaceCallback
            public void onStableAreaChanged(Rect rect0, IOnDoneCallback iOnDoneCallback0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.ISurfaceCallback");
                    u0.g(parcel0, rect0);
                    parcel0.writeStrongInterface(iOnDoneCallback0);
                    this.mRemote.transact(4, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.ISurfaceCallback
            public void onSurfaceAvailable(Bundleable bundleable0, IOnDoneCallback iOnDoneCallback0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.ISurfaceCallback");
                    u0.g(parcel0, bundleable0);
                    parcel0.writeStrongInterface(iOnDoneCallback0);
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.ISurfaceCallback
            public void onSurfaceDestroyed(Bundleable bundleable0, IOnDoneCallback iOnDoneCallback0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.ISurfaceCallback");
                    u0.g(parcel0, bundleable0);
                    parcel0.writeStrongInterface(iOnDoneCallback0);
                    this.mRemote.transact(5, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.ISurfaceCallback
            public void onVisibleAreaChanged(Rect rect0, IOnDoneCallback iOnDoneCallback0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.ISurfaceCallback");
                    u0.g(parcel0, rect0);
                    parcel0.writeStrongInterface(iOnDoneCallback0);
                    this.mRemote.transact(3, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_onClick = 9;
        static final int TRANSACTION_onFling = 7;
        static final int TRANSACTION_onScale = 8;
        static final int TRANSACTION_onScroll = 6;
        static final int TRANSACTION_onStableAreaChanged = 4;
        static final int TRANSACTION_onSurfaceAvailable = 2;
        static final int TRANSACTION_onSurfaceDestroyed = 5;
        static final int TRANSACTION_onVisibleAreaChanged = 3;

        public Stub() {
            this.attachInterface(this, "androidx.car.app.ISurfaceCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ISurfaceCallback asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("androidx.car.app.ISurfaceCallback");
            return iInterface0 != null && iInterface0 instanceof ISurfaceCallback ? ((ISurfaceCallback)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("androidx.car.app.ISurfaceCallback");
            }
            if(v == 0x5F4E5446) {
                parcel1.writeString("androidx.car.app.ISurfaceCallback");
                return true;
            }
            Object object0 = null;
            switch(v) {
                case 2: {
                    Parcelable.Creator parcelable$Creator0 = Bundleable.CREATOR;
                    if(parcel0.readInt() != 0) {
                        object0 = parcelable$Creator0.createFromParcel(parcel0);
                    }
                    this.onSurfaceAvailable(((Bundleable)object0), androidx.car.app.IOnDoneCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    return true;
                }
                case 3: {
                    Parcelable.Creator parcelable$Creator1 = Rect.CREATOR;
                    if(parcel0.readInt() != 0) {
                        object0 = parcelable$Creator1.createFromParcel(parcel0);
                    }
                    this.onVisibleAreaChanged(((Rect)object0), androidx.car.app.IOnDoneCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    return true;
                }
                case 4: {
                    Parcelable.Creator parcelable$Creator2 = Rect.CREATOR;
                    if(parcel0.readInt() != 0) {
                        object0 = parcelable$Creator2.createFromParcel(parcel0);
                    }
                    this.onStableAreaChanged(((Rect)object0), androidx.car.app.IOnDoneCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    return true;
                }
                case 5: {
                    Parcelable.Creator parcelable$Creator3 = Bundleable.CREATOR;
                    if(parcel0.readInt() != 0) {
                        object0 = parcelable$Creator3.createFromParcel(parcel0);
                    }
                    this.onSurfaceDestroyed(((Bundleable)object0), androidx.car.app.IOnDoneCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    return true;
                }
                case 6: {
                    this.onScroll(parcel0.readFloat(), parcel0.readFloat());
                    return true;
                }
                case 7: {
                    this.onFling(parcel0.readFloat(), parcel0.readFloat());
                    return true;
                }
                case 8: {
                    this.onScale(parcel0.readFloat(), parcel0.readFloat(), parcel0.readFloat());
                    return true;
                }
                case 9: {
                    this.onClick(parcel0.readFloat(), parcel0.readFloat());
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
        ISurfaceCallback.DESCRIPTOR = "androidx.car.app.ISurfaceCallback";
    }

    void onClick(float arg1, float arg2);

    void onFling(float arg1, float arg2);

    void onScale(float arg1, float arg2, float arg3);

    void onScroll(float arg1, float arg2);

    void onStableAreaChanged(Rect arg1, IOnDoneCallback arg2);

    void onSurfaceAvailable(Bundleable arg1, IOnDoneCallback arg2);

    void onSurfaceDestroyed(Bundleable arg1, IOnDoneCallback arg2);

    void onVisibleAreaChanged(Rect arg1, IOnDoneCallback arg2);
}

