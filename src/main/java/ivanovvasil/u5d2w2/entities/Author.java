package ivanovvasil.u5d2w2.entities;

import com.github.javafaker.Faker;
import lombok.*;

import java.time.LocalDate;
import java.util.Locale;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder(builderClassName = "AuthorBuilder")
public class Author {
  private int id;
  private String name;
  private String surname;
  private String email;
  private LocalDate birthDate;
  private String avatar;

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public static class AuthorBuilder {
    Faker f = new Faker(Locale.ITALY);
    private String name = f.name().name();
    private String surname = f.name().lastName();
    private String email = f.internet().emailAddress();
    private LocalDate birthDate = LocalDate.parse((CharSequence) f.date().birthday());
    private String avatar = f.avatar().image();
  }

}
