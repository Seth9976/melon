package com.iloen.melon.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.viewpager2.adapter.d;

public class RecyclerViewWithEmptyView extends RecyclerView {
    public View h1;
    public final d i1;
    public static final int j1;

    public RecyclerViewWithEmptyView(Context context0) {
        super(context0);
        this.i1 = new d(this, 2);
    }

    public RecyclerViewWithEmptyView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.i1 = new d(this, 2);
    }

    public RecyclerViewWithEmptyView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.i1 = new d(this, 2);
    }

    public final void h0() {
        int v = 0;
        if(this.h1 != null && this.getAdapter() != null) {
            boolean z = this.getAdapter().getItemCount() == 0;
            this.h1.setVisibility((z ? 0 : 8));
            if(z) {
                v = 8;
            }
            this.setVisibility(v);
        }
    }

    @Override  // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(j0 j00) {
        j0 j01 = this.getAdapter();
        d d0 = this.i1;
        if(j01 != null) {
            j01.unregisterAdapterDataObserver(d0);
        }
        super.setAdapter(j00);
        if(j00 != null) {
            j00.registerAdapterDataObserver(d0);
        }
        this.h0();
    }

    public void setEmptyView(View view0) {
        this.h1 = view0;
        this.h0();
    }
}

