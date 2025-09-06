package io.netty.buffer.search;

import io.netty.util.internal.PlatformDependent;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class AhoCorasicSearchProcessorFactory extends AbstractMultiSearchProcessorFactory {
    static class Context {
        int[] jumpTable;
        int[] matchForNeedleId;

        private Context() {
        }

        public Context(io.netty.buffer.search.AhoCorasicSearchProcessorFactory.1 ahoCorasicSearchProcessorFactory$10) {
        }
    }

    public static class Processor implements MultiSearchProcessor {
        private long currentPosition;
        private final int[] jumpTable;
        private final int[] matchForNeedleId;

        public Processor(int[] arr_v, int[] arr_v1) {
            this.jumpTable = arr_v;
            this.matchForNeedleId = arr_v1;
        }

        @Override  // io.netty.buffer.search.MultiSearchProcessor
        public int getFoundNeedleId() {
            return this.matchForNeedleId[((int)this.currentPosition) >> 8];
        }

        @Override  // io.netty.util.ByteProcessor
        public boolean process(byte b) {
            long v = (long)PlatformDependent.getInt(this.jumpTable, this.currentPosition | ((long)b) & 0xFFL);
            this.currentPosition = v;
            if(v < 0L) {
                this.currentPosition = -v;
                return false;
            }
            return true;
        }

        @Override  // io.netty.buffer.search.SearchProcessor
        public void reset() {
            this.currentPosition = 0L;
        }
    }

    static final int ALPHABET_SIZE = 0x100;
    static final int BITS_PER_SYMBOL = 8;
    private final int[] jumpTable;
    private final int[] matchForNeedleId;

    public AhoCorasicSearchProcessorFactory(byte[][] arr2_b) {
        for(int v1 = 0; v1 < arr2_b.length; ++v1) {
            if(arr2_b[v1].length == 0) {
                throw new IllegalArgumentException("Needle must be non empty");
            }
        }
        Context ahoCorasicSearchProcessorFactory$Context0 = AhoCorasicSearchProcessorFactory.buildTrie(arr2_b);
        this.jumpTable = ahoCorasicSearchProcessorFactory$Context0.jumpTable;
        this.matchForNeedleId = ahoCorasicSearchProcessorFactory$Context0.matchForNeedleId;
        this.linkSuffixes();
        for(int v = 0; true; ++v) {
            int[] arr_v = this.jumpTable;
            if(v >= arr_v.length) {
                break;
            }
            int v2 = arr_v[v];
            if(this.matchForNeedleId[v2 >> 8] >= 0) {
                arr_v[v] = -v2;
            }
        }
    }

    private static Context buildTrie(byte[][] arr2_b) {
        ArrayList arrayList0 = new ArrayList(0x100);
        for(int v1 = 0; v1 < 0x100; ++v1) {
            arrayList0.add(-1);
        }
        ArrayList arrayList1 = new ArrayList();
        arrayList1.add(-1);
        for(int v2 = 0; v2 < arr2_b.length; ++v2) {
            byte[] arr_b = arr2_b[v2];
            int v4 = 0;
            for(int v3 = 0; v3 < arr_b.length; ++v3) {
                int v5 = v4 + (arr_b[v3] & 0xFF);
                if(((int)(((Integer)arrayList0.get(v5)))) == -1) {
                    arrayList0.set(v5, arrayList0.size());
                    for(int v6 = 0; v6 < 0x100; ++v6) {
                        arrayList0.add(-1);
                    }
                    arrayList1.add(-1);
                }
                v4 = (int)(((Integer)arrayList0.get(v5)));
            }
            arrayList1.set(v4 >> 8, v2);
        }
        Context ahoCorasicSearchProcessorFactory$Context0 = new Context(null);
        ahoCorasicSearchProcessorFactory$Context0.jumpTable = new int[arrayList0.size()];
        for(int v7 = 0; v7 < arrayList0.size(); ++v7) {
            int[] arr_v = ahoCorasicSearchProcessorFactory$Context0.jumpTable;
            arr_v[v7] = (int)(((Integer)arrayList0.get(v7)));
        }
        ahoCorasicSearchProcessorFactory$Context0.matchForNeedleId = new int[arrayList1.size()];
        for(int v = 0; v < arrayList1.size(); ++v) {
            int[] arr_v1 = ahoCorasicSearchProcessorFactory$Context0.matchForNeedleId;
            arr_v1[v] = (int)(((Integer)arrayList1.get(v)));
        }
        return ahoCorasicSearchProcessorFactory$Context0;
    }

    private void linkSuffixes() {
        ArrayDeque arrayDeque0 = new ArrayDeque();
        arrayDeque0.add(0);
        int[] arr_v = new int[this.matchForNeedleId.length];
        Arrays.fill(arr_v, -1);
        while(!arrayDeque0.isEmpty()) {
            int v = (int)(((Integer)arrayDeque0.remove()));
            int v1 = v >> 8;
            int v2 = arr_v[v1];
            if(v2 == -1) {
                v2 = 0;
            }
            int[] arr_v1 = this.matchForNeedleId;
            if(arr_v1[v1] == -1) {
                arr_v1[v1] = arr_v1[v2 >> 8];
            }
            for(int v3 = 0; v3 < 0x100; ++v3) {
                int v4 = v | v3;
                int[] arr_v2 = this.jumpTable;
                int v5 = arr_v2[v4];
                int v6 = arr_v2[v2 | v3];
                if(v5 == -1) {
                    if(v6 == -1) {
                        v6 = 0;
                    }
                    arr_v2[v4] = v6;
                }
                else {
                    if(v <= 0 || v6 == -1) {
                        v6 = 0;
                    }
                    arr_v[v5 >> 8] = v6;
                    arrayDeque0.add(v5);
                }
            }
        }
    }

    public Processor newSearchProcessor() {
        return new Processor(this.jumpTable, this.matchForNeedleId);
    }

    @Override  // io.netty.buffer.search.MultiSearchProcessorFactory
    public MultiSearchProcessor newSearchProcessor() {
        return this.newSearchProcessor();
    }

    @Override  // io.netty.buffer.search.SearchProcessorFactory
    public SearchProcessor newSearchProcessor() {
        return this.newSearchProcessor();
    }

    class io.netty.buffer.search.AhoCorasicSearchProcessorFactory.1 {
    }

}

