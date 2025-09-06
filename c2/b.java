package c2;

import P1.c;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public final class B implements Runnable {
    public final int a;
    public final View b;

    public B(View view0, int v) {
        this.a = v;
        this.b = view0;
        super();
    }

    @Override
    public final void run() {
        View view0 = this.b;
        switch(this.a) {
            case 0: {
                ((InputMethodManager)view0.getContext().getSystemService("input_method")).showSoftInput(view0, 0);
                return;
            }
            case 1: {
                view0.requestLayout();
                return;
            }
            case 2: {
                view0.requestFocus();
                view0.post(new B(view0, 3));
                return;
            }
            default: {
                ((InputMethodManager)c.getSystemService(view0.getContext(), InputMethodManager.class)).showSoftInput(view0, 1);
            }
        }
    }
}

