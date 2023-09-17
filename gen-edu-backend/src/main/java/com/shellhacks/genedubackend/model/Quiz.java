package com.shellhacks.genedubackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quiz extends BaseModel{
    private String question;
    private List<String> choices;
    private int answer;
}
