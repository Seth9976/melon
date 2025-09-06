package com.iloen.melon.utils;

import android.text.TextUtils;

public class SoundSearcher {
    public static final int ENGLISH = 1;
    public static final int HANGUL = 0;
    public static final int SPECIAL = 2;
    public static final char[] a;

    static {
        SoundSearcher.a = new char[]{'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'};
    }

    public static String getChosung(String s) {
        StringBuilder stringBuilder0 = new StringBuilder();
        if(TextUtils.isEmpty(s)) {
            return stringBuilder0.toString();
        }
        char[] arr_c = s.toCharArray();
        for(int v = 0; v < arr_c.length; ++v) {
            Character character0 = SoundSearcher.isHangul(arr_c[v]) ? Character.valueOf(SoundSearcher.getInitialSound(arr_c[v])) : Character.valueOf(arr_c[v]);
            if(v == 0) {
                character0 = Character.valueOf(Character.toUpperCase(character0.charValue()));
            }
            stringBuilder0.append(character0);
        }
        return stringBuilder0.toString();
    }

    // 去混淆评级： 低(20)
    public static char getInitialSound(char c) {
        return SoundSearcher.isInitialSound(c) ? c : SoundSearcher.a[(c - 0xAC00) / 588];
    }

    public static int getPrefixIndex(String s) {
        if(SoundSearcher.isHangul(s.toCharArray()[0])) {
            return 0;
        }
        return s.substring(0, 1).matches("^[a-zA-Z]+$") ? 1 : 2;
    }

    public static String getPrefixToUpperCase(String s) {
        if(SoundSearcher.isHangul(s.toCharArray()[0])) {
            return Character.valueOf(SoundSearcher.getInitialSound(s.toCharArray()[0])).toString();
        }
        String s1 = s.substring(0, 1);
        return s1.matches("^[a-zA-Z]+$") ? s1.substring(0, 1).toUpperCase() : "#";
    }

    public static boolean hasChosung(String s) {
        boolean z = false;
        for(int v = 0; v < s.length() && !z; ++v) {
            for(int v1 = 0; v1 < 19; ++v1) {
                if(s.charAt(v) == SoundSearcher.a[v1]) {
                    z = true;
                    break;
                }
            }
        }
        return z;
    }

    public static boolean isHangul(char c) {
        return 0xAC00 <= c && c <= 55203;
    }

    public static boolean isInitialSound(char c) {
        for(int v = 0; v < 19; ++v) {
            if(SoundSearcher.a[v] == c) {
                return true;
            }
        }
        return false;
    }

    public static boolean matchString(String s, String s1) {
        int v = s.length() - s1.length();
        int v1 = s1.length();
        if(v < 0) {
            return false;
        }
        for(int v2 = 0; v2 <= v; ++v2) {
            int v3;
            for(v3 = 0; v3 < v1; ++v3) {
                if(SoundSearcher.isInitialSound(s1.charAt(v3))) {
                    int v4 = v2 + v3;
                    if(SoundSearcher.isHangul(s.charAt(v4)) && SoundSearcher.getInitialSound(s.charAt(v4)) != s1.charAt(v3)) {
                        break;
                    }
                }
                else if(s.charAt(v2 + v3) != s1.charAt(v3)) {
                    break;
                }
            }
            if(v3 == v1) {
                return true;
            }
        }
        return false;
    }
}

