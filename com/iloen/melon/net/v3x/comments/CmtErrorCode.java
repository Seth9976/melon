package com.iloen.melon.net.v3x.comments;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/net/v3x/comments/CmtErrorCode;", "", "<init>", "()V", "INVALI_REQUEST", "", "NOT_LOGIN", "BLOCK_USER", "UNKNOWN_REQUEST", "TOKEN_EXPIRE", "SERVER_ERROR", "CAN_NOT_WRITE_ADCMT_ON_DELETED_CMT", "ALREADY_DELETE_CMT", "RECM_NO_RECM_NOT_ALLOWED_ON_DELETED_CMT", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CmtErrorCode {
    public static final int $stable = 0;
    @NotNull
    public static final String ALREADY_DELETE_CMT = "607";
    @NotNull
    public static final String BLOCK_USER = "403";
    @NotNull
    public static final String CAN_NOT_WRITE_ADCMT_ON_DELETED_CMT = "605";
    @NotNull
    public static final CmtErrorCode INSTANCE = null;
    @NotNull
    public static final String INVALI_REQUEST = "400";
    @NotNull
    public static final String NOT_LOGIN = "401";
    @NotNull
    public static final String RECM_NO_RECM_NOT_ALLOWED_ON_DELETED_CMT = "608";
    @NotNull
    public static final String SERVER_ERROR = "500";
    @NotNull
    public static final String TOKEN_EXPIRE = "405";
    @NotNull
    public static final String UNKNOWN_REQUEST = "404";

    static {
        CmtErrorCode.INSTANCE = new CmtErrorCode();
    }
}

