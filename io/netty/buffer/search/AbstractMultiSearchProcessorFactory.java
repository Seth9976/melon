package io.netty.buffer.search;

public abstract class AbstractMultiSearchProcessorFactory implements MultiSearchProcessorFactory {
    public static AhoCorasicSearchProcessorFactory newAhoCorasicSearchProcessorFactory(byte[][] arr2_b) {
        return new AhoCorasicSearchProcessorFactory(arr2_b);
    }
}

