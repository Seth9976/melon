package com.iloen.melon.fragments.local;

import H8.l;
import android.view.View.OnLongClickListener;
import android.view.View;

public final class b implements View.OnLongClickListener {
    public final int a;
    public final int b;
    public final Object c;
    public final Object d;

    public b(LocalPlaylistAdapter localPlaylistFragment$LocalPlaylistAdapter0, LocalPlaylistFragment localPlaylistFragment0, int v) {
        this.a = 2;
        super();
        this.c = localPlaylistFragment$LocalPlaylistAdapter0;
        this.d = localPlaylistFragment0;
        this.b = v;
    }

    public b(Object object0, int v, Object object1, int v1) {
        this.a = v1;
        this.c = object0;
        this.b = v;
        this.d = object1;
        super();
    }

    @Override  // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view0) {
        switch(this.a) {
            case 0: {
                return LocalAlbumAdapter.onBindViewImpl$lambda$3$lambda$2(((LocalAlbumAdapter)this.c), this.b, ((LocalContentAlbumListFragment)this.d), view0);
            }
            case 1: {
                return LocalGenreAdapter.onBindViewImpl$lambda$2$lambda$1(((LocalContentGenreListFragment)this.c), this.b, ((l)this.d), view0);
            }
            default: {
                return LocalPlaylistAdapter.f(((LocalPlaylistAdapter)this.c), ((LocalPlaylistFragment)this.d), this.b, view0);
            }
        }
    }
}

