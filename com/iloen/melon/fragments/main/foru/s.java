package com.iloen.melon.fragments.main.foru;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.adapters.common.p;
import com.melon.net.res.common.ArtistsInfoBase;
import com.melon.net.res.common.SongInfoBase;

public final class s implements View.OnClickListener {
    public final int a;
    public final boolean b;
    public final int c;
    public final p d;
    public final Object e;
    public final Object f;

    public s(ForUTasteArtistAdapter forUTasteArtistFragment$ForUTasteArtistAdapter0, ArtistsInfoBase artistsInfoBase0, boolean z, ForUTasteArtistFragment forUTasteArtistFragment0, int v) {
        this.a = 0;
        super();
        this.d = forUTasteArtistFragment$ForUTasteArtistAdapter0;
        this.e = artistsInfoBase0;
        this.b = z;
        this.f = forUTasteArtistFragment0;
        this.c = v;
    }

    public s(boolean z, ForUTasteSongAdapter forUTasteSongFragment$ForUTasteSongAdapter0, ForUTasteSongFragment forUTasteSongFragment0, SongInfoBase songInfoBase0, int v) {
        this.a = 1;
        super();
        this.b = z;
        this.d = forUTasteSongFragment$ForUTasteSongAdapter0;
        this.e = forUTasteSongFragment0;
        this.f = songInfoBase0;
        this.c = v;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            ForUTasteSongAdapter.onBindViewImpl$lambda$1$lambda$0(this.b, ((ForUTasteSongAdapter)this.d), ((ForUTasteSongFragment)this.e), ((SongInfoBase)this.f), this.c, view0);
            return;
        }
        ForUTasteArtistAdapter.onBindViewImpl$lambda$2$lambda$1(((ForUTasteArtistAdapter)this.d), ((ArtistsInfoBase)this.e), this.b, ((ForUTasteArtistFragment)this.f), this.c, view0);
    }
}

