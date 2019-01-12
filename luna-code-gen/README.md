#luna-code-gen 介绍
> lluna-code-gen 代码自动生成

* 根据db表生成实体和DAO
* 生成service 层
* 支持分页


### Maven dependency

```
<dependency>
	<groupId>com.seezoon</groupId>
	<artifactId>luna-code-gen</artifactId>
	<version>${luna.version}</version>
	<scope>test</scope>
</dependency>
```

### 具体使用例子

[luna-code-gen-simple](https://github.com/734839030/luna/tree/master/luna-simples/luna-code-gen-simple)


```
package com.seezoon.code.gen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.seezoon.code.gen.service.CodeGenService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=CodeGenApplication.class)
public class CodeGenTest {

	@Autowired
	private CodeGenService codeGenService;
	@Test
	public void gen() throws Exception {
		//表明  和  代码路径
		codeGenService.gen("user","/Users/hdf/Downloads");
	}
}

```