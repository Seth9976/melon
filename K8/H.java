package k8;

import Ba.M;
import Cc.x2;
import Ga.c;
import Pd.i;
import Qb.z;
import Ub.q;
import Ub.s;
import Vb.t0;
import androidx.fragment.app.I;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.fragments.MelonBaseFragment_MembersInjector;
import com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment;
import com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment_MembersInjector;
import com.iloen.melon.fragments.artistchannel.ArtistPickFragment;
import com.iloen.melon.fragments.artistchannel.ArtistPickFragment_MembersInjector;
import com.iloen.melon.fragments.cashfriends.CashFriendsFragment;
import com.iloen.melon.fragments.cashfriends.CashFriendsFragment_MembersInjector;
import com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment;
import com.iloen.melon.fragments.detail.DjPlaylistDetailFragment;
import com.iloen.melon.fragments.detail.MixPlaylistDetailFragment;
import com.iloen.melon.fragments.detail.PlaylistMakeFragment;
import com.iloen.melon.fragments.detail.PlaylistMakeFragment_MembersInjector;
import com.iloen.melon.fragments.detail.SongDetailFragment;
import com.iloen.melon.fragments.detail.SongDetailFragment_MembersInjector;
import com.iloen.melon.fragments.local.LocalContentListFragment;
import com.iloen.melon.fragments.local.LocalContentListFragment_MembersInjector;
import com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment;
import com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment_MembersInjector;
import com.iloen.melon.fragments.melonchart.StreamingCardFragment;
import com.iloen.melon.fragments.melonchart.StreamingCardFragment_MembersInjector;
import com.iloen.melon.fragments.mymusic.LockerFragment;
import com.iloen.melon.fragments.mymusic.LockerFragment_MembersInjector;
import com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment;
import com.iloen.melon.fragments.newmusic.NewAlbumFragment;
import com.iloen.melon.fragments.newmusic.NewAlbumFragment_MembersInjector;
import com.iloen.melon.fragments.searchandadd.SongNowPlayingSearchAndAddFragment;
import com.iloen.melon.fragments.searchandadd.SongNowPlayingSearchAndAddFragment_MembersInjector;
import com.iloen.melon.fragments.settings.KakaoMelonLoginFragment;
import com.iloen.melon.fragments.settings.KakaoMelonLoginFragment_MembersInjector;
import com.iloen.melon.fragments.settings.SettingAddPositionFragment;
import com.iloen.melon.fragments.settings.SettingAddPositionFragment_MembersInjector;
import com.iloen.melon.fragments.settings.SettingAdvancedFragment;
import com.iloen.melon.fragments.settings.SettingAdvancedFragment_MembersInjector;
import com.iloen.melon.fragments.settings.SettingLaboratoryFragment;
import com.iloen.melon.fragments.settings.SettingLaboratoryFragment_MembersInjector;
import com.iloen.melon.fragments.settings.SettingMainFragment;
import com.iloen.melon.fragments.settings.SettingMainFragment_MembersInjector;
import com.iloen.melon.fragments.settings.SettingMusicVideoFragment;
import com.iloen.melon.fragments.settings.SettingMusicVideoFragment_MembersInjector;
import com.iloen.melon.fragments.settings.SettingPushFragment;
import com.iloen.melon.fragments.settings.SettingPushFragment_MembersInjector;
import com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmFragment;
import com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment;
import com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment;
import com.iloen.melon.fragments.shortform.TrendShortFormFragment;
import com.iloen.melon.fragments.shortform.TrendShortFormFragment_MembersInjector;
import com.iloen.melon.fragments.webview.MelonWebViewFragment;
import com.iloen.melon.fragments.webview.MelonWebViewFragment_MembersInjector;
import com.iloen.melon.player.playlist.PlaylistMainFragment;
import com.iloen.melon.player.playlist.PlaylistMainFragment_MembersInjector;
import com.iloen.melon.player.playlist.drawernew.DrawerBtmSheetFragment;
import com.iloen.melon.player.playlist.drawernew.DrawerBtmSheetFragment_MembersInjector;
import com.iloen.melon.player.playlist.drawernew.DrawerFragment;
import com.iloen.melon.player.playlist.drawernew.DrawerFragment_MembersInjector;
import com.iloen.melon.player.playlist.drawernew.DrawerPlaylistViewPagerFragment;
import com.iloen.melon.player.playlist.drawernew.DrawerPlaylistViewPagerFragment_MembersInjector;
import com.iloen.melon.player.playlist.drawernew.DrawerSongFragment;
import com.iloen.melon.player.playlist.drawernew.DrawerSongFragment_MembersInjector;
import com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment;
import com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment_MembersInjector;
import com.iloen.melon.player.playlist.mixup.MixUpPlaylistViewPagerFragment;
import com.iloen.melon.player.playlist.music.MusicPlaylistBaseFragment_MembersInjector;
import com.iloen.melon.player.playlist.music.MusicPlaylistFragment;
import com.iloen.melon.player.playlist.music.MusicSmartPlaylistViewPagerFragment;
import com.iloen.melon.player.playlist.music.SmartPlaylistFragment;
import com.iloen.melon.player.playlist.search.PlaylistSearchFragment;
import com.iloen.melon.player.playlist.search.PlaylistSearchFragment_MembersInjector;
import com.iloen.melon.player.video.VideoMainFrameFragment;
import com.iloen.melon.player.video.VideoMainFrameFragment_MembersInjector;
import com.iloen.melon.player.video.VideoPlayerFragmentBase;
import com.iloen.melon.player.video.VideoPlayerFragmentBase_MembersInjector;
import com.iloen.melon.popup.InstantPlayPopup;
import com.iloen.melon.popup.InstantPlayPopup_MembersInjector;
import com.iloen.melon.popup.RemoteConnectPopup;
import com.iloen.melon.popup.RemoteConnectPopup_MembersInjector;
import com.melon.utils.preference.PreferenceHelper;
import eb.u;
import kc.s2;
import mb.k;
import yb.b;

