package io.netty.util.concurrent;

import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.PlatformDependent;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

public class FastThreadLocal {
    private final int index;

    public FastThreadLocal() {
        this.index = InternalThreadLocalMap.nextVariableIndex();
    }

    private static void addToVariablesToRemove(InternalThreadLocalMap internalThreadLocalMap0, FastThreadLocal fastThreadLocal0) {
        Set set0;
        int v = InternalThreadLocalMap.VARIABLES_TO_REMOVE_INDEX;
        Object object0 = internalThreadLocalMap0.indexedVariable(v);
        if(object0 == InternalThreadLocalMap.UNSET || object0 == null) {
            set0 = Collections.newSetFromMap(new IdentityHashMap());
            internalThreadLocalMap0.setIndexedVariable(v, set0);
        }
        else {
            set0 = (Set)object0;
        }
        set0.add(fastThreadLocal0);
    }

    public static void destroy() {
        InternalThreadLocalMap.destroy();
    }

    public final Object get() {
        InternalThreadLocalMap internalThreadLocalMap0 = InternalThreadLocalMap.get();
        Object object0 = internalThreadLocalMap0.indexedVariable(this.index);
        return object0 == InternalThreadLocalMap.UNSET ? this.initialize(internalThreadLocalMap0) : object0;
    }

    public final Object get(InternalThreadLocalMap internalThreadLocalMap0) {
        Object object0 = internalThreadLocalMap0.indexedVariable(this.index);
        return object0 == InternalThreadLocalMap.UNSET ? this.initialize(internalThreadLocalMap0) : object0;
    }

    public final Object getIfExists() {
        InternalThreadLocalMap internalThreadLocalMap0 = InternalThreadLocalMap.getIfSet();
        if(internalThreadLocalMap0 != null) {
            Object object0 = internalThreadLocalMap0.indexedVariable(this.index);
            return object0 == InternalThreadLocalMap.UNSET ? null : object0;
        }
        return null;
    }

    public Object initialValue() {
        return null;
    }

    private Object initialize(InternalThreadLocalMap internalThreadLocalMap0) {
        Object object0 = null;
        try {
            object0 = this.initialValue();
            if(object0 == InternalThreadLocalMap.UNSET) {
                throw new IllegalArgumentException("InternalThreadLocalMap.UNSET can not be initial value.");
            }
        }
        catch(Exception exception0) {
            PlatformDependent.throwException(exception0);
        }
        internalThreadLocalMap0.setIndexedVariable(this.index, object0);
        FastThreadLocal.addToVariablesToRemove(internalThreadLocalMap0, this);
        return object0;
    }

    public final boolean isSet() {
        return this.isSet(InternalThreadLocalMap.getIfSet());
    }

    public final boolean isSet(InternalThreadLocalMap internalThreadLocalMap0) {
        return internalThreadLocalMap0 != null && internalThreadLocalMap0.isIndexedVariableSet(this.index);
    }

    public void onRemoval(Object object0) {
    }

    public final void remove() {
        this.remove(InternalThreadLocalMap.getIfSet());
    }

    public final void remove(InternalThreadLocalMap internalThreadLocalMap0) {
        if(internalThreadLocalMap0 != null) {
            Object object0 = internalThreadLocalMap0.removeIndexedVariable(this.index);
            if(object0 != InternalThreadLocalMap.UNSET) {
                FastThreadLocal.removeFromVariablesToRemove(internalThreadLocalMap0, this);
                try {
                    this.onRemoval(object0);
                }
                catch(Exception exception0) {
                    PlatformDependent.throwException(exception0);
                }
            }
        }
    }

    public static void removeAll() {
        InternalThreadLocalMap internalThreadLocalMap0 = InternalThreadLocalMap.getIfSet();
        if(internalThreadLocalMap0 == null) {
            return;
        }
        try {
            Object object0 = internalThreadLocalMap0.indexedVariable(InternalThreadLocalMap.VARIABLES_TO_REMOVE_INDEX);
            if(object0 != null && object0 != InternalThreadLocalMap.UNSET) {
                FastThreadLocal[] arr_fastThreadLocal = (FastThreadLocal[])((Set)object0).toArray(new FastThreadLocal[0]);
                for(int v1 = 0; v1 < arr_fastThreadLocal.length; ++v1) {
                    arr_fastThreadLocal[v1].remove(internalThreadLocalMap0);
                }
            }
        }
        finally {
            InternalThreadLocalMap.remove();
        }
    }

    private static void removeFromVariablesToRemove(InternalThreadLocalMap internalThreadLocalMap0, FastThreadLocal fastThreadLocal0) {
        Object object0 = internalThreadLocalMap0.indexedVariable(InternalThreadLocalMap.VARIABLES_TO_REMOVE_INDEX);
        if(object0 != InternalThreadLocalMap.UNSET && object0 != null) {
            ((Set)object0).remove(fastThreadLocal0);
        }
    }

    public final void set(InternalThreadLocalMap internalThreadLocalMap0, Object object0) {
        if(object0 != InternalThreadLocalMap.UNSET) {
            this.setKnownNotUnset(internalThreadLocalMap0, object0);
            return;
        }
        this.remove(internalThreadLocalMap0);
    }

    public final void set(Object object0) {
        if(object0 != InternalThreadLocalMap.UNSET) {
            this.setKnownNotUnset(InternalThreadLocalMap.get(), object0);
            return;
        }
        this.remove();
    }

    private void setKnownNotUnset(InternalThreadLocalMap internalThreadLocalMap0, Object object0) {
        if(internalThreadLocalMap0.setIndexedVariable(this.index, object0)) {
            FastThreadLocal.addToVariablesToRemove(internalThreadLocalMap0, this);
        }
    }

    public static int size() {
        InternalThreadLocalMap internalThreadLocalMap0 = InternalThreadLocalMap.getIfSet();
        return internalThreadLocalMap0 == null ? 0 : internalThreadLocalMap0.size();
    }
}

