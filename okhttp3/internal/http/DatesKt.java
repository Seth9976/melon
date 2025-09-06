package okhttp3.internal.http;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\n\u001A\u000E\u0010\f\u001A\u0004\u0018\u00010\r*\u00020\u0005H\u0000\u001A\f\u0010\u000E\u001A\u00020\u0005*\u00020\rH\u0000\"\u0018\u0010\u0000\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u0016\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00050\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u000E\u0010\u0007\u001A\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000B¨\u0006\u000F"}, d2 = {"BROWSER_COMPATIBLE_DATE_FORMATS", "", "Ljava/text/DateFormat;", "[Ljava/text/DateFormat;", "BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS", "", "[Ljava/lang/String;", "MAX_DATE", "", "STANDARD_DATE_FORMAT", "okhttp3/internal/http/DatesKt$STANDARD_DATE_FORMAT$1", "Lokhttp3/internal/http/DatesKt$STANDARD_DATE_FORMAT$1;", "toHttpDateOrNull", "Ljava/util/Date;", "toHttpDateString", "okhttp"}, k = 2, mv = {1, 8, 0}, xi = 0x30)
public final class DatesKt {
    @NotNull
    private static final DateFormat[] BROWSER_COMPATIBLE_DATE_FORMATS = null;
    @NotNull
    private static final String[] BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = null;
    public static final long MAX_DATE = 0xE677D21FDBFFL;
    @NotNull
    private static final DatesKt.STANDARD_DATE_FORMAT.1 STANDARD_DATE_FORMAT;

    static {
        DatesKt.STANDARD_DATE_FORMAT = new DatesKt.STANDARD_DATE_FORMAT.1();
        DatesKt.BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        DatesKt.BROWSER_COMPATIBLE_DATE_FORMATS = new DateFormat[15];
    }

    @Nullable
    public static final Date toHttpDateOrNull(@NotNull String s) {
        Date date1;
        int v;
        q.g(s, "<this>");
        if(s.length() == 0) {
            return null;
        }
        ParsePosition parsePosition0 = new ParsePosition(0);
        Date date0 = ((DateFormat)DatesKt.STANDARD_DATE_FORMAT.get()).parse(s, parsePosition0);
        if(parsePosition0.getIndex() == s.length()) {
            return date0;
        }
        String[] arr_s = DatesKt.BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
        __monitor_enter(arr_s);
        try {
            v = 0;
            while(true) {
                if(v >= arr_s.length) {
                    goto label_28;
                }
                DateFormat[] arr_dateFormat = DatesKt.BROWSER_COMPATIBLE_DATE_FORMATS;
                DateFormat dateFormat0 = arr_dateFormat[v];
                if(dateFormat0 == null) {
                    dateFormat0 = new SimpleDateFormat(DatesKt.BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[v], Locale.US);
                    dateFormat0.setTimeZone(Util.UTC);
                    arr_dateFormat[v] = dateFormat0;
                }
                parsePosition0.setIndex(0);
                date1 = dateFormat0.parse(s, parsePosition0);
                if(parsePosition0.getIndex() != 0) {
                    goto label_24;
                }
                ++v;
            }
        }
        catch(Throwable throwable0) {
        }
        __monitor_exit(arr_s);
        throw throwable0;
    label_24:
        __monitor_exit(arr_s);
        return date1;
    label_28:
        __monitor_exit(arr_s);
        return null;
    }

    @NotNull
    public static final String toHttpDateString(@NotNull Date date0) {
        q.g(date0, "<this>");
        String s = ((DateFormat)DatesKt.STANDARD_DATE_FORMAT.get()).format(date0);
        q.f(s, "STANDARD_DATE_FORMAT.get().format(this)");
        return s;
    }
}

