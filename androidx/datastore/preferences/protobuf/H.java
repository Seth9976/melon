package androidx.datastore.preferences.protobuf;

import java.util.Iterator;

public abstract class h extends j {
    private static final long serialVersionUID = 1L;

    @Override
    public final Iterator iterator() {
        return new e(this);
    }
}

