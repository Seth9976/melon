package com.bumptech.glide.util;

public final class GlideSuppliers {
    public interface GlideSupplier {
        Object get();
    }

    public static GlideSupplier memorize(GlideSupplier glideSuppliers$GlideSupplier0) {
        return new GlideSupplier() {
            private volatile Object instance;

            @Override  // com.bumptech.glide.util.GlideSuppliers$GlideSupplier
            public Object get() {
                if(this.instance == null) {
                    synchronized(this) {
                        if(this.instance == null) {
                            this.instance = Preconditions.checkNotNull(glideSuppliers$GlideSupplier0.get());
                        }
                    }
                }
                return this.instance;
            }
        };
    }
}

