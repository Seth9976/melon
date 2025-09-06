package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.Preconditions;
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

        public WriteLock() {
            this.lock = new ReentrantLock();
        }
    }

    static class WriteLockPool {
        private static final int MAX_POOL_SIZE = 10;
        private final Queue pool;

        public WriteLockPool() {
            this.pool = new ArrayDeque();
        }

        public WriteLock obtain() {
            WriteLock diskCacheWriteLocker$WriteLock0;
            synchronized(this.pool) {
                diskCacheWriteLocker$WriteLock0 = (WriteLock)this.pool.poll();
            }
            return diskCacheWriteLocker$WriteLock0 == null ? new WriteLock() : diskCacheWriteLocker$WriteLock0;
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
        this.writeLockPool = new WriteLockPool();
    }

    public void acquire(String s) {
        WriteLock diskCacheWriteLocker$WriteLock0;
        synchronized(this) {
            diskCacheWriteLocker$WriteLock0 = (WriteLock)this.locks.get(s);
            if(diskCacheWriteLocker$WriteLock0 == null) {
                diskCacheWriteLocker$WriteLock0 = this.writeLockPool.obtain();
                this.locks.put(s, diskCacheWriteLocker$WriteLock0);
            }
            ++diskCacheWriteLocker$WriteLock0.interestedThreads;
        }
        diskCacheWriteLocker$WriteLock0.lock.lock();
    }

    public void release(String s) {
        WriteLock diskCacheWriteLocker$WriteLock0;
        synchronized(this) {
            diskCacheWriteLocker$WriteLock0 = (WriteLock)Preconditions.checkNotNull(this.locks.get(s));
            int v1 = diskCacheWriteLocker$WriteLock0.interestedThreads;
            if(v1 >= 1) {
                diskCacheWriteLocker$WriteLock0.interestedThreads = v1 - 1;
                if(v1 - 1 == 0) {
                    WriteLock diskCacheWriteLocker$WriteLock1 = (WriteLock)this.locks.remove(s);
                    if(!diskCacheWriteLocker$WriteLock1.equals(diskCacheWriteLocker$WriteLock0)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + diskCacheWriteLocker$WriteLock0 + ", but actually removed: " + diskCacheWriteLocker$WriteLock1 + ", safeKey: " + s);
                    }
                    this.writeLockPool.offer(diskCacheWriteLocker$WriteLock1);
                }
                diskCacheWriteLocker$WriteLock0.lock.unlock();
                return;
            }
        }
        throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + s + ", interestedThreads: " + diskCacheWriteLocker$WriteLock0.interestedThreads);
    }
}

