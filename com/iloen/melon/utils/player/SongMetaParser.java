package com.iloen.melon.utils.player;

import R8.m;
import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.drm.AbsDcfController;
import com.iloen.melon.drm.downloadable.DownloadableDcfController;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.types.Song;
import com.iloen.melon.utils.FilenameUtils;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.CursorUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.gagravarr.flac.FlacNativeFile;
import org.gagravarr.flac.FlacTags;
import u9.f;
import va.e;

public class SongMetaParser {
    static final class SimpleMp3Id3V2Reader {
        public static byte[] a(Uri uri0) {
            byte[] arr_b;
            InputStream inputStream0 = null;
            try {
                inputStream0 = MelonAppBase.instance.getContext().getContentResolver().openInputStream(uri0);
                arr_b = SimpleMp3Id3V2Reader.c(inputStream0);
            }
            catch(Throwable throwable0) {
                if(inputStream0 != null) {
                    try {
                        inputStream0.close();
                    }
                    catch(IOException unused_ex) {
                    }
                }
                throw throwable0;
            }
            try {
                inputStream0.close();
            }
            catch(IOException unused_ex) {
            }
            return arr_b;
        }

        public static byte[] b(File file0) {
            byte[] arr_b;
            BufferedInputStream bufferedInputStream1;
            BufferedInputStream bufferedInputStream0 = null;
            if(!file0.exists() || file0.length() < 10L) {
                return null;
            }
            try {
                bufferedInputStream1 = new BufferedInputStream(new FileInputStream(file0), 0x2000);
            }
            catch(Throwable throwable0) {
                goto label_11;
            }
            try {
                arr_b = SimpleMp3Id3V2Reader.c(bufferedInputStream1);
                goto label_14;
            }
            catch(Throwable throwable0) {
                bufferedInputStream0 = bufferedInputStream1;
            }
        label_11:
            if(bufferedInputStream0 != null) {
                try {
                    bufferedInputStream0.close();
                }
                catch(IOException unused_ex) {
                }
            }
            throw throwable0;
            try {
            label_14:
                bufferedInputStream1.close();
            }
            catch(IOException unused_ex) {
            }
            return arr_b;
        }

        public static byte[] c(InputStream inputStream0) {
            long v = (long)inputStream0.available();
            byte[] arr_b = new byte[10];
            for(int v2 = 0; v2 < 10; v2 += v3) {
                int v3 = inputStream0.read(arr_b, v2, 10 - v2);
                if(v3 < 0) {
                    throw new IOException("bad read");
                }
            }
            if(arr_b[0] == 73 && arr_b[1] == 68 && arr_b[2] == 51) {
                boolean z = (arr_b[5] & 16) > 0;
                int[] arr_v = {arr_b[6] & 0xFF, arr_b[7] & 0xFF, arr_b[8] & 0xFF, arr_b[9] & 0xFF};
                for(int v4 = 0; v4 < 4; ++v4) {
                    int v5 = arr_v[v4] & 0x80;
                    if(v5 > 0) {
                        arr_v[v4] = v5;
                    }
                }
                int v6 = z ? (arr_v[1] << 14 | arr_v[0] << 21 | arr_v[2] << 7 | arr_v[3]) + 10 : arr_v[1] << 14 | arr_v[0] << 21 | arr_v[2] << 7 | arr_v[3];
                if(((long)(v6 + 10)) <= v) {
                    byte[] arr_b1 = new byte[v6];
                    for(int v1 = 0; v1 < v6; v1 += v7) {
                        int v7 = inputStream0.read(arr_b1, v1, v6 - v1);
                        if(v7 < 0) {
                            throw new IOException("bad read");
                        }
                    }
                    return v6 <= 0x200000 ? arr_b1 : null;
                }
            }
            return null;
        }
    }

    public static final int FLAG_ALBUMID = 4;
    public static final int FLAG_LCODE = 8;
    public static final int FLAG_SONGID = 2;
    public static final Pattern a;
    public static final Pattern b;
    public static final Pattern c;
    public static final Pattern d;

