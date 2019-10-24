package com.example.vi.batch.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tutorial")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tutorial {
    @Id
    private int id;
    private String title;
    private String author;
    private Date submission_date;
}
