package lf;

import rf.n;

public enum s implements n {
    AT_MOST_ONCE(0),
    EXACTLY_ONCE(1),
    AT_LEAST_ONCE(2);

    public final int a;

    public s(int v1) {
        this.a = v1;
    }

    @Override  // rf.n
    public final int a() {
        return this.a;
    }
}

