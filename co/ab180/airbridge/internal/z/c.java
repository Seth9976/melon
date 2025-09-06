package co.ab180.airbridge.internal.z;

import java.io.Closeable;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import we.a;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BO\u0012\n\u0010\u0004\u001A\u0006\u0012\u0002\b\u00030\u0003\u0012\u0016\u0010\u0007\u001A\u0012\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0006\u0012\b\b\u0002\u0010\t\u001A\u00020\b\u0012\u0018\b\u0002\u0010\f\u001A\u0012\u0012\u0004\u0012\u00020\b0\nj\b\u0012\u0004\u0012\u00020\b`\u000B¢\u0006\u0004\b\r\u0010\u000EJ\u0015\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001A\u00028\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001A\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0011\u0010\u0018R\u0018\u0010\u0004\u001A\u0006\u0012\u0002\b\u00030\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR$\u0010\u0007\u001A\u0012\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001C\u0010\u001DR\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001E\u0010\u001FR\'\u0010\f\u001A\u0012\u0012\u0004\u0012\u00020\b0\nj\b\u0012\u0004\u0012\u00020\b`\u000B8\u0006¢\u0006\f\n\u0004\b \u0010!\u001A\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lco/ab180/airbridge/internal/z/c;", "T", "Ljava/io/Closeable;", "Ljava/lang/Class;", "clazz", "Lkotlin/Function0;", "Lco/ab180/airbridge/internal/di/DebrisDefinitions;", "definition", "", "primaryType", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "subTypes", "<init>", "(Ljava/lang/Class;Lwe/a;Ljava/lang/String;Ljava/util/HashSet;)V", "targetName", "", "a", "(Ljava/lang/String;)Z", "h", "()Ljava/lang/Object;", "Lie/H;", "close", "()V", "Ljava/lang/Object;", "obj", "b", "Ljava/lang/Class;", "c", "Lwe/a;", "d", "Ljava/lang/String;", "e", "Ljava/util/HashSet;", "m", "()Ljava/util/HashSet;", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class c implements Closeable {
    private Object a;
    private final Class b;
    private final a c;
    private final String d;
    @NotNull
    private final HashSet e;

    public c(@NotNull Class class0, @NotNull a a0, @NotNull String s, @NotNull HashSet hashSet0) {
        this.b = class0;
        this.c = a0;
        this.d = s;
        this.e = hashSet0;
    }

    public c(Class class0, a a0, String s, HashSet hashSet0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 4) != 0) {
            s = class0.getName();
        }
        if((v & 8) != 0) {
            hashSet0 = new HashSet();
        }
        this(class0, a0, s, hashSet0);
    }

    // 去混淆评级： 低(20)
    public final boolean a(@NotNull String s) {
        return q.b(this.d, s) || this.e.contains(s);
    }

    @Override
    public void close() {
        this.a = null;
    }

    public final Object h() {
        synchronized(this.c) {
            if(this.a == null) {
                this.a = this.c.invoke();
            }
            return this.a;
        }
    }

    @NotNull
    public final HashSet m() {
        return this.e;
    }
}

