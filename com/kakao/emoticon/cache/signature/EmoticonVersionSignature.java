package com.kakao.emoticon.cache.signature;

import com.kakao.emoticon.cache.Key;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Objects;

public class EmoticonVersionSignature implements Key {
    private final String emotKey;
    private final int version;

    public EmoticonVersionSignature(String s, int v) {
        this.emotKey = s;
        this.version = v;
    }

    @Override  // com.kakao.emoticon.cache.Key
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 != null && this.getClass() == object0.getClass() && Objects.equals(this.emotKey, ((EmoticonVersionSignature)object0).emotKey) ? this.version == ((EmoticonVersionSignature)object0).version : false;
    }

    @Override  // com.kakao.emoticon.cache.Key
    public int hashCode() {
        return this.emotKey == null ? this.version : this.emotKey.hashCode() * 0x1F + this.version;
    }

    @Override  // com.kakao.emoticon.cache.Key
    public void updateDiskCacheKey(MessageDigest messageDigest0) {
        messageDigest0.update(ByteBuffer.allocate(4).putInt(this.version).array());
        messageDigest0.update(this.emotKey.getBytes("UTF-8"));
    }
}

