import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { ApiService } from '../api.service';


@Component({
  selector: 'app-topic',
  templateUrl: './topic.component.html',
  styleUrls: ['./topic.component.css']
})
export class TopicComponent implements OnInit {
    post: { name: string; level: number; } = {
      name: '',
      level: 0
    };
    name: string;
    level: number;
    content: any[];

    constructor(private route: ActivatedRoute, private apiService: ApiService){
      this.name = "";
      this.level = 0;
      this.content = [];
    }

    ngOnInit():void{
      this.route.paramMap.subscribe((params: ParamMap) => {
        this.name = String(params.get('name'))
        this.level = Number(params.get('rating'))
        this.post = {"name": this.name, "level": this.level}

        console.log(this.post);
        
      });

      this.apiService.addPost(this.post).subscribe((data: any) => {
        console.log(data);
        this.content = data.topics;
      });

    }
}
