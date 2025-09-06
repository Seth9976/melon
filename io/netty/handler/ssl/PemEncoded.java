package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

interface PemEncoded extends ByteBufHolder {
    PemEncoded copy();

    PemEncoded duplicate();

    boolean isSensitive();

    PemEncoded replace(ByteBuf arg1);

    PemEncoded retain();

    PemEncoded retain(int arg1);

    PemEncoded retainedDuplicate();

    PemEncoded touch();

    PemEncoded touch(Object arg1);
}

