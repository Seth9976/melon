package com.bumptech.glide.util;

import androidx.collection.V;
import androidx.collection.f;

public final class CachedHashCodeArrayMap extends f {
    private int hashCode;

    public CachedHashCodeArrayMap() {
        super(0);
    }

    @Override  // androidx.collection.V
    public void clear() {
        this.hashCode = 0;
        super.clear();
    }

    @Override  // androidx.collection.V
    public int hashCode() {
        if(this.hashCode == 0) {
            this.hashCode = super.hashCode();
        }
        return this.hashCode;
    }

    @Override  // androidx.collection.V
    public Object put(Object object0, Object object1) {
        this.hashCode = 0;
        return super.put(object0, object1);
    }

    @Override  // androidx.collection.V
    public void putAll(V v0) {
        this.hashCode = 0;
        super.putAll(v0);
    }

    @Override  // androidx.collection.V
    public Object removeAt(int v) {
        this.hashCode = 0;
        return super.removeAt(v);
    }

    @Override  // androidx.collection.V
    public Object setValueAt(int v, Object object0) {
        this.hashCode = 0;
        return super.setValueAt(v, object0);
    }
}

