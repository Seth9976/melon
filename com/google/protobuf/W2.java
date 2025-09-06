package com.google.protobuf;

public enum w2 implements G1 {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);

    public final int a;

    public w2(int v1) {
        this.a = v1;
    }

    @Override  // com.google.protobuf.G1
    public final int a() {
        if(this == w2.c) {
            throw new IllegalArgumentException("Can\'t get the number of an unknown enum value.");
        }
        return this.a;
    }
}

