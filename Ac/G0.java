package Ac;

import Ua.N;
import androidx.lifecycle.c0;
import com.melon.ui.g1;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.k1;
import ie.H;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"LAc/g0;", "Lcom/melon/ui/k1;", "Ac/d0", "Ac/c0", "Ac/e0", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class g0 extends k1 {
    public final c0 a;
    public final N b;
    public final StringProviderImpl c;
    public static final int d;

    public g0(c0 c00, N n0, StringProviderImpl stringProviderImpl0) {
        q.g(c00, "savedState");
        super();
        this.a = c00;
        this.b = n0;
        this.c = stringProviderImpl0;
    }

    @Override  // com.melon.ui.k1
    public final Object onFetchStart(g1 g10, Continuation continuation0) {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(d0.a);
        arrayList0.add(Ac.c0.a);
        this.updateUiState(new b0(0, arrayList0));
        return H.a;
    }
}

