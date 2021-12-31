package cn.enilu.flash.bean.entity.atool;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "tb_user")
@Table(appliesTo = "tb_user", comment = "用户表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class TbUser  {
    @Id
    @NotNull(message = "不能为空")
    private Integer userId;
    @Column(columnDefinition = "VARCHAR(45)")
    @NotBlank(message = "不能为空")
    private String userName;
}
