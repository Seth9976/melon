package com.iloen.melon.utils.log;

import ie.H;
import p0.p;

public final class a implements we.a {
    public final int a;
    public final Object b;
    public final long c;

    public a(Object object0, long v, int v1) {
        this.a = v1;
        this.b = object0;
        this.c = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return ((String)this.b) + " [" + (System.currentTimeMillis() - this.c) + " Ms]";
            }
            case 1: {
                return ((String)this.b) + " [" + (System.currentTimeMillis() - this.c) + " Ms]";
            }
            case 2: {
                return ((String)this.b) + " [" + (System.currentTimeMillis() - this.c) + " Ms]";
            }
            case 3: {
                return ((String)this.b) + " [" + (System.currentTimeMillis() - this.c) + " Ms]";
            }
            case 4: {
                return ((String)this.b) + " [" + (System.currentTimeMillis() - this.c) + " Ms]";
            }
            default: {
                ((p)this.b).remove(this.c);
                return H.a;
            }
        }
    }
}

