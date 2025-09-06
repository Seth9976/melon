package co.ab180.airbridge.internal.d0.d.c;

import android.os.Bundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0011\u001A\u00020\u000F¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001A\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001A\u00020\u0005¢\u0006\u0004\b\t\u0010\u0007J\r\u0010\n\u001A\u00020\u0005¢\u0006\u0004\b\n\u0010\u0007J\r\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000E\u0010\u0004R\u0016\u0010\u0011\u001A\u00020\u000F8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lco/ab180/airbridge/internal/d0/d/c/c;", "", "", "d", "()Ljava/lang/String;", "", "f", "()J", "g", "b", "c", "", "a", "()Z", "e", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "origin", "<init>", "(Landroid/os/Bundle;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class c {
    private final Bundle a;

    public c(@NotNull Bundle bundle0) {
        this.a = bundle0;
    }

    public final boolean a() {
        return this.a.getBoolean("google_play_instant");
    }

    public final long b() {
        return this.a.getLong("install_begin_timestamp_seconds");
    }

    public final long c() {
        return this.a.getLong("install_begin_timestamp_server_seconds");
    }

    @Nullable
    public final String d() {
        return this.a.getString("install_referrer");
    }

    @Nullable
    public final String e() {
        return this.a.getString("install_version");
    }

    public final long f() {
        return this.a.getLong("referrer_click_timestamp_seconds");
    }

    public final long g() {
        return this.a.getLong("referrer_click_timestamp_server_seconds");
    }
}

