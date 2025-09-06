package z3;

import android.os.Handler.Callback;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer.FrameCallback;
import android.view.Choreographer;
import e3.b;

public final class m implements Handler.Callback, Choreographer.FrameCallback {
    public volatile long a;
    public final Handler b;
    public Choreographer c;
    public int d;
    public static final m e;

    static {
        m.e = new m();
    }

    public m() {
        this.a = 0x8000000000000001L;
        HandlerThread handlerThread0 = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
        handlerThread0.start();
        Handler handler0 = new Handler(handlerThread0.getLooper(), this);
        this.b = handler0;
        handler0.sendEmptyMessage(1);
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
        switch(message0.what) {
            case 1: {
                try {
                    this.c = Choreographer.getInstance();
                }
                catch(RuntimeException runtimeException0) {
                    b.E("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", runtimeException0);
                }
                return true;
            }
            case 2: {
                Choreographer choreographer0 = this.c;
                if(choreographer0 != null) {
                    int v = this.d + 1;
                    this.d = v;
                    if(v == 1) {
                        choreographer0.postFrameCallback(this);
                    }
                }
                return true;
            }
            case 3: {
                Choreographer choreographer1 = this.c;
                if(choreographer1 != null) {
                    int v1 = this.d - 1;
                    this.d = v1;
                    if(v1 == 0) {
                        choreographer1.removeFrameCallback(this);
                        this.a = 0x8000000000000001L;
                    }
                }
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

