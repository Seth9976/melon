package com.iloen.melon.fragments.genre;

public final class d implements Runnable {
    public final GenreArtistDetailFragment a;

    public d(GenreArtistDetailFragment genreArtistDetailFragment0) {
        this.a = genreArtistDetailFragment0;
    }

    @Override
    public final void run() {
        GenreArtistDetailFragment.updateHeader$lambda$8(this.a);
    }
}

