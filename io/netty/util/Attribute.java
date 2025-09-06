package io.netty.util;

public interface Attribute {
    boolean compareAndSet(Object arg1, Object arg2);

    Object get();

    @Deprecated
    Object getAndRemove();

    Object getAndSet(Object arg1);

    AttributeKey key();

    @Deprecated
    void remove();

    void set(Object arg1);

    Object setIfAbsent(Object arg1);
}

