package testRunner;
//
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface CucumberOptions {
 boolean dryRun() default false;

 boolean strict() default false;

 String[] features() default {};

 String[] glue() default {};

 String[] extraGlue() default {};

 String[] tags() default {};

 String[] plugin() default {};

 boolean monochrome() default false;

 String[] name() default {};

 String[] junit() default {};
}
