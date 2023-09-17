import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { ApiService } from '../api.service';

var stuff : any[];
@Component({
  selector: 'app-module',
  templateUrl: './module.component.html',
  styleUrls: ['./module.component.css']
})
export class ModuleComponent implements OnInit{
  topic: string;
  content: any[];

  constructor(private route: ActivatedRoute, private apiService: ApiService){
    this.topic = "";
    this.content = [];
  }
  
  ngOnInit(): void {

    this.route.paramMap.subscribe((params: ParamMap) => {
      this.topic = String(params.get('topic'))
    });

    this.apiService.getPostByTopic(this.topic).subscribe((data: any) => {
        this.content = data.modules;
    });

  }
  

}

