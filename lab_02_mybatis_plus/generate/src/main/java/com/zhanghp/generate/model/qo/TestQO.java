package com.zhanghp.generate.model.qo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import com.zhanghp.common.model.PageParent;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
* <p>
* QO
* </p>
*
* @author zhanghp
* @since 2023-06-21
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "TestQO对象", description = "")
public class TestQO extends PageParent{

    @ApiModelProperty(value = "主键集合")
    private List<Long> idList;
    @ApiModelProperty(value = "")
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "")
    private Long time;

    @ApiModelProperty(value = "")
    private String name;

}