package com.iloen.melon.fragments.main.foru;

import we.a;

public final class c implements a {
    public final int a;
    public final ForUMixMakerKeywordPredictiveFragment b;

    public c(ForUMixMakerKeywordPredictiveFragment forUMixMakerKeywordPredictiveFragment0, int v) {
        this.a = v;
        this.b = forUMixMakerKeywordPredictiveFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return SearchFooterViewHolder.lambda$1$lambda$0(this.b);
            }
            case 1: {
                return ForUMixMakerKeywordPredictiveFragment.imm_delegate$lambda$0(this.b);
            }
            default: {
                return ForUMixMakerKeywordPredictiveFragment.adapter_delegate$lambda$1(this.b);
            }
        }
    }
}

