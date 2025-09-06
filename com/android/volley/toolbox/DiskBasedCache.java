package com.android.volley.toolbox;

import android.os.SystemClock;
import android.text.TextUtils;
import com.android.volley.Cache.Entry;
import com.android.volley.Cache;
import com.android.volley.Header;
import com.android.volley.VolleyLog;
import com.iloen.melon.utils.FileUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import k8.Y;

public class DiskBasedCache implements Cache {
    static class CacheHeader {
        final List allResponseHeaders;
        final String etag;
        final String key;
        final long lastModified;
        final long serverDate;
        long size;
        final long softTtl;
        final long ttl;

        public CacheHeader(String s, Entry cache$Entry0) {
            this(s, cache$Entry0.etag, cache$Entry0.serverDate, cache$Entry0.lastModified, cache$Entry0.ttl, cache$Entry0.softTtl, CacheHeader.getAllResponseHeaders(cache$Entry0));
            this.size = (long)cache$Entry0.data.length;
        }

        private CacheHeader(String s, String s1, long v, long v1, long v2, long v3, List list0) {
            this.key = s;
            if("".equals(s1)) {
                s1 = null;
            }
            this.etag = s1;
            this.serverDate = v;
            this.lastModified = v1;
            this.ttl = v2;
            this.softTtl = v3;
            this.allResponseHeaders = list0;
        }

        private static List getAllResponseHeaders(Entry cache$Entry0) {
            List list0 = cache$Entry0.allResponseHeaders;
            return list0 == null ? HttpHeaderParser.toAllHeaderList(cache$Entry0.responseHeaders) : list0;
        }

        public static CacheHeader readHeader(CountingInputStream diskBasedCache$CountingInputStream0) {
            if(DiskBasedCache.readInt(diskBasedCache$CountingInputStream0) != 0x20150306) {
                throw new IOException();
            }
            return new CacheHeader(DiskBasedCache.readString(diskBasedCache$CountingInputStream0), DiskBasedCache.readString(diskBasedCache$CountingInputStream0), DiskBasedCache.readLong(diskBasedCache$CountingInputStream0), DiskBasedCache.readLong(diskBasedCache$CountingInputStream0), DiskBasedCache.readLong(diskBasedCache$CountingInputStream0), DiskBasedCache.readLong(diskBasedCache$CountingInputStream0), DiskBasedCache.readHeaderList(diskBasedCache$CountingInputStream0));
        }

        public Entry toCacheEntry(byte[] arr_b) {
            Entry cache$Entry0 = new Entry();
            cache$Entry0.data = arr_b;
            cache$Entry0.etag = this.etag;
            cache$Entry0.serverDate = this.serverDate;
            cache$Entry0.lastModified = this.lastModified;
            cache$Entry0.ttl = this.ttl;
            cache$Entry0.softTtl = this.softTtl;
            cache$Entry0.responseHeaders = HttpHeaderParser.toHeaderMap(this.allResponseHeaders);
            cache$Entry0.allResponseHeaders = Collections.unmodifiableList(this.allResponseHeaders);
            return cache$Entry0;
        }

        public boolean writeHeader(OutputStream outputStream0) {
            try {
                DiskBasedCache.writeInt(outputStream0, 0x20150306);
                DiskBasedCache.writeString(outputStream0, this.key);
                DiskBasedCache.writeString(outputStream0, (this.etag == null ? "" : this.etag));
                DiskBasedCache.writeLong(outputStream0, this.serverDate);
                DiskBasedCache.writeLong(outputStream0, this.lastModified);
                DiskBasedCache.writeLong(outputStream0, this.ttl);
                DiskBasedCache.writeLong(outputStream0, this.softTtl);
                DiskBasedCache.writeHeaderList(this.allResponseHeaders, outputStream0);
                outputStream0.flush();
                return true;
            }
            catch(IOException iOException0) {
            }
            VolleyLog.d("%s", new Object[]{iOException0.toString()});
            return false;
        }
    }

