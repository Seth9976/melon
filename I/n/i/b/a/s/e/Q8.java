package i.n.i.b.a.s.e;

public final class q8 {
    public final int a;

    public q8(int v) {
        this.a = v;
        super();
    }

    public final r8 a(int v, byte[] arr_b) {
        switch(this.a) {
            case 0: {
                if(v < 7) {
                    return null;
                }
                String s = new String(arr_b).trim();
                return !s.contains("#EXTM3U") && !s.contains("#EXTINF") ? null : new r8(null, "application/x-mpegURL", 0.5f, true);
            }
            case 1: {
                if(v < 4) {
                    return null;
                }
                String s1 = new String(arr_b);
                return !s1.contains("<MPD") && (!s1.contains("<") || !s1.contains(":MPD")) ? null : new r8(null, "application/dash+xml", 0.5f, true);
            }
            default: {
                if(v >= 0 && v >= 22) {
                    try {
                        if(new String(arr_b, b9.c).contains("SmoothStreamingMedia") || new String(arr_b, b9.e).contains("SmoothStreamingMedia")) {
                            return new r8(null, "application/vnd.ms-sstr+xml", 0.5f, true);
                        }
                    }
                    catch(Exception unused_ex) {
                    }
                    return null;
                }
                return null;
            }
        }
    }
}

