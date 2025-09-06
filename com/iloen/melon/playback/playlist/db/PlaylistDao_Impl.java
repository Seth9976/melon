package com.iloen.melon.playback.playlist.db;

import Bd.m;
import E9.w;
import G4.a;
import U4.F;
import Vb.p0;
import androidx.room.H;
import androidx.room.c;
import androidx.room.d;
import com.iloen.melon.fragments.artistchannel.viewholder.f;
import com.iloen.melon.playback.playlist.db.entity.EduEntity;
import com.iloen.melon.playback.playlist.db.entity.MixUpEntity;
import com.iloen.melon.playback.playlist.db.entity.MixUpWaitingBackEntity;
import com.iloen.melon.playback.playlist.db.entity.MusicEntity;
import com.iloen.melon.playback.playlist.db.entity.PlayableEntity;
import com.iloen.melon.playback.playlist.db.entity.SmartEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.coroutines.Continuation;

public final class PlaylistDao_Impl implements PlaylistDao {
    private final H __db;
    private final c __deleteAdapterOfMixUpWaitingBackEntity;
    private final d __insertAdapterOfEduEntity;
    private final d __insertAdapterOfEduEntity_1;
    private final d __insertAdapterOfMixUpEntity;
    private final d __insertAdapterOfMixUpWaitingBackEntity;
    private final d __insertAdapterOfMusicEntity;
    private final d __insertAdapterOfMusicEntity_1;
    private final d __insertAdapterOfSmartEntity;
    private final c __updateAdapterOfEduEntity;
    private final c __updateAdapterOfEduEntity_1;
    private final c __updateAdapterOfMixUpEntity;
    private final c __updateAdapterOfMusicEntity;
    private final c __updateAdapterOfSmartEntity;

