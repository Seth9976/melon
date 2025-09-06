package com.iloen.melon.fragments;

import we.a;

public final class w implements a {
    public final int a;
    public final MelonWidgetMoreViewFragment b;

    public w(MelonWidgetMoreViewFragment melonWidgetMoreViewFragment0, int v) {
        this.a = v;
        this.b = melonWidgetMoreViewFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return this.b.lambda$showMorePopup$0();
            }
            case 1: {
                return this.b.lambda$showMorePopup$1();
            }
            case 2: {
                return this.b.lambda$showMorePopup$2();
            }
            default: {
                return this.b.lambda$showMorePopup$3();
            }
        }
    }
}

