package com.iloen.melon.fragments.local;

import we.a;

public final class o implements a {
    public final int a;
    public final LocalContentGenreListFragment b;
    public final int c;

    public o(LocalContentGenreListFragment localContentGenreListFragment0, int v, int v1) {
        this.a = v1;
        this.b = localContentGenreListFragment0;
        this.c = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        return this.a == 0 ? com.iloen.melon.fragments.local.LocalContentGenreListFragment.showContextListPopup.1.2.invokeSuspend$lambda$0(this.b, this.c) : LocalContentGenreListFragment.deleteGenre$lambda$3$lambda$2(this.b, this.c);
    }
}

