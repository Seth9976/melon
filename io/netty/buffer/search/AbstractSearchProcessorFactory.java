package io.netty.buffer.search;

public abstract class AbstractSearchProcessorFactory implements SearchProcessorFactory {
    public static BitapSearchProcessorFactory newBitapSearchProcessorFactory(byte[] arr_b) {
        return new BitapSearchProcessorFactory(arr_b);
    }

    public static KmpSearchProcessorFactory newKmpSearchProcessorFactory(byte[] arr_b) {
        return new KmpSearchProcessorFactory(arr_b);
    }
}

