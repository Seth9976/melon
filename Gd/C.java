package gd;

import A8.L;
import A8.m;
import android.content.Context;
import com.iloen.melon.custom.l1;
import hd.O;
import ie.H;
import jd.f0;
import we.a;
import we.k;

public final class c implements a {
    public final int a;
    public final k b;
    public final Context c;

    public c(Context context0, k k0) {
        this.a = 4;
        super();
        this.c = context0;
        this.b = k0;
    }

    public c(k k0, Context context0, int v) {
        this.a = v;
        this.b = k0;
        this.c = context0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                N2 n20 = new N2("파워DJ", l1.m("파워DJ", "getString(...)", this.c, 0x7F130DB1, "getString(...)"));  // string:tiara_click_copy_view_all "전체보기"
                this.b.invoke(n20);
                return H.a;
            }
            case 1: {
                Q2 q20 = new Q2("파워DJ의플레이리스트", l1.m("파워DJ의플레이리스트", "getString(...)", this.c, 0x7F130DB1, "getString(...)"));  // string:tiara_click_copy_view_all "전체보기"
                this.b.invoke(q20);
                return H.a;
            }
            case 2: {
                S2 s20 = new S2("태그플레이리스트", l1.m("태그플레이리스트", "getString(...)", this.c, 0x7F130DB1, "getString(...)"));  // string:tiara_click_copy_view_all "전체보기"
                this.b.invoke(s20);
                return H.a;
            }
            case 3: {
                J2 j20 = new J2("인기플레이리스트", l1.m("인기플레이리스트", "getString(...)", this.c, 0x7F130DB1, "getString(...)"));  // string:tiara_click_copy_view_all "전체보기"
                this.b.invoke(j20);
                return H.a;
            }
            case 4: {
                L l0 = new L("마이감상차트", null, null, l1.m("마이감상차트", "getString(...)", this.c, 0x7F130DB1, "getString(...)"), null, null, null, null, 987);  // string:tiara_click_copy_view_all "전체보기"
                O o0 = new O(new m(0x1F, null, null, null, null), "MY_CHART", l0);
                this.b.invoke(o0);
                return H.a;
            }
            case 5: {
                f0 f01 = new f0(null, null, "선택", "채팅", "입력창", null, 35);
                this.b.invoke(f01);
                return H.a;
            }
            default: {
                f0 f00 = new f0(null, null, "선택", "채팅", "댓글등록", null, 35);
                this.b.invoke(f00);
                return H.a;
            }
        }
    }
}

