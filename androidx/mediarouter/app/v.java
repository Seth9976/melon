package androidx.mediarouter.app;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.custom.CheckableTextView;
import com.iloen.melon.custom.FilterLayout;
import com.iloen.melon.custom.J;
import l4.O;

public final class v implements View.OnClickListener {
    public final int a;
    public final Object b;
    public final Object c;

    public v(int v, Object object0, Object object1) {
        this.a = v;
        this.c = object0;
        this.b = object1;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            CheckableTextView checkableTextView0 = (CheckableTextView)this.b;
            int v = !checkableTextView0.i;
            checkableTextView0.setChecked(((boolean)v));
            J j0 = ((FilterLayout)this.c).f;
            if(j0 != null) {
                j0.a(checkableTextView0, ((boolean)v));
            }
            return;
        }
        ((w)this.c).e.g.n = (O)this.b;
        ((O)this.b).l(true);
        ((w)this.c).b.setVisibility(4);
        ((w)this.c).c.setVisibility(0);
    }
}

