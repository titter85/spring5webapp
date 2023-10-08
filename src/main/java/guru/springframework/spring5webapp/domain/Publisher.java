package guru.springframework.spring5webapp.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(doNotUseGetters = true, of = {"id"})
@ToString(doNotUseGetters = true)
@Builder
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @OneToOne
    @MapsId
    private Address address;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    private final Set<Book> books = new HashSet<>();
}
