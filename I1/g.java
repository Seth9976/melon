package i1;

import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

public abstract class g {
    public static final MainCoroutineDispatcher a;

    static {
        g.a = Dispatchers.getMain();
    }
}

