package com.iloen.melon.fragments.genre;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v5x.response.GenreLabelDetailRes.RESPONSE.LABELINFO.ARTISTLIST;

public final class j implements View.OnClickListener {
    public final int a;
    public final int b;
    public final Object c;

    public j(Object object0, int v, int v1) {
        this.a = v1;
        this.c = object0;
        this.b = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            NewSongAdapter.onBindViewImpl$lambda$0(((GenreDetailMoreNewSongFragment)this.c), this.b, view0);
            return;
        }
        GenreDetailLabelAdapter.onBindViewImpl$lambda$23$lambda$22$lambda$21$lambda$19(((ARTISTLIST)this.c), this.b, view0);
    }
}

