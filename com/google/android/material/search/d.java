package com.google.android.material.search;

import android.view.View;
import c2.B0;
import c2.v;
import com.google.android.material.internal.B;
import com.google.android.material.internal.D;
import com.google.android.material.internal.E;

public final class d implements v, D {
    public final SearchView a;

    public d(SearchView searchView0) {
        this.a = searchView0;
        super();
    }

    @Override  // com.google.android.material.internal.D
    public B0 k(View view0, B0 b00, E e0) {
        boolean z = B.l(this.a.g);
        int v = z ? e0.c : e0.a;
        int v1 = z ? e0.a : e0.c;
        this.a.g.setPadding(b00.b() + v, e0.b, b00.c() + v1, e0.d);
        return b00;
    }

    @Override  // c2.v
    public B0 s(View view0, B0 b00) {
        SearchView.e(this.a, b00);
        return b00;
    }
}

