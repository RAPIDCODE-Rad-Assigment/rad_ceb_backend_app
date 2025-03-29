import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-project-single',
  templateUrl: './project-single.component.html',
  styleUrls: ['./project-single.component.css']
})
export class ProjectSingleComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  project = {
    cover: "assets/images/project-4/m3.jpg",
    description: "<h4 class='wt-tilte'>How Mechanical Engineering Works?</h4><p>Lorem ipsum is simply free text used by copytyping refreshing. Neque porro est    qui    dolorem ipsum quia quaed inventore veritatis et quasi architecto beatae vitae    dicta sunt explicabo.    Aelltes port lacus quis enim var sed efficitur turpis gilla sed sit amet finibus    eros.    Lorem Ipsum is simply dummy text of the printing and typesetting industry.    Lorem Ipsum has been the ndustry standard dummy text ever since the 1500s, when    an unknown printer took    a galley of type and scrambled it to make a type specimen book. It has survived    not only five centuries.    Lorem Ipsum is simply dummy text of the new design printng and type setting    Ipsum Take a look at our    round up of the best shows coming soon to your telly box has been the is    industrys. When an unknown    printer took a galley of type and scrambled it to make a type specimen book. It    has survived not only    five centuries, but also the leap into electronic typesetting, remaining    essentially unchanged.    It was popularised in the 1960s with the release of Letraset sheets containing.</p><h4 class='wt-tilte'>Challenge & Solutions</h4><ul class='arrow-list-1'>    <li><strong>ipsum dolor sit amet, consectetur adipiscing elit.</strong> </li>    <li><strong>Proin sit amet diam et elit dictum sodales.</strong> </li>    <li><strong>Suspendisse tempus felis a libero mollis ultrices.</strong> </li>    <li><strong>Nullam accumsan ipsum a diam cursus mattis</strong> </li>    <li><strong>Duis quis odio quis dui sagittis laoreet.</strong> </li>    <li><strong>Suspendisse tempus felis a libero mollis ultrices.</strong> </li></ul> <div class='row project-single-img-column m-b30'>    <div class='col-md-6 col-lg-6'><img src='assets/images/project-4/m1.jpg' alt=''></div>    <div class='col-md-6 col-lg-6'><img src='assets/images/project-4/m2.jpg' alt=''></div></div><p>when our power of choice is untrammelled and when nothing prevents our being able    to do what we    like best, every pleasure is to be welcomed and every pain avoided.    But in certain circumstances and owing to the claims of duty or the obligations    of business    it will frequently occur that pleasures have to be repudiated and annoyances    accepted.</p>",
    info: {
      intro: "It is a long established fact that a reader will be distracted by the readable content of a page.",
      date: "02 April 2021",
      category: "GYM, Fitness",
      clients: "William Dixon",
      location: "London, NW18JR, UK"
    },
    brochures: {
      pdf: "javascript:void(0);",
      doc: "javascript:void(0);"
    }
  };

  relatedProjects = [
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
      image: "assets/images/project/8.jpg",
      author: "someone",
      link: "/project-single"
    }
  ];
}
