package com.iloen.melon.custom;

import android.view.View.OnClickListener;
import android.view.View;
import java.util.List;
import we.n;

public final class d implements View.OnClickListener {
    public final int a;
    public final ArtistCardRelayRollingView b;
    public final int c;
    public final List d;

    public d(ArtistCardRelayRollingView artistCardRelayRollingView0, int v, List list0, int v1) {
        this.a = v1;
        this.b = artistCardRelayRollingView0;
        this.c = v;
        this.d = list0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            n n0 = this.b.getOnClickListener();
            if(n0 != null) {
                Object object0 = this.d.get(this.c);
                n0.invoke(this.c, object0);
            }
            return;
        }
        n n1 = this.b.getOnClickListener();
        if(n1 != null) {
            Object object1 = this.d.get(this.c);
            n1.invoke(this.c, object1);
        }
    }
}

