package com.kakao.emoticon.ui.tab;

public final class b implements Runnable {
    public final EmoticonTabAdapter a;
    public final int b;
    public final int c;

    public b(EmoticonTabAdapter emoticonTabAdapter0, int v, int v1) {
        this.a = emoticonTabAdapter0;
        this.b = v;
        this.c = v1;
    }

    @Override
    public final void run() {
        this.a.lambda$onItemIdle$1(this.b, this.c);
    }
}

