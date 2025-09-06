package androidx.car.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.car.app.serialization.Bundleable;
import d5.f;

public interface ICarApp extends IInterface {
    public static class Default implements ICarApp {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // androidx.car.app.ICarApp
        public void getAppInfo(IOnDoneCallback iOnDoneCallback0) {
        }

        @Override  // androidx.car.app.ICarApp
        public void getManager(String s, IOnDoneCallback iOnDoneCallback0) {
        }

        @Override  // androidx.car.app.ICarApp
        public void onAppCreate(ICarHost iCarHost0, Intent intent0, Configuration configuration0, IOnDoneCallback iOnDoneCallback0) {
        }

        @Override  // androidx.car.app.ICarApp
        public void onAppPause(IOnDoneCallback iOnDoneCallback0) {
        }

        @Override  // androidx.car.app.ICarApp
        public void onAppResume(IOnDoneCallback iOnDoneCallback0) {
        }

        @Override  // androidx.car.app.ICarApp
        public void onAppStart(IOnDoneCallback iOnDoneCallback0) {
        }

        @Override  // androidx.car.app.ICarApp
        public void onAppStop(IOnDoneCallback iOnDoneCallback0) {
        }

        @Override  // androidx.car.app.ICarApp
        public void onConfigurationChanged(Configuration configuration0, IOnDoneCallback iOnDoneCallback0) {
        }

        @Override  // androidx.car.app.ICarApp
        public void onHandshakeCompleted(Bundleable bundleable0, IOnDoneCallback iOnDoneCallback0) {
        }

        @Override  // androidx.car.app.ICarApp
        public void onNewIntent(Intent intent0, IOnDoneCallback iOnDoneCallback0) {
        }
    }

