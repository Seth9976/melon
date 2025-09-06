package Q0;

public interface b1 {
    long a();

    long b();

    default float c() {
        return 2.0f;
    }

    // 去混淆评级： 低(20)
    default long d() {
        return 0x4240000042400000L;
    }

    default float e() {
        return 3.402823E+38f;
    }

    float f();

    default float g() {
        return 16.0f;
    }
}

