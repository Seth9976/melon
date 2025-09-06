package i.n.i.b.a.s.e;

import android.net.Uri;
import android.text.TextUtils;
import g3.h;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ic implements kd {
    public static final Pattern a;

    static {
        ic.a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");
    }

    @Override  // i.n.i.b.a.s.e.kd
    public final Object j(Uri uri0, h h0) {
        String s = new BufferedReader(new InputStreamReader(h0, b9.c)).readLine();
        try {
            Matcher matcher0 = ic.a.matcher(s);
            if(!matcher0.matches()) {
                throw new H4("Couldn\'t parse timestamp: " + s);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
            }
            String s1 = matcher0.group(1);
            SimpleDateFormat simpleDateFormat0 = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss", Locale.US);
            simpleDateFormat0.setTimeZone(TimeZone.getTimeZone("UTC"));
            long v = simpleDateFormat0.parse(s1).getTime();
            if(!"Z".equals(matcher0.group(2))) {
                long v1 = "+".equals(matcher0.group(4)) ? 1L : -1L;
                long v2 = Long.parseLong(matcher0.group(5));
                String s2 = matcher0.group(7);
                v -= (v2 * 60L + (TextUtils.isEmpty(s2) ? 0L : Long.parseLong(s2))) * 60000L * v1;
            }
            return v;
        }
        catch(ParseException parseException0) {
        }
        throw new H4(parseException0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
    }
}

