package f1;

public final class i {
    public final int a;

    public i(int v) {
        this.a = v;
    }

    public static String a(int v) {
        switch(v) {
            case -1: {
                return "Unspecified";
            }
            case 0: {
                return "None";
            }
            case 1: {
                return "Default";
            }
            case 2: {
                return "Go";
            }
            case 3: {
                return "Search";
            }
            case 4: {
                return "Send";
            }
            case 5: {
                return "Previous";
            }
            case 6: {
                return "Next";
            }
            case 7: {
                return "Done";
            }
            default: {
                return "Invalid";
            }
        }
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof i && this.a == ((i)object0).a;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return i.a(this.a);
    }
}

