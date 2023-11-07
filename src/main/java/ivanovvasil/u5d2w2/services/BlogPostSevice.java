package ivanovvasil.u5d2w2.services;

import ivanovvasil.u5d2w2.NotFoundException;
import ivanovvasil.u5d2w2.entities.BlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostSevice {
  private List<BlogPost> blogPosts = new ArrayList<>();

  public BlogPost save(BlogPost body) {
    Random rndm = new Random();
    body.setId(rndm.nextInt(1, 1000));
    this.blogPosts.add(body);
    return body;
  }

  public List<BlogPost> findAll() {
    return this.blogPosts;
  }

  public BlogPost findById(int id) {
    BlogPost found = (BlogPost) blogPosts.stream().filter(blogPost1 -> blogPost1.getId() == id);
    if (found == null) {
      throw new NotFoundException(id);
    }
    return found;
  }

  public void findByIdAndDelete(int id) {
    BlogPost blogPost = (BlogPost) blogPosts.stream().filter(blogPost1 ->blogPost1.getId() == id);
    blogPosts.remove(blogPost);
  }

  public BlogPost findByIdAndUpdate(int id, BlogPost body) {
    BlogPost found = null;
    for (BlogPost blogPost : blogPosts) {
      if (blogPost.getId() == id) {
        found = blogPost;
        found.setCategoria(body.getCategoria());
        found.setTitolo(body.getTitolo(););
        found.setCover(body.getCover(););
        found.setPostContent(body.getPostContent());
        found.setReadingTime(body.getReadingTime());
      }
    }
    if (found == null) {
      throw new NotFoundException(id);
    }
    return found;
  }
}
