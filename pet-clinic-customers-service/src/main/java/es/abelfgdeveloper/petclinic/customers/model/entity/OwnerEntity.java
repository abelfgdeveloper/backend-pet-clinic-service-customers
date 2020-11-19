package es.abelfgdeveloper.petclinic.customers.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(
    name = "owners",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"identification_document"})})
public class OwnerEntity {

  @Id
  @Column(name = "id", nullable = false)
  private String id;

  @Column(name = "identification_document", nullable = false)
  private String identificationDocument;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "telephone")
  private String telephone;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "audit_create_at", nullable = false)
  private LocalDateTime auditCreateAt;

  @Column(name = "audit_update_at", nullable = false)
  private LocalDateTime auditUpdateAt;

  @Column(name = "is_deleted", nullable = false)
  private boolean deleted;

  @PrePersist
  private void prePersist() {
    this.id = UUID.randomUUID().toString();
    this.auditCreateAt = LocalDateTime.now();
    this.auditUpdateAt = LocalDateTime.now();
  }

  @PreUpdate
  private void preUpdate() {
    this.auditUpdateAt = LocalDateTime.now();
  }
}
