package androidx.media3.session.legacy;

import P4.a;
import P4.d;
import android.os.Bundle;
import android.os.ResultReceiver;
import java.lang.ref.WeakReference;

class MediaControllerCompat.MediaControllerImplApi21.ExtraBinderRequestResultReceiver extends ResultReceiver {
    public WeakReference a;

    @Override  // android.os.ResultReceiver
    public final void onReceiveResult(int v, Bundle bundle0) {
        E e0 = (E)this.a.get();
        if(e0 != null && bundle0 != null) {
            synchronized(e0.b) {
                f f0 = P.C0(bundle0.getBinder("android.support.v4.media.session.EXTRA_BINDER"));
                synchronized(e0.e.a) {
                    e0.e.c = f0;
                    d d0 = a.s(bundle0);
                    __monitor_enter(e0.e.a);
                    e0.e.d = d0;
                }
                e0.a();
            }
        }
    }
}

