package d;

import androidx.activity.ComponentActivity;
import java.util.concurrent.CopyOnWriteArraySet;

public final class a {
    public final CopyOnWriteArraySet a;
    public volatile ComponentActivity b;

    public a() {
        this.a = new CopyOnWriteArraySet();
    }
}

