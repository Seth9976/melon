package com.iloen.melon.fragments.main.foru;

import com.android.volley.Response.Listener;

public final class t implements Listener {
    public final ForUTasteArtistFragment a;
    public final ForUTasteArtistAdapter b;
    public final String c;
    public final int d;

    public t(ForUTasteArtistFragment forUTasteArtistFragment0, ForUTasteArtistAdapter forUTasteArtistFragment$ForUTasteArtistAdapter0, String s, int v) {
        this.a = forUTasteArtistFragment0;
        this.b = forUTasteArtistFragment$ForUTasteArtistAdapter0;
        this.c = s;
        this.d = v;
    }

    @Override  // com.android.volley.Response$Listener
    public final void onResponse(Object object0) {
        ForUTasteArtistAdapter.fetchSimilarArtist$lambda$7(this.a, this.b, this.c, this.d, object0);
    }
}

