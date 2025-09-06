package io.netty.channel.nio;

import java.nio.channels.SelectionKey;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class SelectedSelectionKeySet extends AbstractSet {
    SelectionKey[] keys;
    int size;

    public SelectedSelectionKeySet() {
        this.keys = new SelectionKey[0x400];
    }

    @Override
    public boolean add(Object object0) {
        return this.add(((SelectionKey)object0));
    }

    public boolean add(SelectionKey selectionKey0) {
        if(selectionKey0 == null) {
            return false;
        }
        if(this.size == this.keys.length) {
            this.increaseCapacity();
        }
        int v = this.size;
        this.size = v + 1;
        this.keys[v] = selectionKey0;
        return true;
    }

    @Override
    public boolean contains(Object object0) {
        SelectionKey[] arr_selectionKey = this.keys;
        int v = this.size;
        for(int v1 = 0; v1 < v; ++v1) {
            if(arr_selectionKey[v1].equals(object0)) {
                return true;
            }
        }
        return false;
    }

    private void increaseCapacity() {
        SelectionKey[] arr_selectionKey = this.keys;
        SelectionKey[] arr_selectionKey1 = new SelectionKey[arr_selectionKey.length << 1];
        System.arraycopy(arr_selectionKey, 0, arr_selectionKey1, 0, this.size);
        this.keys = arr_selectionKey1;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int idx;

            @Override
            public boolean hasNext() {
                return this.idx < SelectedSelectionKeySet.this.size;
            }

            @Override
            public Object next() {
                return this.next();
            }

            public SelectionKey next() {
                if(!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                int v = this.idx;
                this.idx = v + 1;
                return SelectedSelectionKeySet.this.keys[v];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public boolean remove(Object object0) {
        return false;
    }

    public void reset() {
        this.reset(0);
    }

    public void reset(int v) {
        Arrays.fill(this.keys, v, this.size, null);
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }
}

