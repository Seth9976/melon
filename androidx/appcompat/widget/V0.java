package androidx.appcompat.widget;

public final class v0 implements Runnable {
    public final int a;
    public final ListPopupWindow b;

    public v0(ListPopupWindow listPopupWindow0, int v) {
        this.a = v;
        this.b = listPopupWindow0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            ListPopupWindow listPopupWindow0 = this.b;
            if(listPopupWindow0.c != null && listPopupWindow0.c.isAttachedToWindow() && listPopupWindow0.c.getCount() > listPopupWindow0.c.getChildCount() && listPopupWindow0.c.getChildCount() <= listPopupWindow0.m) {
                listPopupWindow0.T.setInputMethodMode(2);
                listPopupWindow0.show();
            }
            return;
        }
        o0 o00 = this.b.c;
        if(o00 != null) {
            o00.setListSelectionHidden(true);
            o00.requestLayout();
        }
    }
}

