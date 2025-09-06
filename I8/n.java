package I8;

import Bb.e;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

public final class n extends ContentObserver {
    public final Context a;
    public final e b;
    public static final int c;

    public n(Context context0, Handler handler0) {
        super(handler0);
        this.a = context0;
        this.b = new e(this, handler0.getLooper(), 1);
    }

    public static final void a(n n0) {
        e e0 = n0.b;
        if(I8.e.a()) {
            if(e0.hasMessages(101)) {
                e0.removeMessages(101);
            }
            e0.sendEmptyMessageDelayed(101, 2000L);
            return;
        }
        e0.sendEmptyMessage(101);
    }

    @Override  // android.database.ContentObserver
    public final void onChange(boolean z, Uri uri0) {
        if(uri0 != null) {
            e e0 = this.b;
            if(!e0.hasMessages(102)) {
                e0.sendEmptyMessageDelayed(102, 2000L);
            }
        }
    }
}

