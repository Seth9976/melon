package k;

import android.widget.PopupWindow.OnDismissListener;

public final class t implements PopupWindow.OnDismissListener {
    public final u a;

    public t(u u0) {
        this.a = u0;
    }

    @Override  // android.widget.PopupWindow$OnDismissListener
    public final void onDismiss() {
        this.a.c();
    }
}

