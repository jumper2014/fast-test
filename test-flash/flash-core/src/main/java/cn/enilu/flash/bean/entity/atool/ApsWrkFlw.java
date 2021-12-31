package cn.enilu.flash.bean.entity.atool;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * aps work flow config
 */
@Entity
@Table(name = "aps_wrk_flw")
@Data
public class ApsWrkFlw implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * aps workflow Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flow_id", nullable = false)
    private Integer flowId;

    /**
     * Workflow description
     */
    @Column(name = "flow_desc", nullable = false)
    private String flowDesc;

    /**
     * work flow aduit node step numbers, it is equal to the total number of aps flow step
     */
    @Column(name = "step_count")
    private Integer stepCount;

    /**
     * work flow status, C:Created E:Enabled D:Disabled
     */
    @Column(name = "flow_status")
    private String flowStatus;

    /**
     * The business system originating the change reques
     */
    @Column(name = "biz_sys_id", nullable = false)
    private String bizSysId;

    /**
     * work flow audit type
     */
    @Column(name = "biz_type", nullable = false)
    private String bizType;

    /**
     * Null value-Manual review, Positive value-Max number of hours to pend, 0-Immediate auto review, -1-By the end of day of submission
     */
    @Column(name = "max_pend_mins")
    private Integer maxPendMins;

    /**
     * Null value-Manual review, A-Approved, R-Rejected
     */
    @Column(name = "default_result")
    private String defaultResult;

    /**
     * data operation version, default 0
     */
    @Column(name = "version")
    private Integer version;

    @Column(name = "insert_by")
    private String insertBy;

    /**
     * create time
     */
    @Column(name = "insert_timestamp")
    private LocalDateTime insertTimestamp;

    @Column(name = "last_update_by")
    private String lastUpdateBy;

    /**
     * modify time
     */
    @Column(name = "last_update_timestamp")
    private LocalDateTime lastUpdateTimestamp;

    /**
     * business module name
     */
    @Column(name = "biz_type_name")
    private String bizTypeName;

    /**
     * due day setup method R：Rule,N：Node
     */
    @Column(name = "due_day_setup_method")
    private String dueDaySetupMethod;

    /**
     * work flow customer or standard C：Customer,S：Standard
     */
    @Column(name = "wrk_customer_flag")
    private String wrkCustomerFlag;

    /**
     * effective method
     */
    @Column(name = "effective_method")
    private String effectiveMethod;

    /**
     * reminder email
     */
    @Column(name = "reminder_email")
    private String reminderEmail;

    /**
     * business module Chinese name
     */
    @Column(name = "biz_type_name_zh")
    private String bizTypeNameZh;

    /**
     * work flow change mode support 0:only PR 0-Support change mode;
     */
    @Column(name = "mode_change_support")
    private Integer modeChangeSupport;

    @Column(name = "ofln_flag")
    private Integer oflnFlag;

}
