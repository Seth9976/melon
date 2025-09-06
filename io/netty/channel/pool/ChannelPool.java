package io.netty.channel.pool;

import io.netty.channel.Channel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import java.io.Closeable;

public interface ChannelPool extends Closeable {
    Future acquire();

    Future acquire(Promise arg1);

    @Override
    void close();

    Future release(Channel arg1);

    Future release(Channel arg1, Promise arg2);
}

