import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-our-team-detail',
  templateUrl: './our-team-detail.component.html',
  styleUrls: ['./our-team-detail.component.css']
})
export class OurTeamDetailComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  profile = {
    image: "assets/images/team/pic1.jpg",
    expertise: "Industry Expert",
    name: "Gabriela Flores",
    contact: "(009) 53661246741",
    email: "hello@induza.com",
    joining: "Apr 25, 2021",
    services: "autocad, sketchUp, visual basic, 3d premier",
    address: "32, Wales Street, New York, USA",
    experience: "6+ Years",
    fb: "https://www.facebook.com",
    twitter: "https://twitter.com",
    linkedin: "https://in.linkedin.com",
    pin: "https://in.pinterest.com"
  };

  skills = [
    {
      name: "Industry",
      percent: "80"
    },
    {
      name: "Construction",
      percent: "90"
    },
    {
      name: "Factory",
      percent: "95"
    },
    {
      name: "Mastery of construction machinery",
      percent: "80"
    },
    {
      name: "Builders planning",
      percent: "90"
    },
    {
      name: "Construction and design",
      percent: "95"
    }
  ];

  teamSection = {
    title: "Our Team",
    subtitle: "Our Experts",
    team: [
      {
        image: "assets/images/team3/pic1.jpg",
        expertise: "Industry Expert",
        name: "Ronan"
      },
      {
        image: "assets/images/team3/pic2.jpg",
        expertise: "Director",
        name: "Brayden"
      },
      {
        image: "assets/images/team3/pic3.jpg",
        expertise: "Contractor",
        name: "Marco"
      },
      {
        image: "assets/images/team3/pic4.jpg",
        expertise: "Industry Expert",
        name: "Devin"
      },
      {
        image: "assets/images/team3/pic5.jpg",
        expertise: "Mechanical Engineer",
        name: "Ronan"
      },
      {
        image: "assets/images/team3/pic6.jpg",
        expertise: "Electrician",
        name: "Brayden"
      }
    ]
  };

}
