package com.google.android.exoplayer2.upstream.cache;

import android.os.ConditionVariable;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import jeb.synthetic.FIN;

public final class SimpleCache implements Cache {
    private static final int SUBDIRECTORY_COUNT = 10;
    private static final String TAG = "SimpleCache";
    private static final String UID_FILE_SUFFIX = ".uid";
    private final File cacheDir;
    private final CachedContentIndex contentIndex;
    private final CacheEvictor evictor;
    private final CacheFileMetadataIndex fileIndex;
    private CacheException initializationException;
    private final HashMap listeners;
    private static final HashSet lockedCacheDirs;
    private final Random random;
    private boolean released;
    private long totalSpace;
    private final boolean touchCacheSpans;
    private long uid;

    static {
        SimpleCache.lockedCacheDirs = new HashSet();
    }

    @Deprecated
    public SimpleCache(File file0, CacheEvictor cacheEvictor0) {
        this(file0, cacheEvictor0, null, false);
    }

    public SimpleCache(File file0, CacheEvictor cacheEvictor0, DatabaseProvider databaseProvider0) {
        this(file0, cacheEvictor0, databaseProvider0, null, false, false);
    }

    public SimpleCache(File file0, CacheEvictor cacheEvictor0, DatabaseProvider databaseProvider0, byte[] arr_b, boolean z, boolean z1) {
        this(file0, cacheEvictor0, new CachedContentIndex(databaseProvider0, file0, arr_b, z, z1), (databaseProvider0 == null || z1 ? null : new CacheFileMetadataIndex(databaseProvider0)));
    }