public final class h extends H {
    public final I a;
    public final o b;
    public final e c;

    public h(o o0, g g0, e e0, I i0) {
        this.b = o0;
        this.c = e0;
        this.a = i0;
    }

    public final Md.h a() {
        return new Md.h(this.a);
    }

    public final u b() {
        return new u(this.b.u());
    }

    @Override  // com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment_GeneratedInjector
    public final void injectArtistDetailHomeFragment(ArtistDetailHomeFragment artistDetailHomeFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(artistDetailHomeFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(artistDetailHomeFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(artistDetailHomeFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(artistDetailHomeFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(artistDetailHomeFragment0, this.b());
        ArtistDetailHomeFragment_MembersInjector.injectLoginUseCase(artistDetailHomeFragment0, ((k)this.b.m.get()));
    }

    @Override  // com.iloen.melon.fragments.artistchannel.ArtistPickFragment_GeneratedInjector
    public final void injectArtistPickFragment(ArtistPickFragment artistPickFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(artistPickFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(artistPickFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(artistPickFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(artistPickFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(artistPickFragment0, this.b());
        ArtistPickFragment_MembersInjector.injectPlayerUseCase(artistPickFragment0, this.b.k());
    }

    @Override  // com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment_GeneratedInjector
    public final void injectArtistPlaylistDetailFragment(ArtistPlaylistDetailFragment artistPlaylistDetailFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(artistPlaylistDetailFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(artistPlaylistDetailFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(artistPlaylistDetailFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(artistPlaylistDetailFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(artistPlaylistDetailFragment0, this.b());
    }

    @Override  // com.iloen.melon.fragments.cashfriends.CashFriendsFragment_GeneratedInjector
    public final void injectCashFriendsFragment(CashFriendsFragment cashFriendsFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(cashFriendsFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(cashFriendsFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(cashFriendsFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(cashFriendsFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(cashFriendsFragment0, this.b());
        CashFriendsFragment_MembersInjector.injectLoginUseCase(cashFriendsFragment0, ((k)this.b.m.get()));
    }

    @Override  // com.iloen.melon.fragments.detail.DjPlaylistDetailFragment_GeneratedInjector
    public final void injectDjPlaylistDetailFragment(DjPlaylistDetailFragment djPlaylistDetailFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(djPlaylistDetailFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(djPlaylistDetailFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(djPlaylistDetailFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(djPlaylistDetailFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(djPlaylistDetailFragment0, this.b());
    }

    @Override  // com.iloen.melon.player.playlist.drawernew.DrawerBtmSheetFragment_GeneratedInjector
    public final void injectDrawerBtmSheetFragment(DrawerBtmSheetFragment drawerBtmSheetFragment0) {
        DrawerBtmSheetFragment_MembersInjector.injectPlayerUiHelper(drawerBtmSheetFragment0, this.b.j());
    }

    @Override  // com.iloen.melon.player.playlist.drawernew.DrawerFragment_GeneratedInjector
    public final void injectDrawerFragment(DrawerFragment drawerFragment0) {
        drawerFragment0.downloadHelper = this.a();
        DrawerFragment_MembersInjector.injectPlayerUiHelper(drawerFragment0, this.b.j());
    }

    @Override  // com.iloen.melon.player.playlist.drawernew.DrawerPlaylistViewPagerFragment_GeneratedInjector
    public final void injectDrawerPlaylistViewPagerFragment(DrawerPlaylistViewPagerFragment drawerPlaylistViewPagerFragment0) {
        DrawerPlaylistViewPagerFragment_MembersInjector.injectPlaylistManager(drawerPlaylistViewPagerFragment0, ((s2)this.b.w.get()));
    }

    @Override  // com.iloen.melon.player.playlist.drawernew.DrawerSongFragment_GeneratedInjector
    public final void injectDrawerSongFragment(DrawerSongFragment drawerSongFragment0) {
        drawerSongFragment0.downloadHelper = this.a();
        DrawerSongFragment_MembersInjector.injectPlayerUiHelper(drawerSongFragment0, this.b.j());
        DrawerSongFragment_MembersInjector.injectStringProvider(drawerSongFragment0, this.b.u());
    }

    @Override  // com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment_GeneratedInjector
    public final void injectImageToPlaylistFragment(ImageToPlaylistFragment imageToPlaylistFragment0) {
        imageToPlaylistFragment0.downloadHelper = this.a();
    }

    @Override  // com.iloen.melon.popup.InstantPlayPopup_GeneratedInjector
    public final void injectInstantPlayPopup(InstantPlayPopup instantPlayPopup0) {
        InstantPlayPopup_MembersInjector.injectPlayerUseCase(instantPlayPopup0, this.b.k());
    }

    @Override  // com.iloen.melon.fragments.settings.KakaoMelonLoginFragment_GeneratedInjector
    public final void injectKakaoMelonLoginFragment(KakaoMelonLoginFragment kakaoMelonLoginFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(kakaoMelonLoginFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(kakaoMelonLoginFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(kakaoMelonLoginFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(kakaoMelonLoginFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(kakaoMelonLoginFragment0, this.b());
        KakaoMelonLoginFragment_MembersInjector.injectMelonLoginUseCase(kakaoMelonLoginFragment0, ((k)this.b.m.get()));
        KakaoMelonLoginFragment_MembersInjector.injectKakaoLoginUseCase(kakaoMelonLoginFragment0, this.b.f());
        KakaoMelonLoginFragment_MembersInjector.injectSimpleAccountUseCase(kakaoMelonLoginFragment0, this.b.m());
        KakaoMelonLoginFragment_MembersInjector.injectPlayerUseCase(kakaoMelonLoginFragment0, this.b.k());
    }

    @Override  // com.iloen.melon.fragments.local.LocalContentListFragment_GeneratedInjector
    public final void injectLocalContentListFragment(LocalContentListFragment localContentListFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(localContentListFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(localContentListFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(localContentListFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(localContentListFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(localContentListFragment0, this.b());
        LocalContentListFragment_MembersInjector.injectPlaylistManager(localContentListFragment0, ((s2)this.b.w.get()));
        LocalContentListFragment_MembersInjector.injectPlayerUseCase(localContentListFragment0, this.b.k());
        LocalContentListFragment_MembersInjector.injectPlayerUiHelper(localContentListFragment0, this.b.j());
    }

    @Override  // com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment_GeneratedInjector
    public final void injectLocalContentNewDbBaseFragment(LocalContentNewDbBaseFragment localContentNewDbBaseFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(localContentNewDbBaseFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(localContentNewDbBaseFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(localContentNewDbBaseFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(localContentNewDbBaseFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(localContentNewDbBaseFragment0, this.b());
        LocalContentNewDbBaseFragment_MembersInjector.injectPlayerUseCase(localContentNewDbBaseFragment0, this.b.k());
        LocalContentNewDbBaseFragment_MembersInjector.injectPlayerUiHelper(localContentNewDbBaseFragment0, this.b.j());
    }

    @Override  // com.iloen.melon.fragments.mymusic.LockerFragment_GeneratedInjector
    public final void injectLockerFragment(LockerFragment lockerFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(lockerFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(lockerFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(lockerFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(lockerFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(lockerFragment0, this.b());
        LockerFragment_MembersInjector.injectLoginUseCase(lockerFragment0, ((k)this.b.m.get()));
    }

    @Override  // com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment_GeneratedInjector
    public final void injectLoginSimpleAccountFragment(LoginSimpleAccountFragment loginSimpleAccountFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(loginSimpleAccountFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(loginSimpleAccountFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(loginSimpleAccountFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(loginSimpleAccountFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(loginSimpleAccountFragment0, this.b());
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment_GeneratedInjector
    public final void injectMelonBaseFragment(MelonBaseFragment melonBaseFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(melonBaseFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(melonBaseFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(melonBaseFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(melonBaseFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(melonBaseFragment0, this.b());
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment_GeneratedInjector
    public final void injectMelonWebViewFragment(MelonWebViewFragment melonWebViewFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(melonWebViewFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(melonWebViewFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(melonWebViewFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(melonWebViewFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(melonWebViewFragment0, this.b());
        MelonWebViewFragment_MembersInjector.injectPlaylistManager(melonWebViewFragment0, ((s2)this.b.w.get()));
        MelonWebViewFragment_MembersInjector.injectPlayerUseCase(melonWebViewFragment0, this.b.k());
    }

    @Override  // com.iloen.melon.fragments.detail.MixPlaylistDetailFragment_GeneratedInjector
    public final void injectMixPlaylistDetailFragment(MixPlaylistDetailFragment mixPlaylistDetailFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(mixPlaylistDetailFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(mixPlaylistDetailFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(mixPlaylistDetailFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(mixPlaylistDetailFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(mixPlaylistDetailFragment0, this.b());
    }

    @Override  // com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment_GeneratedInjector
    public final void injectMixUpPlaylistComposeFragment(MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0) {
        mixUpPlaylistComposeFragment0.downloadHelper = this.a();
        MixUpPlaylistComposeFragment_MembersInjector.injectStringProvider(mixUpPlaylistComposeFragment0, this.b.u());
        MixUpPlaylistComposeFragment_MembersInjector.injectPlayerUiHelper(mixUpPlaylistComposeFragment0, this.b.j());
        MixUpPlaylistComposeFragment_MembersInjector.injectPlayerUseCase(mixUpPlaylistComposeFragment0, this.b.k());
        MixUpPlaylistComposeFragment_MembersInjector.injectLocationUseCase(mixUpPlaylistComposeFragment0, this.b.o());
        MixUpPlaylistComposeFragment_MembersInjector.injectPlayBgColorExtractor(mixUpPlaylistComposeFragment0, ((x2)this.b.E0.get()));
    }

    @Override  // com.iloen.melon.player.playlist.mixup.MixUpPlaylistViewPagerFragment_GeneratedInjector
    public final void injectMixUpPlaylistViewPagerFragment(MixUpPlaylistViewPagerFragment mixUpPlaylistViewPagerFragment0) {
    }

    @Override  // com.iloen.melon.player.playlist.music.MusicPlaylistFragment_GeneratedInjector
    public final void injectMusicPlaylistFragment(MusicPlaylistFragment musicPlaylistFragment0) {
        musicPlaylistFragment0.downloadHelper = this.a();
        MusicPlaylistBaseFragment_MembersInjector.injectPlayerUiHelper(musicPlaylistFragment0, this.b.j());
        MusicPlaylistBaseFragment_MembersInjector.injectStringProvider(musicPlaylistFragment0, this.b.u());
    }

    @Override  // com.iloen.melon.player.playlist.music.MusicSmartPlaylistViewPagerFragment_GeneratedInjector
    public final void injectMusicSmartPlaylistViewPagerFragment(MusicSmartPlaylistViewPagerFragment musicSmartPlaylistViewPagerFragment0) {
    }

    @Override  // com.iloen.melon.fragments.newmusic.NewAlbumFragment_GeneratedInjector
    public final void injectNewAlbumFragment(NewAlbumFragment newAlbumFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(newAlbumFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(newAlbumFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(newAlbumFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(newAlbumFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(newAlbumFragment0, this.b());
        NewAlbumFragment_MembersInjector.injectLoginUseCase(newAlbumFragment0, ((k)this.b.m.get()));
    }

    @Override  // com.iloen.melon.player.playlist.PlaylistMainFragment_GeneratedInjector
    public final void injectPlaylistMainFragment(PlaylistMainFragment playlistMainFragment0) {
        playlistMainFragment0.downloadHelper = this.a();
        PlaylistMainFragment_MembersInjector.injectPlayerUiHelper(playlistMainFragment0, this.b.j());
        PlaylistMainFragment_MembersInjector.injectPlayBgColorExtractor(playlistMainFragment0, ((x2)this.b.E0.get()));
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistMakeFragment_GeneratedInjector
    public final void injectPlaylistMakeFragment(PlaylistMakeFragment playlistMakeFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(playlistMakeFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(playlistMakeFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(playlistMakeFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(playlistMakeFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(playlistMakeFragment0, this.b());
        PlaylistMakeFragment_MembersInjector.injectPlaylistManager(playlistMakeFragment0, ((s2)this.b.w.get()));
    }

    @Override  // com.iloen.melon.player.playlist.search.PlaylistSearchFragment_GeneratedInjector
    public final void injectPlaylistSearchFragment(PlaylistSearchFragment playlistSearchFragment0) {
        playlistSearchFragment0.downloadHelper = this.a();
        PlaylistSearchFragment_MembersInjector.injectPlayerUseCase(playlistSearchFragment0, this.b.k());
        PlaylistSearchFragment_MembersInjector.injectPlaylistManager(playlistSearchFragment0, ((s2)this.b.w.get()));
        PlaylistSearchFragment_MembersInjector.injectPlayerUiHelper(playlistSearchFragment0, this.b.j());
        PlaylistSearchFragment_MembersInjector.injectStringProvider(playlistSearchFragment0, this.b.u());
    }

    @Override  // com.iloen.melon.popup.RemoteConnectPopup_GeneratedInjector
    public final void injectRemoteConnectPopup(RemoteConnectPopup remoteConnectPopup0) {
        RemoteConnectPopup_MembersInjector.injectStringProvider(remoteConnectPopup0, this.b.u());
    }

    @Override  // com.iloen.melon.fragments.settings.SettingAddPositionFragment_GeneratedInjector
    public final void injectSettingAddPositionFragment(SettingAddPositionFragment settingAddPositionFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(settingAddPositionFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(settingAddPositionFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(settingAddPositionFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(settingAddPositionFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(settingAddPositionFragment0, this.b());
        SettingAddPositionFragment_MembersInjector.injectPlaylistManager(settingAddPositionFragment0, ((s2)this.b.w.get()));
        SettingAddPositionFragment_MembersInjector.injectPlaybackManager(settingAddPositionFragment0, ((q)this.b.u.get()));
    }

    @Override  // com.iloen.melon.fragments.settings.SettingAdvancedFragment_GeneratedInjector
    public final void injectSettingAdvancedFragment(SettingAdvancedFragment settingAdvancedFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(settingAdvancedFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(settingAdvancedFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(settingAdvancedFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(settingAdvancedFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(settingAdvancedFragment0, this.b());
        SettingAdvancedFragment_MembersInjector.injectPlayerRules(settingAdvancedFragment0, ((t0)this.b.A0.get()));
    }

    @Override  // com.iloen.melon.fragments.settings.SettingLaboratoryFragment_GeneratedInjector
    public final void injectSettingLaboratoryFragment(SettingLaboratoryFragment settingLaboratoryFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(settingLaboratoryFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(settingLaboratoryFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(settingLaboratoryFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(settingLaboratoryFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(settingLaboratoryFragment0, this.b());
        SettingLaboratoryFragment_MembersInjector.injectPlaylistManager(settingLaboratoryFragment0, ((s2)this.b.w.get()));
    }

    @Override  // com.iloen.melon.fragments.settings.SettingMainFragment_GeneratedInjector
    public final void injectSettingMainFragment(SettingMainFragment settingMainFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(settingMainFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(settingMainFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(settingMainFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(settingMainFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(settingMainFragment0, this.b());
        SettingMainFragment_MembersInjector.injectLoginUseCase(settingMainFragment0, ((k)this.b.m.get()));
        SettingMainFragment_MembersInjector.injectSimpleAccountUseCase(settingMainFragment0, this.b.m());
        SettingMainFragment_MembersInjector.injectDeviceData(settingMainFragment0, this.b.e());
    }

    @Override  // com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmFragment_GeneratedInjector
    public final void injectSettingMusicAlarmFragment(SettingMusicAlarmFragment settingMusicAlarmFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(settingMusicAlarmFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(settingMusicAlarmFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(settingMusicAlarmFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(settingMusicAlarmFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(settingMusicAlarmFragment0, this.b());
    }

    @Override  // com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment_GeneratedInjector
    public final void injectSettingMusicAlarmListFragment(SettingMusicAlarmListFragment settingMusicAlarmListFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(settingMusicAlarmListFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(settingMusicAlarmListFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(settingMusicAlarmListFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(settingMusicAlarmListFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(settingMusicAlarmListFragment0, this.b());
    }

    @Override  // com.iloen.melon.fragments.settings.SettingMusicVideoFragment_GeneratedInjector
    public final void injectSettingMusicVideoFragment(SettingMusicVideoFragment settingMusicVideoFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(settingMusicVideoFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(settingMusicVideoFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(settingMusicVideoFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(settingMusicVideoFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(settingMusicVideoFragment0, this.b());
        SettingMusicVideoFragment_MembersInjector.injectMDeviceData(settingMusicVideoFragment0, this.b.e());
    }

    @Override  // com.iloen.melon.fragments.settings.SettingPushFragment_GeneratedInjector
    public final void injectSettingPushFragment(SettingPushFragment settingPushFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(settingPushFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(settingPushFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(settingPushFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(settingPushFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(settingPushFragment0, this.b());
        SettingPushFragment_MembersInjector.injectPreferenceHelper(settingPushFragment0, ((PreferenceHelper)this.b.D0.get()));
    }

    @Override  // com.iloen.melon.player.playlist.music.SmartPlaylistFragment_GeneratedInjector
    public final void injectSmartPlaylistFragment(SmartPlaylistFragment smartPlaylistFragment0) {
        smartPlaylistFragment0.downloadHelper = this.a();
        MusicPlaylistBaseFragment_MembersInjector.injectPlayerUiHelper(smartPlaylistFragment0, this.b.j());
        MusicPlaylistBaseFragment_MembersInjector.injectStringProvider(smartPlaylistFragment0, this.b.u());
    }

    @Override  // com.iloen.melon.fragments.detail.SongDetailFragment_GeneratedInjector
    public final void injectSongDetailFragment(SongDetailFragment songDetailFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(songDetailFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(songDetailFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(songDetailFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(songDetailFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(songDetailFragment0, this.b());
        SongDetailFragment_MembersInjector.injectLoginUseCase(songDetailFragment0, ((k)this.b.m.get()));
    }

    @Override  // com.iloen.melon.fragments.searchandadd.SongNowPlayingSearchAndAddFragment_GeneratedInjector
    public final void injectSongNowPlayingSearchAndAddFragment(SongNowPlayingSearchAndAddFragment songNowPlayingSearchAndAddFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(songNowPlayingSearchAndAddFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(songNowPlayingSearchAndAddFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(songNowPlayingSearchAndAddFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(songNowPlayingSearchAndAddFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(songNowPlayingSearchAndAddFragment0, this.b());
        SongNowPlayingSearchAndAddFragment_MembersInjector.injectPlaylistManager(songNowPlayingSearchAndAddFragment0, ((s2)this.b.w.get()));
    }

    @Override  // com.iloen.melon.fragments.melonchart.StreamingCardFragment_GeneratedInjector
    public final void injectStreamingCardFragment(StreamingCardFragment streamingCardFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(streamingCardFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(streamingCardFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(streamingCardFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(streamingCardFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(streamingCardFragment0, this.b());
        StreamingCardFragment_MembersInjector.injectStreamingCardUseCase(streamingCardFragment0, new b(new c(new Ga.a(((M)this.b.C0.get())))));
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendShortFormFragment_GeneratedInjector
    public final void injectTrendShortFormFragment(TrendShortFormFragment trendShortFormFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(trendShortFormFragment0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(trendShortFormFragment0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(trendShortFormFragment0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(trendShortFormFragment0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(trendShortFormFragment0, this.b());
        TrendShortFormFragment_MembersInjector.injectPlayerUseCase(trendShortFormFragment0, this.b.k());
    }

    @Override  // com.iloen.melon.player.video.VideoMainFrameFragment_GeneratedInjector
    public final void injectVideoMainFrameFragment(VideoMainFrameFragment videoMainFrameFragment0) {
        VideoMainFrameFragment_MembersInjector.injectPlayerUseCase(videoMainFrameFragment0, this.b.k());
        VideoMainFrameFragment_MembersInjector.injectPlaylistManager(videoMainFrameFragment0, ((s2)this.b.w.get()));
        VideoMainFrameFragment_MembersInjector.injectPlayerController(videoMainFrameFragment0, ((z)this.b.t.get()));
        VideoMainFrameFragment_MembersInjector.injectRemotePlayerManager(videoMainFrameFragment0, ((s)this.b.z.get()));
    }

    @Override  // com.iloen.melon.player.video.VideoPlayerFragmentBase_GeneratedInjector
    public final void injectVideoPlayerFragmentBase(VideoPlayerFragmentBase videoPlayerFragmentBase0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(videoPlayerFragmentBase0, ((a)this.b.l.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(videoPlayerFragmentBase0, ((s2)this.b.w.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(videoPlayerFragmentBase0, ((Ub.u)this.b.U.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(videoPlayerFragmentBase0, ((s)this.b.z.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(videoPlayerFragmentBase0, this.b());
        VideoPlayerFragmentBase_MembersInjector.injectPlaybackManager(videoPlayerFragmentBase0, ((q)this.b.u.get()));
        VideoPlayerFragmentBase_MembersInjector.injectPlayerUseCase(videoPlayerFragmentBase0, this.b.k());
        VideoPlayerFragmentBase_MembersInjector.injectRemotePlayerManager(videoPlayerFragmentBase0, ((s)this.b.z.get()));
        VideoPlayerFragmentBase_MembersInjector.injectRemoteDeviceUseCase(videoPlayerFragmentBase0, this.b.l());
        VideoPlayerFragmentBase_MembersInjector.injectPlayerUiHelper(videoPlayerFragmentBase0, this.b.j());
        VideoPlayerFragmentBase_MembersInjector.injectAppVisibilityManager(videoPlayerFragmentBase0, ((i)this.b.A.get()));
    }
}

