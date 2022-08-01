package com.zhanghp.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: zhanghp
 * @date: 2022-06-24 19:08
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "分页数据类")
public class MsgVO {

    @ApiModelProperty(value = "符合查询条件记录的总数量")
    private Long total;

    @ApiModelProperty(value = "符合查询条件的记录数")
    private Object datas;

}
