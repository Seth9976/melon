package com.google.protobuf;

public enum V1 implements G1 {
    NEST_IN_FILE_CLASS_UNKNOWN(0),
    NO(1),
    YES(2),
    LEGACY(3);

    public final int a;

    public V1(int v1) {
        this.a = v1;
    }

    @Override  // com.google.protobuf.G1
    public final int a() {
        return this.a;
    }

    public static V1 b(int v) {
        switch(v) {
            case 0: {
                return V1.b;
            }
            case 1: {
                return V1.c;
            }
            case 2: {
                return V1.d;
            }
            case 3: {
                return V1.e;
            }
            default: {
                return null;
            }
        }
    }
}

