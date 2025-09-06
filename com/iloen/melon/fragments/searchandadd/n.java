package com.iloen.melon.fragments.searchandadd;

import we.a;

public final class n implements a {
    public final SearchAndAddTabFragment a;
    public final boolean b;
    public final int c;

    public n(SearchAndAddTabFragment searchAndAddTabFragment0, boolean z, int v) {
        this.a = searchAndAddTabFragment0;
        this.b = z;
        this.c = v;
    }

    @Override  // we.a
    public final Object invoke() {
        return this.a.lambda$showConfirmPopup$0(this.b, this.c);
    }
}

