package com.kakao.sdk.user.model;

import com.kakao.sdk.common.json.GenericEnumSerializer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/kakao/sdk/user/model/AgeRangeSerializer;", "Lcom/kakao/sdk/common/json/GenericEnumSerializer;", "Lcom/kakao/sdk/user/model/AgeRange;", "()V", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AgeRangeSerializer extends GenericEnumSerializer {
    @NotNull
    public static final AgeRangeSerializer INSTANCE;

    static {
        AgeRangeSerializer.INSTANCE = new AgeRangeSerializer();
    }

    private AgeRangeSerializer() {
        super(AgeRange.class);
    }
}

