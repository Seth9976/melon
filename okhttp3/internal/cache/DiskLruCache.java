package okhttp3.internal.cache;

import Tf.n;
import Tf.o;
import Tf.v;
import d8.d;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010)\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001D\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b*\u0001j\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0004mnopB9\b\u0000\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\u0006\u0010\t\u001A\u00020\u0007\u0012\u0006\u0010\u000B\u001A\u00020\n\u0012\u0006\u0010\r\u001A\u00020\f\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\r\u0010\u0011\u001A\u00020\u0010\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0014\u001A\u00020\u0010H\u0000\u00A2\u0006\u0004\b\u0013\u0010\u0012J\u001E\u0010\u0018\u001A\b\u0018\u00010\u0017R\u00020\u00002\u0006\u0010\u0016\u001A\u00020\u0015H\u0086\u0002\u00A2\u0006\u0004\b\u0018\u0010\u0019J\'\u0010\u001C\u001A\b\u0018\u00010\u001BR\u00020\u00002\u0006\u0010\u0016\u001A\u00020\u00152\b\b\u0002\u0010\u001A\u001A\u00020\nH\u0007\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\r\u0010\u001E\u001A\u00020\n\u00A2\u0006\u0004\b\u001E\u0010\u001FJ#\u0010%\u001A\u00020\u00102\n\u0010 \u001A\u00060\u001BR\u00020\u00002\u0006\u0010\"\u001A\u00020!H\u0000\u00A2\u0006\u0004\b#\u0010$J\u0015\u0010&\u001A\u00020!2\u0006\u0010\u0016\u001A\u00020\u0015\u00A2\u0006\u0004\b&\u0010\'J\u001B\u0010,\u001A\u00020!2\n\u0010)\u001A\u00060(R\u00020\u0000H\u0000\u00A2\u0006\u0004\b*\u0010+J\u000F\u0010-\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b-\u0010\u0012J\r\u0010.\u001A\u00020!\u00A2\u0006\u0004\b.\u0010/J\u000F\u00100\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b0\u0010\u0012J\r\u00101\u001A\u00020\u0010\u00A2\u0006\u0004\b1\u0010\u0012J\r\u00102\u001A\u00020\u0010\u00A2\u0006\u0004\b2\u0010\u0012J\r\u00103\u001A\u00020\u0010\u00A2\u0006\u0004\b3\u0010\u0012J\u0017\u00105\u001A\f\u0012\b\u0012\u00060\u0017R\u00020\u000004\u00A2\u0006\u0004\b5\u00106J\u000F\u00107\u001A\u00020\u0010H\u0002\u00A2\u0006\u0004\b7\u0010\u0012J\u000F\u00109\u001A\u000208H\u0002\u00A2\u0006\u0004\b9\u0010:J\u0017\u0010<\u001A\u00020\u00102\u0006\u0010;\u001A\u00020\u0015H\u0002\u00A2\u0006\u0004\b<\u0010=J\u000F\u0010>\u001A\u00020\u0010H\u0002\u00A2\u0006\u0004\b>\u0010\u0012J\u000F\u0010?\u001A\u00020!H\u0002\u00A2\u0006\u0004\b?\u0010/J\u000F\u0010@\u001A\u00020\u0010H\u0002\u00A2\u0006\u0004\b@\u0010\u0012J\u000F\u0010A\u001A\u00020!H\u0002\u00A2\u0006\u0004\bA\u0010/J\u0017\u0010B\u001A\u00020\u00102\u0006\u0010\u0016\u001A\u00020\u0015H\u0002\u00A2\u0006\u0004\bB\u0010=R\u001A\u0010\u0004\u001A\u00020\u00038\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\u0004\u0010C\u001A\u0004\bD\u0010ER\u0017\u0010\u0006\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\u0006\u0010F\u001A\u0004\bG\u0010HR\u0014\u0010\b\u001A\u00020\u00078\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\b\u0010IR\u001A\u0010\t\u001A\u00020\u00078\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\t\u0010I\u001A\u0004\bJ\u0010KR*\u0010\u000B\u001A\u00020\n2\u0006\u0010L\u001A\u00020\n8F@FX\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u000B\u0010M\u001A\u0004\bN\u0010\u001F\"\u0004\bO\u0010PR\u0014\u0010Q\u001A\u00020\u00058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bQ\u0010FR\u0014\u0010R\u001A\u00020\u00058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bR\u0010FR\u0014\u0010S\u001A\u00020\u00058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bS\u0010FR\u0016\u0010\u001E\u001A\u00020\n8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u001E\u0010MR\u0018\u0010T\u001A\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bT\u0010UR*\u0010W\u001A\u0012\u0012\u0004\u0012\u00020\u0015\u0012\b\u0012\u00060(R\u00020\u00000V8\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\bW\u0010X\u001A\u0004\bY\u0010ZR\u0016\u0010[\u001A\u00020\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b[\u0010IR\u0016\u0010\\\u001A\u00020!8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010^\u001A\u00020!8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b^\u0010]R\u0016\u0010_\u001A\u00020!8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b_\u0010]R\"\u0010`\u001A\u00020!8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b`\u0010]\u001A\u0004\ba\u0010/\"\u0004\bb\u0010cR\u0016\u0010d\u001A\u00020!8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bd\u0010]R\u0016\u0010e\u001A\u00020!8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\be\u0010]R\u0016\u0010f\u001A\u00020\n8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bf\u0010MR\u0014\u0010h\u001A\u00020g8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010k\u001A\u00020j8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bk\u0010l\u00A8\u0006q"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "Lokhttp3/internal/io/FileSystem;", "fileSystem", "Ljava/io/File;", "directory", "", "appVersion", "valueCount", "", "maxSize", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "<init>", "(Lokhttp3/internal/io/FileSystem;Ljava/io/File;IIJLokhttp3/internal/concurrent/TaskRunner;)V", "Lie/H;", "initialize", "()V", "rebuildJournal$okhttp", "rebuildJournal", "", "key", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "get", "(Ljava/lang/String;)Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "expectedSequenceNumber", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "edit", "(Ljava/lang/String;J)Lokhttp3/internal/cache/DiskLruCache$Editor;", "size", "()J", "editor", "", "success", "completeEdit$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Editor;Z)V", "completeEdit", "remove", "(Ljava/lang/String;)Z", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "entry", "removeEntry$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Entry;)Z", "removeEntry", "flush", "isClosed", "()Z", "close", "trimToSize", "delete", "evictAll", "", "snapshots", "()Ljava/util/Iterator;", "readJournal", "Lokio/BufferedSink;", "newJournalWriter", "()Lokio/BufferedSink;", "line", "readJournalLine", "(Ljava/lang/String;)V", "processJournal", "journalRebuildRequired", "checkNotClosed", "removeOldestEntry", "validateKey", "Lokhttp3/internal/io/FileSystem;", "getFileSystem$okhttp", "()Lokhttp3/internal/io/FileSystem;", "Ljava/io/File;", "getDirectory", "()Ljava/io/File;", "I", "getValueCount$okhttp", "()I", "value", "J", "getMaxSize", "setMaxSize", "(J)V", "journalFile", "journalFileTmp", "journalFileBackup", "journalWriter", "Lokio/BufferedSink;", "Ljava/util/LinkedHashMap;", "lruEntries", "Ljava/util/LinkedHashMap;", "getLruEntries$okhttp", "()Ljava/util/LinkedHashMap;", "redundantOpCount", "hasJournalErrors", "Z", "civilizedFileSystem", "initialized", "closed", "getClosed$okhttp", "setClosed$okhttp", "(Z)V", "mostRecentTrimFailed", "mostRecentRebuildFailed", "nextSequenceNumber", "Lokhttp3/internal/concurrent/TaskQueue;", "cleanupQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "okhttp3/internal/cache/DiskLruCache$cleanupTask$1", "cleanupTask", "Lokhttp3/internal/cache/DiskLruCache$cleanupTask$1;", "Companion", "Editor", "Entry", "Snapshot", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class DiskLruCache implements Closeable, Flushable {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001A\u00020\u00048\u0006X\u0087D¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001A\u00020\u00078\u0006X\u0087D¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u00020\u00078\u0006X\u0087D¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000B\u001A\u00020\u00078\u0006X\u0087D¢\u0006\u0006\n\u0004\b\u000B\u0010\tR\u0014\u0010\f\u001A\u00020\u00078\u0006X\u0087D¢\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001A\u00020\u00078\u0006X\u0087D¢\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000F\u001A\u00020\u000E8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0011\u001A\u00020\u00078\u0006X\u0087D¢\u0006\u0006\n\u0004\b\u0011\u0010\tR\u0014\u0010\u0012\u001A\u00020\u00078\u0006X\u0087D¢\u0006\u0006\n\u0004\b\u0012\u0010\tR\u0014\u0010\u0013\u001A\u00020\u00078\u0006X\u0087D¢\u0006\u0006\n\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001A\u00020\u00078\u0006X\u0087D¢\u0006\u0006\n\u0004\b\u0014\u0010\t¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Companion;", "", "<init>", "()V", "", "ANY_SEQUENCE_NUMBER", "J", "", "CLEAN", "Ljava/lang/String;", "DIRTY", "JOURNAL_FILE", "JOURNAL_FILE_BACKUP", "JOURNAL_FILE_TEMP", "LTf/n;", "LEGAL_KEY_PATTERN", "LTf/n;", "MAGIC", "READ", "REMOVE", "VERSION_1", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0018\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\n\u0010\u0004\u001A\u00060\u0002R\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\n\u001A\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000E\u001A\u0004\u0018\u00010\r2\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\u000E\u0010\u000FJ\u0015\u0010\u0011\u001A\u00020\u00102\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001A\u00020\u0007¢\u0006\u0004\b\u0013\u0010\tJ\r\u0010\u0014\u001A\u00020\u0007¢\u0006\u0004\b\u0014\u0010\tR\u001E\u0010\u0004\u001A\u00060\u0002R\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017R\u001C\u0010\u0019\u001A\u0004\u0018\u00010\u00188\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001CR\u0016\u0010\u001E\u001A\u00020\u001D8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001E\u0010\u001F¨\u0006 "}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Editor;", "", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "Lokhttp3/internal/cache/DiskLruCache;", "entry", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Lokhttp3/internal/cache/DiskLruCache$Entry;)V", "Lie/H;", "detach$okhttp", "()V", "detach", "", "index", "Lokio/Source;", "newSource", "(I)Lokio/Source;", "Lokio/Sink;", "newSink", "(I)Lokio/Sink;", "commit", "abort", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "getEntry$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Entry;", "", "written", "[Z", "getWritten$okhttp", "()[Z", "", "done", "Z", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public final class Editor {
        private boolean done;
        @NotNull
        private final Entry entry;
        @Nullable
        private final boolean[] written;

        public Editor(@NotNull Entry diskLruCache$Entry0) {
            q.g(diskLruCache$Entry0, "entry");
            DiskLruCache.this = diskLruCache0;
            super();
            this.entry = diskLruCache$Entry0;
            this.written = diskLruCache$Entry0.getReadable$okhttp() ? null : new boolean[diskLruCache0.getValueCount$okhttp()];
        }

        public final void abort() {
            DiskLruCache diskLruCache0 = DiskLruCache.this;
            synchronized(diskLruCache0) {
                if(!this.done) {
                    if(q.b(this.entry.getCurrentEditor$okhttp(), this)) {
                        diskLruCache0.completeEdit$okhttp(this, false);
                    }
                    this.done = true;
                    return;
                }
            }
            throw new IllegalStateException("Check failed.");
        }

        public final void commit() {
            DiskLruCache diskLruCache0 = DiskLruCache.this;
            synchronized(diskLruCache0) {
                if(!this.done) {
                    if(q.b(this.entry.getCurrentEditor$okhttp(), this)) {
                        diskLruCache0.completeEdit$okhttp(this, true);
                    }
                    this.done = true;
                    return;
                }
            }
            throw new IllegalStateException("Check failed.");
        }

        public final void detach$okhttp() {
            if(q.b(this.entry.getCurrentEditor$okhttp(), this)) {
                if(DiskLruCache.this.civilizedFileSystem) {
                    DiskLruCache.this.completeEdit$okhttp(this, false);
                    return;
                }
                this.entry.setZombie$okhttp(true);
            }
        }

        @NotNull
        public final Entry getEntry$okhttp() {
            return this.entry;
        }

        @Nullable
        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        @NotNull
        public final Sink newSink(int v) {
            Sink sink1;
            DiskLruCache diskLruCache0 = DiskLruCache.this;
            synchronized(diskLruCache0) {
                if(!this.done) {
                    if(!q.b(this.entry.getCurrentEditor$okhttp(), this)) {
                        return Okio.blackhole();
                    }
                    if(!this.entry.getReadable$okhttp()) {
                        q.d(this.written);
                        this.written[v] = true;
                    }
                    File file0 = (File)this.entry.getDirtyFiles$okhttp().get(v);
                    try {
                        sink1 = diskLruCache0.getFileSystem$okhttp().sink(file0);
                    }
                    catch(FileNotFoundException unused_ex) {
                        return Okio.blackhole();
                    }
                    return new FaultHidingSink(sink1, new k(this) {
                        {
                            DiskLruCache.this = diskLruCache0;
                            Editor.this = diskLruCache$Editor0;
                            super(1);
                        }

                        @Override  // we.k
                        public Object invoke(Object object0) {
                            this.invoke(((IOException)object0));
                            return H.a;
                        }

                        public final void invoke(@NotNull IOException iOException0) {
                            q.g(iOException0, "it");
                            synchronized(DiskLruCache.this) {
                                Editor.this.detach$okhttp();
                            }
                        }
                    });
                }
            }
            throw new IllegalStateException("Check failed.");
        }

        @Nullable
        public final Source newSource(int v) {
            Source source0 = null;
            DiskLruCache diskLruCache0 = DiskLruCache.this;
            synchronized(diskLruCache0) {
                if(!this.done) {
                    if(this.entry.getReadable$okhttp() && q.b(this.entry.getCurrentEditor$okhttp(), this) && !this.entry.getZombie$okhttp()) {
                        try {
                            source0 = diskLruCache0.getFileSystem$okhttp().source(((File)this.entry.getCleanFiles$okhttp().get(v)));
                        }
                        catch(FileNotFoundException unused_ex) {
                        }
                        return source0;
                    }
                    return null;
                }
            }
            throw new IllegalStateException("Check failed.");
        }
    }

    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0007\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u001D\u0010\t\u001A\u00020\b2\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002\u00A2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u001D\u0010\u0013\u001A\u00020\u00102\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0000\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0018\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u00020\u0014H\u0000\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001D\u001A\b\u0018\u00010\u0019R\u00020\u001AH\u0000\u00A2\u0006\u0004\b\u001B\u0010\u001CR\u001A\u0010\u0003\u001A\u00020\u00028\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\u0003\u0010\u001E\u001A\u0004\b\u001F\u0010 R\u001A\u0010\"\u001A\u00020!8\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\"\u0010#\u001A\u0004\b$\u0010%R \u0010(\u001A\b\u0012\u0004\u0012\u00020\'0&8\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b(\u0010)\u001A\u0004\b*\u0010+R \u0010,\u001A\b\u0012\u0004\u0012\u00020\'0&8\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b,\u0010)\u001A\u0004\b-\u0010+R\"\u0010/\u001A\u00020.8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b/\u00100\u001A\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00105\u001A\u00020.8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b5\u00100\u001A\u0004\b6\u00102\"\u0004\b7\u00104R(\u00109\u001A\b\u0018\u000108R\u00020\u001A8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b9\u0010:\u001A\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010?\u001A\u00020\u000B8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b?\u0010@\u001A\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010F\u001A\u00020E8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\bF\u0010G\u001A\u0004\bH\u0010I\"\u0004\bJ\u0010K\u00A8\u0006L"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Entry;", "", "", "key", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;)V", "", "strings", "", "invalidLengths", "(Ljava/util/List;)Ljava/lang/Void;", "", "index", "Lokio/Source;", "newSource", "(I)Lokio/Source;", "Lie/H;", "setLengths$okhttp", "(Ljava/util/List;)V", "setLengths", "Lokio/BufferedSink;", "writer", "writeLengths$okhttp", "(Lokio/BufferedSink;)V", "writeLengths", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "snapshot$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "snapshot", "Ljava/lang/String;", "getKey$okhttp", "()Ljava/lang/String;", "", "lengths", "[J", "getLengths$okhttp", "()[J", "", "Ljava/io/File;", "cleanFiles", "Ljava/util/List;", "getCleanFiles$okhttp", "()Ljava/util/List;", "dirtyFiles", "getDirtyFiles$okhttp", "", "readable", "Z", "getReadable$okhttp", "()Z", "setReadable$okhttp", "(Z)V", "zombie", "getZombie$okhttp", "setZombie$okhttp", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "currentEditor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "getCurrentEditor$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Editor;", "setCurrentEditor$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "lockingSourceCount", "I", "getLockingSourceCount$okhttp", "()I", "setLockingSourceCount$okhttp", "(I)V", "", "sequenceNumber", "J", "getSequenceNumber$okhttp", "()J", "setSequenceNumber$okhttp", "(J)V", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public final class Entry {
        @NotNull
        private final List cleanFiles;
        @Nullable
        private Editor currentEditor;
        @NotNull
        private final List dirtyFiles;
        @NotNull
        private final String key;
        @NotNull
        private final long[] lengths;
        private int lockingSourceCount;
        private boolean readable;
        private long sequenceNumber;
        private boolean zombie;

        public Entry(@NotNull String s) {
            q.g(s, "key");
            DiskLruCache.this = diskLruCache0;
            super();
            this.key = s;
            this.lengths = new long[diskLruCache0.getValueCount$okhttp()];
            this.cleanFiles = new ArrayList();
            this.dirtyFiles = new ArrayList();
            StringBuilder stringBuilder0 = new StringBuilder(s);
            stringBuilder0.append('.');
            int v = stringBuilder0.length();
            int v1 = diskLruCache0.getValueCount$okhttp();
            for(int v2 = 0; v2 < v1; ++v2) {
                stringBuilder0.append(v2);
                File file0 = new File(DiskLruCache.this.getDirectory(), stringBuilder0.toString());
                this.cleanFiles.add(file0);
                stringBuilder0.append(".tmp");
                File file1 = new File(DiskLruCache.this.getDirectory(), stringBuilder0.toString());
                this.dirtyFiles.add(file1);
                stringBuilder0.setLength(v);
            }
        }

        @NotNull
        public final List getCleanFiles$okhttp() {
            return this.cleanFiles;
        }

        @Nullable
        public final Editor getCurrentEditor$okhttp() {
            return this.currentEditor;
        }

        @NotNull
        public final List getDirtyFiles$okhttp() {
            return this.dirtyFiles;
        }

        @NotNull
        public final String getKey$okhttp() {
            return this.key;
        }

        @NotNull
        public final long[] getLengths$okhttp() {
            return this.lengths;
        }

        public final int getLockingSourceCount$okhttp() {
            return this.lockingSourceCount;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final boolean getZombie$okhttp() {
            return this.zombie;
        }

        private final Void invalidLengths(List list0) {
            throw new IOException("unexpected journal line: " + list0);
        }

        private final Source newSource(int v) {
            Source source0 = DiskLruCache.this.getFileSystem$okhttp().source(((File)this.cleanFiles.get(v)));
            if(DiskLruCache.this.civilizedFileSystem) {
                return source0;
            }
            ++this.lockingSourceCount;
            return new ForwardingSource(DiskLruCache.this) {
                private boolean closed;

                @Override  // okio.ForwardingSource
                public void close() {
                    super.close();
                    if(!this.closed) {
                        this.closed = true;
                        DiskLruCache diskLruCache0 = this;
                        Entry diskLruCache$Entry0 = Entry.this;
                        synchronized(diskLruCache0) {
                            diskLruCache$Entry0.setLockingSourceCount$okhttp(diskLruCache$Entry0.getLockingSourceCount$okhttp() - 1);
                            if(diskLruCache$Entry0.getLockingSourceCount$okhttp() == 0 && diskLruCache$Entry0.getZombie$okhttp()) {
                                diskLruCache0.removeEntry$okhttp(diskLruCache$Entry0);
                            }
                        }
                    }
                }
            };
        }

        public final void setCurrentEditor$okhttp(@Nullable Editor diskLruCache$Editor0) {
            this.currentEditor = diskLruCache$Editor0;
        }

        public final void setLengths$okhttp(@NotNull List list0) {
            q.g(list0, "strings");
            if(list0.size() == DiskLruCache.this.getValueCount$okhttp()) {
                try {
                    int v = list0.size();
                    for(int v1 = 0; v1 < v; ++v1) {
                        this.lengths[v1] = Long.parseLong(((String)list0.get(v1)));
                    }
                    return;
                }
                catch(NumberFormatException unused_ex) {
                    this.invalidLengths(list0);
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
            this.invalidLengths(list0);
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }

        public final void setLockingSourceCount$okhttp(int v) {
            this.lockingSourceCount = v;
        }

        public final void setReadable$okhttp(boolean z) {
            this.readable = z;
        }

        public final void setSequenceNumber$okhttp(long v) {
            this.sequenceNumber = v;
        }

        public final void setZombie$okhttp(boolean z) {
            this.zombie = z;
        }

        @Nullable
        public final Snapshot snapshot$okhttp() {
            DiskLruCache diskLruCache0 = DiskLruCache.this;
            if(Util.assertionsEnabled && !Thread.holdsLock(diskLruCache0)) {
                throw new AssertionError("Thread jeb-dexdec-sb-st-2486 MUST hold lock on " + diskLruCache0);
            }
            if(!this.readable) {
                return null;
            }
            if(!DiskLruCache.this.civilizedFileSystem && (this.currentEditor != null || this.zombie)) {
                return null;
            }
            ArrayList arrayList0 = new ArrayList();
            long[] arr_v = (long[])this.lengths.clone();
            try {
                int v = DiskLruCache.this.getValueCount$okhttp();
                for(int v1 = 0; v1 < v; ++v1) {
                    arrayList0.add(this.newSource(v1));
                }
                return new Snapshot(DiskLruCache.this, this.key, this.sequenceNumber, arrayList0, arr_v);
            }
            catch(FileNotFoundException unused_ex) {
                for(Object object0: arrayList0) {
                    Util.closeQuietly(((Source)object0));
                }
                try {
                    DiskLruCache.this.removeEntry$okhttp(this);
                }
                catch(IOException unused_ex) {
                }
                return null;
            }
        }

        public final void writeLengths$okhttp(@NotNull BufferedSink bufferedSink0) {
            q.g(bufferedSink0, "writer");
            long[] arr_v = this.lengths;
            for(int v = 0; v < arr_v.length; ++v) {
                long v1 = arr_v[v];
                bufferedSink0.writeByte(0x20).writeDecimalLong(v1);
            }
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B/\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u000B\u0010\fJ\r\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0003\u0010\rJ\u0013\u0010\u0010\u001A\b\u0018\u00010\u000ER\u00020\u000F¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001A\u00020\u00042\u0006\u0010\u0013\u001A\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0019\u001A\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001AR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001BR\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001CR\u001A\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001DR\u0014\u0010\n\u001A\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001E¨\u0006\u001F"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Ljava/io/Closeable;", "", "key", "", "sequenceNumber", "", "Lokio/Source;", "sources", "", "lengths", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;JLjava/util/List;[J)V", "()Ljava/lang/String;", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "edit", "()Lokhttp3/internal/cache/DiskLruCache$Editor;", "", "index", "getSource", "(I)Lokio/Source;", "getLength", "(I)J", "Lie/H;", "close", "()V", "Ljava/lang/String;", "J", "Ljava/util/List;", "[J", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public final class Snapshot implements Closeable {
        @NotNull
        private final String key;
        @NotNull
        private final long[] lengths;
        private final long sequenceNumber;
        @NotNull
        private final List sources;

        public Snapshot(@NotNull String s, long v, @NotNull List list0, @NotNull long[] arr_v) {
            q.g(s, "key");
            q.g(list0, "sources");
            q.g(arr_v, "lengths");
            DiskLruCache.this = diskLruCache0;
            super();
            this.key = s;
            this.sequenceNumber = v;
            this.sources = list0;
            this.lengths = arr_v;
        }

        @Override
        public void close() {
            for(Object object0: this.sources) {
                Util.closeQuietly(((Source)object0));
            }
        }

        @Nullable
        public final Editor edit() {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public final long getLength(int v) {
            return this.lengths[v];
        }

        @NotNull
        public final Source getSource(int v) {
            return (Source)this.sources.get(v);
        }

        @NotNull
        public final String key() {
            return this.key;
        }
    }

    public static final long ANY_SEQUENCE_NUMBER;
    @NotNull
    public static final String CLEAN;
    @NotNull
    public static final Companion Companion;
    @NotNull
    public static final String DIRTY;
    @NotNull
    public static final String JOURNAL_FILE;
    @NotNull
    public static final String JOURNAL_FILE_BACKUP;
    @NotNull
    public static final String JOURNAL_FILE_TEMP;
    @NotNull
    public static final n LEGAL_KEY_PATTERN;
    @NotNull
    public static final String MAGIC;
    @NotNull
    public static final String READ;
    @NotNull
    public static final String REMOVE;
    @NotNull
    public static final String VERSION_1;
    private final int appVersion;
    private boolean civilizedFileSystem;
    @NotNull
    private final TaskQueue cleanupQueue;
    @NotNull
    private final okhttp3.internal.cache.DiskLruCache.cleanupTask.1 cleanupTask;
    private boolean closed;
    @NotNull
    private final File directory;
    @NotNull
    private final FileSystem fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    @NotNull
    private final File journalFile;
    @NotNull
    private final File journalFileBackup;
    @NotNull
    private final File journalFileTmp;
    @Nullable
    private BufferedSink journalWriter;
    @NotNull
    private final LinkedHashMap lruEntries;
    private long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;

    static {
        DiskLruCache.Companion = new Companion(null);
        DiskLruCache.JOURNAL_FILE = "journal";
        DiskLruCache.JOURNAL_FILE_TEMP = "journal.tmp";
        DiskLruCache.JOURNAL_FILE_BACKUP = "journal.bkp";
        DiskLruCache.MAGIC = "libcore.io.DiskLruCache";
        DiskLruCache.VERSION_1 = "1";
        DiskLruCache.ANY_SEQUENCE_NUMBER = -1L;
        DiskLruCache.LEGAL_KEY_PATTERN = new n("[a-z0-9_-]{1,120}");
        DiskLruCache.CLEAN = "CLEAN";
        DiskLruCache.DIRTY = "DIRTY";
        DiskLruCache.REMOVE = "REMOVE";
        DiskLruCache.READ = "READ";
    }

    public DiskLruCache(@NotNull FileSystem fileSystem0, @NotNull File file0, int v, int v1, long v2, @NotNull TaskRunner taskRunner0) {
        q.g(fileSystem0, "fileSystem");
        q.g(file0, "directory");
        q.g(taskRunner0, "taskRunner");
        super();
        this.fileSystem = fileSystem0;
        this.directory = file0;
        this.appVersion = v;
        this.valueCount = v1;
        this.maxSize = v2;
        this.lruEntries = new LinkedHashMap(0, 0.75f, true);
        this.cleanupQueue = taskRunner0.newQueue();
        this.cleanupTask = new Task("OkHttp Cache") {
            {
                DiskLruCache.this = diskLruCache0;
                super(s, false, 2, null);
            }

            @Override  // okhttp3.internal.concurrent.Task
            public long runOnce() {
                DiskLruCache diskLruCache0 = DiskLruCache.this;
                synchronized(diskLruCache0) {
                    if(diskLruCache0.initialized && !diskLruCache0.getClosed$okhttp()) {
                        try {
                            diskLruCache0.trimToSize();
                        }
                        catch(IOException unused_ex) {
                            diskLruCache0.mostRecentTrimFailed = true;
                        }
                        try {
                            if(diskLruCache0.journalRebuildRequired()) {
                                diskLruCache0.rebuildJournal$okhttp();
                                diskLruCache0.redundantOpCount = 0;
                            }
                        }
                        catch(IOException unused_ex) {
                            diskLruCache0.mostRecentRebuildFailed = true;
                            diskLruCache0.journalWriter = Okio.buffer(Okio.blackhole());
                        }
                        return -1L;
                    }
                    return -1L;
                }
            }
        };
        if(v2 <= 0L) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if(v1 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        this.journalFile = new File(file0, "journal");
        this.journalFileTmp = new File(file0, "journal.tmp");
        this.journalFileBackup = new File(file0, "journal.bkp");
    }

    private final void checkNotClosed() {
        synchronized(this) {
            if(!this.closed) {
                return;
            }
        }
        throw new IllegalStateException("cache is closed");
    }

    @Override
    public void close() {
        synchronized(this) {
            if(this.initialized && !this.closed) {
                Collection collection0 = this.lruEntries.values();
                q.f(collection0, "lruEntries.values");
                Entry[] arr_diskLruCache$Entry = (Entry[])collection0.toArray(new Entry[0]);
                for(int v1 = 0; v1 < arr_diskLruCache$Entry.length; ++v1) {
                    Entry diskLruCache$Entry0 = arr_diskLruCache$Entry[v1];
                    if(diskLruCache$Entry0.getCurrentEditor$okhttp() != null) {
                        Editor diskLruCache$Editor0 = diskLruCache$Entry0.getCurrentEditor$okhttp();
                        if(diskLruCache$Editor0 != null) {
                            diskLruCache$Editor0.detach$okhttp();
                        }
                    }
                }
                this.trimToSize();
                BufferedSink bufferedSink0 = this.journalWriter;
                q.d(bufferedSink0);
                bufferedSink0.close();
                this.journalWriter = null;
                this.closed = true;
                return;
            }
            this.closed = true;
        }
    }

    public final void completeEdit$okhttp(@NotNull Editor diskLruCache$Editor0, boolean z) {
        Entry diskLruCache$Entry0;
        synchronized(this) {
            q.g(diskLruCache$Editor0, "editor");
            diskLruCache$Entry0 = diskLruCache$Editor0.getEntry$okhttp();
            if(!q.b(diskLruCache$Entry0.getCurrentEditor$okhttp(), diskLruCache$Editor0)) {
                throw new IllegalStateException("Check failed.");
            }
            if(z && !diskLruCache$Entry0.getReadable$okhttp()) {
                int v1 = this.valueCount;
                int v2 = 0;
                while(true) {
                    if(v2 >= v1) {
                        break;
                    }
                    boolean[] arr_z = diskLruCache$Editor0.getWritten$okhttp();
                    q.d(arr_z);
                    if(!arr_z[v2]) {
                        diskLruCache$Editor0.abort();
                        throw new IllegalStateException("Newly created entry didn\'t create value for index " + v2);
                    }
                    File file0 = (File)diskLruCache$Entry0.getDirtyFiles$okhttp().get(v2);
                    if(this.fileSystem.exists(file0)) {
                        ++v2;
                        continue;
                    }
                    diskLruCache$Editor0.abort();
                    return;
                }
            }
            goto label_22;
        }
        return;
    label_22:
        int v3 = this.valueCount;
        for(int v = 0; v < v3; ++v) {
            File file1 = (File)diskLruCache$Entry0.getDirtyFiles$okhttp().get(v);
            if(!z || diskLruCache$Entry0.getZombie$okhttp()) {
                this.fileSystem.delete(file1);
            }
            else if(this.fileSystem.exists(file1)) {
                File file2 = (File)diskLruCache$Entry0.getCleanFiles$okhttp().get(v);
                this.fileSystem.rename(file1, file2);
                long v4 = diskLruCache$Entry0.getLengths$okhttp()[v];
                long v5 = this.fileSystem.size(file2);
                diskLruCache$Entry0.getLengths$okhttp()[v] = v5;
                this.size = this.size - v4 + v5;
            }
        }
        diskLruCache$Entry0.setCurrentEditor$okhttp(null);
        if(!diskLruCache$Entry0.getZombie$okhttp()) {
            ++this.redundantOpCount;
            BufferedSink bufferedSink0 = this.journalWriter;
            q.d(bufferedSink0);
            if(diskLruCache$Entry0.getReadable$okhttp() || z) {
                diskLruCache$Entry0.setReadable$okhttp(true);
                bufferedSink0.writeUtf8("CLEAN").writeByte(0x20);
                bufferedSink0.writeUtf8(diskLruCache$Entry0.getKey$okhttp());
                diskLruCache$Entry0.writeLengths$okhttp(bufferedSink0);
                bufferedSink0.writeByte(10);
                if(z) {
                    long v6 = this.nextSequenceNumber;
                    this.nextSequenceNumber = v6 + 1L;
                    diskLruCache$Entry0.setSequenceNumber$okhttp(v6);
                }
            }
            else {
                this.lruEntries.remove(diskLruCache$Entry0.getKey$okhttp());
                bufferedSink0.writeUtf8("REMOVE").writeByte(0x20);
                bufferedSink0.writeUtf8(diskLruCache$Entry0.getKey$okhttp());
                bufferedSink0.writeByte(10);
            }
            bufferedSink0.flush();
            if(this.size > this.maxSize || this.journalRebuildRequired()) {
                TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            }
            return;
        }
        this.removeEntry$okhttp(diskLruCache$Entry0);
    }

    public final void delete() {
        this.close();
        this.fileSystem.deleteContents(this.directory);
    }

    @Nullable
    public final Editor edit(@NotNull String s) {
        q.g(s, "key");
        return DiskLruCache.edit$default(this, s, 0L, 2, null);
    }

    @Nullable
    public final Editor edit(@NotNull String s, long v) {
        Editor diskLruCache$Editor1;
        Editor diskLruCache$Editor0;
        Entry diskLruCache$Entry0;
        synchronized(this) {
            q.g(s, "key");
            this.initialize();
            this.checkNotClosed();
            this.validateKey(s);
            diskLruCache$Entry0 = (Entry)this.lruEntries.get(s);
            if(Long.compare(v, DiskLruCache.ANY_SEQUENCE_NUMBER) != 0 && (diskLruCache$Entry0 == null || diskLruCache$Entry0.getSequenceNumber$okhttp() != v)) {
                return null;
            }
            goto label_9;
        }
        return null;
    label_9:
        diskLruCache$Editor0 = diskLruCache$Entry0 == null ? null : diskLruCache$Entry0.getCurrentEditor$okhttp();
        if(diskLruCache$Editor0 != null) {
            return null;
        }
        if(diskLruCache$Entry0 != null && diskLruCache$Entry0.getLockingSourceCount$okhttp() != 0) {
            return null;
        }
        else if(!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
            BufferedSink bufferedSink0 = this.journalWriter;
            q.d(bufferedSink0);
            bufferedSink0.writeUtf8("DIRTY").writeByte(0x20).writeUtf8(s).writeByte(10);
            bufferedSink0.flush();
            if(!this.hasJournalErrors) {
                if(diskLruCache$Entry0 == null) {
                    diskLruCache$Entry0 = new Entry(this, s);
                    this.lruEntries.put(s, diskLruCache$Entry0);
                }
                diskLruCache$Editor1 = new Editor(this, diskLruCache$Entry0);
                diskLruCache$Entry0.setCurrentEditor$okhttp(diskLruCache$Editor1);
                return diskLruCache$Editor1;
            }
            return null;
        }
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        return null;
    }

    public static Editor edit$default(DiskLruCache diskLruCache0, String s, long v, int v1, Object object0) {
        if((v1 & 2) != 0) {
            v = DiskLruCache.ANY_SEQUENCE_NUMBER;
        }
        return diskLruCache0.edit(s, v);
    }

    public final void evictAll() {
        synchronized(this) {
            this.initialize();
            Collection collection0 = this.lruEntries.values();
            q.f(collection0, "lruEntries.values");
            Entry[] arr_diskLruCache$Entry = (Entry[])collection0.toArray(new Entry[0]);
            for(int v1 = 0; v1 < arr_diskLruCache$Entry.length; ++v1) {
                Entry diskLruCache$Entry0 = arr_diskLruCache$Entry[v1];
                q.f(diskLruCache$Entry0, "entry");
                this.removeEntry$okhttp(diskLruCache$Entry0);
            }
            this.mostRecentTrimFailed = false;
        }
    }

    @Override
    public void flush() {
        synchronized(this) {
            if(!this.initialized) {
                return;
            }
            this.checkNotClosed();
            this.trimToSize();
            BufferedSink bufferedSink0 = this.journalWriter;
            q.d(bufferedSink0);
            bufferedSink0.flush();
        }
    }

    @Nullable
    public final Snapshot get(@NotNull String s) {
        Snapshot diskLruCache$Snapshot0;
        synchronized(this) {
            q.g(s, "key");
            this.initialize();
            this.checkNotClosed();
            this.validateKey(s);
            Entry diskLruCache$Entry0 = (Entry)this.lruEntries.get(s);
            if(diskLruCache$Entry0 != null) {
                diskLruCache$Snapshot0 = diskLruCache$Entry0.snapshot$okhttp();
                if(diskLruCache$Snapshot0 != null) {
                    ++this.redundantOpCount;
                    BufferedSink bufferedSink0 = this.journalWriter;
                    q.d(bufferedSink0);
                    bufferedSink0.writeUtf8("READ").writeByte(0x20).writeUtf8(s).writeByte(10);
                    if(this.journalRebuildRequired()) {
                        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
                    }
                    return diskLruCache$Snapshot0;
                }
                return null;
            }
            return null;
        }
        return diskLruCache$Snapshot0;
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    @NotNull
    public final File getDirectory() {
        return this.directory;
    }

    @NotNull
    public final FileSystem getFileSystem$okhttp() {
        return this.fileSystem;
    }

    @NotNull
    public final LinkedHashMap getLruEntries$okhttp() {
        return this.lruEntries;
    }

    public final long getMaxSize() {
        synchronized(this) {
        }
        return this.maxSize;
    }

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    public final void initialize() {
        synchronized(this) {
            if(Util.assertionsEnabled && !Thread.holdsLock(this)) {
                throw new AssertionError("Thread jeb-dexdec-sb-st-2497 MUST hold lock on " + this);
            }
            if(this.initialized) {
                return;
            }
            if(this.fileSystem.exists(this.journalFileBackup)) {
                if(this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.delete(this.journalFileBackup);
                }
                else {
                    this.fileSystem.rename(this.journalFileBackup, this.journalFile);
                }
            }
            this.civilizedFileSystem = Util.isCivilized(this.fileSystem, this.journalFileBackup);
            if(this.fileSystem.exists(this.journalFile)) {
                try {
                    this.readJournal();
                    this.processJournal();
                    this.initialized = true;
                    return;
                }
                catch(IOException iOException0) {
                    Platform.Companion.get().log("DiskLruCache " + this.directory + " is corrupt: " + iOException0.getMessage() + ", removing", 5, iOException0);
                    try {
                        this.delete();
                        this.closed = false;
                    }
                    catch(Throwable throwable0) {
                        this.closed = false;
                        throw throwable0;
                    }
                }
            }
            this.rebuildJournal$okhttp();
            this.initialized = true;
        }
    }

    public final boolean isClosed() {
        synchronized(this) {
        }
        return this.closed;
    }

    private final boolean journalRebuildRequired() {
        return this.redundantOpCount >= 2000 && this.redundantOpCount >= this.lruEntries.size();
    }

    private final BufferedSink newJournalWriter() {
        return Okio.buffer(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new k() {
            {
                DiskLruCache.this = diskLruCache0;
                super(1);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((IOException)object0));
                return H.a;
            }

            public final void invoke(@NotNull IOException iOException0) {
                q.g(iOException0, "it");
                DiskLruCache diskLruCache0 = DiskLruCache.this;
                if(Util.assertionsEnabled && !Thread.holdsLock(diskLruCache0)) {
                    throw new AssertionError("Thread jeb-dexdec-sb-st-2469 MUST hold lock on " + diskLruCache0);
                }
                DiskLruCache.this.hasJournalErrors = true;
            }
        }));
    }

    private final void processJournal() {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator iterator0 = this.lruEntries.values().iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            q.f(object0, "i.next()");
            Entry diskLruCache$Entry0 = (Entry)object0;
            int v = 0;
            if(diskLruCache$Entry0.getCurrentEditor$okhttp() == null) {
                int v1 = this.valueCount;
                while(v < v1) {
                    this.size += diskLruCache$Entry0.getLengths$okhttp()[v];
                    ++v;
                }
            }
            else {
                diskLruCache$Entry0.setCurrentEditor$okhttp(null);
                int v2 = this.valueCount;
                while(v < v2) {
                    File file0 = (File)diskLruCache$Entry0.getCleanFiles$okhttp().get(v);
                    this.fileSystem.delete(file0);
                    File file1 = (File)diskLruCache$Entry0.getDirtyFiles$okhttp().get(v);
                    this.fileSystem.delete(file1);
                    ++v;
                }
                iterator0.remove();
            }
        }
    }

    private final void readJournal() {
        BufferedSource bufferedSource0 = Okio.buffer(this.fileSystem.source(this.journalFile));
        try {
            String s = bufferedSource0.readUtf8LineStrict();
            String s1 = bufferedSource0.readUtf8LineStrict();
            String s2 = bufferedSource0.readUtf8LineStrict();
            String s3 = bufferedSource0.readUtf8LineStrict();
            String s4 = bufferedSource0.readUtf8LineStrict();
            if(!q.b("libcore.io.DiskLruCache", s) || !q.b("1", s1) || !q.b(String.valueOf(this.appVersion), s2) || !q.b(String.valueOf(this.valueCount), s3) || s4.length() > 0) {
                throw new IOException("unexpected journal header: [" + s + ", " + s1 + ", " + s3 + ", " + s4 + ']');
            }
            int v = 0;
            try {
                while(true) {
                    this.readJournalLine(bufferedSource0.readUtf8LineStrict());
                    ++v;
                }
            }
            catch(EOFException unused_ex) {
            }
            this.redundantOpCount = v - this.lruEntries.size();
            if(bufferedSource0.exhausted()) {
                this.journalWriter = this.newJournalWriter();
            }
            else {
                this.rebuildJournal$okhttp();
            }
        }
        catch(Throwable throwable0) {
            d.l(bufferedSource0, throwable0);
            throw throwable0;
        }
        d.l(bufferedSource0, null);
    }

    private final void readJournalLine(String s) {
        String s1;
        int v = o.E0(s, ' ', 0, 6);
        if(v == -1) {
            throw new IOException("unexpected journal line: " + s);
        }
        int v1 = o.E0(s, ' ', v + 1, 4);
        if(v1 == -1) {
            s1 = s.substring(v + 1);
            q.f(s1, "this as java.lang.String).substring(startIndex)");
            if(v == 6 && v.r0(s, "REMOVE", false)) {
                this.lruEntries.remove(s1);
                return;
            }
        }
        else {
            s1 = s.substring(v + 1, v1);
            q.f(s1, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        Entry diskLruCache$Entry0 = (Entry)this.lruEntries.get(s1);
        if(diskLruCache$Entry0 == null) {
            diskLruCache$Entry0 = new Entry(this, s1);
            this.lruEntries.put(s1, diskLruCache$Entry0);
        }
        if(v1 != -1 && v == 5 && v.r0(s, "CLEAN", false)) {
            String s2 = s.substring(v1 + 1);
            q.f(s2, "this as java.lang.String).substring(startIndex)");
            List list0 = o.S0(s2, new char[]{' '});
            diskLruCache$Entry0.setReadable$okhttp(true);
            diskLruCache$Entry0.setCurrentEditor$okhttp(null);
            diskLruCache$Entry0.setLengths$okhttp(list0);
            return;
        }
        if(v1 == -1 && v == 5 && v.r0(s, "DIRTY", false)) {
            diskLruCache$Entry0.setCurrentEditor$okhttp(new Editor(this, diskLruCache$Entry0));
            return;
        }
        if(v1 != -1 || v != 4 || !v.r0(s, "READ", false)) {
            throw new IOException("unexpected journal line: " + s);
        }
    }

    public final void rebuildJournal$okhttp() {
        synchronized(this) {
            BufferedSink bufferedSink0 = this.journalWriter;
            if(bufferedSink0 != null) {
                bufferedSink0.close();
            }
            BufferedSink bufferedSink1 = Okio.buffer(this.fileSystem.sink(this.journalFileTmp));
            try {
                bufferedSink1.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
                bufferedSink1.writeUtf8("1").writeByte(10);
                bufferedSink1.writeDecimalLong(((long)this.appVersion)).writeByte(10);
                bufferedSink1.writeDecimalLong(((long)this.valueCount)).writeByte(10);
                bufferedSink1.writeByte(10);
                Iterator iterator0 = this.lruEntries.values().iterator();
                while(true) {
                    if(!iterator0.hasNext()) {
                        goto label_31;
                    }
                    Object object0 = iterator0.next();
                    Entry diskLruCache$Entry0 = (Entry)object0;
                    if(diskLruCache$Entry0.getCurrentEditor$okhttp() == null) {
                        bufferedSink1.writeUtf8("CLEAN").writeByte(0x20);
                        bufferedSink1.writeUtf8(diskLruCache$Entry0.getKey$okhttp());
                        diskLruCache$Entry0.writeLengths$okhttp(bufferedSink1);
                    }
                    else {
                        bufferedSink1.writeUtf8("DIRTY").writeByte(0x20);
                        bufferedSink1.writeUtf8(diskLruCache$Entry0.getKey$okhttp());
                    }
                    bufferedSink1.writeByte(10);
                }
            }
            catch(Throwable throwable0) {
            }
            try {
                throw throwable0;
            }
            catch(Throwable throwable1) {
                d.l(bufferedSink1, throwable0);
                throw throwable1;
            }
        label_31:
            d.l(bufferedSink1, null);
            if(this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.rename(this.journalFile, this.journalFileBackup);
            }
            this.fileSystem.rename(this.journalFileTmp, this.journalFile);
            this.fileSystem.delete(this.journalFileBackup);
            this.journalWriter = this.newJournalWriter();
            this.hasJournalErrors = false;
            this.mostRecentRebuildFailed = false;
        }
    }

    public final boolean remove(@NotNull String s) {
        synchronized(this) {
            q.g(s, "key");
            this.initialize();
            this.checkNotClosed();
            this.validateKey(s);
            Entry diskLruCache$Entry0 = (Entry)this.lruEntries.get(s);
            if(diskLruCache$Entry0 == null) {
                return false;
            }
            boolean z = this.removeEntry$okhttp(diskLruCache$Entry0);
            if(z && this.size <= this.maxSize) {
                this.mostRecentTrimFailed = false;
            }
            return z;
        }
    }

    public final boolean removeEntry$okhttp(@NotNull Entry diskLruCache$Entry0) {
        q.g(diskLruCache$Entry0, "entry");
        if(!this.civilizedFileSystem) {
            if(diskLruCache$Entry0.getLockingSourceCount$okhttp() > 0) {
                BufferedSink bufferedSink0 = this.journalWriter;
                if(bufferedSink0 != null) {
                    bufferedSink0.writeUtf8("DIRTY");
                    bufferedSink0.writeByte(0x20);
                    bufferedSink0.writeUtf8(diskLruCache$Entry0.getKey$okhttp());
                    bufferedSink0.writeByte(10);
                    bufferedSink0.flush();
                }
            }
            if(diskLruCache$Entry0.getLockingSourceCount$okhttp() > 0 || diskLruCache$Entry0.getCurrentEditor$okhttp() != null) {
                diskLruCache$Entry0.setZombie$okhttp(true);
                return true;
            }
        }
        Editor diskLruCache$Editor0 = diskLruCache$Entry0.getCurrentEditor$okhttp();
        if(diskLruCache$Editor0 != null) {
            diskLruCache$Editor0.detach$okhttp();
        }
        int v = this.valueCount;
        for(int v1 = 0; v1 < v; ++v1) {
            File file0 = (File)diskLruCache$Entry0.getCleanFiles$okhttp().get(v1);
            this.fileSystem.delete(file0);
            this.size -= diskLruCache$Entry0.getLengths$okhttp()[v1];
            diskLruCache$Entry0.getLengths$okhttp()[v1] = 0L;
        }
        ++this.redundantOpCount;
        BufferedSink bufferedSink1 = this.journalWriter;
        if(bufferedSink1 != null) {
            bufferedSink1.writeUtf8("REMOVE");
            bufferedSink1.writeByte(0x20);
            bufferedSink1.writeUtf8(diskLruCache$Entry0.getKey$okhttp());
            bufferedSink1.writeByte(10);
        }
        this.lruEntries.remove(diskLruCache$Entry0.getKey$okhttp());
        if(this.journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
        return true;
    }

    private final boolean removeOldestEntry() {
        for(Object object0: this.lruEntries.values()) {
            Entry diskLruCache$Entry0 = (Entry)object0;
            if(!diskLruCache$Entry0.getZombie$okhttp()) {
                this.removeEntry$okhttp(diskLruCache$Entry0);
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    public final void setClosed$okhttp(boolean z) {
        this.closed = z;
    }

    public final void setMaxSize(long v) {
        synchronized(this) {
            this.maxSize = v;
            if(this.initialized) {
                TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            }
        }
    }

    public final long size() {
        synchronized(this) {
            this.initialize();
            return this.size;
        }
    }

    @NotNull
    public final Iterator snapshots() {
        synchronized(this) {
            this.initialize();
            return new Object() {
                @NotNull
                private final Iterator delegate;
                @Nullable
                private Snapshot nextSnapshot;
                @Nullable
                private Snapshot removeSnapshot;

                {
                    Iterator iterator0 = new ArrayList(diskLruCache0.getLruEntries$okhttp().values()).iterator();
                    q.f(iterator0, "ArrayList(lruEntries.values).iterator()");
                    this.delegate = iterator0;
                }

                @Override
                public boolean hasNext() {
                    if(this.nextSnapshot != null) {
                        return true;
                    }
                    DiskLruCache diskLruCache0 = DiskLruCache.this;
                    synchronized(diskLruCache0) {
                        if(diskLruCache0.getClosed$okhttp()) {
                            return false;
                        }
                        while(this.delegate.hasNext()) {
                            Object object0 = this.delegate.next();
                            Entry diskLruCache$Entry0 = (Entry)object0;
                            if(diskLruCache$Entry0 != null) {
                                Snapshot diskLruCache$Snapshot0 = diskLruCache$Entry0.snapshot$okhttp();
                                if(diskLruCache$Snapshot0 != null) {
                                    this.nextSnapshot = diskLruCache$Snapshot0;
                                    return true;
                                }
                                if(false) {
                                    break;
                                }
                            }
                        }
                        return false;
                    }
                }

                @Override
                public Object next() {
                    return this.next();
                }

                @NotNull
                public Snapshot next() {
                    if(!this.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Snapshot diskLruCache$Snapshot0 = this.nextSnapshot;
                    this.removeSnapshot = diskLruCache$Snapshot0;
                    this.nextSnapshot = null;
                    q.d(diskLruCache$Snapshot0);
                    return diskLruCache$Snapshot0;
                }

                @Override
                public void remove() {
                    Snapshot diskLruCache$Snapshot0 = this.removeSnapshot;
                    if(diskLruCache$Snapshot0 != null) {
                        try {
                            DiskLruCache.this.remove(diskLruCache$Snapshot0.key());
                            this.removeSnapshot = null;
                            return;
                        }
                        catch(IOException unused_ex) {
                            this.removeSnapshot = null;
                            return;
                        }
                        catch(Throwable throwable0) {
                            this.removeSnapshot = null;
                            throw throwable0;
                        }
                    }
                    throw new IllegalStateException("remove() before next()");
                }
            };
        }
    }

    public final void trimToSize() {
        while(this.size > this.maxSize) {
            if(!this.removeOldestEntry()) {
                return;
            }
            if(false) {
                break;
            }
        }
        this.mostRecentTrimFailed = false;
    }

    private final void validateKey(String s) {
        if(!DiskLruCache.LEGAL_KEY_PATTERN.b(s)) {
            throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + s + '\"').toString());
        }
    }
}

