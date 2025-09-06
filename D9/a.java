package d9;

import android.content.Context;
import com.iloen.melon.playback.Playable;
import kotlin.coroutines.Continuation;
import oe.c;

public final class a extends c {
    public Object B;
    public final b D;
    public int E;
    public Context r;
    public Playable w;

    public a(b b0, Continuation continuation0) {
        this.D = b0;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.backgroundWork(null, this);
    }
}

