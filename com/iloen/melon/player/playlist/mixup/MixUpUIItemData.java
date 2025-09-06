package com.iloen.melon.player.playlist.mixup;

import A7.d;
import U4.x;
import Ud.a;
import Ud.h;
import com.melon.playlist.interfaces.PlayableData;
import com.melon.ui.K4;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0005\u0006J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\u0007\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/player/playlist/mixup/MixUpUIItemData;", "Lcom/melon/ui/K4;", "", "getId", "()Ljava/lang/String;", "WaitingTitle", "PlayableItem", "Lcom/iloen/melon/player/playlist/mixup/MixUpUIItemData$PlayableItem;", "Lcom/iloen/melon/player/playlist/mixup/MixUpUIItemData$WaitingTitle;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface MixUpUIItemData extends K4 {
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B7\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\b\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\u0006\u0012\u0006\u0010\n\u001A\u00020\u0006\u0012\u0006\u0010\u000B\u001A\u00020\u0006\u00A2\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0016\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\u0016\u0010\u0014J\u0010\u0010\u0017\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u0014J\u0010\u0010\u0018\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0014JL\u0010\u0019\u001A\u00020\u00002\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u00062\b\b\u0002\u0010\b\u001A\u00020\u00062\b\b\u0002\u0010\t\u001A\u00020\u00062\b\b\u0002\u0010\n\u001A\u00020\u00062\b\b\u0002\u0010\u000B\u001A\u00020\u0006H\u00C6\u0001\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u001B\u001A\u00020\u000EH\u00D6\u0001\u00A2\u0006\u0004\b\u001B\u0010\u0010J\u0010\u0010\u001D\u001A\u00020\u001CH\u00D6\u0001\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u001A\u0010!\u001A\u00020\u00062\b\u0010 \u001A\u0004\u0018\u00010\u001FH\u00D6\u0003\u00A2\u0006\u0004\b!\u0010\"R\u0017\u0010\u0005\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b#\u0010$\u001A\u0004\b%\u0010\u0012R\u001A\u0010\u0007\u001A\u00020\u00068\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b&\u0010\'\u001A\u0004\b\u0007\u0010\u0014R\u001A\u0010\b\u001A\u00020\u00068\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b(\u0010\'\u001A\u0004\b\b\u0010\u0014R\u0017\u0010\t\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\b)\u0010\'\u001A\u0004\b\t\u0010\u0014R\u0017\u0010\n\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\b*\u0010\'\u001A\u0004\b\n\u0010\u0014R\u0017\u0010\u000B\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\b+\u0010\'\u001A\u0004\b\u000B\u0010\u0014\u00A8\u0006,"}, d2 = {"Lcom/iloen/melon/player/playlist/mixup/MixUpUIItemData$PlayableItem;", "Lcom/iloen/melon/player/playlist/mixup/MixUpUIItemData;", "LUd/h;", "LUd/a;", "Lcom/melon/playlist/interfaces/PlayableData;", "playableData", "", "isSelected", "isMarquee", "isCurrent", "isCurrentPlaylist", "isPlaying", "<init>", "(Lcom/melon/playlist/interfaces/PlayableData;ZZZZZ)V", "", "getId", "()Ljava/lang/String;", "component1", "()Lcom/melon/playlist/interfaces/PlayableData;", "component2", "()Z", "component3", "component4", "component5", "component6", "copy", "(Lcom/melon/playlist/interfaces/PlayableData;ZZZZZ)Lcom/iloen/melon/player/playlist/mixup/MixUpUIItemData$PlayableItem;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/melon/playlist/interfaces/PlayableData;", "getPlayableData", "b", "Z", "c", "d", "e", "f", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class PlayableItem implements a, h, MixUpUIItemData {
        public static final int $stable = 8;
        public final PlayableData a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        public final boolean f;

        public PlayableItem(@NotNull PlayableData playableData0, boolean z, boolean z1, boolean z2, boolean z3, boolean z4) {
            q.g(playableData0, "playableData");
            super();
            this.a = playableData0;
            this.b = z;
            this.c = z1;
            this.d = z2;
            this.e = z3;
            this.f = z4;
        }

        @NotNull
        public final PlayableData component1() {
            return this.a;
        }

        public final boolean component2() {
            return this.b;
        }

        public final boolean component3() {
            return this.c;
        }

        public final boolean component4() {
            return this.d;
        }

        public final boolean component5() {
            return this.e;
        }

        public final boolean component6() {
            return this.f;
        }

        @NotNull
        public final PlayableItem copy(@NotNull PlayableData playableData0, boolean z, boolean z1, boolean z2, boolean z3, boolean z4) {
            q.g(playableData0, "playableData");
            return new PlayableItem(playableData0, z, z1, z2, z3, z4);
        }

        public static PlayableItem copy$default(PlayableItem mixUpUIItemData$PlayableItem0, PlayableData playableData0, boolean z, boolean z1, boolean z2, boolean z3, boolean z4, int v, Object object0) {
            if((v & 1) != 0) {
                playableData0 = mixUpUIItemData$PlayableItem0.a;
            }
            if((v & 2) != 0) {
                z = mixUpUIItemData$PlayableItem0.b;
            }
            if((v & 4) != 0) {
                z1 = mixUpUIItemData$PlayableItem0.c;
            }
            if((v & 8) != 0) {
                z2 = mixUpUIItemData$PlayableItem0.d;
            }
            if((v & 16) != 0) {
                z3 = mixUpUIItemData$PlayableItem0.e;
            }
            if((v & 0x20) != 0) {
                z4 = mixUpUIItemData$PlayableItem0.f;
            }
            return mixUpUIItemData$PlayableItem0.copy(playableData0, z, z1, z2, z3, z4);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof PlayableItem)) {
                return false;
            }
            if(!q.b(this.a, ((PlayableItem)object0).a)) {
                return false;
            }
            if(this.b != ((PlayableItem)object0).b) {
                return false;
            }
            if(this.c != ((PlayableItem)object0).c) {
                return false;
            }
            if(this.d != ((PlayableItem)object0).d) {
                return false;
            }
            return this.e == ((PlayableItem)object0).e ? this.f == ((PlayableItem)object0).f : false;
        }

        @Override  // com.iloen.melon.player.playlist.mixup.MixUpUIItemData
        @NotNull
        public String getId() {
            String s = this.a.b;
            return s == null ? "" : s;
        }

        @NotNull
        public final PlayableData getPlayableData() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return Boolean.hashCode(this.f) + d.e(d.e(d.e(d.e(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e);
        }

        public final boolean isCurrent() {
            return this.d;
        }

        public final boolean isCurrentPlaylist() {
            return this.e;
        }

        @Override  // Ud.a
        public boolean isMarquee() {
            return this.c;
        }

        public final boolean isPlaying() {
            return this.f;
        }

        @Override  // Ud.h
        public boolean isSelected() {
            return this.b;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("PlayableItem(playableData=");
            stringBuilder0.append(this.a);
            stringBuilder0.append(", isSelected=");
            stringBuilder0.append(this.b);
            stringBuilder0.append(", isMarquee=");
            x.y(stringBuilder0, this.c, ", isCurrent=", this.d, ", isCurrentPlaylist=");
            stringBuilder0.append(this.e);
            stringBuilder0.append(", isPlaying=");
            stringBuilder0.append(this.f);
            stringBuilder0.append(")");
            return stringBuilder0.toString();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001A\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001A\u0010\f\u001A\u00020\u000B2\b\u0010\n\u001A\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/player/playlist/mixup/MixUpUIItemData$WaitingTitle;", "Lcom/iloen/melon/player/playlist/mixup/MixUpUIItemData;", "", "getId", "()Ljava/lang/String;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class WaitingTitle implements MixUpUIItemData {
        public static final int $stable;
        @NotNull
        public static final WaitingTitle INSTANCE;

        static {
            WaitingTitle.INSTANCE = new WaitingTitle();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof WaitingTitle;
        }

        // 检测为 Lambda 实现
        @Override  // com.iloen.melon.player.playlist.mixup.MixUpUIItemData
        @NotNull
        public String getId() [...]

        @Override
        public int hashCode() {
            return 0x6A7C2958;
        }

        @Override
        @NotNull
        public String toString() {
            return "WaitingTitle";
        }
    }

    @NotNull
    String getId();
}

