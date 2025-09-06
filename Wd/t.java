package wd;

import Pc.e;
import androidx.lifecycle.f0;
import com.iloen.melon.fragments.detail.PlaylistMakeFragment;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.n0;
import d5.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lwd/t;", "Lcom/melon/ui/n0;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class t extends n0 {
    public final i a;
    public final StringProviderImpl b;
    public String c;
    public List d;
    public String e;
    public List f;
    public String g;
    public static final int h;

    public t(i i0, StringProviderImpl stringProviderImpl0) {
        this.a = i0;
        this.b = stringProviderImpl0;
        LogU logU0 = new LogU("AddToPlaylistViewModel");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.g = "";
    }

    @Override  // com.melon.ui.n0
    public final void onUserEvent(e e0) {
        q.g(e0, "userEvent");
        if(e0 instanceof l) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getDefault(), null, new o(this, null), 2, null);
            return;
        }
        if(e0 instanceof j) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getDefault(), null, new p(e0, null, this), 2, null);
            return;
        }
        if(e0 instanceof k) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getDefault(), null, new wd.q(e0, null, this), 2, null);
            return;
        }
        wd.i i0 = wd.i.a;
        if(e0 instanceof m) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getDefault(), null, new r(this, null), 2, null);
            this.sendUiEvent(i0);
            return;
        }
        if(e0 instanceof n) {
            Navigator.open(PlaylistMakeFragment.newInstance("", this.c));
            this.sendUiEvent(i0);
        }
    }
}

