package androidx.recyclerview.widget;

public final class R0 extends A0 {
    public boolean a;
    public final f0 b;

    public R0(f0 f00) {
        this.b = f00;
        this.a = false;
    }

    @Override  // androidx.recyclerview.widget.A0
    public final void onScrollStateChanged(RecyclerView recyclerView0, int v) {
        super.onScrollStateChanged(recyclerView0, v);
        if(v == 0 && this.a) {
            this.a = false;
            this.b.h();
        }
    }

    @Override  // androidx.recyclerview.widget.A0
    public final void onScrolled(RecyclerView recyclerView0, int v, int v1) {
        if(v == 0 && v1 == 0) {
            return;
        }
        this.a = true;
    }
}

