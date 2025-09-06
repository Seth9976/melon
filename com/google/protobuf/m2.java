package com.google.protobuf;

public enum M2 implements G1 {
    SYNTAX_PROTO2(0),
    SYNTAX_PROTO3(1),
    SYNTAX_EDITIONS(2),
    UNRECOGNIZED(-1);

    public final int a;

    public M2(int v1) {
        this.a = v1;
    }

    @Override  // com.google.protobuf.G1
    public final int a() {
        if(this == M2.e) {
            throw new IllegalArgumentException("Can\'t get the number of an unknown enum value.");
        }
        return this.a;
    }

    public static M2 b(int v) {
        switch(v) {
            case 0: {
                return M2.b;
            }
            case 1: {
                return M2.c;
            }
            case 2: {
                return M2.d;
            }
            default: {
                return null;
            }
        }
    }
}

