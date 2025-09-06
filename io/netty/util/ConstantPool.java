package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class ConstantPool {
    private final ConcurrentMap constants;
    private final AtomicInteger nextId;

    public ConstantPool() {
        this.constants = PlatformDependent.newConcurrentHashMap();
        this.nextId = new AtomicInteger(1);
    }

    private Constant createOrThrow(String s) {
        if(((Constant)this.constants.get(s)) == null) {
            Constant constant0 = this.newConstant(this.nextId(), s);
            if(((Constant)this.constants.putIfAbsent(s, constant0)) == null) {
                return constant0;
            }
        }
        throw new IllegalArgumentException("\'" + s + "\' is already in use");
    }

    public boolean exists(String s) {
        String s1 = ObjectUtil.checkNonEmpty(s, "name");
        return this.constants.containsKey(s1);
    }

    private Constant getOrCreate(String s) {
        Constant constant0 = (Constant)this.constants.get(s);
        if(constant0 == null) {
            Constant constant1 = this.newConstant(this.nextId(), s);
            Constant constant2 = (Constant)this.constants.putIfAbsent(s, constant1);
            return constant2 == null ? constant1 : constant2;
        }
        return constant0;
    }

    public abstract Constant newConstant(int arg1, String arg2);

    public Constant newInstance(String s) {
        return this.createOrThrow(ObjectUtil.checkNonEmpty(s, "name"));
    }

    @Deprecated
    public final int nextId() {
        return this.nextId.getAndIncrement();
    }

    public Constant valueOf(Class class0, String s) {
        return this.valueOf(((Class)ObjectUtil.checkNotNull(class0, "firstNameComponent")).getName() + '#' + ((String)ObjectUtil.checkNotNull(s, "secondNameComponent")));
    }

    public Constant valueOf(String s) {
        return this.getOrCreate(ObjectUtil.checkNonEmpty(s, "name"));
    }
}

