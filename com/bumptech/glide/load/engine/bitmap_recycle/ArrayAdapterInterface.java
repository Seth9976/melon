package com.bumptech.glide.load.engine.bitmap_recycle;

interface ArrayAdapterInterface {
    int getArrayLength(Object arg1);

    int getElementSizeInBytes();

    String getTag();

    Object newArray(int arg1);
}

