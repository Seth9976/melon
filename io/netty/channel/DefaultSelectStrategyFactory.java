package io.netty.channel;

public final class DefaultSelectStrategyFactory implements SelectStrategyFactory {
    public static final SelectStrategyFactory INSTANCE;

    static {
        DefaultSelectStrategyFactory.INSTANCE = new DefaultSelectStrategyFactory();
    }

    @Override  // io.netty.channel.SelectStrategyFactory
    public SelectStrategy newSelectStrategy() {
        return DefaultSelectStrategy.INSTANCE;
    }
}

