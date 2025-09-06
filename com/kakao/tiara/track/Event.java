package com.kakao.tiara.track;

import com.kakao.tiara.TiaraTracker;
import com.kakao.tiara.data.ActionType;
import com.kakao.tiara.data.LogBuilder;

public final class Event extends LogBuilder {
    public Event(TiaraTracker tiaraTracker0, String s) {
        super(tiaraTracker0, s);
        this.actionType(ActionType.Event);
    }
}

