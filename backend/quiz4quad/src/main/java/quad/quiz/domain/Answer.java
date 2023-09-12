//package quad.quiz.domain;
//
//import jakarta.persistence.*;
//import lombok.*;
//import org.hibernate.Hibernate;
//
//import java.util.Objects;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
//@Entity
//@Table
//public class Answer {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String answerText;
//    @ManyToOne(cascade = CascadeType.ALL)
//    private Question question;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        Answer answer=(Answer) o;
//        return id != null && Objects.equals(id, answer.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return getClass().hashCode();
//    }
//}
