import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-project-carousel',
  templateUrl: './project-carousel.component.html',
  styleUrls: ['./project-carousel.component.css']
})
export class ProjectCarouselComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  projects1 = [
    {
      title: "Energy",
      subtitle: "Regulatory Compliance System",
      image: "assets/images/project-4/m1.jpg",
      description: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
      author: "someone",
      link: "/project-single"
    },
    {
      title: "Industry",
      subtitle: "Florida Chemical Factories",
      image: "assets/images/project-4/m2.jpg",
      description: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
      author: "someone",
      link: "/project-single"
    },
    {
      title: "Oil & Gas",
      subtitle: "Documents Electronics Data",
      image: "assets/images/project-4/m3.jpg",
      description: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
      author: "someone",
      link: "/project-single"
    },
    {
      title: "Construction",
      subtitle: "Flyover Construction",
      image: "assets/images/project-4/m4.jpg",
      description: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
      author: "someone",
      link: "/project-single"
    }
  ];

  projects2 = [
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
