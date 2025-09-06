package Jc;

import android.view.View;
import com.iloen.melon.fragments.main.common.MainTabTitleView.SimpleEventListener;
import kotlin.jvm.internal.q;
import we.a;

public final class h0 extends SimpleEventListener {
    public final O a;

    public h0(O o0) {
        this.a = o0;
        super();
    }

    @Override  // com.iloen.melon.fragments.main.common.MainTabTitleView$SimpleEventListener
    public final void onViewAllButtonClick(View view0) {
        q.g(view0, "view");
        a a0 = this.a.b;
        if(a0 != null) {
            a0.invoke();
        }
    }
}

