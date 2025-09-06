package androidx.appcompat.widget;

import android.view.View.OnClickListener;
import android.view.View;
import k.m;

public final class b implements View.OnClickListener {
    public final int a;
    public final Object b;

    public b(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            f1 f10 = ((Toolbar)this.b).l0;
            m m0 = f10 == null ? null : f10.b;
            if(m0 != null) {
                m0.collapseActionView();
            }
            return;
        }
        ((j.b)this.b).a();
    }
}

