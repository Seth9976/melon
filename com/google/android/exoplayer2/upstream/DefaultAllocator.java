package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

public final class DefaultAllocator implements Allocator {
    private static final int AVAILABLE_EXTRA_CAPACITY = 100;
    private int allocatedCount;
    private Allocation[] availableAllocations;
    private int availableCount;
    private final int individualAllocationSize;
    private final byte[] initialAllocationBlock;
    private final Allocation[] singleAllocationReleaseHolder;
    private int targetBufferSize;
    private final boolean trimOnReset;

    public DefaultAllocator(boolean z, int v) {
        this(z, v, 0);
    }

    public DefaultAllocator(boolean z, int v, int v1) {
        Assertions.checkArgument(v > 0);
        Assertions.checkArgument(v1 >= 0);
        this.trimOnReset = z;
        this.individualAllocationSize = v;
        this.availableCount = v1;
        this.availableAllocations = new Allocation[v1 + 100];
        if(v1 > 0) {
            this.initialAllocationBlock = new byte[v1 * v];
            for(int v2 = 0; v2 < v1; ++v2) {
                Allocation[] arr_allocation = this.availableAllocations;
                arr_allocation[v2] = new Allocation(this.initialAllocationBlock, v2 * v);
            }
        }
        else {
            this.initialAllocationBlock = null;
        }
        this.singleAllocationReleaseHolder = new Allocation[1];
    }

    @Override  // com.google.android.exoplayer2.upstream.Allocator
    public Allocation allocate() {
        Allocation allocation0;
        synchronized(this) {
            ++this.allocatedCount;
            int v1 = this.availableCount;
            if(v1 > 0) {
                Allocation[] arr_allocation = this.availableAllocations;
                this.availableCount = v1 - 1;
                allocation0 = arr_allocation[v1 - 1];
                arr_allocation[v1 - 1] = null;
            }
            else {
                allocation0 = new Allocation(new byte[this.individualAllocationSize], 0);
            }
            return allocation0;
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.Allocator
    public int getIndividualAllocationLength() {
        return this.individualAllocationSize;
    }

    @Override  // com.google.android.exoplayer2.upstream.Allocator
    public int getTotalBytesAllocated() {
        synchronized(this) {
        }
        return this.allocatedCount * this.individualAllocationSize;
    }

    @Override  // com.google.android.exoplayer2.upstream.Allocator
    public void release(Allocation allocation0) {
        synchronized(this) {
            this.singleAllocationReleaseHolder[0] = allocation0;
            this.release(this.singleAllocationReleaseHolder);
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.Allocator
    public void release(Allocation[] arr_allocation) {
        synchronized(this) {
            int v1 = this.availableCount;
            Allocation[] arr_allocation1 = this.availableAllocations;
            if(arr_allocation.length + v1 >= arr_allocation1.length) {
                this.availableAllocations = (Allocation[])Arrays.copyOf(arr_allocation1, Math.max(arr_allocation1.length * 2, v1 + arr_allocation.length));
            }
            for(int v2 = 0; v2 < arr_allocation.length; ++v2) {
                int v3 = this.availableCount;
                this.availableCount = v3 + 1;
                this.availableAllocations[v3] = arr_allocation[v2];
            }
            this.allocatedCount -= arr_allocation.length;
            this.notifyAll();
        }
    }

    public void reset() {
        synchronized(this) {
            if(this.trimOnReset) {
                this.setTargetBufferSize(0);
            }
        }
    }

    public void setTargetBufferSize(int v) {
        synchronized(this) {
            boolean z = v < this.targetBufferSize;
            this.targetBufferSize = v;
            if(z) {
                this.trim();
            }
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.Allocator
    public void trim() {
        synchronized(this) {
            int v1 = 0;
            int v2 = Math.max(0, (this.targetBufferSize + this.individualAllocationSize - 1) / this.individualAllocationSize - this.allocatedCount);
            int v3 = this.availableCount;
            if(v2 >= v3) {
                return;
            }
            if(this.initialAllocationBlock != null) {
                int v4 = v3 - 1;
                while(v1 <= v4) {
                    Allocation[] arr_allocation = this.availableAllocations;
                    Allocation allocation0 = arr_allocation[v1];
                    byte[] arr_b = this.initialAllocationBlock;
                    if(allocation0.data == arr_b) {
                        ++v1;
                    }
                    else {
                        Allocation allocation1 = arr_allocation[v4];
                        if(allocation1.data == arr_b) {
                            arr_allocation[v1] = allocation1;
                            arr_allocation[v4] = allocation0;
                            --v4;
                            ++v1;
                        }
                        else {
                            --v4;
                        }
                    }
                }
                v2 = Math.max(v2, v1);
                if(v2 >= this.availableCount) {
                    return;
                }
            }
            Arrays.fill(this.availableAllocations, v2, this.availableCount, null);
            this.availableCount = v2;
        }
    }
}

