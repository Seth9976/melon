package com.iloen.melon.player.video;

import A7.d;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\f\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0001 B%\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000B\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000B\u0010\nJ\u0010\u0010\f\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ.\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\b\b\u0002\u0010\u0006\u001A\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u0010\u0010\u0011\u001A\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\nJ\u001A\u0010\u0016\u001A\u00020\u00152\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u001A\u0010\nR\u0017\u0010\u0004\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001B\u0010\u0019\u001A\u0004\b\u001C\u0010\nR\u0017\u0010\u0006\u001A\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001D\u0010\u001E\u001A\u0004\b\u001F\u0010\r¨\u0006!"}, d2 = {"Lcom/iloen/melon/player/video/MotionProgress;", "", "", "startId", "endId", "", "progress", "<init>", "(IIF)V", "component1", "()I", "component2", "component3", "()F", "copy", "(IIF)Lcom/iloen/melon/player/video/MotionProgress;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getStartId", "b", "getEndId", "c", "F", "getProgress", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MotionProgress {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/player/video/MotionProgress$Companion;", "", "", "UNDEFINED_ID", "I", "", "INVALIDE_PROGRESS", "F", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    public static final float INVALIDE_PROGRESS = -1.0f;
    public static final int UNDEFINED_ID = -1;
    public final int a;
    public final int b;
    public final float c;

    static {
        MotionProgress.Companion = new Companion(null);
    }

    public MotionProgress() {
        this(0, 0, 0.0f, 7, null);
    }

    public MotionProgress(int v, int v1, float f) {
        this.a = v;
        this.b = v1;
        this.c = f;
    }

    public MotionProgress(int v, int v1, float f, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v2 & 1) != 0) {
            v = -1;
        }
        if((v2 & 2) != 0) {
            v1 = -1;
        }
        if((v2 & 4) != 0) {
            f = -1.0f;
        }
        this(v, v1, f);
    }

    public final int component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    public final float component3() {
        return this.c;
    }

    @NotNull
    public final MotionProgress copy(int v, int v1, float f) {
        return new MotionProgress(v, v1, f);
    }

    public static MotionProgress copy$default(MotionProgress motionProgress0, int v, int v1, float f, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = motionProgress0.a;
        }
        if((v2 & 2) != 0) {
            v1 = motionProgress0.b;
        }
        if((v2 & 4) != 0) {
            f = motionProgress0.c;
        }
        return motionProgress0.copy(v, v1, f);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof MotionProgress)) {
            return false;
        }
        if(this.a != ((MotionProgress)object0).a) {
            return false;
        }
        return this.b == ((MotionProgress)object0).b ? Float.compare(this.c, ((MotionProgress)object0).c) == 0 : false;
    }

    public final int getEndId() {
        return this.b;
    }

    public final float getProgress() {
        return this.c;
    }

    public final int getStartId() {
        return this.a;
    }

    @Override
    public int hashCode() {
        return Float.hashCode(this.c) + d.b(this.b, this.a * 0x1F, 0x1F);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = o.t(this.a, this.b, "MotionProgress(startId=", ", endId=", ", progress=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

