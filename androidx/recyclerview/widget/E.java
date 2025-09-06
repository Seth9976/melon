package androidx.recyclerview.widget;

import androidx.fragment.app.F0;

public final class e extends s {
    public final F0 a;

    public e(F0 f00) {
        this.a = f00;
    }

    @Override  // androidx.recyclerview.widget.s
    public final boolean areContentsTheSame(int v, int v1) {
        F0 f00 = this.a;
        Object object0 = f00.c.get(v);
        Object object1 = f00.d.get(v1);
        if(object0 != null && object1 != null) {
            return ((v)((h)f00.f).b.c).areContentsTheSame(object0, object1);
        }
        if(object0 != null || object1 != null) {
            throw new AssertionError();
        }
        return true;
    }

    @Override  // androidx.recyclerview.widget.s
    public final boolean areItemsTheSame(int v, int v1) {
        Object object0 = this.a.c.get(v);
        Object object1 = this.a.d.get(v1);
        return object0 == null || object1 == null ? object0 == null && object1 == null : ((v)((h)this.a.f).b.c).areItemsTheSame(object0, object1);
    }

    @Override  // androidx.recyclerview.widget.s
    public final Object getChangePayload(int v, int v1) {
        F0 f00 = this.a;
        Object object0 = f00.c.get(v);
        Object object1 = f00.d.get(v1);
        if(object0 == null || object1 == null) {
            throw new AssertionError();
        }
        return ((v)((h)f00.f).b.c).getChangePayload(object0, object1);
    }

    @Override  // androidx.recyclerview.widget.s
    public final int getNewListSize() {
        return this.a.d.size();
    }

    @Override  // androidx.recyclerview.widget.s
    public final int getOldListSize() {
        return this.a.c.size();
    }
}

