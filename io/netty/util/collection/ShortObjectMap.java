package io.netty.util.collection;

import java.util.Map;

public interface ShortObjectMap extends Map {
    public interface PrimitiveEntry {
        short key();

        void setValue(Object arg1);

        Object value();
    }

    boolean containsKey(short arg1);

    Iterable entries();

    Object get(short arg1);

    Object put(short arg1, Object arg2);

    Object remove(short arg1);
}

