package kd;

import android.content.Context;
import com.kakao.tiara.data.Meta.Builder;
import ie.H;
import jd.f0;
import we.a;
import we.k;

public final class y implements a {
    public final int a;
    public final k b;
    public final Context c;
    public final String d;
    public final String e;

    public y(k k0, Context context0, String s, String s1, int v) {
        this.a = v;
        this.b = k0;
        this.c = context0;
        this.d = s;
        this.e = s1;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            f0 f00 = new f0(null, null, "선택", "채팅", "응원하기", new Builder().id(this.d).type("뮤직웨이브").name(this.e).build(), 3);
            this.b.invoke(f00);
            return H.a;
        }
        f0 f01 = new f0(null, null, "페이지이동", "팝업", "이용권구매", new Builder().id(this.d).type("뮤직웨이브").name(this.e).build(), 3);
        this.b.invoke(f01);
        return H.a;
    }
}

