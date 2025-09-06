package com.kakao.emoticon.cache.module;

import com.kakao.emoticon.cache.Key;
import com.kakao.emoticon.cache.util.Util;
import com.kakao.emoticon.util.LruCache;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SafeKeyGenerator {
    private final LruCache loadIdToSafeHash;

    public SafeKeyGenerator() {
        this.loadIdToSafeHash = new LruCache(1000);
    }

    private static String calculateHexStringDigest(Key key0) {
        try {
            MessageDigest messageDigest0 = MessageDigest.getInstance("SHA-256");
            key0.updateDiskCacheKey(messageDigest0);
            return Util.sha256BytesToHex(messageDigest0.digest());
        }
        catch(UnsupportedEncodingException | NoSuchAlgorithmException exception0) {
            throw new RuntimeException(exception0);
        }
    }

    public String getSafeKey(Key key0) {
        String s;
        synchronized(this.loadIdToSafeHash) {
            s = (String)this.loadIdToSafeHash.get(key0);
        }
        if(s == null) {
            s = SafeKeyGenerator.calculateHexStringDigest(key0);
        }
        synchronized(this.loadIdToSafeHash) {
            this.loadIdToSafeHash.put(key0, s);
            return s;
        }
    }
}

