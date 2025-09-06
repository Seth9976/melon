package io.netty.buffer.search;

import io.netty.util.internal.PlatformDependent;

public class BitapSearchProcessorFactory extends AbstractSearchProcessorFactory {
    public static class Processor implements SearchProcessor {
        private final long[] bitMasks;
        private long currentMask;
        private final long successBit;

        public Processor(long[] arr_v, long v) {
            this.bitMasks = arr_v;
            this.successBit = v;
        }

        @Override  // io.netty.util.ByteProcessor
        public boolean process(byte b) {
            long v = (this.currentMask << 1 | 1L) & PlatformDependent.getLong(this.bitMasks, ((long)b) & 0xFFL);
            this.currentMask = v;
            return (v & this.successBit) == 0L;
        }

        @Override  // io.netty.buffer.search.SearchProcessor
        public void reset() {
            this.currentMask = 0L;
        }
    }

    private final long[] bitMasks;
    private final long successBit;

    public BitapSearchProcessorFactory(byte[] arr_b) {
        this.bitMasks = new long[0x100];
        if(arr_b.length > 0x40) {
            throw new IllegalArgumentException("Maximum supported search pattern length is 64, got " + arr_b.length);
        }
        long v1 = 1L;
        for(int v = 0; v < arr_b.length; ++v) {
            int v2 = arr_b[v] & 0xFF;
            this.bitMasks[v2] |= v1;
            v1 <<= 1;
        }
        this.successBit = 1L << arr_b.length - 1;
    }

    public Processor newSearchProcessor() {
        return new Processor(this.bitMasks, this.successBit);
    }

    @Override  // io.netty.buffer.search.SearchProcessorFactory
    public SearchProcessor newSearchProcessor() {
        return this.newSearchProcessor();
    }
}

