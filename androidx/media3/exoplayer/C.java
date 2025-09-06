package androidx.media3.exoplayer;

import A6.d;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Handler;

public final class c implements AudioManager.OnAudioFocusChangeListener {
    public final int a;
    public final Handler b;
    public final Object c;

    public c(Object object0, Handler handler0, int v) {
        this.a = v;
        this.c = object0;
        this.b = handler0;
        super();
    }

    @Override  // android.media.AudioManager$OnAudioFocusChangeListener
    public final void onAudioFocusChange(int v) {
        if(this.a != 0) {
            d d0 = new d(this, v, 13);
            this.b.post(d0);
            return;
        }
        d d1 = new d(this, v, 5);
        this.b.post(d1);
    }
}

