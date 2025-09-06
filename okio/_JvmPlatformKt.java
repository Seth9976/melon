package okio;

import Tf.a;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0010\u0012\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0013\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001A\u0013\u0010\u0004\u001A\u00020\u0000*\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001A\u0013\u0010\b\u001A\u00060\u0006j\u0002`\u0007H\u0000¢\u0006\u0004\b\b\u0010\t\u001A<\u0010\r\u001A\u00028\u0000\"\u0004\b\u0000\u0010\n*\u00060\u0006j\u0002`\u00072\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u000BH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\r\u0010\u000E*\n\u0010\u0010\"\u00020\u000F2\u00020\u000F*\n\u0010\u0011\"\u00020\u00062\u00020\u0006*\n\u0010\u0013\"\u00020\u00122\u00020\u0012*\n\u0010\u0015\"\u00020\u00142\u00020\u0014*\n\u0010\u0017\"\u00020\u00162\u00020\u0016*\n\u0010\u0019\"\u00020\u00182\u00020\u0018*\n\u0010\u001B\"\u00020\u001A2\u00020\u001A*\n\u0010\u001D\"\u00020\u001C2\u00020\u001C*\n\u0010\u001F\"\u00020\u001E2\u00020\u001E\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006 "}, d2 = {"", "", "toUtf8String", "([B)Ljava/lang/String;", "asUtf8ToByteArray", "(Ljava/lang/String;)[B", "Ljava/util/concurrent/locks/ReentrantLock;", "Lokio/Lock;", "newLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "T", "Lkotlin/Function0;", "action", "withLock", "(Ljava/util/concurrent/locks/ReentrantLock;Lwe/a;)Ljava/lang/Object;", "Ljava/lang/ArrayIndexOutOfBoundsException;", "ArrayIndexOutOfBoundsException", "Lock", "Ljava/io/IOException;", "IOException", "Ljava/net/ProtocolException;", "ProtocolException", "Ljava/io/EOFException;", "EOFException", "Ljava/io/FileNotFoundException;", "FileNotFoundException", "Ljava/io/Closeable;", "Closeable", "Ljava/util/zip/Deflater;", "Deflater", "Ljava/util/zip/Inflater;", "Inflater", "okio"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public final class _JvmPlatformKt {
    @NotNull
    public static final byte[] asUtf8ToByteArray(@NotNull String s) {
        q.g(s, "<this>");
        byte[] arr_b = s.getBytes(a.a);
        q.f(arr_b, "getBytes(...)");
        return arr_b;
    }

    @NotNull
    public static final ReentrantLock newLock() {
        return new ReentrantLock();
    }

    @NotNull
    public static final String toUtf8String(@NotNull byte[] arr_b) {
        q.g(arr_b, "<this>");
        return new String(arr_b, a.a);
    }

    public static final Object withLock(@NotNull ReentrantLock reentrantLock0, @NotNull we.a a0) {
        q.g(reentrantLock0, "<this>");
        q.g(a0, "action");
        reentrantLock0.lock();
        try {
            return a0.invoke();
        }
        finally {
            reentrantLock0.unlock();
        }
    }
}

