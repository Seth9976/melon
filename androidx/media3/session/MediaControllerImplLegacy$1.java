package androidx.media3.session;

import M6.H;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

class MediaControllerImplLegacy.1 extends ResultReceiver {
    public final H a;

    public MediaControllerImplLegacy.1(Handler handler0, H h0) {
        this.a = h0;
        super(handler0);
    }

    @Override  // android.os.ResultReceiver
    public final void onReceiveResult(int v, Bundle bundle0) {
        if(bundle0 == null) {
            bundle0 = Bundle.EMPTY;
        }
        w1 w10 = new w1(v, bundle0);
        this.a.k(w10);
    }
}

