package ewhacodic.demo.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name="tag")
public class Tag {
    @Id
    @Column(name="id")
    private Long id;

    @Column(name="tag_name")
    private String tagName;
}
