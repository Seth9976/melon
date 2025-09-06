package com.iloen.melon.fragments.genre;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v5x.response.GenreLabelAlbumlistRes.RESPONSE.ALBUMLIST;
import com.iloen.melon.net.v5x.response.GenreLabelDetailRes.RESPONSE.LABELINFO.ARTISTLIST;

public final class i implements View.OnClickListener {
    public final int a;
    public final int b;
    public final Object c;
    public final Object d;
    public final Object e;

    public i(Object object0, Object object1, int v, Object object2, int v1) {
        this.a = v1;
        this.c = object0;
        this.d = object1;
        this.b = v;
        this.e = object2;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            GenreDetailLabelAlbumListAdapter.onBindViewImpl$lambda$4$lambda$3$lambda$0(((ALBUMLIST)this.c), ((GenreDetailLabelAlbumListFragment)this.d), this.b, ((ALBUMLIST)this.e), view0);
            return;
        }
        GenreDetailLabelAdapter.onBindViewImpl$lambda$23$lambda$22$lambda$21$lambda$18(((GenreDetailLabelBottomFragment)this.c), ((ARTISTLIST)this.d), this.b, ((GenreDetailLabelAdapter)this.e), view0);
    }
}

