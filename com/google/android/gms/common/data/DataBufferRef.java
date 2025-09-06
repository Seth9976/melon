package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public abstract class DataBufferRef {
    @KeepForSdk
    protected final DataHolder mDataHolder;
    @KeepForSdk
    protected int mDataRow;
    private int zaa;

    @KeepForSdk
    public DataBufferRef(DataHolder dataHolder0, int v) {
        this.mDataHolder = (DataHolder)Preconditions.checkNotNull(dataHolder0);
        this.zaa(v);
    }

    @KeepForSdk
    public void copyToBuffer(String s, CharArrayBuffer charArrayBuffer0) {
        this.mDataHolder.zac(s, this.mDataRow, this.zaa, charArrayBuffer0);
    }

    // 去混淆评级： 低(30)
    @Override
    @KeepForSdk
    public boolean equals(Object object0) {
        return object0 instanceof DataBufferRef && Objects.equal(((DataBufferRef)object0).mDataRow, this.mDataRow) && Objects.equal(((DataBufferRef)object0).zaa, this.zaa) && ((DataBufferRef)object0).mDataHolder == this.mDataHolder;
    }

    @KeepForSdk
    public boolean getBoolean(String s) {
        return this.mDataHolder.getBoolean(s, this.mDataRow, this.zaa);
    }

    @KeepForSdk
    public byte[] getByteArray(String s) {
        return this.mDataHolder.getByteArray(s, this.mDataRow, this.zaa);
    }

    @KeepForSdk
    public int getDataRow() {
        return this.mDataRow;
    }

    @KeepForSdk
    public double getDouble(String s) {
        return this.mDataHolder.zaa(s, this.mDataRow, this.zaa);
    }

    @KeepForSdk
    public float getFloat(String s) {
        return this.mDataHolder.zab(s, this.mDataRow, this.zaa);
    }

    @KeepForSdk
    public int getInteger(String s) {
        return this.mDataHolder.getInteger(s, this.mDataRow, this.zaa);
    }

    @KeepForSdk
    public long getLong(String s) {
        return this.mDataHolder.getLong(s, this.mDataRow, this.zaa);
    }

    @KeepForSdk
    public String getString(String s) {
        return this.mDataHolder.getString(s, this.mDataRow, this.zaa);
    }

    @KeepForSdk
    public boolean hasColumn(String s) {
        return this.mDataHolder.hasColumn(s);
    }

    @KeepForSdk
    public boolean hasNull(String s) {
        return this.mDataHolder.hasNull(s, this.mDataRow, this.zaa);
    }

    @Override
    @KeepForSdk
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.mDataRow, this.zaa, this.mDataHolder});
    }

    @KeepForSdk
    public boolean isDataValid() {
        return !this.mDataHolder.isClosed();
    }

    @KeepForSdk
    public Uri parseUri(String s) {
        String s1 = this.mDataHolder.getString(s, this.mDataRow, this.zaa);
        return s1 == null ? null : Uri.parse(s1);
    }

    public final void zaa(int v) {
        Preconditions.checkState(v >= 0 && v < this.mDataHolder.getCount());
        this.mDataRow = v;
        this.zaa = this.mDataHolder.getWindowIndex(v);
    }
}

