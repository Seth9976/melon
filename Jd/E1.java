package jd;

import Ad.C;

public final class e1 extends C {
    public static final e1 a;

    static {
        e1.a = new e1();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof e1;
    }

    @Override
    public final int hashCode() {
        return 0x52204925;
    }

    @Override
    public final String toString() {
        return "ShowMusicWaveMorePopup";
    }
}

