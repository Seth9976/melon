package R8;

import U4.x;

public final class p extends Exception {
    public final String a;
    private static final long serialVersionUID = 1L;

    public p(String s) {
        this.a = s;
    }

    @Override
    public final String getMessage() {
        return this.a;
    }

    @Override
    public final String toString() {
        return x.m(new StringBuilder("DeviceInformDeviceCheckException {message:"), this.a, "}");
    }
}

