import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-box-about-author',
  templateUrl: './box-about-author.component.html',
  styleUrls: ['./box-about-author.component.css']
})
export class BoxAboutAuthorComponent implements OnInit {

  @Input() data: any;

  constructor() { }

  ngOnInit(): void {
  }

}
