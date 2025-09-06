package Ge;

import De.g;
import Me.K;
import Pe.G;

public abstract class h0 extends s implements g {
    @Override  // Ge.s
    public final F h() {
        return this.s().g;
    }

    @Override  // Ge.s
    public final He.g i() {
        return null;
    }

    @Override  // De.g
    public final boolean isExternal() {
        return ((G)this.r()).f;
    }

    @Override  // De.g
    public final boolean isInfix() {
        this.r();
        return false;
    }

    @Override  // De.g
    public final boolean isInline() {
        return ((G)this.r()).i;
    }

    @Override  // De.g
    public final boolean isOperator() {
        this.r();
        return false;
    }

    @Override  // De.g, De.c
    public final boolean isSuspend() {
        this.r();
        return false;
    }

    @Override  // Ge.s
    public final boolean q() {
        return this.s().q();
    }

    public abstract K r();

    public abstract m0 s();
}

