package i9;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.iloen.melon.mediastore.MelonMediaProvider;

public final class c extends Handler {
    public final int a;
    public final MelonMediaProvider b;

    public c(MelonMediaProvider melonMediaProvider0, Looper looper0, int v) {
        this.a = v;
        this.b = melonMediaProvider0;
        super(looper0);
    }

    @Override  // android.os.Handler
    public final void handleMessage(Message message0) {
        e e1;
        e e0;
        if(this.a != 0) {
            if(message0.what == 1) {
                synchronized(this.b.d) {
                    e0 = (e)this.b.d.pop();
                }
                this.b.m(e0);
                synchronized(this.b.c) {
                    this.b.c.remove(e0.c);
                }
                return;
            }
            return;
        }
        if(message0.what == 1) {
            synchronized(this.b.d) {
                e1 = (e)this.b.d.pop();
            }
            this.b.m(e1);
            synchronized(this.b.c) {
                this.b.c.remove(e1.c);
            }
        }
    }
}

