package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.upstream.Allocation;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.Arrays;

class SampleDataQueue {
    static final class AllocationNode {
        public Allocation allocation;
        public final long endPosition;
        public AllocationNode next;
        public final long startPosition;
        public boolean wasInitialized;

        public AllocationNode(long v, int v1) {
            this.startPosition = v;
            this.endPosition = v + ((long)v1);
        }

        public AllocationNode clear() {
            this.allocation = null;
            AllocationNode sampleDataQueue$AllocationNode0 = this.next;
            this.next = null;
            return sampleDataQueue$AllocationNode0;
        }

        public void initialize(Allocation allocation0, AllocationNode sampleDataQueue$AllocationNode0) {
            this.allocation = allocation0;
            this.next = sampleDataQueue$AllocationNode0;
            this.wasInitialized = true;
        }

        public int translateOffset(long v) {
            return ((int)(v - this.startPosition)) + this.allocation.offset;
        }
    }

    private static final int INITIAL_SCRATCH_SIZE = 0x20;
    private final int allocationLength;
    private final Allocator allocator;
    private AllocationNode firstAllocationNode;
    private AllocationNode readAllocationNode;
    private final ParsableByteArray scratch;
    private long totalBytesWritten;
    private AllocationNode writeAllocationNode;

    public SampleDataQueue(Allocator allocator0) {
        this.allocator = allocator0;
        int v = allocator0.getIndividualAllocationLength();
        this.allocationLength = v;
        this.scratch = new ParsableByteArray(0x20);
        AllocationNode sampleDataQueue$AllocationNode0 = new AllocationNode(0L, v);
        this.firstAllocationNode = sampleDataQueue$AllocationNode0;
        this.readAllocationNode = sampleDataQueue$AllocationNode0;
        this.writeAllocationNode = sampleDataQueue$AllocationNode0;
    }

    private void advanceReadTo(long v) {
        while(true) {
            AllocationNode sampleDataQueue$AllocationNode0 = this.readAllocationNode;
            if(v < sampleDataQueue$AllocationNode0.endPosition) {
                break;
            }
            this.readAllocationNode = sampleDataQueue$AllocationNode0.next;
        }
    }

    private void clearAllocationNodes(AllocationNode sampleDataQueue$AllocationNode0) {
        if(!sampleDataQueue$AllocationNode0.wasInitialized) {
            return;
        }
        int v = ((int)(this.writeAllocationNode.startPosition - sampleDataQueue$AllocationNode0.startPosition)) / this.allocationLength + this.writeAllocationNode.wasInitialized;
        Allocation[] arr_allocation = new Allocation[v];
        for(int v1 = 0; v1 < v; ++v1) {
            arr_allocation[v1] = sampleDataQueue$AllocationNode0.allocation;
            sampleDataQueue$AllocationNode0 = sampleDataQueue$AllocationNode0.clear();
        }
        this.allocator.release(arr_allocation);
    }

    public void discardDownstreamTo(long v) {
        AllocationNode sampleDataQueue$AllocationNode0;
        if(v != -1L) {
            while(true) {
                sampleDataQueue$AllocationNode0 = this.firstAllocationNode;
                if(v < sampleDataQueue$AllocationNode0.endPosition) {
                    break;
                }
                this.allocator.release(sampleDataQueue$AllocationNode0.allocation);
                this.firstAllocationNode = this.firstAllocationNode.clear();
            }
            if(this.readAllocationNode.startPosition < sampleDataQueue$AllocationNode0.startPosition) {
                this.readAllocationNode = sampleDataQueue$AllocationNode0;
            }
        }
    }

    public void discardUpstreamSampleBytes(long v) {
        this.totalBytesWritten = v;
        if(v != 0L) {
            AllocationNode sampleDataQueue$AllocationNode0 = this.firstAllocationNode;
            if(v != sampleDataQueue$AllocationNode0.startPosition) {
                while(this.totalBytesWritten > sampleDataQueue$AllocationNode0.endPosition) {
                    sampleDataQueue$AllocationNode0 = sampleDataQueue$AllocationNode0.next;
                }
                AllocationNode sampleDataQueue$AllocationNode1 = sampleDataQueue$AllocationNode0.next;
                this.clearAllocationNodes(sampleDataQueue$AllocationNode1);
                AllocationNode sampleDataQueue$AllocationNode2 = new AllocationNode(sampleDataQueue$AllocationNode0.endPosition, this.allocationLength);
                sampleDataQueue$AllocationNode0.next = sampleDataQueue$AllocationNode2;
                if(this.totalBytesWritten == sampleDataQueue$AllocationNode0.endPosition) {
                    sampleDataQueue$AllocationNode0 = sampleDataQueue$AllocationNode2;
                }
                this.writeAllocationNode = sampleDataQueue$AllocationNode0;
                if(this.readAllocationNode == sampleDataQueue$AllocationNode1) {
                    this.readAllocationNode = sampleDataQueue$AllocationNode2;
                }
                return;
            }
        }
        this.clearAllocationNodes(this.firstAllocationNode);
        AllocationNode sampleDataQueue$AllocationNode3 = new AllocationNode(this.totalBytesWritten, this.allocationLength);
        this.firstAllocationNode = sampleDataQueue$AllocationNode3;
        this.readAllocationNode = sampleDataQueue$AllocationNode3;
        this.writeAllocationNode = sampleDataQueue$AllocationNode3;
    }

