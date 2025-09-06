package H8;

import G4.a;
import U4.F;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.q;
import we.k;

public final class c implements k {
    public final int a;
    public final String b;
    public final List c;

    public c(String s, int v, List list0) {
        this.a = v;
        this.b = s;
        this.c = list0;
        super();
    }

    private final Object d(Object object0) {
        try(G4.c c0 = ((a)object0).l0(this.b)) {
            Iterator iterator0 = this.c.iterator();
            for(int v = 1; true; ++v) {
                if(!iterator0.hasNext()) {
                    break;
                }
                Object object1 = iterator0.next();
                c0.e(v, ((String)object1));
            }
            int v1 = F.v(c0, "_id");
            int v2 = F.v(c0, "audio_id");
            int v3 = F.v(c0, "mime_type");
            int v4 = F.v(c0, "data");
            int v5 = F.v(c0, "uri");
            int v6 = F.v(c0, "displayName");
            int v7 = F.v(c0, "title");
            int v8 = F.v(c0, "album_id");
            int v9 = F.v(c0, "album");
            int v10 = F.v(c0, "artist");
            int v11 = F.v(c0, "artist_id");
            int v12 = F.v(c0, "playlist_id");
            int v13 = F.v(c0, "play_order");
            int v14 = F.v(c0, "duration");
            ArrayList arrayList0 = new ArrayList();
            while(true) {
                if(!c0.j0()) {
                    break;
                }
                arrayList0.add(new t(c0.getLong(v1), c0.getLong(v2), c0.S(v3), c0.S(v4), c0.S(v5), c0.S(v6), c0.S(v7), c0.S(v8), c0.S(v9), c0.S(v10), c0.S(v11), c0.getLong(v12), ((int)c0.getLong(v13)), ((int)c0.getLong(v14))));
            }
        }
        return arrayList0;
    }