    static {
        SongMetaParser.a = Pattern.compile("(\\d+)");
        SongMetaParser.b = Pattern.compile(";sid=(\\d+);");
        SongMetaParser.c = Pattern.compile(";aid=(\\d+);");
        SongMetaParser.d = Pattern.compile("(m|l)mp(\\d+)");
    }

    public static String a(FlacNativeFile flacNativeFile0) {
        FlacTags flacTags0 = flacNativeFile0.getTags();
        if(flacTags0 != null) {
            Map map0 = flacTags0.getAllComments();
            if(map0 != null) {
                List list0 = (List)map0.get("melon_cid");
                if(list0 != null && !list0.isEmpty()) {
                    String s = SongMetaParser.parseLCode(((String)list0.get(0)));
                    return s == null ? null : SongMetaParser.b(s, "parseFlacLyricLCode");
                }
            }
        }
        return null;
    }

    public static String b(String s, String s1) {
        LogU.d("MetaParser", "parseLyricCode() from: " + s1);
        try {
            Matcher matcher0 = SongMetaParser.d.matcher(s);
            if(matcher0.find()) {
                if("m".equals(matcher0.group(1))) {
                    return "mlr" + matcher0.group(2);
                }
                return "l".equals(matcher0.group(1)) ? "llr" + matcher0.group(2) : "";
            }
            return "";
        }
        catch(Exception exception0) {
        }
        LogU.w("MetaParser", "parseLyricCode() lCode:" + s + ", e : " + exception0);
        return "";
    }

    public static void c(Song song0, String s, String s1, int v) {
        song0.e = 2;
        song0.b = s;
        if((v & 8) > 0) {
            song0.d = SongMetaParser.parseLCode(s1);
        }
        if((v & 4) > 0) {
            song0.g = SongMetaParser.parseAlbumId(s1);
        }
    }

    public static File getLyricFile(Uri uri0) {
        File file0;
        String s = SongMetaParser.parseLyricCodeFromUri(uri0);
        if(TextUtils.isEmpty(s)) {
            file0 = null;
        }
        else {
            Context context0 = MelonAppBase.instance.getContext();
            file0 = new File(f.g.b(context0, "lyric").a(), s + ".slf");
        }
        LogU.d("MetaParser", "getLyricFile() uri: " + uri0 + ", lyricFile: " + file0);
        return file0;
    }

    // 去混淆评级： 低(20)
    public static File getLyricFile(Playable playable0) {
        File file0;
        Context context0 = MelonAppBase.instance.getContext();
        String s = f.g.b(context0, "lyric").f;
        if(FilenameUtils.isMusic("", true)) {
            file0 = new File(s + "" + ".slf");
        }
        else {
            String s1 = StorageUtils.isScopedStorage() ? SongMetaParser.parseLyricCodeFromUri(Uri.parse("")) : SongMetaParser.parseLyricCodeFromFile("");
            file0 = TextUtils.isEmpty(s1) ? null : new File(s + s1 + ".slf");
        }
        LogU.d("MetaParser", "getLyricFile() playable:, lyricFile:" + file0);
        return file0;
    }

    public static File getLyricFile(String s) {
        File file0;
        Context context0 = MelonAppBase.instance.getContext();
        String s1 = f.g.b(context0, "lyric").f;
        if(FilenameUtils.isMusic(s, true)) {
            file0 = new File(e.c(s1, FilenameUtils.getBasename(s), ".slf"));
        }
        else {
            String s2 = SongMetaParser.parseLyricCodeFromFile(s);
            file0 = TextUtils.isEmpty(s2) ? null : new File(s1 + s2 + ".slf");
        }
        LogU.d("MetaParser", "getLyricFile() songPath:" + s + ", lyricFile:" + file0);
        return file0;
    }

    public static String parseAlbumId(String s) {
        try {
            Matcher matcher0 = SongMetaParser.c.matcher(s);
            return matcher0.find() ? matcher0.group(1) : "";
        }
        catch(Exception exception0) {
            LogU.w("MetaParser", "parseAlbumId() cid : " + s + ", e : " + exception0);
            return "";
        }
    }