    public long getTotalBytesWritten() {
        return this.totalBytesWritten;
    }

    private void postAppend(int v) {
        long v1 = this.totalBytesWritten + ((long)v);
        this.totalBytesWritten = v1;
        AllocationNode sampleDataQueue$AllocationNode0 = this.writeAllocationNode;
        if(v1 == sampleDataQueue$AllocationNode0.endPosition) {
            this.writeAllocationNode = sampleDataQueue$AllocationNode0.next;
        }
    }

    private int preAppend(int v) {
        AllocationNode sampleDataQueue$AllocationNode0 = this.writeAllocationNode;
        if(!sampleDataQueue$AllocationNode0.wasInitialized) {
            sampleDataQueue$AllocationNode0.initialize(this.allocator.allocate(), new AllocationNode(this.writeAllocationNode.endPosition, this.allocationLength));
        }
        return Math.min(v, ((int)(this.writeAllocationNode.endPosition - this.totalBytesWritten)));
    }

    private void readData(long v, ByteBuffer byteBuffer0, int v1) {
        this.advanceReadTo(v);
        while(v1 > 0) {
            int v2 = Math.min(v1, ((int)(this.readAllocationNode.endPosition - v)));
            byteBuffer0.put(this.readAllocationNode.allocation.data, this.readAllocationNode.translateOffset(v), v2);
            v1 -= v2;
            v += (long)v2;
            AllocationNode sampleDataQueue$AllocationNode0 = this.readAllocationNode;
            if(v == sampleDataQueue$AllocationNode0.endPosition) {
                this.readAllocationNode = sampleDataQueue$AllocationNode0.next;
            }
        }
    }

    private void readData(long v, byte[] arr_b, int v1) {
        this.advanceReadTo(v);
        int v2 = v1;
        while(v2 > 0) {
            int v3 = Math.min(v2, ((int)(this.readAllocationNode.endPosition - v)));
            System.arraycopy(this.readAllocationNode.allocation.data, this.readAllocationNode.translateOffset(v), arr_b, v1 - v2, v3);
            v2 -= v3;
            v += (long)v3;
            AllocationNode sampleDataQueue$AllocationNode0 = this.readAllocationNode;
            if(v == sampleDataQueue$AllocationNode0.endPosition) {
                this.readAllocationNode = sampleDataQueue$AllocationNode0.next;
            }
        }
    }

