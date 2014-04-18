package com.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * User: Anish
 * Date: 3/8/14
 * Time: 8:54 AM
 */
@MappedSuperclass
public abstract class BaseDto implements Serializable {
    private Long id;
    private Long optimisticLock;
    private String lastUpDatedBy;
    private Date lastUpdatedTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "OPTIMISTIC_LOCK")
    @Version
    public Long getOptimisticLock() {
        return optimisticLock;
    }

    public void setOptimisticLock(Long optimisticLock) {
        this.optimisticLock = optimisticLock;
    }

    @Column(name = "LAST_UPDATED_BY")
    public String getLastUpDatedBy() {
        return lastUpDatedBy;
    }

    public void setLastUpDatedBy(String lastUpDatedBy) {
        this.lastUpDatedBy = lastUpDatedBy;
    }

    @Column(name = "LAST_UPDATED_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    @PrePersist
    @PreUpdate
    public void onSaveOrUpdate(){
        setLastUpdatedTime(Calendar.getInstance().getTime());
    }
}
