package da;

import B4.a;
import kotlin.jvm.internal.q;

public final class b extends a {
    public final int a;

    public b(int v, int v1, int v2) {
        this.a = v2;
        super(v, v1);
    }

    @Override  // B4.a
    public final void migrate(H4.a a0) {
        switch(this.a) {
            case 0: {
                q.g(a0, "db");
                c.a(a0);
                return;
            }
            case 1: {
                q.g(a0, "db");
                c.a(a0);
                return;
            }
            case 2: {
                q.g(a0, "db");
                c.a(a0);
                return;
            }
            case 3: {
                q.g(a0, "db");
                c.a(a0);
                return;
            }
            default: {
                q.g(a0, "database");
                a0.u("CREATE TABLE IF NOT EXISTS `premium_playlist` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `seq` TEXT NOT NULL, `response_type` INTEGER NOT NULL, `playlist_type` INTEGER NOT NULL, `is_dj` INTEGER NOT NULL, `offline_mode` INTEGER NOT NULL, `response_message` TEXT NOT NULL, `save_date` INTEGER NOT NULL)");
            }
        }
    }
}

