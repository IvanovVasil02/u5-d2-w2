package ivanovvasil.u5d2w2.entities;

import lombok.*;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder(builderClassName = "BlogPostBuilder")
public class BlogPost {
  private int id;
  private String categoria;
  private String titolo;
  private String cover;
  private String postContent;
  private LocalTime readingTime;
}
