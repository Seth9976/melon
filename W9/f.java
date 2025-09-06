package w9;

import B4.a;
import a7.c;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import ie.H;
import ie.o;
import ie.p;
import kotlin.jvm.internal.q;

public final class f extends a {
    @Override  // B4.a
    public final void migrate(H4.a a0) {
        H h0;
        q.g(a0, "db");
        try {
            a0.u("\n                    CREATE TABLE IF NOT EXISTS `tag`\n                    (\n                        `_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n                        `tag_seq` TEXT NOT NULL,\n                        `tag_name` TEXT NOT NULL,\n                        `timestamp` INTEGER NOT NULL\n                    )\n                    ");
            a0.u("\n                    CREATE UNIQUE INDEX IF NOT EXISTS index_tag_tag_name_unique ON tag (tag_name)\n                    ");
            a0.u("\n                    CREATE TABLE IF NOT EXISTS `restore_data`\n                    (\n                        `_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n                        `restore_id` TEXT NOT NULL,\n                        `data` TEXT NOT NULL,\n                        `timestamp` INTEGER NOT NULL\n                    )\n                    ");
            a0.u("\n                    CREATE UNIQUE INDEX IF NOT EXISTS index_restore_data_restore_id_unique ON restore_data (restore_id)\n                    ");
            h0 = H.a;
        }
        catch(Throwable throwable0) {
            h0 = n.t(throwable0);
        }
        if(!(h0 instanceof o)) {
            LogU.Companion.d("VolatileDatabase", "migrate() volatile_db version : 2 -> 3 success");
        }
        Throwable throwable1 = p.a(h0);
        if(throwable1 != null) {
            LogU.Companion.e("VolatileDatabase", "migrate() volatile_db version : 2 -> 3 error : " + throwable1);
            c.a().b("VolatileDatabase Migrate fail - 2 -> 3 " + throwable1.getMessage());
        }
    }
}

