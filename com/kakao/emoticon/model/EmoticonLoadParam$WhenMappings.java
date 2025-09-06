package com.kakao.emoticon.model;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
public final class EmoticonLoadParam.WhenMappings {
    public static final int[] $EnumSwitchMapping$0;

    static {
        int[] arr_v = new int[DrawType.values().length];
        EmoticonLoadParam.WhenMappings.$EnumSwitchMapping$0 = arr_v;
        arr_v[DrawType.TITLE.ordinal()] = 1;
        arr_v[DrawType.THUMB.ordinal()] = 2;
        arr_v[DrawType.EMOTICON.ordinal()] = 3;
        arr_v[DrawType.ICON_ON.ordinal()] = 4;
        arr_v[DrawType.ICON_OFF.ordinal()] = 5;
    }
}