    private void readEncryptionData(DecoderInputBuffer decoderInputBuffer0, SampleExtrasHolder sampleQueue$SampleExtrasHolder0) {
        long v = sampleQueue$SampleExtrasHolder0.offset;
        int v1 = 1;
        this.scratch.reset(1);
        this.readData(v, this.scratch.data, 1);
        int v3 = this.scratch.data[0];
        boolean z = (v3 & 0x80) != 0;
        CryptoInfo cryptoInfo0 = decoderInputBuffer0.cryptoInfo;
        byte[] arr_b = cryptoInfo0.iv;
        if(arr_b == null) {
            cryptoInfo0.iv = new byte[16];
        }
        else {
            Arrays.fill(arr_b, 0);
        }
        this.readData(v + 1L, cryptoInfo0.iv, v3 & 0x7F);
        long v4 = v + 1L + ((long)(v3 & 0x7F));
        if(z) {
            this.scratch.reset(2);
            this.readData(v4, this.scratch.data, 2);
            v4 += 2L;
            v1 = this.scratch.readUnsignedShort();
        }
        int[] arr_v = cryptoInfo0.numBytesOfClearData != null && cryptoInfo0.numBytesOfClearData.length >= v1 ? cryptoInfo0.numBytesOfClearData : new int[v1];
        int[] arr_v1 = cryptoInfo0.numBytesOfEncryptedData != null && cryptoInfo0.numBytesOfEncryptedData.length >= v1 ? cryptoInfo0.numBytesOfEncryptedData : new int[v1];
        if(z) {
            this.scratch.reset(v1 * 6);
            this.readData(v4, this.scratch.data, v1 * 6);
            v4 += (long)(v1 * 6);
            this.scratch.setPosition(0);
            for(int v2 = 0; v2 < v1; ++v2) {
                arr_v[v2] = this.scratch.readUnsignedShort();
                arr_v1[v2] = this.scratch.readUnsignedIntToInt();
            }
        }
        else {
            arr_v[0] = 0;
            arr_v1[0] = sampleQueue$SampleExtrasHolder0.size - ((int)(v4 - sampleQueue$SampleExtrasHolder0.offset));
        }
        cryptoInfo0.set(v1, arr_v, arr_v1, sampleQueue$SampleExtrasHolder0.cryptoData.encryptionKey, cryptoInfo0.iv, sampleQueue$SampleExtrasHolder0.cryptoData.cryptoMode, sampleQueue$SampleExtrasHolder0.cryptoData.encryptedBlocks, sampleQueue$SampleExtrasHolder0.cryptoData.clearBlocks);
        int v5 = (int)(v4 - sampleQueue$SampleExtrasHolder0.offset);
        sampleQueue$SampleExtrasHolder0.offset += (long)v5;
        sampleQueue$SampleExtrasHolder0.size -= v5;
    }

    public void readToBuffer(DecoderInputBuffer decoderInputBuffer0, SampleExtrasHolder sampleQueue$SampleExtrasHolder0) {
        if(decoderInputBuffer0.isEncrypted()) {
            this.readEncryptionData(decoderInputBuffer0, sampleQueue$SampleExtrasHolder0);
        }
        if(decoderInputBuffer0.hasSupplementalData()) {
            this.scratch.reset(4);
            this.readData(sampleQueue$SampleExtrasHolder0.offset, this.scratch.data, 4);
            int v = this.scratch.readUnsignedIntToInt();
            sampleQueue$SampleExtrasHolder0.offset += 4L;
            sampleQueue$SampleExtrasHolder0.size -= 4;
            decoderInputBuffer0.ensureSpaceForWrite(v);
            this.readData(sampleQueue$SampleExtrasHolder0.offset, decoderInputBuffer0.data, v);
            sampleQueue$SampleExtrasHolder0.offset += (long)v;
            int v1 = sampleQueue$SampleExtrasHolder0.size - v;
            sampleQueue$SampleExtrasHolder0.size = v1;
            decoderInputBuffer0.resetSupplementalData(v1);
            this.readData(sampleQueue$SampleExtrasHolder0.offset, decoderInputBuffer0.supplementalData, sampleQueue$SampleExtrasHolder0.size);
            return;
        }
        decoderInputBuffer0.ensureSpaceForWrite(sampleQueue$SampleExtrasHolder0.size);
        this.readData(sampleQueue$SampleExtrasHolder0.offset, decoderInputBuffer0.data, sampleQueue$SampleExtrasHolder0.size);
    }

    public void reset() {
        this.clearAllocationNodes(this.firstAllocationNode);
        AllocationNode sampleDataQueue$AllocationNode0 = new AllocationNode(0L, this.allocationLength);
        this.firstAllocationNode = sampleDataQueue$AllocationNode0;
        this.readAllocationNode = sampleDataQueue$AllocationNode0;
        this.writeAllocationNode = sampleDataQueue$AllocationNode0;
        this.totalBytesWritten = 0L;
        this.allocator.trim();
    }

    public void rewind() {
        this.readAllocationNode = this.firstAllocationNode;
    }

    public int sampleData(ExtractorInput extractorInput0, int v, boolean z) {
        int v1 = this.preAppend(v);
        int v2 = extractorInput0.read(this.writeAllocationNode.allocation.data, this.writeAllocationNode.translateOffset(this.totalBytesWritten), v1);
        if(v2 == -1) {
            if(!z) {
                throw new EOFException();
            }
            return -1;
        }
        this.postAppend(v2);
        return v2;
    }

    public void sampleData(ParsableByteArray parsableByteArray0, int v) {
        while(v > 0) {
            int v1 = this.preAppend(v);
            parsableByteArray0.readBytes(this.writeAllocationNode.allocation.data, this.writeAllocationNode.translateOffset(this.totalBytesWritten), v1);
            v -= v1;
            this.postAppend(v1);
        }
    }
}

