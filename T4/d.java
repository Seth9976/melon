package t4;

import M6.B;
import android.net.Uri;
import android.view.InputEvent;
import e.k;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u4.c;
import u4.f;

public final class d extends e {
    public final c a;

    public d(c c0) {
        this.a = c0;
    }

    @Override  // t4.e
    @NotNull
    public B a() {
        return k.f(BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new a(this, null), 3, null));
    }

    @Override  // t4.e
    @NotNull
    public B b(@NotNull Uri uri0) {
        q.g(uri0, "trigger");
        return k.f(BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new t4.c(this, uri0, null), 3, null));
    }

    @NotNull
    public B c(@NotNull u4.a a0) {
        q.g(a0, "deletionRequest");
        throw null;
    }

    @NotNull
    public B d(@NotNull Uri uri0, @Nullable InputEvent inputEvent0) {
        q.g(uri0, "attributionSource");
        return k.f(BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new b(this, uri0, inputEvent0, null), 3, null));
    }

    @NotNull
    public B e(@NotNull u4.d d0) {
        q.g(d0, "request");
        throw null;
    }

    @NotNull
    public B f(@NotNull u4.e e0) {
        q.g(e0, "request");
        throw null;
    }

    @NotNull
    public B g(@NotNull f f0) {
        q.g(f0, "request");
        throw null;
    }
}

