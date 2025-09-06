package com.google.android.material.datepicker;

import androidx.recyclerview.widget.A0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;

public final class o extends A0 {
    public final y a;
    public final MaterialButton b;
    public final p c;

    public o(p p0, y y0, MaterialButton materialButton0) {
        this.c = p0;
        this.a = y0;
        this.b = materialButton0;
    }

    @Override  // androidx.recyclerview.widget.A0
    public final void onScrollStateChanged(RecyclerView recyclerView0, int v) {
        if(v == 0) {
            recyclerView0.announceForAccessibility(this.b.getText());
        }
    }

    @Override  // androidx.recyclerview.widget.A0
    public final void onScrolled(RecyclerView recyclerView0, int v, int v1) {
        int v2 = v >= 0 ? ((LinearLayoutManager)this.c.j.getLayoutManager()).findLastVisibleItemPosition() : ((LinearLayoutManager)this.c.j.getLayoutManager()).findFirstVisibleItemPosition();
        Calendar calendar0 = E.c(this.a.a.a.a);
        calendar0.add(2, v2);
        this.c.f = new Month(calendar0);
        Calendar calendar1 = E.c(this.a.a.a.a);
        calendar1.add(2, v2);
        String s = new Month(calendar1).d();
        this.b.setText(s);
    }
}

