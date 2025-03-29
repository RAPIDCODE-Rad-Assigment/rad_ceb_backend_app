import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home2',
  templateUrl: './home2.component.html',
  styleUrls: ['./home2.component.css']
})
export class Home2Component implements OnInit {

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

  factsSection = [
    {
      subtitle: "We believe in building long lasting our business relationships.",
      contact: "+(02) 0111-7457-354",
      email: "info@gmail.com",
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

  recentProjects = [
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
  
}
