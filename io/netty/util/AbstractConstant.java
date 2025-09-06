package io.netty.util;

import java.util.concurrent.atomic.AtomicLong;

public abstract class AbstractConstant implements Constant {
    private final int id;
    private final String name;
    private static final AtomicLong uniqueIdGenerator;
    private final long uniquifier;

    static {
        AbstractConstant.uniqueIdGenerator = new AtomicLong();
    }

    public AbstractConstant(int v, String s) {
        this.id = v;
        this.name = s;
        this.uniquifier = AbstractConstant.uniqueIdGenerator.getAndIncrement();
    }

    public final int compareTo(AbstractConstant abstractConstant0) {
        if(this == abstractConstant0) {
            return 0;
        }
        int v = this.hashCode() - abstractConstant0.hashCode();
        if(v != 0) {
            return v;
        }
        long v1 = this.uniquifier;
        long v2 = abstractConstant0.uniquifier;
        if(v1 < v2) {
            return -1;
        }
        if(v1 <= v2) {
            throw new Error("failed to compare two different constants");
        }
        return 1;
    }

    @Override
    public int compareTo(Object object0) {
        return this.compareTo(((AbstractConstant)object0));
    }

    @Override
    public final boolean equals(Object object0) {
        return super.equals(object0);
    }

    @Override
    public final int hashCode() {
        return super.hashCode();
    }

    @Override  // io.netty.util.Constant
    public final int id() {
        return this.id;
    }

    @Override  // io.netty.util.Constant
    public final String name() {
        return this.name;
    }

    @Override
    public final String toString() {
        return this.name();
    }
}

