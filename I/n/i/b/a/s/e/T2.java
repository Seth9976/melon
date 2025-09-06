package i.n.i.b.a.s.e;

import android.os.Handler.Callback;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer.FrameCallback;
import android.view.Choreographer;

public final class t2 implements Handler.Callback, Choreographer.FrameCallback {
    public volatile long a;
    public final Handler b;
    public Choreographer c;
    public int d;
    public static final t2 e;

    static {
        t2.e = new t2();
    }

    public t2() {
        this.a = 0x8000000000000001L;
        HandlerThread handlerThread0 = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
        handlerThread0.start();
        Handler handler0 = new Handler(handlerThread0.getLooper(), this);
        this.b = handler0;
        handler0.sendEmptyMessage(0);
    }

    @Override  // android.view.Choreographer$FrameCallback
    public final void doFrame(long v) {
        this.a = v;
        Choreographer choreographer0 = this.c;
        choreographer0.getClass();
        choreographer0.postFrameCallbackDelayed(this, 500L);
    }

    @Override  // android.os.Handler$Callback
    public final boolean handleMessage(Message message0) {
        int v = message0.what;
        switch(v) {
            case 0: {
                this.c = Choreographer.getInstance();
                return true;
            }
            case 1: {
                int v2 = this.d + 1;
                this.d = v2;
                if(v2 == 1) {
                    Choreographer choreographer1 = this.c;
                    choreographer1.getClass();
                    choreographer1.postFrameCallback(this);
                }
                return true;
            }
            default: {
                if(v != 2) {
                    return false;
                }
                int v1 = this.d - 1;
                this.d = v1;
                if(v1 == 0) {
                    Choreographer choreographer0 = this.c;
                    choreographer0.getClass();
                    choreographer0.removeFrameCallback(this);
                    this.a = 0x8000000000000001L;
                }
                return true;
            }
        }
    }
}

