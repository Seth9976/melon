package okhttp3.internal.connection;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.Interceptor.Chain;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/connection/ConnectInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ConnectInterceptor implements Interceptor {
    @NotNull
    public static final ConnectInterceptor INSTANCE;

    static {
        ConnectInterceptor.INSTANCE = new ConnectInterceptor();
    }

    @Override  // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Chain interceptor$Chain0) {
        q.g(interceptor$Chain0, "chain");
        return RealInterceptorChain.copy$okhttp$default(((RealInterceptorChain)interceptor$Chain0), 0, ((RealInterceptorChain)interceptor$Chain0).getCall$okhttp().initExchange$okhttp(((RealInterceptorChain)interceptor$Chain0)), null, 0, 0, 0, 61, null).proceed(((RealInterceptorChain)interceptor$Chain0).getRequest$okhttp());
    }
}

