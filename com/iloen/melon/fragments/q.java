package com.iloen.melon.fragments;

import we.a;

public final class q implements a {
    public final int a;
    public final Object b;

    public q(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return ((com.iloen.melon.fragments.MelonBaseFragment.22)this.b).lambda$run$0();
            }
            case 1: {
                return ((com.iloen.melon.fragments.MelonBaseFragment.22)this.b).lambda$run$1();
            }
            default: {
                return com.iloen.melon.fragments.MelonBaseFragment.25.lambda$run$0(((OnDismissListener)this.b));
            }
        }
    }
}

