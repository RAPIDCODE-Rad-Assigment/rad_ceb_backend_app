import { AfterViewInit, Component, OnInit } from '@angular/core';

declare var jQuery: any;
declare var masonryBox: any;

@Component({
  selector: 'app-project2',
  templateUrl: './project2.component.html',
  styleUrls: ['./project2.component.css']
})
export class Project2Component implements OnInit, AfterViewInit {

  constructor() { }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {
    (function ($) {
      setTimeout(function () {
        masonryBox()
      }, 1000);
    })(jQuery);
  }

  categories = [
    {
      name: "All",
      type: "*"
    },
    {
      name: "Energy",
      type: ".cat-1"
    },
    {
      name: "Industry",
      type: ".cat-2"
    },
    {
      name: "Construction",
      type: ".cat-3"
    },
    {
      name: "Oil & Gas",
      type: ".cat-4"
    },
    {
      name: "Automobile",
      type: ".cat-5"
    },
    {
      name: "Industrial",
      type: ".cat-6"
    },
    {
      name: "Repair",
      type: ".cat-7"
    }
  ];

  projects = [
    {
      title: "Energy",
      subtitle: "Mechanical engineering",
      image: "assets/images/project2/1.jpg",
      author: "someone",
      link: "/project-single",
      category: "cat-1"
    },
    {
      title: "Industry",
      subtitle: "Oxim Energy Power INC",
      image: "assets/images/project3/m2.jpg",
      author: "someone",
      link: "/project-single",
      category: "cat-2"
    },
    {
      title: "Construction",
      subtitle: "Flyover Construction",
      image: "assets/images/project2/2.jpg",
      author: "someone",
      link: "/project-single",
      category: "cat-3"
    },
    {
      title: "Oil & Gas",
      subtitle: "Oil & Gas Filtering",
      image: "assets/images/project2/3.jpg",
      author: "someone",
      link: "/project-single",
      category: "cat-4"
    },
    {
      title: "Automobile",
      subtitle: "Florida Chemicals Factory",
      image: "assets/images/project3/m3.jpg",
      author: "someone",
      link: "/project-single",
      category: "cat-5"
    },
    {
      title: "Industrial",
      subtitle: "Chemical Research Center",
      image: "assets/images/project3/m4.jpg",
      author: "someone",
      link: "/project-single",
      category: "cat-6"
    },
    {
      title: "Planning",
      subtitle: "Machinary Processing",
      image: "assets/images/project2/4.jpg",
      author: "someone",
      link: "/project-single",
      category: "cat-7"
    },
    {
      title: "Repair",
      subtitle: "Welding Processing",
      image: "assets/images/project2/5.jpg",
      author: "someone",
      link: "/project-single",
      category: "cat-2"
    },
    {
      title: "Engineering",
      subtitle: "Villy Manufacturing Inc",
      image: "assets/images/project2/6.jpg",
      author: "someone",
      link: "/project-single",
      category: "cat-3"
    }
  ];

}
