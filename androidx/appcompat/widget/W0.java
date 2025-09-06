package androidx.appcompat.widget;

import android.widget.AbsListView.OnScrollListener;
import android.widget.AbsListView;

public final class w0 implements AbsListView.OnScrollListener {
    public final ListPopupWindow a;

    public w0(ListPopupWindow listPopupWindow0) {
        this.a = listPopupWindow0;
    }

    @Override  // android.widget.AbsListView$OnScrollListener
    public final void onScroll(AbsListView absListView0, int v, int v1, int v2) {
    }

    @Override  // android.widget.AbsListView$OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView0, int v) {
        ListPopupWindow listPopupWindow0 = this.a;
        v0 v00 = listPopupWindow0.B;
        if(v != 1 || listPopupWindow0.T.getInputMethodMode() == 2) {
            return;
        }
        if(listPopupWindow0.T.getContentView() != null) {
            listPopupWindow0.I.removeCallbacks(v00);
            v00.run();
        }
    }
}

