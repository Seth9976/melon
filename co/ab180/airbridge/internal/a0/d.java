package co.ab180.airbridge.internal.a0;

import co.ab180.airbridge.internal.e0.j;
import java.net.HttpURLConnection;
import java.net.URL;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lco/ab180/airbridge/internal/a0/d;", "Lco/ab180/airbridge/internal/a0/c;", "Ljava/net/URL;", "url", "Ljava/net/HttpURLConnection;", "a", "(Ljava/net/URL;)Ljava/net/HttpURLConnection;", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class d implements c {
    @Override  // co.ab180.airbridge.internal.a0.c
    @NotNull
    public HttpURLConnection a(@NotNull URL uRL0) {
        return j.a(uRL0.openConnection());
    }
}

