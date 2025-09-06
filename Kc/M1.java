package kc;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.SpecialContentsKt;
import e.k;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class m1 extends i implements n {
    public final List r;
    public final List w;

    public m1(List list0, List list1, Continuation continuation0) {
        this.r = list0;
        this.w = list1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new m1(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((m1)this.create(((List)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        List list0 = this.r;
        int v = 0;
        for(Object object1: list0) {
            if(v >= 0) {
                ((Playable)object1).setBgVideo(SpecialContentsKt.getSpecialBgVideoFromBgVideoBase(((f3)this.w.get(v)).a));
                ((Playable)object1).setBgImgs(SpecialContentsKt.getSpecialBgImageListFromBgImgsBaseList(((f3)this.w.get(v)).b));
                ++v;
                continue;
            }
            k.O();
            throw null;
        }
        return list0;
    }
}

