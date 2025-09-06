package io.netty.util;

public interface ReferenceCounted {
    int refCnt();

    boolean release();

    boolean release(int arg1);

    ReferenceCounted retain();

    ReferenceCounted retain(int arg1);

    ReferenceCounted touch();

    ReferenceCounted touch(Object arg1);
}

