package com.iloen.melon.fragments.detail;

import com.android.volley.Response.Listener;

public final class z implements Listener {
    public final int a;
    public final PhotoDetailViewFragment b;
    public final PhotoInfoList c;

    public z(PhotoDetailViewFragment photoDetailViewFragment0, PhotoInfoList photoDetailViewFragment$PhotoInfoList0, int v) {
        this.a = v;
        this.b = photoDetailViewFragment0;
        this.c = photoDetailViewFragment$PhotoInfoList0;
        super();
    }

    @Override  // com.android.volley.Response$Listener
    public final void onResponse(Object object0) {
        if(this.a != 0) {
            PhotoDetailViewFragment.executeArtistContentsPhotoListReq$lambda$26(this.b, this.c, object0);
            return;
        }
        PhotoDetailViewFragment.executeAlbumContentsPhotoListReq$lambda$33(this.b, this.c, object0);
    }
}

