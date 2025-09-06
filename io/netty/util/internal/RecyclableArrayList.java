package io.netty.util.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public final class RecyclableArrayList extends ArrayList {
    private static final int DEFAULT_INITIAL_CAPACITY = 8;
    private static final ObjectPool RECYCLER = null;
    private final Handle handle;
    private boolean insertSinceRecycled;
    private static final long serialVersionUID = 0x889473CF3735F415L;

    static {
        RecyclableArrayList.RECYCLER = ObjectPool.newPool(new ObjectCreator() {
            public RecyclableArrayList newObject(Handle objectPool$Handle0) {
                return new RecyclableArrayList(objectPool$Handle0, null);
            }

            @Override  // io.netty.util.internal.ObjectPool$ObjectCreator
            public Object newObject(Handle objectPool$Handle0) {
                return this.newObject(objectPool$Handle0);
            }
        });
    }

    private RecyclableArrayList(Handle objectPool$Handle0) {
        this(objectPool$Handle0, 8);
    }

    private RecyclableArrayList(Handle objectPool$Handle0, int v) {
        super(v);
        this.handle = objectPool$Handle0;
    }

    public RecyclableArrayList(Handle objectPool$Handle0, io.netty.util.internal.RecyclableArrayList.1 recyclableArrayList$10) {
        this(objectPool$Handle0);
    }

    @Override
    public void add(int v, Object object0) {
        super.add(v, ObjectUtil.checkNotNull(object0, "element"));
        this.insertSinceRecycled = true;
    }

    @Override
    public boolean add(Object object0) {
        if(super.add(ObjectUtil.checkNotNull(object0, "element"))) {
            this.insertSinceRecycled = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(int v, Collection collection0) {
        RecyclableArrayList.checkNullElements(collection0);
        if(super.addAll(v, collection0)) {
            this.insertSinceRecycled = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection collection0) {
        RecyclableArrayList.checkNullElements(collection0);
        if(super.addAll(collection0)) {
            this.insertSinceRecycled = true;
            return true;
        }
        return false;
    }

    private static void checkNullElements(Collection collection0) {
        if(!(collection0 instanceof RandomAccess) || !(collection0 instanceof List)) {
            for(Object object0: collection0) {
                if(object0 == null) {
                    throw new IllegalArgumentException("c contains null values");
                }
                if(false) {
                    break;
                }
            }
        }
        else {
            int v = ((List)collection0).size();
            for(int v1 = 0; v1 < v; ++v1) {
                if(((List)collection0).get(v1) == null) {
                    throw new IllegalArgumentException("c contains null values");
                }
            }
        }
    }

    public boolean insertSinceRecycled() {
        return this.insertSinceRecycled;
    }

    public static RecyclableArrayList newInstance() {
        return RecyclableArrayList.newInstance(8);
    }

    public static RecyclableArrayList newInstance(int v) {
        RecyclableArrayList recyclableArrayList0 = (RecyclableArrayList)RecyclableArrayList.RECYCLER.get();
        recyclableArrayList0.ensureCapacity(v);
        return recyclableArrayList0;
    }

    public boolean recycle() {
        this.clear();
        this.insertSinceRecycled = false;
        this.handle.recycle(this);
        return true;
    }

    @Override
    public Object set(int v, Object object0) {
        Object object1 = super.set(v, ObjectUtil.checkNotNull(object0, "element"));
        this.insertSinceRecycled = true;
        return object1;
    }
}

