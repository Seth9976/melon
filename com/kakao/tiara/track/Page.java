package com.kakao.tiara.track;

import com.kakao.tiara.TiaraTracker;
import com.kakao.tiara.data.ActionType;
import com.kakao.tiara.data.LogBuilder;

public final class Page extends LogBuilder {
    public Page(TiaraTracker tiaraTracker0, String s) {
        super(tiaraTracker0, s);
        this.actionType(ActionType.Pageview);
    }
}

