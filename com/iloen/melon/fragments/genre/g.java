package com.iloen.melon.fragments.genre;

import android.view.View.OnClickListener;
import android.view.View;
import java.util.ArrayList;

public final class g implements View.OnClickListener {
    public final int a;
    public final GenreDetailLabelBottomFragment b;
    public final ArrayList c;
    public final int d;
    public final GenreDetailLabelAdapter e;

    public g(GenreDetailLabelBottomFragment genreDetailLabelBottomFragment0, ArrayList arrayList0, int v, GenreDetailLabelAdapter genreDetailLabelBottomFragment$GenreDetailLabelAdapter0, int v1) {
        this.a = v1;
        this.b = genreDetailLabelBottomFragment0;
        this.c = arrayList0;
        this.d = v;
        this.e = genreDetailLabelBottomFragment$GenreDetailLabelAdapter0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            GenreDetailLabelAdapter.onBindViewImpl$lambda$16$lambda$15$lambda$14$lambda$12(this.b, this.c, this.d, this.e, view0);
            return;
        }
        GenreDetailLabelAdapter.onBindViewImpl$lambda$16$lambda$15$lambda$14$lambda$10(this.b, this.c, this.d, this.e, view0);
    }
}

