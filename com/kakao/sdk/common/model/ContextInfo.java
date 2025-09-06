package com.kakao.sdk.common.model;

import kotlin.Metadata;
import kotlinx.serialization.json.JsonObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0012\u0010\n\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\u0005R\u0012\u0010\f\u001A\u00020\rX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0012\u0010\u0010\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/kakao/sdk/common/model/ContextInfo;", "", "appVer", "", "getAppVer", "()Ljava/lang/String;", "extras", "Lkotlinx/serialization/json/JsonObject;", "getExtras", "()Lkotlinx/serialization/json/JsonObject;", "kaHeader", "getKaHeader", "salt", "", "getSalt", "()[B", "signingKeyHash", "getSigningKeyHash", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public interface ContextInfo {
    @NotNull
    String getAppVer();

    @NotNull
    JsonObject getExtras();

    @NotNull
    String getKaHeader();

    @NotNull
    byte[] getSalt();

    @NotNull
    String getSigningKeyHash();
}

