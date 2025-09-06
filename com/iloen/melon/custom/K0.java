package com.iloen.melon.custom;

public final class k0 implements Runnable {
    public final int a;
    public final MelonContentLoadingProgressBar b;

    public k0(MelonContentLoadingProgressBar melonContentLoadingProgressBar0, int v) {
        this.a = v;
        this.b = melonContentLoadingProgressBar0;
        super();
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                MelonContentLoadingProgressBar melonContentLoadingProgressBar1 = this.b;
                melonContentLoadingProgressBar1.a = -1L;
                melonContentLoadingProgressBar1.d = false;
                melonContentLoadingProgressBar1.removeCallbacks(melonContentLoadingProgressBar1.e);
                melonContentLoadingProgressBar1.b = false;
                if(!melonContentLoadingProgressBar1.c) {
                    melonContentLoadingProgressBar1.postDelayed(melonContentLoadingProgressBar1.f, 400L);
                    melonContentLoadingProgressBar1.c = true;
                }
                return;
            }
            case 1: {
                this.b.b = false;
                this.b.a = -1L;
                this.b.setVisibility(8);
                return;
            }
            case 2: {
                MelonContentLoadingProgressBar melonContentLoadingProgressBar2 = this.b;
                melonContentLoadingProgressBar2.c = false;
                if(!melonContentLoadingProgressBar2.d) {
                    melonContentLoadingProgressBar2.a = System.currentTimeMillis();
                    melonContentLoadingProgressBar2.setVisibility(0);
                }
                return;
            }
            default: {
                MelonContentLoadingProgressBar melonContentLoadingProgressBar0 = this.b;
                melonContentLoadingProgressBar0.d = true;
                melonContentLoadingProgressBar0.removeCallbacks(melonContentLoadingProgressBar0.f);
                melonContentLoadingProgressBar0.c = false;
                long v = System.currentTimeMillis() - melonContentLoadingProgressBar0.a;
                if(v >= 200L || melonContentLoadingProgressBar0.a == -1L) {
                    melonContentLoadingProgressBar0.setVisibility(8);
                }
                else if(!melonContentLoadingProgressBar0.b) {
                    melonContentLoadingProgressBar0.postDelayed(melonContentLoadingProgressBar0.e, 200L - v);
                    melonContentLoadingProgressBar0.b = true;
                }
            }
        }
    }
}

