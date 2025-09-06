package S1;

import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.Build.VERSION;

public abstract class e {
    public static final int a;

    static {
        new ThreadLocal();
    }

    public static void a(Paint paint0, a a0) {
        PorterDuff.Mode porterDuff$Mode0;
        PorterDuffXfermode porterDuffXfermode0 = null;
        if(Build.VERSION.SDK_INT >= 29) {
            if(a0 != null) {
                porterDuffXfermode0 = b.i(a0);
            }
            b.k(paint0, porterDuffXfermode0);
            return;
        }
        if(a0 != null) {
            switch(a0.ordinal()) {
                case 0: {
                    porterDuff$Mode0 = PorterDuff.Mode.CLEAR;
                    break;
                }
                case 1: {
                    porterDuff$Mode0 = PorterDuff.Mode.SRC;
                    break;
                }
                case 2: {
                    porterDuff$Mode0 = PorterDuff.Mode.DST;
                    break;
                }
                case 3: {
                    porterDuff$Mode0 = PorterDuff.Mode.SRC_OVER;
                    break;
                }
                case 4: {
                    porterDuff$Mode0 = PorterDuff.Mode.DST_OVER;
                    break;
                }
                case 5: {
                    porterDuff$Mode0 = PorterDuff.Mode.SRC_IN;
                    break;
                }
                case 6: {
                    porterDuff$Mode0 = PorterDuff.Mode.DST_IN;
                    break;
                }
                case 7: {
                    porterDuff$Mode0 = PorterDuff.Mode.SRC_OUT;
                    break;
                }
                case 8: {
                    porterDuff$Mode0 = PorterDuff.Mode.DST_OUT;
                    break;
                }
                case 9: {
                    porterDuff$Mode0 = PorterDuff.Mode.SRC_ATOP;
                    break;
                }
                case 10: {
                    porterDuff$Mode0 = PorterDuff.Mode.DST_ATOP;
                    break;
                }
                case 11: {
                    porterDuff$Mode0 = PorterDuff.Mode.XOR;
                    break;
                }
                case 12: {
                    porterDuff$Mode0 = PorterDuff.Mode.ADD;
                    break;
                }
                case 13: {
                    porterDuff$Mode0 = PorterDuff.Mode.MULTIPLY;
                    break;
                }
                case 14: {
                    porterDuff$Mode0 = PorterDuff.Mode.SCREEN;
                    break;
                }
                case 15: {
                    porterDuff$Mode0 = PorterDuff.Mode.OVERLAY;
                    break;
                }
                case 16: {
                    porterDuff$Mode0 = PorterDuff.Mode.DARKEN;
                    break;
                }
                case 17: {
                    porterDuff$Mode0 = PorterDuff.Mode.LIGHTEN;
                    break;
                }
                default: {
                    porterDuff$Mode0 = null;
                }
            }
            if(porterDuff$Mode0 != null) {
                porterDuffXfermode0 = new PorterDuffXfermode(porterDuff$Mode0);
            }
            paint0.setXfermode(porterDuffXfermode0);
            return;
        }
        paint0.setXfermode(null);
    }
}

