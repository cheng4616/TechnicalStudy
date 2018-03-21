package utils.desensitization;

import java.lang.reflect.Field;

public class DesensitizationFilter extends SimpleValueFilter {
    @Override
    public Object processAnnotaion(Field field, Object value) throws Exception {
        PartialDesensitization annotation = field.getAnnotation(PartialDesensitization.class);
        if (annotation == null) {
            return value;
        }

        String valueStr = value.toString();
        if (valueStr.length() == 0) {
            return value;
        }

        if (annotation.prefix() >= 0 && annotation.suffix() >= 0) {
            return DesensitizationUtil.desensitize(valueStr, annotation.prefix(), annotation.suffix());
        } else {
            return DesensitizationUtil.desensitize(valueStr, annotation.type());
        }
    }

    @Override
    public boolean needFilter(String name, Object value) {
        return value instanceof String || value instanceof Long;
    }

}
