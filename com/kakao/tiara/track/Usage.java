package com.kakao.tiara.track;

import com.kakao.tiara.TiaraTracker;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.ActionType;
import com.kakao.tiara.data.LogBuilder;

public final class Usage extends LogBuilder {
    public Usage(TiaraTracker tiaraTracker0, String s) {
        super(tiaraTracker0, s);
        this.actionType(ActionType.Usage);
        super.actionKind(ActionKind.UsagePage);
    }

    @Override  // com.kakao.tiara.data.LogBuilder
    public LogBuilder actionKind(ActionKind actionKind0) {
        return this;
    }
}

