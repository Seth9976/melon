package io.netty.util.collection;

import java.util.Map;

public interface CharObjectMap extends Map {
    public interface PrimitiveEntry {
        char key();

        void setValue(Object arg1);

        Object value();
    }

    boolean containsKey(char arg1);

    Iterable entries();

    Object get(char arg1);

    Object put(char arg1, Object arg2);

    Object remove(char arg1);
}

