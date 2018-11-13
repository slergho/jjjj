package com.example.login.dto;

import com.example.login.Date2LongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.Date;

@Data
public class RoleDto {
    private String id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String remark;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createDate;

    private String menuIds;

    @Override
    public String toString() {
        return "RoleDto{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", remark='" + remark + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createDate=" + createDate +
                ", menuIds='" + menuIds + '\'' +
                '}';
    }
}
