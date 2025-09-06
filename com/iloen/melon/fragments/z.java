package com.iloen.melon.fragments;

import we.a;

public final class z implements a {
    public final int a;
    public final MetaContentBaseFragment b;
    public final String c;
    public final String d;

    public z(MetaContentBaseFragment metaContentBaseFragment0, String s, String s1, int v) {
        this.a = v;
        this.b = metaContentBaseFragment0;
        this.c = s;
        this.d = s1;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return this.b.lambda$showDeleteDjPlaylistPopup$9(this.c, this.d);
            }
            case 1: {
                return this.b.lambda$showDeletePlaylistPopup$14(this.c, this.d);
            }
            default: {
                return this.b.lambda$showKakaoProfileMusicSetPopup$2(this.c, this.d);
            }
        }
    }
}

