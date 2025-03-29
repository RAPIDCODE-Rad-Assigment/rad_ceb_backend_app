import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-blog-grid',
  templateUrl: './blog-grid.component.html',
  styleUrls: ['./blog-grid.component.css']
})
export class BlogGridComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  blogNews = {
    title: "News And Updates",
    subtitle: "Let's Checkout Our All Current News.",
    news: [
      {
        image: "assets/images/blog/latest-2/b1.jpg",
        day: "13",
        month: "July",
        field: "Factory",
        title: "Cargo flow through better supply chain visibility.",
        description: "",
        linkToReadMore: "/blog-single"
      },
      {
        image: "assets/images/blog/latest-2/b2.jpg",
        day: "18",
        month: "July",
        field: "Industry",
        title: "The future of factories in the coming years",
        description: "",
        linkToReadMore: "/blog-single"
      },
      {
        image: "assets/images/blog/latest-2/b3.jpg",
        day: "19",
        month: "July",
        field: "Energy",
        title: "The factors that countries create are energy",
        description: "",
        linkToReadMore: "/blog-single"
      },
      {
        image: "assets/images/blog/latest-2/b4.jpg",
        day: "13",
        month: "July",
        field: "Factory",
        title: "Cargo flow through better supply chain visibility.",
        description: "",
        linkToReadMore: "/blog-single"
      },
      {
        image: "assets/images/blog/latest-2/b5.jpg",
        day: "18",
        month: "July",
        field: "Industry",
        title: "The future of factories in the coming years",
        description: "",
        linkToReadMore: "/blog-single"
      },
      {
        image: "assets/images/blog/latest-2/b6.jpg",
        day: "19",
        month: "July",
        field: "Energy",
        title: "The factors that countries create are energyc",
        description: "",
        linkToReadMore: "/blog-single"
      }
    ]
  };
}