    public static abstract class Stub extends Binder implements ICarApp {
        static class Proxy implements ICarApp {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // androidx.car.app.ICarApp
            public void getAppInfo(IOnDoneCallback iOnDoneCallback0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.ICarApp");
                    parcel0.writeStrongInterface(iOnDoneCallback0);
                    this.mRemote.transact(10, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "androidx.car.app.ICarApp";
            }

            @Override  // androidx.car.app.ICarApp
            public void getManager(String s, IOnDoneCallback iOnDoneCallback0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.ICarApp");
                    parcel0.writeString(s);
                    parcel0.writeStrongInterface(iOnDoneCallback0);
                    this.mRemote.transact(9, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.ICarApp
            public void onAppCreate(ICarHost iCarHost0, Intent intent0, Configuration configuration0, IOnDoneCallback iOnDoneCallback0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.ICarApp");
                    parcel0.writeStrongInterface(iCarHost0);
                    f.f(parcel0, intent0);
                    f.f(parcel0, configuration0);
                    parcel0.writeStrongInterface(iOnDoneCallback0);
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.ICarApp
            public void onAppPause(IOnDoneCallback iOnDoneCallback0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.ICarApp");
                    parcel0.writeStrongInterface(iOnDoneCallback0);
                    this.mRemote.transact(5, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.ICarApp
            public void onAppResume(IOnDoneCallback iOnDoneCallback0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.ICarApp");
                    parcel0.writeStrongInterface(iOnDoneCallback0);
                    this.mRemote.transact(4, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.ICarApp
            public void onAppStart(IOnDoneCallback iOnDoneCallback0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.ICarApp");
                    parcel0.writeStrongInterface(iOnDoneCallback0);
                    this.mRemote.transact(3, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.ICarApp
            public void onAppStop(IOnDoneCallback iOnDoneCallback0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.ICarApp");
                    parcel0.writeStrongInterface(iOnDoneCallback0);
                    this.mRemote.transact(6, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.ICarApp
            public void onConfigurationChanged(Configuration configuration0, IOnDoneCallback iOnDoneCallback0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.ICarApp");
                    f.f(parcel0, configuration0);
                    parcel0.writeStrongInterface(iOnDoneCallback0);
                    this.mRemote.transact(8, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.ICarApp
            public void onHandshakeCompleted(Bundleable bundleable0, IOnDoneCallback iOnDoneCallback0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.ICarApp");
                    f.f(parcel0, bundleable0);
                    parcel0.writeStrongInterface(iOnDoneCallback0);
                    this.mRemote.transact(11, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.car.app.ICarApp
            public void onNewIntent(Intent intent0, IOnDoneCallback iOnDoneCallback0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.car.app.ICarApp");
                    f.f(parcel0, intent0);
                    parcel0.writeStrongInterface(iOnDoneCallback0);
                    this.mRemote.transact(7, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_getAppInfo = 10;
        static final int TRANSACTION_getManager = 9;
        static final int TRANSACTION_onAppCreate = 2;
        static final int TRANSACTION_onAppPause = 5;
        static final int TRANSACTION_onAppResume = 4;
        static final int TRANSACTION_onAppStart = 3;
        static final int TRANSACTION_onAppStop = 6;
        static final int TRANSACTION_onConfigurationChanged = 8;
        static final int TRANSACTION_onHandshakeCompleted = 11;
        static final int TRANSACTION_onNewIntent = 7;

        public Stub() {
            this.attachInterface(this, "androidx.car.app.ICarApp");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarApp asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("androidx.car.app.ICarApp");
            return iInterface0 != null && iInterface0 instanceof ICarApp ? ((ICarApp)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("androidx.car.app.ICarApp");
            }
            if(v == 0x5F4E5446) {
                parcel1.writeString("androidx.car.app.ICarApp");
                return true;
            }
            switch(v) {
                case 2: {
                    this.onAppCreate(androidx.car.app.ICarHost.Stub.asInterface(parcel0.readStrongBinder()), ((Intent)f.e(parcel0, Intent.CREATOR)), ((Configuration)f.e(parcel0, Configuration.CREATOR)), androidx.car.app.IOnDoneCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    return true;
                }
                case 3: {
                    this.onAppStart(androidx.car.app.IOnDoneCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    return true;
                }
                case 4: {
                    this.onAppResume(androidx.car.app.IOnDoneCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    return true;
                }
                case 5: {
                    this.onAppPause(androidx.car.app.IOnDoneCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    return true;
                }
                case 6: {
                    this.onAppStop(androidx.car.app.IOnDoneCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    return true;
                }
                case 7: {
                    this.onNewIntent(((Intent)f.e(parcel0, Intent.CREATOR)), androidx.car.app.IOnDoneCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    return true;
                }
                case 8: {
                    this.onConfigurationChanged(((Configuration)f.e(parcel0, Configuration.CREATOR)), androidx.car.app.IOnDoneCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    return true;
                }
                case 9: {
                    this.getManager(parcel0.readString(), androidx.car.app.IOnDoneCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    return true;
                }
                case 10: {
                    this.getAppInfo(androidx.car.app.IOnDoneCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    return true;
                }
                case 11: {
                    this.onHandshakeCompleted(((Bundleable)f.e(parcel0, Bundleable.CREATOR)), androidx.car.app.IOnDoneCallback.Stub.asInterface(parcel0.readStrongBinder()));
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
        ICarApp.DESCRIPTOR = "androidx.car.app.ICarApp";
    }

    void getAppInfo(IOnDoneCallback arg1);

    void getManager(String arg1, IOnDoneCallback arg2);

    void onAppCreate(ICarHost arg1, Intent arg2, Configuration arg3, IOnDoneCallback arg4);

    void onAppPause(IOnDoneCallback arg1);

    void onAppResume(IOnDoneCallback arg1);

    void onAppStart(IOnDoneCallback arg1);

    void onAppStop(IOnDoneCallback arg1);

    void onConfigurationChanged(Configuration arg1, IOnDoneCallback arg2);

    void onHandshakeCompleted(Bundleable arg1, IOnDoneCallback arg2);

    void onNewIntent(Intent arg1, IOnDoneCallback arg2);
}

