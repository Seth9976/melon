package com.kakao.emoticon.interfaces;

import com.kakao.emoticon.net.EmoticonApiError;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/kakao/emoticon/interfaces/EmoticonAuthListener;", "", "Lcom/kakao/emoticon/net/EmoticonApiError;", "e", "Lie/H;", "onFail", "(Lcom/kakao/emoticon/net/EmoticonApiError;)V", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public interface EmoticonAuthListener {
    void onFail(@NotNull EmoticonApiError arg1);
}

