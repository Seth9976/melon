package com.bumptech.glide.disklrucache;

import android.annotation.TargetApi;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class DiskLruCache implements Closeable {
    static final class DiskLruCacheThreadFactory implements ThreadFactory {
        private DiskLruCacheThreadFactory() {
        }

        public DiskLruCacheThreadFactory(com.bumptech.glide.disklrucache.DiskLruCache.1 diskLruCache$10) {
        }

        @Override
        public Thread newThread(Runnable runnable0) {
            synchronized(this) {
                Thread thread0 = new Thread(runnable0, "glide-disk-lru-cache-thread");
                thread0.setPriority(1);
                return thread0;
            }
        }
    }

    public final class Editor {
        private boolean committed;
        private final Entry entry;
        private final boolean[] written;

        private Editor(Entry diskLruCache$Entry0) {
            this.entry = diskLruCache$Entry0;
            this.written = Entry.access$700(diskLruCache$Entry0) ? null : new boolean[diskLruCache0.valueCount];
        }

        public Editor(Entry diskLruCache$Entry0, com.bumptech.glide.disklrucache.DiskLruCache.1 diskLruCache$10) {
            this(diskLruCache$Entry0);
        }

        public void abort() {
            DiskLruCache.this.completeEdit(this, false);
        }

        public void abortUnlessCommitted() {
            if(!this.committed) {
                try {
                    this.abort();
                }
                catch(IOException unused_ex) {
                }
            }
        }

        public static Entry access$1500(Editor diskLruCache$Editor0) {
            return diskLruCache$Editor0.entry;
        }

        public static boolean[] access$1600(Editor diskLruCache$Editor0) {
            return diskLruCache$Editor0.written;
        }

        public void commit() {
            DiskLruCache.this.completeEdit(this, true);
            this.committed = true;
        }

        public File getFile(int v) {
            synchronized(DiskLruCache.this) {
                if(Entry.access$800(this.entry) == this) {
                    if(!Entry.access$700(this.entry)) {
                        this.written[v] = true;
                    }
                    File file0 = this.entry.getDirtyFile(v);
                    DiskLruCache.this.directory.mkdirs();
                    return file0;
                }
            }
            throw new IllegalStateException();
        }

        public String getString(int v) {
            InputStream inputStream0 = this.newInputStream(v);
            return inputStream0 == null ? null : DiskLruCache.inputStreamToString(inputStream0);
        }

        private InputStream newInputStream(int v) {
            synchronized(DiskLruCache.this) {
                if(Entry.access$800(this.entry) == this) {
                    if(!Entry.access$700(this.entry)) {
                        return null;
                    }
                    try {
                        return new FileInputStream(this.entry.getCleanFile(v));
                    }
                    catch(FileNotFoundException unused_ex) {
                        return null;
                    }
                }
            }
            throw new IllegalStateException();
        }

        public void set(int v, String s) {
            OutputStreamWriter outputStreamWriter0;
            try {
                outputStreamWriter0 = new OutputStreamWriter(new FileOutputStream(this.getFile(v)), Util.UTF_8);
                outputStreamWriter0.write(s);
            }
            finally {
                Util.closeQuietly(outputStreamWriter0);
            }
        }
    }

    final class Entry {
        File[] cleanFiles;
        private Editor currentEditor;
        File[] dirtyFiles;
        private final String key;
        private final long[] lengths;
        private boolean readable;
        private long sequenceNumber;

        private Entry(String s) {
            this.key = s;
            this.lengths = new long[diskLruCache0.valueCount];
            this.cleanFiles = new File[diskLruCache0.valueCount];
            this.dirtyFiles = new File[diskLruCache0.valueCount];
            StringBuilder stringBuilder0 = new StringBuilder(s);
            stringBuilder0.append('.');
            int v = stringBuilder0.length();
            for(int v1 = 0; v1 < diskLruCache0.valueCount; ++v1) {
                stringBuilder0.append(v1);
                File[] arr_file = this.cleanFiles;
                arr_file[v1] = new File(diskLruCache0.directory, stringBuilder0.toString());
                stringBuilder0.append(".tmp");
                File[] arr_file1 = this.dirtyFiles;
                arr_file1[v1] = new File(diskLruCache0.directory, stringBuilder0.toString());
                stringBuilder0.setLength(v);
            }
        }

        public Entry(String s, com.bumptech.glide.disklrucache.DiskLruCache.1 diskLruCache$10) {
            this(s);
        }

        public static long[] access$1100(Entry diskLruCache$Entry0) {
            return diskLruCache$Entry0.lengths;
        }

        public static String access$1200(Entry diskLruCache$Entry0) {
            return diskLruCache$Entry0.key;
        }

        public static long access$1300(Entry diskLruCache$Entry0) {
            return diskLruCache$Entry0.sequenceNumber;
        }

        public static long access$1302(Entry diskLruCache$Entry0, long v) {
            diskLruCache$Entry0.sequenceNumber = v;
            return v;
        }

        public static boolean access$700(Entry diskLruCache$Entry0) {
            return diskLruCache$Entry0.readable;
        }

        public static boolean access$702(Entry diskLruCache$Entry0, boolean z) {
            diskLruCache$Entry0.readable = z;
            return z;
        }

        public static Editor access$800(Entry diskLruCache$Entry0) {
            return diskLruCache$Entry0.currentEditor;
        }

        public static Editor access$802(Entry diskLruCache$Entry0, Editor diskLruCache$Editor0) {
            diskLruCache$Entry0.currentEditor = diskLruCache$Editor0;
            return diskLruCache$Editor0;
        }

        public static void access$900(Entry diskLruCache$Entry0, String[] arr_s) {
            diskLruCache$Entry0.setLengths(arr_s);
        }

        public File getCleanFile(int v) {
            return this.cleanFiles[v];
        }

        public File getDirtyFile(int v) {
            return this.dirtyFiles[v];
        }

        public String getLengths() {
            StringBuilder stringBuilder0 = new StringBuilder();
            long[] arr_v = this.lengths;
            for(int v = 0; v < arr_v.length; ++v) {
                long v1 = arr_v[v];
                stringBuilder0.append(' ');
                stringBuilder0.append(v1);
            }
            return stringBuilder0.toString();
        }

        private IOException invalidLengths(String[] arr_s) {
            throw new IOException("unexpected journal line: " + Arrays.toString(arr_s));
        }

        private void setLengths(String[] arr_s) {
            if(arr_s.length == DiskLruCache.this.valueCount) {
                try {
                    for(int v = 0; v < arr_s.length; ++v) {
                        this.lengths[v] = Long.parseLong(arr_s[v]);
                    }
                    return;
                }
                catch(NumberFormatException unused_ex) {
                    throw this.invalidLengths(arr_s);
                }
            }
            throw this.invalidLengths(arr_s);
        }
    }

    public final class Value {
        private final File[] files;
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;

        private Value(String s, long v, File[] arr_file, long[] arr_v) {
            this.key = s;
            this.sequenceNumber = v;
            this.files = arr_file;
            this.lengths = arr_v;
        }

        public Value(String s, long v, File[] arr_file, long[] arr_v, com.bumptech.glide.disklrucache.DiskLruCache.1 diskLruCache$10) {
            this(s, v, arr_file, arr_v);
        }

        public Editor edit() {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public File getFile(int v) {
            return this.files[v];
        }

        public long getLength(int v) {
            return this.lengths[v];
        }

        public String getString(int v) {
            return DiskLruCache.inputStreamToString(new FileInputStream(this.files[v]));
        }
    }

    static final long ANY_SEQUENCE_NUMBER = -1L;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Callable cleanupCallable;
    private final File directory;
    final ThreadPoolExecutor executorService;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private Writer journalWriter;
    private final LinkedHashMap lruEntries;
    private long maxSize;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;

    private DiskLruCache(File file0, int v, int v1, long v2) {
        this.size = 0L;
        this.lruEntries = new LinkedHashMap(0, 0.75f, true);
        this.nextSequenceNumber = 0L;
        this.executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DiskLruCacheThreadFactory(null));
        this.cleanupCallable = new Callable() {
            @Override
            public Object call() {
                return this.call();
            }

            public Void call() {
                synchronized(DiskLruCache.this) {
                    if(DiskLruCache.this.journalWriter == null) {
                        return null;
                    }
                    DiskLruCache.this.trimToSize();
                    if(DiskLruCache.this.journalRebuildRequired()) {
                        DiskLruCache.this.rebuildJournal();
                        DiskLruCache.this.redundantOpCount = 0;
                    }
                    return null;
                }
            }
        };
        this.directory = file0;
        this.appVersion = v;
        this.journalFile = new File(file0, "journal");
        this.journalFileTmp = new File(file0, "journal.tmp");
        this.journalFileBackup = new File(file0, "journal.bkp");
        this.valueCount = v1;
        this.maxSize = v2;
    }

    private void checkNotClosed() {
        if(this.journalWriter == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override
    public void close() {
        synchronized(this) {
            if(this.journalWriter == null) {
                return;
            }
            for(Object object0: new ArrayList(this.lruEntries.values())) {
                Entry diskLruCache$Entry0 = (Entry)object0;
                if(Entry.access$800(diskLruCache$Entry0) != null) {
                    Entry.access$800(diskLruCache$Entry0).abort();
                }
            }
            this.trimToSize();
            DiskLruCache.closeWriter(this.journalWriter);
            this.journalWriter = null;
        }
    }

    @TargetApi(26)
    private static void closeWriter(Writer writer0) {
        StrictMode.ThreadPolicy strictMode$ThreadPolicy0 = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(strictMode$ThreadPolicy0).permitUnbufferedIo().build());
        try {
            writer0.close();
        }
        finally {
            StrictMode.setThreadPolicy(strictMode$ThreadPolicy0);
        }
    }

    private void completeEdit(Editor diskLruCache$Editor0, boolean z) {
        synchronized(this) {
            Entry diskLruCache$Entry0 = Editor.access$1500(diskLruCache$Editor0);
            if(Entry.access$800(diskLruCache$Entry0) == diskLruCache$Editor0) {
                if(z && !Entry.access$700(diskLruCache$Entry0)) {
                    int v2 = 0;
                    while(v2 < this.valueCount) {
                        if(Editor.access$1600(diskLruCache$Editor0)[v2]) {
                            if(!diskLruCache$Entry0.getDirtyFile(v2).exists()) {
                                diskLruCache$Editor0.abort();
                                return;
                            }
                            ++v2;
                            continue;
                        }
                        diskLruCache$Editor0.abort();
                        throw new IllegalStateException("Newly created entry didn\'t create value for index " + v2);
                    }
                }
                for(int v1 = 0; v1 < this.valueCount; ++v1) {
                    File file0 = diskLruCache$Entry0.getDirtyFile(v1);
                    if(!z) {
                        DiskLruCache.deleteIfExists(file0);
                    }
                    else if(file0.exists()) {
                        File file1 = diskLruCache$Entry0.getCleanFile(v1);
                        file0.renameTo(file1);
                        long v3 = Entry.access$1100(diskLruCache$Entry0)[v1];
                        long v4 = file1.length();
                        Entry.access$1100(diskLruCache$Entry0)[v1] = v4;
                        this.size = this.size - v3 + v4;
                    }
                }
                ++this.redundantOpCount;
                Entry.access$802(diskLruCache$Entry0, null);
                if((Entry.access$700(diskLruCache$Entry0) | z) == 0) {
                    this.lruEntries.remove(Entry.access$1200(diskLruCache$Entry0));
                    this.journalWriter.append("REMOVE");
                    this.journalWriter.append(' ');
                    this.journalWriter.append(Entry.access$1200(diskLruCache$Entry0));
                    this.journalWriter.append('\n');
                }
                else {
                    Entry.access$702(diskLruCache$Entry0, true);
                    this.journalWriter.append("CLEAN");
                    this.journalWriter.append(' ');
                    this.journalWriter.append(Entry.access$1200(diskLruCache$Entry0));
                    this.journalWriter.append(diskLruCache$Entry0.getLengths());
                    this.journalWriter.append('\n');
                    if(z) {
                        long v5 = this.nextSequenceNumber;
                        this.nextSequenceNumber = v5 + 1L;
                        Entry.access$1302(diskLruCache$Entry0, v5);
                    }
                }
                DiskLruCache.flushWriter(this.journalWriter);
                if(this.size > this.maxSize || this.journalRebuildRequired()) {
                    this.executorService.submit(this.cleanupCallable);
                }
                return;
            }
        }
        throw new IllegalStateException();
    }

    public void delete() {
        this.close();
        Util.deleteContents(this.directory);
    }

    private static void deleteIfExists(File file0) {
        if(file0.exists() && !file0.delete()) {
            throw new IOException();
        }
    }

    private Editor edit(String s, long v) {
        synchronized(this) {
            this.checkNotClosed();
            Entry diskLruCache$Entry0 = (Entry)this.lruEntries.get(s);
            if(Long.compare(v, -1L) != 0 && (diskLruCache$Entry0 == null || Entry.access$1300(diskLruCache$Entry0) != v)) {
                return null;
            }
            if(diskLruCache$Entry0 == null) {
                diskLruCache$Entry0 = new Entry(this, s, null);
                this.lruEntries.put(s, diskLruCache$Entry0);
            }
            else if(Entry.access$800(diskLruCache$Entry0) != null) {
                return null;
            }
            Editor diskLruCache$Editor0 = new Editor(this, diskLruCache$Entry0, null);
            Entry.access$802(diskLruCache$Entry0, diskLruCache$Editor0);
            this.journalWriter.append("DIRTY");
            this.journalWriter.append(' ');
            this.journalWriter.append(s);
            this.journalWriter.append('\n');
            DiskLruCache.flushWriter(this.journalWriter);
            return diskLruCache$Editor0;
        }
    }

    public Editor edit(String s) {
        return this.edit(s, -1L);
    }

    public void flush() {
        synchronized(this) {
            this.checkNotClosed();
            this.trimToSize();
            DiskLruCache.flushWriter(this.journalWriter);
        }
    }

    @TargetApi(26)
    private static void flushWriter(Writer writer0) {
        StrictMode.ThreadPolicy strictMode$ThreadPolicy0 = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(strictMode$ThreadPolicy0).permitUnbufferedIo().build());
        try {
            writer0.flush();
        }
        finally {
            StrictMode.setThreadPolicy(strictMode$ThreadPolicy0);
        }
    }

    public Value get(String s) {
        Value diskLruCache$Value0;
        Throwable throwable2;
        int v;
        Entry diskLruCache$Entry0;
        __monitor_enter(this);
        try {
            this.checkNotClosed();
            diskLruCache$Entry0 = (Entry)this.lruEntries.get(s);
            if(diskLruCache$Entry0 == null) {
                goto label_4;
            }
            goto label_6;
        }
        catch(Throwable throwable0) {
            goto label_31;
        }
    label_4:
        __monitor_exit(this);
        return null;
    label_6:
        if(!Entry.access$700(diskLruCache$Entry0)) {
            __monitor_exit(this);
            return null;
        }
        try {
            File[] arr_file = diskLruCache$Entry0.cleanFiles;
            v = 0;
        }
        catch(Throwable throwable0) {
            goto label_31;
        }
        while(v < arr_file.length) {
            try {
                if(!arr_file[v].exists()) {
                    goto label_13;
                }
                goto label_15;
            }
            catch(Throwable throwable1) {
                throwable2 = throwable1;
                goto label_32;
            }
        label_13:
            __monitor_exit(this);
            return null;
        label_15:
            ++v;
        }
        try {
            ++this.redundantOpCount;
            this.journalWriter.append("READ");
            this.journalWriter.append(' ');
            this.journalWriter.append(s);
            this.journalWriter.append('\n');
            if(this.journalRebuildRequired()) {
                goto label_23;
            }
            diskLruCache$Value0 = new Value(this, s, Entry.access$1300(diskLruCache$Entry0), diskLruCache$Entry0.cleanFiles, Entry.access$1100(diskLruCache$Entry0), null);
            goto label_34;
        }
        catch(Throwable throwable0) {
            goto label_31;
        }
        try {
        label_23:
            this.executorService.submit(this.cleanupCallable);
        }
        catch(Throwable throwable1) {
            throwable2 = throwable1;
            goto label_32;
        }
        try {
            diskLruCache$Value0 = new Value(this, s, Entry.access$1300(diskLruCache$Entry0), diskLruCache$Entry0.cleanFiles, Entry.access$1100(diskLruCache$Entry0), null);
            goto label_34;
        label_31:
            throwable2 = throwable0;
        label_32:
            __monitor_exit(this);
        }
        catch(Throwable throwable0) {
            goto label_31;
        }
        throw throwable2;
    label_34:
        __monitor_exit(this);
        return diskLruCache$Value0;
    }

    public File getDirectory() {
        return this.directory;
    }

    public long getMaxSize() {
        synchronized(this) {
        }
        return this.maxSize;
    }

    private static String inputStreamToString(InputStream inputStream0) {
        return Util.readFully(new InputStreamReader(inputStream0, Util.UTF_8));
    }

    public boolean isClosed() {
        synchronized(this) {
        }
        return this.journalWriter == null;
    }

    private boolean journalRebuildRequired() {
        return this.redundantOpCount >= 2000 && this.redundantOpCount >= this.lruEntries.size();
    }

    public static DiskLruCache open(File file0, int v, int v1, long v2) {
        if(v2 <= 0L) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if(v1 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file1 = new File(file0, "journal.bkp");
        if(file1.exists()) {
            File file2 = new File(file0, "journal");
            if(file2.exists()) {
                file1.delete();
            }
            else {
                DiskLruCache.renameTo(file1, file2, false);
            }
        }
        DiskLruCache diskLruCache0 = new DiskLruCache(file0, v, v1, v2);
        if(diskLruCache0.journalFile.exists()) {
            try {
                diskLruCache0.readJournal();
                diskLruCache0.processJournal();
                return diskLruCache0;
            }
            catch(IOException iOException0) {
                System.out.println("DiskLruCache " + file0 + " is corrupt: " + iOException0.getMessage() + ", removing");
                diskLruCache0.delete();
            }
        }
        file0.mkdirs();
        DiskLruCache diskLruCache1 = new DiskLruCache(file0, v, v1, v2);
        diskLruCache1.rebuildJournal();
        return diskLruCache1;
    }

    private void processJournal() {
        DiskLruCache.deleteIfExists(this.journalFileTmp);
        Iterator iterator0 = this.lruEntries.values().iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            Entry diskLruCache$Entry0 = (Entry)object0;
            int v = 0;
            if(Entry.access$800(diskLruCache$Entry0) == null) {
                while(v < this.valueCount) {
                    this.size += Entry.access$1100(diskLruCache$Entry0)[v];
                    ++v;
                }
            }
            else {
                Entry.access$802(diskLruCache$Entry0, null);
                while(v < this.valueCount) {
                    DiskLruCache.deleteIfExists(diskLruCache$Entry0.getCleanFile(v));
                    DiskLruCache.deleteIfExists(diskLruCache$Entry0.getDirtyFile(v));
                    ++v;
                }
                iterator0.remove();
            }
        }
    }

    private void readJournal() {
        String s4;
        String s3;
        String s1;
        String s;
        StrictLineReader strictLineReader0 = new StrictLineReader(new FileInputStream(this.journalFile), Util.US_ASCII);
        try {
            s = strictLineReader0.readLine();
            s1 = strictLineReader0.readLine();
            String s2 = strictLineReader0.readLine();
            s3 = strictLineReader0.readLine();
            s4 = strictLineReader0.readLine();
            if("libcore.io.DiskLruCache".equals(s) && "1".equals(s1) && Integer.toString(this.appVersion).equals(s2) && Integer.toString(this.valueCount).equals(s3) && "".equals(s4)) {
                int v1 = 0;
                try {
                    while(true) {
                        this.readJournalLine(strictLineReader0.readLine());
                        ++v1;
                    }
                }
                catch(EOFException unused_ex) {
                    this.redundantOpCount = v1 - this.lruEntries.size();
                    if(strictLineReader0.hasUnterminatedLine()) {
                        this.rebuildJournal();
                    }
                    else {
                        this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
                    }
                    return;
                }
            }
        }
        finally {
            Util.closeQuietly(strictLineReader0);
        }
        throw new IOException("unexpected journal header: [" + s + ", " + s1 + ", " + s3 + ", " + s4 + "]");
    }

    private void readJournalLine(String s) {
        String s1;
        int v = s.indexOf(0x20);
        if(v == -1) {
            throw new IOException("unexpected journal line: " + s);
        }
        int v1 = s.indexOf(0x20, v + 1);
        if(v1 == -1) {
            s1 = s.substring(v + 1);
            if(v == 6 && s.startsWith("REMOVE")) {
                this.lruEntries.remove(s1);
                return;
            }
        }
        else {
            s1 = s.substring(v + 1, v1);
        }
        Entry diskLruCache$Entry0 = (Entry)this.lruEntries.get(s1);
        if(diskLruCache$Entry0 == null) {
            diskLruCache$Entry0 = new Entry(this, s1, null);
            this.lruEntries.put(s1, diskLruCache$Entry0);
        }
        if(v1 != -1 && v == 5 && s.startsWith("CLEAN")) {
            Entry.access$702(diskLruCache$Entry0, true);
            Entry.access$802(diskLruCache$Entry0, null);
            Entry.access$900(diskLruCache$Entry0, s.substring(v1 + 1).split(" "));
            return;
        }
        if(v1 == -1 && v == 5 && s.startsWith("DIRTY")) {
            Entry.access$802(diskLruCache$Entry0, new Editor(this, diskLruCache$Entry0, null));
            return;
        }
        if(v1 != -1 || v != 4 || !s.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + s);
        }
    }

    private void rebuildJournal() {
        synchronized(this) {
            Writer writer0 = this.journalWriter;
            if(writer0 != null) {
                DiskLruCache.closeWriter(writer0);
            }
            BufferedWriter bufferedWriter0 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), Util.US_ASCII));
            try {
                bufferedWriter0.write("libcore.io.DiskLruCache");
                bufferedWriter0.write("\n");
                bufferedWriter0.write("1");
                bufferedWriter0.write("\n");
                bufferedWriter0.write(Integer.toString(this.appVersion));
                bufferedWriter0.write("\n");
                bufferedWriter0.write(Integer.toString(this.valueCount));
                bufferedWriter0.write("\n");
                bufferedWriter0.write("\n");
                Iterator iterator0 = this.lruEntries.values().iterator();
                while(true) {
                    if(!iterator0.hasNext()) {
                        goto label_28;
                    }
                    Object object0 = iterator0.next();
                    Entry diskLruCache$Entry0 = (Entry)object0;
                    if(Entry.access$800(diskLruCache$Entry0) == null) {
                        bufferedWriter0.write("CLEAN " + Entry.access$1200(diskLruCache$Entry0) + diskLruCache$Entry0.getLengths() + '\n');
                    }
                    else {
                        bufferedWriter0.write("DIRTY " + Entry.access$1200(diskLruCache$Entry0) + '\n');
                    }
                }
            }
            catch(Throwable throwable0) {
            }
            DiskLruCache.closeWriter(bufferedWriter0);
            throw throwable0;
        label_28:
            DiskLruCache.closeWriter(bufferedWriter0);
            if(this.journalFile.exists()) {
                DiskLruCache.renameTo(this.journalFile, this.journalFileBackup, true);
            }
            DiskLruCache.renameTo(this.journalFileTmp, this.journalFile, false);
            this.journalFileBackup.delete();
            this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
        }
    }

    public boolean remove(String s) {
        synchronized(this) {
            this.checkNotClosed();
            Entry diskLruCache$Entry0 = (Entry)this.lruEntries.get(s);
            if(diskLruCache$Entry0 != null && Entry.access$800(diskLruCache$Entry0) == null) {
                for(int v1 = 0; v1 < this.valueCount; ++v1) {
                    File file0 = diskLruCache$Entry0.getCleanFile(v1);
                    if(file0.exists() && !file0.delete()) {
                        throw new IOException("failed to delete " + file0);
                    }
                    this.size -= Entry.access$1100(diskLruCache$Entry0)[v1];
                    Entry.access$1100(diskLruCache$Entry0)[v1] = 0L;
                }
                ++this.redundantOpCount;
                this.journalWriter.append("REMOVE");
                this.journalWriter.append(' ');
                this.journalWriter.append(s);
                this.journalWriter.append('\n');
                this.lruEntries.remove(s);
                if(this.journalRebuildRequired()) {
                    this.executorService.submit(this.cleanupCallable);
                }
                return true;
            }
            return false;
        }
    }

    private static void renameTo(File file0, File file1, boolean z) {
        if(z) {
            DiskLruCache.deleteIfExists(file1);
        }
        if(!file0.renameTo(file1)) {
            throw new IOException();
        }
    }

    public void setMaxSize(long v) {
        synchronized(this) {
            this.maxSize = v;
            this.executorService.submit(this.cleanupCallable);
        }
    }

    public long size() {
        synchronized(this) {
        }
        return this.size;
    }

    private void trimToSize() {
        while(this.size > this.maxSize) {
            Object object0 = this.lruEntries.entrySet().iterator().next();
            this.remove(((String)((Map.Entry)object0).getKey()));
        }
    }
}

