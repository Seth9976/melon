package io.netty.resolver;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import java.io.Closeable;

public interface NameResolver extends Closeable {
    @Override
    void close();

    Future resolve(String arg1);

    Future resolve(String arg1, Promise arg2);

    Future resolveAll(String arg1);

    Future resolveAll(String arg1, Promise arg2);
}

