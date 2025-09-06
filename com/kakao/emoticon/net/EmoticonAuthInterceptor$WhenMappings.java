package com.kakao.emoticon.net;

import com.kakao.emoticon.auth.IdpType;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
public final class EmoticonAuthInterceptor.WhenMappings {
    public static final int[] $EnumSwitchMapping$0;

    static {
        int[] arr_v = new int[IdpType.values().length];
        EmoticonAuthInterceptor.WhenMappings.$EnumSwitchMapping$0 = arr_v;
        arr_v[IdpType.DAUM.ordinal()] = 1;
        arr_v[IdpType.KAKAO_V1.ordinal()] = 2;
    }
}

