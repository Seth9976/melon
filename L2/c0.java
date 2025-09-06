package l2;

import java.io.InputStream;
import java.io.OutputStream;
import kotlin.coroutines.Continuation;

public interface c0 {
    Object getDefaultValue();

    Object readFrom(InputStream arg1, Continuation arg2);

    Object writeTo(Object arg1, OutputStream arg2, Continuation arg3);
}

