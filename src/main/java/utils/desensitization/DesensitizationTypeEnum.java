package utils.desensitization;

public enum DesensitizationTypeEnum {

    /**
     * 脱敏中间字符
     */
    NORMAL(1, "NORMAL"),
    /**
     * 银行卡号
     */
    BANKCARDNO(2, "BANKCARDNO"),
    /**
     * 手机号
     */
    PHONENO(4, "PHONENO"),
    /**
     * 身份证号
     */
    IDCARDNO(8, "IDCARDNO"),
    /**
     * 姓名/户名
     */
    USERNAME(16, "USERNAME"),
    /**
     * 支付账户号码
     */
    ACCOUNTNO(32, "ACCOUNTNO"),
    /**
     * 支付账户余额
     */
    BALANCE(64, "BALANCE"),
    /**
     * 身份证有效期
     */
    IDVALIDDATE(128, "IDVALIDDATE"),
    /**
     * 地址
     */
    ADDRESS(256, "ADDRESS"),
    /**
     * 固话
     */
    TELEPHONENO(512, "TELEPHONENO"),
    /**
     * 电子邮箱
     */
    EMAIL(1024, "EMAIL"),
    /**
     * cvn2
     */
    CVN2(2048, "CVN2"),
    /**
     * 有效期
     */
    VALIDDATE(4096, "VALIDDATE");

    private int value;
    private String name;

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    DesensitizationTypeEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static DesensitizationTypeEnum getDesensitizationTypeByName(String name) {
        try {
            return Enum.valueOf(DesensitizationTypeEnum.class, name);
        } catch (Exception e) {
            return null;
        }
    }

    public static int getDesensitizationValueByName(String name) {
        return Enum.valueOf(DesensitizationTypeEnum.class, name).getValue();
    }


}
