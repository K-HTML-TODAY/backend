package com.springboot.ktml.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="correct")
public class Correct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long correct_id;
    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String content;
    @ManyToOne
    @JoinColumn(name="uid")
    @ToString.Exclude  //순환참조 방지
    private User user;
}