    static class CountingInputStream extends FilterInputStream {
        private long bytesRead;
        private final long length;

        public CountingInputStream(InputStream inputStream0, long v) {
            super(inputStream0);
            this.length = v;
        }

        public long bytesRead() {
            return this.bytesRead;
        }

        public long bytesRemaining() {
            return this.length - this.bytesRead;
        }

        @Override
        public int read() {
            int v = super.read();
            if(v != -1) {
                ++this.bytesRead;
            }
            return v;
        }

        @Override
        public int read(byte[] arr_b, int v, int v1) {
            int v2 = super.read(arr_b, v, v1);
            if(v2 != -1) {
                this.bytesRead += (long)v2;
            }
            return v2;
        }
    }

    private static final int CACHE_MAGIC = 0x20150306;
    private static final int DEFAULT_DISK_USAGE_BYTES = 0x500000;
    static final float HYSTERESIS_FACTOR = 0.9f;
    private final Map mEntries;
    private final int mMaxCacheSizeInBytes;
    private final File mRootDirectory;
    private long mTotalSize;

    public DiskBasedCache(File file0) {
        this(file0, 0x500000);
    }

    public DiskBasedCache(File file0, int v) {
        this.mEntries = new LinkedHashMap(16, 0.75f, true);
        this.mTotalSize = 0L;
        this.mRootDirectory = file0;
        this.mMaxCacheSizeInBytes = v;
    }

    @Override  // com.android.volley.Cache
    public void clear() {
        synchronized(this) {
            File[] arr_file = this.mRootDirectory.listFiles();
            if(arr_file != null) {
                for(int v1 = 0; v1 < arr_file.length; ++v1) {
                    arr_file[v1].delete();
                }
            }
            this.mEntries.clear();
            this.mTotalSize = 0L;
            VolleyLog.d("Cache cleared.", new Object[0]);
        }
    }

    public InputStream createInputStream(File file0) {
        return new FileInputStream(file0);
    }

    public OutputStream createOutputStream(File file0) {
        return new FileOutputStream(file0);
    }

    @Override  // com.android.volley.Cache
    public Entry get(String s) {
        Entry cache$Entry0;
        CountingInputStream diskBasedCache$CountingInputStream0;
        synchronized(this) {
            CacheHeader diskBasedCache$CacheHeader0 = (CacheHeader)this.mEntries.get(s);
            if(diskBasedCache$CacheHeader0 == null) {
                return null;
            }
            File file0 = this.getFileForKey(s);
            try {
                diskBasedCache$CountingInputStream0 = new CountingInputStream(new BufferedInputStream(this.createInputStream(file0)), file0.length());
            }
            catch(IOException iOException0) {
                VolleyLog.d("%s: %s", new Object[]{FileUtils.getSafetyPath(file0), iOException0.toString()});
                this.remove(s);
                return null;
            }
            try {
                CacheHeader diskBasedCache$CacheHeader1 = CacheHeader.readHeader(diskBasedCache$CountingInputStream0);
                if(!TextUtils.equals(s, diskBasedCache$CacheHeader1.key)) {
                    VolleyLog.d("%s: key=%s, found=%s", new Object[]{FileUtils.getSafetyPath(file0), s, diskBasedCache$CacheHeader1.key});
                    this.removeEntry(s);
                    goto label_14;
                }
                cache$Entry0 = diskBasedCache$CacheHeader0.toCacheEntry(DiskBasedCache.streamToBytes(diskBasedCache$CountingInputStream0, diskBasedCache$CountingInputStream0.bytesRemaining()));
                goto label_23;
            }
            catch(Throwable throwable0) {
                goto label_20;
            }
            try {
            label_14:
                diskBasedCache$CountingInputStream0.close();
            }
            catch(IOException iOException0) {
                VolleyLog.d("%s: %s", new Object[]{FileUtils.getSafetyPath(file0), iOException0.toString()});
                this.remove(s);
            }
            return null;
            try {
                cache$Entry0 = diskBasedCache$CacheHeader0.toCacheEntry(DiskBasedCache.streamToBytes(diskBasedCache$CountingInputStream0, diskBasedCache$CountingInputStream0.bytesRemaining()));
                goto label_23;
            }
            catch(Throwable throwable0) {
                try {
                label_20:
                    diskBasedCache$CountingInputStream0.close();
                    throw throwable0;
                label_23:
                    diskBasedCache$CountingInputStream0.close();
                    return cache$Entry0;
                }
                catch(IOException iOException0) {
                }
            }
            VolleyLog.d("%s: %s", new Object[]{FileUtils.getSafetyPath(file0), iOException0.toString()});
            this.remove(s);
            return null;
        }
    }

