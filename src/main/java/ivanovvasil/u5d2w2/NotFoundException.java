package ivanovvasil.u5d2w2;

public class NotFoundException extends RuntimeException {
  public NotFoundException(int id) {
    super("There is no user with this id");
  }
}
