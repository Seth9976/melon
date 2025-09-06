package com.iloen.melon.fragments.melontv.program;

import androidx.activity.result.ActivityResult;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.iloen.melon.custom.J;
import com.iloen.melon.custom.S;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import e.a;

public final class n implements ErrorListener, J, a {
    public final MetaContentBaseFragment a;

    public n(MetaContentBaseFragment metaContentBaseFragment0) {
        this.a = metaContentBaseFragment0;
        super();
    }

    @Override  // com.iloen.melon.custom.J
    public void a(S s0, boolean z) {
        TvProgramMoreSongFragment.setAllCheckButtonVisibility$lambda$7(((TvProgramMoreSongFragment)this.a), s0, z);
    }

    @Override  // e.a
    public void onActivityResult(Object object0) {
        TvProgramHomeFragment.activityResult$lambda$3(((TvProgramHomeFragment)this.a), ((ActivityResult)object0));
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        TvProgramMoreSongFragment.request$lambda$12$lambda$11(((TvProgramMoreSongFragment)this.a), volleyError0);
    }
}

