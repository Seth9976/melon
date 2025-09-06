package com.kakao.emoticon.auth;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001A\u00020\u0004X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/kakao/emoticon/auth/EmoticonAdapter;", "", "()V", "emoticonServiceConfig", "Lcom/kakao/emoticon/auth/EmoticonConfig;", "getEmoticonServiceConfig", "()Lcom/kakao/emoticon/auth/EmoticonConfig;", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public abstract class EmoticonAdapter {
    @NotNull
    public abstract EmoticonConfig getEmoticonServiceConfig();
}

