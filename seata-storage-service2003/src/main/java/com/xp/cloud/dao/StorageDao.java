package com.xp.cloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.jmx.export.annotation.ManagedAttribute;

/**
 * Created with IntelliJ IDEA.
 * User: xp
 * Date: 2020/12/2
 * Time: 23:20
 * Description: No Description
 */
@Mapper
public interface StorageDao {

  void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}
