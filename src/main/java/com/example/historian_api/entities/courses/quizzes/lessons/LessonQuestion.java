package com.example.historian_api.entities.courses.quizzes.lessons;


import com.example.historian_api.entities.converters.StringToListConverter;
import com.example.historian_api.entities.courses.QuestionImage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lessons_questions")
public class LessonQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private UnitLesson lesson;

    private String question;

    @ElementCollection
    @CollectionTable(name="lessons_question_answers", joinColumns=@JoinColumn(name="question_id"))
    @Column(name="answer")
    private List<String> answers = new ArrayList<>();

    private Integer correctAnswerIndex;

    private Boolean isCheckedAnswer;

    private String correctAnswerDescription;

    @OneToOne
    @JoinColumn(name = "question_image_id")
    private QuestionImage questionImage;

    private String photoUrl;

    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<LessonQuestionSolution> solutions = new ArrayList<>();

    public LessonQuestion(UnitLesson lesson,
                          String question,
                          List<String> answers,
                          Integer correctAnswerIndex,
                          Boolean isCheckedAnswer,
                          String correctAnswerDescription,
                          String photoUrl,
                          QuestionImage questionImage) {
        this.lesson = lesson;
        this.questionImage = questionImage;
        this.correctAnswerDescription = correctAnswerDescription;
        this.photoUrl = photoUrl;
        this.isCheckedAnswer = isCheckedAnswer;
        this.question = question;
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;
    }
}
