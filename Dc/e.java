package dc;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelIterator;
import ne.a;
import oe.i;
import we.n;

public final class e extends i implements n {
    public ChannelIterator r;
    public int w;

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new e(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ChannelIterator channelIterator0;
        a a0 = a.a;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                channelIterator0 = g.f.iterator();
                goto label_10;
            }
            case 1: {
                channelIterator0 = this.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(((Boolean)object0).booleanValue()) {
            ((we.a)channelIterator0.next()).invoke();
        label_10:
            this.r = channelIterator0;
            this.w = 1;
            object0 = channelIterator0.hasNext(this);
            if(object0 != a0) {
                continue;
            }
            return a0;
        }
        return H.a;
    }
}

