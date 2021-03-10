package mycom.annotation;

import java.lang.annotation.Documented;

/**
 * Created by 20013649 on 2020/7/3.
 */
@Documented
public @interface ClassPreamble {
    String author();
    String date();
    int currentRevision() default 1;
    String lastModified() default "N/A";
    String lastModifiedBy() default "N/A";
    String[] reviewers();
}
