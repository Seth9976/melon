package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class SimpleCacheSpan extends CacheSpan {
    private static final Pattern CACHE_FILE_PATTERN_V1 = null;
    private static final Pattern CACHE_FILE_PATTERN_V2 = null;
    private static final Pattern CACHE_FILE_PATTERN_V3 = null;
    static final String COMMON_SUFFIX = ".exo";
    private static final String SUFFIX = ".v3.exo";

    static {
        SimpleCacheSpan.CACHE_FILE_PATTERN_V1 = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 0x20);
        SimpleCacheSpan.CACHE_FILE_PATTERN_V2 = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 0x20);
        SimpleCacheSpan.CACHE_FILE_PATTERN_V3 = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 0x20);
    }

    private SimpleCacheSpan(String s, long v, long v1, long v2, File file0) {
        super(s, v, v1, v2, file0);
    }

    public SimpleCacheSpan copyWithFileAndLastTouchTimestamp(File file0, long v) {
        Assertions.checkState(this.isCached);
        return new SimpleCacheSpan(this.key, this.position, this.length, v, file0);
    }

    public static SimpleCacheSpan createCacheEntry(File file0, long v, long v1, CachedContentIndex cachedContentIndex0) {
        String s = file0.getName();
        if(!s.endsWith(".v3.exo")) {
            file0 = SimpleCacheSpan.upgradeFile(file0, cachedContentIndex0);
            if(file0 == null) {
                return null;
            }
            s = file0.getName();
        }
        Matcher matcher0 = SimpleCacheSpan.CACHE_FILE_PATTERN_V3.matcher(s);
        if(!matcher0.matches()) {
            return null;
        }
        String s1 = cachedContentIndex0.getKeyForId(Integer.parseInt(matcher0.group(1)));
        if(s1 == null) {
            return null;
        }
        if(v == -1L) {
            v = file0.length();
        }
        if(v == 0L) {
            return null;
        }
        long v2 = Long.parseLong(matcher0.group(2));
        return v1 == 0x8000000000000001L ? new SimpleCacheSpan(s1, v2, v, Long.parseLong(matcher0.group(3)), file0) : new SimpleCacheSpan(s1, v2, v, v1, file0);
    }

    public static SimpleCacheSpan createCacheEntry(File file0, long v, CachedContentIndex cachedContentIndex0) {
        return SimpleCacheSpan.createCacheEntry(file0, v, 0x8000000000000001L, cachedContentIndex0);
    }

    public static SimpleCacheSpan createClosedHole(String s, long v, long v1) {
        return new SimpleCacheSpan(s, v, v1, 0x8000000000000001L, null);
    }

    public static SimpleCacheSpan createLookup(String s, long v) {
        return new SimpleCacheSpan(s, v, -1L, 0x8000000000000001L, null);
    }

    public static SimpleCacheSpan createOpenHole(String s, long v) {
        return new SimpleCacheSpan(s, v, -1L, 0x8000000000000001L, null);
    }

    public static File getCacheFile(File file0, int v, long v1, long v2) {
        return new File(file0, v + "." + v1 + "." + v2 + ".v3.exo");
    }

    private static File upgradeFile(File file0, CachedContentIndex cachedContentIndex0) {
        String s1;
        String s = file0.getName();
        Matcher matcher0 = SimpleCacheSpan.CACHE_FILE_PATTERN_V2.matcher(s);
        if(matcher0.matches()) {
            s1 = Util.unescapeFileName(matcher0.group(1));
            if(s1 == null) {
                return null;
            }
        }
        else {
            matcher0 = SimpleCacheSpan.CACHE_FILE_PATTERN_V1.matcher(s);
            if(!matcher0.matches()) {
                return null;
            }
            s1 = matcher0.group(1);
        }
        File file1 = SimpleCacheSpan.getCacheFile(((File)Assertions.checkStateNotNull(file0.getParentFile())), cachedContentIndex0.assignIdForKey(s1), Long.parseLong(matcher0.group(2)), Long.parseLong(matcher0.group(3)));
        return file0.renameTo(file1) ? file1 : null;
    }
}

