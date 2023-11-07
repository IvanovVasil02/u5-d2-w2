package ivanovvasil.u5d2w2.entities;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalTime;
import java.util.Locale;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(builderClassName = "BlogPostBuilder")
public class BlogPost {
  private int id;
  private String categoria;
  private String titolo;
  private String cover;
  private String postContent;
  private LocalTime readingTime;

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }

  public void setCover(String cover) {
    this.cover = cover;
  }

  public void setPostContent(String postContent) {
    this.postContent = postContent;
  }

  public void setReadingTime(LocalTime readingTime) {
    this.readingTime = readingTime;
  }

  public static class BlogPostBuilder{
    Faker f = new Faker(Locale.ITALY);
    private String categoria = f.book().genre();
    private String titolo = f.book().title();
    private String cover = f.avatar().image();
    private String postContent = f.app().name();
    private LocalTime readingTime = LocalTime.ofSecondOfDay(f.random().nextInt(60, 60000));
  }
}
