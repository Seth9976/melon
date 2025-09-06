package gd;

import Pc.e;
import androidx.lifecycle.f0;
import com.iloen.melon.net.v4x.response.DjApplyMainRes;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.n0;
import ed.s;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import x9.b;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lgd/p5;", "Lcom/melon/ui/n0;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class p5 extends n0 {
    public final b a;
    public final StringProviderImpl b;
    public DjApplyMainRes c;
    public static final int d;

    public p5(b b0, StringProviderImpl stringProviderImpl0) {
        this.a = b0;
        this.b = stringProviderImpl0;
    }

    @Override  // com.melon.ui.n0
    public final void onUserEvent(e e0) {
        q.g(e0, "userEvent");
        if(e0 instanceof l5) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getDefault(), null, new n5(this, e0, null), 2, null);
            return;
        }
        if(e0 instanceof k5) {
            this.updateUiState(new s(14));
            return;
        }
        super.onUserEvent(e0);
    }
}

