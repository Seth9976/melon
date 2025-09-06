package vb;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.sns.target.SnsManager.SnsType;
import oe.c;

public final class n extends c {
    public Object B;
    public final o D;
    public int E;
    public SnsManager.SnsType r;
    public Playable w;

    public n(o o0, c c0) {
        this.D = o0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.e(null, null, this);
    }
}

