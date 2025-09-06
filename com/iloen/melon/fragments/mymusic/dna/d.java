package com.iloen.melon.fragments.mymusic.dna;

import I9.g;
import J9.f;
import J9.h;
import Ma.b;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment;
import com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt;
import com.iloen.melon.fragments.tabs.BottomTabBaseFragment.BottomTabInnerBaseFragment;
import com.iloen.melon.fragments.webview.MelonWebViewFragment;
import com.iloen.melon.playback.voicealarm.VoiceTrackAudioFocusHelper;
import com.iloen.melon.player.playlist.common.PlaylistDeleteUiEventHelper;
import com.iloen.melon.player.video.chat.VideoChatViewModel;
import com.iloen.melon.utils.cipher.MelonCryptoManager;
import com.iloen.melon.utils.network.ServerPhase;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import k8.Y;
import k8.o;
import k9.i;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import we.a;

public final class d implements a {
    public final int a;

    public d(int v) {
        this.a = v;
        super();
    }

    public d(VideoChatViewModel videoChatViewModel0) {
        this.a = 22;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        Class class0 = b.class;
        boolean z = false;
        switch(this.a) {
            case 0: {
                return com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onTagItemClickListener$lambda$76$lambda$64$lambda$63();
            }
            case 1: {
                return com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onMostGenreMoreClickListener$lambda$87$lambda$78$lambda$77();
            }
            case 2: {
                return com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onShortcutClickListener$lambda$100$lambda$91$lambda$90();
            }
            case 3: {
                return com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongPlayClickListener$lambda$15$lambda$1$lambda$0();
            }
            case 4: {
                return com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongItemClickListener$lambda$31$lambda$17$lambda$16();
            }
            case 5: {
                return com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onAlbumItemClickListener$lambda$47$lambda$33$lambda$32();
            }
            case 6: {
                return com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onShortcutClickListener$lambda$100$lambda$97$lambda$95();
            }
            case 7: {
                return com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onShortcutClickListener$lambda$100$lambda$97$lambda$96();
            }
            case 8: {
                return SettingMusicAlarmListFragment.N();
            }
            case 9: {
                return TrendMusicWavePopularFragmentKt.n();
            }
            case 10: {
                return TrendMusicWavePopularFragmentKt.b();
            }
            case 11: {
                return BottomTabInnerBaseFragment.d0();
            }
            case 12: {
                return MelonWebViewFragment.o0();
            }
            case 13: {
                return MelonWebViewFragment.n0();
            }
            case 14: {
                return VoiceTrackAudioFocusHelper.a();
            }
            case 15: {
                return new PlaylistDeleteUiEventHelper();
            }
            case 16: {
                byte[] arr_b = i.a();
                if(arr_b != null) {
                    try {
                        z = MelonCryptoManager.isShownSongBtn(arr_b);
                    }
                    catch(Exception unused_ex) {
                    }
                }
                return Boolean.valueOf(z);
            }
            case 17: {
                return new PlaylistDeleteUiEventHelper();
            }
            case 18: {
                return new PlaylistDeleteUiEventHelper();
            }
            case 19: {
                byte[] arr_b1 = i.a();
                if(arr_b1 != null) {
                    try {
                        z = MelonCryptoManager.isShownSongBtn(arr_b1);
                    }
                    catch(Exception unused_ex) {
                    }
                }
                return Boolean.valueOf(z);
            }
            case 20: {
                return new PlaylistDeleteUiEventHelper();
            }
            case 21: {
                return H.a;
            }
            case 22: {
                String s = ServerPhase.INSTANCE.getDomainPrefix();
                if(q.b(s, "sandbox-")) {
                    return new g(new f(h.d));
                }
                return q.b(s, "cbt-") ? new g(new f(h.b)) : new g(new f(h.c));
            }
            case 23: {
                return ((o)(((b)Y.f(MelonAppBase.Companion, class0)))).c();
            }
            case 24: {
                return ((o)(((b)Y.f(MelonAppBase.Companion, class0)))).c();
            }
            case 25: {
                return CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
            }
            case 26: {
                return ActionKind.ClickContent;
            }
            case 27: {
                return "";
            }
            case 28: {
                return "";
            }
            default: {
                return "";
            }
        }
    }
}

