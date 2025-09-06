package com.kakao.emoticon.model;

import com.kakao.emoticon.R.drawable;

public enum DrawType {
    THUMB(drawable.emoticon_not_found_padding),
    EMOTICON,
    TITLE,
    ICON_ON(-1),
    ICON_OFF(-1);

    private int placeHolder;

    private DrawType() {
        this.placeHolder = drawable.emoticon_not_found;
    }

    private DrawType(int v1) {
        this.placeHolder = v1;
    }

    public int getPlaceHolder() {
        return this.placeHolder;
    }
}

