package androidx.appcompat.widget;

import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;

public final class x0 implements View.OnTouchListener {
    public final ListPopupWindow a;

    public x0(ListPopupWindow listPopupWindow0) {
        this.a = listPopupWindow0;
    }

    @Override  // android.view.View$OnTouchListener
    public final boolean onTouch(View view0, MotionEvent motionEvent0) {
        int v = motionEvent0.getAction();
        int v1 = (int)motionEvent0.getX();
        int v2 = (int)motionEvent0.getY();
        ListPopupWindow listPopupWindow0 = this.a;
        if(v == 0 && (listPopupWindow0.T != null && listPopupWindow0.T.isShowing() && v1 >= 0 && v1 < listPopupWindow0.T.getWidth() && v2 >= 0 && v2 < listPopupWindow0.T.getHeight())) {
            listPopupWindow0.I.postDelayed(listPopupWindow0.B, 0xFAL);
            return false;
        }
        if(v == 1) {
            listPopupWindow0.I.removeCallbacks(listPopupWindow0.B);
        }
        return false;
    }
}

