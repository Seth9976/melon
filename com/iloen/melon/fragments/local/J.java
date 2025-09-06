package com.iloen.melon.fragments.local;

import android.view.View.OnLongClickListener;
import android.view.View;
import com.iloen.melon.fragments.MetaContentBaseFragment;

public final class j implements View.OnLongClickListener {
    public final int a;
    public final int b;
    public final MetaContentBaseFragment c;

    public j(MetaContentBaseFragment metaContentBaseFragment0, int v, int v1) {
        this.a = v1;
        this.c = metaContentBaseFragment0;
        this.b = v;
        super();
    }

    @Override  // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view0) {
        return this.a == 0 ? LocalArtistAdapter.onBindViewImpl$lambda$2$lambda$1(((LocalContentArtistListFragment)this.c), this.b, view0) : LocalFolderListAdapter.onBindViewImpl$lambda$3(((LocalFolderListFragment)this.c), this.b, view0);
    }
}

