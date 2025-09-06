package com.iloen.melon.fragments.main.foru;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ForUMixmakerKeywordPredictiveRes.RESPONSE.TAGLIST;
import java.io.Serializable;

public final class b implements View.OnClickListener {
    public final int a;
    public final ForUMixMakerKeywordPredictiveFragment b;
    public final Serializable c;

    public b(ForUMixMakerKeywordPredictiveFragment forUMixMakerKeywordPredictiveFragment0, Serializable serializable0, int v) {
        this.a = v;
        this.b = forUMixMakerKeywordPredictiveFragment0;
        this.c = serializable0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            SearchInputAdapter.onBindViewHolder$lambda$1(this.b, ((String)this.c), view0);
            return;
        }
        SearchInputAdapter.onBindViewHolder$lambda$0(this.b, ((TAGLIST)this.c), view0);
    }
}

