package k3;

import h3.a;
import i3.l;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface t {
    void a(c arg1);

    int b();

    a c(byte[] arg1);

    void closeSession(byte[] arg1);

    default void d(byte[] arr_b, l l0) {
    }

    boolean e(String arg1, byte[] arg2);

    r getKeyRequest(byte[] arg1, List arg2, int arg3, HashMap arg4);

    s getProvisionRequest();

    byte[] openSession();

    byte[] provideKeyResponse(byte[] arg1, byte[] arg2);

    void provideProvisionResponse(byte[] arg1);

    Map queryKeyStatus(byte[] arg1);

    void release();

    void restoreKeys(byte[] arg1, byte[] arg2);
}

