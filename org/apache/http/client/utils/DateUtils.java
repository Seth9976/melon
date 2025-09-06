package org.apache.http.client.utils;

import H0.b;
import java.lang.ref.SoftReference;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
public final class DateUtils {
    static final class DateFormatHolder {
        private static final ThreadLocal THREADLOCAL_FORMATS;

        static {
            DateFormatHolder.THREADLOCAL_FORMATS = new ThreadLocal() {
                @Override
                public Object initialValue() {
                    return this.initialValue();
                }

                public SoftReference initialValue() {
                    return new SoftReference(new HashMap());
                }
            };
        }

        public static void clearThreadLocal() {
            DateFormatHolder.THREADLOCAL_FORMATS.remove();
        }

        public static SimpleDateFormat formatFor(String s) {
            ThreadLocal threadLocal0 = DateFormatHolder.THREADLOCAL_FORMATS;
            Map map0 = (Map)((SoftReference)threadLocal0.get()).get();
            if(map0 == null) {
                map0 = new HashMap();
                threadLocal0.set(new SoftReference(map0));
            }
            SimpleDateFormat simpleDateFormat0 = (SimpleDateFormat)map0.get(s);
            if(simpleDateFormat0 == null) {
                simpleDateFormat0 = new SimpleDateFormat(s, Locale.US);
                simpleDateFormat0.setTimeZone(TimeZone.getTimeZone("GMT"));
                map0.put(s, simpleDateFormat0);
            }
            return simpleDateFormat0;
        }
    }

    private static final String[] DEFAULT_PATTERNS = null;
    private static final Date DEFAULT_TWO_DIGIT_YEAR_START = null;
    public static final TimeZone GMT = null;
    public static final String PATTERN_ASCTIME = "EEE MMM d HH:mm:ss yyyy";
    public static final String PATTERN_RFC1036 = "EEE, dd-MMM-yy HH:mm:ss zzz";
    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";

    static {
        DateUtils.DEFAULT_PATTERNS = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy"};
        TimeZone timeZone0 = TimeZone.getTimeZone("GMT");
        DateUtils.GMT = timeZone0;
        Calendar calendar0 = Calendar.getInstance();
        calendar0.setTimeZone(timeZone0);
        calendar0.set(2000, 0, 1, 0, 0, 0);
        calendar0.set(14, 0);
        DateUtils.DEFAULT_TWO_DIGIT_YEAR_START = calendar0.getTime();
    }

    public static void clearThreadLocal() {
        DateFormatHolder.clearThreadLocal();
    }

    public static String formatDate(Date date0) {
        return DateUtils.formatDate(date0, "EEE, dd MMM yyyy HH:mm:ss zzz");
    }

    public static String formatDate(Date date0, String s) {
        Args.notNull(date0, "Date");
        Args.notNull(s, "Pattern");
        return DateFormatHolder.formatFor(s).format(date0);
    }

    public static Date parseDate(String s) {
        return DateUtils.parseDate(s, null, null);
    }

    public static Date parseDate(String s, String[] arr_s) {
        return DateUtils.parseDate(s, arr_s, null);
    }

    public static Date parseDate(String s, String[] arr_s, Date date0) {
        Args.notNull(s, "Date value");
        if(arr_s == null) {
            arr_s = DateUtils.DEFAULT_PATTERNS;
        }
        if(date0 == null) {
            date0 = DateUtils.DEFAULT_TWO_DIGIT_YEAR_START;
        }
        if(s.length() > 1 && s.startsWith("\'") && s.endsWith("\'")) {
            s = b.d(1, 1, s);
        }
        for(int v = 0; v < arr_s.length; ++v) {
            SimpleDateFormat simpleDateFormat0 = DateFormatHolder.formatFor(arr_s[v]);
            simpleDateFormat0.set2DigitYearStart(date0);
            ParsePosition parsePosition0 = new ParsePosition(0);
            Date date1 = simpleDateFormat0.parse(s, parsePosition0);
            if(parsePosition0.getIndex() != 0) {
                return date1;
            }
        }
        return null;
    }
}

