package io.netty.util.internal;

public final class NoOpTypeParameterMatcher extends TypeParameterMatcher {
    @Override  // io.netty.util.internal.TypeParameterMatcher
    public boolean match(Object object0) {
        return true;
    }
}

