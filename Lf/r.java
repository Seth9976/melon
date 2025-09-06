package lf;

import rf.n;

public enum r implements n {
    RETURNS_CONSTANT(0),
    CALLS(1),
    RETURNS_NOT_NULL(2);

    public final int a;

    public r(int v1) {
        this.a = v1;
    }

    @Override  // rf.n
    public final int a() {
        return this.a;
    }
}

