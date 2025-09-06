package Pa;

import Cb.j;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistInsertRes;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.FlowCollector;
import ne.a;
import oe.i;
import ua.u;
import we.n;

public final class b extends i implements n {
    public Object B;
    public final d5.i D;
    public final String E;
    public final List G;
    public MyMusicPlaylistInsertRes r;
    public int w;

    public b(d5.i i0, String s, List list0, Continuation continuation0) {
        this.D = i0;
        this.E = s;
        this.G = list0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new b(this.D, this.E, this.G, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((b)this.create(((FlowCollector)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        MyMusicPlaylistInsertRes myMusicPlaylistInsertRes0;
        FlowCollector flowCollector0 = (FlowCollector)this.B;
        a a0 = a.a;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                this.B = flowCollector0;
                this.w = 1;
                object0 = ((u)this.D.a).p(this.E, this);
                if(object0 != a0) {
                label_16:
                    myMusicPlaylistInsertRes0 = (MyMusicPlaylistInsertRes)object0;
                    f f0 = new f(myMusicPlaylistInsertRes0.notification);
                    this.B = flowCollector0;
                    this.r = myMusicPlaylistInsertRes0;
                    this.w = 2;
                    if(flowCollector0.emit(f0, this) != a0) {
                    label_22:
                        if(!j.d(myMusicPlaylistInsertRes0)) {
                            return H.a;
                        }
                        List list0 = this.G;
                        if(list0 != null && !list0.isEmpty()) {
                            String s = myMusicPlaylistInsertRes0.response.plylstSeq;
                            q.d(s);
                            d d0 = new d(s, list0);
                            this.B = null;
                            this.r = null;
                            this.w = 4;
                            return flowCollector0.emit(d0, this) != a0 ? H.a : a0;
                        }
                        g g0 = new g(0x7F130823);  // string:playlist_created "플레이리스트가 생성되었습니다."
                        this.B = null;
                        this.r = null;
                        this.w = 3;
                        if(flowCollector0.emit(g0, this) != a0) {
                            return H.a;
                        }
                    }
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                goto label_16;
            }
            case 2: {
                myMusicPlaylistInsertRes0 = this.r;
                d5.n.D(object0);
                goto label_22;
            }
            case 3: 
            case 4: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }
}

