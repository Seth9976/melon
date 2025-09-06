package com.iloen.melon.fragments.mymusic;

import android.view.View.OnFocusChangeListener;
import android.view.View;

public final class l0 implements View.OnFocusChangeListener {
    public final SeriesEditMenuViewHolder a;
    public final String b;
    public final SeriesPlaylistMakeAdapter c;

    public l0(SeriesEditMenuViewHolder seriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter$SeriesEditMenuViewHolder0, String s, SeriesPlaylistMakeAdapter seriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter0) {
        this.a = seriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter$SeriesEditMenuViewHolder0;
        this.b = s;
        this.c = seriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter0;
    }

    @Override  // android.view.View$OnFocusChangeListener
    public final void onFocusChange(View view0, boolean z) {
        SeriesEditMenuViewHolder.bindItem$lambda$0(this.a, this.b, this.c, view0, z);
    }
}

