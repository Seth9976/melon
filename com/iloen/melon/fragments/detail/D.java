package com.iloen.melon.fragments.detail;

import B9.e;
import android.view.View.OnClickListener;
import android.view.View;
import androidx.recyclerview.widget.O0;

public final class d implements View.OnClickListener {
    public final AlbumDetailContentsPhotoFragment a;
    public final O0 b;
    public final int c;

    public d(AlbumDetailContentsPhotoFragment albumDetailContentsPhotoFragment0, e e0, int v) {
        this.a = albumDetailContentsPhotoFragment0;
        this.b = e0;
        this.c = v;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        PhotoAdapter.onBindViewImpl$lambda$1(this.a, this.b, this.c, view0);
    }
}