    public File getFileForKey(String s) {
        String s1 = this.getFilenameForKey(s);
        return new File(this.mRootDirectory, s1);
    }

    private String getFilenameForKey(String s) {
        int v = s.length();
        StringBuilder stringBuilder0 = Y.p(String.valueOf(s.substring(0, v / 2).hashCode()));
        stringBuilder0.append(String.valueOf(s.substring(v / 2).hashCode()));
        return stringBuilder0.toString();
    }

    @Override  // com.android.volley.Cache
    public void initialize() {
        synchronized(this) {
            if(!this.mRootDirectory.exists()) {
                if(!this.mRootDirectory.mkdirs()) {
                    VolleyLog.e("Unable to create cache dir %s", new Object[]{FileUtils.getSafetyPath(this.mRootDirectory)});
                }
                return;
            }
            File[] arr_file = this.mRootDirectory.listFiles();
            if(arr_file == null) {
                return;
            }
            for(int v1 = 0; v1 < arr_file.length; ++v1) {
                File file0 = arr_file[v1];
                try {
                    long v2 = file0.length();
                    CountingInputStream diskBasedCache$CountingInputStream0 = new CountingInputStream(new BufferedInputStream(this.createInputStream(file0)), v2);
                    try {
                        CacheHeader diskBasedCache$CacheHeader0 = CacheHeader.readHeader(diskBasedCache$CountingInputStream0);
                        diskBasedCache$CacheHeader0.size = v2;
                        this.putEntry(diskBasedCache$CacheHeader0.key, diskBasedCache$CacheHeader0);
                    }
                    catch(Throwable throwable0) {
                        diskBasedCache$CountingInputStream0.close();
                        throw throwable0;
                    }
                    diskBasedCache$CountingInputStream0.close();
                }
                catch(OutOfMemoryError unused_ex) {
                    if(file0.exists()) {
                        file0.delete();
                    }
                }
                catch(IOException unused_ex) {
                    if(file0.exists()) {
                        file0.delete();
                    }
                }
            }
        }
    }

    @Override  // com.android.volley.Cache
    public void invalidate(String s, boolean z) {
        synchronized(this) {
            Entry cache$Entry0 = this.get(s);
            if(cache$Entry0 != null) {
                cache$Entry0.softTtl = 0L;
                if(z) {
                    cache$Entry0.ttl = 0L;
                }
                this.put(s, cache$Entry0);
            }
        }
    }

