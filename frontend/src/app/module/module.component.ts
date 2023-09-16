import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-module',
  templateUrl: './module.component.html',
  styleUrls: ['./module.component.css']
})
export class ModuleComponent implements OnInit{
  topic: string;

  constructor(private route: ActivatedRoute){
    this.topic = "";
  }
  ngOnInit(): void {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.topic = String(params.get('topic'))
    })
  }
  

}
