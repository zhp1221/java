package com.zhanghp.generate.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhanghp
 * @since 2023-06-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("test")
@ToString
public class Test extends Model<Test> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Integer id;

    @TableField("time")
    private Long time;

    @TableField("name")
    private String name;


    public static final String ID = "id";

    public static final String TIME = "time";

    public static final String NAME = "name";

    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
