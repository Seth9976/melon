package io.netty.util.collection;

import java.util.Map;

public interface LongObjectMap extends Map {
    public interface PrimitiveEntry {
        long key();

        void setValue(Object arg1);

        Object value();
    }

    boolean containsKey(long arg1);

    Iterable entries();

    Object get(long arg1);

    Object put(long arg1, Object arg2);

    Object remove(long arg1);
}

