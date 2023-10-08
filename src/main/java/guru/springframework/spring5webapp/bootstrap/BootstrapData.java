package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        Author dominik = new Author();
        dominik.setName("Dominik");
        dominik.setSurname("Sarnowski");
        Book firstBook = new Book();
        firstBook.setTitle("First title");
        firstBook.setIsbn("4532");
        dominik.setBooks(Set.of(firstBook));

        authorRepository.save(dominik);
        bookRepository.save(firstBook);

        System.out.println("Bootstrapping DB:");
        System.out.println("Number of authors saved: " + authorRepository.count());
    }
}
