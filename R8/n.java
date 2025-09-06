package R8;

import U4.x;

public final class n extends Exception {
    public final String a;
    private static final long serialVersionUID = 0x397FBA49DB7C8E0EL;

    public n(String s) {
        this.a = s;
    }

    @Override
    public final String getMessage() {
        return this.a;
    }

    @Override
    public final String toString() {
        return x.m(new StringBuilder("DcfExtendException {message:"), this.a, "}");
    }
}

