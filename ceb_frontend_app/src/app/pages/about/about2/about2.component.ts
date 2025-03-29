import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-about2',
  templateUrl: './about2.component.html',
  styleUrls: ['./about2.component.css']
})
export class About2Component implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  aboutSection = [
    {
      sectionImage: "assets/images/intro-pic.jpg",
      title: "About Our Company",
      subtitle: "We Provide top industrial Services.",
      yearsOfExperience: "25+",
      description: "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of you need to be sure there embarrassing.",
      features: [
        {
          icon:"flaticon-briefing",
          title: "Research & Analysis",
          description: "Train with the best experts in body building field."
        },
        {
          icon: "flaticon-reliability",
          title: "Quality Product",
          description: "Our personal trainers will help you find a perfect workout."
        }
      ]
    }
  ];

  teamSection = [
    {
      title: "Team of Professionals",
      subtitle: "Expert Contractors",
      team: [
        {
          image: "assets/images/team/pic1.jpg",
          expertise: "Mechanical Engineer",
          name: "William Dixon"
        },
        {
          image: "assets/images/team/pic2.jpg",
          expertise: "Industry Expert",
          name: "Gabriela Flores"
        },
        {
          image: "assets/images/team/pic3.jpg",
          expertise: "Mechanical Engineer",
          name: "Juliana Bryant"
        }
      ]
    }
  ];

  updatesSection = [
    {
      title: "News And Updates",
      subtitle: "Let's Checkout Our All Current News.",
      updates: [
        {
          image: "assets/images/blog/latest-2/b1.jpg",
          day: "13",
          month: "April",
          field: "Factory",
          title: "Cargo flow through better supply chain visibility.",
          description: "",
          linkToReadMore: "/blog-single"
        },
        {
          image: "assets/images/blog/latest-2/b2.jpg",
          day: "18",
          month: "April",
          field: "Industry",
          title: "he future of factories in the coming years",
          description: "",
          linkToReadMore: "/blog-single"
        },
        {
          image: "assets/images/blog/latest-2/b3.jpg",
          day: "19",
          month: "April",
          field: "Energy",
          title: "The factors that countries create are energy",
          description: "",
          linkToReadMore: "/blog-single"
        }
      ]
    }
  ];

  featuresSection = [
    {
      features: [
        {
          background: "bg-white",
          textColor: "white",
          icon: "flaticon-briefing",
          title: "Our Mission",
          description: "You can dream, create, design, and build the most wonderful place in the world. But it requires people."
        },
        {
          background: "site-bg-black",
          textColor: "",
          icon: "flaticon-lightbulb",
          title: "Our Vision",
          description: "You can dream, create, design, and build the most wonderful place in the world. But it requires people."
        },
        {
          background: "bg-white",
          textColor: "white",
          icon: "flaticon-worker",
          title: "Our Values",
          description: "You can dream, create, design, and build the most wonderful place in the world. But it requires people."
        }
      ]
    }
  ];
  
}
