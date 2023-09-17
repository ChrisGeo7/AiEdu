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
  name: any;
  rating: any;


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
        console.log(this.content);
        
    });

  }

  numSequence(n: number): Array<number> {
    return Array(n);
  }

  selected(){
    console.log(this.name + " " + this.rating)
  }
  

}

