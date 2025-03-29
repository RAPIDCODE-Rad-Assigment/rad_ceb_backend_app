import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home1',
  templateUrl: './home1.component.html',
  styleUrls: ['./home1.component.css']
})
export class Home1Component implements OnInit {

  constructor() {}

  ngOnInit(): void {
  }

  aboutUsSection = [
    {
      sectionImage: "assets/images/intro-pic.jpg",
      title: "About Us",
      subtitle: "The Best Solution For All Industries And Factories",
      yearsOfSuccess: "25",
      description: "Manufacturing industry became a key sector of production and labour in European and North American countries during the Industrial Revolution, upsetting previous mercantile and feudal economies.",
      features: [
        {
          title: "Best Quality Services",
          description: "Train with the best experts in body building field."
        },
        {
          title: "Lean Machines",
          description: "Our personal trainers will help you find a perfect workout."
        }
      ]
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

  teamSection = [
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

  servicesSection = [
    {
      title: "Services",
      subtitle: "Best A Grade Commercial & Residential Services",
      description: "Our event unites athletic professionals and enthusiasts to pursue a great goal. We create and promote initiatives that enable people to become and remain physically active regardless and challenge inequality of access to physical activity.",
      services: [
        {
          icon: "flaticon-physics",
          title: "Chemical Research Industry",
          description: "Given the increasing complexity of many construction projects it is becoming more common that a consultant.",
          linkToReadMore: "/service-detail"
        },
        {
          icon: "flaticon-graphic-tool",
          title: "Construction & Engineering",
          description: "Given the increasing complexity of many construction projects it is becoming more common that a consultant.",
          linkToReadMore: "/service-detail"
        },
        {
          icon: "flaticon-gas-station",
          title: "Petroleum & Gas Engineering",
          description: "Given the increasing complexity of many construction projects it is becoming more common that a consultant.",
          linkToReadMore: "/service-detail"
        },
        {
          icon: "flaticon-work-time",
          title: "Mechanical Engineering",
          description: "Given the increasing complexity of many construction projects it is becoming more common that a consultant.",
          linkToReadMore: "/service-detail"
        },
        {
          icon: "flaticon-oil",
          title: "Oil & gas Engineering",
          description: "Given the increasing complexity of many construction projects it is becoming more common that a consultant.",
          linkToReadMore: "/service-detail"
        },
        {
          icon: "flaticon-car-parts",
          title: "Automotive Manufacturing",
          description: "Given the increasing complexity of many construction projects it is becoming more common that a consultant.",
          linkToReadMore: "/service-detail"
        },
        {
          icon: "flaticon-helmet",
          title: "Civil & Art Engineering",
          description: "Given the increasing complexity of many construction projects it is becoming more common that a consultant.",
          linkToReadMore: "/service-detail"
        },
        {
          icon: "flaticon-plant",
          title: "Agricultural Automation",
          description: "Given the increasing complexity of many construction projects it is becoming more common that a consultant.",
          linkToReadMore: "/service-detail"
        }
      ]
    }
  ];

  buildFutureSection = [
    {
      sectionImage: "assets/images/background/bg12.jpg",
      title: "Build Future",
      subtitle: "We provide the highest quality of work that meets your expectations",
      fields: [
        {
          field: "Industry",
          qualityPercentage: "80"
        },
        {
          field: "Construction",
          qualityPercentage: "90"
        },
        {
          field: "Factory",
          qualityPercentage: "95"
        }
      ]
    }
  ];

  testimonialsSection = [
    {
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
    }
  ];

  updatesSection = [
    {
      title: "News And Updates",
      subtitle: "Let's Checkout Our All Current News.",
      updates: [
        {
          image: "assets/images/blog/latest/bg1.jpg",
          day: "13",
          month: "July",
          field: "Factory",
          title: "Cargo flow through better supply chain visibility.",
          description: "The trade war currently ensuing between the US and several nations around the globe, most fiercely with China,",
          linkToReadMore: "/blog-single"
        },
        {
          image: "assets/images/blog/latest/bg2.jpg",
          day: "18",
          month: "July",
          field: "Industry",
          title: "The future of factories in the coming years",
          description: "The trade war currently ensuing between the US and several nations around the globe, most fiercely with China,",
          linkToReadMore: "/blog-single"
        },
        {
          image: "assets/images/blog/latest/bg3.jpg",
          day: "19",
          month: "July",
          field: "Energy",
          title: "The factors that countries create are energy",
          description: "The trade war currently ensuing between the US and several nations around the globe, most fiercely with China,",
          linkToReadMore: "/blog-single"
        }
      ]
    }
  ];

  clientsSection = [
    {
      title: "Our Clients",
      subtitle: "A Few of Our Clients",
      clients: [
        {
          image: "assets/images/client-logo/w1.png"
        },
        {
          image: "assets/images/client-logo/w2.png"
        },
        {
          image: "assets/images/client-logo/w3.png"
        },
        {
          image: "assets/images/client-logo/w4.png"
        },
        {
          image: "assets/images/client-logo/w5.png"
        },
        {
          image: "assets/images/client-logo/w6.png"
        },
        {
          image: "assets/images/client-logo/w1.png"
        },
        {
          image: "assets/images/client-logo/w2.png"
        },
        {
          image: "assets/images/client-logo/w3.png"
        },
        {
          image: "assets/images/client-logo/w4.png"
        },
        {
          image: "assets/images/client-logo/w5.png"
        },
        {
          image: "assets/images/client-logo/w6.png"
        },
        {
          image: "assets/images/client-logo/w1.png"
        },
        {
          image: "assets/images/client-logo/w2.png"
        },
        {
          image: "assets/images/client-logo/w3.png"
        },
        {
          image: "assets/images/client-logo/w4.png"
        },
        {
          image: "assets/images/client-logo/w5.png"
        },
        {
          image: "assets/images/client-logo/w6.png"
        }
      ],
      features: [
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
      ]
    }
  ];
}
