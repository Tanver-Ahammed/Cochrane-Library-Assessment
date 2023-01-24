package com.vantage.assesment.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Md. Tanver Ahammed
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TopicDTO {

    private long id;

    @NotEmpty
    @Size(min = 4, message = "topic title must be min of 4 character")
    private String title;

    private List<ReviewDTO> reviewDTOS = new ArrayList<>();

}
