package com.iloen.melon.popup;

import androidx.compose.runtime.b0;
import ie.H;
import j5.d;
import kotlin.jvm.internal.q;
import r1.l;
import we.k;

public final class g implements k {
    public final int a;
    public final b0 b;

    public g(b0 b00, int v) {
        this.a = v;
        this.b = b00;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        b0 b00 = this.b;
        switch(this.a) {
            case 0: {
                ((Integer)object0).intValue();
                b00.setValue(((Integer)object0));
                return h0;
            }
            case 1: {
                ((Integer)object0).intValue();
                b00.setValue(((Integer)object0));
                return h0;
            }
            case 2: {
                ((Integer)object0).intValue();
                b00.setValue(((Integer)object0));
                return h0;
            }
            case 3: {
                q.g(((d)object0), "it");
                b00.setValue(43);
                return h0;
            }
            default: {
                b00.setValue(new l(((l)object0).a));
                return h0;
            }
        }
    }
}

