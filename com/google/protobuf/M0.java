package com.google.protobuf;

public enum m0 implements G1 {
    STRING(0),
    CORD(1),
    STRING_PIECE(2);

    public final int a;

    public m0(int v1) {
        this.a = v1;
    }

    @Override  // com.google.protobuf.G1
    public final int a() {
        return this.a;
    }

    public static m0 b(int v) {
        switch(v) {
            case 0: {
                return m0.b;
            }
            case 1: {
                return m0.c;
            }
            case 2: {
                return m0.d;
            }
            default: {
                return null;
            }
        }
    }
}

