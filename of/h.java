package of;

import rf.n;

public enum h implements n {
    NONE(0),
    INTERNAL_TO_CLASS_ID(1),
    DESC_TO_CLASS_ID(2);

    public final int a;

    public h(int v1) {
        this.a = v1;
    }

    @Override  // rf.n
    public final int a() {
        return this.a;
    }
}

