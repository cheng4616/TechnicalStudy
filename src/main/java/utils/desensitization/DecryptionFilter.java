package utils.desensitization;

import java.lang.reflect.Field;

public class DecryptionFilter extends SimpleValueFilter {


    @Override
    public Object processAnnotaion(Field field, Object value) throws Exception {
        PartialDesensitization annotation = field.getAnnotation(PartialDesensitization.class);
        if (annotation == null) {
            return value;
        }

        String valueStr = (String) value;
        if (valueStr.length() == 0) {
            return value;
        }

        if (DesensitizationRuleUtil.needDecrypt(annotation.type())) {
            valueStr = DecryptionUtil.des3CBCDecrypt(valueStr);
        }

        return valueStr;
    }

    @Override
    public boolean needFilter(String name, Object value) {
        return value instanceof String;
    }

}
