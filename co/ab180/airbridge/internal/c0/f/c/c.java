package co.ab180.airbridge.internal.c0.f.c;

import De.w;
import android.content.SharedPreferences;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\b\u001A\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ$\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\u00022\n\u0010\r\u001A\u0006\u0012\u0002\b\u00030\fH\u0096\u0002¢\u0006\u0004\b\u000E\u0010\u000FJ,\u0010\u000E\u001A\u00020\u00112\u0006\u0010\u000B\u001A\u00020\u00022\n\u0010\r\u001A\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u0010\u001A\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u000E\u0010\u0012R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\u0013R\u0014\u0010\u0007\u001A\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\b\u001A\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lco/ab180/airbridge/internal/c0/f/c/c;", "Lze/c;", "", "", "Landroid/content/SharedPreferences;", "preferences", "", "name", "default", "<init>", "(Landroid/content/SharedPreferences;Ljava/lang/String;J)V", "thisRef", "LDe/w;", "property", "a", "(Ljava/lang/Object;LDe/w;)Ljava/lang/Long;", "value", "Lie/H;", "(Ljava/lang/Object;LDe/w;J)V", "Landroid/content/SharedPreferences;", "b", "Ljava/lang/String;", "c", "J", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class c implements ze.c {
    private final SharedPreferences a;
    private final String b;
    private final long c;

    public c(@NotNull SharedPreferences sharedPreferences0, @NotNull String s, long v) {
        this.a = sharedPreferences0;
        this.b = s;
        this.c = v;
    }

    @NotNull
    public Long a(@NotNull Object object0, @NotNull w w0) {
        return this.a.getLong(this.b, this.c);
    }

    public void a(@NotNull Object object0, @NotNull w w0, long v) {
        this.a.edit().putLong(this.b, v).apply();
    }

    @Override  // ze.b
    public Object getValue(Object object0, w w0) {
        return this.a(object0, w0);
    }

    @Override  // ze.c
    public void setValue(Object object0, w w0, Object object1) {
        this.a(object0, w0, ((Number)object1).longValue());
    }
}

