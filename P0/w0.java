package P0;

import J0.n;
import J0.o;

public interface w0 extends m {
    default long C() {
        return B0.a;
    }

    void L(n arg1, o arg2, long arg3);

    void N();

    default boolean h0() {
        return false;
    }

    default void j0() {
        this.N();
    }

    @Override  // P0.m
    default void onDensityChange() {
        this.N();
    }

    default void q() {
    }
}

