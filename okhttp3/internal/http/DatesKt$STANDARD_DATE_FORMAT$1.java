package okhttp3.internal.http;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001A\u00020\u0002H\u0014¨\u0006\u0004"}, d2 = {"okhttp3/internal/http/DatesKt$STANDARD_DATE_FORMAT$1", "Ljava/lang/ThreadLocal;", "Ljava/text/DateFormat;", "initialValue", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class DatesKt.STANDARD_DATE_FORMAT.1 extends ThreadLocal {
    @Override
    public Object initialValue() {
        return this.initialValue();
    }

    @NotNull
    public DateFormat initialValue() {
        DateFormat dateFormat0 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss \'GMT\'", Locale.US);
        dateFormat0.setLenient(false);
        dateFormat0.setTimeZone(Util.UTC);
        return dateFormat0;
    }
}

