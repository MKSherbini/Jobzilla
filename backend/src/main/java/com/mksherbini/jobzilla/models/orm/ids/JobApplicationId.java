package com.mksherbini.jobzilla.models.orm.ids;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobApplicationId implements Serializable {
    private Integer jobId;
    private Integer userId;
}