    public PlaylistDao_Impl(H h0) {
        this.__db = h0;
        this.__insertAdapterOfMusicEntity = new d() {
            public void bind(G4.c c0, MusicEntity musicEntity0) {
                c0.e(1, musicEntity0.getTrackId());
                PlayableEntity playableEntity0 = musicEntity0.getPlayableEntity();
                c0.a(2, ((long)playableEntity0.getSongId()));
                c0.e(3, playableEntity0.getTitle());
                c0.e(4, playableEntity0.getData());
                c0.e(5, playableEntity0.getAlbum());
                c0.e(6, playableEntity0.getAlbumId());
                c0.e(7, playableEntity0.getArtist());
                c0.e(8, playableEntity0.getArtistId());
                c0.a(9, playableEntity0.getDuration());
                c0.a(10, ((long)playableEntity0.isAdult()));
                c0.a(11, ((long)playableEntity0.getOrigin()));
                c0.e(12, playableEntity0.getMenuId());
                c0.e(13, playableEntity0.getOriginMenuId());
                c0.a(14, ((long)playableEntity0.getHasMv()));
                c0.e(15, playableEntity0.getMvName());
                c0.e(16, playableEntity0.getMvId());
                c0.e(17, playableEntity0.getCType());
                c0.a(18, ((long)playableEntity0.getPlayCount()));
                c0.a(19, ((long)playableEntity0.isFree()));
                c0.a(20, ((long)playableEntity0.isHitSong()));
                c0.a(21, ((long)playableEntity0.isHoldBack()));
                c0.a(22, ((long)playableEntity0.isTitle()));
                c0.a(23, playableEntity0.getCreatedAt());
                c0.a(24, ((long)playableEntity0.getCreatedSeq()));
                c0.e(25, playableEntity0.getAlbumImgPath());
                c0.e(26, playableEntity0.getAlbumThumbPath());
                c0.a(27, ((long)playableEntity0.getDisplayOrder()));
                c0.e(28, playableEntity0.getStatsElements());
                c0.e(29, playableEntity0.getUriString());
                c0.e(30, playableEntity0.getDisplayName());
            }

            @Override  // androidx.room.d
            public void bind(G4.c c0, Object object0) {
                this.bind(c0, ((MusicEntity)object0));
            }

            @Override  // androidx.room.d
            public String createQuery() {
                return "INSERT OR REPLACE INTO `MUSIC` (`track_id`,`song_id`,`title`,`data`,`album`,`album_id`,`artist`,`artist_id`,`duration`,`is_adult`,`origin`,`menu_id`,`origin_menu_id`,`has_mv`,`mv_name`,`mv_id`,`c_type`,`play_count`,`is_free`,`is_hit_song`,`is_holdback`,`is_title`,`create_at`,`create_seq`,`album_img_path`,`album_thumb_path`,`display_order`,`stats_elements`,`uri_string`,`display_name`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }
        };
        this.__insertAdapterOfMusicEntity_1 = new d() {
            public void bind(G4.c c0, MusicEntity musicEntity0) {
                c0.e(1, musicEntity0.getTrackId());
                PlayableEntity playableEntity0 = musicEntity0.getPlayableEntity();
                c0.a(2, ((long)playableEntity0.getSongId()));
                c0.e(3, playableEntity0.getTitle());
                c0.e(4, playableEntity0.getData());
                c0.e(5, playableEntity0.getAlbum());
                c0.e(6, playableEntity0.getAlbumId());
                c0.e(7, playableEntity0.getArtist());
                c0.e(8, playableEntity0.getArtistId());
                c0.a(9, playableEntity0.getDuration());
                c0.a(10, ((long)playableEntity0.isAdult()));
                c0.a(11, ((long)playableEntity0.getOrigin()));
                c0.e(12, playableEntity0.getMenuId());
                c0.e(13, playableEntity0.getOriginMenuId());
                c0.a(14, ((long)playableEntity0.getHasMv()));
                c0.e(15, playableEntity0.getMvName());
                c0.e(16, playableEntity0.getMvId());
                c0.e(17, playableEntity0.getCType());
                c0.a(18, ((long)playableEntity0.getPlayCount()));
                c0.a(19, ((long)playableEntity0.isFree()));
                c0.a(20, ((long)playableEntity0.isHitSong()));
                c0.a(21, ((long)playableEntity0.isHoldBack()));
                c0.a(22, ((long)playableEntity0.isTitle()));
                c0.a(23, playableEntity0.getCreatedAt());
                c0.a(24, ((long)playableEntity0.getCreatedSeq()));
                c0.e(25, playableEntity0.getAlbumImgPath());
                c0.e(26, playableEntity0.getAlbumThumbPath());
                c0.a(27, ((long)playableEntity0.getDisplayOrder()));
                c0.e(28, playableEntity0.getStatsElements());
                c0.e(29, playableEntity0.getUriString());
                c0.e(30, playableEntity0.getDisplayName());
            }

            @Override  // androidx.room.d
            public void bind(G4.c c0, Object object0) {
                this.bind(c0, ((MusicEntity)object0));
            }

            @Override  // androidx.room.d
            public String createQuery() {
                return "INSERT OR ABORT INTO `MUSIC` (`track_id`,`song_id`,`title`,`data`,`album`,`album_id`,`artist`,`artist_id`,`duration`,`is_adult`,`origin`,`menu_id`,`origin_menu_id`,`has_mv`,`mv_name`,`mv_id`,`c_type`,`play_count`,`is_free`,`is_hit_song`,`is_holdback`,`is_title`,`create_at`,`create_seq`,`album_img_path`,`album_thumb_path`,`display_order`,`stats_elements`,`uri_string`,`display_name`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }
        };
        this.__insertAdapterOfEduEntity = new d() {
            public void bind(G4.c c0, EduEntity eduEntity0) {
                c0.e(1, eduEntity0.getTrackId());
                PlayableEntity playableEntity0 = eduEntity0.getPlayableEntity();
                c0.a(2, ((long)playableEntity0.getSongId()));
                c0.e(3, playableEntity0.getTitle());
                c0.e(4, playableEntity0.getData());
                c0.e(5, playableEntity0.getAlbum());
                c0.e(6, playableEntity0.getAlbumId());
                c0.e(7, playableEntity0.getArtist());
                c0.e(8, playableEntity0.getArtistId());
                c0.a(9, playableEntity0.getDuration());
                c0.a(10, ((long)playableEntity0.isAdult()));
                c0.a(11, ((long)playableEntity0.getOrigin()));
                c0.e(12, playableEntity0.getMenuId());
                c0.e(13, playableEntity0.getOriginMenuId());
                c0.a(14, ((long)playableEntity0.getHasMv()));
                c0.e(15, playableEntity0.getMvName());
                c0.e(16, playableEntity0.getMvId());
                c0.e(17, playableEntity0.getCType());
                c0.a(18, ((long)playableEntity0.getPlayCount()));
                c0.a(19, ((long)playableEntity0.isFree()));
                c0.a(20, ((long)playableEntity0.isHitSong()));
                c0.a(21, ((long)playableEntity0.isHoldBack()));
                c0.a(22, ((long)playableEntity0.isTitle()));
                c0.a(23, playableEntity0.getCreatedAt());
                c0.a(24, ((long)playableEntity0.getCreatedSeq()));
                c0.e(25, playableEntity0.getAlbumImgPath());
                c0.e(26, playableEntity0.getAlbumThumbPath());
                c0.a(27, ((long)playableEntity0.getDisplayOrder()));
                c0.e(28, playableEntity0.getStatsElements());
                c0.e(29, playableEntity0.getUriString());
                c0.e(30, playableEntity0.getDisplayName());
            }

            @Override  // androidx.room.d
            public void bind(G4.c c0, Object object0) {
                this.bind(c0, ((EduEntity)object0));
            }

            @Override  // androidx.room.d
            public String createQuery() {
                return "INSERT OR REPLACE INTO `EDU` (`track_id`,`song_id`,`title`,`data`,`album`,`album_id`,`artist`,`artist_id`,`duration`,`is_adult`,`origin`,`menu_id`,`origin_menu_id`,`has_mv`,`mv_name`,`mv_id`,`c_type`,`play_count`,`is_free`,`is_hit_song`,`is_holdback`,`is_title`,`create_at`,`create_seq`,`album_img_path`,`album_thumb_path`,`display_order`,`stats_elements`,`uri_string`,`display_name`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }
        };
        this.__insertAdapterOfEduEntity_1 = new d() {
            public void bind(G4.c c0, EduEntity eduEntity0) {
                c0.e(1, eduEntity0.getTrackId());
                PlayableEntity playableEntity0 = eduEntity0.getPlayableEntity();
                c0.a(2, ((long)playableEntity0.getSongId()));
                c0.e(3, playableEntity0.getTitle());
                c0.e(4, playableEntity0.getData());
                c0.e(5, playableEntity0.getAlbum());
                c0.e(6, playableEntity0.getAlbumId());
                c0.e(7, playableEntity0.getArtist());
                c0.e(8, playableEntity0.getArtistId());
                c0.a(9, playableEntity0.getDuration());
                c0.a(10, ((long)playableEntity0.isAdult()));
                c0.a(11, ((long)playableEntity0.getOrigin()));
                c0.e(12, playableEntity0.getMenuId());
                c0.e(13, playableEntity0.getOriginMenuId());
                c0.a(14, ((long)playableEntity0.getHasMv()));
                c0.e(15, playableEntity0.getMvName());
                c0.e(16, playableEntity0.getMvId());
                c0.e(17, playableEntity0.getCType());
                c0.a(18, ((long)playableEntity0.getPlayCount()));
                c0.a(19, ((long)playableEntity0.isFree()));
                c0.a(20, ((long)playableEntity0.isHitSong()));
                c0.a(21, ((long)playableEntity0.isHoldBack()));
                c0.a(22, ((long)playableEntity0.isTitle()));
                c0.a(23, playableEntity0.getCreatedAt());
                c0.a(24, ((long)playableEntity0.getCreatedSeq()));
                c0.e(25, playableEntity0.getAlbumImgPath());
                c0.e(26, playableEntity0.getAlbumThumbPath());
                c0.a(27, ((long)playableEntity0.getDisplayOrder()));
                c0.e(28, playableEntity0.getStatsElements());
                c0.e(29, playableEntity0.getUriString());
                c0.e(30, playableEntity0.getDisplayName());
            }

            @Override  // androidx.room.d
            public void bind(G4.c c0, Object object0) {
                this.bind(c0, ((EduEntity)object0));
            }

            @Override  // androidx.room.d
            public String createQuery() {
                return "INSERT OR ABORT INTO `EDU` (`track_id`,`song_id`,`title`,`data`,`album`,`album_id`,`artist`,`artist_id`,`duration`,`is_adult`,`origin`,`menu_id`,`origin_menu_id`,`has_mv`,`mv_name`,`mv_id`,`c_type`,`play_count`,`is_free`,`is_hit_song`,`is_holdback`,`is_title`,`create_at`,`create_seq`,`album_img_path`,`album_thumb_path`,`display_order`,`stats_elements`,`uri_string`,`display_name`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }
        };
        this.__insertAdapterOfSmartEntity = new d() {
            public void bind(G4.c c0, SmartEntity smartEntity0) {
                c0.e(1, smartEntity0.getTrackId());
                PlayableEntity playableEntity0 = smartEntity0.getPlayableEntity();
                c0.a(2, ((long)playableEntity0.getSongId()));
                c0.e(3, playableEntity0.getTitle());
                c0.e(4, playableEntity0.getData());
                c0.e(5, playableEntity0.getAlbum());
                c0.e(6, playableEntity0.getAlbumId());
                c0.e(7, playableEntity0.getArtist());
                c0.e(8, playableEntity0.getArtistId());
                c0.a(9, playableEntity0.getDuration());
                c0.a(10, ((long)playableEntity0.isAdult()));
                c0.a(11, ((long)playableEntity0.getOrigin()));
                c0.e(12, playableEntity0.getMenuId());
                c0.e(13, playableEntity0.getOriginMenuId());
                c0.a(14, ((long)playableEntity0.getHasMv()));
                c0.e(15, playableEntity0.getMvName());
                c0.e(16, playableEntity0.getMvId());
                c0.e(17, playableEntity0.getCType());
                c0.a(18, ((long)playableEntity0.getPlayCount()));
                c0.a(19, ((long)playableEntity0.isFree()));
                c0.a(20, ((long)playableEntity0.isHitSong()));
                c0.a(21, ((long)playableEntity0.isHoldBack()));
                c0.a(22, ((long)playableEntity0.isTitle()));
                c0.a(23, playableEntity0.getCreatedAt());
                c0.a(24, ((long)playableEntity0.getCreatedSeq()));
                c0.e(25, playableEntity0.getAlbumImgPath());
                c0.e(26, playableEntity0.getAlbumThumbPath());
                c0.a(27, ((long)playableEntity0.getDisplayOrder()));
                c0.e(28, playableEntity0.getStatsElements());
                c0.e(29, playableEntity0.getUriString());
                c0.e(30, playableEntity0.getDisplayName());
            }

            @Override  // androidx.room.d
            public void bind(G4.c c0, Object object0) {
                this.bind(c0, ((SmartEntity)object0));
            }

            @Override  // androidx.room.d
            public String createQuery() {
                return "INSERT OR REPLACE INTO `SMART` (`track_id`,`song_id`,`title`,`data`,`album`,`album_id`,`artist`,`artist_id`,`duration`,`is_adult`,`origin`,`menu_id`,`origin_menu_id`,`has_mv`,`mv_name`,`mv_id`,`c_type`,`play_count`,`is_free`,`is_hit_song`,`is_holdback`,`is_title`,`create_at`,`create_seq`,`album_img_path`,`album_thumb_path`,`display_order`,`stats_elements`,`uri_string`,`display_name`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }
        };
        this.__insertAdapterOfMixUpEntity = new d() {
            public void bind(G4.c c0, MixUpEntity mixUpEntity0) {
                c0.e(1, mixUpEntity0.getTrackId());
                PlayableEntity playableEntity0 = mixUpEntity0.getPlayableEntity();
                c0.a(2, ((long)playableEntity0.getSongId()));
                c0.e(3, playableEntity0.getTitle());
                c0.e(4, playableEntity0.getData());
                c0.e(5, playableEntity0.getAlbum());
                c0.e(6, playableEntity0.getAlbumId());
                c0.e(7, playableEntity0.getArtist());
                c0.e(8, playableEntity0.getArtistId());
                c0.a(9, playableEntity0.getDuration());
                c0.a(10, ((long)playableEntity0.isAdult()));
                c0.a(11, ((long)playableEntity0.getOrigin()));
                c0.e(12, playableEntity0.getMenuId());
                c0.e(13, playableEntity0.getOriginMenuId());
                c0.a(14, ((long)playableEntity0.getHasMv()));
                c0.e(15, playableEntity0.getMvName());
                c0.e(16, playableEntity0.getMvId());
                c0.e(17, playableEntity0.getCType());
                c0.a(18, ((long)playableEntity0.getPlayCount()));
                c0.a(19, ((long)playableEntity0.isFree()));
                c0.a(20, ((long)playableEntity0.isHitSong()));
                c0.a(21, ((long)playableEntity0.isHoldBack()));
                c0.a(22, ((long)playableEntity0.isTitle()));
                c0.a(23, playableEntity0.getCreatedAt());
                c0.a(24, ((long)playableEntity0.getCreatedSeq()));
                c0.e(25, playableEntity0.getAlbumImgPath());
                c0.e(26, playableEntity0.getAlbumThumbPath());
                c0.a(27, ((long)playableEntity0.getDisplayOrder()));
                c0.e(28, playableEntity0.getStatsElements());
                c0.e(29, playableEntity0.getUriString());
                c0.e(30, playableEntity0.getDisplayName());
            }

            @Override  // androidx.room.d
            public void bind(G4.c c0, Object object0) {
                this.bind(c0, ((MixUpEntity)object0));
            }

            @Override  // androidx.room.d
            public String createQuery() {
                return "INSERT OR REPLACE INTO `MIXUP` (`track_id`,`song_id`,`title`,`data`,`album`,`album_id`,`artist`,`artist_id`,`duration`,`is_adult`,`origin`,`menu_id`,`origin_menu_id`,`has_mv`,`mv_name`,`mv_id`,`c_type`,`play_count`,`is_free`,`is_hit_song`,`is_holdback`,`is_title`,`create_at`,`create_seq`,`album_img_path`,`album_thumb_path`,`display_order`,`stats_elements`,`uri_string`,`display_name`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }
        };
        this.__insertAdapterOfMixUpWaitingBackEntity = new d() {
            public void bind(G4.c c0, MixUpWaitingBackEntity mixUpWaitingBackEntity0) {
                c0.e(1, mixUpWaitingBackEntity0.getTrackId());
                PlayableEntity playableEntity0 = mixUpWaitingBackEntity0.getPlayableEntity();
                c0.a(2, ((long)playableEntity0.getSongId()));
                c0.e(3, playableEntity0.getTitle());
                c0.e(4, playableEntity0.getData());
                c0.e(5, playableEntity0.getAlbum());
                c0.e(6, playableEntity0.getAlbumId());
                c0.e(7, playableEntity0.getArtist());
                c0.e(8, playableEntity0.getArtistId());
                c0.a(9, playableEntity0.getDuration());
                c0.a(10, ((long)playableEntity0.isAdult()));
                c0.a(11, ((long)playableEntity0.getOrigin()));
                c0.e(12, playableEntity0.getMenuId());
                c0.e(13, playableEntity0.getOriginMenuId());
                c0.a(14, ((long)playableEntity0.getHasMv()));
                c0.e(15, playableEntity0.getMvName());
                c0.e(16, playableEntity0.getMvId());
                c0.e(17, playableEntity0.getCType());
                c0.a(18, ((long)playableEntity0.getPlayCount()));
                c0.a(19, ((long)playableEntity0.isFree()));
                c0.a(20, ((long)playableEntity0.isHitSong()));
                c0.a(21, ((long)playableEntity0.isHoldBack()));
                c0.a(22, ((long)playableEntity0.isTitle()));
                c0.a(23, playableEntity0.getCreatedAt());
                c0.a(24, ((long)playableEntity0.getCreatedSeq()));
                c0.e(25, playableEntity0.getAlbumImgPath());
                c0.e(26, playableEntity0.getAlbumThumbPath());
                c0.a(27, ((long)playableEntity0.getDisplayOrder()));
                c0.e(28, playableEntity0.getStatsElements());
                c0.e(29, playableEntity0.getUriString());
                c0.e(30, playableEntity0.getDisplayName());
            }

            @Override  // androidx.room.d
            public void bind(G4.c c0, Object object0) {
                this.bind(c0, ((MixUpWaitingBackEntity)object0));
            }

            @Override  // androidx.room.d
            public String createQuery() {
                return "INSERT OR REPLACE INTO `MIXUP_WAITING_BACK` (`track_id`,`song_id`,`title`,`data`,`album`,`album_id`,`artist`,`artist_id`,`duration`,`is_adult`,`origin`,`menu_id`,`origin_menu_id`,`has_mv`,`mv_name`,`mv_id`,`c_type`,`play_count`,`is_free`,`is_hit_song`,`is_holdback`,`is_title`,`create_at`,`create_seq`,`album_img_path`,`album_thumb_path`,`display_order`,`stats_elements`,`uri_string`,`display_name`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }
        };
        this.__deleteAdapterOfMixUpWaitingBackEntity = new c() {
            public void bind(G4.c c0, MixUpWaitingBackEntity mixUpWaitingBackEntity0) {
                c0.e(1, mixUpWaitingBackEntity0.getTrackId());
            }

            @Override  // androidx.room.c
            public void bind(G4.c c0, Object object0) {
                this.bind(c0, ((MixUpWaitingBackEntity)object0));
            }

            @Override  // androidx.room.c
            public String createQuery() {
                return "DELETE FROM `MIXUP_WAITING_BACK` WHERE `track_id` = ?";
            }
        };
        this.__updateAdapterOfMusicEntity = new c() {
            public void bind(G4.c c0, MusicEntity musicEntity0) {
                c0.e(1, musicEntity0.getTrackId());
                PlayableEntity playableEntity0 = musicEntity0.getPlayableEntity();
                c0.a(2, ((long)playableEntity0.getSongId()));
                c0.e(3, playableEntity0.getTitle());
                c0.e(4, playableEntity0.getData());
                c0.e(5, playableEntity0.getAlbum());
                c0.e(6, playableEntity0.getAlbumId());
                c0.e(7, playableEntity0.getArtist());
                c0.e(8, playableEntity0.getArtistId());
                c0.a(9, playableEntity0.getDuration());
                c0.a(10, ((long)playableEntity0.isAdult()));
                c0.a(11, ((long)playableEntity0.getOrigin()));
                c0.e(12, playableEntity0.getMenuId());
                c0.e(13, playableEntity0.getOriginMenuId());
                c0.a(14, ((long)playableEntity0.getHasMv()));
                c0.e(15, playableEntity0.getMvName());
                c0.e(16, playableEntity0.getMvId());
                c0.e(17, playableEntity0.getCType());
                c0.a(18, ((long)playableEntity0.getPlayCount()));
                c0.a(19, ((long)playableEntity0.isFree()));
                c0.a(20, ((long)playableEntity0.isHitSong()));
                c0.a(21, ((long)playableEntity0.isHoldBack()));
                c0.a(22, ((long)playableEntity0.isTitle()));
                c0.a(23, playableEntity0.getCreatedAt());
                c0.a(24, ((long)playableEntity0.getCreatedSeq()));
                c0.e(25, playableEntity0.getAlbumImgPath());
                c0.e(26, playableEntity0.getAlbumThumbPath());
                c0.a(27, ((long)playableEntity0.getDisplayOrder()));
                c0.e(28, playableEntity0.getStatsElements());
                c0.e(29, playableEntity0.getUriString());
                c0.e(30, playableEntity0.getDisplayName());
                c0.e(0x1F, musicEntity0.getTrackId());
            }

            @Override  // androidx.room.c
            public void bind(G4.c c0, Object object0) {
                this.bind(c0, ((MusicEntity)object0));
            }

            @Override  // androidx.room.c
            public String createQuery() {
                return "UPDATE OR IGNORE `MUSIC` SET `track_id` = ?,`song_id` = ?,`title` = ?,`data` = ?,`album` = ?,`album_id` = ?,`artist` = ?,`artist_id` = ?,`duration` = ?,`is_adult` = ?,`origin` = ?,`menu_id` = ?,`origin_menu_id` = ?,`has_mv` = ?,`mv_name` = ?,`mv_id` = ?,`c_type` = ?,`play_count` = ?,`is_free` = ?,`is_hit_song` = ?,`is_holdback` = ?,`is_title` = ?,`create_at` = ?,`create_seq` = ?,`album_img_path` = ?,`album_thumb_path` = ?,`display_order` = ?,`stats_elements` = ?,`uri_string` = ?,`display_name` = ? WHERE `track_id` = ?";
            }
        };
        this.__updateAdapterOfEduEntity = new c() {
            public void bind(G4.c c0, EduEntity eduEntity0) {
                c0.e(1, eduEntity0.getTrackId());
                PlayableEntity playableEntity0 = eduEntity0.getPlayableEntity();
                c0.a(2, ((long)playableEntity0.getSongId()));
                c0.e(3, playableEntity0.getTitle());
                c0.e(4, playableEntity0.getData());
                c0.e(5, playableEntity0.getAlbum());
                c0.e(6, playableEntity0.getAlbumId());
                c0.e(7, playableEntity0.getArtist());
                c0.e(8, playableEntity0.getArtistId());
                c0.a(9, playableEntity0.getDuration());
                c0.a(10, ((long)playableEntity0.isAdult()));
                c0.a(11, ((long)playableEntity0.getOrigin()));
                c0.e(12, playableEntity0.getMenuId());
                c0.e(13, playableEntity0.getOriginMenuId());
                c0.a(14, ((long)playableEntity0.getHasMv()));
                c0.e(15, playableEntity0.getMvName());
                c0.e(16, playableEntity0.getMvId());
                c0.e(17, playableEntity0.getCType());
                c0.a(18, ((long)playableEntity0.getPlayCount()));
                c0.a(19, ((long)playableEntity0.isFree()));
                c0.a(20, ((long)playableEntity0.isHitSong()));
                c0.a(21, ((long)playableEntity0.isHoldBack()));
                c0.a(22, ((long)playableEntity0.isTitle()));
                c0.a(23, playableEntity0.getCreatedAt());
                c0.a(24, ((long)playableEntity0.getCreatedSeq()));
                c0.e(25, playableEntity0.getAlbumImgPath());
                c0.e(26, playableEntity0.getAlbumThumbPath());
                c0.a(27, ((long)playableEntity0.getDisplayOrder()));
                c0.e(28, playableEntity0.getStatsElements());
                c0.e(29, playableEntity0.getUriString());
                c0.e(30, playableEntity0.getDisplayName());
                c0.e(0x1F, eduEntity0.getTrackId());
            }

            @Override  // androidx.room.c
            public void bind(G4.c c0, Object object0) {
                this.bind(c0, ((EduEntity)object0));
            }

            @Override  // androidx.room.c
            public String createQuery() {
                return "UPDATE OR IGNORE `EDU` SET `track_id` = ?,`song_id` = ?,`title` = ?,`data` = ?,`album` = ?,`album_id` = ?,`artist` = ?,`artist_id` = ?,`duration` = ?,`is_adult` = ?,`origin` = ?,`menu_id` = ?,`origin_menu_id` = ?,`has_mv` = ?,`mv_name` = ?,`mv_id` = ?,`c_type` = ?,`play_count` = ?,`is_free` = ?,`is_hit_song` = ?,`is_holdback` = ?,`is_title` = ?,`create_at` = ?,`create_seq` = ?,`album_img_path` = ?,`album_thumb_path` = ?,`display_order` = ?,`stats_elements` = ?,`uri_string` = ?,`display_name` = ? WHERE `track_id` = ?";
            }
        };
        this.__updateAdapterOfEduEntity_1 = new c() {
            public void bind(G4.c c0, EduEntity eduEntity0) {
                c0.e(1, eduEntity0.getTrackId());
                PlayableEntity playableEntity0 = eduEntity0.getPlayableEntity();
                c0.a(2, ((long)playableEntity0.getSongId()));
                c0.e(3, playableEntity0.getTitle());
                c0.e(4, playableEntity0.getData());
                c0.e(5, playableEntity0.getAlbum());
                c0.e(6, playableEntity0.getAlbumId());
                c0.e(7, playableEntity0.getArtist());
                c0.e(8, playableEntity0.getArtistId());
                c0.a(9, playableEntity0.getDuration());
                c0.a(10, ((long)playableEntity0.isAdult()));
                c0.a(11, ((long)playableEntity0.getOrigin()));
                c0.e(12, playableEntity0.getMenuId());
                c0.e(13, playableEntity0.getOriginMenuId());
                c0.a(14, ((long)playableEntity0.getHasMv()));
                c0.e(15, playableEntity0.getMvName());
                c0.e(16, playableEntity0.getMvId());
                c0.e(17, playableEntity0.getCType());
                c0.a(18, ((long)playableEntity0.getPlayCount()));
                c0.a(19, ((long)playableEntity0.isFree()));
                c0.a(20, ((long)playableEntity0.isHitSong()));
                c0.a(21, ((long)playableEntity0.isHoldBack()));
                c0.a(22, ((long)playableEntity0.isTitle()));
                c0.a(23, playableEntity0.getCreatedAt());
                c0.a(24, ((long)playableEntity0.getCreatedSeq()));
                c0.e(25, playableEntity0.getAlbumImgPath());
                c0.e(26, playableEntity0.getAlbumThumbPath());
                c0.a(27, ((long)playableEntity0.getDisplayOrder()));
                c0.e(28, playableEntity0.getStatsElements());
                c0.e(29, playableEntity0.getUriString());
                c0.e(30, playableEntity0.getDisplayName());
                c0.e(0x1F, eduEntity0.getTrackId());
            }

            @Override  // androidx.room.c
            public void bind(G4.c c0, Object object0) {
                this.bind(c0, ((EduEntity)object0));
            }

            @Override  // androidx.room.c
            public String createQuery() {
                return "UPDATE OR ABORT `EDU` SET `track_id` = ?,`song_id` = ?,`title` = ?,`data` = ?,`album` = ?,`album_id` = ?,`artist` = ?,`artist_id` = ?,`duration` = ?,`is_adult` = ?,`origin` = ?,`menu_id` = ?,`origin_menu_id` = ?,`has_mv` = ?,`mv_name` = ?,`mv_id` = ?,`c_type` = ?,`play_count` = ?,`is_free` = ?,`is_hit_song` = ?,`is_holdback` = ?,`is_title` = ?,`create_at` = ?,`create_seq` = ?,`album_img_path` = ?,`album_thumb_path` = ?,`display_order` = ?,`stats_elements` = ?,`uri_string` = ?,`display_name` = ? WHERE `track_id` = ?";
            }
        };
        this.__updateAdapterOfSmartEntity = new c() {
            public void bind(G4.c c0, SmartEntity smartEntity0) {
                c0.e(1, smartEntity0.getTrackId());
                PlayableEntity playableEntity0 = smartEntity0.getPlayableEntity();
                c0.a(2, ((long)playableEntity0.getSongId()));
                c0.e(3, playableEntity0.getTitle());
                c0.e(4, playableEntity0.getData());
                c0.e(5, playableEntity0.getAlbum());
                c0.e(6, playableEntity0.getAlbumId());
                c0.e(7, playableEntity0.getArtist());
                c0.e(8, playableEntity0.getArtistId());
                c0.a(9, playableEntity0.getDuration());
                c0.a(10, ((long)playableEntity0.isAdult()));
                c0.a(11, ((long)playableEntity0.getOrigin()));
                c0.e(12, playableEntity0.getMenuId());
                c0.e(13, playableEntity0.getOriginMenuId());
                c0.a(14, ((long)playableEntity0.getHasMv()));
                c0.e(15, playableEntity0.getMvName());
                c0.e(16, playableEntity0.getMvId());
                c0.e(17, playableEntity0.getCType());
                c0.a(18, ((long)playableEntity0.getPlayCount()));
                c0.a(19, ((long)playableEntity0.isFree()));
                c0.a(20, ((long)playableEntity0.isHitSong()));
                c0.a(21, ((long)playableEntity0.isHoldBack()));
                c0.a(22, ((long)playableEntity0.isTitle()));
                c0.a(23, playableEntity0.getCreatedAt());
                c0.a(24, ((long)playableEntity0.getCreatedSeq()));
                c0.e(25, playableEntity0.getAlbumImgPath());
                c0.e(26, playableEntity0.getAlbumThumbPath());
                c0.a(27, ((long)playableEntity0.getDisplayOrder()));
                c0.e(28, playableEntity0.getStatsElements());
                c0.e(29, playableEntity0.getUriString());
                c0.e(30, playableEntity0.getDisplayName());
                c0.e(0x1F, smartEntity0.getTrackId());
            }

            @Override  // androidx.room.c
            public void bind(G4.c c0, Object object0) {
                this.bind(c0, ((SmartEntity)object0));
            }

            @Override  // androidx.room.c
            public String createQuery() {
                return "UPDATE OR IGNORE `SMART` SET `track_id` = ?,`song_id` = ?,`title` = ?,`data` = ?,`album` = ?,`album_id` = ?,`artist` = ?,`artist_id` = ?,`duration` = ?,`is_adult` = ?,`origin` = ?,`menu_id` = ?,`origin_menu_id` = ?,`has_mv` = ?,`mv_name` = ?,`mv_id` = ?,`c_type` = ?,`play_count` = ?,`is_free` = ?,`is_hit_song` = ?,`is_holdback` = ?,`is_title` = ?,`create_at` = ?,`create_seq` = ?,`album_img_path` = ?,`album_thumb_path` = ?,`display_order` = ?,`stats_elements` = ?,`uri_string` = ?,`display_name` = ? WHERE `track_id` = ?";
            }
        };
        this.__updateAdapterOfMixUpEntity = new c() {
            public void bind(G4.c c0, MixUpEntity mixUpEntity0) {
                c0.e(1, mixUpEntity0.getTrackId());
                PlayableEntity playableEntity0 = mixUpEntity0.getPlayableEntity();
                c0.a(2, ((long)playableEntity0.getSongId()));
                c0.e(3, playableEntity0.getTitle());
                c0.e(4, playableEntity0.getData());
                c0.e(5, playableEntity0.getAlbum());
                c0.e(6, playableEntity0.getAlbumId());
                c0.e(7, playableEntity0.getArtist());
                c0.e(8, playableEntity0.getArtistId());
                c0.a(9, playableEntity0.getDuration());
                c0.a(10, ((long)playableEntity0.isAdult()));
                c0.a(11, ((long)playableEntity0.getOrigin()));
                c0.e(12, playableEntity0.getMenuId());
                c0.e(13, playableEntity0.getOriginMenuId());
                c0.a(14, ((long)playableEntity0.getHasMv()));
                c0.e(15, playableEntity0.getMvName());
                c0.e(16, playableEntity0.getMvId());
                c0.e(17, playableEntity0.getCType());
                c0.a(18, ((long)playableEntity0.getPlayCount()));
                c0.a(19, ((long)playableEntity0.isFree()));
                c0.a(20, ((long)playableEntity0.isHitSong()));
                c0.a(21, ((long)playableEntity0.isHoldBack()));
                c0.a(22, ((long)playableEntity0.isTitle()));
                c0.a(23, playableEntity0.getCreatedAt());
                c0.a(24, ((long)playableEntity0.getCreatedSeq()));
                c0.e(25, playableEntity0.getAlbumImgPath());
                c0.e(26, playableEntity0.getAlbumThumbPath());
                c0.a(27, ((long)playableEntity0.getDisplayOrder()));
                c0.e(28, playableEntity0.getStatsElements());
                c0.e(29, playableEntity0.getUriString());
                c0.e(30, playableEntity0.getDisplayName());
                c0.e(0x1F, mixUpEntity0.getTrackId());
            }

            @Override  // androidx.room.c
            public void bind(G4.c c0, Object object0) {
                this.bind(c0, ((MixUpEntity)object0));
            }

            @Override  // androidx.room.c
            public String createQuery() {
                return "UPDATE OR IGNORE `MIXUP` SET `track_id` = ?,`song_id` = ?,`title` = ?,`data` = ?,`album` = ?,`album_id` = ?,`artist` = ?,`artist_id` = ?,`duration` = ?,`is_adult` = ?,`origin` = ?,`menu_id` = ?,`origin_menu_id` = ?,`has_mv` = ?,`mv_name` = ?,`mv_id` = ?,`c_type` = ?,`play_count` = ?,`is_free` = ?,`is_hit_song` = ?,`is_holdback` = ?,`is_title` = ?,`create_at` = ?,`create_seq` = ?,`album_img_path` = ?,`album_thumb_path` = ?,`display_order` = ?,`stats_elements` = ?,`uri_string` = ?,`display_name` = ? WHERE `track_id` = ?";
            }
        };
    }

    public static ie.H A(a a0) {
        return PlaylistDao_Impl.lambda$deleteAllEdu$46(a0);
    }

    public static ie.H B(a a0) {
        return PlaylistDao_Impl.lambda$deleteAllSmartEntities$50(a0);
    }

    public static ie.H C(PlaylistDao_Impl playlistDao_Impl0, List list0, a a0) {
        return playlistDao_Impl0.lambda$insertMixUpEntities$5(list0, a0);
    }

    public static Object D(PlaylistDao_Impl playlistDao_Impl0, List list0, List list1, Continuation continuation0) {
        return playlistDao_Impl0.lambda$insertMusicsAndUpdateOrderInTransaction$13(list0, list1, continuation0);
    }

    public static Object E(PlaylistDao_Impl playlistDao_Impl0, List list0, List list1, Continuation continuation0) {
        return playlistDao_Impl0.lambda$insertMixUpEntitiesAndUpdateOrder$28(list0, list1, continuation0);
    }

    public static Object F(PlaylistDao_Impl playlistDao_Impl0, List list0, Continuation continuation0) {
        return playlistDao_Impl0.lambda$updateDisPlayOrderEduList$19(list0, continuation0);
    }

    public static ie.H G(PlaylistDao_Impl playlistDao_Impl0, List list0, a a0) {
        return playlistDao_Impl0.lambda$insertAllMusic$0(list0, a0);
    }

    public static List J(a a0) {
        return PlaylistDao_Impl.lambda$getAllOrdered$40(a0);
    }

    public static Object L(PlaylistDao_Impl playlistDao_Impl0, List list0, List list1, Continuation continuation0) {
        return playlistDao_Impl0.lambda$insertSmartEntitiesAndUpdateOrder$23(list0, list1, continuation0);
    }

    public static List N(a a0) {
        return PlaylistDao_Impl.lambda$getAllMusicPlaylist$35(a0);
    }

    public static Object O(PlaylistDao_Impl playlistDao_Impl0, List list0, Continuation continuation0) {
        return playlistDao_Impl0.lambda$clearAndInsertMixUpEntities$32(list0, continuation0);
    }

    public static ie.H P(PlaylistDao_Impl playlistDao_Impl0, List list0, a a0) {
        return playlistDao_Impl0.lambda$insert$6(list0, a0);
    }

    public static ie.H Q(PlaylistDao_Impl playlistDao_Impl0, List list0, a a0) {
        return playlistDao_Impl0.lambda$delete$7(list0, a0);
    }

    public static ie.H R(a a0) {
        return PlaylistDao_Impl.lambda$deleteAllEntitiesMixUp$53(a0);
    }

    public static Object S(PlaylistDao_Impl playlistDao_Impl0, List list0, List list1, List list2, Continuation continuation0) {
        return playlistDao_Impl0.lambda$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$26(list0, list1, list2, continuation0);
    }

    public static ie.H T(PlaylistDao_Impl playlistDao_Impl0, List list0, a a0) {
        return playlistDao_Impl0.lambda$insertSmartEntities$4(list0, a0);
    }

    public static Object U(PlaylistDao_Impl playlistDao_Impl0, List list0, List list1, List list2, Continuation continuation0) {
        return playlistDao_Impl0.lambda$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$31(list0, list1, list2, continuation0);
    }

    public static Integer V(PlaylistDao_Impl playlistDao_Impl0, List list0, a a0) {
        return playlistDao_Impl0.lambda$updateSmartEntities$11(list0, a0);
    }

    public static ie.H W(PlaylistDao_Impl playlistDao_Impl0, EduEntity eduEntity0, a a0) {
        return playlistDao_Impl0.lambda$insertEduEntity$3(eduEntity0, a0);
    }

    public static ie.H X(a a0) {
        return PlaylistDao_Impl.lambda$clear$54(a0);
    }

    public static Object Y(PlaylistDao_Impl playlistDao_Impl0, List list0, List list1, List list2, Continuation continuation0) {
        return playlistDao_Impl0.lambda$deleteAndInsertMusicsAndUpdateOrderInTransaction$16(list0, list1, list2, continuation0);
    }

    public static List Z(a a0) {
        return PlaylistDao_Impl.lambda$getAllMixUpEntities$38(a0);
    }

    public static ie.H a(PlaylistDao_Impl playlistDao_Impl0, List list0, a a0) {
        return playlistDao_Impl0.lambda$insertAllEdu$2(list0, a0);
    }

    public static Object a0(PlaylistDao_Impl playlistDao_Impl0, List list0, Continuation continuation0) {
        return playlistDao_Impl0.lambda$clearAndInsertMusicInTransaction$17(list0, continuation0);
    }

    public static Integer b(PlaylistDao_Impl playlistDao_Impl0, List list0, a a0) {
        return playlistDao_Impl0.lambda$updateMixUpEntities$12(list0, a0);
    }

    public static ie.H c(PlaylistDao_Impl playlistDao_Impl0, List list0, a a0) {
        return playlistDao_Impl0.lambda$updatedEduEntitys$9(list0, a0);
    }

    public static Object c0(PlaylistDao_Impl playlistDao_Impl0, List list0, Continuation continuation0) {
        return playlistDao_Impl0.lambda$updateOrdersSmart$24(list0, continuation0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MixUpWaitingBackDao
    public Object clear(Continuation continuation0) {
        f f0 = new f(13);
        return w.P(this.__db, continuation0, f0, false, true);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MixUpWaitingBackDao
    public Object clearAndInsert(List list0, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.a a0 = new com.iloen.melon.playback.playlist.db.a(this, list0, 19);
        return w.O(this.__db, continuation0, a0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.EduPlaylistDao
    public Object clearAndInsertEduInTransaction(List list0, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.a a0 = new com.iloen.melon.playback.playlist.db.a(this, list0, 10);
        return w.O(this.__db, continuation0, a0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MixUpPlaylistDao
    public Object clearAndInsertMixUpEntities(List list0, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.a a0 = new com.iloen.melon.playback.playlist.db.a(this, list0, 3);
        return w.O(this.__db, continuation0, a0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MusicPlaylistDao
    public Object clearAndInsertMusicInTransaction(List list0, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.a a0 = new com.iloen.melon.playback.playlist.db.a(this, list0, 12);
        return w.O(this.__db, continuation0, a0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.SmartPlaylistDao
    public Object clearAndInsertSmartEntities(List list0, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.a a0 = new com.iloen.melon.playback.playlist.db.a(this, list0, 5);
        return w.O(this.__db, continuation0, a0);
    }

    public static List d(a a0) {
        return PlaylistDao_Impl.lambda$getAllEduPlaylist$36(a0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MixUpWaitingBackDao
    public Object delete(List list0, Continuation continuation0) {
        list0.getClass();
        com.iloen.melon.playback.playlist.db.a a0 = new com.iloen.melon.playback.playlist.db.a(this, list0, 1);
        return w.P(this.__db, continuation0, a0, false, true);
    }

    @Override  // com.iloen.melon.playback.playlist.db.EduPlaylistDao
    public Object deleteAllEdu(Continuation continuation0) {
        f f0 = new f(19);
        return w.P(this.__db, continuation0, f0, false, true);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MixUpPlaylistDao
    public Object deleteAllEntitiesMixUp(Continuation continuation0) {
        f f0 = new f(22);
        return w.P(this.__db, continuation0, f0, false, true);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MusicPlaylistDao
    public Object deleteAllMusic(Continuation continuation0) {
        f f0 = new f(17);
        return w.P(this.__db, continuation0, f0, false, true);
    }

    @Override  // com.iloen.melon.playback.playlist.db.SmartPlaylistDao
    public Object deleteAllSmartEntities(Continuation continuation0) {
        f f0 = new f(12);
        return w.P(this.__db, continuation0, f0, false, true);
    }

    @Override  // com.iloen.melon.playback.playlist.db.EduPlaylistDao
    public Object deleteAndInsertEdusAndUpdateOrderInTransaction(List list0, List list1, List list2, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.c c0 = new com.iloen.melon.playback.playlist.db.c(this, list0, list1, list2, 1);
        return w.O(this.__db, continuation0, c0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MixUpPlaylistDao
    public Object deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp(List list0, List list1, List list2, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.c c0 = new com.iloen.melon.playback.playlist.db.c(this, list0, list1, list2, 3);
        return w.O(this.__db, continuation0, c0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MusicPlaylistDao
    public Object deleteAndInsertMusicsAndUpdateOrderInTransaction(List list0, List list1, List list2, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.c c0 = new com.iloen.melon.playback.playlist.db.c(this, list0, list1, list2, 0);
        return w.O(this.__db, continuation0, c0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.SmartPlaylistDao
    public Object deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction(List list0, List list1, List list2, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.c c0 = new com.iloen.melon.playback.playlist.db.c(this, list0, list1, list2, 2);
        return w.O(this.__db, continuation0, c0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.EduPlaylistDao
    public Object deleteEduList(List list0, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.a a0 = new com.iloen.melon.playback.playlist.db.a(this, list0, 20);
        return w.O(this.__db, continuation0, a0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MixUpPlaylistDao
    public Object deleteEntityByTrackIdMixUp(String s, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.d d0 = new com.iloen.melon.playback.playlist.db.d(s, 1);
        return w.P(this.__db, continuation0, d0, false, true);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MixUpPlaylistDao
    public Object deleteMixUpEntities(List list0, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.a a0 = new com.iloen.melon.playback.playlist.db.a(this, list0, 14);
        return w.O(this.__db, continuation0, a0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MusicPlaylistDao
    public Object deleteMusicList(List list0, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.a a0 = new com.iloen.melon.playback.playlist.db.a(this, list0, 7);
        return w.O(this.__db, continuation0, a0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.SmartPlaylistDao
    public Object deleteSmartEntities(List list0, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.a a0 = new com.iloen.melon.playback.playlist.db.a(this, list0, 0);
        return w.O(this.__db, continuation0, a0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.SmartPlaylistDao
    public Object deleteSmartEntityByTrackId(String s, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.d d0 = new com.iloen.melon.playback.playlist.db.d(s, 3);
        return w.P(this.__db, continuation0, d0, false, true);
    }

    @Override  // com.iloen.melon.playback.playlist.db.EduPlaylistDao
    public Object deleteTrackIdEdu(String s, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.d d0 = new com.iloen.melon.playback.playlist.db.d(s, 2);
        return w.P(this.__db, continuation0, d0, false, true);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MusicPlaylistDao
    public Object deleteTrackIdMusic(String s, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.d d0 = new com.iloen.melon.playback.playlist.db.d(s, 0);
        return w.P(this.__db, continuation0, d0, false, true);
    }

    public static Object e(PlaylistDao_Impl playlistDao_Impl0, List list0, Continuation continuation0) {
        return playlistDao_Impl0.lambda$deleteSmartEntities$25(list0, continuation0);
    }

    public static ie.H f(a a0) {
        return PlaylistDao_Impl.lambda$deleteAllMusic$44(a0);
    }

    public static Object g(PlaylistDao_Impl playlistDao_Impl0, List list0, Continuation continuation0) {
        return playlistDao_Impl0.lambda$updateOrdersMixUp$29(list0, continuation0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.EduPlaylistDao
    public List getAllEduPlaylist() {
        f f0 = new f(16);
        return (List)w.N(this.__db, true, false, f0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MixUpPlaylistDao
    public List getAllMixUpEntities() {
        f f0 = new f(21);
        return (List)w.N(this.__db, true, false, f0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MusicPlaylistDao
    public List getAllMusicPlaylist() {
        f f0 = new f(18);
        return (List)w.N(this.__db, true, false, f0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MixUpWaitingBackDao
    public Object getAllOrdered(Continuation continuation0) {
        f f0 = new f(14);
        return w.P(this.__db, continuation0, f0, true, false);
    }

    @Override  // com.iloen.melon.playback.playlist.db.SmartPlaylistDao
    public List getAllSmartEntities() {
        f f0 = new f(15);
        return (List)w.N(this.__db, true, false, f0);
    }

    public static List getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override  // com.iloen.melon.playback.playlist.db.MixUpWaitingBackDao
    public Object getSize(Continuation continuation0) {
        f f0 = new f(20);
        return w.P(this.__db, continuation0, f0, true, false);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MixUpWaitingBackDao
    public Object getTopN(int v, Continuation continuation0) {
        m m0 = new m(v, 4);
        return w.P(this.__db, continuation0, m0, true, false);
    }

    public static Object h(PlaylistDao_Impl playlistDao_Impl0, List list0, List list1, List list2, Continuation continuation0) {
        return playlistDao_Impl0.lambda$deleteAndInsertEdusAndUpdateOrderInTransaction$21(list0, list1, list2, continuation0);
    }

    public static Object i(PlaylistDao_Impl playlistDao_Impl0, List list0, Continuation continuation0) {
        return playlistDao_Impl0.lambda$deleteMusicList$15(list0, continuation0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MixUpWaitingBackDao
    public Object insert(List list0, Continuation continuation0) {
        list0.getClass();
        com.iloen.melon.playback.playlist.db.a a0 = new com.iloen.melon.playback.playlist.db.a(this, list0, 13);
        return w.P(this.__db, continuation0, a0, false, true);
    }

    @Override  // com.iloen.melon.playback.playlist.db.EduPlaylistDao
    public Object insertAllEdu(List list0, Continuation continuation0) {
        list0.getClass();
        com.iloen.melon.playback.playlist.db.a a0 = new com.iloen.melon.playback.playlist.db.a(this, list0, 17);
        return w.P(this.__db, continuation0, a0, false, true);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MusicPlaylistDao
    public Object insertAllMusic(List list0, Continuation continuation0) {
        list0.getClass();
        com.iloen.melon.playback.playlist.db.a a0 = new com.iloen.melon.playback.playlist.db.a(this, list0, 15);
        return w.P(this.__db, continuation0, a0, false, true);
    }

    @Override  // com.iloen.melon.playback.playlist.db.EduPlaylistDao
    public Object insertEduEntity(EduEntity eduEntity0, Continuation continuation0) {
        eduEntity0.getClass();
        e e0 = new e(this, eduEntity0, 0);
        return w.P(this.__db, continuation0, e0, false, true);
    }

    @Override  // com.iloen.melon.playback.playlist.db.EduPlaylistDao
    public Object insertEdusAndUpdateOrderInTransaction(List list0, List list1, Continuation continuation0) {
        b b0 = new b(this, list0, list1, 0);
        return w.O(this.__db, continuation0, b0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MixUpPlaylistDao
    public Object insertMixUpEntities(List list0, Continuation continuation0) {
        list0.getClass();
        com.iloen.melon.playback.playlist.db.a a0 = new com.iloen.melon.playback.playlist.db.a(this, list0, 8);
        return w.P(this.__db, continuation0, a0, false, true);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MixUpPlaylistDao
    public Object insertMixUpEntitiesAndUpdateOrder(List list0, List list1, Continuation continuation0) {
        b b0 = new b(this, list0, list1, 2);
        return w.O(this.__db, continuation0, b0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MusicPlaylistDao
    public Object insertMusicEntity(MusicEntity musicEntity0, Continuation continuation0) {
        musicEntity0.getClass();
        p0 p00 = new p0(10, this, musicEntity0);
        return w.P(this.__db, continuation0, p00, false, true);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MusicPlaylistDao
    public Object insertMusicsAndUpdateOrderInTransaction(List list0, List list1, Continuation continuation0) {
        b b0 = new b(this, list0, list1, 1);
        return w.O(this.__db, continuation0, b0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.SmartPlaylistDao
    public Object insertSmartEntities(List list0, Continuation continuation0) {
        list0.getClass();
        com.iloen.melon.playback.playlist.db.a a0 = new com.iloen.melon.playback.playlist.db.a(this, list0, 2);
        return w.P(this.__db, continuation0, a0, false, true);
    }

    @Override  // com.iloen.melon.playback.playlist.db.SmartPlaylistDao
    public Object insertSmartEntitiesAndUpdateOrder(List list0, List list1, Continuation continuation0) {
        b b0 = new b(this, list0, list1, 3);
        return w.O(this.__db, continuation0, b0);
    }

    public static ie.H j(PlaylistDao_Impl playlistDao_Impl0, EduEntity eduEntity0, a a0) {
        return playlistDao_Impl0.lambda$updateEduEntity$10(eduEntity0, a0);
    }

    public static ie.H k(String s, a a0) {
        return PlaylistDao_Impl.lambda$deleteEntityByTrackIdMixUp$52(s, a0);
    }

    public static Integer l(PlaylistDao_Impl playlistDao_Impl0, List list0, a a0) {
        return playlistDao_Impl0.lambda$updateMusicEntitys$8(list0, a0);
    }

    private static ie.H lambda$clear$54(a a0) {
        try(G4.c c0 = a0.l0("DELETE FROM MIXUP_WAITING_BACK")) {
            c0.j0();
            return ie.H.a;
        }
    }

    private Object lambda$clearAndInsert$33(List list0, Continuation continuation0) {
        return super.clearAndInsert(list0, continuation0);
    }

    private Object lambda$clearAndInsertEduInTransaction$22(List list0, Continuation continuation0) {
        return super.clearAndInsertEduInTransaction(list0, continuation0);
    }

    private Object lambda$clearAndInsertMixUpEntities$32(List list0, Continuation continuation0) {
        return super.clearAndInsertMixUpEntities(list0, continuation0);
    }

    private Object lambda$clearAndInsertMusicInTransaction$17(List list0, Continuation continuation0) {
        return super.clearAndInsertMusicInTransaction(list0, continuation0);
    }

    private Object lambda$clearAndInsertSmartEntities$27(List list0, Continuation continuation0) {
        return super.clearAndInsertSmartEntities(list0, continuation0);
    }

    private ie.H lambda$delete$7(List list0, a a0) {
        this.__deleteAdapterOfMixUpWaitingBackEntity.handleMultiple(a0, list0);
        return ie.H.a;
    }

    private static ie.H lambda$deleteAllEdu$46(a a0) {
        try(G4.c c0 = a0.l0("DELETE FROM EDU")) {
            c0.j0();
            return ie.H.a;
        }
    }

    private static ie.H lambda$deleteAllEntitiesMixUp$53(a a0) {
        try(G4.c c0 = a0.l0("DELETE FROM MIXUP")) {
            c0.j0();
            return ie.H.a;
        }
    }

    private static ie.H lambda$deleteAllMusic$44(a a0) {
        try(G4.c c0 = a0.l0("DELETE FROM MUSIC")) {
            c0.j0();
            return ie.H.a;
        }
    }

    private static ie.H lambda$deleteAllSmartEntities$50(a a0) {
        try(G4.c c0 = a0.l0("DELETE FROM SMART")) {
            c0.j0();
            return ie.H.a;
        }
    }

    private Object lambda$deleteAndInsertEdusAndUpdateOrderInTransaction$21(List list0, List list1, List list2, Continuation continuation0) {
        return super.deleteAndInsertEdusAndUpdateOrderInTransaction(list0, list1, list2, continuation0);
    }

    private Object lambda$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$31(List list0, List list1, List list2, Continuation continuation0) {
        return super.deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp(list0, list1, list2, continuation0);
    }

    private Object lambda$deleteAndInsertMusicsAndUpdateOrderInTransaction$16(List list0, List list1, List list2, Continuation continuation0) {
        return super.deleteAndInsertMusicsAndUpdateOrderInTransaction(list0, list1, list2, continuation0);
    }

    private Object lambda$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$26(List list0, List list1, List list2, Continuation continuation0) {
        return super.deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction(list0, list1, list2, continuation0);
    }

    private Object lambda$deleteEduList$20(List list0, Continuation continuation0) {
        return super.deleteEduList(list0, continuation0);
    }

    private static ie.H lambda$deleteEntityByTrackIdMixUp$52(String s, a a0) {
        try(G4.c c0 = a0.l0("DELETE FROM MIXUP WHERE track_id = ?")) {
            c0.e(1, s);
            c0.j0();
            return ie.H.a;
        }
    }

    private Object lambda$deleteMixUpEntities$30(List list0, Continuation continuation0) {
        return super.deleteMixUpEntities(list0, continuation0);
    }

    private Object lambda$deleteMusicList$15(List list0, Continuation continuation0) {
        return super.deleteMusicList(list0, continuation0);
    }

    private Object lambda$deleteSmartEntities$25(List list0, Continuation continuation0) {
        return super.deleteSmartEntities(list0, continuation0);
    }

    private static ie.H lambda$deleteSmartEntityByTrackId$49(String s, a a0) {
        try(G4.c c0 = a0.l0("DELETE FROM SMART WHERE track_id = ?")) {
            c0.e(1, s);
            c0.j0();
            return ie.H.a;
        }
    }

    private static ie.H lambda$deleteTrackIdEdu$47(String s, a a0) {
        try(G4.c c0 = a0.l0("DELETE FROM EDU WHERE track_id = ?")) {
            c0.e(1, s);
            c0.j0();
            return ie.H.a;
        }
    }

    private static ie.H lambda$deleteTrackIdMusic$43(String s, a a0) {
        try(G4.c c0 = a0.l0("DELETE FROM MUSIC WHERE track_id = ?")) {
            c0.e(1, s);
            c0.j0();
            return ie.H.a;
        }
    }

    private static List lambda$getAllEduPlaylist$36(a a0) {
        boolean z5;
        boolean z4;
        boolean z3;
        boolean z2;
        boolean z1;
        boolean z;
        try(G4.c c0 = a0.l0("SELECT * FROM EDU")) {
            int v = F.v(c0, "track_id");
            int v1 = F.v(c0, "song_id");
            int v2 = F.v(c0, "title");
            int v3 = F.v(c0, "data");
            int v4 = F.v(c0, "album");
            int v5 = F.v(c0, "album_id");
            int v6 = F.v(c0, "artist");
            int v7 = F.v(c0, "artist_id");
            int v8 = F.v(c0, "duration");
            int v9 = F.v(c0, "is_adult");
            int v10 = F.v(c0, "origin");
            int v11 = F.v(c0, "menu_id");
            int v12 = F.v(c0, "origin_menu_id");
            int v13 = F.v(c0, "has_mv");
            int v14 = F.v(c0, "mv_name");
            int v15 = F.v(c0, "mv_id");
            int v16 = F.v(c0, "c_type");
            int v17 = F.v(c0, "play_count");
            int v18 = F.v(c0, "is_free");
            int v19 = F.v(c0, "is_hit_song");
            int v20 = F.v(c0, "is_holdback");
            int v21 = F.v(c0, "is_title");
            int v22 = F.v(c0, "create_at");
            int v23 = F.v(c0, "create_seq");
            int v24 = F.v(c0, "album_img_path");
            int v25 = F.v(c0, "album_thumb_path");
            int v26 = F.v(c0, "display_order");
            int v27 = F.v(c0, "stats_elements");
            int v28 = F.v(c0, "uri_string");
            int v29 = F.v(c0, "display_name");
            ArrayList arrayList0 = new ArrayList();
            while(true) {
                if(!c0.j0()) {
                    break;
                }
                String s = c0.S(v);
                int v30 = (int)c0.getLong(v1);
                String s1 = c0.S(v2);
                String s2 = c0.S(v3);
                String s3 = c0.S(v4);
                String s4 = c0.S(v5);
                String s5 = c0.S(v6);
                String s6 = c0.S(v7);
                long v31 = c0.getLong(v8);
                z = ((int)c0.getLong(v9)) == 0 ? false : true;
                int v32 = (int)c0.getLong(v10);
                String s7 = c0.S(v11);
                String s8 = c0.S(v12);
                z1 = ((int)c0.getLong(v13)) == 0 ? false : true;
                String s9 = c0.S(v14);
                String s10 = c0.S(v15);
                String s11 = c0.S(v16);
                int v33 = (int)c0.getLong(v17);
                z2 = ((int)c0.getLong(v18)) == 0 ? false : true;
                z3 = ((int)c0.getLong(v19)) == 0 ? false : true;
                z4 = ((int)c0.getLong(v20)) == 0 ? false : true;
                z5 = ((int)c0.getLong(v21)) == 0 ? false : true;
                arrayList0.add(new EduEntity(s, new PlayableEntity(v30, s1, s2, s3, s4, s5, s6, v31, z, v32, s7, s8, z1, s9, s10, s11, v33, z2, z3, z4, z5, c0.getLong(v22), ((int)c0.getLong(v23)), c0.S(v24), c0.S(v25), ((int)c0.getLong(v26)), c0.S(v27), c0.S(v28), c0.S(v29))));
            }
            return arrayList0;
        }
    }

    private static List lambda$getAllMixUpEntities$38(a a0) {
        boolean z5;
        boolean z4;
        boolean z3;
        boolean z2;
        boolean z1;
        boolean z;
        try(G4.c c0 = a0.l0("SELECT * FROM MIXUP")) {
            int v = F.v(c0, "track_id");
            int v1 = F.v(c0, "song_id");
            int v2 = F.v(c0, "title");
            int v3 = F.v(c0, "data");
            int v4 = F.v(c0, "album");
            int v5 = F.v(c0, "album_id");
            int v6 = F.v(c0, "artist");
            int v7 = F.v(c0, "artist_id");
            int v8 = F.v(c0, "duration");
            int v9 = F.v(c0, "is_adult");
            int v10 = F.v(c0, "origin");
            int v11 = F.v(c0, "menu_id");
            int v12 = F.v(c0, "origin_menu_id");
            int v13 = F.v(c0, "has_mv");
            int v14 = F.v(c0, "mv_name");
            int v15 = F.v(c0, "mv_id");
            int v16 = F.v(c0, "c_type");
            int v17 = F.v(c0, "play_count");
            int v18 = F.v(c0, "is_free");
            int v19 = F.v(c0, "is_hit_song");
            int v20 = F.v(c0, "is_holdback");
            int v21 = F.v(c0, "is_title");
            int v22 = F.v(c0, "create_at");
            int v23 = F.v(c0, "create_seq");
            int v24 = F.v(c0, "album_img_path");
            int v25 = F.v(c0, "album_thumb_path");
            int v26 = F.v(c0, "display_order");
            int v27 = F.v(c0, "stats_elements");
            int v28 = F.v(c0, "uri_string");
            int v29 = F.v(c0, "display_name");
            ArrayList arrayList0 = new ArrayList();
            while(true) {
                if(!c0.j0()) {
                    break;
                }
                String s = c0.S(v);
                int v30 = (int)c0.getLong(v1);
                String s1 = c0.S(v2);
                String s2 = c0.S(v3);
                String s3 = c0.S(v4);
                String s4 = c0.S(v5);
                String s5 = c0.S(v6);
                String s6 = c0.S(v7);
                long v31 = c0.getLong(v8);
                z = ((int)c0.getLong(v9)) == 0 ? false : true;
                int v32 = (int)c0.getLong(v10);
                String s7 = c0.S(v11);
                String s8 = c0.S(v12);
                z1 = ((int)c0.getLong(v13)) == 0 ? false : true;
                String s9 = c0.S(v14);
                String s10 = c0.S(v15);
                String s11 = c0.S(v16);
                int v33 = (int)c0.getLong(v17);
                z2 = ((int)c0.getLong(v18)) == 0 ? false : true;
                z3 = ((int)c0.getLong(v19)) == 0 ? false : true;
                z4 = ((int)c0.getLong(v20)) == 0 ? false : true;
                z5 = ((int)c0.getLong(v21)) == 0 ? false : true;
                arrayList0.add(new MixUpEntity(s, new PlayableEntity(v30, s1, s2, s3, s4, s5, s6, v31, z, v32, s7, s8, z1, s9, s10, s11, v33, z2, z3, z4, z5, c0.getLong(v22), ((int)c0.getLong(v23)), c0.S(v24), c0.S(v25), ((int)c0.getLong(v26)), c0.S(v27), c0.S(v28), c0.S(v29))));
            }
            return arrayList0;
        }
    }

    private static List lambda$getAllMusicPlaylist$35(a a0) {
        boolean z5;
        boolean z4;
        boolean z3;
        boolean z2;
        boolean z1;
        boolean z;
        try(G4.c c0 = a0.l0("SELECT * FROM MUSIC")) {
            int v = F.v(c0, "track_id");
            int v1 = F.v(c0, "song_id");
            int v2 = F.v(c0, "title");
            int v3 = F.v(c0, "data");
            int v4 = F.v(c0, "album");
            int v5 = F.v(c0, "album_id");
            int v6 = F.v(c0, "artist");
            int v7 = F.v(c0, "artist_id");
            int v8 = F.v(c0, "duration");
            int v9 = F.v(c0, "is_adult");
            int v10 = F.v(c0, "origin");
            int v11 = F.v(c0, "menu_id");
            int v12 = F.v(c0, "origin_menu_id");
            int v13 = F.v(c0, "has_mv");
            int v14 = F.v(c0, "mv_name");
            int v15 = F.v(c0, "mv_id");
            int v16 = F.v(c0, "c_type");
            int v17 = F.v(c0, "play_count");
            int v18 = F.v(c0, "is_free");
            int v19 = F.v(c0, "is_hit_song");
            int v20 = F.v(c0, "is_holdback");
            int v21 = F.v(c0, "is_title");
            int v22 = F.v(c0, "create_at");
            int v23 = F.v(c0, "create_seq");
            int v24 = F.v(c0, "album_img_path");
            int v25 = F.v(c0, "album_thumb_path");
            int v26 = F.v(c0, "display_order");
            int v27 = F.v(c0, "stats_elements");
            int v28 = F.v(c0, "uri_string");
            int v29 = F.v(c0, "display_name");
            ArrayList arrayList0 = new ArrayList();
            while(true) {
                if(!c0.j0()) {
                    break;
                }
                String s = c0.S(v);
                int v30 = (int)c0.getLong(v1);
                String s1 = c0.S(v2);
                String s2 = c0.S(v3);
                String s3 = c0.S(v4);
                String s4 = c0.S(v5);
                String s5 = c0.S(v6);
                String s6 = c0.S(v7);
                long v31 = c0.getLong(v8);
                z = ((int)c0.getLong(v9)) == 0 ? false : true;
                int v32 = (int)c0.getLong(v10);
                String s7 = c0.S(v11);
                String s8 = c0.S(v12);
                z1 = ((int)c0.getLong(v13)) == 0 ? false : true;
                String s9 = c0.S(v14);
                String s10 = c0.S(v15);
                String s11 = c0.S(v16);
                int v33 = (int)c0.getLong(v17);
                z2 = ((int)c0.getLong(v18)) == 0 ? false : true;
                z3 = ((int)c0.getLong(v19)) == 0 ? false : true;
                z4 = ((int)c0.getLong(v20)) == 0 ? false : true;
                z5 = ((int)c0.getLong(v21)) == 0 ? false : true;
                arrayList0.add(new MusicEntity(s, new PlayableEntity(v30, s1, s2, s3, s4, s5, s6, v31, z, v32, s7, s8, z1, s9, s10, s11, v33, z2, z3, z4, z5, c0.getLong(v22), ((int)c0.getLong(v23)), c0.S(v24), c0.S(v25), ((int)c0.getLong(v26)), c0.S(v27), c0.S(v28), c0.S(v29))));
            }
            return arrayList0;
        }
    }

    private static List lambda$getAllOrdered$40(a a0) {
        boolean z5;
        boolean z4;
        boolean z3;
        boolean z2;
        boolean z1;
        boolean z;
        try(G4.c c0 = a0.l0("\n        SELECT * FROM MIXUP_WAITING_BACK\n        ORDER BY create_at ASC, create_seq ASC\n    ")) {
            int v = F.v(c0, "track_id");
            int v1 = F.v(c0, "song_id");
            int v2 = F.v(c0, "title");
            int v3 = F.v(c0, "data");
            int v4 = F.v(c0, "album");
            int v5 = F.v(c0, "album_id");
            int v6 = F.v(c0, "artist");
            int v7 = F.v(c0, "artist_id");
            int v8 = F.v(c0, "duration");
            int v9 = F.v(c0, "is_adult");
            int v10 = F.v(c0, "origin");
            int v11 = F.v(c0, "menu_id");
            int v12 = F.v(c0, "origin_menu_id");
            int v13 = F.v(c0, "has_mv");
            int v14 = F.v(c0, "mv_name");
            int v15 = F.v(c0, "mv_id");
            int v16 = F.v(c0, "c_type");
            int v17 = F.v(c0, "play_count");
            int v18 = F.v(c0, "is_free");
            int v19 = F.v(c0, "is_hit_song");
            int v20 = F.v(c0, "is_holdback");
            int v21 = F.v(c0, "is_title");
            int v22 = F.v(c0, "create_at");
            int v23 = F.v(c0, "create_seq");
            int v24 = F.v(c0, "album_img_path");
            int v25 = F.v(c0, "album_thumb_path");
            int v26 = F.v(c0, "display_order");
            int v27 = F.v(c0, "stats_elements");
            int v28 = F.v(c0, "uri_string");
            int v29 = F.v(c0, "display_name");
            ArrayList arrayList0 = new ArrayList();
            while(true) {
                if(!c0.j0()) {
                    break;
                }
                String s = c0.S(v);
                int v30 = (int)c0.getLong(v1);
                String s1 = c0.S(v2);
                String s2 = c0.S(v3);
                String s3 = c0.S(v4);
                String s4 = c0.S(v5);
                String s5 = c0.S(v6);
                String s6 = c0.S(v7);
                long v31 = c0.getLong(v8);
                z = ((int)c0.getLong(v9)) == 0 ? false : true;
                int v32 = (int)c0.getLong(v10);
                String s7 = c0.S(v11);
                String s8 = c0.S(v12);
                z1 = ((int)c0.getLong(v13)) == 0 ? false : true;
                String s9 = c0.S(v14);
                String s10 = c0.S(v15);
                String s11 = c0.S(v16);
                int v33 = (int)c0.getLong(v17);
                z2 = ((int)c0.getLong(v18)) == 0 ? false : true;
                z3 = ((int)c0.getLong(v19)) == 0 ? false : true;
                z4 = ((int)c0.getLong(v20)) == 0 ? false : true;
                z5 = ((int)c0.getLong(v21)) == 0 ? false : true;
                arrayList0.add(new MixUpWaitingBackEntity(s, new PlayableEntity(v30, s1, s2, s3, s4, s5, s6, v31, z, v32, s7, s8, z1, s9, s10, s11, v33, z2, z3, z4, z5, c0.getLong(v22), ((int)c0.getLong(v23)), c0.S(v24), c0.S(v25), ((int)c0.getLong(v26)), c0.S(v27), c0.S(v28), c0.S(v29))));
            }
            return arrayList0;
        }
    }

    private static List lambda$getAllSmartEntities$37(a a0) {
        boolean z5;
        boolean z4;
        boolean z3;
        boolean z2;
        boolean z1;
        boolean z;
        try(G4.c c0 = a0.l0("SELECT * FROM SMART")) {
            int v = F.v(c0, "track_id");
            int v1 = F.v(c0, "song_id");
            int v2 = F.v(c0, "title");
            int v3 = F.v(c0, "data");
            int v4 = F.v(c0, "album");
            int v5 = F.v(c0, "album_id");
            int v6 = F.v(c0, "artist");
            int v7 = F.v(c0, "artist_id");
            int v8 = F.v(c0, "duration");
            int v9 = F.v(c0, "is_adult");
            int v10 = F.v(c0, "origin");
            int v11 = F.v(c0, "menu_id");
            int v12 = F.v(c0, "origin_menu_id");
            int v13 = F.v(c0, "has_mv");
            int v14 = F.v(c0, "mv_name");
            int v15 = F.v(c0, "mv_id");
            int v16 = F.v(c0, "c_type");
            int v17 = F.v(c0, "play_count");
            int v18 = F.v(c0, "is_free");
            int v19 = F.v(c0, "is_hit_song");
            int v20 = F.v(c0, "is_holdback");
            int v21 = F.v(c0, "is_title");
            int v22 = F.v(c0, "create_at");
            int v23 = F.v(c0, "create_seq");
            int v24 = F.v(c0, "album_img_path");
            int v25 = F.v(c0, "album_thumb_path");
            int v26 = F.v(c0, "display_order");
            int v27 = F.v(c0, "stats_elements");
            int v28 = F.v(c0, "uri_string");
            int v29 = F.v(c0, "display_name");
            ArrayList arrayList0 = new ArrayList();
            while(true) {
                if(!c0.j0()) {
                    break;
                }
                String s = c0.S(v);
                int v30 = (int)c0.getLong(v1);
                String s1 = c0.S(v2);
                String s2 = c0.S(v3);
                String s3 = c0.S(v4);
                String s4 = c0.S(v5);
                String s5 = c0.S(v6);
                String s6 = c0.S(v7);
                long v31 = c0.getLong(v8);
                z = ((int)c0.getLong(v9)) == 0 ? false : true;
                int v32 = (int)c0.getLong(v10);
                String s7 = c0.S(v11);
                String s8 = c0.S(v12);
                z1 = ((int)c0.getLong(v13)) == 0 ? false : true;
                String s9 = c0.S(v14);
                String s10 = c0.S(v15);
                String s11 = c0.S(v16);
                int v33 = (int)c0.getLong(v17);
                z2 = ((int)c0.getLong(v18)) == 0 ? false : true;
                z3 = ((int)c0.getLong(v19)) == 0 ? false : true;
                z4 = ((int)c0.getLong(v20)) == 0 ? false : true;
                z5 = ((int)c0.getLong(v21)) == 0 ? false : true;
                arrayList0.add(new SmartEntity(s, new PlayableEntity(v30, s1, s2, s3, s4, s5, s6, v31, z, v32, s7, s8, z1, s9, s10, s11, v33, z2, z3, z4, z5, c0.getLong(v22), ((int)c0.getLong(v23)), c0.S(v24), c0.S(v25), ((int)c0.getLong(v26)), c0.S(v27), c0.S(v28), c0.S(v29))));
            }
            return arrayList0;
        }
    }

    private static Integer lambda$getSize$39(a a0) {
        try(G4.c c0 = a0.l0("SELECT COUNT(*) FROM MIXUP_WAITING_BACK")) {
            return c0.j0() ? ((int)c0.getLong(0)) : 0;
        }
    }

    private static List lambda$getTopN$41(int v, a a0) {
        boolean z5;
        boolean z4;
        boolean z3;
        boolean z2;
        boolean z1;
        boolean z;
        try(G4.c c0 = a0.l0("\n        SELECT * FROM MIXUP_WAITING_BACK\n        ORDER BY create_at ASC, create_seq ASC\n        LIMIT ?\n    ")) {
            c0.a(1, ((long)v));
            int v1 = F.v(c0, "track_id");
            int v2 = F.v(c0, "song_id");
            int v3 = F.v(c0, "title");
            int v4 = F.v(c0, "data");
            int v5 = F.v(c0, "album");
            int v6 = F.v(c0, "album_id");
            int v7 = F.v(c0, "artist");
            int v8 = F.v(c0, "artist_id");
            int v9 = F.v(c0, "duration");
            int v10 = F.v(c0, "is_adult");
            int v11 = F.v(c0, "origin");
            int v12 = F.v(c0, "menu_id");
            int v13 = F.v(c0, "origin_menu_id");
            int v14 = F.v(c0, "has_mv");
            int v15 = F.v(c0, "mv_name");
            int v16 = F.v(c0, "mv_id");
            int v17 = F.v(c0, "c_type");
            int v18 = F.v(c0, "play_count");
            int v19 = F.v(c0, "is_free");
            int v20 = F.v(c0, "is_hit_song");
            int v21 = F.v(c0, "is_holdback");
            int v22 = F.v(c0, "is_title");
            int v23 = F.v(c0, "create_at");
            int v24 = F.v(c0, "create_seq");
            int v25 = F.v(c0, "album_img_path");
            int v26 = F.v(c0, "album_thumb_path");
            int v27 = F.v(c0, "display_order");
            int v28 = F.v(c0, "stats_elements");
            int v29 = F.v(c0, "uri_string");
            int v30 = F.v(c0, "display_name");
            List list0 = new ArrayList();
            while(true) {
                if(!c0.j0()) {
                    break;
                }
                String s = c0.S(v1);
                int v31 = (int)c0.getLong(v2);
                String s1 = c0.S(v3);
                String s2 = c0.S(v4);
                String s3 = c0.S(v5);
                String s4 = c0.S(v6);
                String s5 = c0.S(v7);
                String s6 = c0.S(v8);
                long v32 = c0.getLong(v9);
                z = ((int)c0.getLong(v10)) == 0 ? false : true;
                int v33 = (int)c0.getLong(v11);
                String s7 = c0.S(v12);
                String s8 = c0.S(v13);
                z1 = ((int)c0.getLong(v14)) == 0 ? false : true;
                String s9 = c0.S(v15);
                String s10 = c0.S(v16);
                String s11 = c0.S(v17);
                int v34 = (int)c0.getLong(v18);
                z2 = ((int)c0.getLong(v19)) == 0 ? false : true;
                z3 = ((int)c0.getLong(v20)) == 0 ? false : true;
                z4 = ((int)c0.getLong(v21)) == 0 ? false : true;
                z5 = ((int)c0.getLong(v22)) == 0 ? false : true;
                ((ArrayList)list0).add(new MixUpWaitingBackEntity(s, new PlayableEntity(v31, s1, s2, s3, s4, s5, s6, v32, z, v33, s7, s8, z1, s9, s10, s11, v34, z2, z3, z4, z5, c0.getLong(v23), ((int)c0.getLong(v24)), c0.S(v25), c0.S(v26), ((int)c0.getLong(v27)), c0.S(v28), c0.S(v29), c0.S(v30))));
            }
            return list0;
        }
    }

    private ie.H lambda$insert$6(List list0, a a0) {
        this.__insertAdapterOfMixUpWaitingBackEntity.insert(a0, list0);
        return ie.H.a;
    }

    private ie.H lambda$insertAllEdu$2(List list0, a a0) {
        this.__insertAdapterOfEduEntity.insert(a0, list0);
        return ie.H.a;
    }

    private ie.H lambda$insertAllMusic$0(List list0, a a0) {
        this.__insertAdapterOfMusicEntity.insert(a0, list0);
        return ie.H.a;
    }

    private ie.H lambda$insertEduEntity$3(EduEntity eduEntity0, a a0) {
        this.__insertAdapterOfEduEntity_1.insert(a0, eduEntity0);
        return ie.H.a;
    }

    private Object lambda$insertEdusAndUpdateOrderInTransaction$18(List list0, List list1, Continuation continuation0) {
        return super.insertEdusAndUpdateOrderInTransaction(list0, list1, continuation0);
    }

    private ie.H lambda$insertMixUpEntities$5(List list0, a a0) {
        this.__insertAdapterOfMixUpEntity.insert(a0, list0);
        return ie.H.a;
    }

    private Object lambda$insertMixUpEntitiesAndUpdateOrder$28(List list0, List list1, Continuation continuation0) {
        return super.insertMixUpEntitiesAndUpdateOrder(list0, list1, continuation0);
    }

    private ie.H lambda$insertMusicEntity$1(MusicEntity musicEntity0, a a0) {
        this.__insertAdapterOfMusicEntity_1.insert(a0, musicEntity0);
        return ie.H.a;
    }

    private Object lambda$insertMusicsAndUpdateOrderInTransaction$13(List list0, List list1, Continuation continuation0) {
        return super.insertMusicsAndUpdateOrderInTransaction(list0, list1, continuation0);
    }

    private ie.H lambda$insertSmartEntities$4(List list0, a a0) {
        this.__insertAdapterOfSmartEntity.insert(a0, list0);
        return ie.H.a;
    }

    private Object lambda$insertSmartEntitiesAndUpdateOrder$23(List list0, List list1, Continuation continuation0) {
        return super.insertSmartEntitiesAndUpdateOrder(list0, list1, continuation0);
    }

    private Object lambda$popTopN$34(int v, Continuation continuation0) {
        return super.popTopN(v, continuation0);
    }

    private Object lambda$updateDisPlayOrderEduList$19(List list0, Continuation continuation0) {
        return super.updateDisPlayOrderEduList(list0, continuation0);
    }

    private Object lambda$updateDisPlayOrderMusicList$14(List list0, Continuation continuation0) {
        return super.updateDisPlayOrderMusicList(list0, continuation0);
    }

    private static ie.H lambda$updateDisplayOrderByTrackIdMixUp$51(int v, String s, a a0) {
        try(G4.c c0 = a0.l0("UPDATE MIXUP set display_order = ? WHERE track_id = ?")) {
            c0.a(1, ((long)v));
            c0.e(2, s);
            c0.j0();
            return ie.H.a;
        }
    }

    private static ie.H lambda$updateDisplayOrderByTrackIdSmart$48(int v, String s, a a0) {
        try(G4.c c0 = a0.l0("UPDATE SMART set display_order = ? WHERE track_id = ?")) {
            c0.a(1, ((long)v));
            c0.e(2, s);
            c0.j0();
            return ie.H.a;
        }
    }

    private static ie.H lambda$updateDisplayOrderEdu$45(int v, String s, a a0) {
        try(G4.c c0 = a0.l0("UPDATE EDU set display_order = ? WHERE track_id = ?")) {
            c0.a(1, ((long)v));
            c0.e(2, s);
            c0.j0();
            return ie.H.a;
        }
    }

    private static ie.H lambda$updateDisplayOrderMusic$42(int v, String s, a a0) {
        try(G4.c c0 = a0.l0("UPDATE MUSIC set display_order = ? WHERE track_id = ?")) {
            c0.a(1, ((long)v));
            c0.e(2, s);
            c0.j0();
            return ie.H.a;
        }
    }

    private ie.H lambda$updateEduEntity$10(EduEntity eduEntity0, a a0) {
        this.__updateAdapterOfEduEntity_1.handle(a0, eduEntity0);
        return ie.H.a;
    }

    private Integer lambda$updateMixUpEntities$12(List list0, a a0) {
        return this.__updateAdapterOfMixUpEntity.handleMultiple(a0, list0);
    }

    private Integer lambda$updateMusicEntitys$8(List list0, a a0) {
        return this.__updateAdapterOfMusicEntity.handleMultiple(a0, list0);
    }

    private Object lambda$updateOrdersMixUp$29(List list0, Continuation continuation0) {
        return super.updateOrdersMixUp(list0, continuation0);
    }

    private Object lambda$updateOrdersSmart$24(List list0, Continuation continuation0) {
        return super.updateOrdersSmart(list0, continuation0);
    }

    private Integer lambda$updateSmartEntities$11(List list0, a a0) {
        return this.__updateAdapterOfSmartEntity.handleMultiple(a0, list0);
    }

    private ie.H lambda$updatedEduEntitys$9(List list0, a a0) {
        this.__updateAdapterOfEduEntity.handleMultiple(a0, list0);
        return ie.H.a;
    }

    public static Integer m(a a0) {
        return PlaylistDao_Impl.lambda$getSize$39(a0);
    }

    public static Object n(PlaylistDao_Impl playlistDao_Impl0, List list0, List list1, Continuation continuation0) {
        return playlistDao_Impl0.lambda$insertEdusAndUpdateOrderInTransaction$18(list0, list1, continuation0);
    }

    public static Object o(PlaylistDao_Impl playlistDao_Impl0, List list0, Continuation continuation0) {
        return playlistDao_Impl0.lambda$clearAndInsertEduInTransaction$22(list0, continuation0);
    }

    public static ie.H p(String s, a a0) {
        return PlaylistDao_Impl.lambda$deleteSmartEntityByTrackId$49(s, a0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MixUpWaitingBackDao
    public Object popTopN(int v, Continuation continuation0) {
        C8.e e0 = new C8.e(this, v, 6);
        return w.O(this.__db, continuation0, e0);
    }

    public static Object q(PlaylistDao_Impl playlistDao_Impl0, List list0, Continuation continuation0) {
        return playlistDao_Impl0.lambda$clearAndInsert$33(list0, continuation0);
    }

    public static Object r(PlaylistDao_Impl playlistDao_Impl0, List list0, Continuation continuation0) {
        return playlistDao_Impl0.lambda$updateDisPlayOrderMusicList$14(list0, continuation0);
    }

    public static Object s(PlaylistDao_Impl playlistDao_Impl0, List list0, Continuation continuation0) {
        return playlistDao_Impl0.lambda$deleteEduList$20(list0, continuation0);
    }

    public static Object t(PlaylistDao_Impl playlistDao_Impl0, List list0, Continuation continuation0) {
        return playlistDao_Impl0.lambda$deleteMixUpEntities$30(list0, continuation0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.EduPlaylistDao
    public Object updateDisPlayOrderEduList(List list0, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.a a0 = new com.iloen.melon.playback.playlist.db.a(this, list0, 16);
        return w.O(this.__db, continuation0, a0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MusicPlaylistDao
    public Object updateDisPlayOrderMusicList(List list0, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.a a0 = new com.iloen.melon.playback.playlist.db.a(this, list0, 22);
        return w.O(this.__db, continuation0, a0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MixUpPlaylistDao
    public Object updateDisplayOrderByTrackIdMixUp(String s, int v, Continuation continuation0) {
        Ld.w w0 = new Ld.w(v, s, 4);
        return w.P(this.__db, continuation0, w0, false, true);
    }

    @Override  // com.iloen.melon.playback.playlist.db.SmartPlaylistDao
    public Object updateDisplayOrderByTrackIdSmart(String s, int v, Continuation continuation0) {
        Ld.w w0 = new Ld.w(v, s, 1);
        return w.P(this.__db, continuation0, w0, false, true);
    }

    @Override  // com.iloen.melon.playback.playlist.db.EduPlaylistDao
    public Object updateDisplayOrderEdu(String s, int v, Continuation continuation0) {
        Ld.w w0 = new Ld.w(v, s, 2);
        return w.P(this.__db, continuation0, w0, false, true);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MusicPlaylistDao
    public Object updateDisplayOrderMusic(String s, int v, Continuation continuation0) {
        Ld.w w0 = new Ld.w(v, s, 3);
        return w.P(this.__db, continuation0, w0, false, true);
    }

    @Override  // com.iloen.melon.playback.playlist.db.EduPlaylistDao
    public Object updateEduEntity(EduEntity eduEntity0, Continuation continuation0) {
        eduEntity0.getClass();
        e e0 = new e(this, eduEntity0, 1);
        return w.P(this.__db, continuation0, e0, false, true);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MixUpPlaylistDao
    public Object updateMixUpEntities(List list0, Continuation continuation0) {
        list0.getClass();
        com.iloen.melon.playback.playlist.db.a a0 = new com.iloen.melon.playback.playlist.db.a(this, list0, 9);
        return w.P(this.__db, continuation0, a0, false, true);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MusicPlaylistDao
    public Object updateMusicEntitys(List list0, Continuation continuation0) {
        list0.getClass();
        com.iloen.melon.playback.playlist.db.a a0 = new com.iloen.melon.playback.playlist.db.a(this, list0, 11);
        return w.P(this.__db, continuation0, a0, false, true);
    }

    @Override  // com.iloen.melon.playback.playlist.db.MixUpPlaylistDao
    public Object updateOrdersMixUp(List list0, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.a a0 = new com.iloen.melon.playback.playlist.db.a(this, list0, 18);
        return w.O(this.__db, continuation0, a0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.SmartPlaylistDao
    public Object updateOrdersSmart(List list0, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.a a0 = new com.iloen.melon.playback.playlist.db.a(this, list0, 21);
        return w.O(this.__db, continuation0, a0);
    }

    @Override  // com.iloen.melon.playback.playlist.db.SmartPlaylistDao
    public Object updateSmartEntities(List list0, Continuation continuation0) {
        list0.getClass();
        com.iloen.melon.playback.playlist.db.a a0 = new com.iloen.melon.playback.playlist.db.a(this, list0, 6);
        return w.P(this.__db, continuation0, a0, false, true);
    }

    @Override  // com.iloen.melon.playback.playlist.db.EduPlaylistDao
    public Object updatedEduEntitys(List list0, Continuation continuation0) {
        list0.getClass();
        com.iloen.melon.playback.playlist.db.a a0 = new com.iloen.melon.playback.playlist.db.a(this, list0, 4);
        return w.P(this.__db, continuation0, a0, false, true);
    }

    public static Object w(PlaylistDao_Impl playlistDao_Impl0, int v, Continuation continuation0) {
        return playlistDao_Impl0.lambda$popTopN$34(v, continuation0);
    }

    public static List x(a a0) {
        return PlaylistDao_Impl.lambda$getAllSmartEntities$37(a0);
    }

    public static Object y(PlaylistDao_Impl playlistDao_Impl0, List list0, Continuation continuation0) {
        return playlistDao_Impl0.lambda$clearAndInsertSmartEntities$27(list0, continuation0);
    }

    public static ie.H z(String s, a a0) {
        return PlaylistDao_Impl.lambda$deleteTrackIdMusic$43(s, a0);
    }
}

