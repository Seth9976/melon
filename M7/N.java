package M7;

import t7.f;

public enum n implements f {
    EVENT_TYPE_UNKNOWN(0),  // 此枚举字段已被移除
    SESSION_START(1);

    public final int a;

    public n(int v1) {
        this.a = v1;
    }

    @Override  // t7.f
    public final int a() {
        return this.a;
    }
}

