package utils.desensitization;

public class AuthorityCheckUtil {

    public static boolean isContain(int authority, int type) {
        return (type & authority) == type;
    }

    public static boolean notContain(int authority, int type) {
        return (type & authority) != type;
    }

}
