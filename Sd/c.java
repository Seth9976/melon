package sd;

import P0.d0;
import androidx.compose.runtime.l;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.track.Event;
import ie.H;
import q8.d;
import q8.h;
import we.n;

public final class c implements n {
    public final int a;
    public final P b;

    public c(P p0, int v) {
        this.a = 0;
        super();
        this.b = p0;
    }

    public c(P p0, int v, byte b) {
        this.a = v;
        this.b = p0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).getClass();
                o.c(this.b, ((l)object0), 1);
                return H.a;
            }
            case 1: {
                long v2 = (long)(((Long)object0));
                int v3 = (int)(((Integer)object1));
                P p1 = this.b;
                if(v3 == 0) {
                    d0 d01 = p1.l;
                    if(d01.f()) {
                        d d1 = new d();  // 初始化器: LQb/h;-><init>()V
                        d0.i(d01, d1, ActionKind.ClickContent);
                        ((h)d1.b).a = d01.d(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        d1.b(new p(d01, 1));
                        ((Event)d1.p()).track();
                    }
                }
                p1.e.y(v3, v2);
                return H.a;
            }
            default: {
                long v = (long)(((Long)object0));
                int v1 = (int)(((Integer)object1));
                P p0 = this.b;
                if(v1 == 0) {
                    d0 d00 = p0.l;
                    if(d00.f()) {
                        d d0 = new d();  // 初始化器: LQb/h;-><init>()V
                        d0.i(d00, d0, ActionKind.ClickContent);
                        ((h)d0.b).a = d00.d(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        d0.b(new p(d00, 0));
                        ((Event)d0.p()).track();
                    }
                }
                p0.e.c(v1, v);
                return H.a;
            }
        }
    }
}

