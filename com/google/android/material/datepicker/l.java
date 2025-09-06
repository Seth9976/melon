package com.google.android.material.datepicker;

import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public final class l extends LinearLayoutManager {
    public final int a;
    public final p b;

    public l(p p0, int v, int v1) {
        this.b = p0;
        this.a = v1;
        super(v, false);
    }

    @Override  // androidx.recyclerview.widget.LinearLayoutManager
    public final void calculateExtraLayoutSpace(K0 k00, int[] arr_v) {
        p p0 = this.b;
        if(this.a == 0) {
            arr_v[0] = p0.j.getWidth();
            arr_v[1] = p0.j.getWidth();
            return;
        }
        arr_v[0] = p0.j.getHeight();
        arr_v[1] = p0.j.getHeight();
    }

    @Override  // androidx.recyclerview.widget.LinearLayoutManager
    public final void smoothScrollToPosition(RecyclerView recyclerView0, K0 k00, int v) {
        C c0 = new C(recyclerView0.getContext());  // 初始化器: Landroidx/recyclerview/widget/LinearSmoothScroller;-><init>(Landroid/content/Context;)V
        c0.setTargetPosition(v);
        this.startSmoothScroll(c0);
    }
}

