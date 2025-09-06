package io.netty.util;

public interface UncheckedBooleanSupplier extends BooleanSupplier {
    public static final UncheckedBooleanSupplier FALSE_SUPPLIER;
    public static final UncheckedBooleanSupplier TRUE_SUPPLIER;

    static {
        UncheckedBooleanSupplier.FALSE_SUPPLIER = new UncheckedBooleanSupplier() {
            @Override  // io.netty.util.UncheckedBooleanSupplier
            public boolean get() {
                return false;
            }
        };
        UncheckedBooleanSupplier.TRUE_SUPPLIER = new UncheckedBooleanSupplier() {
            @Override  // io.netty.util.UncheckedBooleanSupplier
            public boolean get() {
                return true;
            }
        };
    }

    @Override  // io.netty.util.BooleanSupplier
    boolean get();
}

