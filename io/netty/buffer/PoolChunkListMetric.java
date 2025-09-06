package io.netty.buffer;

public interface PoolChunkListMetric extends Iterable {
    int maxUsage();

    int minUsage();
}

