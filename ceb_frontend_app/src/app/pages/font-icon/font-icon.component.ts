import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-font-icon',
  templateUrl: './font-icon.component.html',
  styleUrls: ['./font-icon.component.css']
})
export class FontIconComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  icons = [
    {
      name: "flaticon-checked"
    },
    {
      name: "flaticon-right"
    },
    {
      name: "flaticon-left"
    },
    {
      name: "flaticon-chat"
    },
    {
      name: "flaticon-lightbulb"
    },
    {
      name: "flaticon-antivirus"
    },
    {
      name: "flaticon-customer-service"
    },
    {
      name: "flaticon-physics"
    },
    {
      name: "flaticon-graphic-tool"
    },
    {
      name: "flaticon-gas-station"
    },
    {
      name: "flaticon-quote-1"
    },
    {
      name: "flaticon-quote"
    },
    {
      name: "flaticon-email"
    },
    {
      name: "flaticon-call"
    },
    {
      name: "flaticon-location"
    },
    {
      name: "flaticon-mail"
    },
    {
      name: "flaticon-worker"
    },
    {
      name: "flaticon-briefing"
    },
    {
      name: "flaticon-factory"
    },
    {
      name: "flaticon-reliability"
    },
    {
      name: "flaticon-oil"
    },
    {
      name: "flaticon-helmet"
    },
    {
      name: "flaticon-work-time"
    },
    {
      name: "flaticon-plant"
    },
    {
      name: "flaticon-car-parts"
    },
    {
      name: "flaticon-farmer"
    },
    {
      name: "flaticon-field"
    },
    {
      name: "flaticon-trophy"
    },
    {
      name: "flaticon-deal"
    },
    {
      name: "flaticon-harvest"
    },
    {
      name: "flaticon-vegetables"
    }
  ];
}
