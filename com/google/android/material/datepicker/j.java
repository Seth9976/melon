package com.google.android.material.datepicker;

import android.view.View.OnClickListener;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Calendar;

public final class j implements View.OnClickListener {
    public final int a;
    public final y b;
    public final p c;

    public j(p p0, y y0, int v) {
        this.a = v;
        this.c = p0;
        this.b = y0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            p p0 = this.c;
            int v = ((LinearLayoutManager)p0.j.getLayoutManager()).findFirstVisibleItemPosition();
            if(v + 1 < p0.j.getAdapter().getItemCount()) {
                Calendar calendar0 = E.c(this.b.a.a.a);
                calendar0.add(2, v + 1);
                p0.m(new Month(calendar0));
            }
            return;
        }
        p p1 = this.c;
        int v1 = ((LinearLayoutManager)p1.j.getLayoutManager()).findLastVisibleItemPosition();
        if(v1 - 1 >= 0) {
            Calendar calendar1 = E.c(this.b.a.a.a);
            calendar1.add(2, v1 - 1);
            p1.m(new Month(calendar1));
        }
    }
}

