package com.facebook.internal;

import Tf.a;
import Tf.v;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.c;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import jeb.synthetic.FIN;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 52\u00020\u0001:\b67589:;<B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\f\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\u0010\u0010\u000FJ\r\u0010\u0012\u001A\u00020\u0011\u00A2\u0006\u0004\b\u0012\u0010\u0013J&\u0010\u0016\u001A\u0004\u0018\u00010\u00152\u0006\u0010\b\u001A\u00020\u00022\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u0002H\u0087\u0002\u00A2\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0019\u001A\u00020\u00182\u0006\u0010\b\u001A\u00020\u00022\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\r\u0010\u001B\u001A\u00020\u000B\u00A2\u0006\u0004\b\u001B\u0010\u000FJ\u001D\u0010\u001D\u001A\u00020\u00152\u0006\u0010\b\u001A\u00020\u00022\u0006\u0010\u001C\u001A\u00020\u0015\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010\u001F\u001A\u00020\u0002H\u0016\u00A2\u0006\u0004\b\u001F\u0010 R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010!R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010\"R\u0014\u0010#\u001A\u00020\t8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001A\u00020%8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b&\u0010\'R\u0016\u0010(\u001A\u00020%8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b(\u0010\'R\u0014\u0010*\u001A\u00020)8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b*\u0010+R\u001C\u0010.\u001A\n -*\u0004\u0018\u00010,0,8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001A\u0002008\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b1\u00102R\u0011\u00104\u001A\u00020\u00028F\u00A2\u0006\u0006\u001A\u0004\b3\u0010 \u00A8\u0006="}, d2 = {"Lcom/facebook/internal/FileLruCache;", "", "", "tag", "Lcom/facebook/internal/FileLruCache$Limits;", "limits", "<init>", "(Ljava/lang/String;Lcom/facebook/internal/FileLruCache$Limits;)V", "key", "Ljava/io/File;", "buffer", "Lie/H;", "renameToTargetAndTrim", "(Ljava/lang/String;Ljava/io/File;)V", "postTrim", "()V", "trim", "", "sizeInBytesForTest", "()J", "contentTag", "Ljava/io/InputStream;", "get", "(Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;", "Ljava/io/OutputStream;", "openPutStream", "(Ljava/lang/String;Ljava/lang/String;)Ljava/io/OutputStream;", "clearCache", "input", "interceptAndPut", "(Ljava/lang/String;Ljava/io/InputStream;)Ljava/io/InputStream;", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "Lcom/facebook/internal/FileLruCache$Limits;", "directory", "Ljava/io/File;", "", "isTrimPending", "Z", "isTrimInProgress", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "condition", "Ljava/util/concurrent/locks/Condition;", "Ljava/util/concurrent/atomic/AtomicLong;", "lastClearCacheTime", "Ljava/util/concurrent/atomic/AtomicLong;", "getLocation", "location", "Companion", "BufferFile", "CloseCallbackOutputStream", "CopyingInputStream", "Limits", "ModifiedFile", "StreamCloseCallback", "StreamHeader", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FileLruCache {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\r\u0010\f\u001A\u00020\t¢\u0006\u0004\b\f\u0010\u000BJ\u0017\u0010\r\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000ER\u0014\u0010\u0010\u001A\u00020\u000F8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/facebook/internal/FileLruCache$BufferFile;", "", "<init>", "()V", "Ljava/io/File;", "root", "Lie/H;", "deleteAll", "(Ljava/io/File;)V", "Ljava/io/FilenameFilter;", "excludeBufferFiles", "()Ljava/io/FilenameFilter;", "excludeNonBufferFiles", "newFile", "(Ljava/io/File;)Ljava/io/File;", "", "FILE_NAME_PREFIX", "Ljava/lang/String;", "filterExcludeBufferFiles", "Ljava/io/FilenameFilter;", "filterExcludeNonBufferFiles", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class BufferFile {
        @NotNull
        private static final String FILE_NAME_PREFIX = "buffer";
        @NotNull
        public static final BufferFile INSTANCE;
        @NotNull
        private static final FilenameFilter filterExcludeBufferFiles;
        @NotNull
        private static final FilenameFilter filterExcludeNonBufferFiles;

        static {
            BufferFile.INSTANCE = new BufferFile();
            BufferFile.filterExcludeBufferFiles = new b(0);
            BufferFile.filterExcludeNonBufferFiles = new b(1);
        }

        public final void deleteAll(@NotNull File file0) {
            q.g(file0, "root");
            File[] arr_file = file0.listFiles(this.excludeNonBufferFiles());
            if(arr_file != null) {
                for(int v = 0; v < arr_file.length; ++v) {
                    arr_file[v].delete();
                }
            }
        }

        @NotNull
        public final FilenameFilter excludeBufferFiles() {
            return BufferFile.filterExcludeBufferFiles;
        }

        @NotNull
        public final FilenameFilter excludeNonBufferFiles() {
            return BufferFile.filterExcludeNonBufferFiles;
        }

        private static final boolean filterExcludeBufferFiles$lambda$0(File file0, String s) {
            q.f(s, "filename");
            return !v.r0(s, "buffer", false);
        }

        private static final boolean filterExcludeNonBufferFiles$lambda$1(File file0, String s) {
            q.f(s, "filename");
            return v.r0(s, "buffer", false);
        }

        @NotNull
        public final File newFile(@Nullable File file0) {
            return new File(file0, "buffer" + FileLruCache.bufferIndex.incrementAndGet());
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u000E\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\n\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\'\u0010\u0010\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0010\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0010\u0010\u0012J\u0017\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0014R\u0017\u0010\u0002\u001A\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0004\u001A\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001A\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2 = {"Lcom/facebook/internal/FileLruCache$CloseCallbackOutputStream;", "Ljava/io/OutputStream;", "innerStream", "Lcom/facebook/internal/FileLruCache$StreamCloseCallback;", "callback", "<init>", "(Ljava/io/OutputStream;Lcom/facebook/internal/FileLruCache$StreamCloseCallback;)V", "Lie/H;", "close", "()V", "flush", "", "buffer", "", "offset", "count", "write", "([BII)V", "([B)V", "oneByte", "(I)V", "Ljava/io/OutputStream;", "getInnerStream", "()Ljava/io/OutputStream;", "Lcom/facebook/internal/FileLruCache$StreamCloseCallback;", "getCallback", "()Lcom/facebook/internal/FileLruCache$StreamCloseCallback;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class CloseCallbackOutputStream extends OutputStream {
        @NotNull
        private final StreamCloseCallback callback;
        @NotNull
        private final OutputStream innerStream;

        public CloseCallbackOutputStream(@NotNull OutputStream outputStream0, @NotNull StreamCloseCallback fileLruCache$StreamCloseCallback0) {
            q.g(outputStream0, "innerStream");
            q.g(fileLruCache$StreamCloseCallback0, "callback");
            super();
            this.innerStream = outputStream0;
            this.callback = fileLruCache$StreamCloseCallback0;
        }

        @Override
        public void close() {
            try {
                this.innerStream.close();
            }
            finally {
                this.callback.onClose();
            }
        }

        @Override
        public void flush() {
            this.innerStream.flush();
        }

        @NotNull
        public final StreamCloseCallback getCallback() {
            return this.callback;
        }

        @NotNull
        public final OutputStream getInnerStream() {
            return this.innerStream;
        }

        @Override
        public void write(int v) {
            this.innerStream.write(v);
        }

        @Override
        public void write(@NotNull byte[] arr_b) {
            q.g(arr_b, "buffer");
            this.innerStream.write(arr_b);
        }

        @Override
        public void write(@NotNull byte[] arr_b, int v, int v1) {
            q.g(arr_b, "buffer");
            this.innerStream.write(arr_b, v, v1);
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001A\n \u0007*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/internal/FileLruCache$Companion;", "", "()V", "HEADER_CACHEKEY_KEY", "", "HEADER_CACHE_CONTENT_TAG_KEY", "TAG", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "bufferIndex", "Ljava/util/concurrent/atomic/AtomicLong;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        // 去混淆评级： 低(20)
        public final String getTAG() [...] // 潜在的解密器
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000E\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0011\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0015\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\tJ\'\u0010\u0015\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0017\u001A\u00020\u00072\u0006\u0010\u0018\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\nH\u0016¢\u0006\u0004\b\u001A\u0010\fJ\u0017\u0010\u001D\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001BH\u0016¢\u0006\u0004\b\u001D\u0010\u001ER\u0017\u0010\u0002\u001A\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u001F\u001A\u0004\b \u0010!R\u0017\u0010\u0004\u001A\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\"\u001A\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/facebook/internal/FileLruCache$CopyingInputStream;", "Ljava/io/InputStream;", "input", "Ljava/io/OutputStream;", "output", "<init>", "(Ljava/io/InputStream;Ljava/io/OutputStream;)V", "", "available", "()I", "Lie/H;", "close", "()V", "readlimit", "mark", "(I)V", "", "markSupported", "()Z", "", "buffer", "read", "([B)I", "offset", "length", "([BII)I", "reset", "", "byteCount", "skip", "(J)J", "Ljava/io/InputStream;", "getInput", "()Ljava/io/InputStream;", "Ljava/io/OutputStream;", "getOutput", "()Ljava/io/OutputStream;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class CopyingInputStream extends InputStream {
        @NotNull
        private final InputStream input;
        @NotNull
        private final OutputStream output;

        public CopyingInputStream(@NotNull InputStream inputStream0, @NotNull OutputStream outputStream0) {
            q.g(inputStream0, "input");
            q.g(outputStream0, "output");
            super();
            this.input = inputStream0;
            this.output = outputStream0;
        }

        @Override
        public int available() {
            return this.input.available();
        }

        @Override
        public void close() {
            try {
                this.input.close();
            }
            finally {
                this.output.close();
            }
        }

        @NotNull
        public final InputStream getInput() {
            return this.input;
        }

        @NotNull
        public final OutputStream getOutput() {
            return this.output;
        }

        @Override
        public void mark(int v) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean markSupported() {
            return false;
        }

        @Override
        public int read() {
            int v = this.input.read();
            if(v >= 0) {
                this.output.write(v);
            }
            return v;
        }

        @Override
        public int read(@NotNull byte[] arr_b) {
            q.g(arr_b, "buffer");
            int v = this.input.read(arr_b);
            if(v > 0) {
                this.output.write(arr_b, 0, v);
            }
            return v;
        }

        @Override
        public int read(@NotNull byte[] arr_b, int v, int v1) {
            q.g(arr_b, "buffer");
            int v2 = this.input.read(arr_b, v, v1);
            if(v2 > 0) {
                this.output.write(arr_b, v, v2);
            }
            return v2;
        }

        @Override
        public void reset() {
            synchronized(this) {
                throw new UnsupportedOperationException();
            }
        }

        @Override
        public long skip(long v) {
            long v1;
            for(v1 = 0L; v1 < v; v1 += (long)v2) {
                int v2 = this.read(new byte[0x400], 0, ((int)Math.min(v - v1, 0x400L)));
                if(v2 < 0) {
                    break;
                }
            }
            return v1;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0004@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0004@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/facebook/internal/FileLruCache$Limits;", "", "()V", "value", "", "byteCount", "getByteCount", "()I", "setByteCount", "(I)V", "fileCount", "getFileCount", "setFileCount", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Limits {
        private int byteCount;
        private int fileCount;

        public Limits() {
            this.byteCount = 0x100000;
            this.fileCount = 0x400;
        }

        public final int getByteCount() {
            return this.byteCount;
        }

        public final int getFileCount() {
            return this.fileCount;
        }

        public final void setByteCount(int v) {
            if(v < 0) {
                throw new InvalidParameterException("Cache byte-count limit must be >= 0");
            }
            this.byteCount = v;
        }

        public final void setFileCount(int v) {
            if(v < 0) {
                throw new InvalidParameterException("Cache file count limit must be >= 0");
            }
            this.fileCount = v;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u0000H\u0096\u0002J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\r\u001A\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001A\u00020\fH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/facebook/internal/FileLruCache$ModifiedFile;", "", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "modified", "", "getModified", "()J", "compareTo", "", "another", "equals", "", "", "hashCode", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class ModifiedFile implements Comparable {
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/FileLruCache$ModifiedFile$Companion;", "", "()V", "HASH_MULTIPLIER", "", "HASH_SEED", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class com.facebook.internal.FileLruCache.ModifiedFile.Companion {
            private com.facebook.internal.FileLruCache.ModifiedFile.Companion() {
            }

            public com.facebook.internal.FileLruCache.ModifiedFile.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @NotNull
        public static final com.facebook.internal.FileLruCache.ModifiedFile.Companion Companion = null;
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;
        @NotNull
        private final File file;
        private final long modified;

        static {
            ModifiedFile.Companion = new com.facebook.internal.FileLruCache.ModifiedFile.Companion(null);
        }

        public ModifiedFile(@NotNull File file0) {
            q.g(file0, "file");
            super();
            this.file = file0;
            this.modified = file0.lastModified();
        }

        public int compareTo(@NotNull ModifiedFile fileLruCache$ModifiedFile0) {
            q.g(fileLruCache$ModifiedFile0, "another");
            long v = this.modified;
            long v1 = fileLruCache$ModifiedFile0.modified;
            if(v < v1) {
                return -1;
            }
            return v <= v1 ? this.file.compareTo(fileLruCache$ModifiedFile0.file) : 1;
        }

        @Override
        public int compareTo(Object object0) {
            return this.compareTo(((ModifiedFile)object0));
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            return object0 instanceof ModifiedFile && this.compareTo(((ModifiedFile)object0)) == 0;
        }

        @NotNull
        public final File getFile() {
            return this.file;
        }

        public final long getModified() {
            return this.modified;
        }

        @Override
        public int hashCode() {
            return (this.file.hashCode() + 1073) * 37 + ((int)(this.modified % 0x7FFFFFFFL));
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bâ\u0080\u0001\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/internal/FileLruCache$StreamCloseCallback;", "", "Lie/H;", "onClose", "()V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    interface StreamCloseCallback {
        void onClose();
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000F\u001A\u00020\u000E8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/facebook/internal/FileLruCache$StreamHeader;", "", "<init>", "()V", "Ljava/io/OutputStream;", "stream", "Lorg/json/JSONObject;", "header", "Lie/H;", "writeHeader", "(Ljava/io/OutputStream;Lorg/json/JSONObject;)V", "Ljava/io/InputStream;", "readHeader", "(Ljava/io/InputStream;)Lorg/json/JSONObject;", "", "HEADER_VERSION", "I", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class StreamHeader {
        private static final int HEADER_VERSION;
        @NotNull
        public static final StreamHeader INSTANCE;

        static {
            StreamHeader.INSTANCE = new StreamHeader();
        }

        @Nullable
        public final JSONObject readHeader(@NotNull InputStream inputStream0) {
            q.g(inputStream0, "stream");
            if(inputStream0.read() != 0) {
                return null;
            }
            int v1 = 0;
            for(int v2 = 0; v2 < 3; ++v2) {
                int v3 = inputStream0.read();
                if(v3 == -1) {
                    q.f("FileLruCache", "TAG");
                    Logger.Companion.log(LoggingBehavior.CACHE, "FileLruCache", "readHeader: stream.read returned -1 while reading header size");
                    return null;
                }
                v1 = (v1 << 8) + (v3 & 0xFF);
            }
            byte[] arr_b = new byte[v1];
            for(int v = 0; v < v1; v += v4) {
                int v4 = inputStream0.read(arr_b, v, v1 - v);
                if(v4 < 1) {
                    q.f("FileLruCache", "TAG");
                    Logger.Companion.log(LoggingBehavior.CACHE, "FileLruCache", "readHeader: stream.read stopped at " + v + " when expected " + v1);
                    return null;
                }
            }
            JSONTokener jSONTokener0 = new JSONTokener(new String(arr_b, a.a));
            try {
                Object object0 = jSONTokener0.nextValue();
                if(!(object0 instanceof JSONObject)) {
                    q.f("FileLruCache", "TAG");
                    Logger.Companion.log(LoggingBehavior.CACHE, "FileLruCache", "readHeader: expected JSONObject, got " + object0.getClass().getCanonicalName());
                    return null;
                }
                return (JSONObject)object0;
            }
            catch(JSONException jSONException0) {
            }
            throw new IOException(jSONException0.getMessage());
        }

        public final void writeHeader(@NotNull OutputStream outputStream0, @NotNull JSONObject jSONObject0) {
            q.g(outputStream0, "stream");
            q.g(jSONObject0, "header");
            String s = jSONObject0.toString();
            q.f(s, "header.toString()");
            byte[] arr_b = s.getBytes(a.a);
            q.f(arr_b, "this as java.lang.String).getBytes(charset)");
            outputStream0.write(0);
            outputStream0.write(arr_b.length >> 16 & 0xFF);
            outputStream0.write(arr_b.length >> 8 & 0xFF);
            outputStream0.write(arr_b.length & 0xFF);
            outputStream0.write(arr_b);
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String HEADER_CACHEKEY_KEY = "key";
    @NotNull
    private static final String HEADER_CACHE_CONTENT_TAG_KEY = "tag";
    private static final String TAG;
    @NotNull
    private static final AtomicLong bufferIndex;
    private final Condition condition;
    @NotNull
    private final File directory;
    private boolean isTrimInProgress;
    private boolean isTrimPending;
    @NotNull
    private final AtomicLong lastClearCacheTime;
    @NotNull
    private final Limits limits;
    @NotNull
    private final ReentrantLock lock;
    @NotNull
    private final String tag;

    static {
        FileLruCache.Companion = new Companion(null);
        FileLruCache.TAG = "FileLruCache";
        FileLruCache.bufferIndex = new AtomicLong();
    }

    public FileLruCache(@NotNull String s, @NotNull Limits fileLruCache$Limits0) {
        q.g(s, "tag");
        q.g(fileLruCache$Limits0, "limits");
        super();
        this.tag = s;
        this.limits = fileLruCache$Limits0;
        File file0 = new File(FacebookSdk.getCacheDir(), s);
        this.directory = file0;
        ReentrantLock reentrantLock0 = new ReentrantLock();
        this.lock = reentrantLock0;
        this.condition = reentrantLock0.newCondition();
        this.lastClearCacheTime = new AtomicLong(0L);
        if(!file0.mkdirs() && !file0.isDirectory()) {
            return;
        }
        BufferFile.INSTANCE.deleteAll(file0);
    }

    public static void a(File[] arr_file) {
        FileLruCache.clearCache$lambda$1(arr_file);
    }

    public static final String access$getTAG$cp() [...] // 潜在的解密器

    public static void b(FileLruCache fileLruCache0) {
        FileLruCache.postTrim$lambda$3$lambda$2(fileLruCache0);
    }

    public final void clearCache() {
        File[] arr_file = this.directory.listFiles(BufferFile.INSTANCE.excludeBufferFiles());
        this.lastClearCacheTime.set(System.currentTimeMillis());
        if(arr_file != null) {
            FacebookSdk.getExecutor().execute(new c(arr_file, 8));
        }
    }

    private static final void clearCache$lambda$1(File[] arr_file) {
        q.f(arr_file, "filesToDelete");
        for(int v = 0; v < arr_file.length; ++v) {
            arr_file[v].delete();
        }
    }

    @Nullable
    public final InputStream get(@NotNull String s) {
        q.g(s, "key");
        return FileLruCache.get$default(this, s, null, 2, null);
    }

    @Nullable
    public final InputStream get(@NotNull String s, @Nullable String s1) {
        FileInputStream fileInputStream0;
        q.g(s, "key");
        String s2 = Utility.md5hash(s);
        File file0 = new File(this.directory, s2);
        try {
            fileInputStream0 = new FileInputStream(file0);
        }
        catch(IOException unused_ex) {
            return null;
        }
        InputStream inputStream0 = new BufferedInputStream(fileInputStream0, 0x2000);
        int v = FIN.finallyOpen$NT();
        JSONObject jSONObject0 = StreamHeader.INSTANCE.readHeader(inputStream0);
        if(jSONObject0 == null) {
            FIN.finallyCodeBegin$NT(v);
            ((BufferedInputStream)inputStream0).close();
            FIN.finallyCodeEnd$NT(v);
            return null;
        }
        if(!q.b(jSONObject0.optString("key"), s)) {
            FIN.finallyExec$NT(v);
            return null;
        }
        if(s1 == null && !q.b(null, jSONObject0.optString("tag", null))) {
            FIN.finallyExec$NT(v);
            return null;
        }
        long v1 = new Date().getTime();
        q.f("FileLruCache", "TAG");
        Logger.Companion.log(LoggingBehavior.CACHE, "FileLruCache", "Setting lastModified to " + v1 + " for " + file0.getName());
        file0.setLastModified(v1);
        return inputStream0;
    }

    public static InputStream get$default(FileLruCache fileLruCache0, String s, String s1, int v, Object object0) {
        if((v & 2) != 0) {
            s1 = null;
        }
        return fileLruCache0.get(s, s1);
    }

    @NotNull
    public final String getLocation() {
        String s = this.directory.getPath();
        q.f(s, "directory.path");
        return s;
    }

    @NotNull
    public final InputStream interceptAndPut(@NotNull String s, @NotNull InputStream inputStream0) {
        q.g(s, "key");
        q.g(inputStream0, "input");
        return new CopyingInputStream(inputStream0, FileLruCache.openPutStream$default(this, s, null, 2, null));
    }

    @NotNull
    public final OutputStream openPutStream(@NotNull String s) {
        q.g(s, "key");
        return FileLruCache.openPutStream$default(this, s, null, 2, null);
    }

    @NotNull
    public final OutputStream openPutStream(@NotNull String s, @Nullable String s1) {
        JSONException jSONException1;
        Throwable throwable1;
        FileOutputStream fileOutputStream0;
        q.g(s, "key");
        File file0 = BufferFile.INSTANCE.newFile(this.directory);
        file0.delete();
        if(!file0.createNewFile()) {
            throw new IOException("Could not create file at " + file0.getAbsolutePath());
        }
        try {
            fileOutputStream0 = new FileOutputStream(file0);
        }
        catch(FileNotFoundException fileNotFoundException0) {
            q.f("FileLruCache", "TAG");
            Logger.Companion.log(LoggingBehavior.CACHE, 5, "FileLruCache", "Error creating buffer output stream: " + fileNotFoundException0);
            throw new IOException(fileNotFoundException0.getMessage());
        }
        OutputStream outputStream0 = new BufferedOutputStream(new CloseCallbackOutputStream(fileOutputStream0, new StreamCloseCallback() {
            @Override  // com.facebook.internal.FileLruCache$StreamCloseCallback
            public void onClose() {
                long v = file0.lastClearCacheTime.get();
                if(this < v) {
                    s.delete();
                    return;
                }
                file0.renameToTargetAndTrim(this.$key, s);
            }
        }), 0x2000);
        try {
            try {
                JSONObject jSONObject0 = new JSONObject();
                jSONObject0.put("key", s);
                if(!Utility.isNullOrEmpty(s1)) {
                    jSONObject0.put("tag", s1);
                }
                StreamHeader.INSTANCE.writeHeader(outputStream0, jSONObject0);
                return outputStream0;
            label_21:
                jSONException1 = jSONException0;
            }
            catch(JSONException jSONException0) {
                goto label_21;
            }
            q.f("FileLruCache", "TAG");
            Logger.Companion.log(LoggingBehavior.CACHE, 5, "FileLruCache", "Error creating JSON header for cache file: " + jSONException1);
            throw new IOException(jSONException1.getMessage());
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
        }
        outputStream0.close();
        throw throwable1;
    }

    public static OutputStream openPutStream$default(FileLruCache fileLruCache0, String s, String s1, int v, Object object0) {
        if((v & 2) != 0) {
            s1 = null;
        }
        return fileLruCache0.openPutStream(s, s1);
    }

    private final void postTrim() {
        ReentrantLock reentrantLock0 = this.lock;
        reentrantLock0.lock();
        try {
            if(!this.isTrimPending) {
                this.isTrimPending = true;
                FacebookSdk.getExecutor().execute(new c(this, 9));
            }
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    private static final void postTrim$lambda$3$lambda$2(FileLruCache fileLruCache0) {
        q.g(fileLruCache0, "this$0");
        fileLruCache0.trim();
    }

    private final void renameToTargetAndTrim(String s, File file0) {
        String s1 = Utility.md5hash(s);
        if(!file0.renameTo(new File(this.directory, s1))) {
            file0.delete();
        }
        this.postTrim();
    }

    public final long sizeInBytesForTest() {
        ReentrantLock reentrantLock0 = this.lock;
        reentrantLock0.lock();
        try {
            while(this.isTrimPending || this.isTrimInProgress) {
                try {
                    this.condition.await();
                }
                catch(InterruptedException unused_ex) {
                }
            }
        }
        finally {
            reentrantLock0.unlock();
        }
        File[] arr_file = this.directory.listFiles();
        long v1 = 0L;
        if(arr_file != null) {
            for(int v2 = 0; v2 < arr_file.length; ++v2) {
                v1 += arr_file[v2].length();
            }
        }
        return v1;
    }

    @Override
    @NotNull
    public String toString() {
        return "{FileLruCache: tag:" + this.tag + " file:" + this.directory.getName() + '}';
    }

    private final void trim() {
        long v3;
        this.lock.lock();
        this.isTrimPending = false;
        this.isTrimInProgress = true;
        this.lock.unlock();
        try {
            q.f("FileLruCache", "TAG");
            Logger.Companion.log(LoggingBehavior.CACHE, "FileLruCache", "trim started");
            PriorityQueue priorityQueue0 = new PriorityQueue();
            File[] arr_file = this.directory.listFiles(BufferFile.INSTANCE.excludeBufferFiles());
            long v1 = 0L;
            if(arr_file == null) {
                v3 = 0L;
            }
            else {
                v3 = 0L;
                for(int v2 = 0; v2 < arr_file.length; ++v2) {
                    File file0 = arr_file[v2];
                    q.f(file0, "file");
                    ModifiedFile fileLruCache$ModifiedFile0 = new ModifiedFile(file0);
                    priorityQueue0.add(fileLruCache$ModifiedFile0);
                    q.f("FileLruCache", "TAG");
                    Logger.Companion.log(LoggingBehavior.CACHE, "FileLruCache", "  trim considering time=" + fileLruCache$ModifiedFile0.getModified() + " name=" + fileLruCache$ModifiedFile0.getFile().getName());
                    v1 += file0.length();
                    ++v3;
                }
            }
            while(v1 > ((long)this.limits.getByteCount()) || v3 > ((long)this.limits.getFileCount())) {
                File file1 = ((ModifiedFile)priorityQueue0.remove()).getFile();
                q.f("FileLruCache", "TAG");
                Logger.Companion.log(LoggingBehavior.CACHE, "FileLruCache", "  trim removing " + file1.getName());
                v1 -= file1.length();
                --v3;
                file1.delete();
            }
        }
        finally {
            this.lock.lock();
            try {
                this.isTrimInProgress = false;
                this.condition.signalAll();
            }
            finally {
                this.lock.unlock();
            }
        }
    }
}

