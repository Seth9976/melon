package td;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class b1 extends i implements n {
    public int r;
    public final t1 w;

    public b1(Continuation continuation0, t1 t10) {
        this.w = t10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new b1(continuation0, this.w);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((b1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        t1 t10 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                if(t10.d.b(0x7F13090F, this) == a0) {  // string:section_repeat_mode_release_toast "반복재생이 해제되었습니다.\n반복재생은 재생 목록에서 재설정 가능합니다."
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            case 2: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        this.r = 2;
        return t1.c(t10, this) == a0 ? a0 : H.a;
    }
}

