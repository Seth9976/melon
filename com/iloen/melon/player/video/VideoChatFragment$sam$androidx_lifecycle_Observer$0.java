package com.iloen.melon.player.video;

import androidx.lifecycle.M;
import ie.f;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
final class VideoChatFragment.sam.androidx_lifecycle_Observer.0 implements M, k {
    public final we.k a;

    public VideoChatFragment.sam.androidx_lifecycle_Observer.0(we.k k0) {
        this.a = k0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(@Nullable Object object0) {
        return !(object0 instanceof M) || !(object0 instanceof k) ? false : q.b(this.getFunctionDelegate(), ((k)object0).getFunctionDelegate());
    }

    @Override  // kotlin.jvm.internal.k
    @NotNull
    public final f getFunctionDelegate() {
        return this.a;
    }

    @Override
    public final int hashCode() {
        return this.getFunctionDelegate().hashCode();
    }

    @Override  // androidx.lifecycle.M
    public final void onChanged(Object object0) {
        this.a.invoke(object0);
    }
}

