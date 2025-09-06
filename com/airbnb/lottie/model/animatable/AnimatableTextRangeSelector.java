package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.model.content.TextRangeUnits;

public class AnimatableTextRangeSelector {
    public final AnimatableIntegerValue end;
    public final AnimatableIntegerValue offset;
    public final AnimatableIntegerValue start;
    public final TextRangeUnits units;

    public AnimatableTextRangeSelector(AnimatableIntegerValue animatableIntegerValue0, AnimatableIntegerValue animatableIntegerValue1, AnimatableIntegerValue animatableIntegerValue2, TextRangeUnits textRangeUnits0) {
        this.start = animatableIntegerValue0;
        this.end = animatableIntegerValue1;
        this.offset = animatableIntegerValue2;
        this.units = textRangeUnits0;
    }
}

