import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-page-banner',
  templateUrl: './page-banner.component.html',
  styleUrls: ['./page-banner.component.css']
})
export class PageBannerComponent implements OnInit {

  @Input() title: any;
  @Input() subtitle: any;

  constructor() { }

  ngOnInit(): void {
  }

}
