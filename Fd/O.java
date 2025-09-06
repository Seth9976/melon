package Fd;

import Cc.e0;
import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.l;
import com.iloen.melon.net.v6x.response.SearchKeywordContent;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.r;
import we.p;

public final class o extends r implements p {
    public final int f;
    public final List g;
    public final D h;

    public o(List list0, D d0, int v) {
        this.f = v;
        this.g = list0;
        this.h = d0;
        super(4);
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        switch(this.f) {
            case 0: {
                int v4 = ((Number)object1).intValue();
                int v5 = ((Number)object3).intValue();
                int v6 = (v5 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v5 : v5;
                if((v5 & 0x30) == 0) {
                    v6 |= (((androidx.compose.runtime.p)(((l)object2))).e(v4) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v6 & 1, (v6 & 0x93) != 0x92)) {
                    Object object5 = this.g.get(v4);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(0xA2275CB9);
                    this.h.r(((SearchKeywordContent)object5), Z.b, v4, ((androidx.compose.runtime.p)(((l)object2))), 0x30 | (v6 & 0x7E) << 3 & 0x380);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
            case 1: {
                int v7 = ((Number)object1).intValue();
                int v8 = ((Number)object3).intValue();
                int v9 = (v8 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v8 : v8;
                if((v8 & 0x30) == 0) {
                    v9 |= (((androidx.compose.runtime.p)(((l)object2))).e(v7) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v9 & 1, (v9 & 0x93) != 0x92)) {
                    SearchKeywordContent searchKeywordContent0 = (SearchKeywordContent)this.g.get(v7);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(0xE696FB78);
                    long v10 = e0.T(((androidx.compose.runtime.p)(((l)object2))), 0x7F060160);  // color:gray600s_support_high_contrast
                    this.h.t(Z.b, true, v10, searchKeywordContent0.getTitle(), v7, ((androidx.compose.runtime.p)(((l)object2))), (v9 & 0x7E) << 9 & 0xE000 | 54);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
            case 2: {
                int v11 = ((Number)object1).intValue();
                int v12 = ((Number)object3).intValue();
                int v13 = (v12 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v12 : v12;
                if((v12 & 0x30) == 0) {
                    v13 |= (((androidx.compose.runtime.p)(((l)object2))).e(v11) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v13 & 1, (v13 & 0x93) != 0x92)) {
                    Object object6 = this.g.get(v11);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(0x47701EEB);
                    this.h.r(((SearchKeywordContent)object6), Z.a, v11, ((androidx.compose.runtime.p)(((l)object2))), 0x30 | (v13 & 0x7E) << 3 & 0x380);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
            default: {
                int v = ((Number)object1).intValue();
                int v1 = ((Number)object3).intValue();
                int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v1 : v1;
                if((v1 & 0x30) == 0) {
                    v2 |= (((androidx.compose.runtime.p)(((l)object2))).e(v) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
                    Object object4 = this.g.get(v);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(0x590A7317);
                    long v3 = e0.T(((androidx.compose.runtime.p)(((l)object2))), 0x7F06016D);  // color:gray900s
                    this.h.t(Z.a, false, v3, ((String)object4), v, ((androidx.compose.runtime.p)(((l)object2))), 54 | (v2 & 0x7E) << 9 & 0xE000);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
        }
    }
}

