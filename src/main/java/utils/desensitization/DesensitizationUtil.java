package utils.desensitization;

import org.apache.commons.lang3.StringUtils;

public class DesensitizationUtil {


    private static final String STAR4 = "****";
    private static final String STAR2 = "**";
    private static final String STAR1 = "*";

    /**
     * <p>按脱敏类型进行属性脱敏</p>
     *
     * @param origStr
     * @param type
     * @return
     * @author Administrator
     * @date 2017年6月15日 上午11:12:11
     */
    public static String desensitize(String origStr, DesensitizationTypeEnum type) {
        if (origStr == null || origStr.length() == 0) {
            return origStr;
        }

        if (type == null) {
            return STAR4;
        }

        switch (type) {
            case BANKCARDNO:
                if (origStr.length() > 10) {
                    return desensitize(origStr, 4, 4);
                } else if (origStr.length() > 4) {
                    return desensitizeBack(origStr, 4, STAR4);
                } else {
                    return desensitizeBack(origStr, 1, STAR2);
                }
            case PHONENO:
                if (origStr.length() == 11) {
                    return desensitize(origStr, 3, 4);
                } else if (origStr.length() > 3) {
                    return desensitizeBack(origStr, 3, STAR4);
                } else {
                    return desensitizeBack(origStr, 1, STAR2);
                }
            case IDCARDNO:
                if (origStr.length() > 4) {
                    return desensitize(origStr, 2, 2);
                } else {
                    return desensitizeBack(origStr, 1, STAR2);
                }
            case IDVALIDDATE:
                if (origStr.length() > 4) {
                    return desensitize(origStr, 2, 2);
                } else {
                    return desensitizeBack(origStr, 1, STAR2);
                }
            case USERNAME:
                if (origStr.length() <= 4) {
                    return desensitizeBack(origStr, 1, STAR2);
                } else {
                    return desensitizeBack(origStr, 4, STAR4);
                }
            case ACCOUNTNO:
                if (origStr.length() > 4) {
                    return desensitize(origStr, 2, 2);
                } else {
                    return desensitizeBack(origStr, 1, STAR2);
                }
            case BALANCE:
                return STAR4;
            case ADDRESS:
                if (origStr.length() > 4) {
                    return desensitizeBack(origStr, 4, STAR4);
                } else {
                    return desensitizeBack(origStr, 1, STAR2);
                }
            case TELEPHONENO:
                return desensitizeFront(origStr, 4, STAR4);
            case EMAIL:
                String[] splitEmail = origStr.split("@");
                if (splitEmail.length > 1) {
                    return desensitizeBack(splitEmail[0], 1, STAR4).concat("@").concat(splitEmail[1]);
                } else {
                    return STAR4;
                }
            case CVN2:
                return "***";
            case VALIDDATE:
                return "********";
            default:
                return StringUtils.repeat(STAR1, origStr.length());
        }
    }

    /**
     * <p>按前后保留的明文位数进行脱敏</p>
     *
     * @param origStr
     * @param prefix
     * @param suffix
     * @return
     * @author Administrator
     * @date 2017年6月15日 上午11:12:31
     */
    public static String desensitize(String origStr, int prefix, int suffix) {
        if (origStr == null || origStr.length() == 0) {
            return origStr;
        }

        if ((prefix != 0 || suffix != 0) && origStr.length() > prefix + suffix) {
            return StringUtils.left(origStr, prefix).concat(STAR4).concat(StringUtils.right(origStr, suffix));
        } else {
            return STAR4;
        }
    }

    /**
     * <p>脱敏字符串尾部</p>
     *
     * @param origStr 源字符串
     * @param prefix  首部多少位明文
     * @param desStr  尾部脱敏字符串
     * @return
     * @author Administrator
     * @date 2017年6月15日 上午11:13:13
     */
    public static String desensitizeBack(String origStr, int prefix, String desStr) {
        if (origStr == null || origStr.length() == 0) {
            return origStr;
        }

        if (origStr.length() > prefix) {
            return StringUtils.left(origStr, prefix).concat(desStr);
        } else {
            return STAR4;
        }
    }

    /**
     * <p>脱敏字符串头部</p>
     *
     * @param origStr 源字符串
     * @param suffix  尾部多少位明文
     * @param desStr  首部脱敏字符串
     * @return
     * @author Administrator
     * @date 2017年6月15日 上午11:13:37
     */
    public static String desensitizeFront(String origStr, int suffix, String desStr) {
        if (origStr == null || origStr.length() == 0) {
            return origStr;
        }

        if (origStr.length() > suffix) {
            return desStr.concat(StringUtils.right(origStr, suffix));
        } else {
            return STAR4;
        }
    }

    public static String processTransparentDesensitization() {
        return STAR4;
    }

}
