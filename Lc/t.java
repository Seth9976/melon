package Lc;

import Ac.b0;
import Bb.c;
import Bb.g;
import Cb.i;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.g1;
import com.melon.ui.k1;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"LLc/t;", "Lcom/melon/ui/k1;", "<init>", "()V", "Lc/s", "Lc/r", "Lc/q", "Lc/p", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class t extends k1 {
    public final LogU a;
    public static final int b;

    @Inject
    public t() {
        LogU logU0 = new LogU("DownloadManagerViewModel");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(false);
        this.a = logU0;
    }

    public final m c() {
        Object object0 = this.getUiState().getValue();
        return object0 instanceof m ? ((m)object0) : null;
    }

    @Override  // com.melon.ui.k1
    public final Object onFetchStart(g1 g10, Continuation continuation0) {
        ArrayList arrayList1;
        ArrayList arrayList0;
        String s = "onFetchStart() type: " + i.o(g10);
        LogU.info$default(this.a, s, null, false, 6, null);
        g g0 = g.a;
        synchronized(g0) {
            arrayList0 = new ArrayList();
            List list0 = g.b;
            if(!list0.isEmpty()) {
                arrayList0.addAll(list0);
            }
        }
        synchronized(g0) {
            arrayList1 = new ArrayList();
            arrayList1.addAll(g.c);
        }
        if(arrayList0.isEmpty() && arrayList1.isEmpty()) {
            this.updateUiState(new H8.g(25));
            return H.a;
        }
        ArrayList arrayList2 = new ArrayList();
        if(!arrayList0.isEmpty()) {
            arrayList2.add(new s(false));
            int v2 = arrayList0.size();
            for(int v3 = 0; v3 < v2; ++v3) {
                arrayList2.add(new r(v3 == 0, ((c)arrayList0.get(v3)), 0L));
            }
        }
        if(!arrayList1.isEmpty()) {
            arrayList2.add(new q());  // 初始化器: Ljava/lang/Object;-><init>()V
            int v4 = arrayList1.size();
            for(int v1 = 0; v1 < v4; ++v1) {
                arrayList2.add(new p(((c)arrayList1.get(v1))));
            }
        }
        this.updateUiState(new b0(9, arrayList2));
        return H.a;
    }
}

