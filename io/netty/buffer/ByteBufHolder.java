package io.netty.buffer;

import io.netty.util.ReferenceCounted;

public interface ByteBufHolder extends ReferenceCounted {
    ByteBuf content();

    ByteBufHolder copy();

    ByteBufHolder duplicate();

    ByteBufHolder replace(ByteBuf arg1);

    ByteBufHolder retain();

    ByteBufHolder retain(int arg1);

    ByteBufHolder retainedDuplicate();

    ByteBufHolder touch();

    ByteBufHolder touch(Object arg1);
}

