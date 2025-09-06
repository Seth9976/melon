package com.google.protobuf;

public final class a3 extends IllegalArgumentException {
    public a3(int v, int v1) {
        super("Unpaired surrogate at index " + v + " of " + v1);
    }
}

