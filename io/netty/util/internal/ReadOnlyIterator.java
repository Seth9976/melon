package io.netty.util.internal;

import java.util.Iterator;

public final class ReadOnlyIterator implements Iterator {
    private final Iterator iterator;

    public ReadOnlyIterator(Iterator iterator0) {
        this.iterator = (Iterator)ObjectUtil.checkNotNull(iterator0, "iterator");
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public Object next() {
        return this.iterator.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("read-only");
    }
}

