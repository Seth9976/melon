package androidx.fragment.app;

import b.a;

public interface h0 {
    default void onBackStackChangeCancelled() {
    }

    default void onBackStackChangeCommitted(I i0, boolean z) {
    }

    default void onBackStackChangeProgressed(a a0) {
    }

    default void onBackStackChangeStarted(I i0, boolean z) {
    }

    void onBackStackChanged();
}

