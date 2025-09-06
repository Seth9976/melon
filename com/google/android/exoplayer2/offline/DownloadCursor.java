package com.google.android.exoplayer2.offline;

import java.io.Closeable;

public interface DownloadCursor extends Closeable {
    @Override
    void close();

    int getCount();

    Download getDownload();

    int getPosition();

    default boolean isAfterLast() {
        return this.getCount() == 0 ? true : this.getPosition() == this.getCount();
    }

    default boolean isBeforeFirst() {
        return this.getCount() == 0 ? true : this.getPosition() == -1;
    }

    boolean isClosed();

    default boolean isFirst() {
        return this.getPosition() == 0 && this.getCount() != 0;
    }

    default boolean isLast() {
        int v = this.getCount();
        return this.getPosition() == v - 1 && v != 0;
    }

    default boolean moveToFirst() {
        return this.moveToPosition(0);
    }

    default boolean moveToLast() {
        return this.moveToPosition(this.getCount() - 1);
    }

    default boolean moveToNext() {
        return this.moveToPosition(this.getPosition() + 1);
    }

    boolean moveToPosition(int arg1);

    default boolean moveToPrevious() {
        return this.moveToPosition(this.getPosition() - 1);
    }
}

