package io.netty.util.internal;

import io.netty.util.Recycler;

public abstract class ObjectPool {
    public interface Handle {
        void recycle(Object arg1);
    }

    public interface ObjectCreator {
        Object newObject(Handle arg1);
    }

    static final class RecyclerObjectPool extends ObjectPool {
        private final Recycler recycler;

        public RecyclerObjectPool(ObjectCreator objectPool$ObjectCreator0) {
            this.recycler = new Recycler() {
                @Override  // io.netty.util.Recycler
                public Object newObject(io.netty.util.Recycler.Handle recycler$Handle0) {
                    return objectPool$ObjectCreator0.newObject(recycler$Handle0);
                }
            };
        }

        @Override  // io.netty.util.internal.ObjectPool
        public Object get() {
            return this.recycler.get();
        }
    }

    public abstract Object get();

    public static ObjectPool newPool(ObjectCreator objectPool$ObjectCreator0) {
        return new RecyclerObjectPool(((ObjectCreator)ObjectUtil.checkNotNull(objectPool$ObjectCreator0, "creator")));
    }
}

