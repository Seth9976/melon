package security;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Properties;

public class Rijndael_Properties {
    static final String ALGORITHM = "Rijndael";
    private static final String[][] DEFAULT_PROPERTIES = null;
    static final String FULL_NAME = "Rijndael ver. 0.1";
    static final boolean GLOBAL_DEBUG = false;
    static final String NAME = "Rijndael_Properties";
    static final double VERSION = 0.1;
    static Class class$security$Rijndael_Properties;
    static final Properties properties;

    static {
        Properties properties0 = new Properties();
        Rijndael_Properties.properties = properties0;
        Rijndael_Properties.DEFAULT_PROPERTIES = new String[][]{new String[]{"Trace.Rijndael_Algorithm", "true"}, new String[]{"Debug.Level.*", "1"}, new String[]{"Debug.Level.Rijndael_Algorithm", "9"}};
        Class class0 = Rijndael_Properties.class$security$Rijndael_Properties;
        if(class0 == null) {
            class0 = Rijndael_Properties.class$("security.Rijndael_Properties");
            Rijndael_Properties.class$security$Rijndael_Properties = class0;
        }
        InputStream inputStream0 = class0.getResourceAsStream("Rijndael.properties");
        boolean z = inputStream0 != null;
        if(z) {
            try {
                properties0.load(inputStream0);
                inputStream0.close();
            }
            catch(Exception unused_ex) {
                z = false;
            }
        }
        if(!z) {
            for(int v = 0; v < Rijndael_Properties.DEFAULT_PROPERTIES.length; ++v) {
                String[] arr_s = Rijndael_Properties.DEFAULT_PROPERTIES[v];
                Rijndael_Properties.properties.put(arr_s[0], arr_s[1]);
            }
        }
    }

    public static Class class$(String s) {
        try {
            return Class.forName(s);
        }
        catch(ClassNotFoundException classNotFoundException0) {
            throw new NoClassDefFoundError(classNotFoundException0.getMessage());
        }
    }

    public static int getLevel(String s) {
        String s1 = Rijndael_Properties.getProperty(("Debug.Level." + s));
        if(s1 == null) {
            s1 = Rijndael_Properties.getProperty("Debug.Level.*");
            if(s1 == null) {
                return 0;
            }
        }
        try {
            return Integer.parseInt(s1);
        }
        catch(NumberFormatException unused_ex) {
            return 0;
        }
    }

    public static PrintWriter getOutput() {
        String s = Rijndael_Properties.getProperty("Output");
        return s == null || !s.equals("out") ? new PrintWriter(System.err, true) : new PrintWriter(System.out, true);
    }

    public static String getProperty(String s) {
        return Rijndael_Properties.properties.getProperty(s);
    }

    public static String getProperty(String s, String s1) {
        return Rijndael_Properties.properties.getProperty(s, s1);
    }

    public static boolean isTraceable(String s) {
        String s1 = Rijndael_Properties.getProperty(("Trace." + s));
        return s1 == null ? false : new Boolean(s1).booleanValue();
    }

    public static void list(PrintStream printStream0) {
        Rijndael_Properties.list(new PrintWriter(printStream0, true));
    }

    public static void list(PrintWriter printWriter0) {
        printWriter0.println("#");
        printWriter0.println("# ----- Begin Rijndael properties -----");
        printWriter0.println("#");
        Enumeration enumeration0 = Rijndael_Properties.properties.propertyNames();
        while(enumeration0.hasMoreElements()) {
            String s = (String)enumeration0.nextElement();
            printWriter0.println(s + " = " + Rijndael_Properties.getProperty(s));
        }
        printWriter0.println("#");
        printWriter0.println("# ----- End Rijndael properties -----");
    }

    public static Enumeration propertyNames() {
        return Rijndael_Properties.properties.propertyNames();
    }
}

