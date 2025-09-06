package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class MediaStoreSignature implements Key {
    private final long dateModified;
    private final String mimeType;
    private final int orientation;

    public MediaStoreSignature(String s, long v, int v1) {
        if(s == null) {
            s = "";
        }
        this.mimeType = s;
        this.dateModified = v;
        this.orientation = v1;
    }

    @Override  // com.bumptech.glide.load.Key
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 == null || this.getClass() != object0.getClass() || this.dateModified != ((MediaStoreSignature)object0).dateModified) {
            return false;
        }
        return this.orientation == ((MediaStoreSignature)object0).orientation ? this.mimeType.equals(((MediaStoreSignature)object0).mimeType) : false;
    }

    @Override  // com.bumptech.glide.load.Key
    public int hashCode() {
        return (this.mimeType.hashCode() * 0x1F + ((int)(this.dateModified ^ this.dateModified >>> 0x20))) * 0x1F + this.orientation;
    }

    @Override  // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest0) {
        messageDigest0.update(ByteBuffer.allocate(12).putLong(this.dateModified).putInt(this.orientation).array());
        messageDigest0.update(this.mimeType.getBytes(Key.CHARSET));
    }
}

