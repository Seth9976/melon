package com.iloen.melon.playback.playlist.add;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/SuccessExtra;", "", "<init>", "()V", "Normal", "MixUpSeedOverMaxSize", "MixUpSimple", "Lcom/iloen/melon/playback/playlist/add/SuccessExtra$MixUpSeedOverMaxSize;", "Lcom/iloen/melon/playback/playlist/add/SuccessExtra$MixUpSimple;", "Lcom/iloen/melon/playback/playlist/add/SuccessExtra$Normal;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class SuccessExtra {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001A\u00020\tHÖ\u0001J\t\u0010\n\u001A\u00020\u000BHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/SuccessExtra$MixUpSeedOverMaxSize;", "Lcom/iloen/melon/playback/playlist/add/SuccessExtra;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class MixUpSeedOverMaxSize extends SuccessExtra {
        public static final int $stable;
        @NotNull
        public static final MixUpSeedOverMaxSize INSTANCE;

        static {
            MixUpSeedOverMaxSize.INSTANCE = new MixUpSeedOverMaxSize();
        }

        private MixUpSeedOverMaxSize() {
            super(null);
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof MixUpSeedOverMaxSize;
        }

        @Override
        public int hashCode() {
            return -1030913197;
        }

        @Override
        @NotNull
        public String toString() {
            return "MixUpSeedOverMaxSize";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001A\u00020\tHÖ\u0001J\t\u0010\n\u001A\u00020\u000BHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/SuccessExtra$MixUpSimple;", "Lcom/iloen/melon/playback/playlist/add/SuccessExtra;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class MixUpSimple extends SuccessExtra {
        public static final int $stable;
        @NotNull
        public static final MixUpSimple INSTANCE;

        static {
            MixUpSimple.INSTANCE = new MixUpSimple();
        }

        private MixUpSimple() {
            super(null);
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof MixUpSimple;
        }

        @Override
        public int hashCode() {
            return 305059295;
        }

        @Override
        @NotNull
        public String toString() {
            return "MixUpSimple";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001A\u00020\tHÖ\u0001J\t\u0010\n\u001A\u00020\u000BHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/SuccessExtra$Normal;", "Lcom/iloen/melon/playback/playlist/add/SuccessExtra;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Normal extends SuccessExtra {
        public static final int $stable;
        @NotNull
        public static final Normal INSTANCE;

        static {
            Normal.INSTANCE = new Normal();
        }

        private Normal() {
            super(null);
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof Normal;
        }

        @Override
        public int hashCode() {
            return 0xA77BB7F1;
        }

        @Override
        @NotNull
        public String toString() {
            return "Normal";
        }
    }

    public static final int $stable;

    private SuccessExtra() {
    }

    public SuccessExtra(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

