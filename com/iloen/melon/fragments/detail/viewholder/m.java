package com.iloen.melon.fragments.detail.viewholder;

import android.view.View.OnClickListener;
import android.view.View;

public final class m implements View.OnClickListener {
    public final int a;
    public final DetailContentsSongHolder b;
    public final DetailContentsSong c;

    public m(DetailContentsSongHolder detailContentsSongHolder0, DetailContentsSong detailContentsSongHolder$DetailContentsSong0, int v) {
        this.a = v;
        this.b = detailContentsSongHolder0;
        this.c = detailContentsSongHolder$DetailContentsSong0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                DetailContentsSongHolder.bind$lambda$7$lambda$1(this.b, this.c, view0);
                return;
            }
            case 1: {
                DetailContentsSongHolder.bind$lambda$7$lambda$2(this.b, this.c, view0);
                return;
            }
            case 2: {
                DetailContentsSongHolder.bind$lambda$7$lambda$4(this.b, this.c, view0);
                return;
            }
            default: {
                DetailContentsSongHolder.bind$lambda$7$lambda$5(this.b, this.c, view0);
            }
        }
    }
}

