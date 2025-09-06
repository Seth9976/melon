package com.google.protobuf;

public enum s0 implements G1 {
    TARGET_TYPE_UNKNOWN(0),
    TARGET_TYPE_FILE(1),
    TARGET_TYPE_EXTENSION_RANGE(2),
    TARGET_TYPE_MESSAGE(3),
    TARGET_TYPE_FIELD(4),
    TARGET_TYPE_ONEOF(5),
    TARGET_TYPE_ENUM(6),
    TARGET_TYPE_ENUM_ENTRY(7),
    TARGET_TYPE_SERVICE(8),
    TARGET_TYPE_METHOD(9);

    public final int a;

    public s0(int v1) {
        this.a = v1;
    }

    @Override  // com.google.protobuf.G1
    public final int a() {
        return this.a;
    }

    public static s0 b(int v) {
        switch(v) {
            case 0: {
                return s0.b;
            }
            case 1: {
                return s0.c;
            }
            case 2: {
                return s0.d;
            }
            case 3: {
                return s0.e;
            }
            case 4: {
                return s0.f;
            }
            case 5: {
                return s0.g;
            }
            case 6: {
                return s0.h;
            }
            case 7: {
                return s0.i;
            }
            case 8: {
                return s0.j;
            }
            case 9: {
                return s0.k;
            }
            default: {
                return null;
            }
        }
    }
}