    public static Song parseDcfMeta(Uri uri0, Song song0) {
        Context context0 = MelonAppBase.instance.getContext();
        DownloadableDcfController downloadableDcfController0 = (DownloadableDcfController)m.a(context0, 1);
        try {
            String s = downloadableDcfController0.j(uri0).b;
            if(!TextUtils.isEmpty(s)) {
                if(song0 == null) {
                    song0 = new Song(null, uri0, s, 2);
                }
                else {
                    song0.e = 2;
                    song0.b = s;
                }
            }
            return song0;
        }
        catch(Exception unused_ex) {
            m.b(context0);
            return song0;
        }
        finally {
            m.b(context0);
        }
    }

    public static String parseDcfSongId(String s) {
        try {
            Matcher matcher0 = SongMetaParser.a.matcher(s);
            return matcher0.find() ? matcher0.group(1) : "";
        }
        catch(Exception exception0) {
            LogU.w("MetaParser", "parseDcfSongId() failed - desc : " + s + ", e : " + exception0);
            return "";
        }
    }

    public static String parseFlacLyricLCode(Uri uri0) {
        String s;
        InputStream inputStream1;
        LogU.d("MetaParser", "parseFlacLyricLCode() uri : " + uri0);
        InputStream inputStream0 = null;
        try {
            inputStream1 = null;
            inputStream1 = MelonAppBase.instance.getContext().getContentResolver().openInputStream(uri0);
            s = SongMetaParser.a(new FlacNativeFile(inputStream1));
            goto label_19;
        }
        catch(Exception exception0) {
            goto label_10;
        }
        catch(Throwable throwable0) {
        }
        goto label_16;
        try {
            try {
                s = SongMetaParser.a(new FlacNativeFile(inputStream1));
                goto label_19;
            }
            catch(Exception exception0) {
            }
        label_10:
            LogU.w("MetaParser", "parseFlacLyricLCode() uri error : " + exception0);
            if(inputStream1 != null) {
                goto label_12;
            }
            return null;
        }
        catch(Throwable throwable0) {
            goto label_15;
        }
        try {
        label_12:
            inputStream1.close();
        }
        catch(IOException unused_ex) {
        }
        return null;
    label_15:
        inputStream0 = inputStream1;
    label_16:
        if(inputStream0 != null) {
            try {
                inputStream0.close();
            }
            catch(IOException unused_ex) {
            }
        }
        throw throwable0;
    label_19:
        if(inputStream1 != null) {
            try {
                inputStream1.close();
            }
            catch(IOException unused_ex) {
            }
        }
        return s;
    }

    public static String parseLCode(String s) {
        try {
            Matcher matcher0 = SongMetaParser.d.matcher(s);
            return matcher0.find() ? matcher0.group() : "";
        }
        catch(Exception exception0) {
            LogU.w("MetaParser", "parseLCode() melonCidStr : " + s + ", e : " + exception0);
            return "";
        }
    }

    public static String parseLyricCodeFromFile(String s) {
        String s1 = null;
        switch(FilenameUtils.getFileType(s)) {
            case 0x102: {
                try {
                    byte[] arr_b = SimpleMp3Id3V2Reader.b(new File(s));
                    if(arr_b != null) {
                        String s2 = SongMetaParser.parseLCode(new String(arr_b, "euc-kr"));
                        if(s2 != null) {
                            return SongMetaParser.b(s2, "parseMp3LyricLCode");
                        }
                    }
                }
                catch(Exception exception0) {
                    LogU.w("MetaParser", "parseMp3LyricLCode() path error : " + exception0);
                }
                return null;
            }
            case 0x202: {
                Z.w("parseFlacLyricLCode() path : ", s, "MetaParser");
                try {
                    return SongMetaParser.a(new FlacNativeFile(new File(s)));
                }
                catch(Exception exception1) {
                    LogU.w("MetaParser", "parseFlacLyricLCode() path error : " + exception1);
                    return null;
                }
            }
            case 0x402: {
                Context context0 = MelonAppBase.instance.getContext();
                AbsDcfController absDcfController0 = m.a(context0, m.a);
                try {
                    s1 = absDcfController0.d(s).a();
                }
                catch(Exception exception2) {
                    LogU.w("MetaParser", "parseDcfLyricLCode() path error : " + exception2);
                }
                finally {
                    m.b(context0);
                }
                return s1;
            }
            default: {
                return null;
            }
        }
    }

