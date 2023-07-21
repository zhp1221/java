package com.zhanghp.generate.model.ro;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
* <p>
* RO
* </p>
*
* @author zhanghp
* @since 2023-06-21
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "TestURO对象", description = "")
public class TestRO {

    @ApiModelProperty(value = "")
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "")
    private Long time;

    @ApiModelProperty(value = "")
    private String name;

}