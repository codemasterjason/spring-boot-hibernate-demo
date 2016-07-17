package com.jasonpark.demo.domain;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Jason Park
 * @since v
 */
@Entity
@Table(name = "citizen", schema = "demo", catalog = "")
public class CitizenEntity {
  private long id;
  private String name;
  private Timestamp createdAt;
  private Timestamp updatedAt;
  private long version;
  private EmotionEntity emotionByEmotionId;

  public void setId(Long id) {
    this.id = id;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  @Id
  @Column(name = "id", nullable = false)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Basic
  @Column(name = "name", nullable = false, length = 255)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(name = "created_at", nullable = false)
  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  @Basic
  @Column(name = "updated_at", nullable = false)
  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Basic
  @Column(name = "version", nullable = false)
  public long getVersion() {
    return version;
  }

  public void setVersion(long version) {
    this.version = version;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CitizenEntity that = (CitizenEntity) o;

    if (id != that.id) return false;
    if (version != that.version) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null)
      return false;
    if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
    result = 31 * result + (int) (version ^ (version >>> 32));
    return result;
  }

  @ManyToOne
  @JoinColumn(name = "emotion_id", referencedColumnName = "id", nullable = false)
  public EmotionEntity getEmotionByEmotionId() {
    return emotionByEmotionId;
  }

  public void setEmotionByEmotionId(EmotionEntity emotionByEmotionId) {
    this.emotionByEmotionId = emotionByEmotionId;
  }
}
