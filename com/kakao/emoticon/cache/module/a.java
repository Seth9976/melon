package com.kakao.emoticon.cache.module;

import com.kakao.emoticon.cache.Key;
import java.security.MessageDigest;

public final class a implements Key {
    public final String a;

    public a(String s) {
        this.a = s;
    }

    @Override  // com.kakao.emoticon.cache.Key
    public final void updateDiskCacheKey(MessageDigest messageDigest0) {
        EmoticonDiskCacheFactory.lambda$build$0(this.a, messageDigest0);
    }
}

