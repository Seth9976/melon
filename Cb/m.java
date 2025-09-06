package Cb;

import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import we.k;

public final class m implements ViewTreeObserver.OnPreDrawListener {
    public final k a;
    public final TextView b;

    public m(k k0, TextView textView0) {
        this.a = k0;
        this.b = textView0;
    }

    @Override  // android.view.ViewTreeObserver$OnPreDrawListener
    public final boolean onPreDraw() {
        Integer integer0 = this.b.getLineCount();
        this.a.invoke(integer0);
        this.b.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    }
}

