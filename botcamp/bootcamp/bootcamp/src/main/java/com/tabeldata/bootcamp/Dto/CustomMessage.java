package com.tabeldata.bootcamp.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data@NoArgsConstructor
public class CustomMessage {

    public CustomMessage (HttpStatus status, String message){
        this.message = message;
        this.status = status.value();
        this.title = status.getReasonPhrase();
    }
    private String timestamp = LocalDateTime.now().toString();
    private String message;
    private Integer status;
    private String title;

}
