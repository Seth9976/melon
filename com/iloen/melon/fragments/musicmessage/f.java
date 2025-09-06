package com.iloen.melon.fragments.musicmessage;

import android.view.View.OnClickListener;
import android.view.View;
import java.util.ArrayList;

public final class f implements View.OnClickListener {
    public final ArrayList a;
    public final int b;
    public final boolean c;

    public f(ArrayList arrayList0, int v, boolean z) {
        this.a = arrayList0;
        this.b = v;
        this.c = z;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        MemberGridAdapter.a(this.a, this.b, this.c, view0);
    }
}

