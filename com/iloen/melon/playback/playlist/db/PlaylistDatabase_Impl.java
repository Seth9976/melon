package com.iloen.melon.playback.playlist.db;

import D4.o;
import D4.q;
import D4.r;
import E9.w;
import G4.a;
import U4.x;
import androidx.room.K;
import androidx.room.L;
import androidx.room.M;
import androidx.room.l;
import com.google.firebase.b;
import h7.u0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class PlaylistDatabase_Impl extends PlaylistDatabase {
    private volatile PlaylistDao _playlistDao;

    @Override  // androidx.room.H
    public void clearAllTables() {
        this.performClear(false, new String[]{"MUSIC", "EDU", "SMART", "MIXUP", "MIXUP_WAITING_BACK"});
    }

    @Override  // androidx.room.H
    public l createInvalidationTracker() {
        return new l(this, new HashMap(0), new HashMap(0), new String[]{"MUSIC", "EDU", "SMART", "MIXUP", "MIXUP_WAITING_BACK"});
    }

    public L createOpenDelegate() {
        return new L(3, "ae6701eb42368d36ed7448809ed0f3c1", "354c2f85ee1f41abd25a18fa98b0b476") {
            @Override  // androidx.room.L
            public void createAllTables(a a0) {
                u0.w("CREATE TABLE IF NOT EXISTS `MUSIC` (`track_id` TEXT NOT NULL, `song_id` INTEGER NOT NULL, `title` TEXT NOT NULL, `data` TEXT NOT NULL, `album` TEXT NOT NULL, `album_id` TEXT NOT NULL, `artist` TEXT NOT NULL, `artist_id` TEXT NOT NULL, `duration` INTEGER NOT NULL, `is_adult` INTEGER NOT NULL, `origin` INTEGER NOT NULL, `menu_id` TEXT NOT NULL, `origin_menu_id` TEXT NOT NULL, `has_mv` INTEGER NOT NULL, `mv_name` TEXT NOT NULL, `mv_id` TEXT NOT NULL, `c_type` TEXT NOT NULL, `play_count` INTEGER NOT NULL, `is_free` INTEGER NOT NULL, `is_hit_song` INTEGER NOT NULL, `is_holdback` INTEGER NOT NULL, `is_title` INTEGER NOT NULL, `create_at` INTEGER NOT NULL, `create_seq` INTEGER NOT NULL, `album_img_path` TEXT NOT NULL, `album_thumb_path` TEXT NOT NULL, `display_order` INTEGER NOT NULL, `stats_elements` TEXT NOT NULL, `uri_string` TEXT NOT NULL, `display_name` TEXT NOT NULL, PRIMARY KEY(`track_id`))", a0);
                u0.w("CREATE UNIQUE INDEX IF NOT EXISTS `index_MUSIC_track_id` ON `MUSIC` (`track_id`)", a0);
                u0.w("CREATE TABLE IF NOT EXISTS `EDU` (`track_id` TEXT NOT NULL, `song_id` INTEGER NOT NULL, `title` TEXT NOT NULL, `data` TEXT NOT NULL, `album` TEXT NOT NULL, `album_id` TEXT NOT NULL, `artist` TEXT NOT NULL, `artist_id` TEXT NOT NULL, `duration` INTEGER NOT NULL, `is_adult` INTEGER NOT NULL, `origin` INTEGER NOT NULL, `menu_id` TEXT NOT NULL, `origin_menu_id` TEXT NOT NULL, `has_mv` INTEGER NOT NULL, `mv_name` TEXT NOT NULL, `mv_id` TEXT NOT NULL, `c_type` TEXT NOT NULL, `play_count` INTEGER NOT NULL, `is_free` INTEGER NOT NULL, `is_hit_song` INTEGER NOT NULL, `is_holdback` INTEGER NOT NULL, `is_title` INTEGER NOT NULL, `create_at` INTEGER NOT NULL, `create_seq` INTEGER NOT NULL, `album_img_path` TEXT NOT NULL, `album_thumb_path` TEXT NOT NULL, `display_order` INTEGER NOT NULL, `stats_elements` TEXT NOT NULL, `uri_string` TEXT NOT NULL, `display_name` TEXT NOT NULL, PRIMARY KEY(`track_id`))", a0);
                u0.w("CREATE UNIQUE INDEX IF NOT EXISTS `index_EDU_track_id` ON `EDU` (`track_id`)", a0);
                u0.w("CREATE TABLE IF NOT EXISTS `SMART` (`track_id` TEXT NOT NULL, `song_id` INTEGER NOT NULL, `title` TEXT NOT NULL, `data` TEXT NOT NULL, `album` TEXT NOT NULL, `album_id` TEXT NOT NULL, `artist` TEXT NOT NULL, `artist_id` TEXT NOT NULL, `duration` INTEGER NOT NULL, `is_adult` INTEGER NOT NULL, `origin` INTEGER NOT NULL, `menu_id` TEXT NOT NULL, `origin_menu_id` TEXT NOT NULL, `has_mv` INTEGER NOT NULL, `mv_name` TEXT NOT NULL, `mv_id` TEXT NOT NULL, `c_type` TEXT NOT NULL, `play_count` INTEGER NOT NULL, `is_free` INTEGER NOT NULL, `is_hit_song` INTEGER NOT NULL, `is_holdback` INTEGER NOT NULL, `is_title` INTEGER NOT NULL, `create_at` INTEGER NOT NULL, `create_seq` INTEGER NOT NULL, `album_img_path` TEXT NOT NULL, `album_thumb_path` TEXT NOT NULL, `display_order` INTEGER NOT NULL, `stats_elements` TEXT NOT NULL, `uri_string` TEXT NOT NULL, `display_name` TEXT NOT NULL, PRIMARY KEY(`track_id`))", a0);
                u0.w("CREATE UNIQUE INDEX IF NOT EXISTS `index_SMART_track_id` ON `SMART` (`track_id`)", a0);
                u0.w("CREATE TABLE IF NOT EXISTS `MIXUP` (`track_id` TEXT NOT NULL, `song_id` INTEGER NOT NULL, `title` TEXT NOT NULL, `data` TEXT NOT NULL, `album` TEXT NOT NULL, `album_id` TEXT NOT NULL, `artist` TEXT NOT NULL, `artist_id` TEXT NOT NULL, `duration` INTEGER NOT NULL, `is_adult` INTEGER NOT NULL, `origin` INTEGER NOT NULL, `menu_id` TEXT NOT NULL, `origin_menu_id` TEXT NOT NULL, `has_mv` INTEGER NOT NULL, `mv_name` TEXT NOT NULL, `mv_id` TEXT NOT NULL, `c_type` TEXT NOT NULL, `play_count` INTEGER NOT NULL, `is_free` INTEGER NOT NULL, `is_hit_song` INTEGER NOT NULL, `is_holdback` INTEGER NOT NULL, `is_title` INTEGER NOT NULL, `create_at` INTEGER NOT NULL, `create_seq` INTEGER NOT NULL, `album_img_path` TEXT NOT NULL, `album_thumb_path` TEXT NOT NULL, `display_order` INTEGER NOT NULL, `stats_elements` TEXT NOT NULL, `uri_string` TEXT NOT NULL, `display_name` TEXT NOT NULL, PRIMARY KEY(`track_id`))", a0);
                u0.w("CREATE UNIQUE INDEX IF NOT EXISTS `index_MIXUP_track_id` ON `MIXUP` (`track_id`)", a0);
                u0.w("CREATE TABLE IF NOT EXISTS `MIXUP_WAITING_BACK` (`track_id` TEXT NOT NULL, `song_id` INTEGER NOT NULL, `title` TEXT NOT NULL, `data` TEXT NOT NULL, `album` TEXT NOT NULL, `album_id` TEXT NOT NULL, `artist` TEXT NOT NULL, `artist_id` TEXT NOT NULL, `duration` INTEGER NOT NULL, `is_adult` INTEGER NOT NULL, `origin` INTEGER NOT NULL, `menu_id` TEXT NOT NULL, `origin_menu_id` TEXT NOT NULL, `has_mv` INTEGER NOT NULL, `mv_name` TEXT NOT NULL, `mv_id` TEXT NOT NULL, `c_type` TEXT NOT NULL, `play_count` INTEGER NOT NULL, `is_free` INTEGER NOT NULL, `is_hit_song` INTEGER NOT NULL, `is_holdback` INTEGER NOT NULL, `is_title` INTEGER NOT NULL, `create_at` INTEGER NOT NULL, `create_seq` INTEGER NOT NULL, `album_img_path` TEXT NOT NULL, `album_thumb_path` TEXT NOT NULL, `display_order` INTEGER NOT NULL, `stats_elements` TEXT NOT NULL, `uri_string` TEXT NOT NULL, `display_name` TEXT NOT NULL, PRIMARY KEY(`track_id`))", a0);
                u0.w("CREATE UNIQUE INDEX IF NOT EXISTS `index_MIXUP_WAITING_BACK_create_at_create_seq` ON `MIXUP_WAITING_BACK` (`create_at`, `create_seq`)", a0);
                u0.w("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)", a0);
                u0.w("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \'ae6701eb42368d36ed7448809ed0f3c1\')", a0);
            }

            @Override  // androidx.room.L
            public void dropAllTables(a a0) {
                u0.w("DROP TABLE IF EXISTS `MUSIC`", a0);
                u0.w("DROP TABLE IF EXISTS `EDU`", a0);
                u0.w("DROP TABLE IF EXISTS `SMART`", a0);
                u0.w("DROP TABLE IF EXISTS `MIXUP`", a0);
                u0.w("DROP TABLE IF EXISTS `MIXUP_WAITING_BACK`", a0);
            }

            @Override  // androidx.room.L
            public void onCreate(a a0) {
            }

            @Override  // androidx.room.L
            public void onOpen(a a0) {
                PlaylistDatabase_Impl.this.internalInitInvalidationTracker(a0);
            }

            @Override  // androidx.room.L
            public void onPostMigrate(a a0) {
            }

            @Override  // androidx.room.L
            public void onPreMigrate(a a0) {
                w.q(a0);
            }

            @Override  // androidx.room.L
            public K onValidateSchema(a a0) {
                HashMap hashMap0 = new HashMap(30);
                hashMap0.put("track_id", new o(1, "track_id", "TEXT", null, true, 1));
                hashMap0.put("song_id", new o(0, "song_id", "INTEGER", null, true, 1));
                hashMap0.put("title", new o(0, "title", "TEXT", null, true, 1));
                hashMap0.put("data", new o(0, "data", "TEXT", null, true, 1));
                hashMap0.put("album", new o(0, "album", "TEXT", null, true, 1));
                hashMap0.put("album_id", new o(0, "album_id", "TEXT", null, true, 1));
                hashMap0.put("artist", new o(0, "artist", "TEXT", null, true, 1));
                hashMap0.put("artist_id", new o(0, "artist_id", "TEXT", null, true, 1));
                hashMap0.put("duration", new o(0, "duration", "INTEGER", null, true, 1));
                hashMap0.put("is_adult", new o(0, "is_adult", "INTEGER", null, true, 1));
                hashMap0.put("origin", new o(0, "origin", "INTEGER", null, true, 1));
                hashMap0.put("menu_id", new o(0, "menu_id", "TEXT", null, true, 1));
                hashMap0.put("origin_menu_id", new o(0, "origin_menu_id", "TEXT", null, true, 1));
                hashMap0.put("has_mv", new o(0, "has_mv", "INTEGER", null, true, 1));
                hashMap0.put("mv_name", new o(0, "mv_name", "TEXT", null, true, 1));
                hashMap0.put("mv_id", new o(0, "mv_id", "TEXT", null, true, 1));
                hashMap0.put("c_type", new o(0, "c_type", "TEXT", null, true, 1));
                hashMap0.put("play_count", new o(0, "play_count", "INTEGER", null, true, 1));
                hashMap0.put("is_free", new o(0, "is_free", "INTEGER", null, true, 1));
                hashMap0.put("is_hit_song", new o(0, "is_hit_song", "INTEGER", null, true, 1));
                hashMap0.put("is_holdback", new o(0, "is_holdback", "INTEGER", null, true, 1));
                hashMap0.put("is_title", new o(0, "is_title", "INTEGER", null, true, 1));
                hashMap0.put("create_at", new o(0, "create_at", "INTEGER", null, true, 1));
                hashMap0.put("create_seq", new o(0, "create_seq", "INTEGER", null, true, 1));
                hashMap0.put("album_img_path", new o(0, "album_img_path", "TEXT", null, true, 1));
                hashMap0.put("album_thumb_path", new o(0, "album_thumb_path", "TEXT", null, true, 1));
                hashMap0.put("display_order", new o(0, "display_order", "INTEGER", null, true, 1));
                hashMap0.put("stats_elements", new o(0, "stats_elements", "TEXT", null, true, 1));
                hashMap0.put("uri_string", new o(0, "uri_string", "TEXT", null, true, 1));
                HashSet hashSet0 = x.q(hashMap0, "display_name", new o(0, "display_name", "TEXT", null, true, 1), 0);
                HashSet hashSet1 = new HashSet(1);
                hashSet1.add(new q("index_MUSIC_track_id", true, Arrays.asList(new String[]{"track_id"}), Arrays.asList(new String[]{"ASC"})));
                r r0 = new r("MUSIC", hashMap0, hashSet0, hashSet1);
                r r1 = b.N("MUSIC", a0);
                if(!r0.equals(r1)) {
                    return new K(false, "MUSIC(com.iloen.melon.playback.playlist.db.entity.MusicEntity).\n Expected:\n" + r0 + "\n Found:\n" + r1);
                }
                HashMap hashMap1 = new HashMap(30);
                hashMap1.put("track_id", new o(1, "track_id", "TEXT", null, true, 1));
                hashMap1.put("song_id", new o(0, "song_id", "INTEGER", null, true, 1));
                hashMap1.put("title", new o(0, "title", "TEXT", null, true, 1));
                hashMap1.put("data", new o(0, "data", "TEXT", null, true, 1));
                hashMap1.put("album", new o(0, "album", "TEXT", null, true, 1));
                hashMap1.put("album_id", new o(0, "album_id", "TEXT", null, true, 1));
                hashMap1.put("artist", new o(0, "artist", "TEXT", null, true, 1));
                hashMap1.put("artist_id", new o(0, "artist_id", "TEXT", null, true, 1));
                hashMap1.put("duration", new o(0, "duration", "INTEGER", null, true, 1));
                hashMap1.put("is_adult", new o(0, "is_adult", "INTEGER", null, true, 1));
                hashMap1.put("origin", new o(0, "origin", "INTEGER", null, true, 1));
                hashMap1.put("menu_id", new o(0, "menu_id", "TEXT", null, true, 1));
                hashMap1.put("origin_menu_id", new o(0, "origin_menu_id", "TEXT", null, true, 1));
                hashMap1.put("has_mv", new o(0, "has_mv", "INTEGER", null, true, 1));
                hashMap1.put("mv_name", new o(0, "mv_name", "TEXT", null, true, 1));
                hashMap1.put("mv_id", new o(0, "mv_id", "TEXT", null, true, 1));
                hashMap1.put("c_type", new o(0, "c_type", "TEXT", null, true, 1));
                hashMap1.put("play_count", new o(0, "play_count", "INTEGER", null, true, 1));
                hashMap1.put("is_free", new o(0, "is_free", "INTEGER", null, true, 1));
                hashMap1.put("is_hit_song", new o(0, "is_hit_song", "INTEGER", null, true, 1));
                hashMap1.put("is_holdback", new o(0, "is_holdback", "INTEGER", null, true, 1));
                hashMap1.put("is_title", new o(0, "is_title", "INTEGER", null, true, 1));
                hashMap1.put("create_at", new o(0, "create_at", "INTEGER", null, true, 1));
                hashMap1.put("create_seq", new o(0, "create_seq", "INTEGER", null, true, 1));
                hashMap1.put("album_img_path", new o(0, "album_img_path", "TEXT", null, true, 1));
                hashMap1.put("album_thumb_path", new o(0, "album_thumb_path", "TEXT", null, true, 1));
                hashMap1.put("display_order", new o(0, "display_order", "INTEGER", null, true, 1));
                hashMap1.put("stats_elements", new o(0, "stats_elements", "TEXT", null, true, 1));
                hashMap1.put("uri_string", new o(0, "uri_string", "TEXT", null, true, 1));
                HashSet hashSet2 = x.q(hashMap1, "display_name", new o(0, "display_name", "TEXT", null, true, 1), 0);
                HashSet hashSet3 = new HashSet(1);
                hashSet3.add(new q("index_EDU_track_id", true, Arrays.asList(new String[]{"track_id"}), Arrays.asList(new String[]{"ASC"})));
                r r2 = new r("EDU", hashMap1, hashSet2, hashSet3);
                r r3 = b.N("EDU", a0);
                if(!r2.equals(r3)) {
                    return new K(false, "EDU(com.iloen.melon.playback.playlist.db.entity.EduEntity).\n Expected:\n" + r2 + "\n Found:\n" + r3);
                }
                HashMap hashMap2 = new HashMap(30);
                hashMap2.put("track_id", new o(1, "track_id", "TEXT", null, true, 1));
                hashMap2.put("song_id", new o(0, "song_id", "INTEGER", null, true, 1));
                hashMap2.put("title", new o(0, "title", "TEXT", null, true, 1));
                hashMap2.put("data", new o(0, "data", "TEXT", null, true, 1));
                hashMap2.put("album", new o(0, "album", "TEXT", null, true, 1));
                hashMap2.put("album_id", new o(0, "album_id", "TEXT", null, true, 1));
                hashMap2.put("artist", new o(0, "artist", "TEXT", null, true, 1));
                hashMap2.put("artist_id", new o(0, "artist_id", "TEXT", null, true, 1));
                hashMap2.put("duration", new o(0, "duration", "INTEGER", null, true, 1));
                hashMap2.put("is_adult", new o(0, "is_adult", "INTEGER", null, true, 1));
                hashMap2.put("origin", new o(0, "origin", "INTEGER", null, true, 1));
                hashMap2.put("menu_id", new o(0, "menu_id", "TEXT", null, true, 1));
                hashMap2.put("origin_menu_id", new o(0, "origin_menu_id", "TEXT", null, true, 1));
                hashMap2.put("has_mv", new o(0, "has_mv", "INTEGER", null, true, 1));
                hashMap2.put("mv_name", new o(0, "mv_name", "TEXT", null, true, 1));
                hashMap2.put("mv_id", new o(0, "mv_id", "TEXT", null, true, 1));
                hashMap2.put("c_type", new o(0, "c_type", "TEXT", null, true, 1));
                hashMap2.put("play_count", new o(0, "play_count", "INTEGER", null, true, 1));
                hashMap2.put("is_free", new o(0, "is_free", "INTEGER", null, true, 1));
                hashMap2.put("is_hit_song", new o(0, "is_hit_song", "INTEGER", null, true, 1));
                hashMap2.put("is_holdback", new o(0, "is_holdback", "INTEGER", null, true, 1));
                hashMap2.put("is_title", new o(0, "is_title", "INTEGER", null, true, 1));
                hashMap2.put("create_at", new o(0, "create_at", "INTEGER", null, true, 1));
                hashMap2.put("create_seq", new o(0, "create_seq", "INTEGER", null, true, 1));
                hashMap2.put("album_img_path", new o(0, "album_img_path", "TEXT", null, true, 1));
                hashMap2.put("album_thumb_path", new o(0, "album_thumb_path", "TEXT", null, true, 1));
                hashMap2.put("display_order", new o(0, "display_order", "INTEGER", null, true, 1));
                hashMap2.put("stats_elements", new o(0, "stats_elements", "TEXT", null, true, 1));
                hashMap2.put("uri_string", new o(0, "uri_string", "TEXT", null, true, 1));
                HashSet hashSet4 = x.q(hashMap2, "display_name", new o(0, "display_name", "TEXT", null, true, 1), 0);
                HashSet hashSet5 = new HashSet(1);
                hashSet5.add(new q("index_SMART_track_id", true, Arrays.asList(new String[]{"track_id"}), Arrays.asList(new String[]{"ASC"})));
                r r4 = new r("SMART", hashMap2, hashSet4, hashSet5);
                r r5 = b.N("SMART", a0);
                if(!r4.equals(r5)) {
                    return new K(false, "SMART(com.iloen.melon.playback.playlist.db.entity.SmartEntity).\n Expected:\n" + r4 + "\n Found:\n" + r5);
                }
                HashMap hashMap3 = new HashMap(30);
                hashMap3.put("track_id", new o(1, "track_id", "TEXT", null, true, 1));
                hashMap3.put("song_id", new o(0, "song_id", "INTEGER", null, true, 1));
                hashMap3.put("title", new o(0, "title", "TEXT", null, true, 1));
                hashMap3.put("data", new o(0, "data", "TEXT", null, true, 1));
                hashMap3.put("album", new o(0, "album", "TEXT", null, true, 1));
                hashMap3.put("album_id", new o(0, "album_id", "TEXT", null, true, 1));
                hashMap3.put("artist", new o(0, "artist", "TEXT", null, true, 1));
                hashMap3.put("artist_id", new o(0, "artist_id", "TEXT", null, true, 1));
                hashMap3.put("duration", new o(0, "duration", "INTEGER", null, true, 1));
                hashMap3.put("is_adult", new o(0, "is_adult", "INTEGER", null, true, 1));
                hashMap3.put("origin", new o(0, "origin", "INTEGER", null, true, 1));
                hashMap3.put("menu_id", new o(0, "menu_id", "TEXT", null, true, 1));
                hashMap3.put("origin_menu_id", new o(0, "origin_menu_id", "TEXT", null, true, 1));
                hashMap3.put("has_mv", new o(0, "has_mv", "INTEGER", null, true, 1));
                hashMap3.put("mv_name", new o(0, "mv_name", "TEXT", null, true, 1));
                hashMap3.put("mv_id", new o(0, "mv_id", "TEXT", null, true, 1));
                hashMap3.put("c_type", new o(0, "c_type", "TEXT", null, true, 1));
                hashMap3.put("play_count", new o(0, "play_count", "INTEGER", null, true, 1));
                hashMap3.put("is_free", new o(0, "is_free", "INTEGER", null, true, 1));
                hashMap3.put("is_hit_song", new o(0, "is_hit_song", "INTEGER", null, true, 1));
                hashMap3.put("is_holdback", new o(0, "is_holdback", "INTEGER", null, true, 1));
                hashMap3.put("is_title", new o(0, "is_title", "INTEGER", null, true, 1));
                hashMap3.put("create_at", new o(0, "create_at", "INTEGER", null, true, 1));
                hashMap3.put("create_seq", new o(0, "create_seq", "INTEGER", null, true, 1));
                hashMap3.put("album_img_path", new o(0, "album_img_path", "TEXT", null, true, 1));
                hashMap3.put("album_thumb_path", new o(0, "album_thumb_path", "TEXT", null, true, 1));
                hashMap3.put("display_order", new o(0, "display_order", "INTEGER", null, true, 1));
                hashMap3.put("stats_elements", new o(0, "stats_elements", "TEXT", null, true, 1));
                hashMap3.put("uri_string", new o(0, "uri_string", "TEXT", null, true, 1));
                HashSet hashSet6 = x.q(hashMap3, "display_name", new o(0, "display_name", "TEXT", null, true, 1), 0);
                HashSet hashSet7 = new HashSet(1);
                hashSet7.add(new q("index_MIXUP_track_id", true, Arrays.asList(new String[]{"track_id"}), Arrays.asList(new String[]{"ASC"})));
                r r6 = new r("MIXUP", hashMap3, hashSet6, hashSet7);
                r r7 = b.N("MIXUP", a0);
                if(!r6.equals(r7)) {
                    return new K(false, "MIXUP(com.iloen.melon.playback.playlist.db.entity.MixUpEntity).\n Expected:\n" + r6 + "\n Found:\n" + r7);
                }
                HashMap hashMap4 = new HashMap(30);
                hashMap4.put("track_id", new o(1, "track_id", "TEXT", null, true, 1));
                hashMap4.put("song_id", new o(0, "song_id", "INTEGER", null, true, 1));
                hashMap4.put("title", new o(0, "title", "TEXT", null, true, 1));
                hashMap4.put("data", new o(0, "data", "TEXT", null, true, 1));
                hashMap4.put("album", new o(0, "album", "TEXT", null, true, 1));
                hashMap4.put("album_id", new o(0, "album_id", "TEXT", null, true, 1));
                hashMap4.put("artist", new o(0, "artist", "TEXT", null, true, 1));
                hashMap4.put("artist_id", new o(0, "artist_id", "TEXT", null, true, 1));
                hashMap4.put("duration", new o(0, "duration", "INTEGER", null, true, 1));
                hashMap4.put("is_adult", new o(0, "is_adult", "INTEGER", null, true, 1));
                hashMap4.put("origin", new o(0, "origin", "INTEGER", null, true, 1));
                hashMap4.put("menu_id", new o(0, "menu_id", "TEXT", null, true, 1));
                hashMap4.put("origin_menu_id", new o(0, "origin_menu_id", "TEXT", null, true, 1));
                hashMap4.put("has_mv", new o(0, "has_mv", "INTEGER", null, true, 1));
                hashMap4.put("mv_name", new o(0, "mv_name", "TEXT", null, true, 1));
                hashMap4.put("mv_id", new o(0, "mv_id", "TEXT", null, true, 1));
                hashMap4.put("c_type", new o(0, "c_type", "TEXT", null, true, 1));
                hashMap4.put("play_count", new o(0, "play_count", "INTEGER", null, true, 1));
                hashMap4.put("is_free", new o(0, "is_free", "INTEGER", null, true, 1));
                hashMap4.put("is_hit_song", new o(0, "is_hit_song", "INTEGER", null, true, 1));
                hashMap4.put("is_holdback", new o(0, "is_holdback", "INTEGER", null, true, 1));
                hashMap4.put("is_title", new o(0, "is_title", "INTEGER", null, true, 1));
                hashMap4.put("create_at", new o(0, "create_at", "INTEGER", null, true, 1));
                hashMap4.put("create_seq", new o(0, "create_seq", "INTEGER", null, true, 1));
                hashMap4.put("album_img_path", new o(0, "album_img_path", "TEXT", null, true, 1));
                hashMap4.put("album_thumb_path", new o(0, "album_thumb_path", "TEXT", null, true, 1));
                hashMap4.put("display_order", new o(0, "display_order", "INTEGER", null, true, 1));
                hashMap4.put("stats_elements", new o(0, "stats_elements", "TEXT", null, true, 1));
                hashMap4.put("uri_string", new o(0, "uri_string", "TEXT", null, true, 1));
                HashSet hashSet8 = x.q(hashMap4, "display_name", new o(0, "display_name", "TEXT", null, true, 1), 0);
                HashSet hashSet9 = new HashSet(1);
                hashSet9.add(new q("index_MIXUP_WAITING_BACK_create_at_create_seq", true, Arrays.asList(new String[]{"create_at", "create_seq"}), Arrays.asList(new String[]{"ASC", "ASC"})));
                r r8 = new r("MIXUP_WAITING_BACK", hashMap4, hashSet8, hashSet9);
                r r9 = b.N("MIXUP_WAITING_BACK", a0);
                return r8.equals(r9) ? new K(true, null) : new K(false, "MIXUP_WAITING_BACK(com.iloen.melon.playback.playlist.db.entity.MixUpWaitingBackEntity).\n Expected:\n" + r8 + "\n Found:\n" + r9);
            }
        };
    }

    @Override  // androidx.room.H
    public M createOpenDelegate() {
        return this.createOpenDelegate();
    }

    @Override  // androidx.room.H
    public List getAutoMigrations(Map map0) {
        List list0 = new ArrayList();
        ((ArrayList)list0).add(new PlaylistDatabase_AutoMigration_1_2_Impl());
        ((ArrayList)list0).add(new PlaylistDatabase_AutoMigration_2_3_Impl());
        return list0;
    }

    @Override  // androidx.room.H
    public Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override  // androidx.room.H
    public Map getRequiredTypeConverters() {
        Map map0 = new HashMap();
        ((HashMap)map0).put(PlaylistDao.class, PlaylistDao_Impl.getRequiredConverters());
        return map0;
    }

    @Override  // com.iloen.melon.playback.playlist.db.PlaylistDatabase
    public PlaylistDao playlistDao() {
        if(this._playlistDao != null) {
            return this._playlistDao;
        }
        synchronized(this) {
            if(this._playlistDao == null) {
                this._playlistDao = new PlaylistDao_Impl(this);
            }
            return this._playlistDao;
        }
    }
}

