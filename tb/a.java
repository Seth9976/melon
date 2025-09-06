package tb;

import Cb.j;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistListRes.RESPONSE.PLAYLISTLIST;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistListRes;
import com.iloen.melon.types.ContextItemInfo.Params;
import com.iloen.melon.types.ContextItemInfo;
import ie.H;
import java.util.ArrayList;
import je.q;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import oe.i;
import ua.u;
import we.n;

public final class a extends i implements n {
    public Object B;
    public final ea.a D;
    public final String E;
    public MyMusicPlaylistListRes r;
    public int w;

    public a(ea.a a0, String s, Continuation continuation0) {
        this.D = a0;
        this.E = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new a(this.D, this.E, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((a)this.create(((FlowCollector)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ArrayList arrayList1;
        MyMusicPlaylistListRes myMusicPlaylistListRes0;
        FlowCollector flowCollector0 = (FlowCollector)this.B;
        ne.a a0 = ne.a.a;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                this.B = flowCollector0;
                this.w = 1;
                object0 = ((u)this.D.a).j(1, 100, "all", this.E, this);
                if(object0 == a0) {
                    return a0;
                }
                goto label_13;
            }
            case 1: {
                d5.n.D(object0);
            label_13:
                myMusicPlaylistListRes0 = (MyMusicPlaylistListRes)object0;
                d d0 = new d(myMusicPlaylistListRes0.notification);
                this.B = flowCollector0;
                this.r = myMusicPlaylistListRes0;
                this.w = 2;
                if(flowCollector0.emit(d0, this) == a0) {
                    return a0;
                }
                break;
            }
            case 2: {
                myMusicPlaylistListRes0 = this.r;
                d5.n.D(object0);
                break;
            }
            case 3: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(j.d(myMusicPlaylistListRes0)) {
            ArrayList arrayList0 = myMusicPlaylistListRes0.response.playlistlist;
            if(arrayList0 == null) {
                arrayList1 = null;
            }
            else {
                arrayList1 = new ArrayList(q.Q(10, arrayList0));
                for(Object object1: arrayList0) {
                    String s = String.valueOf(ProtocolUtils.parseInt(((PLAYLISTLIST)object1).songcnt, 0));
                    ContextItemInfo contextItemInfo0 = ContextItemInfo.a(new v9.d(-1, ((PLAYLISTLIST)object1).plylsttitle, s));
                    Params contextItemInfo$Params0 = new Params();
                    contextItemInfo$Params0.a = ((PLAYLISTLIST)object1).plylstseq;
                    contextItemInfo0.b(contextItemInfo$Params0);
                    arrayList1.add(contextItemInfo0);
                }
            }
            c c0 = new c(arrayList1);
            this.B = null;
            this.r = null;
            this.w = 3;
            if(flowCollector0.emit(c0, this) == a0) {
                return a0;
            }
        }
        return H.a;
    }
}

