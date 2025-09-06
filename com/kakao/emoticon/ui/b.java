package com.kakao.emoticon.ui;

public final class b implements Runnable {
    public final int a;
    public final KeyboardEmoticonManager b;

    public b(KeyboardEmoticonManager keyboardEmoticonManager0, int v) {
        this.a = v;
        this.b = keyboardEmoticonManager0;
        super();
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                this.b.lambda$hide$3();
                return;
            }
            case 1: {
                this.b.lambda$onConfigurationChanged$4();
                return;
            }
            case 2: {
                this.b.lambda$dismissOtherPopupWindowsDelayed$2();
                return;
            }
            default: {
                this.b.lambda$show$0();
            }
        }
    }
}

