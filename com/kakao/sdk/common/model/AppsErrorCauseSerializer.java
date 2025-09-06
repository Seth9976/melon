package com.kakao.sdk.common.model;

import com.kakao.sdk.common.json.GenericEnumSerializer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/kakao/sdk/common/model/AppsErrorCauseSerializer;", "Lcom/kakao/sdk/common/json/GenericEnumSerializer;", "Lcom/kakao/sdk/common/model/AppsErrorCause;", "()V", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
final class AppsErrorCauseSerializer extends GenericEnumSerializer {
    @NotNull
    public static final AppsErrorCauseSerializer INSTANCE;

    static {
        AppsErrorCauseSerializer.INSTANCE = new AppsErrorCauseSerializer();
    }

    private AppsErrorCauseSerializer() {
        super(AppsErrorCause.class);
    }
}

