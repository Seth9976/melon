package io.netty.channel;

import com.iloen.melon.utils.a;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;

public class AdaptiveRecvByteBufAllocator extends DefaultMaxMessagesRecvByteBufAllocator {
    final class HandleImpl extends MaxMessageHandle {
        private boolean decreaseNow;
        private int index;
        private final int maxIndex;
        private final int minIndex;
        private int nextReceiveBufferSize;

        public HandleImpl(int v, int v1, int v2) {
            this.minIndex = v;
            this.maxIndex = v1;
            this.index = AdaptiveRecvByteBufAllocator.getSizeTableIndex(v2);
            this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public int guess() {
            return this.nextReceiveBufferSize;
        }

        @Override  // io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator$MaxMessageHandle
        public void lastBytesRead(int v) {
            if(v == this.attemptedBytesRead()) {
                this.record(v);
            }
            super.lastBytesRead(v);
        }

        @Override  // io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator$MaxMessageHandle
        public void readComplete() {
            this.record(this.totalBytesRead());
        }

        private void record(int v) {
            if(v <= AdaptiveRecvByteBufAllocator.SIZE_TABLE[Math.max(0, this.index - 1)]) {
                if(this.decreaseNow) {
                    this.index = Math.max(this.index - 1, this.minIndex);
                    this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
                    this.decreaseNow = false;
                    return;
                }
                this.decreaseNow = true;
                return;
            }
            if(v >= this.nextReceiveBufferSize) {
                this.index = Math.min(this.index + 4, this.maxIndex);
                this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
                this.decreaseNow = false;
            }
        }
    }

    @Deprecated
    public static final AdaptiveRecvByteBufAllocator DEFAULT = null;
    static final int DEFAULT_INITIAL = 0x800;
    static final int DEFAULT_MAXIMUM = 0x10000;
    static final int DEFAULT_MINIMUM = 0x40;
    private static final int INDEX_DECREMENT = 1;
    private static final int INDEX_INCREMENT = 4;
    private static final int[] SIZE_TABLE;
    private final int initial;
    private final int maxIndex;
    private final int minIndex;

    static {
        ArrayList arrayList0 = new ArrayList();
        for(int v = 16; v < 0x200; v = a.d(v, v, 16, arrayList0)) {
        }
        for(int v1 = 0x200; v1 > 0; v1 <<= 1) {
            arrayList0.add(v1);
        }
        AdaptiveRecvByteBufAllocator.SIZE_TABLE = new int[arrayList0.size()];
        for(int v2 = 0; true; ++v2) {
            int[] arr_v = AdaptiveRecvByteBufAllocator.SIZE_TABLE;
            if(v2 >= arr_v.length) {
                break;
            }
            arr_v[v2] = (int)(((Integer)arrayList0.get(v2)));
        }
        AdaptiveRecvByteBufAllocator.DEFAULT = new AdaptiveRecvByteBufAllocator();
    }

    public AdaptiveRecvByteBufAllocator() {
        this(0x40, 0x800, 0x10000);
    }

    public AdaptiveRecvByteBufAllocator(int v, int v1, int v2) {
        ObjectUtil.checkPositive(v, "minimum");
        if(v1 < v) {
            throw new IllegalArgumentException("initial: " + v1);
        }
        if(v2 < v1) {
            throw new IllegalArgumentException("maximum: " + v2);
        }
        int v3 = AdaptiveRecvByteBufAllocator.getSizeTableIndex(v);
        int[] arr_v = AdaptiveRecvByteBufAllocator.SIZE_TABLE;
        this.minIndex = arr_v[v3] < v ? v3 + 1 : v3;
        int v4 = AdaptiveRecvByteBufAllocator.getSizeTableIndex(v2);
        this.maxIndex = arr_v[v4] > v2 ? v4 - 1 : v4;
        this.initial = v1;
    }

    private static int getSizeTableIndex(int v) {
        int v5;
        int v4;
        int v3;
        int v1 = AdaptiveRecvByteBufAllocator.SIZE_TABLE.length - 1;
        int v2 = 0;
        while(true) {
            if(v1 < v2) {
                return v2;
            }
            if(v1 == v2) {
                return v1;
            }
            v3 = v2 + v1 >>> 1;
            v4 = AdaptiveRecvByteBufAllocator.SIZE_TABLE[v3];
            v5 = v3 + 1;
            if(v > AdaptiveRecvByteBufAllocator.SIZE_TABLE[v5]) {
                v2 = v5;
            }
            else {
                if(v >= v4) {
                    break;
                }
                v1 = v3 - 1;
            }
        }
        return v == v4 ? v3 : v5;
    }

    @Override  // io.netty.channel.RecvByteBufAllocator
    public Handle newHandle() {
        return new HandleImpl(this, this.minIndex, this.maxIndex, this.initial);
    }

    public AdaptiveRecvByteBufAllocator respectMaybeMoreData(boolean z) {
        super.respectMaybeMoreData(z);
        return this;
    }

    @Override  // io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator
    public DefaultMaxMessagesRecvByteBufAllocator respectMaybeMoreData(boolean z) {
        return this.respectMaybeMoreData(z);
    }
}

