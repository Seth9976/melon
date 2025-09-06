package com.bumptech.glide.util.pool;

import android.util.Log;
import b2.d;
import b2.e;
import b2.f;
import java.util.ArrayList;
import java.util.List;

public final class FactoryPools {
    public interface Factory {
        Object create();
    }

    static final class FactoryPool implements d {
        private final Factory factory;
        private final d pool;
        private final Resetter resetter;

        public FactoryPool(d d0, Factory factoryPools$Factory0, Resetter factoryPools$Resetter0) {
            this.pool = d0;
            this.factory = factoryPools$Factory0;
            this.resetter = factoryPools$Resetter0;
        }

        @Override  // b2.d
        public Object acquire() {
            Object object0 = this.pool.acquire();
            if(object0 == null) {
                object0 = this.factory.create();
                if(Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + object0.getClass());
                }
            }
            if(object0 instanceof Poolable) {
                ((Poolable)object0).getVerifier().setRecycled(false);
            }
            return object0;
        }

        @Override  // b2.d
        public boolean release(Object object0) {
            if(object0 instanceof Poolable) {
                ((Poolable)object0).getVerifier().setRecycled(true);
            }
            this.resetter.reset(object0);
            return this.pool.release(object0);
        }
    }

    public interface Poolable {
        StateVerifier getVerifier();
    }

    public interface Resetter {
        void reset(Object arg1);
    }

    private static final int DEFAULT_POOL_SIZE = 20;
    private static final Resetter EMPTY_RESETTER = null;
    private static final String TAG = "FactoryPools";

    static {
        FactoryPools.EMPTY_RESETTER = new Resetter() {
            @Override  // com.bumptech.glide.util.pool.FactoryPools$Resetter
            public void reset(Object object0) {
            }
        };
    }

    private static d build(d d0, Factory factoryPools$Factory0) {
        return FactoryPools.build(d0, factoryPools$Factory0, FactoryPools.emptyResetter());
    }

    private static d build(d d0, Factory factoryPools$Factory0, Resetter factoryPools$Resetter0) {
        return new FactoryPool(d0, factoryPools$Factory0, factoryPools$Resetter0);
    }

    private static Resetter emptyResetter() {
        return FactoryPools.EMPTY_RESETTER;
    }

    public static d simple(int v, Factory factoryPools$Factory0) {
        return FactoryPools.build(new e(v, 0), factoryPools$Factory0);
    }

    public static d threadSafe(int v, Factory factoryPools$Factory0) {
        return FactoryPools.build(new f(v), factoryPools$Factory0);
    }

    public static d threadSafe(int v, Factory factoryPools$Factory0, Resetter factoryPools$Resetter0) {
        return FactoryPools.build(new f(v), factoryPools$Factory0, factoryPools$Resetter0);
    }

    public static d threadSafeList() {
        return FactoryPools.threadSafeList(20);
    }

    public static d threadSafeList(int v) {
        return FactoryPools.build(new f(v), new Factory() {
            @Override  // com.bumptech.glide.util.pool.FactoryPools$Factory
            public Object create() {
                return this.create();
            }

            public List create() {
                return new ArrayList();
            }
        }, new Resetter() {
            @Override  // com.bumptech.glide.util.pool.FactoryPools$Resetter
            public void reset(Object object0) {
                this.reset(((List)object0));
            }

            public void reset(List list0) {
                list0.clear();
            }
        });
    }
}

