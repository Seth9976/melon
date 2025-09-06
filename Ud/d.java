package ud;

import Ub.s;
import Ub.u;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.iloen.melon.fragments.MelonBaseFragment_MembersInjector;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import d5.n;
import dagger.hilt.android.internal.managers.ViewComponentManager.FragmentContextWrapper;
import ee.i;
import h7.u0;
import k8.a;
import k8.h;
import kc.s2;

public abstract class d extends MetaContentBaseFragment {
    public ViewComponentManager.FragmentContextWrapper a;
    public boolean b;
    public boolean c;

    public d() {
        this.c = false;
    }

    public final void d0() {
        if(this.a == null) {
            this.a = new ViewComponentManager.FragmentContextWrapper(super.getContext(), this);
            this.b = u0.I(super.getContext());
        }
    }

    @Override  // com.iloen.melon.fragments.Hilt_MelonBaseFragment
    public final Context getContext() {
        if(super.getContext() == null && !this.b) {
            return null;
        }
        this.d0();
        return this.a;
    }

    @Override  // com.iloen.melon.fragments.Hilt_MelonBaseFragment
    public final void inject() {
        if(!this.c) {
            this.c = true;
            b0 b00 = (b0)this.generatedComponent();
            MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(((Z)this), ((a)((h)b00).b.l.get()));
            MelonBaseFragment_MembersInjector.injectPlaylistManager(((Z)this), ((s2)((h)b00).b.w.get()));
            MelonBaseFragment_MembersInjector.injectVodRepeatManager(((Z)this), ((u)((h)b00).b.U.get()));
            MelonBaseFragment_MembersInjector.injectRemotePlayerManager(((Z)this), ((s)((h)b00).b.z.get()));
            MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(((Z)this), ((h)b00).b());
            ((Z)this).e = ((h)b00).b.k();
        }
    }

    @Override  // com.iloen.melon.fragments.Hilt_MelonBaseFragment
    public final void onAttach(Activity activity0) {
        super.onAttach(activity0);
        n.n(this.a == null || i.b(this.a) == activity0, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        this.d0();
        this.inject();
    }

    @Override  // com.iloen.melon.fragments.Hilt_MelonBaseFragment
    public final void onAttach(Context context0) {
        super.onAttach(context0);
        this.d0();
        this.inject();
    }

    @Override  // com.iloen.melon.fragments.Hilt_MelonBaseFragment
    public final LayoutInflater onGetLayoutInflater(Bundle bundle0) {
        LayoutInflater layoutInflater0 = super.onGetLayoutInflater(bundle0);
        return layoutInflater0.cloneInContext(new ViewComponentManager.FragmentContextWrapper(layoutInflater0, this));
    }
}

