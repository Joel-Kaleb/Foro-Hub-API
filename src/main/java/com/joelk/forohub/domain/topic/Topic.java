package com.joelk.forohub.domain.topic;

import com.joelk.forohub.domain.course.Course;
import com.joelk.forohub.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topics", uniqueConstraints = {
        @UniqueConstraint(name = "uk_topic_title_message", columnNames = {"title", "message"})
})
@Entity(name = "Topic")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String message;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private Boolean active = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @Enumerated(EnumType.STRING)
    private TopicStatus status = TopicStatus.OPEN;

    public Topic(DataRegistrationTopic data, User author, Course course) {
        this.title = data.title();
        this.message = data.message();
        this.author = author;
        this.course = course;
        this.active = true;
        this.createdAt = LocalDateTime.now();
    }
}
