package com.shellhacks.genedubackend.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TextContent extends BaseModel{

    List<String> header;

    List<String> data;

}
