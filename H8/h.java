package H8;

import androidx.room.c;
import com.iloen.melon.premium.PremiumContentsEntity;
import y8.v;

public final class h extends c {
    public final int a;

    public h(int v) {
        this.a = v;
        super();
    }

    @Override  // androidx.room.c
    public final void bind(G4.c c0, Object object0) {
        switch(this.a) {
            case 0: {
                c0.a(1, ((k)object0).a);
                return;
            }
            case 1: {
                k k0 = (k)object0;
                c0.e(1, k0.b);
                c0.e(2, k0.c);
                c0.e(3, k0.d);
                c0.e(4, k0.e);
                c0.a(5, ((long)k0.f));
                c0.a(6, k0.g);
                c0.e(7, k0.h);
                c0.a(8, k0.i);
                c0.a(9, k0.j);
                c0.e(10, k0.k);
                c0.a(11, ((long)k0.l));
                c0.e(12, k0.m);
                c0.e(13, k0.n);
                c0.e(14, k0.o);
                c0.e(15, k0.p);
                c0.e(16, k0.q);
                c0.e(17, k0.r);
                c0.e(18, k0.s);
                c0.a(19, ((long)k0.t));
                Integer integer0 = k0.u;
                if(integer0 == null) {
                    c0.b(20);
                }
                else {
                    c0.a(20, ((long)(((int)integer0))));
                }
                c0.a(21, k0.v);
                c0.a(22, k0.w);
                c0.a(23, k0.a);
                c0.a(24, k0.a);
                return;
            }
            case 2: {
                c0.a(1, ((u)object0).a);
                c0.e(2, ((u)object0).b);
                c0.e(3, ((u)object0).c);
                c0.a(4, ((long)((u)object0).d));
                c0.e(5, ((u)object0).e);
                c0.e(6, ((u)object0).f);
                c0.e(7, ((u)object0).g);
                c0.e(8, ((u)object0).h);
                c0.e(9, ((u)object0).i);
                c0.a(10, ((u)object0).a);
                return;
            }
            case 3: {
                c0.a(1, ((t)object0).a);
                return;
            }
            case 4: {
                c0.a(1, ((s)object0).a);
                c0.e(2, ((s)object0).b);
                c0.a(3, ((s)object0).c);
                c0.a(4, ((s)object0).d);
                c0.a(5, ((long)((s)object0).e));
                c0.a(6, ((long)((s)object0).f));
                c0.a(7, ((s)object0).a);
                return;
            }
            case 5: {
                c0.a(1, ((t)object0).a);
                c0.a(2, ((t)object0).b);
                c0.e(3, ((t)object0).c);
                c0.e(4, ((t)object0).d);
                c0.e(5, ((t)object0).e);
                c0.e(6, ((t)object0).f);
                c0.e(7, ((t)object0).g);
                c0.e(8, ((t)object0).h);
                c0.e(9, ((t)object0).i);
                c0.e(10, ((t)object0).j);
                c0.e(11, ((t)object0).k);
                c0.a(12, ((t)object0).l);
                c0.a(13, ((long)((t)object0).m));
                c0.a(14, ((long)((t)object0).n));
                c0.a(15, ((t)object0).a);
                return;
            }
            case 6: {
                c0.a(1, ((long)((PremiumContentsEntity)object0).a));
                c0.e(2, ((PremiumContentsEntity)object0).b);
                c0.e(3, ((PremiumContentsEntity)object0).c);
                c0.e(4, ((PremiumContentsEntity)object0).d);
                c0.e(5, ((PremiumContentsEntity)object0).e);
                c0.e(6, ((PremiumContentsEntity)object0).f);
                c0.e(7, ((PremiumContentsEntity)object0).g);
                c0.e(8, ((PremiumContentsEntity)object0).h);
                c0.e(9, ((PremiumContentsEntity)object0).i);
                c0.e(10, ((PremiumContentsEntity)object0).j);
                String s3 = ((PremiumContentsEntity)object0).k;
                if(s3 == null) {
                    c0.b(11);
                }
                else {
                    c0.e(11, s3);
                }
                String s4 = ((PremiumContentsEntity)object0).l;
                if(s4 == null) {
                    c0.b(12);
                }
                else {
                    c0.e(12, s4);
                }
                String s5 = ((PremiumContentsEntity)object0).m;
                if(s5 == null) {
                    c0.b(13);
                }
                else {
                    c0.e(13, s5);
                }
                Boolean boolean0 = ((PremiumContentsEntity)object0).n;
                Integer integer1 = boolean0 == null ? null : ((int)boolean0.booleanValue());
                if(integer1 == null) {
                    c0.b(14);
                }
                else {
                    c0.a(14, ((long)(((int)integer1))));
                }
                c0.a(15, ((long)((PremiumContentsEntity)object0).a));
                return;
            }
            default: {
                String s = ((v)object0).a;
                c0.e(1, s);
                c0.e(2, ((v)object0).b);
                String s1 = ((v)object0).c;
                c0.e(3, s1);
                c0.e(4, ((v)object0).d);
                String s2 = ((v)object0).e;
                if(s2 == null) {
                    c0.b(5);
                }
                else {
                    c0.e(5, s2);
                }
                c0.e(6, s);
                c0.e(7, s1);
            }
        }
    }

