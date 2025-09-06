package androidx.sqlite.db;

import H4.b;
import H4.c;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"androidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sqlite_release"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public class SupportSQLiteOpenHelper.Configuration.Builder {
    public final Context a;
    public String b;
    public b c;
    public boolean d;
    public boolean e;

    public SupportSQLiteOpenHelper.Configuration.Builder(@NotNull Context context0) {
        q.g(context0, "context");
        super();
        this.a = context0;
    }

    public final c a() {
        b b0 = this.c;
        if(b0 == null) {
            throw new IllegalArgumentException("Must set a callback to create the configuration.");
        }
        if(this.d && (this.b == null || this.b.length() == 0)) {
            throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
        }
        return new c(this.a, this.b, b0, this.d, this.e);
    }
}

