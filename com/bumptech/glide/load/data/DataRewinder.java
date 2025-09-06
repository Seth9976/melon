package com.bumptech.glide.load.data;

public interface DataRewinder {
    public interface Factory {
        DataRewinder build(Object arg1);

        Class getDataClass();
    }

    void cleanup();

    Object rewindAndGet();
}

