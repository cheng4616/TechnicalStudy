package utils.desensitization;

import java.lang.annotation.*;

@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PartialDesensitization {

    int prefix() default -1;

    int suffix() default -1;

    DesensitizationTypeEnum type();
}
