package com.zzz.simplespringboot.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/1 11:26 AM
 **/
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[0];
    }
}
