package demo.tasks;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class Task implements Serializable {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private String name;

  @Override
  public String toString() {
    return String.format("Task[id=%d, name='%s']", this.id, this.name);
  }

}
