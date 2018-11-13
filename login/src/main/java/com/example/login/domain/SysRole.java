package com.example.login.domain;

import com.example.login.domain.SysMenu;
import com.example.login.domain.SysUser;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 角色
 */
@Entity
@Data
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
public class SysRole implements Serializable {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
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
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateDate;


    @ManyToMany(mappedBy = "roles")
    private List<SysUser> users = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "sys_role_menu",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "menu_id", referencedColumnName = "id"))
    private List<SysMenu> menus = new ArrayList<>();


    @Override
    public String toString() {
        return "SysRole{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", remark='" + remark + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createDate=" + createDate +
                ", updateBy='" + updateBy + '\'' +
                ", updateDate=" + updateDate +
                '}';
    }
}
