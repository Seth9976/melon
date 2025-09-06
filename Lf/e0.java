package lf;

import rf.n;

public enum e0 implements n {
    LANGUAGE_VERSION(0),
    COMPILER_VERSION(1),
    API_VERSION(2);

    public final int a;

    public e0(int v1) {
        this.a = v1;
    }

    @Override  // rf.n
    public final int a() {
        return this.a;
    }
}

