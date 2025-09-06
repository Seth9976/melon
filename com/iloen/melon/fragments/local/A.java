package com.iloen.melon.fragments.local;

import android.view.View.OnClickListener;
import android.view.View;

public final class a implements View.OnClickListener {
    public final int a;
    public final LocalContentAlbumListFragment b;
    public final int c;

    public a(LocalContentAlbumListFragment localContentAlbumListFragment0, int v, int v1) {
        this.a = v1;
        this.b = localContentAlbumListFragment0;
        this.c = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            LocalAlbumAdapter.onBindViewImpl$lambda$3$lambda$1(this.b, this.c, view0);
            return;
        }
        LocalAlbumAdapter.onBindViewImpl$lambda$3$lambda$0(this.b, this.c, view0);
    }
}

