package co.ab180.airbridge.internal.c0.f.c;

import De.w;
import android.content.SharedPreferences;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ze.c;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B!\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ&\u0010\r\u001A\u0004\u0018\u00010\u00032\u0006\u0010\n\u001A\u00020\u00022\n\u0010\f\u001A\u0006\u0012\u0002\b\u00030\u000BH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000EJ.\u0010\r\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u00022\n\u0010\f\u001A\u0006\u0012\u0002\b\u00030\u000B2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\r\u0010\u0011R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0014\u0010\u0006\u001A\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0007\u001A\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014¨\u0006\u0016"}, d2 = {"Lco/ab180/airbridge/internal/c0/f/c/e;", "Lze/c;", "", "", "Landroid/content/SharedPreferences;", "preferences", "name", "default", "<init>", "(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/String;)V", "thisRef", "LDe/w;", "property", "a", "(Ljava/lang/Object;LDe/w;)Ljava/lang/String;", "value", "Lie/H;", "(Ljava/lang/Object;LDe/w;Ljava/lang/String;)V", "Landroid/content/SharedPreferences;", "b", "Ljava/lang/String;", "c", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class e implements c {
    private final SharedPreferences a;
    private final String b;
    private final String c;

    public e(@NotNull SharedPreferences sharedPreferences0, @NotNull String s, @Nullable String s1) {
        this.a = sharedPreferences0;
        this.b = s;
        this.c = s1;
    }

    @Nullable
    public String a(@NotNull Object object0, @NotNull w w0) {
        String s = this.a.getString(this.b, this.c);
        return s == null ? this.c : s;
    }

    public void a(@NotNull Object object0, @NotNull w w0, @Nullable String s) {
        this.a.edit().putString(this.b, s).apply();
    }

    @Override  // ze.b
    public Object getValue(Object object0, w w0) {
        return this.a(object0, w0);
    }

    @Override  // ze.c
    public void setValue(Object object0, w w0, Object object1) {
        this.a(object0, w0, ((String)object1));
    }
}

