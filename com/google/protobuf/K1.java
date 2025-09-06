package com.google.protobuf;

public enum k1 implements G1 {
    CARDINALITY_UNKNOWN(0),
    CARDINALITY_OPTIONAL(1),
    CARDINALITY_REQUIRED(2),
    CARDINALITY_REPEATED(3),
    UNRECOGNIZED(-1);

    public final int a;

    public k1(int v1) {
        this.a = v1;
    }

    @Override  // com.google.protobuf.G1
    public final int a() {
        if(this == k1.f) {
            throw new IllegalArgumentException("Can\'t get the number of an unknown enum value.");
        }
        return this.a;
    }
}

