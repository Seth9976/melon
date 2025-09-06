package com.iloen.melon.adapters.common;

import android.view.View;
import androidx.recyclerview.widget.A0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.w0;

public abstract class g extends A0 {
    private static final String TAG = "EndlessRecyclerOnScrollListener";
    private int mLastVisibleItemIndex;
    private A mRecyclerViewHelper;

    public g() {
        this.mLastVisibleItemIndex = -1;
    }

    public final void a(int v) {
        if(v == 0) {
            A a0 = this.mRecyclerViewHelper;
            if(a0 != null) {
                View view0 = a0.a.getLayoutManager().getChildAt(0);
                int v1 = view0.getMeasuredHeight();
                this.onParallax(Math.abs(view0.getY()) / ((float)v1));
                return;
            }
        }
        if(v == -1) {
            this.onParallax(0.0f);
            return;
        }
        this.onParallax(1.0f);
    }

    public abstract void onLastItemVisibleChanged(RecyclerView arg1, boolean arg2);

    public abstract void onParallax(float arg1);

    public abstract void onScrollDown();

    @Override  // androidx.recyclerview.widget.A0
    public void onScrollStateChanged(RecyclerView recyclerView0, int v) {
        super.onScrollStateChanged(recyclerView0, v);
    }

    public abstract void onScrollUp();

    @Override  // androidx.recyclerview.widget.A0
    public void onScrolled(RecyclerView recyclerView0, int v, int v1) {
        super.onScrolled(recyclerView0, v, v1);
        if(this.mRecyclerViewHelper == null) {
            if(recyclerView0 == null) {
                throw new NullPointerException("Recycler View is null");
            }
            this.mRecyclerViewHelper = new A(recyclerView0);
        }
        if(recyclerView0 != this.mRecyclerViewHelper.a) {
            this.mRecyclerViewHelper = null;
            if(recyclerView0 == null) {
                throw new NullPointerException("Recycler View is null");
            }
            this.mRecyclerViewHelper = new A(recyclerView0);
        }
        int v2 = recyclerView0.getChildCount();
        w0 w00 = this.mRecyclerViewHelper.b;
        int v3 = w00 == null ? 0 : w00.getItemCount();
        int v4 = this.mRecyclerViewHelper.a();
        if(v2 != 0 && v3 != 0) {
            int v5 = v2 + v4;
            if(v5 + 1 < v3) {
                this.onLastItemVisibleChanged(recyclerView0, false);
            }
            else if(v5 != this.mLastVisibleItemIndex) {
                this.mLastVisibleItemIndex = v5;
                this.onLastItemVisibleChanged(recyclerView0, true);
            }
            else {
                this.mLastVisibleItemIndex = -1;
            }
            this.a(v4);
            if(v1 > 0) {
                this.onScrollDown();
                return;
            }
            this.onScrollUp();
        }
    }

    public void requestLayoutOnParallax() {
        A a0 = this.mRecyclerViewHelper;
        if(a0 != null) {
            this.a(a0.a());
        }
    }
}

