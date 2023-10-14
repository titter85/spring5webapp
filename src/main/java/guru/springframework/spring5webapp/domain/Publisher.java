package guru.springframework.spring5webapp.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(doNotUseGetters = true, of = {"id"})
@ToString(doNotUseGetters = true, exclude = {"books"})
@Builder
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @OneToOne
    @MapsId
    private Address address;
}
