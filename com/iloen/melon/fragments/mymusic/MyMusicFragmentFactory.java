package com.iloen.melon.fragments.mymusic;

import com.iloen.melon.fragments.MelonBaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicFragmentFactory;", "", "<init>", "()V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MyMusicFragmentFactory {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001E\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u000BJ&\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u000BJ&\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000ER\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicFragmentFactory$Companion;", "", "<init>", "()V", "TAG", "", "create", "Lcom/iloen/melon/fragments/MelonBaseFragment;", "targetMemberKey", "type", "index", "", "term", "isPowerDj", "", "isSeries", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MelonBaseFragment create(@NotNull String s, int v, boolean z, boolean z1) {
            q.g(s, "targetMemberKey");
            switch(v) {
                case 0: {
                    return DjPlaylistFragment.Companion.newInstance(s, z, 0, ((int)z1));
                }
                case 1: {
                    return com.iloen.melon.fragments.mymusic.PlaylistFragment.Companion.newInstance$default(PlaylistFragment.Companion, true, s, z, 0, 8, null);
                }
                default: {
                    return com.iloen.melon.fragments.mymusic.PlaylistFragment.Companion.newInstance$default(PlaylistFragment.Companion, true, s, z, 0, 8, null);
                }
            }
        }

        @NotNull
        public final MelonBaseFragment create(@NotNull String s, @NotNull String s1, int v) {
            q.g(s, "targetMemberKey");
            q.g(s1, "type");
            switch(s1) {
                case "fanartist": {
                    switch(v) {
                        case 0: {
                            return MyMusicFanArtistFragment.Companion.newInstance("fan_joined", s);
                        }
                        case 1: {
                            return MyMusicFanArtistFragment.Companion.newInstance("friendly", s);
                        }
                        default: {
                            return MyMusicFanArtistFragment.Companion.newInstance("fan_joined", s);
                        }
                    }
                }
                case "listen": {
                    switch(v) {
                        case 0: {
                            return MyMusicListenedSongFragment.Companion.newInstance(s);
                        }
                        case 1: {
                            return MyMusicListenedPlaylistFragment.Companion.newInstance(s);
                        }
                        case 2: {
                            return MyMusicListenedCastFragment.Companion.newInstance(s);
                        }
                        case 3: {
                            return MyMusicListenedVideoFragment.Companion.newInstance(s);
                        }
                        default: {
                            return MyMusicListenedSongFragment.Companion.newInstance(s);
                        }
                    }
                }
                case "mychart": {
                    switch(v) {
                        case 0: {
                            return MyMusicMyChartMonthFragment.Companion.newInstance("W", s);
                        }
                        case 1: {
                            return MyMusicMyChartMonthFragment.Companion.newInstance("1M", s);
                        }
                        case 2: {
                            return MyMusicMyChartMonthFragment.Companion.newInstance("3M", s);
                        }
                        case 3: {
                            return MyMusicMyChartMonthFragment.Companion.newInstance("TERM", s);
                        }
                        default: {
                            return MyMusicMyChartMonthFragment.Companion.newInstance("W", s);
                        }
                    }
                }
                case "mycomment": {
                    switch(v) {
                        case 0: {
                            return MyMusicMyCommentFragment.Companion.newInstance("comment");
                        }
                        case 1: {
                            return MyMusicMyCommentFragment.Companion.newInstance("reply");
                        }
                        default: {
                            return MyMusicMyChartMonthFragment.Companion.newInstance("comment", s);
                        }
                    }
                }
                case "mylike": {
                    switch(v) {
                        case 0: {
                            return MyMusicLikedSongFragment.Companion.newInstance(s);
                        }
                        case 1: {
                            return MyMusicLikedAlbumFragment.Companion.newInstance(s);
                        }
                        case 2: {
                            return MyMusicLikedPlaylistFragment.Companion.newInstance(s);
                        }
                        case 3: {
                            return MyMusicLikedCastFragment.Companion.newInstance(s);
                        }
                        case 4: {
                            return MyMusicLikedTagFragment.Companion.newInstance(s);
                        }
                        case 5: {
                            return MyMusicLikedVideoFragment.Companion.newInstance(s);
                        }
                        default: {
                            return MyMusicLikedSongFragment.Companion.newInstance(s);
                        }
                    }
                }
                case "otherlike": {
                    switch(v) {
                        case 0: {
                            return OtherMusicLikedSongFragment.Companion.newInstance(s);
                        }
                        case 1: {
                            return OtherMusicLikedAlbumFragment.Companion.newInstance(s);
                        }
                        case 2: {
                            return OtherMusicLikedPlaylistFragment.Companion.newInstance(s);
                        }
                        default: {
                            return MyMusicLikedSongFragment.Companion.newInstance(s);
                        }
                    }
                }
                default: {
                    switch(v) {
                        case 0: {
                            return MyMusicLikedSongFragment.Companion.newInstance(s);
                        }
                        case 1: {
                            return MyMusicLikedAlbumFragment.Companion.newInstance(s);
                        }
                        case 2: {
                            return MyMusicLikedPlaylistFragment.Companion.newInstance(s);
                        }
                        case 4: {
                            return MyMusicLikedTagFragment.Companion.newInstance(s);
                        }
                        case 5: {
                            return MyMusicLikedVideoFragment.Companion.newInstance(s);
                        }
                        default: {
                            return MyMusicLikedSongFragment.Companion.newInstance(s);
                        }
                    }
                }
            }
        }

        @NotNull
        public final MelonBaseFragment create(@NotNull String s, @NotNull String s1, @NotNull String s2, int v) {
            q.g(s, "targetMemberKey");
            q.g(s1, "type");
            q.g(s2, "term");
            if(!s1.equals("mychart")) {
                return MyMusicMyChartMonthFragment.Companion.newInstance("1M", s);
            }
            switch(v) {
                case 1: {
                    return MyMusicMyChartMonthFragment.Companion.newInstance("1M", s);
                }
                case 2: {
                    return MyMusicMyChartMonthFragment.Companion.newInstance("3M", s);
                }
                case 3: {
                    return MyMusicMyChartMonthFragment.Companion.newInstance("TERM", s2, s);
                }
                default: {
                    return MyMusicMyChartMonthFragment.Companion.newInstance("1M", s);
                }
            }
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "MyMusicFragmentFactory";

    static {
        MyMusicFragmentFactory.Companion = new Companion(null);
    }
}

