package androidx.recyclerview.widget;

public final class c implements a0 {
    public final Object a;

    public c(Object object0) {
        this.a = object0;
        super();
    }

    @Override  // androidx.recyclerview.widget.a0
    public void e(int v, int v1) {
        ((j0)this.a).notifyItemRangeInserted(v, v1);
    }

    @Override  // androidx.recyclerview.widget.a0
    public void i(int v, int v1) {
        ((j0)this.a).notifyItemRangeRemoved(v, v1);
    }

    @Override  // androidx.recyclerview.widget.a0
    public void q(int v, int v1, Object object0) {
        ((j0)this.a).notifyItemRangeChanged(v, v1, object0);
    }

    @Override  // androidx.recyclerview.widget.a0
    public void s(int v, int v1) {
        ((j0)this.a).notifyItemMoved(v, v1);
    }
}

