package Fc;

import androidx.lifecycle.f0;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.n0;
import d9.j;
import kc.s2;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ob.z;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"LFc/p;", "Lcom/melon/ui/n0;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class p extends n0 {
    public final s2 a;
    public final MutableStateFlow b;
    public final MutableStateFlow c;
    public static final int d;

    public p(s2 s20, z z0) {
        q.g(s20, "playlistManager");
        super();
        this.a = s20;
        LogU logU0 = new LogU("CoverScreenLyricViewModel");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(j.b("CoverScreenLyricViewModel"));
        this.b = mutableStateFlow0;
        this.c = mutableStateFlow0;
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getMain(), null, new o(this, null), 2, null);
    }
}