    public static String parseLyricCodeFromUri(Uri uri0) {
        Context context0 = MelonAppBase.instance.getContext();
        String s = null;
        if(DocumentsContract.isDocumentUri(context0, uri0)) {
            Context context1 = MelonAppBase.instance.getContext();
            DownloadableDcfController downloadableDcfController0 = (DownloadableDcfController)m.a(context1, 1);
            try {
                s = downloadableDcfController0.j(uri0).a();
            }
            catch(Exception unused_ex) {
            }
            finally {
                m.b(context1);
            }
            return s;
        }
        switch(FilenameUtils.getFileType(CursorUtil.getDisplayName(context0, uri0))) {
            case 0x102: {
                return SongMetaParser.parseMp3LyricLCode(uri0);
            }
            case 0x202: {
                return SongMetaParser.parseFlacLyricLCode(uri0);
            }
            default: {
                return null;
            }
        }
    }

    public static Song parseMeta(Uri uri0, Song song0, int v) {
        InputStream inputStream1;
        InputStream inputStream0 = null;
        switch(FilenameUtils.getFileType(StorageUtils.getDisplayName(uri0, MelonAppBase.instance.getContext()))) {
            case 0x102: {
                try {
                    byte[] arr_b = SimpleMp3Id3V2Reader.a(uri0);
                    if(arr_b != null) {
                        String s = new String(arr_b, "euc-kr");
                        String s1 = SongMetaParser.parseSongId(s);
                        if(!TextUtils.isEmpty(s1)) {
                            if(song0 == null) {
                                song0 = new Song(null, uri0, s1, 2);
                            }
                            SongMetaParser.c(song0, s1, s, v);
                            return song0;
                        }
                    }
                    break;
                }
                catch(Exception exception0) {
                }
                LogU.w("MetaParser", "parseMp3Meta() uri e : " + exception0);
                return song0;
            }
            case 0x202: {
                try {
                    try {
                        inputStream1 = MelonAppBase.instance.getContext().getContentResolver().openInputStream(uri0);
                    }
                    catch(Exception exception1) {
                        LogU.w("MetaParser", "parseFlacMeta() uri e : " + exception1);
                        goto label_43;
                    }
                }
                catch(Throwable throwable0) {
                    goto label_46;
                }
                try {
                    FlacTags flacTags0 = new FlacNativeFile(inputStream1).getTags();
                    if(flacTags0 != null) {
                        Map map0 = flacTags0.getAllComments();
                        if(map0 != null) {
                            List list0 = (List)map0.get("melon_cid");
                            if(list0 != null && !list0.isEmpty()) {
                                String s2 = (String)list0.get(0);
                                String s3 = SongMetaParser.parseSongId(s2);
                                if(!TextUtils.isEmpty(s3)) {
                                    if(song0 == null) {
                                        song0 = new Song(null, uri0, s3, 2);
                                    }
                                    SongMetaParser.c(song0, s3, s2, v);
                                }
                            }
                        }
                    }
                    goto label_49;
                }
                catch(Exception exception1) {
                    inputStream0 = inputStream1;
                }
                catch(Throwable throwable0) {
                    inputStream0 = inputStream1;
                    goto label_46;
                }
                try {
                    LogU.w("MetaParser", "parseFlacMeta() uri e : " + exception1);
                }
                catch(Throwable throwable0) {
                    goto label_46;
                }
            label_43:
                if(inputStream0 != null) {
                    try {
                        inputStream0.close();
                        return song0;
                    }
                    catch(IOException unused_ex) {
                        break;
                    }
                label_46:
                    if(inputStream0 != null) {
                        try {
                            inputStream0.close();
                        }
                        catch(IOException unused_ex) {
                        }
                    }
                    throw throwable0;
                label_49:
                    if(inputStream1 != null) {
                        try {
                            inputStream1.close();
                            return song0;
                        }
                        catch(IOException unused_ex) {
                        }
                    }
                }
                break;
            }
            case 0x402: {
                return SongMetaParser.parseDcfMeta(uri0, song0);
            }
            default: {
                return null;
            }
        }
        return song0;
    }

