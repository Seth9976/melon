package io.netty.util;

public interface BooleanSupplier {
    public static final BooleanSupplier FALSE_SUPPLIER;
    public static final BooleanSupplier TRUE_SUPPLIER;

    static {
        BooleanSupplier.FALSE_SUPPLIER = new BooleanSupplier() {
            @Override  // io.netty.util.BooleanSupplier
            public boolean get() {
                return false;
            }
        };
        BooleanSupplier.TRUE_SUPPLIER = new BooleanSupplier() {
            @Override  // io.netty.util.BooleanSupplier
            public boolean get() {
                return true;
            }
        };
    }

    boolean get();
}

