package androidx.viewpager2.adapter;

import androidx.recyclerview.widget.l0;
import com.iloen.melon.adapters.common.MelonCursorAdapter;
import com.iloen.melon.custom.RecyclerViewWithEmptyView;

public final class d extends l0 {
    public final int a;
    public final Object b;

    public d(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // androidx.recyclerview.widget.l0
    public final void onChanged() {
        Object object0 = this.b;
        switch(this.a) {
            case 0: {
                ((f)object0).b(true);
                return;
            }
            case 1: {
                MelonCursorAdapter.b(((MelonCursorAdapter)object0));
                return;
            }
            default: {
                ((RecyclerViewWithEmptyView)object0).h0();
            }
        }
    }

    @Override  // androidx.recyclerview.widget.l0
    public void onItemRangeChanged(int v, int v1) {
        if(this.a != 0) {
            super.onItemRangeChanged(v, v1);
            return;
        }
        this.onChanged();
    }

    @Override  // androidx.recyclerview.widget.l0
    public void onItemRangeChanged(int v, int v1, Object object0) {
        if(this.a != 0) {
            super.onItemRangeChanged(v, v1, object0);
            return;
        }
        this.onChanged();
    }

    @Override  // androidx.recyclerview.widget.l0
    public final void onItemRangeInserted(int v, int v1) {
        Object object0 = this.b;
        switch(this.a) {
            case 0: {
                this.onChanged();
                return;
            }
            case 1: {
                MelonCursorAdapter.b(((MelonCursorAdapter)object0));
                return;
            }
            default: {
                ((RecyclerViewWithEmptyView)object0).h0();
            }
        }
    }

    @Override  // androidx.recyclerview.widget.l0
    public void onItemRangeMoved(int v, int v1, int v2) {
        if(this.a != 0) {
            super.onItemRangeMoved(v, v1, v2);
            return;
        }
        this.onChanged();
    }

    @Override  // androidx.recyclerview.widget.l0
    public final void onItemRangeRemoved(int v, int v1) {
        Object object0 = this.b;
        switch(this.a) {
            case 0: {
                this.onChanged();
                return;
            }
            case 1: {
                MelonCursorAdapter.b(((MelonCursorAdapter)object0));
                return;
            }
            default: {
                ((RecyclerViewWithEmptyView)object0).h0();
            }
        }
    }
}

