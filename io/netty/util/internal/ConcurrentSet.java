package io.netty.util.internal;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;

@Deprecated
public final class ConcurrentSet extends AbstractSet implements Serializable {
    private final ConcurrentMap map;
    private static final long serialVersionUID = 0xA22A477F00E58ED8L;

    public ConcurrentSet() {
        this.map = PlatformDependent.newConcurrentHashMap();
    }

    @Override
    public boolean add(Object object0) {
        return this.map.putIfAbsent(object0, Boolean.TRUE) == null;
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    @Override
    public boolean contains(Object object0) {
        return this.map.containsKey(object0);
    }

    @Override
    public Iterator iterator() {
        return this.map.keySet().iterator();
    }

    @Override
    public boolean remove(Object object0) {
        return this.map.remove(object0) != null;
    }

    @Override
    public int size() {
        return this.map.size();
    }
}

