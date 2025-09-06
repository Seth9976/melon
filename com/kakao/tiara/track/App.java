package com.kakao.tiara.track;

import com.kakao.tiara.TiaraTracker;
import com.kakao.tiara.data.ActionType;
import com.kakao.tiara.data.LogBuilder;

public class App extends LogBuilder {
    public App(TiaraTracker tiaraTracker0, String s, String s1) {
        super(tiaraTracker0, s);
        this.actionType(ActionType.App);
        this.adTrackId(s1);
    }
}

