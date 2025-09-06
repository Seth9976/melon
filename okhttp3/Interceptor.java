package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u0000 \u00072\u00020\u0001:\u0002\u0006\u0007J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&¨\u0006\b"}, d2 = {"Lokhttp3/Interceptor;", "", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Chain", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public interface Interceptor {
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H&J\b\u0010\u0004\u001A\u00020\u0005H&J\n\u0010\u0006\u001A\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH&J\b\u0010\f\u001A\u00020\u0005H&J\b\u0010\n\u001A\u00020\u000BH&J\u0018\u0010\r\u001A\u00020\u00002\u0006\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u0010H&J\u0018\u0010\u0011\u001A\u00020\u00002\u0006\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u0010H&J\u0018\u0010\u0012\u001A\u00020\u00002\u0006\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u0010H&J\b\u0010\u0013\u001A\u00020\u0005H&¨\u0006\u0014"}, d2 = {"Lokhttp3/Interceptor$Chain;", "", "call", "Lokhttp3/Call;", "connectTimeoutMillis", "", "connection", "Lokhttp3/Connection;", "proceed", "Lokhttp3/Response;", "request", "Lokhttp3/Request;", "readTimeoutMillis", "withConnectTimeout", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "withReadTimeout", "withWriteTimeout", "writeTimeoutMillis", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface Chain {
        @NotNull
        Call call();

        int connectTimeoutMillis();

        @Nullable
        Connection connection();

        @NotNull
        Response proceed(@NotNull Request arg1);

        int readTimeoutMillis();

        @NotNull
        Request request();

        @NotNull
        Chain withConnectTimeout(int arg1, @NotNull TimeUnit arg2);

        @NotNull
        Chain withReadTimeout(int arg1, @NotNull TimeUnit arg2);

        @NotNull
        Chain withWriteTimeout(int arg1, @NotNull TimeUnit arg2);

        int writeTimeoutMillis();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\t\u001A\u00020\b2\u0014\b\u0004\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0086\nø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000B"}, d2 = {"Lokhttp3/Interceptor$Companion;", "", "<init>", "()V", "Lkotlin/Function1;", "Lokhttp3/Interceptor$Chain;", "Lokhttp3/Response;", "block", "Lokhttp3/Interceptor;", "invoke", "(Lwe/k;)Lokhttp3/Interceptor;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        static final Companion $$INSTANCE;

        static {
            Companion.$$INSTANCE = new Companion();
        }

        @NotNull
        public final Interceptor invoke(@NotNull k k0) {
            q.g(k0, "block");
            return new Interceptor() {
                @Override  // okhttp3.Interceptor
                @NotNull
                public final Response intercept(@NotNull Chain interceptor$Chain0) {
                    q.g(interceptor$Chain0, "it");
                    return (Response)this.$block.invoke(interceptor$Chain0);
                }
            };
        }
    }

    @NotNull
    public static final Companion Companion;

    static {
        Interceptor.Companion = Companion.$$INSTANCE;
    }

    @NotNull
    Response intercept(@NotNull Chain arg1);
}

