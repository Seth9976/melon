package com.google.protobuf;

public enum q0 implements G1 {
    JS_NORMAL(0),
    JS_STRING(1),
    JS_NUMBER(2);

    public final int a;

    public q0(int v1) {
        this.a = v1;
    }

    @Override  // com.google.protobuf.G1
    public final int a() {
        return this.a;
    }

    public static q0 b(int v) {
        switch(v) {
            case 0: {
                return q0.b;
            }
            case 1: {
                return q0.c;
            }
            case 2: {
                return q0.d;
            }
            default: {
                return null;
            }
        }
    }
}

