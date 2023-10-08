package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Address;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {
        Publisher firstPublisher = Publisher.builder()
                .name("First Publisher")
                .address(Address.builder()
                        .city("Wroclaw")
                        .state("Dolnoslaskie")
                        .addressLine("Opolska 1")
                        .zipCode("11-123")
                        .build())
                .build();

        publisherRepository.save(firstPublisher);

        System.out.format("Publisher %1d saved with address: %2d !\r\n", firstPublisher.getId(), firstPublisher.getAddress().getId());

        Author dominik = new Author();
        dominik.setName("Dominik");
        dominik.setSurname("Sarnowski");
        Book firstBook = new Book();
        firstBook.setTitle("First title");
        firstBook.setIsbn("4532");
        firstBook.setPublisher(firstPublisher);
        Book secondBook = new Book();
        secondBook.setTitle("Second book");
        secondBook.setIsbn("7865");
        secondBook.setAuthors(Set.of(dominik));
        secondBook.setPublisher(firstPublisher);
        Book thirdBook = Book.builder()
                .title("3rd title")
                .isbn("0987")
                .authors(Set.of(dominik))
                .publisher(firstPublisher)
                .build();
        dominik.setBooks(Set.of(firstBook, secondBook, thirdBook));
        firstPublisher.getBooks().add(firstBook);
        firstPublisher.getBooks().add(secondBook);
        firstPublisher.getBooks().add(thirdBook);

        authorRepository.save(dominik);
        bookRepository.save(firstBook);
        bookRepository.save(secondBook);
        bookRepository.save(thirdBook);
        publisherRepository.save(firstPublisher);

        System.out.println("Bootstrapping DB:");
        System.out.println("Number of authors saved: " + authorRepository.count());

        System.out.format("Publisher %1$d published %2$d books.", firstPublisher.getId(), firstPublisher.getBooks().size());

    }
}
