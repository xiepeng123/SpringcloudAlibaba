package com.xp.cloud.domain;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * User: xp
 * Date: 2020/11/29
 * Time: 23:29
 * Description: No Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

  private Long id;
  private Long userId;
  private Long productId;
  private Integer count;
  private BigDecimal money;
  private Integer status;

}
