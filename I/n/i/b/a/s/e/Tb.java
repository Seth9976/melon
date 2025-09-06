package i.n.i.b.a.s.e;

import android.media.AudioTrack.StreamEventCallback;
import android.media.AudioTrack;
import androidx.media3.exoplayer.C;
import j3.s;
import j3.u;

public final class tb extends AudioTrack.StreamEventCallback {
    public final int a;
    public final Object b;

    public tb(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.media.AudioTrack$StreamEventCallback
    public final void onDataRequest(AudioTrack audioTrack0, int v) {
        if(this.a != 0) {
            if(audioTrack0.equals(((s)((y8.s)this.b).c).v)) {
                s s0 = (s)((y8.s)this.b).c;
                Ga ga0 = s0.r;
                if(ga0 != null && s0.V) {
                    C c0 = ((u)ga0.b).b0;
                    if(c0 != null) {
                        c0.a();
                    }
                }
            }
            return;
        }
        M7.J(audioTrack0 == ((ub)((sa)this.b).d).r);
        ub ub0 = (ub)((sa)this.b).d;
        Ga ga1 = ub0.o;
        if(ga1 != null && ub0.S) {
            C9 c90 = ((od)ga1.b).x1;
            if(c90 != null) {
                c90.a.g.c(2);
            }
        }
    }

    @Override  // android.media.AudioTrack$StreamEventCallback
    public void onPresentationEnded(AudioTrack audioTrack0) {
        if(this.a != 1) {
            super.onPresentationEnded(audioTrack0);
            return;
        }
        if(audioTrack0.equals(((s)((y8.s)this.b).c).v)) {
            ((s)((y8.s)this.b).c).U = true;
        }
    }

    @Override  // android.media.AudioTrack$StreamEventCallback
    public final void onTearDown(AudioTrack audioTrack0) {
        if(this.a != 0) {
            if(audioTrack0.equals(((s)((y8.s)this.b).c).v)) {
                s s0 = (s)((y8.s)this.b).c;
                Ga ga0 = s0.r;
                if(ga0 != null && s0.V) {
                    C c0 = ((u)ga0.b).b0;
                    if(c0 != null) {
                        c0.a();
                    }
                }
            }
            return;
        }
        M7.J(audioTrack0 == ((ub)((sa)this.b).d).r);
        ub ub0 = (ub)((sa)this.b).d;
        Ga ga1 = ub0.o;
        if(ga1 != null && ub0.S) {
            C9 c90 = ((od)ga1.b).x1;
            if(c90 != null) {
                c90.a.g.c(2);
            }
        }
    }
}

