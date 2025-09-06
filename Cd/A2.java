package cd;

import com.iloen.melon.utils.tab.MainTabConstants.StrategyIconType;

public abstract class a2 {
    public static final int[] a;

    static {
        int[] arr_v = new int[StrategyIconType.values().length];
        try {
            arr_v[StrategyIconType.NONE.ordinal()] = 1;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[StrategyIconType.PLAY.ordinal()] = 2;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[StrategyIconType.AD.ordinal()] = 3;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        a2.a = arr_v;
    }
}

