import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-project1',
  templateUrl: './project1.component.html',
  styleUrls: ['./project1.component.css']
})
export class Project1Component implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  projects = [
    {
      title: "Energy",
      subtitle: "Regulatory Compliance System",
      image: "assets/images/project/1.jpg",
      author: "someone",
      link: "/project-single"
    },
    {
      title: "Industry",
      subtitle: "Florida Chemical Factories",
      image: "assets/images/project/2.jpg",
      author: "someone",
      link: "/project-single"
    },
    {
      title: "Construction",
      subtitle: "Flyover Construction",
      image: "assets/images/project/3.jpg",
      author: "someone",
      link: "/project-single"
    },
    {
      title: "Oil & Gas",
      subtitle: "Documents Electronics Data",
      image: "assets/images/project/4.jpg",
      author: "someone",
      link: "/project-single"
    },
    {
      title: "Automobile",
      subtitle: "Automotive Manufactureing",
      image: "assets/images/project/5.jpg",
      author: "someone",
      link: "/project-single"
    },
    {
      title: "Industrial",
      subtitle: "California Power Point",
      image: "assets/images/project/6.jpg",
      author: "someone",
      link: "/project-single"
    },
    {
      title: "Energy",
      subtitle: "Regulatory Compliance System",
      image: "assets/images/project/7.jpg",
      author: "someone",
      link: "/project-single"
    },
    {
      title: "Industry",
      subtitle: "Florida Chemical Factories",
      image: "assets/images/project/2.jpg",
      author: "someone",
      link: "/project-single"
    },
    {
      title: "Construction",
      subtitle: "Flyover Construction",
      image: "assets/images/project/8.jpg",
      author: "someone",
      link: "/project-single"
    }
  ];
}
