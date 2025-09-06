package m9;

import com.kakao.tiara.data.ContentList;
import ie.H;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.q;
import p8.s;
import q8.c;
import q8.j;
import we.k;

public final class o implements k {
    public final int a;
    public final j b;
    public final ContentList c;
    public final s d;

    public o(j j0, ContentList contentList0, s s0, int v) {
        this.a = v;
        this.b = j0;
        this.c = contentList0;
        this.d = s0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        String s = "";
        s s1 = this.d;
        ContentList contentList0 = this.c;
        j j0 = this.b;
        if(this.a != 0) {
            q.g(((c)object0), "$this$customProps");
            LinkedHashMap linkedHashMap0 = ((c)object0).a;
            if(s1 != null) {
                String s2 = s1.c;
                if(s2 != null) {
                    s = s2;
                }
            }
            linkedHashMap0.put("menuid", s);
            j0.getClass();
            j0.h = contentList0;
            return h0;
        }
        q.g(((c)object0), "$this$customProps");
        LinkedHashMap linkedHashMap1 = ((c)object0).a;
        if(s1 != null) {
            String s3 = s1.c;
            if(s3 != null) {
                s = s3;
            }
        }
        linkedHashMap1.put("menuid", s);
        j0.getClass();
        j0.h = contentList0;
        return h0;
    }
}

