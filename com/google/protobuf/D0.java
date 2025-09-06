package com.google.protobuf;

public enum d0 implements G1 {
    DEFAULT_SYMBOL_VISIBILITY_UNKNOWN(0),
    EXPORT_ALL(1),
    EXPORT_TOP_LEVEL(2),
    LOCAL_ALL(3),
    STRICT(4);

    public final int a;

    public d0(int v1) {
        this.a = v1;
    }

    @Override  // com.google.protobuf.G1
    public final int a() {
        return this.a;
    }

    public static d0 b(int v) {
        switch(v) {
            case 0: {
                return d0.b;
            }
            case 1: {
                return d0.c;
            }
            case 2: {
                return d0.d;
            }
            case 3: {
                return d0.e;
            }
            case 4: {
                return d0.f;
            }
            default: {
                return null;
            }
        }
    }
}

