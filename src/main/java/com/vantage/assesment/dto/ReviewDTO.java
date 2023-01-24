package com.vantage.assesment.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: Md. Tanver Ahammed
 * */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReviewDTO {

    private long id;

    @NotEmpty
    @Size(min = 4, message = "review title must be min of 4 character")
    private String title;

    private String date;

    @NotEmpty
    private String authors;

    @NotEmpty
    private String details;

    private TopicDTO topicDTO;

}
