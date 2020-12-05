package com.xp.cloud.dao;

import java.math.BigDecimal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 * User: xp
 * Date: 2020/12/2
 * Time: 23:33
 * Description: No Description
 */
@Mapper
public interface AccountDao {

  void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
