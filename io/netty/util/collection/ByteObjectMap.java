package io.netty.util.collection;

import java.util.Map;

public interface ByteObjectMap extends Map {
    public interface PrimitiveEntry {
        byte key();

        void setValue(Object arg1);

        Object value();
    }

    boolean containsKey(byte arg1);

    Iterable entries();

    Object get(byte arg1);

    Object put(byte arg1, Object arg2);

    Object remove(byte arg1);
}

