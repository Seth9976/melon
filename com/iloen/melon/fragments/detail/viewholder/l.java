package com.iloen.melon.fragments.detail.viewholder;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.net.v5x.response.DetailBaseRes.MAGAZINE;
import com.iloen.melon.net.v5x.response.DetailBaseRes.PHOTO;
import com.iloen.melon.net.v5x.response.DetailBaseRes.VIDEO;
import com.melon.net.res.common.MvInfoBase;

public final class l implements View.OnClickListener {
    public final int a;
    public final int b;
    public final Object c;
    public final Object d;

    public l(PhotoHolder photoHolder0, int v, PHOTO detailBaseRes$PHOTO0) {
        this.a = 4;
        super();
        this.c = photoHolder0;
        this.b = v;
        this.d = detailBaseRes$PHOTO0;
    }

    public l(MAGAZINE detailBaseRes$MAGAZINE0, MagazineHolder magazineHolder0, int v) {
        this.a = 3;
        super();
        this.d = detailBaseRes$MAGAZINE0;
        this.c = magazineHolder0;
        this.b = v;
    }

    public l(Object object0, Object object1, int v, int v1) {
        this.a = v1;
        this.c = object0;
        this.d = object1;
        this.b = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                DetailContentsMagazineItemHolder.bind$lambda$3(((DetailContentsMagazineItemHolder)this.c), ((MAGAZINE)this.d), this.b, view0);
                return;
            }
            case 1: {
                DetailContentsMvItemHolder.bind$lambda$3(((DetailContentsMvItemHolder)this.c), ((MvInfoBase)this.d), this.b, view0);
                return;
            }
            case 2: {
                DetailContentsPhotoItemHolder.bind$lambda$2$lambda$1(((DetailContentsPhotoItemHolder)this.c), ((PHOTO)this.d), this.b, view0);
                return;
            }
            case 3: {
                MagazineHolder.bindItem$lambda$2(((MAGAZINE)this.d), ((MagazineHolder)this.c), this.b, view0);
                return;
            }
            case 4: {
                PhotoHolder.bindItem$lambda$4(((PhotoHolder)this.c), this.b, ((PHOTO)this.d), view0);
                return;
            }
            case 5: {
                PlaylistTagHolder.bindItem$lambda$3$lambda$2(((TagInfoBase)this.c), ((PlaylistTagHolder)this.d), this.b, view0);
                return;
            }
            default: {
                VideoHolder.bindItem$lambda$3(((VIDEO)this.c), ((VideoHolder)this.d), this.b, view0);
            }
        }
    }
}

