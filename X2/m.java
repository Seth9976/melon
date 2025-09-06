package X2;

import Ua.h;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.os.ResultReceiver;
import androidx.appcompat.app.o;
import androidx.media.MediaBrowserServiceCompat;

public final class m implements Runnable {
    public final int a;
    public final p b;
    public final String c;
    public final ResultReceiver d;
    public final h e;

    public m(h h0, p p0, String s, Bundle bundle0, ResultReceiver resultReceiver0) {
        this.a = 1;
        super();
        this.e = h0;
        this.b = p0;
        this.c = s;
        this.d = resultReceiver0;
    }

    public m(h h0, p p0, String s, ResultReceiver resultReceiver0) {
        this.a = 0;
        super();
        this.e = h0;
        this.b = p0;
        this.c = s;
        this.d = resultReceiver0;
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            IBinder iBinder0 = this.b.a.getBinder();
            if(((a)((MediaBrowserServiceCompat)this.e.a).e.get(iBinder0)) == null) {
                o.A("search for callback that isn\'t registered query=", this.c, "MBServiceCompat");
                return;
            }
            this.d.send(-1, null);
            return;
        }
        IBinder iBinder1 = this.b.a.getBinder();
        if(((a)((MediaBrowserServiceCompat)this.e.a).e.get(iBinder1)) == null) {
            o.A("getMediaItem for callback that isn\'t registered id=", this.c, "MBServiceCompat");
            return;
        }
        this.d.send(-1, null);
    }
}

