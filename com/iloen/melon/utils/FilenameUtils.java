package com.iloen.melon.utils;

import java.io.File;

public class FilenameUtils {
    public static final int FILE_TYPE_3GP = 0x8004;
    public static final int FILE_TYPE_DCF = 0x402;
    public static final int FILE_TYPE_FLAC = 0x202;
    public static final int FILE_TYPE_JPEG = 0x10008;
    public static final int FILE_TYPE_MP3 = 0x102;
    public static final int FILE_TYPE_MP4 = 0x4004;
    public static final int FILE_TYPE_PNG = 0x20008;
    public static final int FILE_TYPE_UNSUPPORTED;

    public static String getBasename(String s) [...] // 潜在的解密器

    public static String getExtension(String s) {
        if(s == null) {
            return null;
        }
        int v = FilenameUtils.indexOfExtension(s);
        return v == -1 ? "" : s.substring(v + 1);
    }

    public static int getFileType(String s) {
        String s1 = FilenameUtils.getExtension(s);
        if(s1 != null) {
            String s2 = s1.toLowerCase();
            if("mp3".equals(s2)) {
                return 0x102;
            }
            if("dcf".equals(s2)) {
                return 0x402;
            }
            if("mp4".equals(s2)) {
                return 0x4004;
            }
            if("3gp".equals(s2)) {
                return 0x8004;
            }
            if("jpeg".equals(s2)) {
                return 0x10008;
            }
            if("jpg".equals(s2)) {
                return 0x10008;
            }
            if("png".equals(s2)) {
                return 0x20008;
            }
            return "flac".equals(s2) ? 0x202 : 0;
        }
        return 0;
    }

    public static String getName(String s) {
        return s == null ? null : s.substring(FilenameUtils.indexOfLastSeparator(s) + 1);
    }

    public static int indexOfExtension(String s) {
        if(s == null) {
            return -1;
        }
        int v = s.lastIndexOf(46);
        return FilenameUtils.indexOfLastSeparator(s) <= v ? v : -1;
    }

    public static int indexOfLastSeparator(String s) {
        return s == null ? -1 : s.lastIndexOf(((int)File.separatorChar));
    }

    public static boolean isDcf(String s) [...] // 潜在的解密器

    public static boolean isFlac(String s) {
        return FilenameUtils.getFileType(s) == 0x202;
    }

    public static boolean isImage(String s) {
        return (FilenameUtils.getFileType(s) & 8) > 0;
    }

    public static boolean isMp3(String s) {
        return FilenameUtils.getFileType(s) == 0x102;
    }

    public static boolean isMp4(String s) {
        return FilenameUtils.getFileType(s) == 0x4004;
    }

    public static boolean isMusic(String s) {
        return FilenameUtils.isMusic(s, null);
    }

    // 去混淆评级： 低(20)
    public static boolean isMusic(String s, boolean z) {
        return z ? FilenameUtils.isMusic(s, new int[]{0x402}) : FilenameUtils.isMusic(s, null);
    }

    public static boolean isMusic(String s, int[] arr_v) {
        int v = FilenameUtils.getFileType(s);
        if((v & 2) > 0) {
            if(arr_v != null) {
                for(int v1 = 0; v1 < arr_v.length; ++v1) {
                    if(arr_v[v1] == v) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static boolean isMusicOrVideo(String s) {
        return (FilenameUtils.getFileType(s) & 6) > 0;
    }

    public static boolean isVideo(String s) {
        return (FilenameUtils.getFileType(s) & 4) > 0;
    }

    public static String removeExtension(String s) {
        if(s == null) {
            return null;
        }
        int v = FilenameUtils.indexOfExtension(s);
        return v == -1 ? s : s.substring(0, v);
    }
}

