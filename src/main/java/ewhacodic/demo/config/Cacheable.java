package ewhacodic.demo.config;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
public @interface Cacheable {
    @AliasFor("cacheName")
    String value() default "";

    @AliasFor("value")
    String cacheName() default "";
}