    public SimpleCache(File file0, CacheEvictor cacheEvictor0, CachedContentIndex cachedContentIndex0, CacheFileMetadataIndex cacheFileMetadataIndex0) {
        if(!SimpleCache.lockFolder(file0)) {
            throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file0);
        }
        this.cacheDir = file0;
        this.evictor = cacheEvictor0;
        this.contentIndex = cachedContentIndex0;
        this.fileIndex = cacheFileMetadataIndex0;
        this.listeners = new HashMap();
        this.random = new Random();
        this.touchCacheSpans = cacheEvictor0.requiresCacheSpanTouches();
        this.uid = -1L;
        ConditionVariable conditionVariable0 = new ConditionVariable();
        new Thread("SimpleCache.initialize()") {
            @Override
            public void run() {
                synchronized(SimpleCache.this) {
                    conditionVariable0.open();
                    SimpleCache.access$000(SimpleCache.this);
                    SimpleCache.access$100(SimpleCache.this).onCacheInitialized();
                }
            }
        }.start();
        conditionVariable0.block();
    }

    @Deprecated
    public SimpleCache(File file0, CacheEvictor cacheEvictor0, byte[] arr_b) {
        this(file0, cacheEvictor0, arr_b, arr_b != null);
    }

    @Deprecated
    public SimpleCache(File file0, CacheEvictor cacheEvictor0, byte[] arr_b, boolean z) {
        this(file0, cacheEvictor0, null, arr_b, z, true);
    }

    public static void access$000(SimpleCache simpleCache0) {
        simpleCache0.initialize();
    }

    public static CacheEvictor access$100(SimpleCache simpleCache0) {
        return simpleCache0.evictor;
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache
    public NavigableSet addListener(String s, Listener cache$Listener0) {
        synchronized(this) {
            Assertions.checkState(!this.released);
            ArrayList arrayList0 = (ArrayList)this.listeners.get(s);
            if(arrayList0 == null) {
                arrayList0 = new ArrayList();
                this.listeners.put(s, arrayList0);
            }
            arrayList0.add(cache$Listener0);
            return this.getCachedSpans(s);
        }
    }

    private void addSpan(SimpleCacheSpan simpleCacheSpan0) {
        this.contentIndex.getOrAdd(simpleCacheSpan0.key).addSpan(simpleCacheSpan0);
        this.totalSpace += simpleCacheSpan0.length;
        this.notifySpanAdded(simpleCacheSpan0);
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache
    public void applyContentMetadataMutations(String s, ContentMetadataMutations contentMetadataMutations0) {
        synchronized(this) {
            Assertions.checkState(!this.released);
            this.checkInitialization();
            this.contentIndex.applyContentMetadataMutations(s, contentMetadataMutations0);
            try {
                this.contentIndex.store();
            }
            catch(IOException iOException0) {
                throw new CacheException(iOException0);
            }
        }
    }

    public void checkInitialization() {
        CacheException cache$CacheException0;
        synchronized(this) {
            cache$CacheException0 = this.initializationException;
            if(cache$CacheException0 == null) {
                return;
            }
        }
        throw cache$CacheException0;
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache
    public void commitFile(File file0, long v) {
        synchronized(this) {
            boolean z = true;
            Assertions.checkState(!this.released);
            if(file0.exists()) {
                if(v != 0L) {
                    SimpleCacheSpan simpleCacheSpan0 = (SimpleCacheSpan)Assertions.checkNotNull(SimpleCacheSpan.createCacheEntry(file0, v, this.contentIndex));
                    CachedContent cachedContent0 = (CachedContent)Assertions.checkNotNull(this.contentIndex.get(simpleCacheSpan0.key));
                    Assertions.checkState(cachedContent0.isLocked());
                    long v1 = ContentMetadata.getContentLength(cachedContent0.getMetadata());
                    if(v1 != -1L) {
                        if(simpleCacheSpan0.position + simpleCacheSpan0.length > v1) {
                            z = false;
                        }
                        Assertions.checkState(z);
                    }
                    if(this.fileIndex != null) {
                        String s = file0.getName();
                        try {
                            this.fileIndex.set(s, simpleCacheSpan0.length, simpleCacheSpan0.lastTouchTimestamp);
                        }
                        catch(IOException iOException0) {
                            throw new CacheException(iOException0);
                        }
                    }
                    this.addSpan(simpleCacheSpan0);
                    try {
                        this.contentIndex.store();
                    }
                    catch(IOException iOException1) {
                        throw new CacheException(iOException1);
                    }
                    this.notifyAll();
                    return;
                }
                file0.delete();
            }
        }
    }

    private static long createUid(File file0) {
        long v = new SecureRandom().nextLong();
        long v1 = v == 0x8000000000000000L ? 0L : Math.abs(v);
        File file1 = new File(file0, Long.toString(v1, 16) + ".uid");
        if(!file1.createNewFile()) {
            throw new IOException("Failed to create UID file: " + file1);
        }
        return v1;
    }

    public static void delete(File file0, DatabaseProvider databaseProvider0) {
        if(!file0.exists()) {
            return;
        }
        File[] arr_file = file0.listFiles();
        if(arr_file == null) {
            file0.delete();
            return;
        }
        if(databaseProvider0 != null) {
            long v = SimpleCache.loadUid(arr_file);
            if(v != -1L) {
                try {
                    CacheFileMetadataIndex.delete(databaseProvider0, v);
                }
                catch(DatabaseIOException unused_ex) {
                    Log.w("SimpleCache", "Failed to delete file metadata: " + v);
                }
                try {
                    CachedContentIndex.delete(databaseProvider0, v);
                }
                catch(DatabaseIOException unused_ex) {
                    Log.w("SimpleCache", "Failed to delete file metadata: " + v);
                }
            }
        }
        Util.recursiveDelete(file0);
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache
    public long getCacheSpace() {
        synchronized(this) {
            Assertions.checkState(!this.released);
            return this.totalSpace;
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache
    public long getCachedLength(String s, long v, long v1) {
        synchronized(this) {
            Assertions.checkState(!this.released);
            CachedContent cachedContent0 = this.contentIndex.get(s);
            return cachedContent0 == null ? -v1 : cachedContent0.getCachedBytesLength(v, v1);
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache
    public NavigableSet getCachedSpans(String s) {
        synchronized(this) {
            Assertions.checkState(!this.released);
            CachedContent cachedContent0 = this.contentIndex.get(s);
            return cachedContent0 == null || cachedContent0.isEmpty() ? new TreeSet() : new TreeSet(cachedContent0.getSpans());
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache
    public ContentMetadata getContentMetadata(String s) {
        synchronized(this) {
            Assertions.checkState(!this.released);
            return this.contentIndex.getContentMetadata(s);
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache
    public Set getKeys() {
        synchronized(this) {
            Assertions.checkState(!this.released);
            return new HashSet(this.contentIndex.getKeys());
        }
    }

    private SimpleCacheSpan getSpan(String s, long v) {
        SimpleCacheSpan simpleCacheSpan0;
        CachedContent cachedContent0 = this.contentIndex.get(s);
        if(cachedContent0 == null) {
            return SimpleCacheSpan.createOpenHole(s, v);
        }
        while(true) {
            simpleCacheSpan0 = cachedContent0.getSpan(v);
            if(!simpleCacheSpan0.isCached || simpleCacheSpan0.file.length() == simpleCacheSpan0.length) {
                break;
            }
            this.removeStaleSpans();
        }
        return simpleCacheSpan0;
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache
    public long getUid() {
        synchronized(this) {
        }
        return this.uid;
    }

    private void initialize() {
        if(!this.cacheDir.exists() && !this.cacheDir.mkdirs()) {
            String s = String.valueOf(this.cacheDir);
            Log.e("SimpleCache", "Failed to create cache directory: " + s);
            this.initializationException = new CacheException("Failed to create cache directory: " + s);
            return;
        }
        File[] arr_file = this.cacheDir.listFiles();
        if(arr_file == null) {
            String s1 = String.valueOf(this.cacheDir);
            Log.e("SimpleCache", "Failed to list cache directory files: " + s1);
            this.initializationException = new CacheException("Failed to list cache directory files: " + s1);
            return;
        }
        long v = SimpleCache.loadUid(arr_file);
        this.uid = v;
        if(v == -1L) {
            try {
                this.uid = SimpleCache.createUid(this.cacheDir);
            }
            catch(IOException iOException0) {
                String s2 = String.valueOf(this.cacheDir);
                Log.e("SimpleCache", "Failed to create cache UID: " + s2, iOException0);
                this.initializationException = new CacheException("Failed to create cache UID: " + s2, iOException0);
                return;
            }
        }
        try {
            this.contentIndex.initialize(this.uid);
            CacheFileMetadataIndex cacheFileMetadataIndex0 = this.fileIndex;
            if(cacheFileMetadataIndex0 == null) {
                this.loadDirectory(this.cacheDir, true, arr_file, null);
            }
            else {
                cacheFileMetadataIndex0.initialize(this.uid);
                Map map0 = this.fileIndex.getAll();
                this.loadDirectory(this.cacheDir, true, arr_file, map0);
                Set set0 = map0.keySet();
                this.fileIndex.removeAll(set0);
            }
        }
        catch(IOException iOException1) {
            String s3 = String.valueOf(this.cacheDir);
            Log.e("SimpleCache", "Failed to initialize cache indices: " + s3, iOException1);
            this.initializationException = new CacheException("Failed to initialize cache indices: " + s3, iOException1);
            return;
        }
        this.contentIndex.removeEmpty();
        try {
            this.contentIndex.store();
        }
        catch(IOException iOException2) {
            Log.e("SimpleCache", "Storing index file failed", iOException2);
        }
    }

    public static boolean isCacheFolderLocked(File file0) {
        synchronized(SimpleCache.class) {
            File file1 = file0.getAbsoluteFile();
            return SimpleCache.lockedCacheDirs.contains(file1);
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache
    public boolean isCached(String s, long v, long v1) {
        synchronized(this) {
            boolean z = true;
            Assertions.checkState(!this.released);
            CachedContent cachedContent0 = this.contentIndex.get(s);
            if(cachedContent0 == null || cachedContent0.getCachedBytesLength(v, v1) < v1) {
                z = false;
            }
            return z;
        }
    }

    private void loadDirectory(File file0, boolean z, File[] arr_file, Map map0) {
        long v2;
        long v1;
        if(arr_file != null && arr_file.length != 0) {
            for(int v = 0; v < arr_file.length; ++v) {
                File file1 = arr_file[v];
                String s = file1.getName();
                if(z && s.indexOf(46) == -1) {
                    this.loadDirectory(file1, false, file1.listFiles(), map0);
                }
                else if(!z || !CachedContentIndex.isIndexFile(s) && !s.endsWith(".uid")) {
                    CacheFileMetadata cacheFileMetadata0 = map0 == null ? null : ((CacheFileMetadata)map0.remove(s));
                    if(cacheFileMetadata0 == null) {
                        v1 = -1L;
                        v2 = 0x8000000000000001L;
                    }
                    else {
                        v1 = cacheFileMetadata0.length;
                        v2 = cacheFileMetadata0.lastTouchTimestamp;
                    }
                    SimpleCacheSpan simpleCacheSpan0 = SimpleCacheSpan.createCacheEntry(file1, v1, v2, this.contentIndex);
                    if(simpleCacheSpan0 == null) {
                        file1.delete();
                    }
                    else {
                        this.addSpan(simpleCacheSpan0);
                    }
                }
            }
            return;
        }
        if(!z) {
            file0.delete();
        }
    }

    private static long loadUid(File[] arr_file) {
        for(int v = 0; v < arr_file.length; ++v) {
            File file0 = arr_file[v];
            String s = file0.getName();
            if(s.endsWith(".uid")) {
                try {
                    return SimpleCache.parseUid(s);
                }
                catch(NumberFormatException unused_ex) {
                    Log.e("SimpleCache", "Malformed UID file: " + file0);
                    file0.delete();
                }
            }
        }
        return -1L;
    }

    private static boolean lockFolder(File file0) {
        synchronized(SimpleCache.class) {
            File file1 = file0.getAbsoluteFile();
            return SimpleCache.lockedCacheDirs.add(file1);
        }
    }

    private void notifySpanAdded(SimpleCacheSpan simpleCacheSpan0) {
        ArrayList arrayList0 = (ArrayList)this.listeners.get(simpleCacheSpan0.key);
        if(arrayList0 != null) {
            for(int v = arrayList0.size() - 1; v >= 0; --v) {
                ((Listener)arrayList0.get(v)).onSpanAdded(this, simpleCacheSpan0);
            }
        }
        this.evictor.onSpanAdded(this, simpleCacheSpan0);
    }

    private void notifySpanRemoved(CacheSpan cacheSpan0) {
        ArrayList arrayList0 = (ArrayList)this.listeners.get(cacheSpan0.key);
        if(arrayList0 != null) {
            for(int v = arrayList0.size() - 1; v >= 0; --v) {
                ((Listener)arrayList0.get(v)).onSpanRemoved(this, cacheSpan0);
            }
        }
        this.evictor.onSpanRemoved(this, cacheSpan0);
    }

    private void notifySpanTouched(SimpleCacheSpan simpleCacheSpan0, CacheSpan cacheSpan0) {
        ArrayList arrayList0 = (ArrayList)this.listeners.get(simpleCacheSpan0.key);
        if(arrayList0 != null) {
            for(int v = arrayList0.size() - 1; v >= 0; --v) {
                ((Listener)arrayList0.get(v)).onSpanTouched(this, simpleCacheSpan0, cacheSpan0);
            }
        }
        this.evictor.onSpanTouched(this, simpleCacheSpan0, cacheSpan0);
    }

    private static long parseUid(String s) {
        return Long.parseLong(s.substring(0, s.indexOf(46)), 16);
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache
    public void release() {
        __monitor_enter(this);
        int v = FIN.finallyOpen$NT();
        if(this.released) {
            FIN.finallyCodeBegin$NT(v);
            __monitor_exit(this);
            FIN.finallyCodeEnd$NT(v);
            return;
        }
        this.listeners.clear();
        this.removeStaleSpans();
        try {
            this.contentIndex.store();
        }
        catch(IOException iOException0) {
            Log.e("SimpleCache", "Storing index file failed", iOException0);
        }
        finally {
            SimpleCache.unlockFolder(this.cacheDir);
            this.released = true;
            FIN.finallyExec$NT(v);
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache
    public void releaseHoleSpan(CacheSpan cacheSpan0) {
        synchronized(this) {
            Assertions.checkState(!this.released);
            CachedContent cachedContent0 = this.contentIndex.get(cacheSpan0.key);
            Assertions.checkNotNull(cachedContent0);
            Assertions.checkState(cachedContent0.isLocked());
            cachedContent0.setLocked(false);
            this.contentIndex.maybeRemove(cachedContent0.key);
            this.notifyAll();
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache
    public void removeListener(String s, Listener cache$Listener0) {
        synchronized(this) {
            if(this.released) {
                return;
            }
            ArrayList arrayList0 = (ArrayList)this.listeners.get(s);
            if(arrayList0 != null) {
                arrayList0.remove(cache$Listener0);
                if(arrayList0.isEmpty()) {
                    this.listeners.remove(s);
                }
            }
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache
    public void removeSpan(CacheSpan cacheSpan0) {
        synchronized(this) {
            Assertions.checkState(!this.released);
            this.removeSpanInternal(cacheSpan0);
        }
    }

    private void removeSpanInternal(CacheSpan cacheSpan0) {
        CachedContent cachedContent0 = this.contentIndex.get(cacheSpan0.key);
        if(cachedContent0 != null && cachedContent0.removeSpan(cacheSpan0)) {
            this.totalSpace -= cacheSpan0.length;
            if(this.fileIndex != null) {
                String s = cacheSpan0.file.getName();
                try {
                    this.fileIndex.remove(s);
                }
                catch(IOException unused_ex) {
                    String s1 = String.valueOf(s);
                    Log.w("SimpleCache", (s1.length() == 0 ? new String("Failed to remove file index entry for: ") : "Failed to remove file index entry for: " + s1));
                }
            }
            this.contentIndex.maybeRemove(cachedContent0.key);
            this.notifySpanRemoved(cacheSpan0);
        }
    }

    private void removeStaleSpans() {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: this.contentIndex.getAll()) {
            for(Object object1: ((CachedContent)object0).getSpans()) {
                CacheSpan cacheSpan0 = (CacheSpan)object1;
                if(cacheSpan0.file.length() != cacheSpan0.length) {
                    arrayList0.add(cacheSpan0);
                }
            }
        }
        for(int v = 0; v < arrayList0.size(); ++v) {
            this.removeSpanInternal(((CacheSpan)arrayList0.get(v)));
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache
    public File startFile(String s, long v, long v1) {
        File file1;
        Throwable throwable2;
        CachedContent cachedContent0;
        __monitor_enter(this);
        try {
            Assertions.checkState(!this.released);
            this.checkInitialization();
            cachedContent0 = this.contentIndex.get(s);
            Assertions.checkNotNull(cachedContent0);
            Assertions.checkState(cachedContent0.isLocked());
            if(!this.cacheDir.exists()) {
                goto label_7;
            }
            goto label_13;
        }
        catch(Throwable throwable0) {
            goto label_21;
        }
        try {
        label_7:
            this.cacheDir.mkdirs();
            this.removeStaleSpans();
        }
        catch(Throwable throwable1) {
            throwable2 = throwable1;
            goto label_22;
        }
        try {
        label_13:
            this.evictor.onStartFile(this, s, v, v1);
            String s1 = Integer.toString(this.random.nextInt(10));
            File file0 = new File(this.cacheDir, s1);
            if(!file0.exists()) {
                file0.mkdir();
            }
            file1 = SimpleCacheSpan.getCacheFile(file0, cachedContent0.id, v, System.currentTimeMillis());
            goto label_24;
        label_21:
            throwable2 = throwable0;
        label_22:
            __monitor_exit(this);
        }
        catch(Throwable throwable0) {
            goto label_21;
        }
        throw throwable2;
    label_24:
        __monitor_exit(this);
        return file1;
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache
    public CacheSpan startReadWrite(String s, long v) {
        synchronized(this) {
            Assertions.checkState(!this.released);
            this.checkInitialization();
            CacheSpan cacheSpan0;
            while((cacheSpan0 = this.startReadWriteNonBlocking(s, v)) == null) {
                this.wait();
            }
            return cacheSpan0;
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache
    public CacheSpan startReadWriteNonBlocking(String s, long v) {
        synchronized(this) {
            Assertions.checkState(!this.released);
            this.checkInitialization();
            CacheSpan cacheSpan0 = this.getSpan(s, v);
            if(cacheSpan0.isCached) {
                return this.touchSpan(s, ((SimpleCacheSpan)cacheSpan0));
            }
            CachedContent cachedContent0 = this.contentIndex.getOrAdd(s);
            if(!cachedContent0.isLocked()) {
                cachedContent0.setLocked(true);
                return cacheSpan0;
            }
            return null;
        }
    }

    private SimpleCacheSpan touchSpan(String s, SimpleCacheSpan simpleCacheSpan0) {
        boolean z;
        if(!this.touchCacheSpans) {
            return simpleCacheSpan0;
        }
        String s1 = ((File)Assertions.checkNotNull(simpleCacheSpan0.file)).getName();
        long v = simpleCacheSpan0.length;
        long v1 = System.currentTimeMillis();
        CacheFileMetadataIndex cacheFileMetadataIndex0 = this.fileIndex;
        if(cacheFileMetadataIndex0 == null) {
            z = true;
        }
        else {
            try {
                cacheFileMetadataIndex0.set(s1, v, v1);
            }
            catch(IOException unused_ex) {
                Log.w("SimpleCache", "Failed to update index with new touch timestamp.");
            }
            z = false;
        }
        SimpleCacheSpan simpleCacheSpan1 = this.contentIndex.get(s).setLastTouchTimestamp(simpleCacheSpan0, v1, z);
        this.notifySpanTouched(simpleCacheSpan0, simpleCacheSpan1);
        return simpleCacheSpan1;
    }

    private static void unlockFolder(File file0) {
        synchronized(SimpleCache.class) {
            File file1 = file0.getAbsoluteFile();
            SimpleCache.lockedCacheDirs.remove(file1);
        }
    }
}

