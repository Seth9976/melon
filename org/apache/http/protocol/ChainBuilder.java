package org.apache.http.protocol;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
final class ChainBuilder {
    private final LinkedList list;
    private final Map uniqueClasses;

    public ChainBuilder() {
        this.list = new LinkedList();
        this.uniqueClasses = new HashMap();
    }

    public ChainBuilder addAllFirst(Collection collection0) {
        if(collection0 != null) {
            for(Object object0: collection0) {
                this.addFirst(object0);
            }
        }
        return this;
    }

    public ChainBuilder addAllFirst(Object[] arr_object) {
        if(arr_object != null) {
            for(int v = 0; v < arr_object.length; ++v) {
                this.addFirst(arr_object[v]);
            }
        }
        return this;
    }

    public ChainBuilder addAllLast(Collection collection0) {
        if(collection0 != null) {
            for(Object object0: collection0) {
                this.addLast(object0);
            }
        }
        return this;
    }

    public ChainBuilder addAllLast(Object[] arr_object) {
        if(arr_object != null) {
            for(int v = 0; v < arr_object.length; ++v) {
                this.addLast(arr_object[v]);
            }
        }
        return this;
    }

    public ChainBuilder addFirst(Object object0) {
        if(object0 == null) {
            return this;
        }
        this.ensureUnique(object0);
        this.list.addFirst(object0);
        return this;
    }

    public ChainBuilder addLast(Object object0) {
        if(object0 == null) {
            return this;
        }
        this.ensureUnique(object0);
        this.list.addLast(object0);
        return this;
    }

    public LinkedList build() {
        return new LinkedList(this.list);
    }

    private void ensureUnique(Object object0) {
        Class class0 = object0.getClass();
        Object object1 = this.uniqueClasses.remove(class0);
        if(object1 != null) {
            this.list.remove(object1);
        }
        Class class1 = object0.getClass();
        this.uniqueClasses.put(class1, object0);
    }
}

