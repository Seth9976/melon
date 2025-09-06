package io.netty.util.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class ShortCollections {
    static final class EmptyMap implements ShortObjectMap {
        private EmptyMap() {
        }

        public EmptyMap(io.netty.util.collection.ShortCollections.1 shortCollections$10) {
        }

        @Override
        public void clear() {
        }

        @Override
        public boolean containsKey(Object object0) {
            return false;
        }

        @Override  // io.netty.util.collection.ShortObjectMap
        public boolean containsKey(short v) {
            return false;
        }

        @Override
        public boolean containsValue(Object object0) {
            return false;
        }

        @Override  // io.netty.util.collection.ShortObjectMap
        public Iterable entries() {
            return Collections.EMPTY_SET;
        }

        @Override
        public Set entrySet() {
            return Collections.EMPTY_SET;
        }

        @Override
        public Object get(Object object0) {
            return null;
        }

        @Override  // io.netty.util.collection.ShortObjectMap
        public Object get(short v) {
            return null;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public Set keySet() {
            return Collections.EMPTY_SET;
        }

        @Override
        public Object put(Object object0, Object object1) {
            return this.put(((Short)object0), object1);
        }

        public Object put(Short short0, Object object0) {
            throw new UnsupportedOperationException();
        }

        @Override  // io.netty.util.collection.ShortObjectMap
        public Object put(short v, Object object0) {
            throw new UnsupportedOperationException("put");
        }

        @Override
        public void putAll(Map map0) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Object remove(Object object0) {
            return null;
        }

        @Override  // io.netty.util.collection.ShortObjectMap
        public Object remove(short v) {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public Collection values() {
            return Collections.EMPTY_LIST;
        }
    }

    static final class UnmodifiableMap implements ShortObjectMap {
        class EntryImpl implements PrimitiveEntry {
            private final PrimitiveEntry entry;

            public EntryImpl(PrimitiveEntry shortObjectMap$PrimitiveEntry0) {
                this.entry = shortObjectMap$PrimitiveEntry0;
            }

            @Override  // io.netty.util.collection.ShortObjectMap$PrimitiveEntry
            public short key() {
                return this.entry.key();
            }

            @Override  // io.netty.util.collection.ShortObjectMap$PrimitiveEntry
            public void setValue(Object object0) {
                throw new UnsupportedOperationException("setValue");
            }

            @Override  // io.netty.util.collection.ShortObjectMap$PrimitiveEntry
            public Object value() {
                return this.entry.value();
            }
        }

        class IteratorImpl implements Iterator {
            final Iterator iter;

            public IteratorImpl(Iterator iterator0) {
                this.iter = iterator0;
            }

            @Override
            public boolean hasNext() {
                return this.iter.hasNext();
            }

            public PrimitiveEntry next() {
                if(!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                Object object0 = this.iter.next();
                return new EntryImpl(UnmodifiableMap.this, ((PrimitiveEntry)object0));
            }

            @Override
            public Object next() {
                return this.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }
        }

        private Iterable entries;
        private Set entrySet;
        private Set keySet;
        private final ShortObjectMap map;
        private Collection values;

        public UnmodifiableMap(ShortObjectMap shortObjectMap0) {
            this.map = shortObjectMap0;
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException("clear");
        }

        @Override
        public boolean containsKey(Object object0) {
            return this.map.containsKey(object0);
        }

        @Override  // io.netty.util.collection.ShortObjectMap
        public boolean containsKey(short v) {
            return this.map.containsKey(v);
        }

        @Override
        public boolean containsValue(Object object0) {
            return this.map.containsValue(object0);
        }

        @Override  // io.netty.util.collection.ShortObjectMap
        public Iterable entries() {
            if(this.entries == null) {
                this.entries = new Iterable() {
                    @Override
                    public Iterator iterator() {
                        Iterator iterator0 = UnmodifiableMap.this.map.entries().iterator();
                        return new IteratorImpl(UnmodifiableMap.this, iterator0);
                    }
                };
            }
            return this.entries;
        }

        @Override
        public Set entrySet() {
            if(this.entrySet == null) {
                this.entrySet = Collections.unmodifiableSet(this.map.entrySet());
            }
            return this.entrySet;
        }

        @Override
        public Object get(Object object0) {
            return this.map.get(object0);
        }

        @Override  // io.netty.util.collection.ShortObjectMap
        public Object get(short v) {
            return this.map.get(v);
        }

        @Override
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override
        public Set keySet() {
            if(this.keySet == null) {
                this.keySet = Collections.unmodifiableSet(this.map.keySet());
            }
            return this.keySet;
        }

        @Override
        public Object put(Object object0, Object object1) {
            return this.put(((Short)object0), object1);
        }

        public Object put(Short short0, Object object0) {
            throw new UnsupportedOperationException("put");
        }

        @Override  // io.netty.util.collection.ShortObjectMap
        public Object put(short v, Object object0) {
            throw new UnsupportedOperationException("put");
        }

        @Override
        public void putAll(Map map0) {
            throw new UnsupportedOperationException("putAll");
        }

        @Override
        public Object remove(Object object0) {
            throw new UnsupportedOperationException("remove");
        }

        @Override  // io.netty.util.collection.ShortObjectMap
        public Object remove(short v) {
            throw new UnsupportedOperationException("remove");
        }

        @Override
        public int size() {
            return this.map.size();
        }

        @Override
        public Collection values() {
            if(this.values == null) {
                this.values = Collections.unmodifiableCollection(this.map.values());
            }
            return this.values;
        }
    }

    private static final ShortObjectMap EMPTY_MAP;

    static {
        ShortCollections.EMPTY_MAP = new EmptyMap(null);
    }

    public static ShortObjectMap emptyMap() {
        return ShortCollections.EMPTY_MAP;
    }

    public static ShortObjectMap unmodifiableMap(ShortObjectMap shortObjectMap0) {
        return new UnmodifiableMap(shortObjectMap0);
    }

    class io.netty.util.collection.ShortCollections.1 {
    }

}

