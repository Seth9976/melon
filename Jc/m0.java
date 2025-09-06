package Jc;

import android.view.View;
import com.iloen.melon.fragments.main.common.MainTabTitleView.SimpleEventListener;
import kotlin.jvm.internal.q;
import we.a;

public final class m0 extends SimpleEventListener {
    public final Q a;

    public m0(Q q0) {
        this.a = q0;
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

