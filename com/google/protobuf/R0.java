package com.google.protobuf;

public enum r0 implements G1 {
    RETENTION_UNKNOWN(0),
    RETENTION_RUNTIME(1),
    RETENTION_SOURCE(2);

    public final int a;

    public r0(int v1) {
        this.a = v1;
    }

    @Override  // com.google.protobuf.G1
    public final int a() {
        return this.a;
    }

    public static r0 b(int v) {
        switch(v) {
            case 0: {
                return r0.b;
            }
            case 1: {
                return r0.c;
            }
            case 2: {
                return r0.d;
            }
            default: {
                return null;
            }
        }
    }
}

