package com.google.android.material.textfield;

import H0.e;

public final class d extends l {
    public final int e;

    public d(k k0, int v) {
        this.e = v;
        super(k0);
    }

    @Override  // com.google.android.material.textfield.l
    public void r() {
        if(this.e != 0) {
            return;
        }
        this.b.o = null;
        this.b.g.setOnLongClickListener(null);
        e.X(this.b.g, null);
    }
}

