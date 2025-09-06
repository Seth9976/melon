package io.netty.buffer.search;

import io.netty.util.internal.PlatformDependent;

public class KmpSearchProcessorFactory extends AbstractSearchProcessorFactory {
    public static class Processor implements SearchProcessor {
        private long currentPosition;
        private final int[] jumpTable;
        private final byte[] needle;

        public Processor(byte[] arr_b, int[] arr_v) {
            this.needle = arr_b;
            this.jumpTable = arr_v;
        }

        @Override  // io.netty.util.ByteProcessor
        public boolean process(byte b) {
            while(this.currentPosition > 0L && PlatformDependent.getByte(this.needle, this.currentPosition) != b) {
                this.currentPosition = (long)PlatformDependent.getInt(this.jumpTable, this.currentPosition);
            }
            if(PlatformDependent.getByte(this.needle, this.currentPosition) == b) {
                ++this.currentPosition;
            }
            long v = this.currentPosition;
            if(v == ((long)this.needle.length)) {
                this.currentPosition = (long)PlatformDependent.getInt(this.jumpTable, v);
                return false;
            }
            return true;
        }

        @Override  // io.netty.buffer.search.SearchProcessor
        public void reset() {
            this.currentPosition = 0L;
        }
    }

    private final int[] jumpTable;
    private final byte[] needle;

    public KmpSearchProcessorFactory(byte[] arr_b) {
        this.needle = (byte[])arr_b.clone();
        int v = 1;
        this.jumpTable = new int[arr_b.length + 1];
        int v1 = 0;
        while(v < arr_b.length) {
            while(v1 > 0 && arr_b[v1] != arr_b[v]) {
                v1 = this.jumpTable[v1];
            }
            if(arr_b[v1] == arr_b[v]) {
                ++v1;
            }
            ++v;
            this.jumpTable[v] = v1;
        }
    }

    public Processor newSearchProcessor() {
        return new Processor(this.needle, this.jumpTable);
    }

    @Override  // io.netty.buffer.search.SearchProcessorFactory
    public SearchProcessor newSearchProcessor() {
        return this.newSearchProcessor();
    }
}