    public static Song parseMeta(String s, Song song0, int v) {
        switch(FilenameUtils.getFileType(s)) {
            case 0x102: {
                try {
                    byte[] arr_b = SimpleMp3Id3V2Reader.b(new File(s));
                    if(arr_b != null) {
                        String s2 = new String(arr_b, "euc-kr");
                        String s3 = SongMetaParser.parseSongId(s2);
                        if(!TextUtils.isEmpty(s3)) {
                            if(song0 == null) {
                                song0 = new Song(s, null, s3, 2);
                            }
                            SongMetaParser.c(song0, s3, s2, v);
                            return song0;
                        }
                    }
                    return song0;
                }
                catch(Exception exception1) {
                }
                LogU.w("MetaParser", "parseMp3Meta() path e : " + exception1);
                return song0;
            }
            case 0x202: {
                try {
                    FlacTags flacTags0 = new FlacNativeFile(new File(s)).getTags();
                    if(flacTags0 != null) {
                        Map map0 = flacTags0.getAllComments();
                        if(map0 != null) {
                            List list0 = (List)map0.get("melon_cid");
                            if(list0 != null && !list0.isEmpty()) {
                                String s4 = (String)list0.get(0);
                                String s5 = SongMetaParser.parseSongId(s4);
                                if(!TextUtils.isEmpty(s5)) {
                                    if(song0 == null) {
                                        song0 = new Song(s, null, s5, 2);
                                    }
                                    SongMetaParser.c(song0, s5, s4, v);
                                    return song0;
                                }
                            }
                        }
                    }
                    return song0;
                }
                catch(Exception exception2) {
                }
                break;
            }
            case 0x402: {
                Context context0 = MelonAppBase.instance.getContext();
                AbsDcfController absDcfController0 = m.a(context0, m.a);
                try {
                    String s1 = absDcfController0.d(s).b;
                    if(!TextUtils.isEmpty(s1)) {
                        if(song0 == null) {
                            song0 = new Song(s, null, s1, 2);
                        }
                        else {
                            song0.e = 2;
                            song0.b = s1;
                        }
                    }
                }
                catch(Exception exception0) {
                    LogU.w("MetaParser", "parseDcfMeta() path e : " + exception0);
                }
                finally {
                    m.b(context0);
                }
                return song0;
            }
            default: {
                return null;
            }
        }
        LogU.w("MetaParser", "parseFlacMeta() path e : " + exception2);
        return song0;
    }

    public static String parseMp3LyricLCode(Uri uri0) {
        try {
            byte[] arr_b = SimpleMp3Id3V2Reader.a(uri0);
            if(arr_b != null) {
                String s = SongMetaParser.parseLCode(new String(arr_b, "euc-kr"));
                return s == null ? null : SongMetaParser.b(s, "parseMp3LyricLCode");
            }
        }
        catch(Exception exception0) {
            LogU.w("MetaParser", "parseMp3LyricLCode() uri error : " + exception0);
        }
        return null;
    }

    public static String parseSongId(String s) {
        try {
            Matcher matcher0 = SongMetaParser.b.matcher(s);
            return matcher0.find() ? matcher0.group(1) : "";
        }
        catch(Exception exception0) {
            LogU.w("MetaParser", "parseSongId() melonCidStr : " + s + ", e : " + exception0);
            return "";
        }
    }
}

