package io.netty.channel.nio;

import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;

final class SelectedSelectionKeySetSelector extends Selector {
    private final Selector delegate;
    private final SelectedSelectionKeySet selectionKeys;

    public SelectedSelectionKeySetSelector(Selector selector0, SelectedSelectionKeySet selectedSelectionKeySet0) {
        this.delegate = selector0;
        this.selectionKeys = selectedSelectionKeySet0;
    }

    @Override
    public void close() {
        this.delegate.close();
    }

    @Override
    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    @Override
    public Set keys() {
        return this.delegate.keys();
    }

    @Override
    public SelectorProvider provider() {
        return this.delegate.provider();
    }

    @Override
    public int select() {
        this.selectionKeys.reset();
        return this.delegate.select();
    }

    @Override
    public int select(long v) {
        this.selectionKeys.reset();
        return this.delegate.select(v);
    }

    @Override
    public int selectNow() {
        this.selectionKeys.reset();
        return this.delegate.selectNow();
    }

    @Override
    public Set selectedKeys() {
        return this.delegate.selectedKeys();
    }

    @Override
    public Selector wakeup() {
        return this.delegate.wakeup();
    }
}

