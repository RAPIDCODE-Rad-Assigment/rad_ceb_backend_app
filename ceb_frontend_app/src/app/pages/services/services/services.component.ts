import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-services',
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.css']
})
export class ServicesComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  services = [
    {
      icon: "flaticon-physics",
      title: "Chemical Research Industry",
      description: "You can dream, create, design, and build the most wonderful place in the world. But it requires people.",
      link: "/service-detail"
    },
    {
      icon: "flaticon-graphic-tool",
      title: "Construction & Engineering",
      description: "You can dream, create, design, and build the most wonderful place in the world. But it requires people.",
      link: "/service-detail"
    },
    {
      icon: "flaticon-gas-station",
      title: "Petroleum & Gas Engineering",
      description: "You can dream, create, design, and build the most wonderful place in the world. But it requires people.",
      link: "/service-detail"
    },
    {
      icon: "flaticon-work-time",
      title: "Mechanical Engineering",
      description: "You can dream, create, design, and build the most wonderful place in the world. But it requires people.",
      link: "/service-detail"
    },
    {
      icon: "flaticon-oil",
      title: "Oil & gas Engineering",
      description: "You can dream, create, design, and build the most wonderful place in the world. But it requires people.",
      link: "/service-detail"
    },
    {
      icon: "flaticon-car-parts",
      title: "Automotive Manufacturing",
      description: "You can dream, create, design, and build the most wonderful place in the world. But it requires people.",
      link: "/service-detail"
    }
  ];

  features = [
    {
      background: "site-bg-primary",
      textColor: "white",
      icon: "flaticon-lightbulb",
      title: "Creative Ideas",
      subtitle: "Train with the best experts in bodybuilding field."
    },
    {
      background: "site-bg-gray",
      textColor: "",
      icon: "flaticon-customer-service",
      title: "24/7 Support",
      subtitle: "Train with the best experts in bodybuilding field"
    },
    {
      background: "site-bg-black",
      textColor: "white",
      icon: "flaticon-antivirus",
      title: "Super Safety",
      subtitle: "Train with the best experts in bodybuilding field."
    }
  ];

  factsSection = [
    {
      title: "Some Facts",
      subtitle: "Expert Workers Are Giving Best Services To Build Your Dream Factory.",
      videoThumbnail: "assets/images/background/bg-2.jpg",
      videoUrl: "https://www.youtube.com/watch?v=c1XNqw2gSbU",
      facts: [
        {
          icon: "flaticon-worker",
          count: "808",
          title: "Contractors"
        },
        {
          icon: "flaticon-briefing",
          count: "950",
          title: "Projects Done!"
        },
        {
          icon: "flaticon-factory",
          count: "560",
          title: "Industries Served"
        },
        {
          icon: "flaticon-reliability",
          count: "996",
          title: "Trusted By"
        }
      ]
    }
  ];

  testimonialsSection = {
    title: "Testimonial",
    subtitle: "Happy Client Says About Us",
    testimonials: [
      {
        image: "assets/images/testimonials/pic1.jpg",
        name: "Mike Hardson",
        designation: "Director",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise to deliver dynamic solutions to our customers to fit"
      },
      {
        image: "assets/images/testimonials/pic2.jpg",
        name: "Edword Howells",
        designation: "Founder & CEO",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise to deliver dynamic solutions to our customers to fit"
      },
      {
        image: "assets/images/testimonials/pic3.jpg",
        name: "David Lee",
        designation: "Contractor",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise to deliver dynamic solutions to our customers to fit"
      },
      {
        image: "assets/images/testimonials/pic1.jpg",
        name: "Mike Hardson",
        designation: "Director",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise to deliver dynamic solutions to our customers to fit"
      },
      {
        image: "assets/images/testimonials/pic2.jpg",
        name: "Edword Howells",
        designation: "Founder & CEO",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise to deliver dynamic solutions to our customers to fit"
      },
      {
        image: "assets/images/testimonials/pic3.jpg",
        name: "David Lee",
        designation: "Contractor",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise to deliver dynamic solutions to our customers to fit"
      },
      {
        image: "assets/images/testimonials/pic1.jpg",
        name: "Mike Hardson",
        designation: "Director",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise to deliver dynamic solutions to our customers to fit"
      },
      {
        image: "assets/images/testimonials/pic2.jpg",
        name: "Edword Howells",
        designation: "Founder & CEO",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise to deliver dynamic solutions to our customers to fit"
      },
      {
        image: "assets/images/testimonials/pic3.jpg",
        name: "David Lee",
        designation: "Contractor",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise to deliver dynamic solutions to our customers to fit"
      }
    ]
  };
}
