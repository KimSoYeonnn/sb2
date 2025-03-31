package org.zerock.sb2.todo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name = "todo")
@Table(name = "tbl_todo")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    
    //모든 엔티티는 반드시 id가 존재
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tno;

    @Column(nullable = false, length = 300)
    private String title;

    private String writer;
}
