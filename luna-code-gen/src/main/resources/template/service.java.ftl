package com.seezoon.modules.${moduleName}.service;

import org.springframework.stereotype.Service;
import com.seezoon.luna.service.CrudService;
import com.seezoon.modules.${moduleName}.dao.${className}Dao;
import com.seezoon.modules.${moduleName}.entity.${className};

/**
 * ${tableComment!}Service
 * Copyright &copy; 2018 powered by huangdf, All rights reserved.
 * @author hdf ${.now}
 */
@Service
public class ${className}Service extends CrudService<${className}Dao, ${className}>{

}
