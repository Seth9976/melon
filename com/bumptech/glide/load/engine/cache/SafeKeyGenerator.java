package com.bumptech.glide.load.engine.cache;

import b2.d;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools.Factory;
import com.bumptech.glide.util.pool.FactoryPools.Poolable;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SafeKeyGenerator {
    static final class PoolableDigestContainer implements Poolable {
        final MessageDigest messageDigest;
        private final StateVerifier stateVerifier;

        public PoolableDigestContainer(MessageDigest messageDigest0) {
            this.stateVerifier = StateVerifier.newInstance();
            this.messageDigest = messageDigest0;
        }

        @Override  // com.bumptech.glide.util.pool.FactoryPools$Poolable
        public StateVerifier getVerifier() {
            return this.stateVerifier;
        }
    }

    private final d digestPool;
    private final LruCache loadIdToSafeHash;

    public SafeKeyGenerator() {
        this.loadIdToSafeHash = new LruCache(1000L);
        this.digestPool = FactoryPools.threadSafe(10, new Factory() {
            public PoolableDigestContainer create() {
                try {
                    return new PoolableDigestContainer(MessageDigest.getInstance("SHA-256"));
                }
                catch(NoSuchAlgorithmException noSuchAlgorithmException0) {
                    throw new RuntimeException(noSuchAlgorithmException0);
                }
            }

            @Override  // com.bumptech.glide.util.pool.FactoryPools$Factory
            public Object create() {
                return this.create();
            }
        });
    }

    private String calculateHexStringDigest(Key key0) {
        PoolableDigestContainer safeKeyGenerator$PoolableDigestContainer0 = (PoolableDigestContainer)Preconditions.checkNotNull(this.digestPool.acquire());
        try {
            key0.updateDiskCacheKey(safeKeyGenerator$PoolableDigestContainer0.messageDigest);
            return Util.sha256BytesToHex(safeKeyGenerator$PoolableDigestContainer0.messageDigest.digest());
        }
        finally {
            this.digestPool.release(safeKeyGenerator$PoolableDigestContainer0);
        }
    }

    public String getSafeKey(Key key0) {
        String s;
        synchronized(this.loadIdToSafeHash) {
            s = (String)this.loadIdToSafeHash.get(key0);
        }
        if(s == null) {
            s = this.calculateHexStringDigest(key0);
        }
        synchronized(this.loadIdToSafeHash) {
            this.loadIdToSafeHash.put(key0, s);
            return s;
        }
    }
}

