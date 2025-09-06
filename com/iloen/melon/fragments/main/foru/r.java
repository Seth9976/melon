package com.iloen.melon.fragments.main.foru;

public final class r implements Runnable {
    public final int a;
    public final ForUTasteArtistFragment b;
    public final int c;

    public r(ForUTasteArtistFragment forUTasteArtistFragment0, int v, int v1) {
        this.a = v1;
        this.b = forUTasteArtistFragment0;
        this.c = v;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            ForUTasteArtistAdapter.fetchSimilarArtist$lambda$7$lambda$6(this.b, this.c);
            return;
        }
        ForUTasteArtistAdapter.onBindViewImpl$lambda$2$lambda$1$lambda$0(this.b, this.c);
    }
}

