package androidx.compose.runtime;

public interface a0 extends b0, b1 {
    default void c(int v) {
        ((K0)this).n(v);
    }

    @Override  // androidx.compose.runtime.b1
    default Object getValue() {
        return ((K0)this).m();
    }

    @Override  // androidx.compose.runtime.b0
    default void setValue(Object object0) {
        this.c(((Number)object0).intValue());
    }
}

