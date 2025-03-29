import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home3',
  templateUrl: './home3.component.html',
  styleUrls: ['./home3.component.css']
})
export class Home3Component implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  aboutSection = {
    sectionImage: "assets/images/intro-pic3.jpg",
    title: "Know About Us",
    subtitle: "Bringing Growth to Agriculture",
    projects: "450",
    description1: "Wild flowers , plants and fungi are the life support for all our wildlife and their colour and character light up our landscapes. But without our help , this priceless natural heritage is in danger of being lost.",
    description2: "If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text.",
    features: [
      {
        icon: "flaticon-harvest",
        title: "Growing Fruits and Vegetables"
      },
      {
        icon: "flaticon-vegetables",
        title: "Tips for Ripening your Fruits"
      }
    ]
  };

  services = [
    {
      title: "Lawn Cleaning",
      description: "You can dream, create, design, and build the most wonderful place.",
      image: "assets/images/agriculture/service/m1.jpg",
      link: "/service-detail"
    },
    {
      title: "Planting Tree",
      description: "You can dream, create, design, and build the most wonderful place.",
      image: "assets/images/agriculture/service/m2.jpg",
      link: "/service-detail"
    },
    {
      title: "Garden Care",
      description: "You can dream, create, design, and build the most wonderful place.",
      image: "assets/images/agriculture/service/m3.jpg",
      link: "/service-detail"
    },
    {
      title: "Leaf Cutting",
      description: "You can dream, create, design, and build the most wonderful place.",
      image: "assets/images/agriculture/service/m4.jpg",
      link: "/service-detail"
    }
  ];

  factsSection = {
    background: "assets/images/agriculture/leaf-border.png",
    facts: [
      {
        icon: "flaticon-farmer",
        count: "808",
        title: "Team Members"
      },
      {
        icon: "flaticon-field",
        count: "950",
        title: "Our Farms"
      },
      {
        icon: "flaticon-trophy",
        count: "560",
        title: "Win Awards"
      },
      {
        icon: "flaticon-deal",
        count: "996",
        title: "Gold Partners"
      }
    ]
  };

  projects = [
    {
      title: "Organic solutions",
      subtitle: "Regulatory Compliance System",
      image: "assets/images/agriculture/project/1.jpg",
      author: "someone",
      link: "/project-single"
    },
    {
      title: "Harvest Innovation",
      subtitle: "Florida Chemical Factories",
      image: "assets/images/agriculture/project/2.jpg",
      author: "someone",
      link: "/project-single"
    },
    {
      title: "Agriculture Farming",
      subtitle: "Flyover Construction",
      image: "assets/images/agriculture/project/3.jpg",
      author: "someone",
      link: "/project-single"
    },
    {
      title: "Garden Supplies",
      subtitle: "Documents Electronics Data",
      image: "assets/images/agriculture/project/4.jpg",
      author: "someone",
      link: "/project-single"
    },
    {
      title: "Natural Vegetable",
      subtitle: "Automotive Manufactureing",
      image: "assets/images/agriculture/project/5.jpg",
      author: "someone",
      link: "/project-single"
    },
    {
      title: "Ecological Farming",
      subtitle: "California Power Point",
      image: "assets/images/agriculture/project/6.jpg",
      author: "someone",
      link: "/project-single"
    },
    {
      title: "Fresh Rice",
      subtitle: "Regulatory Compliance System",
      image: "assets/images/agriculture/project/7.jpg",
      author: "someone",
      link: "/project-single"
    },
    {
      title: "Food Health Check",
      subtitle: "Florida Chemical Factories",
      image: "assets/images/agriculture/project/8.jpg",
      author: "someone",
      link: "/project-single"
    }
  ];

  teamSection = {
    title: "Team of Professionals",
    subtitle: "Expert Contractors",
    team: [
      {
        image: "assets/images/agriculture/team/pic1.jpg",
        expertise: "Mechanical Engineer",
        name: "William Dixon"
      },
      {
        image: "assets/images/agriculture/team/pic2.jpg",
        expertise: "Industry Expert",
        name: "Gabriela Flores"
      },
      {
        image: "assets/images/agriculture/team/pic3.jpg",
        expertise: "Mechanical Engineer",
        name: "Juliana Bryant"
      }
    ]
  };

  updatesSection = [
    {
      title: "News And Updates",
      subtitle: "Let's Checkout Our All Current News.",
      updates: [
        {
          image: "assets/images/agriculture/latest-2/b1.jpg",
          day: "13",
          month: "April",
          field: "Factory",
          title: "Cargo flow through better supply chain visibility.",
          description: "",
          linkToReadMore: "/blog-single"
        },
        {
          image: "assets/images/agriculture/latest-2/b2.jpg",
          day: "18",
          month: "April",
          field: "Industry",
          title: "he future of factories in the coming years",
          description: "",
          linkToReadMore: "/blog-single"
        },
        {
          image: "assets/images/agriculture/latest-2/b3.jpg",
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

  testimonialsSection = {
    title: "Testimonial",
    subtitle: "What Our Customers Are Talking About",
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
      }
    ]
  };
}
