package utils.desensitization;

import com.alibaba.fastjson.serializer.ValueFilter;

import java.lang.reflect.Field;

public abstract class SimpleValueFilter implements ValueFilter {


    @Override
    public Object process(Object object, String name, Object value) {
        try {
            if (!needFilter(name, value)) {
                return value;
            }

            Field field = object.getClass().getDeclaredField(name);
            return processAnnotaion(field, value);
        } catch (NoSuchFieldException e) {
            Class<?> superClass = object.getClass().getSuperclass();
            while (superClass != null && superClass != Object.class) {
                try {
                    Field field = superClass.getDeclaredField(name);
                    return processAnnotaion(field, value);
                } catch (NoSuchFieldException e1) {
                    superClass = superClass.getSuperclass();
                } catch (Exception e1) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

        return value;
    }

    public boolean needFilter(String name, Object value) {
        return true;
    }

    public abstract Object processAnnotaion(Field field, Object value) throws Exception;

}
