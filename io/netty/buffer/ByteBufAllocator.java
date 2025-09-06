package io.netty.buffer;

public interface ByteBufAllocator {
    public static final ByteBufAllocator DEFAULT;

    static {
        ByteBufAllocator.DEFAULT = ByteBufUtil.DEFAULT_ALLOCATOR;
    }

    ByteBuf buffer();

    ByteBuf buffer(int arg1);

    ByteBuf buffer(int arg1, int arg2);

    int calculateNewCapacity(int arg1, int arg2);

    CompositeByteBuf compositeBuffer();

    CompositeByteBuf compositeBuffer(int arg1);

    CompositeByteBuf compositeDirectBuffer();

    CompositeByteBuf compositeDirectBuffer(int arg1);

    CompositeByteBuf compositeHeapBuffer();

    CompositeByteBuf compositeHeapBuffer(int arg1);

    ByteBuf directBuffer();

    ByteBuf directBuffer(int arg1);

    ByteBuf directBuffer(int arg1, int arg2);

    ByteBuf heapBuffer();

    ByteBuf heapBuffer(int arg1);

    ByteBuf heapBuffer(int arg1, int arg2);

    ByteBuf ioBuffer();

    ByteBuf ioBuffer(int arg1);

    ByteBuf ioBuffer(int arg1, int arg2);

    boolean isDirectBufferPooled();
}

