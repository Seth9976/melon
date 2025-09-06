package com.kakao.sdk.network;

import okhttp3.logging.HttpLoggingInterceptor.Logger;

public final class a implements Logger {
    @Override  // okhttp3.logging.HttpLoggingInterceptor$Logger
    public final void log(String s) {
        ApiFactory.loggingInterceptor.2.invoke$lambda$0(s);
    }
}

