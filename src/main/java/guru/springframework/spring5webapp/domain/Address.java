package guru.springframework.spring5webapp.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(doNotUseGetters = true, of = {"id"})
@ToString(doNotUseGetters = true)
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String addressLine;
    private String city;
    private String state;
    private String zipCode;
}
