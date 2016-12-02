package kz.ukarim.projects.todojavaee.core.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "text")
    private String text;

    @Column(name = "completed")
    private boolean completed;

    @Column(name = "deleted")
    private boolean deleted;

}
