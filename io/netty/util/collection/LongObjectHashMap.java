package io.netty.util.collection;

import io.netty.util.internal.MathUtil;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class LongObjectHashMap implements LongObjectMap {
    final class EntrySet extends AbstractSet {
        private EntrySet() {
        }

        public EntrySet(io.netty.util.collection.LongObjectHashMap.1 longObjectHashMap$10) {
        }

        @Override
        public Iterator iterator() {
            return new MapIterator(LongObjectHashMap.this, null);
        }

        @Override
        public int size() {
            return LongObjectHashMap.this.size();
        }
    }

    final class KeySet extends AbstractSet {
        private KeySet() {
        }

        public KeySet(io.netty.util.collection.LongObjectHashMap.1 longObjectHashMap$10) {
        }

        @Override
        public void clear() {
            LongObjectHashMap.this.clear();
        }

        @Override
        public boolean contains(Object object0) {
            return LongObjectHashMap.this.containsKey(object0);
        }

        @Override
        public Iterator iterator() {
            return new Iterator() {
                private final Iterator iter;

                {
                    this.iter = LongObjectHashMap.this.entrySet.iterator();
                }

                @Override
                public boolean hasNext() {
                    return this.iter.hasNext();
                }

                public Long next() {
                    Object object0 = this.iter.next();
                    return (Long)((Map.Entry)object0).getKey();
                }

                @Override
                public Object next() {
                    return this.next();
                }

                @Override
                public void remove() {
                    this.iter.remove();
                }
            };
        }

        @Override
        public boolean remove(Object object0) {
            return LongObjectHashMap.this.remove(object0) != null;
        }

        @Override
        public boolean retainAll(Collection collection0) {
            boolean z = false;
            Iterator iterator0 = LongObjectHashMap.this.entries().iterator();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                if(!collection0.contains(((PrimitiveEntry)object0).key())) {
                    iterator0.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override
        public int size() {
            return LongObjectHashMap.this.size();
        }
    }

    final class MapEntry implements Map.Entry {
        private final int entryIndex;

        public MapEntry(int v) {
            this.entryIndex = v;
        }

        public Long getKey() {
            this.verifyExists();
            return (long)LongObjectHashMap.this.keys[this.entryIndex];
        }

        @Override
        public Object getKey() {
            return this.getKey();
        }

        @Override
        public Object getValue() {
            this.verifyExists();
            return LongObjectHashMap.toExternal(LongObjectHashMap.this.values[this.entryIndex]);
        }

        @Override
        public Object setValue(Object object0) {
            this.verifyExists();
            Object object1 = LongObjectHashMap.toExternal(LongObjectHashMap.this.values[this.entryIndex]);
            LongObjectHashMap.this.values[this.entryIndex] = LongObjectHashMap.toInternal(object0);
            return object1;
        }

        private void verifyExists() {
            if(LongObjectHashMap.this.values[this.entryIndex] == null) {
                throw new IllegalStateException("The map entry has been removed");
            }
        }
    }

    final class MapIterator implements Iterator {
        private final PrimitiveIterator iter;

        private MapIterator() {
            this.iter = new PrimitiveIterator(longObjectHashMap0, null);
        }

        public MapIterator(io.netty.util.collection.LongObjectHashMap.1 longObjectHashMap$10) {
        }

        @Override
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override
        public Object next() {
            return this.next();
        }

        public Map.Entry next() {
            if(!this.hasNext()) {
                throw new NoSuchElementException();
            }
            this.iter.next();
            return new MapEntry(LongObjectHashMap.this, this.iter.entryIndex);
        }

        @Override
        public void remove() {
            this.iter.remove();
        }
    }

    final class PrimitiveIterator implements PrimitiveEntry, Iterator {
        private int entryIndex;
        private int nextIndex;
        private int prevIndex;

        private PrimitiveIterator() {
            this.prevIndex = -1;
            this.nextIndex = -1;
            this.entryIndex = -1;
        }

        public PrimitiveIterator(io.netty.util.collection.LongObjectHashMap.1 longObjectHashMap$10) {
        }

        @Override
        public boolean hasNext() {
            if(this.nextIndex == -1) {
                this.scanNext();
            }
            return this.nextIndex != LongObjectHashMap.this.values.length;
        }

        @Override  // io.netty.util.collection.LongObjectMap$PrimitiveEntry
        public long key() {
            return LongObjectHashMap.this.keys[this.entryIndex];
        }

        public PrimitiveEntry next() {
            if(!this.hasNext()) {
                throw new NoSuchElementException();
            }
            this.prevIndex = this.nextIndex;
            this.scanNext();
            this.entryIndex = this.prevIndex;
            return this;
        }

        @Override
        public Object next() {
            return this.next();
        }

        @Override
        public void remove() {
            int v = this.prevIndex;
            if(v == -1) {
                throw new IllegalStateException("next must be called before each remove.");
            }
            if(LongObjectHashMap.this.removeAt(v)) {
                this.nextIndex = this.prevIndex;
            }
            this.prevIndex = -1;
        }

        private void scanNext() {
            do {
                int v = this.nextIndex + 1;
                this.nextIndex = v;
            }
            while(v != LongObjectHashMap.this.values.length && LongObjectHashMap.this.values[this.nextIndex] == null);
        }

        @Override  // io.netty.util.collection.LongObjectMap$PrimitiveEntry
        public void setValue(Object object0) {
            LongObjectHashMap.this.values[this.entryIndex] = LongObjectHashMap.toInternal(object0);
        }

        @Override  // io.netty.util.collection.LongObjectMap$PrimitiveEntry
        public Object value() {
            return LongObjectHashMap.toExternal(LongObjectHashMap.this.values[this.entryIndex]);
        }
    }

    static final boolean $assertionsDisabled = false;
    public static final int DEFAULT_CAPACITY = 8;
    public static final float DEFAULT_LOAD_FACTOR = 0.5f;
    private static final Object NULL_VALUE;
    private final Iterable entries;
    private final Set entrySet;
    private final Set keySet;
    private long[] keys;
    private final float loadFactor;
    private int mask;
    private int maxSize;
    private int size;
    private Object[] values;

    static {
        LongObjectHashMap.NULL_VALUE = new Object();
    }

    public LongObjectHashMap() {
        this(8, 0.5f);
    }

    public LongObjectHashMap(int v) {
        this(v, 0.5f);
    }

    public LongObjectHashMap(int v, float f) {
        this.keySet = new KeySet(this, null);
        this.entrySet = new EntrySet(this, null);
        this.entries = new Iterable() {
            @Override
            public Iterator iterator() {
                return new PrimitiveIterator(LongObjectHashMap.this, null);
            }
        };
        if(f <= 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0 and <= 1");
        }
        this.loadFactor = f;
        int v1 = MathUtil.safeFindNextPositivePowerOfTwo(v);
        this.mask = v1 - 1;
        this.keys = new long[v1];
        this.values = new Object[v1];
        this.maxSize = this.calcMaxSize(v1);
    }

    private int calcMaxSize(int v) {
        return Math.min(v - 1, ((int)(((float)v) * this.loadFactor)));
    }

    @Override
    public void clear() {
        Arrays.fill(this.keys, 0L);
        Arrays.fill(this.values, null);
        this.size = 0;
    }

    @Override  // io.netty.util.collection.LongObjectMap
    public boolean containsKey(long v) {
        return this.indexOf(v) >= 0;
    }

    @Override
    public boolean containsKey(Object object0) {
        return this.containsKey(this.objectToKey(object0));
    }

    @Override
    public boolean containsValue(Object object0) {
        Object object1 = LongObjectHashMap.toInternal(object0);
        Object[] arr_object = this.values;
        for(int v = 0; v < arr_object.length; ++v) {
            Object object2 = arr_object[v];
            if(object2 != null && object2.equals(object1)) {
                return true;
            }
        }
        return false;
    }

    @Override  // io.netty.util.collection.LongObjectMap
    public Iterable entries() {
        return this.entries;
    }

    @Override
    public Set entrySet() {
        return this.entrySet;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof LongObjectMap)) {
            return false;
        }
        if(this.size != ((LongObjectMap)object0).size()) {
            return false;
        }
        for(int v = 0; true; ++v) {
            Object[] arr_object = this.values;
            if(v >= arr_object.length) {
                break;
            }
            Object object1 = arr_object[v];
            if(object1 != null) {
                Object object2 = ((LongObjectMap)object0).get(this.keys[v]);
                if(object1 == LongObjectHashMap.NULL_VALUE) {
                    if(object2 != null) {
                        return false;
                    }
                }
                else if(!object1.equals(object2)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override  // io.netty.util.collection.LongObjectMap
    public Object get(long v) {
        int v1 = this.indexOf(v);
        return v1 == -1 ? null : LongObjectHashMap.toExternal(this.values[v1]);
    }

    @Override
    public Object get(Object object0) {
        return this.get(this.objectToKey(object0));
    }

    private void growSize() {
        int v = this.size + 1;
        this.size = v;
        if(v > this.maxSize) {
            long[] arr_v = this.keys;
            if(arr_v.length == 0x7FFFFFFF) {
                throw new IllegalStateException("Max capacity reached at size=" + this.size);
            }
            this.rehash(arr_v.length << 1);
        }
    }

    private static int hashCode(long v) {
        return (int)(v ^ v >>> 0x20);
    }

    @Override
    public int hashCode() {
        int v = this.size;
        long[] arr_v = this.keys;
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            v ^= LongObjectHashMap.hashCode(arr_v[v1]);
        }
        return v;
    }

    private int hashIndex(long v) {
        return LongObjectHashMap.hashCode(v) & this.mask;
    }

    private int indexOf(long v) {
        int v1 = this.hashIndex(v);
        int v2 = v1;
        do {
            if(this.values[v2] == null) {
                return -1;
            }
            if(v == this.keys[v2]) {
                return v2;
            }
            v2 = this.probeNext(v2);
        }
        while(v2 != v1);
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Set keySet() {
        return this.keySet;
    }

    public String keyToString(long v) {
        return Long.toString(v);
    }

    private long objectToKey(Object object0) {
        return (long)(((Long)object0));
    }

    private int probeNext(int v) {
        return v + 1 & this.mask;
    }

    @Override  // io.netty.util.collection.LongObjectMap
    public Object put(long v, Object object0) {
        int v1 = this.hashIndex(v);
        int v2 = v1;
        do {
            Object[] arr_object = this.values;
            Object object1 = arr_object[v2];
            if(object1 == null) {
                this.keys[v2] = v;
                arr_object[v2] = LongObjectHashMap.toInternal(object0);
                this.growSize();
                return null;
            }
            if(this.keys[v2] == v) {
                arr_object[v2] = LongObjectHashMap.toInternal(object0);
                return LongObjectHashMap.toExternal(object1);
            }
            v2 = this.probeNext(v2);
        }
        while(v2 != v1);
        throw new IllegalStateException("Unable to insert");
    }

    public Object put(Long long0, Object object0) {
        return this.put(this.objectToKey(long0), object0);
    }

    @Override
    public Object put(Object object0, Object object1) {
        return this.put(((Long)object0), object1);
    }

    @Override
    public void putAll(Map map0) {
        if(map0 instanceof LongObjectHashMap) {
            for(int v = 0; true; ++v) {
                Object[] arr_object = ((LongObjectHashMap)map0).values;
                if(v >= arr_object.length) {
                    break;
                }
                Object object0 = arr_object[v];
                if(object0 != null) {
                    this.put(((LongObjectHashMap)map0).keys[v], object0);
                }
            }
        }
        else {
            for(Object object1: map0.entrySet()) {
                this.put(((Long)((Map.Entry)object1).getKey()), ((Map.Entry)object1).getValue());
            }
        }
    }

    private void rehash(int v) {
        Object[] arr_object1;
        long[] arr_v = this.keys;
        Object[] arr_object = this.values;
        this.keys = new long[v];
        this.values = new Object[v];
        this.maxSize = this.calcMaxSize(v);
        this.mask = v - 1;
        for(int v1 = 0; v1 < arr_object.length; ++v1) {
            Object object0 = arr_object[v1];
            if(object0 != null) {
                long v2 = arr_v[v1];
                int v3;
                for(v3 = this.hashIndex(v2); true; v3 = this.probeNext(v3)) {
                    arr_object1 = this.values;
                    if(arr_object1[v3] == null) {
                        break;
                    }
                }
                this.keys[v3] = v2;
                arr_object1[v3] = object0;
            }
        }
    }

    @Override  // io.netty.util.collection.LongObjectMap
    public Object remove(long v) {
        int v1 = this.indexOf(v);
        if(v1 == -1) {
            return null;
        }
        Object object0 = this.values[v1];
        this.removeAt(v1);
        return LongObjectHashMap.toExternal(object0);
    }

    @Override
    public Object remove(Object object0) {
        return this.remove(this.objectToKey(object0));
    }

    private boolean removeAt(int v) {
        --this.size;
        this.keys[v] = 0L;
        this.values[v] = null;
        int v1 = this.probeNext(v);
        Object object0 = this.values[v1];
        int v2 = v;
        while(object0 != null) {
            long v3 = this.keys[v1];
            int v4 = this.hashIndex(v3);
            if(v1 < v4 && (v4 <= v2 || v2 <= v1) || v4 <= v2 && v2 <= v1) {
                long[] arr_v = this.keys;
                arr_v[v2] = v3;
                Object[] arr_object = this.values;
                arr_object[v2] = object0;
                arr_v[v1] = 0L;
                arr_object[v1] = null;
                v2 = v1;
            }
            v1 = this.probeNext(v1);
            object0 = this.values[v1];
        }
        return v2 != v;
    }

    @Override
    public int size() {
        return this.size;
    }

    private static Object toExternal(Object object0) {
        return object0 == LongObjectHashMap.NULL_VALUE ? null : object0;
    }

    private static Object toInternal(Object object0) {
        return object0 == null ? LongObjectHashMap.NULL_VALUE : object0;
    }

    @Override
    public String toString() {
        if(this.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder0 = new StringBuilder(this.size * 4);
        stringBuilder0.append('{');
        boolean z = true;
        for(int v = 0; true; ++v) {
            Object[] arr_object = this.values;
            if(v >= arr_object.length) {
                break;
            }
            Object object0 = arr_object[v];
            if(object0 != null) {
                if(!z) {
                    stringBuilder0.append(", ");
                }
                stringBuilder0.append(this.keyToString(this.keys[v]));
                stringBuilder0.append('=');
                String s = object0 == this ? "(this Map)" : LongObjectHashMap.toExternal(object0);
                stringBuilder0.append(s);
                z = false;
            }
        }
        stringBuilder0.append('}');
        return stringBuilder0.toString();
    }

    @Override
    public Collection values() {
        return new AbstractCollection() {
            @Override
            public Iterator iterator() {
                return new Iterator() {
                    final PrimitiveIterator iter;

                    {
                        this.iter = new PrimitiveIterator(LongObjectHashMap.this, null);
                    }

                    @Override
                    public boolean hasNext() {
                        return this.iter.hasNext();
                    }

                    @Override
                    public Object next() {
                        return this.iter.next().value();
                    }

                    @Override
                    public void remove() {
                        this.iter.remove();
                    }
                };
            }

            @Override
            public int size() {
                return LongObjectHashMap.this.size;
            }
        };
    }
}

