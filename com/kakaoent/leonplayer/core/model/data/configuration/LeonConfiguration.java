package com.kakaoent.leonplayer.core.model.data.configuration;

import e.k;
import java.util.List;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u00072\u00020\u0001:\u0002\u0007\bR\u0018\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonConfiguration;", "", "playerItemList", "", "Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonPlayerItem;", "getPlayerItemList", "()Ljava/util/List;", "Companion", "Impl", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface LeonConfiguration {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006J\u0018\u0010\u0003\u001A\u00020\u00042\u000E\b\u0002\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\bH\u0002¨\u0006\t"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonConfiguration$Companion;", "", "()V", "of", "Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonConfiguration;", "playerItem", "Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonPlayerItem;", "playItemList", "", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        static final Companion $$INSTANCE;

        static {
            Companion.$$INSTANCE = new Companion();
        }

        private final LeonConfiguration of(List list0) {
            return new Impl(list0);
        }

        @NotNull
        public final LeonConfiguration of(@NotNull LeonPlayerItem leonPlayerItem0) {
            q.g(leonPlayerItem0, "playerItem");
            return this.of(k.z(leonPlayerItem0));
        }

        public static LeonConfiguration of$default(Companion leonConfiguration$Companion0, List list0, int v, Object object0) {
            if((v & 1) != 0) {
                list0 = w.a;
            }
            return leonConfiguration$Companion0.of(list0);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000F\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001A\u00020\u00002\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u001A\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonConfiguration$Impl;", "Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonConfiguration;", "playerItemList", "", "Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonPlayerItem;", "(Ljava/util/List;)V", "getPlayerItemList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    static final class Impl implements LeonConfiguration {
        @NotNull
        private final List playerItemList;

        public Impl(@NotNull List list0) {
            q.g(list0, "playerItemList");
            super();
            this.playerItemList = list0;
        }

        @NotNull
        public final List component1() {
            return this.getPlayerItemList();
        }

        @NotNull
        public final Impl copy(@NotNull List list0) {
            q.g(list0, "playerItemList");
            return new Impl(list0);
        }

        public static Impl copy$default(Impl leonConfiguration$Impl0, List list0, int v, Object object0) {
            if((v & 1) != 0) {
                list0 = leonConfiguration$Impl0.getPlayerItemList();
            }
            return leonConfiguration$Impl0.copy(list0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof Impl ? q.b(this.getPlayerItemList(), ((Impl)object0).getPlayerItemList()) : false;
        }

        @Override  // com.kakaoent.leonplayer.core.model.data.configuration.LeonConfiguration
        @NotNull
        public List getPlayerItemList() {
            return this.playerItemList;
        }

        @Override
        public int hashCode() {
            return this.getPlayerItemList().hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "Impl(playerItemList=" + this.getPlayerItemList() + ')';
        }
    }

    @NotNull
    public static final Companion Companion;

    static {
        LeonConfiguration.Companion = Companion.$$INSTANCE;
    }

    @NotNull
    List getPlayerItemList();
}

