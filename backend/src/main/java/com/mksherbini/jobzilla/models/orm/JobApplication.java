package com.mksherbini.jobzilla.models.orm;

import com.mksherbini.jobzilla.models.enums.ApplicationStatus;
import com.mksherbini.jobzilla.models.orm.ids.JobApplicationId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(JobApplicationId.class)
public class JobApplication {
    @Id
    @Column(name = "job_id")
    private Integer jobId;

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "application_status")
    private ApplicationStatus status;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
