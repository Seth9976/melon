package okio;

import e2.a;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u0011\u0010\u0002\u001A\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001A\u0011\u0010\u0002\u001A\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006\u001A\u000F\u0010\t\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001AP\u0010\u0010\u001A\u00028\u0001\"\u0010\b\u0000\u0010\f*\n\u0018\u00010\nj\u0004\u0018\u0001`\u000B\"\u0004\b\u0001\u0010\r*\u00028\u00002\u0012\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000EH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"Lokio/Source;", "Lokio/BufferedSource;", "buffer", "(Lokio/Source;)Lokio/BufferedSource;", "Lokio/Sink;", "Lokio/BufferedSink;", "(Lokio/Sink;)Lokio/BufferedSink;", "blackhole", "()Lokio/Sink;", "blackholeSink", "Ljava/io/Closeable;", "Lokio/Closeable;", "T", "R", "Lkotlin/Function1;", "block", "use", "(Ljava/io/Closeable;Lwe/k;)Ljava/lang/Object;", "okio"}, k = 5, mv = {2, 1, 0}, xi = 0x30, xs = "okio/Okio")
final class Okio__OkioKt {
    @NotNull
    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    @NotNull
    public static final BufferedSink buffer(@NotNull Sink sink0) {
        q.g(sink0, "<this>");
        return new RealBufferedSink(sink0);
    }

    @NotNull
    public static final BufferedSource buffer(@NotNull Source source0) {
        q.g(source0, "<this>");
        return new RealBufferedSource(source0);
    }

    public static final Object use(Closeable closeable0, @NotNull k k0) {
        Object object1;
        q.g(k0, "block");
        Object object0 = null;
        try {
            object1 = k0.invoke(closeable0);
        }
        catch(Throwable throwable0) {
            if(closeable0 != null) {
                try {
                    closeable0.close();
                }
                catch(Throwable throwable1) {
                    a.q(throwable0, throwable1);
                }
            }
            goto label_18;
        }
        if(closeable0 != null) {
            try {
                closeable0.close();
            }
            catch(Throwable object0) {
            }
        }
        Object object2 = object0;
        object0 = object1;
        throwable0 = object2;
    label_18:
        if(throwable0 != null) {
            throw throwable0;
        }
        return object0;
    }
}

