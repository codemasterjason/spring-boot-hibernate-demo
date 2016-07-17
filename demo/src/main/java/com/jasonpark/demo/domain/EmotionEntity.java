package com.jasonpark.demo.domain;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Jason Park
 * @since v
 */
@Entity
@Table(name = "emotion", schema = "demo", catalog = "")
public class EmotionEntity {
  private long id;
  private int happy;
  private int sad;
  private int angry;
  private Timestamp createdAt;
  private Timestamp updatedAt;
  private long version;
  private Collection<CitizenEntity> citizensById;

  public void setId(Long id) {
    this.id = id;
  }

  public void setHappy(Integer happy) {
    this.happy = happy;
  }

  public void setSad(Integer sad) {
    this.sad = sad;
  }

  public void setAngry(Integer angry) {
    this.angry = angry;
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
  @Column(name = "happy", nullable = false)
  public int getHappy() {
    return happy;
  }

  public void setHappy(int happy) {
    this.happy = happy;
  }

  @Basic
  @Column(name = "sad", nullable = false)
  public int getSad() {
    return sad;
  }

  public void setSad(int sad) {
    this.sad = sad;
  }

  @Basic
  @Column(name = "angry", nullable = false)
  public int getAngry() {
    return angry;
  }

  public void setAngry(int angry) {
    this.angry = angry;
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

    EmotionEntity that = (EmotionEntity) o;

    if (id != that.id) return false;
    if (happy != that.happy) return false;
    if (sad != that.sad) return false;
    if (angry != that.angry) return false;
    if (version != that.version) return false;
    if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null)
      return false;
    if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + happy;
    result = 31 * result + sad;
    result = 31 * result + angry;
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
    result = 31 * result + (int) (version ^ (version >>> 32));
    return result;
  }

  @OneToMany(mappedBy = "emotionByEmotionId")
  public Collection<CitizenEntity> getCitizensById() {
    return citizensById;
  }

  public void setCitizensById(Collection<CitizenEntity> citizensById) {
    this.citizensById = citizensById;
  }
}
