package com.bumptech.glide.load.engine.bitmap_recycle;

public final class ByteArrayAdapter implements ArrayAdapterInterface {
    private static final String TAG = "ByteArrayPool";

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public int getArrayLength(Object object0) {
        return this.getArrayLength(((byte[])object0));
    }

    public int getArrayLength(byte[] arr_b) {
        return arr_b.length;
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public int getElementSizeInBytes() {
        return 1;
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public String getTag() {
        return "ByteArrayPool";
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public Object newArray(int v) {
        return this.newArray(v);
    }

    public byte[] newArray(int v) {
        return new byte[v];
    }
}

