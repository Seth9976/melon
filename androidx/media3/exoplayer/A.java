package androidx.media3.exoplayer;

import J0.h;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import i.n.i.b.a.s.e.zc;

public final class a extends BroadcastReceiver implements Runnable {
    public final int a;
    public final Handler b;
    public final Object c;
    public final Object d;

    public a(Object object0, Handler handler0, Object object1, int v) {
        this.a = v;
        this.d = object0;
        super();
        this.b = handler0;
        this.c = object1;
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        if(this.a != 0) {
            if("android.media.AUDIO_BECOMING_NOISY".equals(intent0.getAction())) {
                this.b.post(this);
            }
            return;
        }
        if("android.media.AUDIO_BECOMING_NOISY".equals(intent0.getAction())) {
            this.b.post(this);
        }
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            if(((h)this.d).b) {
                ((zc)this.c).a.B1(-1, 3, false);
            }
            return;
        }
        if(((h)this.d).b) {
            ((y)this.c).a.E0(-1, 3, false);
        }
    }
}

