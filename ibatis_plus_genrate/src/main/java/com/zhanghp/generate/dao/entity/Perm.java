package com.zhanghp.generate.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 功能权限表
 * </p>
 *
 * @author zhanghp
 * @since 2022-07-29
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("perm")
public class Perm extends Model<Perm> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父组Id(0表示根组)
     */
    @TableField("parentId")
    private Integer parentId;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 路径
     */
    @TableField("path")
    private String path;

    /**
     * 代码
     */
    @TableField("code")
    private String code;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 功能(definitiontype主键)
     */
    @TableField("menuType")
    private Integer menuType;

    /**
     * 系统(definitiontype主键)
     */
    @TableField("systemType")
    private Integer systemType;

    /**
     * 样式
     */
    @TableField("style")
    private String style;

    /**
     * 备注
     */
    @TableField("remarks")
    private String remarks;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private Date createTime;

    /**
     * 图标路径
     */
    @TableField("iconPath")
    private String iconPath;

    /**
     * 开关：0：开 1:关
     */
    @TableField("switchOperation")
    private Integer switchOperation;


    public static final String ID = "id";

    public static final String PARENTID = "parentId";

    public static final String NAME = "name";

    public static final String PATH = "path";

    public static final String CODE = "code";

    public static final String SORT = "sort";

    public static final String MENUTYPE = "menuType";

    public static final String SYSTEMTYPE = "systemType";

    public static final String STYLE = "style";

    public static final String REMARKS = "remarks";

    public static final String CREATETIME = "createTime";

    public static final String ICONPATH = "iconPath";

    public static final String SWITCHOPERATION = "switchOperation";

    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
