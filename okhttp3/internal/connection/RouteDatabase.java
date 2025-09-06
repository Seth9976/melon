package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.Route;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u0004¢\u0006\u0004\b\n\u0010\bJ\u0015\u0010\f\u001A\u00020\u000B2\u0006\u0010\t\u001A\u00020\u0004¢\u0006\u0004\b\f\u0010\rR\u001A\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00040\u000E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/connection/RouteDatabase;", "", "<init>", "()V", "Lokhttp3/Route;", "failedRoute", "Lie/H;", "failed", "(Lokhttp3/Route;)V", "route", "connected", "", "shouldPostpone", "(Lokhttp3/Route;)Z", "", "failedRoutes", "Ljava/util/Set;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class RouteDatabase {
    @NotNull
    private final Set failedRoutes;

    public RouteDatabase() {
        this.failedRoutes = new LinkedHashSet();
    }

    public final void connected(@NotNull Route route0) {
        synchronized(this) {
            q.g(route0, "route");
            this.failedRoutes.remove(route0);
        }
    }

    public final void failed(@NotNull Route route0) {
        synchronized(this) {
            q.g(route0, "failedRoute");
            this.failedRoutes.add(route0);
        }
    }

    public final boolean shouldPostpone(@NotNull Route route0) {
        synchronized(this) {
            q.g(route0, "route");
            return this.failedRoutes.contains(route0);
        }
    }
}

