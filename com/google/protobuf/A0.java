package com.google.protobuf;

public enum a0 implements G1 {
    UTF8_VALIDATION_UNKNOWN(0),
    VERIFY(2),
    NONE(3);

    public final int a;

    public a0(int v1) {
        this.a = v1;
    }

    @Override  // com.google.protobuf.G1
    public final int a() {
        return this.a;
    }

    public static a0 b(int v) {
        switch(v) {
            case 0: {
                return a0.b;
            }
            case 2: {
                return a0.c;
            }
            case 3: {
                return a0.d;
            }
            default: {
                return null;
            }
        }
    }
}

