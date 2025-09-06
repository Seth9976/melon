package Ac;

import androidx.lifecycle.f0;
import com.melon.ui.K4;
import com.melon.ui.c3;
import com.melon.ui.e3;
import com.melon.ui.k1;
import ie.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import we.k;

public final class p3 implements k {
    public final int a;
    public final L3 b;

    public p3(L3 l30, int v) {
        this.a = v;
        this.b = l30;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        L3 l30 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((K4)object0), "it");
                return new l3(new c3(l30.e.a(0x7F1303D9), 0, false, null, 14));  // string:error_network_connectivity "해당 페이지의 접속이 지연되고 있습니다.\n네트워크 연결 상태를 확인하거나,\n잠시 
                                                                                 // 후 다시 이용해주세요."
            }
            case 1: {
                q.g(((V3)object0), "it");
                L3 l31 = this.b;
                if(((V3)object0) instanceof S3) {
                    k1.startFetch$default(l31, true, null, null, 6, null);
                }
                BuildersKt__Builders_commonKt.launch$default(f0.h(l31), null, null, new E3(((V3)object0), null), 3, null);
                return H.a;
            }
            default: {
                q.g(((K4)object0), "it");
                return new m3(new e3(l30.e.a(0x7F1301E0), null, null, null, 61));  // string:cmt_empty_text "등록된 댓글이 없습니다."
            }
        }
    }
}

