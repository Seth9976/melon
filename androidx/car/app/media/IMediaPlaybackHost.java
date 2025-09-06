package androidx.car.app.media;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.car.app.serialization.Bundleable;

public interface IMediaPlaybackHost extends IInterface {
    public static class Default implements IMediaPlaybackHost {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // androidx.car.app.media.IMediaPlaybackHost
        public void registerMediaSessionToken(Bundleable bundleable0) {
        }
    }

    public static abstract class Stub extends Binder implements IMediaPlaybackHost {
        static class Proxy implements IMediaPlaybackHost {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "androidx.car.app.media.IMediaPlaybackHost";
            }

            @Override  // androidx.car.app.media.IMediaPlaybackHost
            public void registerMediaSessionToken(Bundleable bundleable0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.media.IMediaPlaybackHost");
                    if(bundleable0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        bundleable0.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_registerMediaSessionToken = 1;

        public Stub() {
            this.attachInterface(this, "androidx.car.app.media.IMediaPlaybackHost");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IMediaPlaybackHost asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("androidx.car.app.media.IMediaPlaybackHost");
            return iInterface0 != null && iInterface0 instanceof IMediaPlaybackHost ? ((IMediaPlaybackHost)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("androidx.car.app.media.IMediaPlaybackHost");
            }
            switch(v) {
                case 1: {
                    this.registerMediaSessionToken(((Bundleable)(parcel0.readInt() == 0 ? null : Bundleable.CREATOR.createFromParcel(parcel0))));
                    parcel1.writeNoException();
                    return true;
                }
                case 0x5F4E5446: {
                    parcel1.writeString("androidx.car.app.media.IMediaPlaybackHost");
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
        IMediaPlaybackHost.DESCRIPTOR = "androidx.car.app.media.IMediaPlaybackHost";
    }

    void registerMediaSessionToken(Bundleable arg1);
}

