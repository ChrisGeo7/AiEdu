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
public class Content<T> extends BaseModel{

    private String type;

    private Set<T> contents;

}
