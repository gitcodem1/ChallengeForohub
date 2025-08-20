package com.njaimed.forohub.challenge.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TopicRequest {

    @NotBlank
    @Size(max = 200)
    private String title;

    @Size(max = 200)
    private String message;
}
