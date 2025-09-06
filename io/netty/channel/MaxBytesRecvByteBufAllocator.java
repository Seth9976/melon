package io.netty.channel;

import java.util.Map.Entry;

public interface MaxBytesRecvByteBufAllocator extends RecvByteBufAllocator {
    int maxBytesPerIndividualRead();

    MaxBytesRecvByteBufAllocator maxBytesPerIndividualRead(int arg1);

    int maxBytesPerRead();

    MaxBytesRecvByteBufAllocator maxBytesPerRead(int arg1);

    MaxBytesRecvByteBufAllocator maxBytesPerReadPair(int arg1, int arg2);

    Map.Entry maxBytesPerReadPair();
}

