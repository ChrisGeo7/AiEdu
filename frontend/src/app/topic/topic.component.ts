import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { ApiService } from '../api.service';
import { NgbNavModule } from '@ng-bootstrap/ng-bootstrap';
import { NgFor } from '@angular/common';


@Component({
  selector: 'app-topic',
  templateUrl: './topic.component.html',
  standalone: true,
  imports: [NgbNavModule, NgbNavModule, NgFor],
  styleUrls: ['./topic.component.css']
})
export class TopicComponent implements OnInit {
    active = '';
    post: { name: string; level: number; } = {
      name: '',
      level: 0
    };
    posttopic: { name: string; moduleName: string; } = {
      name: '',
      moduleName: ''
    };
    moduleName: string;
    level: number;
    content: any[];
    tname: any;
    description: string = 'Please wait while the content is being loaded.';

    constructor(private route: ActivatedRoute, private apiService: ApiService){
      this.moduleName = "";
      this.level = 0;
      this.content = [];
    }

    ngOnInit():void{
      this.route.paramMap.subscribe((params: ParamMap) => {
        this.moduleName = String(params.get('name'))
        this.level = Number(params.get('rating'))
        this.post = {"name": this.moduleName, "level": this.level}
        

        console.log(this.post);
        
      });

      this.apiService.addPost(this.post).subscribe((data: any) => {
        console.log(data);
        this.content = data.topics;
        this.active = this.content[0];
      });

    }

    selected(){
      this.posttopic = {"name": this.active, "moduleName": this.moduleName}
      this.description = 'Please wait while the content is being loaded.'
      this.apiService.getContent(this.posttopic).subscribe((data: any) => {
        console.log(data.content);
        this.description = data.content;
      })
      console.log(this.moduleName + " " + this.active)
    }


}
