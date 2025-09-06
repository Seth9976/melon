package Jc;

import android.view.View;
import com.iloen.melon.fragments.main.common.MainTabTitleView.SimpleEventListener;
import kotlin.jvm.internal.q;
import we.k;

public final class f0 extends SimpleEventListener {
    public final B a;

    public f0(B b0) {
        this.a = b0;
        super();
    }

    @Override  // com.iloen.melon.fragments.main.common.MainTabTitleView$SimpleEventListener
    public final void onViewAllButtonClick(View view0) {
        q.g(view0, "view");
        B b0 = this.a;
        k k0 = b0.k;
        if(k0 != null) {
            k0.invoke(b0);
        }
    }
}

