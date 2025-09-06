package xd;

import H8.q;
import Pc.e;
import T2.a;
import androidx.lifecycle.f0;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.n0;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import x9.c;
import zd.Q;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lxd/r;", "Lcom/melon/ui/n0;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class r extends n0 {
    public final c a;
    public final CoroutineDispatcher b;
    public int c;
    public Q d;
    public static final int e;

    public r(c c0, q q0, StringProviderImpl stringProviderImpl0, CoroutineDispatcher coroutineDispatcher0) {
        this.a = c0;
        this.b = coroutineDispatcher0;
        LogU logU0 = new LogU("ArtistMultiPopupViewModel");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.c = 1;
    }

    @Override  // com.melon.ui.n0
    public final void onUserEvent(e e0) {
        kotlin.jvm.internal.q.g(e0, "userEvent");
        if(e0 instanceof o) {
            a a0 = f0.h(this);
            p p0 = new p(this, null);
            BuildersKt__Builders_commonKt.launch$default(a0, this.b, null, p0, 2, null);
            return;
        }
        if(e0 instanceof n) {
            this.sendUiEvent(new m(((n)e0).a, ((n)e0).b, ((n)e0).c));
        }
    }
}

