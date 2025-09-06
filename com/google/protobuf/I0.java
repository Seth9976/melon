package com.google.protobuf;

public enum i0 implements G1 {
    LABEL_OPTIONAL(1),
    LABEL_REPEATED(3),
    LABEL_REQUIRED(2);

    public final int a;

    public i0(int v1) {
        this.a = v1;
    }

    @Override  // com.google.protobuf.G1
    public final int a() {
        return this.a;
    }

    public static i0 b(int v) {
        switch(v) {
            case 1: {
                return i0.b;
            }
            case 2: {
                return i0.d;
            }
            case 3: {
                return i0.c;
            }
            default: {
                return null;
            }
        }
    }
}

