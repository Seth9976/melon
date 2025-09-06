package ed;

import Q.K;
import Q.e;
import androidx.compose.runtime.b0;
import com.iloen.melon.net.v6x.response.SearchHotKeywordAndMenuListRes.RESPONSE.KeywordList;
import ie.H;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import we.a;

public final class h implements a {
    public final int a;
    public final b0 b;
    public final e0 c;
    public final CoroutineScope d;
    public final ed.Z.a e;
    public final String f;
    public final K g;
    public final b0 h;

    public h(b0 b00, e0 e00, CoroutineScope coroutineScope0, ed.Z.a z$a0, String s, e e0, b0 b01, int v) {
        this.a = v;
        this.b = b00;
        this.c = e00;
        this.d = coroutineScope0;
        this.e = z$a0;
        this.f = s;
        this.g = e0;
        this.h = b01;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        String s1;
        String s;
        if(this.a != 0) {
            KeywordList searchHotKeywordAndMenuListRes$RESPONSE$KeywordList0 = this.c.a.yesterdayHotKeywordList;
            if(searchHotKeywordAndMenuListRes$RESPONSE$KeywordList0 == null) {
                s = "";
            }
            else {
                s = searchHotKeywordAndMenuListRes$RESPONSE$KeywordList0.dateTime;
                if(s == null) {
                    s = "";
                }
            }
            this.b.setValue(s);
            B b0 = new B(this.g, this.h, null);
            BuildersKt__Builders_commonKt.launch$default(this.d, null, null, b0, 3, null);
            ((F0)this.e.getViewModel()).k().c(this.f);
            return H.a;
        }
        KeywordList searchHotKeywordAndMenuListRes$RESPONSE$KeywordList1 = this.c.a.currentHotKeywordList;
        if(searchHotKeywordAndMenuListRes$RESPONSE$KeywordList1 == null) {
            s1 = "";
        }
        else {
            s1 = searchHotKeywordAndMenuListRes$RESPONSE$KeywordList1.dateTime;
            if(s1 == null) {
                s1 = "";
            }
        }
        this.b.setValue(s1);
        A a0 = new A(this.g, this.h, null);
        BuildersKt__Builders_commonKt.launch$default(this.d, null, null, a0, 3, null);
        ((F0)this.e.getViewModel()).k().c(this.f);
        return H.a;
    }
}

