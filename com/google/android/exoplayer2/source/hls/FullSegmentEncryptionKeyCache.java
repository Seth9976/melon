package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class FullSegmentEncryptionKeyCache {
    private final LinkedHashMap backingMap;

    public FullSegmentEncryptionKeyCache(int v) {
        this.backingMap = new LinkedHashMap(v + 1, 1.0f, false) {
            @Override
            public boolean removeEldestEntry(Map.Entry map$Entry0) {
                return this.size() > v;
            }
        };
    }

    public boolean containsUri(Uri uri0) {
        Object object0 = Assertions.checkNotNull(uri0);
        return this.backingMap.containsKey(object0);
    }

    public byte[] get(Uri uri0) {
        return uri0 == null ? null : ((byte[])this.backingMap.get(uri0));
    }

    public byte[] put(Uri uri0, byte[] arr_b) {
        Uri uri1 = (Uri)Assertions.checkNotNull(uri0);
        byte[] arr_b1 = (byte[])Assertions.checkNotNull(arr_b);
        return (byte[])this.backingMap.put(uri1, arr_b1);
    }

    public byte[] remove(Uri uri0) {
        Object object0 = Assertions.checkNotNull(uri0);
        return (byte[])this.backingMap.remove(object0);
    }
}

