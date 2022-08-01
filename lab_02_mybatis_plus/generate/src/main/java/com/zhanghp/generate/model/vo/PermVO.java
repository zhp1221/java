package com.zhanghp.generate.model.vo;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
* <p>
* 功能权限表VO
* </p>
*
* @author zhanghp
* @since 2022-07-29
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "PermVO对象", description = "功能权限表")
public class PermVO {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "父组Id(0表示根组)")
    private Integer parentId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "路径")
    private String path;

    @ApiModelProperty(value = "代码")
    private String code;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "功能(definitiontype主键)")
    private Integer menuType;

    @ApiModelProperty(value = "系统(definitiontype主键)")
    private Integer systemType;

    @ApiModelProperty(value = "样式")
    private String style;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "图标路径")
    private String iconPath;

    @ApiModelProperty(value = "开关：0：开 1:关")
    private Integer switchOperation;

}