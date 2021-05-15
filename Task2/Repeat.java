package HomeWork12.Task2;

import java.lang.annotation.*;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Repeat {
    int value() default 1;
}