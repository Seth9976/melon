package com.google.protobuf;

public enum x0 implements G1 {
    SPEED(1),
    CODE_SIZE(2),
    LITE_RUNTIME(3);

    public final int a;

    public x0(int v1) {
        this.a = v1;
    }

    @Override  // com.google.protobuf.G1
    public final int a() {
        return this.a;
    }

    public static x0 b(int v) {
        switch(v) {
            case 1: {
                return x0.b;
            }
            case 2: {
                return x0.c;
            }
            case 3: {
                return x0.d;
            }
            default: {
                return null;
            }
        }
    }
}

