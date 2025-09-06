package com.iloen.melon.playback.playlist.db;

import B4.a;
import h7.u0;

final class PlaylistDatabase_AutoMigration_2_3_Impl extends a {
    public PlaylistDatabase_AutoMigration_2_3_Impl() {
        super(2, 3);
    }

    @Override  // B4.a
    public void migrate(G4.a a0) {
        u0.w("CREATE TABLE IF NOT EXISTS `MIXUP_WAITING_BACK` (`track_id` TEXT NOT NULL, `song_id` INTEGER NOT NULL, `title` TEXT NOT NULL, `data` TEXT NOT NULL, `album` TEXT NOT NULL, `album_id` TEXT NOT NULL, `artist` TEXT NOT NULL, `artist_id` TEXT NOT NULL, `duration` INTEGER NOT NULL, `is_adult` INTEGER NOT NULL, `origin` INTEGER NOT NULL, `menu_id` TEXT NOT NULL, `origin_menu_id` TEXT NOT NULL, `has_mv` INTEGER NOT NULL, `mv_name` TEXT NOT NULL, `mv_id` TEXT NOT NULL, `c_type` TEXT NOT NULL, `play_count` INTEGER NOT NULL, `is_free` INTEGER NOT NULL, `is_hit_song` INTEGER NOT NULL, `is_holdback` INTEGER NOT NULL, `is_title` INTEGER NOT NULL, `create_at` INTEGER NOT NULL, `create_seq` INTEGER NOT NULL, `album_img_path` TEXT NOT NULL, `album_thumb_path` TEXT NOT NULL, `display_order` INTEGER NOT NULL, `stats_elements` TEXT NOT NULL, `uri_string` TEXT NOT NULL, `display_name` TEXT NOT NULL, PRIMARY KEY(`track_id`))", a0);
        u0.w("CREATE UNIQUE INDEX IF NOT EXISTS `index_MIXUP_WAITING_BACK_create_at_create_seq` ON `MIXUP_WAITING_BACK` (`create_at`, `create_seq`)", a0);
    }
}

