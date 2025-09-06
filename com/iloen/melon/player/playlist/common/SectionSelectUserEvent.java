package com.iloen.melon.player.playlist.common;

import Pc.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/player/playlist/common/SectionSelectUserEvent;", "LPc/e;", "ClickSectionSelectButton", "ClickSectionSelectCancelButton", "Lcom/iloen/melon/player/playlist/common/SectionSelectUserEvent$ClickSectionSelectButton;", "Lcom/iloen/melon/player/playlist/common/SectionSelectUserEvent$ClickSectionSelectCancelButton;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class SectionSelectUserEvent implements e {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/common/SectionSelectUserEvent$ClickSectionSelectButton;", "Lcom/iloen/melon/player/playlist/common/SectionSelectUserEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ClickSectionSelectButton extends SectionSelectUserEvent {
        public static final int $stable;
        @NotNull
        public static final ClickSectionSelectButton INSTANCE;

        static {
            ClickSectionSelectButton.INSTANCE = new ClickSectionSelectButton(null);  // 初始化器: Lcom/iloen/melon/player/playlist/common/SectionSelectUserEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof ClickSectionSelectButton;
        }

        @Override
        public int hashCode() {
            return -1410901128;
        }

        @Override
        @NotNull
        public String toString() {
            return "ClickSectionSelectButton";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/common/SectionSelectUserEvent$ClickSectionSelectCancelButton;", "Lcom/iloen/melon/player/playlist/common/SectionSelectUserEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ClickSectionSelectCancelButton extends SectionSelectUserEvent {
        public static final int $stable;
        @NotNull
        public static final ClickSectionSelectCancelButton INSTANCE;

        static {
            ClickSectionSelectCancelButton.INSTANCE = new ClickSectionSelectCancelButton(null);  // 初始化器: Lcom/iloen/melon/player/playlist/common/SectionSelectUserEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof ClickSectionSelectCancelButton;
        }

        @Override
        public int hashCode() {
            return 0x57E16612;
        }

        @Override
        @NotNull
        public String toString() {
            return "ClickSectionSelectCancelButton";
        }
    }

    public static final int $stable;

    public SectionSelectUserEvent(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

