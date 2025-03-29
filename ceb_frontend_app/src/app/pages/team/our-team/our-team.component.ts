import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-our-team',
  templateUrl: './our-team.component.html',
  styleUrls: ['./our-team.component.css']
})
export class OurTeamComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  teamSection1 = [
    {
      title: "Team of Professionals",
      subtitle: "Expert Contractors",
      videoUrl: "https://www.youtube.com/watch?v=c1XNqw2gSbU",
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

  teamSection2 = {
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

  teamSection3 = {
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
      },
      {
        image: "assets/images/team/pic4.jpg",
        expertise: "Mechanical Engineer",
        name: "William Dixon"
      }
    ]
  };
}
