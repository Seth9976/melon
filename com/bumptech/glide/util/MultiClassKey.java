package com.bumptech.glide.util;

public class MultiClassKey {
    private Class first;
    private Class second;
    private Class third;

    public MultiClassKey() {
    }

    public MultiClassKey(Class class0, Class class1) {
        this.set(class0, class1);
    }

    public MultiClassKey(Class class0, Class class1, Class class2) {
        this.set(class0, class1, class2);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 == null || this.getClass() != object0.getClass() || !this.first.equals(((MultiClassKey)object0).first)) {
            return false;
        }
        return this.second.equals(((MultiClassKey)object0).second) ? Util.bothNullOrEqual(this.third, ((MultiClassKey)object0).third) : false;
    }

    @Override
    public int hashCode() {
        int v = this.first.hashCode();
        int v1 = this.second.hashCode();
        return this.third == null ? (v1 + v * 0x1F) * 0x1F : (v1 + v * 0x1F) * 0x1F + this.third.hashCode();
    }

    public void set(Class class0, Class class1) {
        this.set(class0, class1, null);
    }

    public void set(Class class0, Class class1, Class class2) {
        this.first = class0;
        this.second = class1;
        this.third = class2;
    }

    @Override
    public String toString() {
        return "MultiClassKey{first=" + this.first + ", second=" + this.second + '}';
    }
}

