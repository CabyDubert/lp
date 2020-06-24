package com.lp.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("dict_unit")
public class Unit implements java.io.Serializable {
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    private String code;
    private String name;
    @TableField(value = "is_enable")
    private Boolean isEnable;
    /**
     * 创建时间
     */
    private Date ct;
    /**
     * 修改时间
     */
    private Date mt;
}
