package Dd;

import Bc.i;
import Nc.W0;
import android.content.Context;
import com.kakao.tiara.data.Meta.Builder;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.ui.r4;
import gd.i7;
import ie.H;
import java.util.Collection;
import java.util.List;
import jd.t2;
import kotlin.jvm.internal.q;
import w0.h;
import we.a;
import we.k;

public final class j1 implements a {
    public final int a;
    public final h b;
    public final k c;
    public final Object d;
    public final int e;
    public final Object f;
    public final Object g;

    public j1(h h0, List list0, int v, k k0, Context context0, a a0) {
        this.a = 3;
        super();
        this.b = h0;
        this.d = list0;
        this.e = v;
        this.c = k0;
        this.f = context0;
        this.g = a0;
    }

    public j1(h h0, a a0, k k0, String s, String s1, int v) {
        this.a = 1;
        super();
        this.b = h0;
        this.f = a0;
        this.c = k0;
        this.d = s;
        this.g = s1;
        this.e = v;
    }

    public j1(h h0, k k0, Context context0, List list0, int v, k k1) {
        this.a = 2;
        super();
        this.b = h0;
        this.c = k0;
        this.d = context0;
        this.f = list0;
        this.e = v;
        this.g = k1;
    }

    public j1(h h0, k k0, String s, LinkInfoBase linkInfoBase0, i i0, int v) {
        this.a = 0;
        super();
        this.b = h0;
        this.c = k0;
        this.d = s;
        this.f = linkInfoBase0;
        this.g = i0;
        this.e = v;
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                h.a(this.b);
                D1 d10 = new D1(((String)this.d), ((LinkInfoBase)this.f), ((i)this.g), this.e);
                this.c.invoke(d10);
                return H.a;
            }
            case 1: {
                h.a(this.b);
                ((a)this.f).invoke();
                String s = (String)this.d;
                String s1 = (String)this.g;
                if(s1 == null) {
                    s1 = "";
                }
                i7 i70 = new i7(s, s1, "suggest", this.e, true);
                this.c.invoke(i70);
                return H.a;
            }
            case 2: {
                h.a(this.b);
                Context context1 = (Context)this.d;
                t2 t21 = new t2(null, "선택", "이미지뷰어", "이미지삭제", new Builder().id(((jd.a)((List)this.f).get(this.e)).a).type("이미지").build());
                k k0 = this.c;
                k0.invoke(t21);
                String s2 = ((jd.a)((List)this.f).get(this.e)).a;
                if(s2 != null) {
                    q.f("선택중인 이미지를 삭제하시겠습니까?", "getString(...)");
                    r4 r40 = new r4("", "선택중인 이미지를 삭제하시겠습니까?", null, new W0(25, k0, s2), null, null, 108);
                    ((k)this.g).invoke(r40);
                }
                return H.a;
            }
            default: {
                Context context0 = (Context)this.f;
                h.a(this.b);
                Object object0 = this.d;
                if(!((Collection)object0).isEmpty()) {
                    int v = this.e;
                    if(v >= 0 && v < ((List)object0).size()) {
                        t2 t20 = new t2(null, "페이지이동", "이미지뷰어", "뷰어닫기", new Builder().id(((jd.a)((List)object0).get(v)).a).type("이미지").build());
                        this.c.invoke(t20);
                    }
                }
                ((a)this.g).invoke();
                return H.a;
            }
        }
    }
}

