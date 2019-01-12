<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.seezoon.modules.${moduleName}.dao.${className}Dao" >
  <resultMap id="BaseResultMap" type="com.seezoon.modules.${moduleName}.entity.${className}" >
<#list columns as columnInfo>
    <${(columnInfo.columnKey == "PRI") ? string("id","result")} column="${columnInfo.name}" property="${columnInfo.javaFieldName}" jdbcType="${columnInfo.jdbcType}" />
</#list>
  </resultMap>
  
  <sql id="Base_Column_List" >
  <#assign notFirst = false>
  <#list columns as columnInfo><#if columnInfo.jdbcType !='LONGVARCHAR'><#if notFirst>,</#if>${columnInfo.name}<#assign notFirst = true></#if></#list>
  </sql>
  <#if hasBlob>
  <sql id="Blob_Column_List" >
  <#assign notFirst = false>
  <#list columns as columnInfo><#if columnInfo.jdbcType =='LONGVARCHAR'><#if notFirst>,</#if>${columnInfo.name}<#assign notFirst = true></#if></#list>
  </sql>
  </#if>
  <select id="selectByPrimaryKey" resultMap="BaseResultMap" parameterType="${pkJavaType}" >
    select 
    <include refid="Base_Column_List" />
    <#if hasBlob>
    ,<include refid="Blob_Column_List" />
    </#if>
    from ${tableName}
    where 
     	<#assign notFirst = false>
    	<#list pks as pk>
    	<#if notFirst>AND</#if> ${pk.columnName} =  ${"#"}{${pk.javaFieldName}}
    	<#assign notFirst = true>
   	 	</#list>
  </select>
  <select id="findList" resultMap="BaseResultMap" parameterType="com.seezoon.modules.${moduleName}.entity.${className}" >
    select 
    <include refid="Base_Column_List" />
    from ${tableName}
    <where>
    	<#list columns as columnInfo>
    		<if test="${(columnInfo.javaType == "String")?string("${columnInfo.javaFieldName} !=null and ${columnInfo.javaFieldName}!=''","${columnInfo.javaFieldName} !=null")}">
    		AND ${columnInfo.name} =  ${"#"}{${columnInfo.javaFieldName}}
    		</if>
   	 	</#list>
    </where>
	<choose>
    <when test="sortField != null and sortField != '' and direction != null and direction !=''">
    order by ${r'${sortField} ${direction}'}
    </when>
    <otherwise>
   	<!-- 默认排序设置 -->
   		<#list columns as columnInfo>
   			<#if columnInfo.name== "create_date" >
  				order by create_date desc
   			</#if>
   	 	</#list>
    </otherwise>
    </choose>
  </select>
  <delete id="deleteByPrimaryKey" >
    delete from ${tableName}
   where 
     	<#assign notFirst = false>
    	<#list pks as pk>
    	<#if notFirst>AND</#if> ${pk.columnName} =  ${"#"}{${pk.javaFieldName}}
    	<#assign notFirst = true>
   	 	</#list>
  </delete>
  <#assign notFirst = false>
  <insert id="insert" parameterType="com.seezoon.modules.${moduleName}.entity.${className}" >
    insert into ${tableName} (<#list columns as columnInfo><#if columnInfo.insert! ="1"><#if notFirst>,</#if>${columnInfo.name}<#assign notFirst = true></#if></#list>)
    <#assign notFirst = false>
    values (<#list columns as columnInfo><#if columnInfo.insert! ="1"><#if notFirst>,</#if>${"#"}{${columnInfo.javaFieldName}}<#assign notFirst = true></#if></#list>)
  </insert>
  <update id="updateByPrimaryKeySelective" parameterType="com.seezoon.modules.${moduleName}.entity.${className}" >
    update ${tableName}
    <set>
      <#list columns as columnInfo>
      <#if columnInfo.update! ="1">
      <if test="${columnInfo.javaFieldName} != null" >
        ${columnInfo.name} = ${"#"}{${columnInfo.javaFieldName}},
      </if>
      </#if>
      </#list>
    </set>
   where 
     	<#assign notFirst = false>
    	<#list pks as pk>
    	<#if notFirst>AND</#if> ${pk.columnName} =  ${"#"}{${pk.javaFieldName}}
    	<#assign notFirst = true>
   	 	</#list>
  </update>
  <update id="updateByPrimaryKey" parameterType="com.seezoon.modules.${moduleName}.entity.${className}" >
    update ${tableName}
    set 
    	<#assign notFirst = false>
      <#list columns as columnInfo>
      <#if columnInfo.update! ="1">
        <#if notFirst>,</#if>${columnInfo.name} = ${"#"}{${columnInfo.javaFieldName}}<#assign notFirst = true>
      </#if>
      </#list>
    where 
     	<#assign notFirst = false>
    	<#list pks as pk>
    	<#if notFirst>AND</#if> ${pk.columnName} =  ${"#"}{${pk.javaFieldName}}
    	<#assign notFirst = true>
   	 	</#list>
  </update>
</mapper>