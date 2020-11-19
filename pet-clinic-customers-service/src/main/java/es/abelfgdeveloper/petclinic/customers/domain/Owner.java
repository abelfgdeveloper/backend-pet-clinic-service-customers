package es.abelfgdeveloper.petclinic.customers.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Owner {

  @EqualsAndHashCode.Include private String id;
  private String identificationDocument;
  private String firstName;
  private String lastName;
  private String telephone;
  private String email;
  private LocalDateTime auditCreateAt;
  private LocalDateTime auditUpdateAt;
  private boolean deleted;
}
