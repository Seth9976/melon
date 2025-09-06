package com.iloen.melon.fragments;

import Ma.m;
import Q1.c;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.a;
import androidx.fragment.app.l0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.playback.Actor;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.system.CompatUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.kakao.tiara.data.ActionKind;
import com.melon.playlist.b;
import ie.H;
import k8.Y;
import k8.o;
import kc.d3;
import kc.s2;
import kotlin.jvm.internal.q;
import oc.w;
import p8.g;
import p8.s;
import vd.X;

public class MelonWidgetMoreViewFragment extends MelonBaseFragment {
    private static final String ARG_ACTOR = "arg_actor";
    private static final String TAG = "MelonWidgetMoreViewFragment";
    private Actor mActor;

    private H lambda$showMorePopup$0() {
        this.performBackPress();
        return null;
    }

    private H lambda$showMorePopup$1() {
        FragmentActivity fragmentActivity0 = this.getActivity();
        this.trackTiara(0x7F130D7C);  // string:tiara_click_copy_playlist "재생목록"
        this.openNowPlayingList();
        if(fragmentActivity0 != null) {
            fragmentActivity0.finish();
        }
        return null;
    }

    private H lambda$showMorePopup$2() {
        FragmentActivity fragmentActivity0 = this.getActivity();
        this.trackTiara(0x7F130D90);  // string:tiara_click_copy_search "검색"
        this.openSearchView();
        if(fragmentActivity0 != null) {
            fragmentActivity0.finish();
        }
        return null;
    }

    private H lambda$showMorePopup$3() {
        FragmentActivity fragmentActivity0 = this.getActivity();
        this.trackTiara(0x7F130D98);  // string:tiara_click_copy_setting "설정"
        if(fragmentActivity0 != null) {
            fragmentActivity0.finish();
        }
        Intent intent0 = new Intent();
        c.Y(intent0, "com.iloen.melon.intent.action.widget.setting", true);
        intent0.addFlags(0x8000);
        intent0.putExtra("com.iloen.melon.intent.extra.actor", this.mActor);
        this.startActivity(intent0);
        return null;
    }

    public static MelonWidgetMoreViewFragment newInstance(Actor actor0) {
        MelonWidgetMoreViewFragment melonWidgetMoreViewFragment0 = new MelonWidgetMoreViewFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putSerializable("arg_actor", actor0);
        melonWidgetMoreViewFragment0.setArguments(bundle0);
        return melonWidgetMoreViewFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        if(bundle0 != null) {
            this.mActor = (Actor)CompatUtils.getSerializable(bundle0, "arg_actor", Actor.class);
        }
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        viewGroup0.setBackgroundResource(0x106000D);
        return layoutInflater0.inflate(0x7F0D0020, viewGroup0, false);  // layout:activity_popup_fragment
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        if(this.getContext() != null) {
            this.mMelonTiaraProperty = new s("위젯", "위젯_aos_바탕화면위젯", "1000003153", null);
        }
        this.showMorePopup();
    }

    private void openNowPlayingList() {
        Context context0 = this.requireContext();
        q.g(context0, "context");
        Context context1 = context0.getApplicationContext();
        q.d(context1);
        b b0 = (b)((d3)(((s2)((o)(((m)com.google.firebase.b.B(context1, m.class)))).w.get()))).a;
        b0.Y("getRecentAudioPlaylistIdOrNull");
        PlaylistId playlistId0 = (PlaylistId)b0.q.getValue();
        w w0 = playlistId0 == null ? null : b0.H(playlistId0);
        if(w0 != null && !e1.b.D(w0.getState())) {
            Intent intent0 = new Intent("com.iloen.melon.MELON_NOWPLAYING_START_ACTION");
            intent0.putExtra("activitystartactionname", "player");
            intent0.putExtra("com.iloen.melon.intent.extra.actor", this.mActor);
            intent0.addFlags(0x10000000);
            this.getActivity().startActivity(intent0);
            return;
        }
        ToastManager.showShort(0x7F13082B);  // string:playlist_empty "재생 가능한 곡이 없습니다."
    }

    private void openSearchView() {
        Intent intent0 = new Intent(this.getActivity(), MusicBrowserActivity.class);
        intent0.setAction("com.iloen.melon.intent.action.widget.search");
        intent0.putExtra("com.iloen.melon.intent.extra.actor", this.mActor);
        this.getActivity().startActivity(intent0);
    }

    private void openWidgetSetting() {
        MelonWidgetSettingFragment melonWidgetSettingFragment0 = MelonWidgetSettingFragment.newInstance(this.mActor);
        if(melonWidgetSettingFragment0 != null) {
            l0 l00 = this.getActivity().getSupportFragmentManager();
            l00.getClass();
            a a0 = new a(l00);
            a0.g(0x7F0A04DB, melonWidgetSettingFragment0, null);  // id:fragment
            a0.c("MelonWidgetSettingFragment");
            a0.k();
        }
    }

    private void showMorePopup() {
        if(this.isPossiblePopupShow()) {
            l0 l00 = this.getChildFragmentManager();
            com.iloen.melon.fragments.w w0 = new com.iloen.melon.fragments.w(this, 0);
            com.iloen.melon.fragments.w w1 = new com.iloen.melon.fragments.w(this, 1);
            com.iloen.melon.fragments.w w2 = new com.iloen.melon.fragments.w(this, 2);
            com.iloen.melon.fragments.w w3 = new com.iloen.melon.fragments.w(this, 3);
            if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K) {
                l00.C();
                if(com.melon.ui.popup.b.b(l00, "showWidgetMoreViewPopup", null, null, 12) == null) {
                    X x0 = new X();
                    x0.f = w0;
                    x0.g = w1;
                    x0.h = w2;
                    x0.i = w3;
                    x0.show(l00, "showWidgetMoreViewPopup");
                }
            }
        }
    }

    private void trackTiara(int v) {
        Context context0 = this.getContext();
        if(context0 != null && this.mMelonTiaraProperty != null) {
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = this.mMelonTiaraProperty.c;
            g0.a = "페이지이동";
            g0.d = ActionKind.ClickContent;
            g0.b = this.mMelonTiaraProperty.a;
            g0.c = this.mMelonTiaraProperty.b;
            g0.y = "더보기";
            g0.F = context0.getString(v);
            g0.a().track();
        }
    }
}

