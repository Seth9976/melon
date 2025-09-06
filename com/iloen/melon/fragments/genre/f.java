package com.iloen.melon.fragments.genre;

import android.view.View.OnClickListener;
import android.view.View;
import java.util.ArrayList;

public final class f implements View.OnClickListener {
    public final int a;
    public final ArrayList b;
    public final int c;

    public f(ArrayList arrayList0, int v, int v1) {
        this.a = v1;
        this.b = arrayList0;
        this.c = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            GenreDetailLabelAdapter.onBindViewImpl$lambda$16$lambda$15$lambda$14$lambda$11(this.b, this.c, view0);
            return;
        }
        GenreDetailLabelAdapter.onBindViewImpl$lambda$16$lambda$15$lambda$14$lambda$9(this.b, this.c, view0);
    }
}

