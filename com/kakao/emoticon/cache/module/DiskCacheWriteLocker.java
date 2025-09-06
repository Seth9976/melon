package com.kakao.emoticon.cache.module;

import com.kakao.emoticon.cache.Key;
import com.kakao.emoticon.cache.util.Preconditions;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class DiskCacheWriteLocker {
    static class WriteLock {
        int interestedThreads;
        final Lock lock;

        private WriteLock() {
            this.lock = new ReentrantLock();
        }

        public WriteLock(com.kakao.emoticon.cache.module.DiskCacheWriteLocker.1 diskCacheWriteLocker$10) {
        }
    }

    static class WriteLockPool {
        private static final int MAX_POOL_SIZE = 10;
        private final Queue pool;

        private WriteLockPool() {
            this.pool = new ArrayDeque();
        }

        public WriteLockPool(com.kakao.emoticon.cache.module.DiskCacheWriteLocker.1 diskCacheWriteLocker$10) {
        }

        public WriteLock obtain() {
            WriteLock diskCacheWriteLocker$WriteLock0;
            synchronized(this.pool) {
                diskCacheWriteLocker$WriteLock0 = (WriteLock)this.pool.poll();
            }
            return diskCacheWriteLocker$WriteLock0 == null ? new WriteLock(null) : diskCacheWriteLocker$WriteLock0;
        }

        public void offer(WriteLock diskCacheWriteLocker$WriteLock0) {
            synchronized(this.pool) {
                if(this.pool.size() < 10) {
                    this.pool.offer(diskCacheWriteLocker$WriteLock0);
                }
            }
        }
    }

    private final Map locks;
    private final WriteLockPool writeLockPool;

    public DiskCacheWriteLocker() {
        this.locks = new HashMap();
        this.writeLockPool = new WriteLockPool(null);
    }

    public void acquire(Key key0) {
        WriteLock diskCacheWriteLocker$WriteLock0;
        synchronized(this) {
            diskCacheWriteLocker$WriteLock0 = (WriteLock)this.locks.get(key0);
            if(diskCacheWriteLocker$WriteLock0 == null) {
                diskCacheWriteLocker$WriteLock0 = this.writeLockPool.obtain();
                this.locks.put(key0, diskCacheWriteLocker$WriteLock0);
            }
            ++diskCacheWriteLocker$WriteLock0.interestedThreads;
        }
        diskCacheWriteLocker$WriteLock0.lock.lock();
    }

    public void release(Key key0) {
        WriteLock diskCacheWriteLocker$WriteLock0;
        synchronized(this) {
            diskCacheWriteLocker$WriteLock0 = (WriteLock)Preconditions.checkNotNull(this.locks.get(key0));
            int v1 = diskCacheWriteLocker$WriteLock0.interestedThreads;
            if(v1 >= 1) {
                diskCacheWriteLocker$WriteLock0.interestedThreads = v1 - 1;
                if(v1 - 1 == 0) {
                    WriteLock diskCacheWriteLocker$WriteLock1 = (WriteLock)this.locks.remove(key0);
                    if(!diskCacheWriteLocker$WriteLock1.equals(diskCacheWriteLocker$WriteLock0)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + diskCacheWriteLocker$WriteLock0 + ", but actually removed: " + diskCacheWriteLocker$WriteLock1 + ", key: " + key0);
                    }
                    this.writeLockPool.offer(diskCacheWriteLocker$WriteLock1);
                }
                diskCacheWriteLocker$WriteLock0.lock.unlock();
                return;
            }
        }
        throw new IllegalStateException("Cannot release a lock that is not held, key: " + key0 + ", interestedThreads: " + diskCacheWriteLocker$WriteLock0.interestedThreads);
    }

    class com.kakao.emoticon.cache.module.DiskCacheWriteLocker.1 {
    }

}

