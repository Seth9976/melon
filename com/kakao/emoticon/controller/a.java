package com.kakao.emoticon.controller;

public final class a implements Runnable {
    public final KeyboardHeightCache a;

    public a(KeyboardHeightCache keyboardHeightHelper$KeyboardHeightCache0) {
        this.a = keyboardHeightHelper$KeyboardHeightCache0;
    }

    @Override
    public final void run() {
        KeyboardHeightCache.a(this.a);
    }
}

