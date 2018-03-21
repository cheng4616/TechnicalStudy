package utils.desensitization;

public class DesensitizationRuleUtil {

    private static int DECRYPTION_FIELDS = DesensitizationTypeEnum.USERNAME.getValue() | DesensitizationTypeEnum.IDCARDNO.getValue()
            | DesensitizationTypeEnum.PHONENO.getValue() | DesensitizationTypeEnum.BANKCARDNO.getValue() | DesensitizationTypeEnum.ACCOUNTNO.getValue()
            | DesensitizationTypeEnum.IDVALIDDATE.getValue();

    public static boolean needDecrypt(DesensitizationTypeEnum type) {
        return AuthorityCheckUtil.isContain(DesensitizationRuleUtil.DECRYPTION_FIELDS, type.getValue());
    }

    public static void setDesensitizationRule(int rule) {
        DECRYPTION_FIELDS = rule;
    }

}
