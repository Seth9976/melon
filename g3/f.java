package g3;

import android.net.Uri;
import b3.j;
import java.util.Collections;
import java.util.Map;

public interface f extends j {
    void close();

    default Map getResponseHeaders() {
        return Collections.EMPTY_MAP;
    }

    Uri getUri();

    long p(g3.j arg1);

    void r(x arg1);
}

