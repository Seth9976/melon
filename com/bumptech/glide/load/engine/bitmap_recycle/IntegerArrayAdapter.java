package com.bumptech.glide.load.engine.bitmap_recycle;

public final class IntegerArrayAdapter implements ArrayAdapterInterface {
    private static final String TAG = "IntegerArrayPool";

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public int getArrayLength(Object object0) {
        return this.getArrayLength(((int[])object0));
    }

    public int getArrayLength(int[] arr_v) {
        return arr_v.length;
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public int getElementSizeInBytes() {
        return 4;
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public String getTag() {
        return "IntegerArrayPool";
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public Object newArray(int v) {
        return this.newArray(v);
    }

    public int[] newArray(int v) {
        return new int[v];
    }
}

