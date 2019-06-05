package com.mall.concurrency.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 课程里用来标记【不推荐】的类或写法
 */
@Target(ElementType.TYPE)//注解作用的目标
@Retention(RetentionPolicy.SOURCE)//注解存在的范围
public @interface NotRecommend {
    String value() default "";
}
