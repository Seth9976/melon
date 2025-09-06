package B6;

import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;

public final class b implements View.OnTouchListener {
    public final int a;

    public b(int v) {
        this.a = v;
        super();
    }

    @Override  // android.view.View$OnTouchListener
    public final boolean onTouch(View view0, MotionEvent motionEvent0) {
        switch(this.a) {
            case 0: {
                return true;
            }
            case 1: {
                return false;
            }
            default: {
                return true;
            }
        }
    }
}

