package com.iloen.melon.fragments.mymusic;

import com.melon.ui.k2;
import java.util.ArrayList;
import we.k;

public final class o implements k {
    public final int a;
    public final Object b;
    public final Object c;

    public o(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return this.a == 0 ? MemberProfileEditFragment.showSnsChannelPopup$lambda$8(((ArrayList)this.b), ((MemberProfileEditFragment)this.c), ((k2)object0)) : ((SeriesFolderDetailFragment)this.b).lambda$showEditPopup$1(((String)this.c), ((k2)object0));
    }
}

