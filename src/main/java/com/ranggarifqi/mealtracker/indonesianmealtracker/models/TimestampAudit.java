package com.ranggarifqi.mealtracker.indonesianmealtracker.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@MappedSuperclass
public class TimestampAudit {
  @Column(name = "`createdAt`", nullable = false)
  @CreatedDate
  private Date createdAt;

  @Column(name = "`updatedAt`", nullable = true)
  @LastModifiedDate
  private Date updatedAt;

  public TimestampAudit() {
  }

  public TimestampAudit(Date createdAt, Date updatedAt) {
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }
}
