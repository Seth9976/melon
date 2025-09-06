package lf;

import rf.n;

public enum j implements n {
    CLASS(0),
    INTERFACE(1),
    ENUM_CLASS(2),
    ENUM_ENTRY(3),  // 此枚举字段已被移除
    ANNOTATION_CLASS(4),
    OBJECT(5),  // 此枚举字段已被移除
    COMPANION_OBJECT(6);

    public final int a;

    public j(int v1) {
        this.a = v1;
    }

    @Override  // rf.n
    public final int a() {
        return this.a;
    }
}

