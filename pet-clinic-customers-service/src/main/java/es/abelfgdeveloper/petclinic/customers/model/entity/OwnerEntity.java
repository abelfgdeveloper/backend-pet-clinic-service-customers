package es.abelfgdeveloper.petclinic.customers.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
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
@Table(name = "owners")
public class OwnerEntity {

  @Id
  @Column(name = "id")
  private String id;

  @Column(name = "identification_document")
  private String identificationDocument;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "telephone")
  private String telephone;

  @Column(name = "email")
  private String email;

  @Column(name = "audit_create_at")
  private LocalDateTime auditCreateAt;

  @Column(name = "audit_update_at")
  private LocalDateTime auditUpdateAt;

  @Column(name = "is_deleted")
  private boolean deleted;

  @PrePersist
  private void prePersist() {
    this.id = UUID.randomUUID().toString();
  }
}
