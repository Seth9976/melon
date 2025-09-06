package io.netty.util.collection;

import java.util.Map;

public interface IntObjectMap extends Map {
    public interface PrimitiveEntry {
        int key();

        void setValue(Object arg1);

        Object value();
    }

    boolean containsKey(int arg1);

    Iterable entries();

    Object get(int arg1);

    Object put(int arg1, Object arg2);

    Object remove(int arg1);
}

