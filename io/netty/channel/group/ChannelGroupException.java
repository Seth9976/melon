package io.netty.channel.group;

import io.netty.channel.ChannelException;
import io.netty.util.internal.ObjectUtil;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class ChannelGroupException extends ChannelException implements Iterable {
    private final Collection failed;
    private static final long serialVersionUID = -4093064295562629453L;

    public ChannelGroupException(Collection collection0) {
        ObjectUtil.checkNonEmpty(collection0, "causes");
        this.failed = Collections.unmodifiableCollection(collection0);
    }

    @Override
    public Iterator iterator() {
        return this.failed.iterator();
    }
}

