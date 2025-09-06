package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;

public final class w implements AdapterView.OnItemClickListener {
    public final MaterialCalendarGridView a;
    public final y b;

    public w(y y0, MaterialCalendarGridView materialCalendarGridView0) {
        this.b = y0;
        this.a = materialCalendarGridView0;
    }

    @Override  // android.widget.AdapterView$OnItemClickListener
    public final void onItemClick(AdapterView adapterView0, View view0, int v, long v1) {
        MaterialCalendarGridView materialCalendarGridView0 = this.a;
        v v2 = materialCalendarGridView0.a();
        if(v >= v2.a() && v <= v2.c()) {
            long v3 = (long)materialCalendarGridView0.a().b(v);
            p p0 = this.b.d.a;
            if(p0.d.c.i(v3)) {
                p0.c.i0(v3);
                for(Object object0: p0.a) {
                    ((r)object0).b(p0.c.c0());
                }
                p0.j.getAdapter().notifyDataSetChanged();
                RecyclerView recyclerView0 = p0.i;
                if(recyclerView0 != null) {
                    recyclerView0.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }
}

