package com.springboot.ktml.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="Level")
public class Level extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long level_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    private User user;
}
