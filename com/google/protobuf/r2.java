package com.google.protobuf;

public final class R2 extends RuntimeException {
    private static final long serialVersionUID = 0x986022C4D65DB14DL;

    public R2() {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }
}

