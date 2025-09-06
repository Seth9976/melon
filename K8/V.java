package k8;

import com.iloen.melon.MelonAppBase;
import kotlin.coroutines.Continuation;
import oe.c;

public final class v extends c {
    public int B;
    public Object r;
    public final MelonAppBase w;

    public v(MelonAppBase melonAppBase0, Continuation continuation0) {
        this.w = melonAppBase0;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return MelonAppBase.access$handleLifecycleEvent(this.w, null, this);
    }
}

