package io.netty.channel.group;

import io.netty.util.internal.ObjectUtil;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class CombinedIterator implements Iterator {
    private Iterator currentIterator;
    private final Iterator i1;
    private final Iterator i2;

    public CombinedIterator(Iterator iterator0, Iterator iterator1) {
        this.i1 = (Iterator)ObjectUtil.checkNotNull(iterator0, "i1");
        this.i2 = (Iterator)ObjectUtil.checkNotNull(iterator1, "i2");
        this.currentIterator = iterator0;
    }

    @Override
    public boolean hasNext() {
        while(true) {
            if(this.currentIterator.hasNext()) {
                return true;
            }
            if(this.currentIterator != this.i1) {
                break;
            }
            this.currentIterator = this.i2;
        }
        return false;
    }

    @Override
    public Object next() {
        while(true) {
            try {
                return this.currentIterator.next();
            }
            catch(NoSuchElementException noSuchElementException0) {
            }
            if(this.currentIterator != this.i1) {
                break;
            }
            this.currentIterator = this.i2;
        }
        throw noSuchElementException0;
    }

    @Override
    public void remove() {
        this.currentIterator.remove();
    }
}

