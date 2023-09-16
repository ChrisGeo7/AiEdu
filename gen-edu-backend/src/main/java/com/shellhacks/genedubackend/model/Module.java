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
public class Module extends BaseModel{

    private String name;

    private Set<Topic> topics;

    public Module(String name) {
        this.name = name;
    }
}
