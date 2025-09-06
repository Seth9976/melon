package b1;

import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;

public abstract class j {
    public static final h a;
    public static final long b;

    static {
        j.a = new h();  // 初始化器: Landroid/graphics/Canvas;-><init>()V
        j.b = 0L;
    }

    public static final TextDirectionHeuristic a(int v) {
        switch(v) {
            case 0: {
                return TextDirectionHeuristics.LTR;
            }
            case 1: {
                return TextDirectionHeuristics.RTL;
            }
            case 2: {
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
            case 3: {
                return TextDirectionHeuristics.FIRSTSTRONG_RTL;
            }
            case 4: {
                return TextDirectionHeuristics.ANYRTL_LTR;
            }
            case 5: {
                return TextDirectionHeuristics.LOCALE;
            }
            default: {
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
        }
    }
}

