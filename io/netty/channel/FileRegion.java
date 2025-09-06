package io.netty.channel;

import io.netty.util.ReferenceCounted;
import java.nio.channels.WritableByteChannel;

public interface FileRegion extends ReferenceCounted {
    long count();

    long position();

    FileRegion retain();

    FileRegion retain(int arg1);

    FileRegion touch();

    FileRegion touch(Object arg1);

    long transferTo(WritableByteChannel arg1, long arg2);

    @Deprecated
    long transfered();

    long transferred();
}