    private final Object e(Object object0) {
        try(G4.c c0 = ((a)object0).l0(this.b)) {
            Iterator iterator0 = this.c.iterator();
            for(int v = 1; true; ++v) {
                if(!iterator0.hasNext()) {
                    break;
                }
                Object object1 = iterator0.next();
                c0.a(v, ((long)(((int)(((Integer)object1))))));
            }
            c0.j0();
            return Q1.c.F(((a)object0));
        }
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        int v99;
        Integer integer2;
        int v98;
        int v67;
        Integer integer1;
        int v66;
        int v35;
        Integer integer0;
        int v34;
        switch(this.a) {
            case 0: {
                try(G4.c c1 = ((a)object0).l0(this.b)) {
                    Iterator iterator1 = this.c.iterator();
                    for(int v1 = 1; true; ++v1) {
                        if(!iterator1.hasNext()) {
                            break;
                        }
                        Object object2 = iterator1.next();
                        c1.e(v1, ((String)object2));
                    }
                    ArrayList arrayList0 = new ArrayList();
                    while(true) {
                        if(!c1.j0()) {
                            break;
                        }
                        arrayList0.add(c1.S(0));
                    }
                }
                return arrayList0;
            }
            case 1: {
                try(G4.c c2 = ((a)object0).l0(this.b)) {
                    Iterator iterator2 = this.c.iterator();
                    for(int v2 = 1; true; ++v2) {
                        if(!iterator2.hasNext()) {
                            break;
                        }
                        Object object3 = iterator2.next();
                        c2.e(v2, ((String)object3));
                    }
                    c2.j0();
                }
                return null;
            }
            case 2: {
                try(G4.c c3 = ((a)object0).l0(this.b)) {
                    Iterator iterator3 = this.c.iterator();
                    for(int v3 = 1; true; ++v3) {
                        if(!iterator3.hasNext()) {
                            break;
                        }
                        Object object4 = iterator3.next();
                        c3.e(v3, ((String)object4));
                    }
                    ArrayList arrayList1 = new ArrayList();
                    while(true) {
                        if(!c3.j0()) {
                            break;
                        }
                        arrayList1.add(c3.S(0));
                    }
                }
                return arrayList1;
            }
            case 3: {
                try(G4.c c4 = ((a)object0).l0(this.b)) {
                    Iterator iterator4 = this.c.iterator();
                    for(int v4 = 1; true; ++v4) {
                        if(!iterator4.hasNext()) {
                            break;
                        }
                        Object object5 = iterator4.next();
                        c4.e(v4, ((String)object5));
                    }
                    int v5 = F.v(c4, "data");
                    int v6 = F.v(c4, "uri");
                    int v7 = F.v(c4, "display_name");
                    int v8 = F.v(c4, "song_id");
                    int v9 = F.v(c4, "match_stat");
                    int v10 = F.v(c4, "size");
                    int v11 = F.v(c4, "mime_type");
                    int v12 = F.v(c4, "date_added");
                    int v13 = F.v(c4, "date_modified");
                    int v14 = F.v(c4, "title");
                    int v15 = F.v(c4, "duration");
                    int v16 = F.v(c4, "artists");
                    int v17 = F.v(c4, "artist_ids");
                    int v18 = F.v(c4, "album");
                    int v19 = F.v(c4, "album_key");
                    int v20 = F.v(c4, "album_id");
                    int v21 = F.v(c4, "genre");
                    int v22 = F.v(c4, "genre_id");
                    int v23 = F.v(c4, "track");
                    int v24 = F.v(c4, "year");
                    int v25 = F.v(c4, "media_store_media_id");
                    int v26 = F.v(c4, "media_store_album_id");
                    int v27 = F.v(c4, "_id");
                    ArrayList arrayList2 = new ArrayList();
                    while(true) {
                        if(!c4.j0()) {
                            break;
                        }
                        String s = c4.S(v5);
                        String s1 = c4.S(v6);
                        String s2 = c4.S(v7);
                        String s3 = c4.S(v8);
                        int v28 = (int)c4.getLong(v9);
                        long v29 = c4.getLong(v10);
                        String s4 = c4.S(v11);
                        long v30 = c4.getLong(v12);
                        long v31 = c4.getLong(v13);
                        String s5 = c4.S(v14);
                        int v32 = (int)c4.getLong(v15);
                        String s6 = c4.S(v16);
                        String s7 = c4.S(v17);
                        String s8 = c4.S(v18);
                        String s9 = c4.S(v19);
                        String s10 = c4.S(v20);
                        String s11 = c4.S(v21);
                        String s12 = c4.S(v22);
                        int v33 = (int)c4.getLong(v23);
                        if(c4.isNull(v24)) {
                            v34 = v9;
                            integer0 = null;
                            v35 = v8;
                        }
                        else {
                            v35 = v8;
                            v34 = v9;
                            integer0 = (int)c4.getLong(v24);
                        }
                        H8.k k0 = new H8.k(s, s1, s2, s3, v28, v29, s4, v30, v31, s5, v32, s6, s7, s8, s9, s10, s11, s12, v33, integer0, c4.getLong(v25), c4.getLong(v26));
                        k0.a = c4.getLong(v27);
                        arrayList2.add(k0);
                        v8 = v35;
                        v9 = v34;
                    }
                }
                return arrayList2;
            }
            case 4: {
                try(G4.c c5 = ((a)object0).l0(this.b)) {
                    Iterator iterator5 = this.c.iterator();
                    for(int v36 = 1; true; ++v36) {
                        if(!iterator5.hasNext()) {
                            break;
                        }
                        Object object6 = iterator5.next();
                        c5.a(v36, ((long)(((Long)object6))));
                    }
                    int v37 = F.v(c5, "data");
                    int v38 = F.v(c5, "uri");
                    int v39 = F.v(c5, "display_name");
                    int v40 = F.v(c5, "song_id");
                    int v41 = F.v(c5, "match_stat");
                    int v42 = F.v(c5, "size");
                    int v43 = F.v(c5, "mime_type");
                    int v44 = F.v(c5, "date_added");
                    int v45 = F.v(c5, "date_modified");
                    int v46 = F.v(c5, "title");
                    int v47 = F.v(c5, "duration");
                    int v48 = F.v(c5, "artists");
                    int v49 = F.v(c5, "artist_ids");
                    int v50 = F.v(c5, "album");
                    int v51 = F.v(c5, "album_key");
                    int v52 = F.v(c5, "album_id");
                    int v53 = F.v(c5, "genre");
                    int v54 = F.v(c5, "genre_id");
                    int v55 = F.v(c5, "track");
                    int v56 = F.v(c5, "year");
                    int v57 = F.v(c5, "media_store_media_id");
                    int v58 = F.v(c5, "media_store_album_id");
                    int v59 = F.v(c5, "_id");
                    ArrayList arrayList3 = new ArrayList();
                    while(true) {
                        if(!c5.j0()) {
                            break;
                        }
                        String s13 = c5.S(v37);
                        String s14 = c5.S(v38);
                        String s15 = c5.S(v39);
                        String s16 = c5.S(v40);
                        int v60 = (int)c5.getLong(v41);
                        long v61 = c5.getLong(v42);
                        String s17 = c5.S(v43);
                        long v62 = c5.getLong(v44);
                        long v63 = c5.getLong(v45);
                        String s18 = c5.S(v46);
                        int v64 = (int)c5.getLong(v47);
                        String s19 = c5.S(v48);
                        String s20 = c5.S(v49);
                        String s21 = c5.S(v50);
                        String s22 = c5.S(v51);
                        String s23 = c5.S(v52);
                        String s24 = c5.S(v53);
                        String s25 = c5.S(v54);
                        int v65 = (int)c5.getLong(v55);
                        if(c5.isNull(v56)) {
                            v66 = v41;
                            integer1 = null;
                            v67 = v40;
                        }
                        else {
                            v67 = v40;
                            v66 = v41;
                            integer1 = (int)c5.getLong(v56);
                        }
                        H8.k k1 = new H8.k(s13, s14, s15, s16, v60, v61, s17, v62, v63, s18, v64, s19, s20, s21, s22, s23, s24, s25, v65, integer1, c5.getLong(v57), c5.getLong(v58));
                        k1.a = c5.getLong(v59);
                        arrayList3.add(k1);
                        v40 = v67;
                        v41 = v66;
                    }
                }
                return arrayList3;
            }
            case 5: {
                try(G4.c c6 = ((a)object0).l0(this.b)) {
                    Iterator iterator6 = this.c.iterator();
                    for(int v68 = 1; true; ++v68) {
                        if(!iterator6.hasNext()) {
                            break;
                        }
                        Object object7 = iterator6.next();
                        c6.e(v68, ((String)object7));
                    }
                    int v69 = F.v(c6, "data");
                    int v70 = F.v(c6, "uri");
                    int v71 = F.v(c6, "display_name");
                    int v72 = F.v(c6, "song_id");
                    int v73 = F.v(c6, "match_stat");
                    int v74 = F.v(c6, "size");
                    int v75 = F.v(c6, "mime_type");
                    int v76 = F.v(c6, "date_added");
                    int v77 = F.v(c6, "date_modified");
                    int v78 = F.v(c6, "title");
                    int v79 = F.v(c6, "duration");
                    int v80 = F.v(c6, "artists");
                    int v81 = F.v(c6, "artist_ids");
                    int v82 = F.v(c6, "album");
                    int v83 = F.v(c6, "album_key");
                    int v84 = F.v(c6, "album_id");
                    int v85 = F.v(c6, "genre");
                    int v86 = F.v(c6, "genre_id");
                    int v87 = F.v(c6, "track");
                    int v88 = F.v(c6, "year");
                    int v89 = F.v(c6, "media_store_media_id");
                    int v90 = F.v(c6, "media_store_album_id");
                    int v91 = F.v(c6, "_id");
                    ArrayList arrayList4 = new ArrayList();
                    while(true) {
                        if(!c6.j0()) {
                            break;
                        }
                        String s26 = c6.S(v69);
                        String s27 = c6.S(v70);
                        String s28 = c6.S(v71);
                        String s29 = c6.S(v72);
                        int v92 = (int)c6.getLong(v73);
                        long v93 = c6.getLong(v74);
                        String s30 = c6.S(v75);
                        long v94 = c6.getLong(v76);
                        long v95 = c6.getLong(v77);
                        String s31 = c6.S(v78);
                        int v96 = (int)c6.getLong(v79);
                        String s32 = c6.S(v80);
                        String s33 = c6.S(v81);
                        String s34 = c6.S(v82);
                        String s35 = c6.S(v83);
                        String s36 = c6.S(v84);
                        String s37 = c6.S(v85);
                        String s38 = c6.S(v86);
                        int v97 = (int)c6.getLong(v87);
                        if(c6.isNull(v88)) {
                            v98 = v73;
                            integer2 = null;
                            v99 = v72;
                        }
                        else {
                            v99 = v72;
                            v98 = v73;
                            integer2 = (int)c6.getLong(v88);
                        }
                        H8.k k2 = new H8.k(s26, s27, s28, s29, v92, v93, s30, v94, v95, s31, v96, s32, s33, s34, s35, s36, s37, s38, v97, integer2, c6.getLong(v89), c6.getLong(v90));
                        k2.a = c6.getLong(v91);
                        arrayList4.add(k2);
                        v72 = v99;
                        v73 = v98;
                    }
                }
                return arrayList4;
            }
            case 6: {
                try(G4.c c7 = ((a)object0).l0(this.b)) {
                    Iterator iterator7 = this.c.iterator();
                    for(int v100 = 1; true; ++v100) {
                        if(!iterator7.hasNext()) {
                            break;
                        }
                        Object object8 = iterator7.next();
                        c7.e(v100, ((String)object8));
                    }
                    ArrayList arrayList5 = new ArrayList();
                    while(true) {
                        if(!c7.j0()) {
                            break;
                        }
                        arrayList5.add(c7.getLong(0));
                    }
                }
                return arrayList5;
            }
            case 7: {
                try(G4.c c8 = ((a)object0).l0(this.b)) {
                    Iterator iterator8 = this.c.iterator();
                    for(int v101 = 1; true; ++v101) {
                        if(!iterator8.hasNext()) {
                            break;
                        }
                        Object object9 = iterator8.next();
                        c8.e(v101, ((String)object9));
                    }
                    ArrayList arrayList6 = new ArrayList();
                    while(true) {
                        if(!c8.j0()) {
                            break;
                        }
                        u u0 = new u();
                        u0.a = c8.getLong(0);
                        String s39 = c8.S(1);
                        q.g(s39, "<set-?>");
                        u0.b = s39;
                        String s40 = c8.S(2);
                        q.g(s40, "<set-?>");
                        u0.c = s40;
                        u0.d = (int)c8.getLong(3);
                        String s41 = c8.S(4);
                        q.g(s41, "<set-?>");
                        u0.e = s41;
                        String s42 = c8.S(5);
                        q.g(s42, "<set-?>");
                        u0.f = s42;
                        String s43 = c8.S(6);
                        q.g(s43, "<set-?>");
                        u0.g = s43;
                        String s44 = c8.S(7);
                        q.g(s44, "<set-?>");
                        u0.h = s44;
                        String s45 = c8.S(8);
                        q.g(s45, "<set-?>");
                        u0.i = s45;
                        arrayList6.add(u0);
                    }
                }
                return arrayList6;
            }
            case 8: {
                try(G4.c c9 = ((a)object0).l0(this.b)) {
                    Iterator iterator9 = this.c.iterator();
                    for(int v102 = 1; true; ++v102) {
                        if(!iterator9.hasNext()) {
                            break;
                        }
                        Object object10 = iterator9.next();
                        c9.a(v102, ((long)(((Long)object10))));
                    }
                    c9.j0();
                }
                return null;
            }
            case 9: {
                try(G4.c c10 = ((a)object0).l0(this.b)) {
                    Iterator iterator10 = this.c.iterator();
                    for(int v103 = 1; true; ++v103) {
                        if(!iterator10.hasNext()) {
                            break;
                        }
                        Object object11 = iterator10.next();
                        c10.e(v103, ((String)object11));
                    }
                    ArrayList arrayList7 = new ArrayList();
                    while(true) {
                        if(!c10.j0()) {
                            break;
                        }
                        arrayList7.add(c10.getLong(0));
                    }
                }
                return arrayList7;
            }
            case 10: {
                try(G4.c c11 = ((a)object0).l0(this.b)) {
                    Iterator iterator11 = this.c.iterator();
                    for(int v104 = 1; true; ++v104) {
                        if(!iterator11.hasNext()) {
                            break;
                        }
                        Object object12 = iterator11.next();
                        c11.e(v104, ((String)object12));
                    }
                    c11.j0();
                }
                return null;
            }
            case 11: {
                try(G4.c c12 = ((a)object0).l0(this.b)) {
                    Iterator iterator12 = this.c.iterator();
                    for(int v105 = 1; true; ++v105) {
                        if(!iterator12.hasNext()) {
                            break;
                        }
                        Object object13 = iterator12.next();
                        c12.e(v105, ((String)object13));
                    }
                    int v106 = F.v(c12, "_id");
                    int v107 = F.v(c12, "audio_id");
                    int v108 = F.v(c12, "mime_type");
                    int v109 = F.v(c12, "data");
                    int v110 = F.v(c12, "uri");
                    int v111 = F.v(c12, "displayName");
                    int v112 = F.v(c12, "title");
                    int v113 = F.v(c12, "album_id");
                    int v114 = F.v(c12, "album");
                    int v115 = F.v(c12, "artist");
                    int v116 = F.v(c12, "artist_id");
                    int v117 = F.v(c12, "playlist_id");
                    int v118 = F.v(c12, "play_order");
                    int v119 = F.v(c12, "duration");
                    ArrayList arrayList8 = new ArrayList();
                    while(true) {
                        if(!c12.j0()) {
                            break;
                        }
                        arrayList8.add(new t(c12.getLong(v106), c12.getLong(v107), c12.S(v108), c12.S(v109), c12.S(v110), c12.S(v111), c12.S(v112), c12.S(v113), c12.S(v114), c12.S(v115), c12.S(v116), c12.getLong(v117), ((int)c12.getLong(v118)), ((int)c12.getLong(v119))));
                    }
                }
                return arrayList8;
            }
            case 12: {
                return this.d(object0);
            }
            case 13: {
                return this.e(object0);
            }
            default: {
                try(G4.c c0 = ((a)object0).l0(this.b)) {
                    Iterator iterator0 = this.c.iterator();
                    for(int v = 1; true; ++v) {
                        if(!iterator0.hasNext()) {
                            break;
                        }
                        Object object1 = iterator0.next();
                        c0.a(v, ((long)(((int)(((Integer)object1))))));
                    }
                    c0.j0();
                    return Q1.c.F(((a)object0));
                }
            }
        }
    }
}

