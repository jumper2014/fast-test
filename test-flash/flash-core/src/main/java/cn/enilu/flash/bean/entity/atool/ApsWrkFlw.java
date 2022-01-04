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
     * Null value-Manual review, A-Approved, R-Rejected
     */
    @Column(name = "default_result")
    private String defaultResult;




}
