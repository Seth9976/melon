package io.netty.channel;

import io.netty.util.IntSupplier;

final class DefaultSelectStrategy implements SelectStrategy {
    static final SelectStrategy INSTANCE;

    static {
        DefaultSelectStrategy.INSTANCE = new DefaultSelectStrategy();
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.channel.SelectStrategy
    public int calculateStrategy(IntSupplier intSupplier0, boolean z) {
        return z ? intSupplier0.get() : -1;
    }
}

