package com.iloen.melon.fragments;

import com.iloen.melon.adapters.common.n;

public final class l implements Runnable {
    public final int a;
    public final Object b;

    public l(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                ((n)this.b).showLoading();
                return;
            }
            case 1: {
                ((DetailMetaContentBaseFragment)this.b).lambda$clearListItems$1();
                return;
            }
            case 2: {
                ((EditorBaseFragment)this.b).lambda$onViewCreated$1();
                return;
            }
            case 3: {
                ((MelonAdapterViewBaseFragment)this.b).lambda$onFragmentVisibilityChanged$0();
                return;
            }
            default: {
                ProgramDetailFragment.onViewCreated$lambda$2$lambda$1(((ProgramDetailFragment)this.b));
            }
        }
    }
}

