package com.iloen.melon.fragments.local;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.fragments.MetaContentBaseFragment;

public final class f implements View.OnClickListener {
    public final int a;
    public final int b;
    public final MetaContentBaseFragment c;

    public f(MetaContentBaseFragment metaContentBaseFragment0, int v, int v1) {
        this.a = v1;
        this.c = metaContentBaseFragment0;
        this.b = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                LocalContentAllSongAdapter.onBindViewImpl$lambda$0(((LocalContentAllSongFragment)this.c), this.b, view0);
                return;
            }
            case 1: {
                LocalArtistAdapter.onBindViewImpl$lambda$2$lambda$0(((LocalContentArtistListFragment)this.c), this.b, view0);
                return;
            }
            case 2: {
                LocalGenreAdapter.onBindViewImpl$lambda$2$lambda$0(((LocalContentGenreListFragment)this.c), this.b, view0);
                return;
            }
            case 3: {
                LocalFolderListAdapter.onBindViewImpl$lambda$2(((LocalFolderListFragment)this.c), this.b, view0);
                return;
            }
            case 4: {
                LocalPlaylistDetailSongAdapter.onBindViewImpl$lambda$0(((LocalPlaylistDetailEditFragment)this.c), this.b, view0);
                return;
            }
            default: {
                LocalSongAdapter.onBindViewImpl$lambda$0(((LocalContentBaseUIFragment)this.c), this.b, view0);
            }
        }
    }
}

