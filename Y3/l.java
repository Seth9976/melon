package Y3;

import Ac.X3;
import I6.Q;
import I6.V;
import e3.e;

public interface l {
    void g(byte[] arg1, int arg2, int arg3, k arg4, e arg5);

    default d i(byte[] arr_b, int v, int v1) {
        Q q0 = V.o();
        X3 x30 = new X3(q0, 19);
        this.g(arr_b, 0, v1, k.c, x30);
        return new b(q0.g());
    }

    int j();

    default void reset() {
    }
}

