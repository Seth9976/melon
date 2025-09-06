package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import d5.m;
import k.k;
import k.y;

public final class ExpandedMenuView extends ListView implements AdapterView.OnItemClickListener, k, y {
    public MenuBuilder a;
    public static final int[] b;

    static {
        ExpandedMenuView.b = new int[]{0x10100D4, 0x1010129};
    }

    public ExpandedMenuView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x1010074);
    }

    public ExpandedMenuView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0);
        this.setOnItemClickListener(this);
        m m0 = m.r(context0, attributeSet0, ExpandedMenuView.b, v);
        TypedArray typedArray0 = (TypedArray)m0.c;
        if(typedArray0.hasValue(0)) {
            this.setBackgroundDrawable(m0.k(0));
        }
        if(typedArray0.hasValue(1)) {
            this.setDivider(m0.k(1));
        }
        m0.t();
    }

    @Override  // k.y
    public final void a(MenuBuilder menuBuilder0) {
        this.a = menuBuilder0;
    }

    @Override  // k.k
    public final boolean b(k.m m0) {
        return this.a.q(m0, null, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override  // android.widget.ListView
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.setChildrenDrawingCacheEnabled(false);
    }

    @Override  // android.widget.AdapterView$OnItemClickListener
    public final void onItemClick(AdapterView adapterView0, View view0, int v, long v1) {
        this.b(((k.m)this.getAdapter().getItem(v)));
    }
}

