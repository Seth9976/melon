package Jc;

import android.view.View;
import com.iloen.melon.fragments.main.common.MainTabTitleView.SimpleEventListener;
import kotlin.jvm.internal.q;
import we.a;

public final class p0 extends SimpleEventListener {
    public final T a;

    public p0(T t0) {
        this.a = t0;
        super();
    }

    @Override  // com.iloen.melon.fragments.main.common.MainTabTitleView$SimpleEventListener
    public final void onViewAllButtonClick(View view0) {
        q.g(view0, "view");
        a a0 = this.a.d;
        if(a0 != null) {
            a0.invoke();
        }
    }
}

