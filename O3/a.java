package o3;

import android.media.MediaCodec.OnFrameRenderedListener;
import android.media.MediaCodec;
import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Message;
import ea.c;
import i.n.i.b.a.s.e.H0;
import i.n.i.b.a.s.e.I0;
import i.n.i.b.a.s.e.L7;
import i.n.i.b.a.s.e.Q3;
import i.n.i.b.a.s.e.y7;

public final class a implements MediaCodec.OnFrameRenderedListener {
    public final int a;
    public final Handler.Callback b;

    public a(Object object0, Handler.Callback handler$Callback0, int v) {
        this.a = v;
        this.b = handler$Callback0;
        super();
    }

    @Override  // android.media.MediaCodec$OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec0, long v, long v1) {
        switch(this.a) {
            case 0: {
                ((H0)this.b).a(v);
                return;
            }
            case 1: {
                ((H0)this.b).a(v);
                return;
            }
            default: {
                H0 h00 = (H0)this.b;
                Handler handler0 = h00.b;
                if(L7.a < 30) {
                    handler0.sendMessageAtFrontOfQueue(Message.obtain(handler0, 0, ((int)(v >> 0x20)), ((int)v)));
                    return;
                }
                I0 i00 = (I0)h00.c;
                if(h00 == i00.X1) {
                    if(Long.compare(v, 0x7FFFFFFFFFFFFFFFL) == 0) {
                        i00.Y0 = true;
                        return;
                    }
                    try {
                        i00.m0(v);
                        i00.F0();
                        i00.a1.getClass();
                        if(i00.V1 && !i00.Y1) {
                            i00.Y1 = true;
                            c c0 = i00.p1;
                            Handler handler1 = (Handler)c0.b;
                            if(handler1 != null) {
                                handler1.post(new Q3(c0, 2));
                            }
                        }
                        i00.E0();
                        i00.g0(v);
                    }
                    catch(y7 y70) {
                        i00.Z0 = y70;
                    }
                }
            }
        }
    }
}

