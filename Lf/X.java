package lf;

import rf.n;

public enum x implements n {
    TRUE(0),
    FALSE(1),
    NULL(2);

    public final int a;

    public x(int v1) {
        this.a = v1;
    }

    @Override  // rf.n
    public final int a() {
        return this.a;
    }
}

