package k8;

import com.iloen.melon.playback.EpPlayLogger.DebugReqInfo;
import d5.n;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.q;

public final class s0 extends i implements q {
    public int B;
    public DebugReqInfo D;
    public String r;
    public long w;

    @Override  // we.q
    public final Object invoke(Object object0, Object object1, Object object2, Object object3, Object object4) {
        s0 s00 = new s0(5, ((Continuation)object4));  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        s00.r = (String)object0;
        s00.w = ((Number)object1).longValue();
        s00.B = ((Number)object2).intValue();
        s00.D = (DebugReqInfo)object3;
        return s00.invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s = this.r;
        long v = this.w;
        int v1 = this.B;
        DebugReqInfo epPlayLogger$DebugReqInfo0 = this.D;
        n.D(object0);
        return new K0(s, v, v1, epPlayLogger$DebugReqInfo0);
    }
}

