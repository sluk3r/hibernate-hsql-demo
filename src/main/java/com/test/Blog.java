package com.test;
 
import java.util.Date;
 
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
 
@Entity
public class Blog {
 
  private Long id;
 
  private String subject;
 
  private String body;
 
  private Date createdAt;
 
  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }
 
  public void setId(Long id) {
    this.id = id;
  }
 
  public String getSubject() {
    return subject;
  }
 
  public void setSubject(String subject) {
    this.subject = subject;
  }
 
  public String getBody() {
    return body;
  }
 
  public void setBody(String body) {
    this.body = body;
  }
 
  public Date getCreatedAt() {
    return createdAt;
  }
 
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }
}