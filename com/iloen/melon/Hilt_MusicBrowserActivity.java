package com.iloen.melon;

import Ub.q;
import Ub.s;
import Ub.u;
import Vb.t0;
import android.content.Context;
import android.view.View;
import androidx.appcompat.app.h;
import androidx.lifecycle.f0;
import androidx.lifecycle.y;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.custom.f1;
import com.iloen.melon.fragments.tabs.BottomTabBaseFragment;
import com.iloen.melon.fragments.tabs.BottomTabPagerAdapter;
import com.melon.data.newlogin.BlockStoreAccountRepository;
import com.melon.playback.melon.drm.c;
import com.melon.ui.interfaces.StringProviderImpl;
import d5.t;
import hc.l;
import k8.a;
import k8.e;
import k8.q1;
import kb.D;
import kc.s2;
import mb.b;
import mb.k;
import ob.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sd.P;

public abstract class Hilt_MusicBrowserActivity extends BaseActivity {
    private boolean injected;

    public Hilt_MusicBrowserActivity() {
        this.injected = false;
        this._initHiltInternal();
    }

    private void _initHiltInternal() {
        this.addOnContextAvailableListener(new h(this, 1));
    }

    @Override  // com.iloen.melon.activity.BaseActivity
    @Nullable
    public abstract BottomTabPagerAdapter getBottomTabPagerAdapter();

    @Override  // com.iloen.melon.activity.BaseActivity
    @Nullable
    public abstract View getCtlBottom();

    @Override  // com.iloen.melon.activity.BaseActivity
    @Nullable
    public abstract BottomTabBaseFragment getCurrentTabContainerFragment();

    @Override  // com.iloen.melon.activity.BaseActivity
    public abstract int getMiniPlayerHeight();

    @Override  // com.iloen.melon.activity.Hilt_BaseActivity
    public void inject() {
        if(!this.injected) {
            this.injected = true;
            q1 q10 = (q1)this.generatedComponent();
            ((MusicBrowserActivity)this).blockingProgressDialogManage = (a)((e)q10).b.l.get();
            ((MusicBrowserActivity)this).playerUseCase = ((e)q10).b.k();
            ((MusicBrowserActivity)this).loginUseCase = (k)((e)q10).b.m.get();
            ((MusicBrowserActivity)this).kakaoLoginUseCase = ((e)q10).b.f();
            ((MusicBrowserActivity)this).tokenCheckUseCase = ((e)q10).b();
            ((MusicBrowserActivity)this).playbackManager = (q)((e)q10).b.u.get();
            ((MusicBrowserActivity)this).playlistManager = (s2)((e)q10).b.w.get();
            ((MusicBrowserActivity)this).vodRepeatManager = (u)((e)q10).b.U.get();
            ((MusicBrowserActivity)this).playerRules = (t0)((e)q10).b.A0.get();
            Context context0 = ((e)q10).b.a.a;
            t.e(context0);
            Object object0 = ((e)q10).b.w.get();
            StringProviderImpl stringProviderImpl0 = ((e)q10).b.u();
            Bc.h h0 = ((e)q10).b.j();
            z z0 = ((e)q10).b.k();
            l l0 = ((e)q10).b.l();
            y y0 = f0.f(((e)q10).a);
            kotlin.jvm.internal.q.g(((s2)object0), "playlistManager");
            ((MusicBrowserActivity)this).miniPlayerViewModel = new P(context0, ((s2)object0), stringProviderImpl0, h0, z0, l0, y0);
            ((MusicBrowserActivity)this).drmContentsHelper = (c)((e)q10).b.B0.get();
            ((MusicBrowserActivity)this).remotePlayerManager = (s)((e)q10).b.z.get();
            ((MusicBrowserActivity)this).shuffleRepeatChangeNotifier = ((e)q10).b.s();
            BlockStoreAccountRepository blockStoreAccountRepository0 = (BlockStoreAccountRepository)((e)q10).b.k.get();
            kotlin.jvm.internal.q.g(blockStoreAccountRepository0, "blockStoreAccountRepository");
            ((MusicBrowserActivity)this).blockStoreRetrieveAndLoginUseCase = new b(new D(blockStoreAccountRepository0, 14), ((e)q10).b(), ((k)((e)q10).b.m.get()));
        }
    }

    @Override  // com.iloen.melon.activity.BaseActivity
    public abstract boolean isTabInitialized();

    @Override  // com.iloen.melon.activity.BaseActivity
    public abstract void selectTab(int arg1, boolean arg2, boolean arg3);

    @Override  // com.iloen.melon.activity.BaseActivity
    public abstract void selectTabAndClear(int arg1);

    @Override  // com.iloen.melon.activity.BaseActivity
    public abstract void setBottomTabFragmentForeground(boolean arg1);

    @Override  // com.iloen.melon.activity.BaseActivity
    public abstract void setTabAndMiniPlayerVisible(boolean arg1, boolean arg2, boolean arg3);

    @Override  // com.iloen.melon.activity.BaseActivity
    public abstract void setVideoMiniPlayer();

    @Override  // com.iloen.melon.activity.BaseActivity
    public abstract void updateSystemUiFit(@NotNull f1 arg1);
}

