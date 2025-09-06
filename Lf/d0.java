package lf;

import rf.n;

public enum d0 implements n {
    WARNING(0),
    ERROR(1),
    HIDDEN(2);

    public final int a;

    public d0(int v1) {
        this.a = v1;
    }

    @Override  // rf.n
    public final int a() {
        return this.a;
    }
}

