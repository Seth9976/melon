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

public class ByteObjectHashMap implements ByteObjectMap {
    final class EntrySet extends AbstractSet {
        private EntrySet() {
        }

        public EntrySet(io.netty.util.collection.ByteObjectHashMap.1 byteObjectHashMap$10) {
        }

        @Override
        public Iterator iterator() {
            return new MapIterator(ByteObjectHashMap.this, null);
        }

        @Override
        public int size() {
            return ByteObjectHashMap.this.size();
        }
    }

    final class KeySet extends AbstractSet {
        private KeySet() {
        }

        public KeySet(io.netty.util.collection.ByteObjectHashMap.1 byteObjectHashMap$10) {
        }

        @Override
        public void clear() {
            ByteObjectHashMap.this.clear();
        }

        @Override
        public boolean contains(Object object0) {
            return ByteObjectHashMap.this.containsKey(object0);
        }

        @Override
        public Iterator iterator() {
            return new Iterator() {
                private final Iterator iter;

                {
                    this.iter = ByteObjectHashMap.this.entrySet.iterator();
                }

                @Override
                public boolean hasNext() {
                    return this.iter.hasNext();
                }

                public Byte next() {
                    Object object0 = this.iter.next();
                    return (Byte)((Map.Entry)object0).getKey();
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
            return ByteObjectHashMap.this.remove(object0) != null;
        }

        @Override
        public boolean retainAll(Collection collection0) {
            boolean z = false;
            Iterator iterator0 = ByteObjectHashMap.this.entries().iterator();
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
            return ByteObjectHashMap.this.size();
        }
    }

    final class MapEntry implements Map.Entry {
        private final int entryIndex;

        public MapEntry(int v) {
            this.entryIndex = v;
        }

        public Byte getKey() {
            this.verifyExists();
            return (byte)ByteObjectHashMap.this.keys[this.entryIndex];
        }

        @Override
        public Object getKey() {
            return this.getKey();
        }

        @Override
        public Object getValue() {
            this.verifyExists();
            return ByteObjectHashMap.toExternal(ByteObjectHashMap.this.values[this.entryIndex]);
        }

        @Override
        public Object setValue(Object object0) {
            this.verifyExists();
            Object object1 = ByteObjectHashMap.toExternal(ByteObjectHashMap.this.values[this.entryIndex]);
            ByteObjectHashMap.this.values[this.entryIndex] = ByteObjectHashMap.toInternal(object0);
            return object1;
        }

        private void verifyExists() {
            if(ByteObjectHashMap.this.values[this.entryIndex] == null) {
                throw new IllegalStateException("The map entry has been removed");
            }
        }
    }

    final class MapIterator implements Iterator {
        private final PrimitiveIterator iter;

        private MapIterator() {
            this.iter = new PrimitiveIterator(byteObjectHashMap0, null);
        }

        public MapIterator(io.netty.util.collection.ByteObjectHashMap.1 byteObjectHashMap$10) {
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
            return new MapEntry(ByteObjectHashMap.this, PrimitiveIterator.access$1100(this.iter));
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

        public PrimitiveIterator(io.netty.util.collection.ByteObjectHashMap.1 byteObjectHashMap$10) {
        }

        public static int access$1100(PrimitiveIterator byteObjectHashMap$PrimitiveIterator0) {
            return byteObjectHashMap$PrimitiveIterator0.entryIndex;
        }

        @Override
        public boolean hasNext() {
            if(this.nextIndex == -1) {
                this.scanNext();
            }
            return this.nextIndex != ByteObjectHashMap.this.values.length;
        }

        @Override  // io.netty.util.collection.ByteObjectMap$PrimitiveEntry
        public byte key() {
            return ByteObjectHashMap.this.keys[this.entryIndex];
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
            if(ByteObjectHashMap.this.removeAt(v)) {
                this.nextIndex = this.prevIndex;
            }
            this.prevIndex = -1;
        }

        private void scanNext() {
            do {
                int v = this.nextIndex + 1;
                this.nextIndex = v;
            }
            while(v != ByteObjectHashMap.this.values.length && ByteObjectHashMap.this.values[this.nextIndex] == null);
        }

        @Override  // io.netty.util.collection.ByteObjectMap$PrimitiveEntry
        public void setValue(Object object0) {
            ByteObjectHashMap.this.values[this.entryIndex] = ByteObjectHashMap.toInternal(object0);
        }

        @Override  // io.netty.util.collection.ByteObjectMap$PrimitiveEntry
        public Object value() {
            return ByteObjectHashMap.toExternal(ByteObjectHashMap.this.values[this.entryIndex]);
        }
    }

    static final boolean $assertionsDisabled = false;
    public static final int DEFAULT_CAPACITY = 8;
    public static final float DEFAULT_LOAD_FACTOR = 0.5f;
    private static final Object NULL_VALUE;
    private final Iterable entries;
    private final Set entrySet;
    private final Set keySet;
    private byte[] keys;
    private final float loadFactor;
    private int mask;
    private int maxSize;
    private int size;
    private Object[] values;

    static {
        ByteObjectHashMap.NULL_VALUE = new Object();
    }

    public ByteObjectHashMap() {
        this(8, 0.5f);
    }

    public ByteObjectHashMap(int v) {
        this(v, 0.5f);
    }

    public ByteObjectHashMap(int v, float f) {
        this.keySet = new KeySet(this, null);
        this.entrySet = new EntrySet(this, null);
        this.entries = new Iterable() {
            @Override
            public Iterator iterator() {
                return new PrimitiveIterator(ByteObjectHashMap.this, null);
            }
        };
        if(f <= 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0 and <= 1");
        }
        this.loadFactor = f;
        int v1 = MathUtil.safeFindNextPositivePowerOfTwo(v);
        this.mask = v1 - 1;
        this.keys = new byte[v1];
        this.values = new Object[v1];
        this.maxSize = this.calcMaxSize(v1);
    }

    private int calcMaxSize(int v) {
        return Math.min(v - 1, ((int)(((float)v) * this.loadFactor)));
    }

    @Override
    public void clear() {
        Arrays.fill(this.keys, 0);
        Arrays.fill(this.values, null);
        this.size = 0;
    }

    @Override  // io.netty.util.collection.ByteObjectMap
    public boolean containsKey(byte b) {
        return this.indexOf(b) >= 0;
    }

    @Override
    public boolean containsKey(Object object0) {
        return this.containsKey(this.objectToKey(object0));
    }

    @Override
    public boolean containsValue(Object object0) {
        Object object1 = ByteObjectHashMap.toInternal(object0);
        Object[] arr_object = this.values;
        for(int v = 0; v < arr_object.length; ++v) {
            Object object2 = arr_object[v];
            if(object2 != null && object2.equals(object1)) {
                return true;
            }
        }
        return false;
    }

    @Override  // io.netty.util.collection.ByteObjectMap
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
        if(!(object0 instanceof ByteObjectMap)) {
            return false;
        }
        if(this.size != ((ByteObjectMap)object0).size()) {
            return false;
        }
        for(int v = 0; true; ++v) {
            Object[] arr_object = this.values;
            if(v >= arr_object.length) {
                break;
            }
            Object object1 = arr_object[v];
            if(object1 != null) {
                Object object2 = ((ByteObjectMap)object0).get(this.keys[v]);
                if(object1 == ByteObjectHashMap.NULL_VALUE) {
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

    @Override  // io.netty.util.collection.ByteObjectMap
    public Object get(byte b) {
        int v = this.indexOf(b);
        return v == -1 ? null : ByteObjectHashMap.toExternal(this.values[v]);
    }

    @Override
    public Object get(Object object0) {
        return this.get(this.objectToKey(object0));
    }

    private void growSize() {
        int v = this.size + 1;
        this.size = v;
        if(v > this.maxSize) {
            byte[] arr_b = this.keys;
            if(arr_b.length == 0x7FFFFFFF) {
                throw new IllegalStateException("Max capacity reached at size=" + this.size);
            }
            this.rehash(arr_b.length << 1);
        }
    }

    private static int hashCode(byte b) [...] // Inlined contents

    @Override
    public int hashCode() {
        int v = this.size;
        byte[] arr_b = this.keys;
        for(int v1 = 0; v1 < arr_b.length; ++v1) {
            v ^= ByteObjectHashMap.hashCode(arr_b[v1]);
        }
        return v;
    }

    private int hashIndex(byte b) {
        return b & this.mask;
    }

    private int indexOf(byte b) {
        int v = this.hashIndex(b);
        int v1 = v;
        do {
            if(this.values[v1] == null) {
                return -1;
            }
            if(b == this.keys[v1]) {
                return v1;
            }
            v1 = this.probeNext(v1);
        }
        while(v1 != v);
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

    public String keyToString(byte b) {
        return Byte.toString(b);
    }

    private byte objectToKey(Object object0) {
        return (byte)(((Byte)object0));
    }

    private int probeNext(int v) {
        return v + 1 & this.mask;
    }

    @Override  // io.netty.util.collection.ByteObjectMap
    public Object put(byte b, Object object0) {
        int v = this.hashIndex(b);
        int v1 = v;
        do {
            Object[] arr_object = this.values;
            Object object1 = arr_object[v1];
            if(object1 == null) {
                this.keys[v1] = b;
                arr_object[v1] = ByteObjectHashMap.toInternal(object0);
                this.growSize();
                return null;
            }
            if(this.keys[v1] == b) {
                arr_object[v1] = ByteObjectHashMap.toInternal(object0);
                return ByteObjectHashMap.toExternal(object1);
            }
            v1 = this.probeNext(v1);
        }
        while(v1 != v);
        throw new IllegalStateException("Unable to insert");
    }

    public Object put(Byte byte0, Object object0) {
        return this.put(this.objectToKey(byte0), object0);
    }

    @Override
    public Object put(Object object0, Object object1) {
        return this.put(((Byte)object0), object1);
    }

    @Override
    public void putAll(Map map0) {
        if(map0 instanceof ByteObjectHashMap) {
            for(int v = 0; true; ++v) {
                Object[] arr_object = ((ByteObjectHashMap)map0).values;
                if(v >= arr_object.length) {
                    break;
                }
                Object object0 = arr_object[v];
                if(object0 != null) {
                    this.put(((ByteObjectHashMap)map0).keys[v], object0);
                }
            }
        }
        else {
            for(Object object1: map0.entrySet()) {
                this.put(((Byte)((Map.Entry)object1).getKey()), ((Map.Entry)object1).getValue());
            }
        }
    }

    private void rehash(int v) {
        Object[] arr_object1;
        byte[] arr_b = this.keys;
        Object[] arr_object = this.values;
        this.keys = new byte[v];
        this.values = new Object[v];
        this.maxSize = this.calcMaxSize(v);
        this.mask = v - 1;
        for(int v1 = 0; v1 < arr_object.length; ++v1) {
            Object object0 = arr_object[v1];
            if(object0 != null) {
                byte b = arr_b[v1];
                int v2;
                for(v2 = this.hashIndex(b); true; v2 = this.probeNext(v2)) {
                    arr_object1 = this.values;
                    if(arr_object1[v2] == null) {
                        break;
                    }
                }
                this.keys[v2] = b;
                arr_object1[v2] = object0;
            }
        }
    }

    @Override  // io.netty.util.collection.ByteObjectMap
    public Object remove(byte b) {
        int v = this.indexOf(b);
        if(v == -1) {
            return null;
        }
        Object object0 = this.values[v];
        this.removeAt(v);
        return ByteObjectHashMap.toExternal(object0);
    }

    @Override
    public Object remove(Object object0) {
        return this.remove(this.objectToKey(object0));
    }

    private boolean removeAt(int v) {
        --this.size;
        this.keys[v] = 0;
        this.values[v] = null;
        int v1 = this.probeNext(v);
        Object object0 = this.values[v1];
        int v2 = v;
        while(object0 != null) {
            byte b = this.keys[v1];
            int v3 = this.hashIndex(b);
            if(v1 < v3 && (v3 <= v2 || v2 <= v1) || v3 <= v2 && v2 <= v1) {
                byte[] arr_b = this.keys;
                arr_b[v2] = b;
                Object[] arr_object = this.values;
                arr_object[v2] = object0;
                arr_b[v1] = 0;
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
        return object0 == ByteObjectHashMap.NULL_VALUE ? null : object0;
    }

    private static Object toInternal(Object object0) {
        return object0 == null ? ByteObjectHashMap.NULL_VALUE : object0;
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
                String s = object0 == this ? "(this Map)" : ByteObjectHashMap.toExternal(object0);
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
                        this.iter = new PrimitiveIterator(ByteObjectHashMap.this, null);
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
                return ByteObjectHashMap.this.size;
            }
        };
    }
}

