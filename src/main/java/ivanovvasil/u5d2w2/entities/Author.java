package ivanovvasil.u5d2w2.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Author {
  private int id;
  private String name;
  private String surname;
  private String email;
  private String birthDate;
  private String avatar;
}
