package com.zhanghp.generate.model.qo;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import com.zhanghp.common.model.PageParent;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
* <p>
* 标签QO
* </p>
*
* @author zhanghp
* @since 2022-08-09
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "LabelQO对象", description = "标签")
public class LabelQO extends PageParent{

    @ApiModelProperty(value = "主键集合")
    private List<Long> idList;
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "排序字段")
    private Integer sort;

}