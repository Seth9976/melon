package com.iloen.melon.playback;

import Cb.k;
import com.iloen.melon.utils.log.error.MelonDebugUtils;
import h7.u0;
import java.util.Comparator;
import java.util.Locale;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\bÇ\u0002\u0018\u00002\u00020\u0001:\t\u0017\u0018\u0019\u001A\u001B\u001C\u001D\u001E\u001FB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0007H\u0002J\u0016\u0010\t\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0007J\u0016\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\fJ\u0018\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\fH\u0002J\u0010\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\fJ!\u0010\u0012\u001A\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001A\u00020\u00102\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016¨\u0006 "}, d2 = {"Lcom/iloen/melon/playback/PlayableComparators;", "", "<init>", "()V", "myOrder", "", "p0", "Lcom/iloen/melon/playback/Playable;", "p1", "compareBySongName", "compareString", "str1", "", "str2", "compareStringReverse", "getFirstCharacter", "", "str", "getChosungFromHangulChar", "char", "unicodeBlock", "Ljava/lang/Character$UnicodeBlock;", "(CLjava/lang/Character$UnicodeBlock;)Ljava/lang/Character;", "MyOrderPlayableComparator", "MostlyThenMyOrderPlayableComparator", "MostlyThenSongNamePlayableComparator", "RecentlyPlayableComparator", "ArtistPlayableComparator", "ArtistReversePlayableComparator", "SongPlayableComparator", "AlbumPlayableComparator", "StringType", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlayableComparators {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/iloen/melon/playback/PlayableComparators$AlbumPlayableComparator;", "Ljava/util/Comparator;", "Lcom/iloen/melon/playback/Playable;", "<init>", "()V", "compare", "", "p0", "p1", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class AlbumPlayableComparator implements Comparator {
        public static final int $stable;

        // 去混淆评级： 低(26)
        public int compare(@NotNull Playable playable0, @NotNull Playable playable1) {
            q.g(playable0, "p0");
            q.g(playable1, "p1");
            String s = Y.j("getDefault(...)", "", "toLowerCase(...)");
            String s1 = Y.j("getDefault(...)", "", "toLowerCase(...)");
            int v = PlayableComparators.INSTANCE.compareString(s, s1);
            return v == 0 ? PlayableComparators.INSTANCE.compareString(Y.j("getDefault(...)", "", "toLowerCase(...)"), Y.j("getDefault(...)", "", "toLowerCase(...)")) : v;
        }

        @Override
        public int compare(Object object0, Object object1) {
            return this.compare(((Playable)object0), ((Playable)object1));
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/iloen/melon/playback/PlayableComparators$ArtistPlayableComparator;", "Ljava/util/Comparator;", "Lcom/iloen/melon/playback/Playable;", "<init>", "()V", "compare", "", "p0", "p1", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ArtistPlayableComparator implements Comparator {
        public static final int $stable;

        // 去混淆评级： 低(24)
        public int compare(@NotNull Playable playable0, @NotNull Playable playable1) {
            q.g(playable0, "p0");
            q.g(playable1, "p1");
            String s = Y.j("getDefault(...)", "", "toLowerCase(...)");
            String s1 = Y.j("getDefault(...)", "", "toLowerCase(...)");
            PlayableComparators playableComparators0 = PlayableComparators.INSTANCE;
            int v = playableComparators0.compareString(s, s1);
            if(v != 0) {
                return v;
            }
            int v1 = playableComparators0.compareString(Y.j("getDefault(...)", "", "toLowerCase(...)"), Y.j("getDefault(...)", "", "toLowerCase(...)"));
            return v1 == 0 ? playableComparators0.compareString(Y.j("getDefault(...)", "", "toLowerCase(...)"), Y.j("getDefault(...)", "", "toLowerCase(...)")) : v1;
        }

        @Override
        public int compare(Object object0, Object object1) {
            return this.compare(((Playable)object0), ((Playable)object1));
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/iloen/melon/playback/PlayableComparators$ArtistReversePlayableComparator;", "Ljava/util/Comparator;", "Lcom/iloen/melon/playback/Playable;", "<init>", "()V", "compare", "", "p0", "p1", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ArtistReversePlayableComparator implements Comparator {
        public static final int $stable;

        // 去混淆评级： 低(24)
        public int compare(@NotNull Playable playable0, @NotNull Playable playable1) {
            q.g(playable0, "p0");
            q.g(playable1, "p1");
            String s = Y.j("getDefault(...)", "", "toLowerCase(...)");
            String s1 = Y.j("getDefault(...)", "", "toLowerCase(...)");
            PlayableComparators playableComparators0 = PlayableComparators.INSTANCE;
            int v = playableComparators0.compareStringReverse(s, s1);
            if(v != 0) {
                return v;
            }
            int v1 = playableComparators0.compareString(Y.j("getDefault(...)", "", "toLowerCase(...)"), Y.j("getDefault(...)", "", "toLowerCase(...)"));
            return v1 == 0 ? playableComparators0.compareString(Y.j("getDefault(...)", "", "toLowerCase(...)"), Y.j("getDefault(...)", "", "toLowerCase(...)")) : v1;
        }

        @Override
        public int compare(Object object0, Object object1) {
            return this.compare(((Playable)object0), ((Playable)object1));
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/iloen/melon/playback/PlayableComparators$MostlyThenMyOrderPlayableComparator;", "Ljava/util/Comparator;", "Lcom/iloen/melon/playback/Playable;", "<init>", "()V", "compare", "", "p0", "p1", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class MostlyThenMyOrderPlayableComparator implements Comparator {
        public static final int $stable;

        public int compare(@NotNull Playable playable0, @NotNull Playable playable1) {
            q.g(playable0, "p0");
            q.g(playable1, "p1");
            return playable0.getPlayCount() == playable1.getPlayCount() ? PlayableComparators.INSTANCE.myOrder(playable0, playable1) : playable1.getPlayCount() - playable0.getPlayCount();
        }

        @Override
        public int compare(Object object0, Object object1) {
            return this.compare(((Playable)object0), ((Playable)object1));
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/iloen/melon/playback/PlayableComparators$MostlyThenSongNamePlayableComparator;", "Ljava/util/Comparator;", "Lcom/iloen/melon/playback/Playable;", "<init>", "()V", "compare", "", "p0", "p1", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class MostlyThenSongNamePlayableComparator implements Comparator {
        public static final int $stable;

        public int compare(@NotNull Playable playable0, @NotNull Playable playable1) {
            q.g(playable0, "p0");
            q.g(playable1, "p1");
            return playable0.getPlayCount() == playable1.getPlayCount() ? PlayableComparators.INSTANCE.compareBySongName(playable0, playable1) : playable1.getPlayCount() - playable0.getPlayCount();
        }

        @Override
        public int compare(Object object0, Object object1) {
            return this.compare(((Playable)object0), ((Playable)object1));
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/iloen/melon/playback/PlayableComparators$MyOrderPlayableComparator;", "Ljava/util/Comparator;", "Lcom/iloen/melon/playback/Playable;", "<init>", "()V", "compare", "", "p0", "p1", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class MyOrderPlayableComparator implements Comparator {
        public static final int $stable;

        public int compare(@NotNull Playable playable0, @NotNull Playable playable1) {
            q.g(playable0, "p0");
            q.g(playable1, "p1");
            return PlayableComparators.INSTANCE.myOrder(playable0, playable1);
        }

        @Override
        public int compare(Object object0, Object object1) {
            return this.compare(((Playable)object0), ((Playable)object1));
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/iloen/melon/playback/PlayableComparators$RecentlyPlayableComparator;", "Ljava/util/Comparator;", "Lcom/iloen/melon/playback/Playable;", "<init>", "()V", "compare", "", "p0", "p1", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RecentlyPlayableComparator implements Comparator {
        public static final int $stable;

        public int compare(@NotNull Playable playable0, @NotNull Playable playable1) {
            q.g(playable0, "p0");
            q.g(playable1, "p1");
            if(playable0.getCreatedAt() == playable1.getCreatedAt()) {
                return playable1.getCreatedSeq() - playable0.getCreatedSeq();
            }
            return playable0.getCreatedAt() >= playable1.getCreatedAt() ? -1 : 1;
        }

        @Override
        public int compare(Object object0, Object object1) {
            return this.compare(((Playable)object0), ((Playable)object1));
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/iloen/melon/playback/PlayableComparators$SongPlayableComparator;", "Ljava/util/Comparator;", "Lcom/iloen/melon/playback/Playable;", "<init>", "()V", "compare", "", "p0", "p1", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class SongPlayableComparator implements Comparator {
        public static final int $stable;

        public int compare(@NotNull Playable playable0, @NotNull Playable playable1) {
            q.g(playable0, "p0");
            q.g(playable1, "p1");
            return PlayableComparators.INSTANCE.compareBySongName(playable0, playable1);
        }

        @Override
        public int compare(Object object0, Object object1) {
            return this.compare(((Playable)object0), ((Playable)object1));
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \r2\u00020\u0001:\u0006\b\t\n\u000B\f\rB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0082\u0001\u0005\u000E\u000F\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/playback/PlayableComparators$StringType;", "", "priority", "", "<init>", "(I)V", "getPriority", "()I", "HANGUL", "ENGLISH", "NUMBER", "OTHERS", "EMPTY", "Companion", "Lcom/iloen/melon/playback/PlayableComparators$StringType$EMPTY;", "Lcom/iloen/melon/playback/PlayableComparators$StringType$ENGLISH;", "Lcom/iloen/melon/playback/PlayableComparators$StringType$HANGUL;", "Lcom/iloen/melon/playback/PlayableComparators$StringType$NUMBER;", "Lcom/iloen/melon/playback/PlayableComparators$StringType$OTHERS;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static abstract class StringType {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/playback/PlayableComparators$StringType$Companion;", "", "<init>", "()V", "getStringType", "Lcom/iloen/melon/playback/PlayableComparators$StringType;", "str", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class Companion {
            private Companion() {
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final StringType getStringType(@Nullable String s) {
                if(s != null && s.length() != 0) {
                    int v = s.charAt(0);
                    if(u0.K(((char)v))) {
                        return EMPTY.INSTANCE;
                    }
                    Character.UnicodeBlock character$UnicodeBlock0 = Character.UnicodeBlock.of(((char)v));
                    if(character$UnicodeBlock0 != null && k.a.contains(character$UnicodeBlock0)) {
                        Character character0 = PlayableComparators.INSTANCE.getChosungFromHangulChar(((char)v), character$UnicodeBlock0);
                        return character0 != null ? new HANGUL(character0.charValue()) : OTHERS.INSTANCE;
                    }
                    if(65 <= v && v < 91 || 97 <= v && v < 0x7B) {
                        return ENGLISH.INSTANCE;
                    }
                    return 0x30 <= v && v < 58 ? NUMBER.INSTANCE : OTHERS.INSTANCE;
                }
                return EMPTY.INSTANCE;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/playback/PlayableComparators$StringType$EMPTY;", "Lcom/iloen/melon/playback/PlayableComparators$StringType;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class EMPTY extends StringType {
            public static final int $stable;
            @NotNull
            public static final EMPTY INSTANCE;

            static {
                EMPTY.INSTANCE = new EMPTY();
            }

            private EMPTY() {
                super(5, null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/playback/PlayableComparators$StringType$ENGLISH;", "Lcom/iloen/melon/playback/PlayableComparators$StringType;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class ENGLISH extends StringType {
            public static final int $stable;
            @NotNull
            public static final ENGLISH INSTANCE;

            static {
                ENGLISH.INSTANCE = new ENGLISH();
            }

            private ENGLISH() {
                super(2, null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/playback/PlayableComparators$StringType$HANGUL;", "Lcom/iloen/melon/playback/PlayableComparators$StringType;", "chosung", "", "<init>", "(C)V", "getChosung", "()C", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class HANGUL extends StringType {
            public static final int $stable;
            private final char chosung;

            public HANGUL(char c) {
                super(1, null);
                this.chosung = c;
            }

            public final char getChosung() {
                return this.chosung;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/playback/PlayableComparators$StringType$NUMBER;", "Lcom/iloen/melon/playback/PlayableComparators$StringType;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class NUMBER extends StringType {
            public static final int $stable;
            @NotNull
            public static final NUMBER INSTANCE;

            static {
                NUMBER.INSTANCE = new NUMBER();
            }

            private NUMBER() {
                super(3, null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/playback/PlayableComparators$StringType$OTHERS;", "Lcom/iloen/melon/playback/PlayableComparators$StringType;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class OTHERS extends StringType {
            public static final int $stable;
            @NotNull
            public static final OTHERS INSTANCE;

            static {
                OTHERS.INSTANCE = new OTHERS();
            }

            private OTHERS() {
                super(4, null);
            }
        }

        public static final int $stable;
        @NotNull
        public static final Companion Companion;
        private final int priority;

        static {
            StringType.Companion = new Companion(null);
        }

        private StringType(int v) {
            this.priority = v;
        }

        public StringType(int v, DefaultConstructorMarker defaultConstructorMarker0) {
            this(v);
        }

        public final int getPriority() {
            return this.priority;
        }
    }

    public static final int $stable;
    @NotNull
    public static final PlayableComparators INSTANCE;

    static {
        PlayableComparators.INSTANCE = new PlayableComparators();
    }

    // 去混淆评级： 低(26)
    public final int compareBySongName(@NotNull Playable playable0, @NotNull Playable playable1) {
        q.g(playable0, "p0");
        q.g(playable1, "p1");
        return this.compareString(Y.j("getDefault(...)", "", "toLowerCase(...)"), Y.j("getDefault(...)", "", "toLowerCase(...)"));
    }

    public final int compareString(@NotNull String s, @NotNull String s1) {
        q.g(s, "str1");
        q.g(s1, "str2");
        StringType playableComparators$StringType0 = StringType.Companion.getStringType(s);
        StringType playableComparators$StringType1 = StringType.Companion.getStringType(s1);
        try {
            if(playableComparators$StringType0.getPriority() != playableComparators$StringType1.getPriority()) {
                return playableComparators$StringType0.getPriority() - playableComparators$StringType1.getPriority();
            }
            if(playableComparators$StringType0 instanceof HANGUL) {
                HANGUL playableComparators$StringType$HANGUL0 = (HANGUL)playableComparators$StringType1;
                return ((HANGUL)playableComparators$StringType0).getChosung() == ((HANGUL)playableComparators$StringType1).getChosung() ? s.compareTo(s1) : ((HANGUL)playableComparators$StringType0).getChosung() - ((HANGUL)playableComparators$StringType1).getChosung();
            }
            if(playableComparators$StringType0 instanceof ENGLISH) {
                Locale locale0 = Locale.getDefault();
                q.f(locale0, "getDefault(...)");
                String s2 = s.toUpperCase(locale0);
                q.f(s2, "toUpperCase(...)");
                Locale locale1 = Locale.getDefault();
                q.f(locale1, "getDefault(...)");
                String s3 = s1.toUpperCase(locale1);
                q.f(s3, "toUpperCase(...)");
                return s2.compareTo(s3);
            }
            return s.compareTo(s1);
        }
        catch(Exception exception0) {
        }
        MelonDebugUtils.INSTANCE.errorLogOrException("Comparator", (exception0.getMessage() == null ? "compareString error" : exception0.getMessage()));
        return s.compareTo(s1);
    }

    private final int compareStringReverse(String s, String s1) {
        return -this.compareString(s, s1);
    }

    @Nullable
    public final Character getChosungFromHangulChar(char c, @Nullable Character.UnicodeBlock character$UnicodeBlock0) {
        Character.UnicodeBlock character$UnicodeBlock1 = character$UnicodeBlock0 == null ? Character.UnicodeBlock.of(c) : character$UnicodeBlock0;
        if(q.b(character$UnicodeBlock1, Character.UnicodeBlock.HANGUL_JAMO)) {
            switch(c - 0x1100) {
                case 0: 
                case 1: {
                    return Character.valueOf('ㄱ');
                }
                case 2: {
                    return Character.valueOf('ㄴ');
                }
                case 3: 
                case 4: {
                    return Character.valueOf('ㄷ');
                }
                case 5: {
                    return Character.valueOf('ㄹ');
                }
                case 6: {
                    return Character.valueOf('ㅁ');
                }
                case 7: 
                case 8: {
                    return Character.valueOf('ㅂ');
                }
                case 9: 
                case 10: {
                    return Character.valueOf('ㅅ');
                }
                case 11: {
                    return Character.valueOf('ㅇ');
                }
                case 12: 
                case 13: {
                    return Character.valueOf('ㅈ');
                }
                case 14: {
                    return Character.valueOf('ㅊ');
                }
                case 15: {
                    return Character.valueOf('ㅋ');
                }
                case 16: {
                    return Character.valueOf('ㅌ');
                }
                case 17: {
                    return Character.valueOf('ㅍ');
                }
                case 18: {
                    return Character.valueOf('ㅎ');
                }
                default: {
                    return null;
                }
            }
        }
        if(q.b(character$UnicodeBlock1, Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO)) {
            switch(c - 0x3131) {
                case 0: 
                case 1: 
                case 2: {
                    return Character.valueOf('ㄱ');
                }
                case 3: 
                case 4: 
                case 5: {
                    return Character.valueOf('ㄴ');
                }
                case 6: 
                case 7: {
                    return Character.valueOf('ㄷ');
                }
                case 8: 
                case 9: 
                case 10: 
                case 11: 
                case 12: 
                case 13: 
                case 14: 
                case 15: {
                    return Character.valueOf('ㄹ');
                }
                case 16: {
                    return Character.valueOf('ㅁ');
                }
                case 17: 
                case 18: 
                case 19: {
                    return Character.valueOf('ㅂ');
                }
                case 20: 
                case 21: {
                    return Character.valueOf('ㅅ');
                }
                case 22: {
                    return Character.valueOf('ㅇ');
                }
                case 23: 
                case 24: {
                    return Character.valueOf('ㅈ');
                }
                case 25: {
                    return Character.valueOf('ㅊ');
                }
                case 26: {
                    return Character.valueOf('ㅋ');
                }
                case 27: {
                    return Character.valueOf('ㅌ');
                }
                case 28: {
                    return Character.valueOf('ㅍ');
                }
                case 29: {
                    return Character.valueOf('ㅎ');
                }
                default: {
                    return null;
                }
            }
        }
        if(q.b(character$UnicodeBlock1, Character.UnicodeBlock.HANGUL_SYLLABLES)) {
            switch((c - 0xAC00) / 588) {
                case 0: 
                case 1: {
                    return Character.valueOf('ㄱ');
                }
                case 2: {
                    return Character.valueOf('ㄴ');
                }
                case 3: 
                case 4: {
                    return Character.valueOf('ㄷ');
                }
                case 5: {
                    return Character.valueOf('ㄹ');
                }
                case 6: {
                    return Character.valueOf('ㅁ');
                }
                case 7: 
                case 8: {
                    return Character.valueOf('ㅂ');
                }
                case 9: 
                case 10: {
                    return Character.valueOf('ㅅ');
                }
                case 11: {
                    return Character.valueOf('ㅇ');
                }
                case 12: 
                case 13: {
                    return Character.valueOf('ㅈ');
                }
                case 14: {
                    return Character.valueOf('ㅊ');
                }
                case 15: {
                    return Character.valueOf('ㅋ');
                }
                case 16: {
                    return Character.valueOf('ㅌ');
                }
                case 17: {
                    return Character.valueOf('ㅍ');
                }
                case 18: {
                    return Character.valueOf('ㅎ');
                }
                default: {
                    return null;
                }
            }
        }
        return null;
    }

    public static Character getChosungFromHangulChar$default(PlayableComparators playableComparators0, char c, Character.UnicodeBlock character$UnicodeBlock0, int v, Object object0) {
        if((v & 2) != 0) {
            character$UnicodeBlock0 = null;
        }
        return playableComparators0.getChosungFromHangulChar(c, character$UnicodeBlock0);
    }

    public final char getFirstCharacter(@Nullable String s) {
        if(s != null && s.length() != 0) {
            int v = s.charAt(0);
            Character.UnicodeBlock character$UnicodeBlock0 = Character.UnicodeBlock.of(((char)v));
            if(character$UnicodeBlock0 != null && k.a.contains(character$UnicodeBlock0)) {
                Character character0 = this.getChosungFromHangulChar(((char)v), character$UnicodeBlock0);
                return character0 == null ? '#' : character0.charValue();
            }
            return (65 > v || v >= 91) && (97 > v || v >= 0x7B) ? '#' : Character.toUpperCase(((char)v));
        }
        return '#';
    }

    private final int myOrder(Playable playable0, Playable playable1) {
        return playable0.getOrder() - playable1.getOrder();
    }
}

