package ivanovvasil.u5d2w2.services;

import ivanovvasil.u5d2w2.NotFoundException;
import ivanovvasil.u5d2w2.entities.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AuthorsSevices {
  private List<Author> authors = new ArrayList<>();

  public Author save(Author body) {
    Random rndm = new Random();
    body.setId(rndm.nextInt(1, 1000));
    this.authors.add(body);
    return body;
  }

  public List<Author> findAll() {
    return this.authors;
  }

  public Author findById(int id) {
    Author found = (Author) authors.stream().filter(author1 -> author1.getId() == id);
    if (found == null) {
      throw new NotFoundException(id);
    }
    return found;
  }

  public void findByIdAndDelete(int id) {
    Author author = (Author) authors.stream().filter(author1 -> author1.getId() == id);
    authors.remove(author);
  }

  public Author findByIdAndUpdate(int id, Author body) {
    Author found = null;
    for (Author author : authors) {
      if (author.getId() == id) {
        found = author;
        found.setName(body.getName());
        found.setSurname(body.getSurname());
        found.setEmail(body.getEmail());
        found.setBirthDate(body.getBirthDate());
        found.setAvatar(body.getAvatar());
      }
    }
    if (found == null) {
      throw new NotFoundException(id);
    }
    return found;
  }
}
