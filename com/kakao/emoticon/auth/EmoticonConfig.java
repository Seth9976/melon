package com.kakao.emoticon.auth;

import android.app.Application;
import com.kakao.emoticon.interfaces.EmoticonAuthListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0016\u001A\u00020\u0017H&R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001A\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u0004\u0018\u00010\u000BX¦\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0005R\u0012\u0010\u0010\u001A\u00020\u0011X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/kakao/emoticon/auth/EmoticonConfig;", "", "appKey", "", "getAppKey", "()Ljava/lang/String;", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "emoticonAuthListener", "Lcom/kakao/emoticon/interfaces/EmoticonAuthListener;", "getEmoticonAuthListener", "()Lcom/kakao/emoticon/interfaces/EmoticonAuthListener;", "idpToken", "getIdpToken", "idpType", "Lcom/kakao/emoticon/auth/IdpType;", "getIdpType", "()Lcom/kakao/emoticon/auth/IdpType;", "kaHeader", "getKaHeader", "enableLoginTab", "", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public interface EmoticonConfig {
    boolean enableLoginTab();

    @NotNull
    String getAppKey();

    @Nullable
    Application getApplication();

    @Nullable
    EmoticonAuthListener getEmoticonAuthListener();

    @Nullable
    String getIdpToken();

    @NotNull
    IdpType getIdpType();

    @Nullable
    String getKaHeader();
}

