package androidx.datastore.preferences.protobuf;

import java.io.IOException;

public final class n extends IOException {
    private static final long serialVersionUID = 0x9F95917C52CE6E25L;

    public n(IndexOutOfBoundsException indexOutOfBoundsException0) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", indexOutOfBoundsException0);
    }
}

