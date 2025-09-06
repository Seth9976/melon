package G;

import F.L;

public interface m0 {
    // 去混淆评级： 低(20)
    default boolean a(L l0, L l1) {
        return l0.equals(this.c()) && l1.equals(this.b());
    }

    Object b();

    Object c();
}

