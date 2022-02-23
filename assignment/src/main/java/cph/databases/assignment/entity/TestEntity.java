package cph.databases.assignment.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Table(name = "test_entity")
@Entity
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @NotNull
    private String jobType;
    @NotNull
    private String jobId;
    @NotNull
    private String jobStatus;


    public TestEntity() {
    }

}
