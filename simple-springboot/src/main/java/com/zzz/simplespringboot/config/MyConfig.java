package com.zzz.simplespringboot.config;

import org.springframework.context.annotation.Import;

/**
 *
 * @author zhangtianyu
 * @date 2022/2/1 11:26 AM
 **/
//@Configuration
@Import(MyImportSelector.class)
public class MyConfig {
}
