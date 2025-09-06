package com.google.android.material.search;

import android.view.View.OnClickListener;
import android.view.View;

public final class b implements View.OnClickListener {
    public final int a;
    public final SearchView b;

    public b(SearchView searchView0, int v) {
        this.a = v;
        this.b = searchView0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        SearchView searchView0 = this.b;
        switch(this.a) {
            case 0: {
                searchView0.j.setText("");
                searchView0.i();
                return;
            }
            case 1: {
                searchView0.k();
                return;
            }
            default: {
                if(!searchView0.W.equals(h.b) && !searchView0.W.equals(h.a)) {
                    searchView0.o.j();
                }
            }
        }
    }
}

