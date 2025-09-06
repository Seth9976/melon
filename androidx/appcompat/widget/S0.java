package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;

public final class s0 implements AdapterView.OnItemSelectedListener {
    public final int a;
    public final Object b;

    public s0(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    private final void a(AdapterView adapterView0) {
    }

    private final void b(AdapterView adapterView0) {
    }

    @Override  // android.widget.AdapterView$OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView0, View view0, int v, long v1) {
        if(this.a != 0) {
            ((SearchView)this.b).o(v);
            return;
        }
        if(v != -1) {
            o0 o00 = ((ListPopupWindow)this.b).c;
            if(o00 != null) {
                o00.setListSelectionHidden(false);
            }
        }
    }

    @Override  // android.widget.AdapterView$OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView0) {
    }
}

