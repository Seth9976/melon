package com.google.android.exoplayer2.source;

import java.util.Arrays;
import java.util.Random;

public interface ShuffleOrder {
    public static class DefaultShuffleOrder implements ShuffleOrder {
        private final int[] indexInShuffled;
        private final Random random;
        private final int[] shuffled;

        public DefaultShuffleOrder(int v) {
            this(v, new Random());
        }

        public DefaultShuffleOrder(int v, long v1) {
            this(v, new Random(v1));
        }

        private DefaultShuffleOrder(int v, Random random0) {
            this(DefaultShuffleOrder.createShuffledList(v, random0), random0);
        }

        public DefaultShuffleOrder(int[] arr_v, long v) {
            this(Arrays.copyOf(arr_v, arr_v.length), new Random(v));
        }

        private DefaultShuffleOrder(int[] arr_v, Random random0) {
            this.shuffled = arr_v;
            this.random = random0;
            this.indexInShuffled = new int[arr_v.length];
            for(int v = 0; v < arr_v.length; ++v) {
                this.indexInShuffled[arr_v[v]] = v;
            }
        }

        @Override  // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndClear() {
            return new DefaultShuffleOrder(0, new Random(this.random.nextLong()));
        }

        @Override  // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndInsert(int v, int v1) {
            int[] arr_v = new int[v1];
            int[] arr_v1 = new int[v1];
            for(int v3 = 0; v3 < v1; ++v3) {
                arr_v[v3] = this.random.nextInt(this.shuffled.length + 1);
                int v4 = this.random.nextInt(v3 + 1);
                arr_v1[v3] = arr_v1[v4];
                arr_v1[v4] = v3 + v;
            }
            Arrays.sort(arr_v);
            int[] arr_v2 = new int[this.shuffled.length + v1];
            int v5 = 0;
            int v6 = 0;
            for(int v2 = 0; true; ++v2) {
                int[] arr_v3 = this.shuffled;
                if(v2 >= arr_v3.length + v1) {
                    break;
                }
                if(v5 >= v1 || v6 != arr_v[v5]) {
                    int v7 = arr_v3[v6];
                    arr_v2[v2] = v7;
                    if(v7 >= v) {
                        arr_v2[v2] = v7 + v1;
                    }
                    ++v6;
                }
                else {
                    arr_v2[v2] = arr_v1[v5];
                    ++v5;
                }
            }
            return new DefaultShuffleOrder(arr_v2, new Random(this.random.nextLong()));
        }

        @Override  // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndRemove(int v, int v1) {
            int v2 = v1 - v;
            int[] arr_v = new int[this.shuffled.length - v2];
            int v4 = 0;
            for(int v3 = 0; true; ++v3) {
                int[] arr_v1 = this.shuffled;
                if(v3 >= arr_v1.length) {
                    break;
                }
                int v5 = arr_v1[v3];
                if(v5 < v || v5 >= v1) {
                    if(v5 >= v) {
                        v5 -= v2;
                    }
                    arr_v[v3 - v4] = v5;
                }
                else {
                    ++v4;
                }
            }
            return new DefaultShuffleOrder(arr_v, new Random(this.random.nextLong()));
        }

        private static int[] createShuffledList(int v, Random random0) {
            int[] arr_v = new int[v];
            for(int v1 = 0; v1 < v; ++v1) {
                int v2 = random0.nextInt(v1 + 1);
                arr_v[v1] = arr_v[v2];
                arr_v[v2] = v1;
            }
            return arr_v;
        }

        @Override  // com.google.android.exoplayer2.source.ShuffleOrder
        public int getFirstIndex() {
            return this.shuffled.length <= 0 ? -1 : this.shuffled[0];
        }

        @Override  // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLastIndex() {
            return this.shuffled.length <= 0 ? -1 : this.shuffled[this.shuffled.length - 1];
        }

        @Override  // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLength() {
            return this.shuffled.length;
        }

        @Override  // com.google.android.exoplayer2.source.ShuffleOrder
        public int getNextIndex(int v) {
            int v1 = this.indexInShuffled[v] + 1;
            return v1 >= this.shuffled.length ? -1 : this.shuffled[v1];
        }

        @Override  // com.google.android.exoplayer2.source.ShuffleOrder
        public int getPreviousIndex(int v) {
            int v1 = this.indexInShuffled[v] - 1;
            return v1 < 0 ? -1 : this.shuffled[v1];
        }
    }

    public static final class UnshuffledShuffleOrder implements ShuffleOrder {
        private final int length;

        public UnshuffledShuffleOrder(int v) {
            this.length = v;
        }

        @Override  // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndClear() {
            return new UnshuffledShuffleOrder(0);
        }

        @Override  // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndInsert(int v, int v1) {
            return new UnshuffledShuffleOrder(this.length + v1);
        }

        @Override  // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndRemove(int v, int v1) {
            return new UnshuffledShuffleOrder(this.length - v1 + v);
        }

        @Override  // com.google.android.exoplayer2.source.ShuffleOrder
        public int getFirstIndex() {
            return this.length <= 0 ? -1 : 0;
        }

        @Override  // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLastIndex() {
            return this.length <= 0 ? -1 : this.length - 1;
        }

        @Override  // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLength() {
            return this.length;
        }

        @Override  // com.google.android.exoplayer2.source.ShuffleOrder
        public int getNextIndex(int v) {
            return v + 1 >= this.length ? -1 : v + 1;
        }

        @Override  // com.google.android.exoplayer2.source.ShuffleOrder
        public int getPreviousIndex(int v) {
            return v - 1 < 0 ? -1 : v - 1;
        }
    }

    ShuffleOrder cloneAndClear();

    ShuffleOrder cloneAndInsert(int arg1, int arg2);

    ShuffleOrder cloneAndRemove(int arg1, int arg2);

    int getFirstIndex();

    int getLastIndex();

    int getLength();

    int getNextIndex(int arg1);

    int getPreviousIndex(int arg1);
}

