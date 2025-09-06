package androidx.car.app.media;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface ICarAudioCallback extends IInterface {
    public static class Default implements ICarAudioCallback {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // androidx.car.app.media.ICarAudioCallback
        public void onStopRecording() {
        }
    }

    public static abstract class Stub extends Binder implements ICarAudioCallback {
        static class Proxy implements ICarAudioCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "androidx.car.app.media.ICarAudioCallback";
            }

            @Override  // androidx.car.app.media.ICarAudioCallback
            public void onStopRecording() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.media.ICarAudioCallback");
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_onStopRecording = 1;

        public Stub() {
            this.attachInterface(this, "androidx.car.app.media.ICarAudioCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarAudioCallback asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("androidx.car.app.media.ICarAudioCallback");
            return iInterface0 != null && iInterface0 instanceof ICarAudioCallback ? ((ICarAudioCallback)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("androidx.car.app.media.ICarAudioCallback");
            }
            switch(v) {
                case 1: {
                    this.onStopRecording();
                    parcel1.writeNoException();
                    return true;
                }
                case 0x5F4E5446: {
                    parcel1.writeString("androidx.car.app.media.ICarAudioCallback");
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
        ICarAudioCallback.DESCRIPTOR = "androidx.car.app.media.ICarAudioCallback";
    }

    void onStopRecording();
}

