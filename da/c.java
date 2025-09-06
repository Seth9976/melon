package da;

import H4.a;
import android.database.Cursor;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import d8.d;
import ie.H;
import ie.o;
import ie.p;
import java.io.Closeable;
import kotlin.jvm.internal.q;

public abstract class c {
    public static final b a;
    public static final b b;
    public static final b c;
    public static final b d;

    static {
        c.a = new b(34, 35, 0);
        c.b = new b(35, 36, 1);
        c.c = new b(36, 37, 2);
        c.d = new b(37, 38, 3);
    }

    public static void a(a a0) {
        o o0;
        Closeable closeable0;
        boolean z;
        int v = a0.getVersion();
        try {
            a0.u("\n                    CREATE TABLE IF NOT EXISTS `search_history`\n                    (\n                        `_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n                        `song_id` TEXT NOT NULL,\n                        `song_name` TEXT NOT NULL,\n                        `album_id` TEXT NOT NULL,\n                        `album_name` TEXT NOT NULL,\n                        `album_img_path` TEXT NOT NULL,\n                        `artist_id` TEXT NOT NULL,\n                        `artist_name` TEXT NOT NULL,\n                        `ctype` TEXT NOT NULL,\n                        `is_service` INTEGER NOT NULL,\n                        `is_adult` INTEGER NOT NULL,\n                        `play_time` TEXT NOT NULL,\n                        `timestamp` INTEGER NOT NULL\n                    )\n                    ");
            a0.u("\n                    CREATE UNIQUE INDEX IF NOT EXISTS index_search_history_song_id_unique ON search_history (song_id)\n                    ");
            z = false;
            boolean z1 = a0.R("SELECT * FROM sqlite_master WHERE name = \'search_hist\'").getCount() != 0;
            Companion logU$Companion0 = LogU.Companion;
            logU$Companion0.d("MelonDatabaseMigration", "isExistSearchHist : " + z1);
            if(z1) {
                a0.u("\n                        INSERT OR IGNORE INTO search_history (\n                            song_id,\n                            song_name,\n                            album_id,\n                            album_name,\n                            album_img_path,\n                            artist_id,\n                            artist_name,\n                            ctype,\n                            is_service,\n                            is_adult,\n                            play_time,\n                            timestamp\n                        )\n                        SELECT\n                            song_id,\n                            song_title,\n                            album_id,\n                            album_name,\n                            album_img_path,\n                            artist_id,\n                            artist_name,\n                            ctype,\n                            is_service,\n                            0,\n                            play_time,\n                            strftime(\'%s\', timestamp) * 1000\n                        FROM search_hist\n                        ");
                a0.u("\n                        DROP TABLE IF EXISTS search_hist\n                        ");
            }
            a0.u("\n                    CREATE TABLE IF NOT EXISTS `local_playback_log`\n                    (\n                        `_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n                        `data` TEXT NOT NULL,\n                        `cid` TEXT NOT NULL,\n                        `ctype` TEXT NOT NULL,\n                        `lcode` TEXT NOT NULL,\n                        `timestamp` INTEGER NOT NULL\n                    )\n                    ");
            boolean z2 = a0.R("SELECT * FROM sqlite_master WHERE name = \'playbacklog\'").getCount() != 0;
            logU$Companion0.d("MelonDatabaseMigration", "isExistPlaybackLog : " + z2);
            if(z2) {
                a0.u("\n                    INSERT INTO local_playback_log (\n                        data,\n                        cid,\n                        ctype,\n                        lcode,\n                        timestamp\n                    )\n                    SELECT\n                        data,\n                        cid,\n                        ctype,\n                        lcode,\n                        played_time\n                    FROM playbacklog\n                    ");
                a0.u("\n                    DROP TABLE IF EXISTS playbacklog\n                    ");
            }
            a0.u("\n                    CREATE TABLE IF NOT EXISTS `premium_off_play_log`\n                    (\n                        `_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n                        `cid` TEXT NOT NULL,\n                        `ctype` TEXT NOT NULL,\n                        `pstime` TEXT NOT NULL,\n                        `meta_type` TEXT NOT NULL,\n                        `bitrate` TEXT NOT NULL,\n                        `binfo` TEXT NOT NULL,\n                        `free_yn` TEXT NOT NULL,\n                        `memberkey` TEXT NOT NULL,\n                        `timestamp` INTEGER NOT NULL\n                    )\n                    ");
            boolean z3 = a0.R("SELECT * FROM sqlite_master WHERE name = \'premium_offplay_log\'").getCount() != 0;
            logU$Companion0.d("MelonDatabaseMigration", "isExistPremiumOffplayLog : " + z3);
            if(z3) {
                a0.u("\n                    INSERT INTO premium_off_play_log (\n                        cid,\n                        ctype,\n                        pstime,\n                        meta_type,\n                        bitrate,\n                        binfo,\n                        free_yn,\n                        memberkey,\n                        timestamp\n                    )\n                    SELECT\n                        cid,\n                        ctype,\n                        pstime,\n                        meta_type,\n                        bitrate,\n                        binfo,\n                        free_yn,\n                        memberkey,\n                        played_time\n                    FROM premium_offplay_log\n                    ");
                a0.u("\n                    DROP TABLE IF EXISTS premium_offplay_log\n                    ");
            }
            a0.u("\n                    CREATE TABLE IF NOT EXISTS `banner_popup`\n                    (\n                        `_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n                        `member_key` TEXT NOT NULL,\n                        `id` TEXT NOT NULL,\n                        `ban_on` TEXT NOT NULL,\n                        `popup_type` TEXT NOT NULL\n                    )\n                    ");
            a0.u("\n                    CREATE UNIQUE INDEX IF NOT EXISTS index_member_key_id_popup_type_unique ON banner_popup (member_key, id, popup_type);\n                    ");
            boolean z4 = a0.R("SELECT * FROM sqlite_master WHERE name = \'layer_popup\'").getCount() != 0;
            logU$Companion0.d("MelonDatabaseMigration", "isExistLayerPopup : " + z4);
            if(z4) {
                a0.u("\n                    INSERT OR IGNORE INTO banner_popup (\n                        member_key,\n                        id,\n                        ban_on,\n                        popup_type\n                    )\n                    SELECT\n                        member_key,\n                        BANERSEQ,\n                        BANON,\n                        \'LAYER\'\n                    FROM layer_popup\n                    ");
                a0.u("\n                        DROP TABLE IF EXISTS layer_popup\n                        ");
            }
            boolean z5 = a0.R("SELECT * FROM sqlite_master WHERE name = \'notice_popup\'").getCount() != 0;
            logU$Companion0.d("MelonDatabaseMigration", "isExistNoticePopup : " + z5);
            if(z5) {
                a0.u("\n                    INSERT OR IGNORE INTO banner_popup (\n                        member_key,\n                        id,\n                        ban_on,\n                        popup_type\n                    )\n                    SELECT\n                        MEMBER_KEY,\n                        BANERSEQ,\n                        BANON,\n                        \'NOTICE\'\n                    FROM notice_popup\n                    ");
                a0.u("\n                        DROP TABLE IF EXISTS notice_popup\n                        ");
            }
            a0.u("\n                    CREATE TABLE IF NOT EXISTS `floating_banner_popup`\n                    (\n                        `_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n                        `member_key` TEXT NOT NULL,\n                        `BANERSEQ` TEXT NOT NULL,\n                        `BANON` TEXT NOT NULL\n                    )\n                    ");
            boolean z6 = a0.R("SELECT * FROM sqlite_master WHERE name = \'floating_banner_popup\'").getCount() != 0;
            logU$Companion0.d("MelonDatabaseMigration", "isExistFloatingBannerPopup : " + z6);
            if(z6) {
                a0.u("\n                    INSERT OR IGNORE INTO banner_popup (\n                        member_key,\n                        id,\n                        ban_on,\n                        popup_type\n                    )\n                    SELECT\n                        member_key,\n                        BANERSEQ,\n                        BANON,\n                        \'FLOATING\'\n                    FROM floating_banner_popup\n                    ");
            }
            a0.u("\n                    DROP TABLE IF EXISTS floating_banner_popup\n                    ");
            boolean z7 = a0.R("SELECT * FROM sqlite_master WHERE name = \'promotion_popup\'").getCount() != 0;
            logU$Companion0.d("MelonDatabaseMigration", "isExistPromotionPopup : " + z7);
            if(z7) {
                a0.u("\n                    INSERT OR IGNORE INTO banner_popup (\n                        member_key,\n                        id,\n                        ban_on,\n                        popup_type\n                    )\n                    SELECT\n                        member_key,\n                        id,\n                        query,\n                        \'PROMOTION\'\n                    FROM promotion_popup\n                    ");
                a0.u("\n                    DROP TABLE IF EXISTS promotion_popup\n                    ");
            }
            a0.u("\n                    CREATE TABLE IF NOT EXISTS `response_cache_new`\n                    (\n                        `_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n                        `key` TEXT NOT NULL,\n                        `cache_type` INTEGER NOT NULL DEFAULT 0,\n                        `contents` TEXT NOT NULL,\n                        `has_more` INTEGER NOT NULL DEFAULT 0,\n                        `timestamp` INTEGER NOT NULL\n                    )\n                    ");
            a0.u("\n                    DROP TABLE IF EXISTS response_cache\n                    ");
            a0.u("\n                    ALTER TABLE response_cache_new RENAME TO response_cache;\n                    ");
            closeable0 = a0.R("PRAGMA table_info(user_equalizer)");
        }
        catch(Throwable throwable0) {
            goto label_71;
        }
        try {
            if(((Cursor)closeable0).moveToFirst()) {
                while(true) {
                    if(q.b(((Cursor)closeable0).getString(((Cursor)closeable0).getColumnIndexOrThrow("name")), "type")) {
                        z = true;
                        break;
                    }
                    if(!((Cursor)closeable0).moveToNext()) {
                        break;
                    }
                }
            }
            goto label_59;
        }
        catch(Throwable throwable1) {
            try {
                d.l(closeable0, throwable1);
                throw throwable1;
            label_59:
                d.l(closeable0, null);
                LogU.Companion.d("MelonDatabaseMigration", "typeColumnExists : " + z);
                if(z) {
                    a0.u("\n                    CREATE TABLE IF NOT EXISTS `user_equalizer_new`\n                    (\n                        `_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n                        `eq_type` INTEGER NOT NULL DEFAULT 0,\n                        `name` TEXT NOT NULL,\n                        `eq_values` TEXT NOT NULL,\n                        `range` TEXT NOT NULL\n                    )\n                    ");
                    a0.u("\n                    INSERT INTO user_equalizer_new (\n                        eq_type,\n                        name,\n                        eq_values,\n                        range\n                    )\n                    SELECT\n                        type,\n                        name,\n                        eq_values,\n                        range\n                    FROM user_equalizer\n                    ");
                    a0.u("\n                    DROP TABLE IF EXISTS user_equalizer\n                    ");
                    a0.u("\n                    ALTER TABLE user_equalizer_new RENAME TO user_equalizer;\n                    ");
                }
                else {
                    a0.u("\n                    CREATE TABLE IF NOT EXISTS `user_equalizer`\n                    (\n                        `_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n                        `eq_type` INTEGER NOT NULL DEFAULT 0,\n                        `name` TEXT NOT NULL,\n                        `eq_values` TEXT NOT NULL,\n                        `range` TEXT NOT NULL\n                    )\n                    ");
                }
                o0 = H.a;
                goto label_72;
            }
            catch(Throwable throwable0) {
            }
        }
    label_71:
        o0 = n.t(throwable0);
    label_72:
        if(!(o0 instanceof o)) {
            H h0 = (H)o0;
            LogU.Companion.e("MelonDatabaseMigration", "migrate() version : " + v + " -> " + (v + 1) + " success");
        }
        Throwable throwable2 = p.a(o0);
        if(throwable2 != null) {
            StringBuilder stringBuilder0 = androidx.appcompat.app.o.t(v, v + 1, "migrate() version : ", " -> ", " error : ");
            stringBuilder0.append(throwable2);
            LogU.Companion.e("MelonDatabaseMigration", stringBuilder0.toString());
            a7.c c0 = a7.c.a();
            StringBuilder stringBuilder1 = androidx.appcompat.app.o.t(v, v + 1, "MelonDb Migrate fail - ", " -> ", " ");
            stringBuilder1.append(throwable2.getMessage());
            c0.b(stringBuilder1.toString());
        }
    }
}

