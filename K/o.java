package k;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;
import j.c;

public final class o extends FrameLayout implements c {
    public final CollapsibleActionView a;

    public o(View view0) {
        super(view0.getContext());
        this.a = (CollapsibleActionView)view0;
        this.addView(view0);
    }

    @Override  // j.c
    public final void onActionViewCollapsed() {
        this.a.onActionViewCollapsed();
    }

    @Override  // j.c
    public final void onActionViewExpanded() {
        this.a.onActionViewExpanded();
    }
}

