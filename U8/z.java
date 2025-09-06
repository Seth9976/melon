package U8;

import P.b;
import P.m;
import P4.a;
import Zc.Y;
import androidx.compose.runtime.l;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistHiRisingHolderKt;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistSpotlightHolderKt;
import com.iloen.melon.fragments.melonchart.ui.Hot100BannerKt;
import com.iloen.melon.fragments.shortform.TrendMusicWaveBackgroundPatternKt;
import com.iloen.melon.fragments.shortform.TrendMusicWaveExclusiveFragmentKt;
import com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt;
import com.iloen.melon.player.playlist.PlaylistMainComposablesKt;
import com.iloen.melon.player.playlist.drawernew.composable.DrawerNeedLoginKt;
import com.iloen.melon.player.playlist.mixup.MixUpComposablesKt;
import com.iloen.melon.popup.CommonFilterPopupKt;
import com.iloen.melon.popup.DjSelectionPopupKt;
import com.iloen.melon.popup.MalrangServiceGuidePopupKt;
import com.iloen.melon.utils.ui.MusicBrowserPopupHelperKt;
import d5.t;
import ie.H;
import kotlin.jvm.internal.q;
import we.n;

public final class z implements n {
    public final int a;
    public final int b;

    public z(int v, int v1) {
        this.a = 0;
        super();
        this.b = v;
    }

    public z(int v, int v1, byte b) {
        this.a = v1;
        this.b = v;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).getClass();
                J.d(this.b, ((l)object0), 1);
                return H.a;
            }
            case 1: {
                q.g(((m)object0), "$this$items");
                q.g(((Y)object1), "item");
                return ((Y)object1).a == 6 ? new b(a.e(1)) : new b(a.e(this.b));
            }
            case 2: {
                return ArtistHiRisingHolderKt.g(this.b, ((l)object0), ((int)(((Integer)object1))));
            }
            case 3: {
                return ArtistSpotlightHolderKt.e(this.b, ((l)object0), ((int)(((Integer)object1))));
            }
            case 4: {
                return Hot100BannerKt.b(this.b, ((l)object0), ((int)(((Integer)object1))));
            }
            case 5: {
                return TrendMusicWaveBackgroundPatternKt.b(this.b, ((l)object0), ((int)(((Integer)object1))));
            }
            case 6: {
                return TrendMusicWaveExclusiveFragmentKt.e(this.b, ((l)object0), ((int)(((Integer)object1))));
            }
            case 7: {
                return TrendMusicWaveExclusiveFragmentKt.g(this.b, ((l)object0), ((int)(((Integer)object1))));
            }
            case 8: {
                return TrendMusicWavePopularFragmentKt.a(this.b, ((l)object0), ((int)(((Integer)object1))));
            }
            case 9: {
                return TrendMusicWavePopularFragmentKt.k(this.b, ((l)object0), ((int)(((Integer)object1))));
            }
            case 10: {
                return TrendMusicWavePopularFragmentKt.m(this.b, ((l)object0), ((int)(((Integer)object1))));
            }
            case 11: {
                return TrendMusicWavePopularFragmentKt.l(this.b, ((l)object0), ((int)(((Integer)object1))));
            }
            case 12: {
                ((Integer)object1).intValue();
                PlaylistMainComposablesKt.PlaylistPortraitBottomControllerLayoutPreview(((l)object0), (this.b | 1) & -920350135 | ((0x24924924 & (this.b | 1)) >> 1 | 306783378 & (this.b | 1)) | (306783378 & (this.b | 1)) << 1 & (0x24924924 & (this.b | 1)));
                return H.a;
            }
            case 13: {
                ((Integer)object1).intValue();
                DrawerNeedLoginKt.DrawerNeedLogin(((l)object0), (this.b | 1) & -920350135 | ((0x24924924 & (this.b | 1)) >> 1 | 306783378 & (this.b | 1)) | (306783378 & (this.b | 1)) << 1 & (0x24924924 & (this.b | 1)));
                return H.a;
            }
            case 14: {
                ((Integer)object1).intValue();
                MixUpComposablesKt.SourceTitleCommonPreview(((l)object0), (this.b | 1) & -920350135 | ((0x24924924 & (this.b | 1)) >> 1 | 306783378 & (this.b | 1)) | (306783378 & (this.b | 1)) << 1 & (0x24924924 & (this.b | 1)));
                return H.a;
            }
            case 15: {
                ((Integer)object1).intValue();
                CommonFilterPopupKt.CommonFilterBasicPreview(((l)object0), (this.b | 1) & -920350135 | ((0x24924924 & (this.b | 1)) >> 1 | 306783378 & (this.b | 1)) | (306783378 & (this.b | 1)) << 1 & (0x24924924 & (this.b | 1)));
                return H.a;
            }
            case 16: {
                ((Integer)object1).intValue();
                CommonFilterPopupKt.CommonFilterTwoDepthHorizontalPreview(((l)object0), (this.b | 1) & -920350135 | ((0x24924924 & (this.b | 1)) >> 1 | 306783378 & (this.b | 1)) | (306783378 & (this.b | 1)) << 1 & (0x24924924 & (this.b | 1)));
                return H.a;
            }
            case 17: {
                ((Integer)object1).intValue();
                DjSelectionPopupKt.DjSelectionPopupPreview(((l)object0), (this.b | 1) & -920350135 | ((0x24924924 & (this.b | 1)) >> 1 | 306783378 & (this.b | 1)) | (306783378 & (this.b | 1)) << 1 & (0x24924924 & (this.b | 1)));
                return H.a;
            }
            case 18: {
                ((Integer)object1).intValue();
                MalrangServiceGuidePopupKt.PreviewMalrangServiceGuidePopup(((l)object0), (this.b | 1) & -920350135 | ((0x24924924 & (this.b | 1)) >> 1 | 306783378 & (this.b | 1)) | (306783378 & (this.b | 1)) << 1 & (0x24924924 & (this.b | 1)));
                return H.a;
            }
            case 19: {
                ((Integer)object1).intValue();
                MusicBrowserPopupHelperKt.FloatingBannerPreview(((l)object0), (this.b | 1) & -920350135 | ((0x24924924 & (this.b | 1)) >> 1 | 306783378 & (this.b | 1)) | (306783378 & (this.b | 1)) << 1 & (0x24924924 & (this.b | 1)));
                return H.a;
            }
            default: {
                ((Integer)object1).getClass();
                t.a(((l)object0), (this.b | 1) & -920350135 | ((0x24924924 & (this.b | 1)) >> 1 | 306783378 & (this.b | 1)) | (306783378 & (this.b | 1)) << 1 & (0x24924924 & (this.b | 1)));
                return H.a;
            }
        }
    }
}