    @Override  // androidx.room.c
    public final String createQuery() {
        switch(this.a) {
            case 0: {
                return "DELETE FROM `local_contents` WHERE `_id` = ?";
            }
            case 1: {
                return "UPDATE OR ABORT `local_contents` SET `data` = ?,`uri` = ?,`display_name` = ?,`song_id` = ?,`match_stat` = ?,`size` = ?,`mime_type` = ?,`date_added` = ?,`date_modified` = ?,`title` = ?,`duration` = ?,`artists` = ?,`artist_ids` = ?,`album` = ?,`album_key` = ?,`album_id` = ?,`genre` = ?,`genre_id` = ?,`track` = ?,`year` = ?,`media_store_media_id` = ?,`media_store_album_id` = ?,`_id` = ? WHERE `_id` = ?";
            }
            case 2: {
                return "UPDATE OR ABORT `local_contents` SET `_id` = ?,`data` = ?,`song_id` = ?,`match_stat` = ?,`artists` = ?,`artist_ids` = ?,`album` = ?,`album_key` = ?,`album_id` = ? WHERE `_id` = ?";
            }
            case 3: {
                return "DELETE FROM `local_playlists_map` WHERE `_id` = ?";
            }
            case 4: {
                return "UPDATE OR ABORT `local_playlists` SET `_id` = ?,`name` = ?,`date_added` = ?,`date_modified` = ?,`sort_order` = ?,`playlist_count` = ? WHERE `_id` = ?";
            }
            case 5: {
                return "UPDATE OR ABORT `local_playlists_map` SET `_id` = ?,`audio_id` = ?,`mime_type` = ?,`data` = ?,`uri` = ?,`displayName` = ?,`title` = ?,`album_id` = ?,`album` = ?,`artist` = ?,`artist_id` = ?,`playlist_id` = ?,`play_order` = ?,`duration` = ? WHERE `_id` = ?";
            }
            case 6: {
                return "UPDATE OR ABORT `premium_contents` SET `_id` = ?,`cid` = ?,`ctype` = ?,`meta_type` = ?,`bitrate` = ?,`content_type` = ?,`secret` = ?,`file_update` = ?,`file_size` = ?,`cache_path` = ?,`thumbnail_path` = ?,`image_path` = ?,`image_etag` = ?,`is_free` = ? WHERE `_id` = ?";
            }
            default: {
                return "UPDATE OR ABORT `SolMetaDataEntity` SET `content_id` = ?,`c_type_code` = ?,`sol_type_code` = ?,`reg_date` = ?,`meta_data` = ? WHERE `content_id` = ? AND `sol_type_code` = ?";
            }
        }
    }
}

