package w9;

import B4.a;
import a7.c;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import ie.H;
import ie.o;
import ie.p;
import kotlin.jvm.internal.q;

public final class g extends a {
    @Override  // B4.a
    public final void migrate(H4.a a0) {
        H h0;
        q.g(a0, "db");
        try {
            a0.u("\n                    CREATE TABLE IF NOT EXISTS `tab_menu_shortcut`\n                    (\n                        `_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n                        `menu_seq` TEXT NOT NULL,\n                        `member_key` TEXT NOT NULL,\n                        `timestamp` INTEGER NOT NULL\n                    )\n                    ");
            a0.u("\n                    CREATE UNIQUE INDEX IF NOT EXISTS index_tab_menu_shortcut_menu_seq_member_key_unique ON tab_menu_shortcut (menu_seq, member_key);\n                    ");
            a0.u("\n                    DROP TABLE IF EXISTS popup_manage\n                    ");
            h0 = H.a;
        }
        catch(Throwable throwable0) {
            h0 = n.t(throwable0);
        }
        if(!(h0 instanceof o)) {
            LogU.Companion.d("VolatileDatabase", "migrate() volatile_db version : 3 -> 4 success");
        }
        Throwable throwable1 = p.a(h0);
        if(throwable1 != null) {
            LogU.Companion.e("VolatileDatabase", "migrate() volatile_db version : 3 -> 4 error : " + throwable1);
            c.a().b("VolatileDatabase Migrate fail - 3 -> 4 " + throwable1.getMessage());
        }
    }
}

