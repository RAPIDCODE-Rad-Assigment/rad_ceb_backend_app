import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-faqs',
  templateUrl: './faqs.component.html',
  styleUrls: ['./faqs.component.css']
})
export class FaqsComponent implements OnInit {

  @Input() faqs: any;

  constructor() { }

  ngOnInit(): void {
  }

}
