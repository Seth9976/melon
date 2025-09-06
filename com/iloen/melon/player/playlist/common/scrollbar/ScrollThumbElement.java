package com.iloen.melon.player.playlist.common.scrollbar;

import P0.a0;
import P0.f;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r0.p;
import we.k;
import we.n;
import y0.u;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\u0007\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\r\u001A\u00020\u0003HÆ\u0003¢\u0006\u0004\b\r\u0010\u000EJ\u001A\u0010\u000F\u001A\u00020\u00002\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0012\u001A\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001A\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001A\u0010\u001A\u001A\u00020\u00192\b\u0010\u0018\u001A\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001A\u0010\u001BR\u0017\u0010\u0004\u001A\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u000E¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/player/playlist/common/scrollbar/ScrollThumbElement;", "LP0/a0;", "Lcom/iloen/melon/player/playlist/common/scrollbar/ScrollThumbNode;", "Ly0/u;", "colorProducer", "<init>", "(Ly0/u;)V", "create", "()Lcom/iloen/melon/player/playlist/common/scrollbar/ScrollThumbNode;", "node", "Lie/H;", "update", "(Lcom/iloen/melon/player/playlist/common/scrollbar/ScrollThumbNode;)V", "component1", "()Ly0/u;", "copy", "(Ly0/u;)Lcom/iloen/melon/player/playlist/common/scrollbar/ScrollThumbElement;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ly0/u;", "getColorProducer", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
final class ScrollThumbElement extends a0 {
    public final u a;

    public ScrollThumbElement(@NotNull u u0) {
        q.g(u0, "colorProducer");
        super();
        this.a = u0;
    }

    @Override  // r0.o
    public boolean all(@NotNull k k0) {
        return super.all(k0);
    }

    @Override  // r0.o
    public boolean any(@NotNull k k0) {
        return super.any(k0);
    }

    @NotNull
    public final u component1() {
        return this.a;
    }

    @NotNull
    public final ScrollThumbElement copy(@NotNull u u0) {
        q.g(u0, "colorProducer");
        return new ScrollThumbElement(u0);
    }

    public static ScrollThumbElement copy$default(ScrollThumbElement scrollThumbElement0, u u0, int v, Object object0) {
        if((v & 1) != 0) {
            u0 = scrollThumbElement0.a;
        }
        return scrollThumbElement0.copy(u0);
    }

    @NotNull
    public ScrollThumbNode create() {
        return new ScrollThumbNode(this.a);
    }

    @Override  // P0.a0
    public p create() {
        return this.create();
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof ScrollThumbElement ? q.b(this.a, ((ScrollThumbElement)object0).a) : false;
    }

    @Override  // r0.o
    public Object foldIn(Object object0, @NotNull n n0) {
        return n0.invoke(object0, this);
    }

    public Object foldOut(Object object0, @NotNull n n0) {
        return n0.invoke(this, object0);
    }

    @NotNull
    public final u getColorProducer() {
        return this.a;
    }

    @Override
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override  // r0.q
    @NotNull
    public r0.q then(@NotNull r0.q q0) {
        return super.then(q0);
    }

    @Override
    @NotNull
    public String toString() {
        return "ScrollThumbElement(colorProducer=" + this.a + ")";
    }

    public void update(@NotNull ScrollThumbNode scrollThumbNode0) {
        q.g(scrollThumbNode0, "node");
        scrollThumbNode0.setColorProducer(this.a);
        f.m(scrollThumbNode0);
    }

    @Override  // P0.a0
    public void update(p p0) {
        this.update(((ScrollThumbNode)p0));
    }
}