    private void pruneIfNeeded(int v) {
        int v1 = 0;
        if(this.mTotalSize + ((long)v) >= ((long)this.mMaxCacheSizeInBytes)) {
            if(VolleyLog.DEBUG) {
                VolleyLog.v("Pruning old cache entries.", new Object[0]);
            }
            long v2 = this.mTotalSize;
            long v3 = SystemClock.elapsedRealtime();
            Iterator iterator0 = this.mEntries.entrySet().iterator();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                CacheHeader diskBasedCache$CacheHeader0 = (CacheHeader)((Map.Entry)object0).getValue();
                if(this.getFileForKey(diskBasedCache$CacheHeader0.key).delete()) {
                    this.mTotalSize -= diskBasedCache$CacheHeader0.size;
                }
                else {
                    String s = this.getFilenameForKey(diskBasedCache$CacheHeader0.key);
                    VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", new Object[]{diskBasedCache$CacheHeader0.key, s});
                }
                iterator0.remove();
                ++v1;
                if(((float)(this.mTotalSize + ((long)v))) < ((float)this.mMaxCacheSizeInBytes) * 0.9f) {
                    break;
                }
            }
            if(VolleyLog.DEBUG) {
                VolleyLog.v("pruned %d files, %d bytes, %d ms", new Object[]{v1, ((long)(this.mTotalSize - v2)), ((long)(SystemClock.elapsedRealtime() - v3))});
            }
        }
    }

    @Override  // com.android.volley.Cache
    public void put(String s, Entry cache$Entry0) {
        BufferedOutputStream bufferedOutputStream0;
        synchronized(this) {
            this.pruneIfNeeded(cache$Entry0.data.length);
            File file0 = this.getFileForKey(s);
            try {
                bufferedOutputStream0 = new BufferedOutputStream(this.createOutputStream(file0));
                CacheHeader diskBasedCache$CacheHeader0 = new CacheHeader(s, cache$Entry0);
                if(diskBasedCache$CacheHeader0.writeHeader(bufferedOutputStream0)) {
                    bufferedOutputStream0.write(cache$Entry0.data);
                    bufferedOutputStream0.close();
                    this.putEntry(s, diskBasedCache$CacheHeader0);
                    return;
                }
                goto label_14;
            }
            catch(IOException unused_ex) {
                goto label_16;
            }
            return;
            try {
            label_14:
                bufferedOutputStream0.close();
                VolleyLog.d("Failed to write header for %s", new Object[]{file0.getAbsolutePath()});
            }
            catch(IOException unused_ex) {
            }
        label_16:
            if(!file0.delete()) {
                VolleyLog.d("Could not clean up file %s", new Object[]{file0.getAbsolutePath()});
            }
        }
    }

    private void putEntry(String s, CacheHeader diskBasedCache$CacheHeader0) {
        if(this.mEntries.containsKey(s)) {
            CacheHeader diskBasedCache$CacheHeader1 = (CacheHeader)this.mEntries.get(s);
            this.mTotalSize = diskBasedCache$CacheHeader0.size - diskBasedCache$CacheHeader1.size + this.mTotalSize;
        }
        else {
            this.mTotalSize += diskBasedCache$CacheHeader0.size;
        }
        this.mEntries.put(s, diskBasedCache$CacheHeader0);
    }

    private static int read(InputStream inputStream0) {
        int v = inputStream0.read();
        if(v == -1) {
            throw new EOFException();
        }
        return v;
    }

    public static List readHeaderList(CountingInputStream diskBasedCache$CountingInputStream0) {
        int v = DiskBasedCache.readInt(diskBasedCache$CountingInputStream0);
        if(v < 0) {
            throw new IOException("readHeaderList size=" + v);
        }
        List list0 = v == 0 ? Collections.EMPTY_LIST : new ArrayList();
        for(int v1 = 0; v1 < v; ++v1) {
            list0.add(new Header(DiskBasedCache.readString(diskBasedCache$CountingInputStream0).intern(), DiskBasedCache.readString(diskBasedCache$CountingInputStream0).intern()));
        }
        return list0;
    }

    public static int readInt(InputStream inputStream0) {
        int v = DiskBasedCache.read(inputStream0);
        int v1 = DiskBasedCache.read(inputStream0);
        int v2 = DiskBasedCache.read(inputStream0);
        return DiskBasedCache.read(inputStream0) << 24 | (v | v1 << 8 | v2 << 16);
    }

    public static long readLong(InputStream inputStream0) {
        return ((long)DiskBasedCache.read(inputStream0)) & 0xFFL | (((long)DiskBasedCache.read(inputStream0)) & 0xFFL) << 8 | (((long)DiskBasedCache.read(inputStream0)) & 0xFFL) << 16 | (((long)DiskBasedCache.read(inputStream0)) & 0xFFL) << 24 | (((long)DiskBasedCache.read(inputStream0)) & 0xFFL) << 0x20 | (((long)DiskBasedCache.read(inputStream0)) & 0xFFL) << 40 | (((long)DiskBasedCache.read(inputStream0)) & 0xFFL) << 0x30 | (0xFFL & ((long)DiskBasedCache.read(inputStream0))) << 56;
    }

    public static String readString(CountingInputStream diskBasedCache$CountingInputStream0) {
        return new String(DiskBasedCache.streamToBytes(diskBasedCache$CountingInputStream0, DiskBasedCache.readLong(diskBasedCache$CountingInputStream0)), "UTF-8");
    }

    @Override  // com.android.volley.Cache
    public void remove(String s) {
        synchronized(this) {
            boolean z = this.getFileForKey(s).delete();
            this.removeEntry(s);
            if(!z) {
                VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", new Object[]{s, this.getFilenameForKey(s)});
            }
        }
    }

    private void removeEntry(String s) {
        CacheHeader diskBasedCache$CacheHeader0 = (CacheHeader)this.mEntries.remove(s);
        if(diskBasedCache$CacheHeader0 != null) {
            this.mTotalSize -= diskBasedCache$CacheHeader0.size;
        }
    }

    public static byte[] streamToBytes(CountingInputStream diskBasedCache$CountingInputStream0, long v) {
        long v1 = diskBasedCache$CountingInputStream0.bytesRemaining();
        if(v >= 0L && v <= v1 && ((long)(((int)v))) == v) {
            byte[] arr_b = new byte[((int)v)];
            new DataInputStream(diskBasedCache$CountingInputStream0).readFully(arr_b);
            return arr_b;
        }
        StringBuilder stringBuilder0 = Y.o(v, "streamToBytes length=", ", maxLength=");
        stringBuilder0.append(v1);
        throw new IOException(stringBuilder0.toString());
    }

    public static void writeHeaderList(List list0, OutputStream outputStream0) {
        if(list0 != null) {
            DiskBasedCache.writeInt(outputStream0, list0.size());
            for(Object object0: list0) {
                DiskBasedCache.writeString(outputStream0, ((Header)object0).getName());
                DiskBasedCache.writeString(outputStream0, ((Header)object0).getValue());
            }
            return;
        }
        DiskBasedCache.writeInt(outputStream0, 0);
    }

    public static void writeInt(OutputStream outputStream0, int v) {
        outputStream0.write(v & 0xFF);
        outputStream0.write(v >> 8 & 0xFF);
        outputStream0.write(v >> 16 & 0xFF);
        outputStream0.write(v >> 24 & 0xFF);
    }

    public static void writeLong(OutputStream outputStream0, long v) {
        outputStream0.write(((int)(((byte)(((int)v))))));
        outputStream0.write(((int)(((byte)(((int)(v >>> 8)))))));
        outputStream0.write(((int)(((byte)(((int)(v >>> 16)))))));
        outputStream0.write(((int)(((byte)(((int)(v >>> 24)))))));
        outputStream0.write(((int)(((byte)(((int)(v >>> 0x20)))))));
        outputStream0.write(((int)(((byte)(((int)(v >>> 40)))))));
        outputStream0.write(((int)(((byte)(((int)(v >>> 0x30)))))));
        outputStream0.write(((int)(((byte)(((int)(v >>> 56)))))));
    }

    public static void writeString(OutputStream outputStream0, String s) {
        byte[] arr_b = s.getBytes("UTF-8");
        DiskBasedCache.writeLong(outputStream0, ((long)arr_b.length));
        outputStream0.write(arr_b, 0, arr_b.length);
    }
}

