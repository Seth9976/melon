package com.kakao.tiara;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

class UUID {
    private static final char[] CHARS = null;
    private static final String DATE_FORMAT_PATTERN = "yyMMdd";
    private static final String DATE_FORMAT_PATTERN_WITH_TIME = "yyMMddkkmmssSSS";
    private static final int ID_LENGTH = 12;
    private static final String NUMBER_FORMAT = "%09d";
    private static final int RANDOM_NUMBER_BOUND = 1000000000;
    private static final String SEPARATOR = "_";

    static {
        UUID.CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    }

    private static void appendDate(StringBuilder stringBuilder0, boolean z) {
        stringBuilder0.append(new SimpleDateFormat((z ? "yyMMddkkmmssSSS" : "yyMMdd"), Locale.US).format(Calendar.getInstance().getTime()));
    }

    private static void appendRandomChars(StringBuilder stringBuilder0) {
        Random random0 = new Random();
        for(int v = 0; v < 12; ++v) {
            stringBuilder0.append(UUID.CHARS[random0.nextInt(UUID.CHARS.length)]);
        }
    }

    private static void appendRandomNumber(StringBuilder stringBuilder0) {
        Object[] arr_object = {new Random().nextInt(1000000000)};
        stringBuilder0.append(String.format(Locale.US, "%09d", arr_object));
    }

    private static void appendSeparator(StringBuilder stringBuilder0) {
        stringBuilder0.append("_");
    }

    public static String generate(boolean z) [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    public static String generateWithTime() [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    public static String generateWithoutTime() [...] // 潜在的解密器
}

