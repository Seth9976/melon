package co.ab180.airbridge.internal.e0;

import android.content.Context;
import co.ab180.airbridge.internal.c0.f.a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0007\b \u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\r\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH&¢\u0006\u0004\b\r\u0010\u000EJ\u0015\u0010\r\u001A\u00020\u00022\u0006\u0010\u000F\u001A\u00020\u0000¢\u0006\u0004\b\r\u0010\u0010J%\u0010\r\u001A\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0002¢\u0006\u0004\b\r\u0010\u0011J\u000F\u0010\u0013\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0015\u001A\u0004\b\r\u0010\u0016R\u0017\u0010\u0004\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001A\u0004\b\u0017\u0010\u0016R\u0017\u0010\u0005\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001A\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2 = {"Lco/ab180/airbridge/internal/e0/s;", "", "", "major", "minor", "patch", "<init>", "(III)V", "Landroid/content/Context;", "context", "Lco/ab180/airbridge/internal/c0/f/a;", "preferenceStorage", "Lie/H;", "a", "(Landroid/content/Context;Lco/ab180/airbridge/internal/c0/f/a;)V", "other", "(Lco/ab180/airbridge/internal/e0/s;)I", "(III)I", "", "toString", "()Ljava/lang/String;", "I", "()I", "b", "c", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public abstract class s {
    private final int a;
    private final int b;
    private final int c;

    public s(int v, int v1, int v2) {
        this.a = v;
        this.b = v1;
        this.c = v2;
    }

    public final int a() {
        return this.a;
    }

    public final int a(int v, int v1, int v2) {
        int v3 = this.a - v;
        if(v3 != 0) {
            return v3;
        }
        int v4 = this.b - v1;
        if(v4 != 0) {
            return v4;
        }
        int v5 = this.c - v2;
        return v5 == 0 ? 0 : v5;
    }

    public final int a(@NotNull s s0) {
        return this.a(s0.a, s0.b, s0.c);
    }

    public abstract void a(@NotNull Context arg1, @NotNull a arg2);

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    @Override
    @NotNull
    public String toString() {
        return this.a + '.' + this.b + '.' + this.c;
    }
}

