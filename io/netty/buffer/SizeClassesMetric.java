package io.netty.buffer;

public interface SizeClassesMetric {
    int normalizeSize(int arg1);

    long pageIdx2size(int arg1);

    long pageIdx2sizeCompute(int arg1);

    int pages2pageIdx(int arg1);

    int pages2pageIdxFloor(int arg1);

    int size2SizeIdx(int arg1);

    int sizeIdx2size(int arg1);

    int sizeIdx2sizeCompute(int arg1);
}

