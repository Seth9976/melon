package com.google.protobuf;

import androidx.datastore.preferences.protobuf.e;
import java.util.Iterator;

public abstract class m extends o {
    private static final long serialVersionUID = 1L;

    @Override
    public final Iterator iterator() {
        return new e(this);
    }
}

