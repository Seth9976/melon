package Q0;

import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.facebook.login.widget.ToolTipPopup;

public final class h implements ViewTreeObserver.OnScrollChangedListener {
    public final int a;
    public final Object b;

    public h(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.view.ViewTreeObserver$OnScrollChangedListener
    public final void onScrollChanged() {
        if(this.a != 0) {
            ToolTipPopup.scrollListener$lambda$1(((ToolTipPopup)this.b));
            return;
        }
        ((u)this.b).L();
    }
}

