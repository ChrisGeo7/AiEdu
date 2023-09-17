package com.shellhacks.genedubackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topic extends BaseModel{

    private String name;

    private String moduleName;

    private String content;

}
