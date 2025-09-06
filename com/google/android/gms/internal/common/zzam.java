package com.google.android.gms.internal.common;

import java.util.Iterator;

public abstract class zzam implements Iterator {
    @Override
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

