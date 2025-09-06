package Jc;

import android.view.View;
import com.iloen.melon.fragments.main.common.MainTabTitleView.SimpleEventListener;
import kotlin.jvm.internal.q;

public final class r extends SimpleEventListener {
    public final J a;

    public r(J j0) {
        this.a = j0;
        super();
    }

    @Override  // com.iloen.melon.fragments.main.common.MainTabTitleView$SimpleEventListener
    public final void onViewAllButtonClick(View view0) {
        q.g(view0, "view");
        this.a.d.invoke();
    }
}

