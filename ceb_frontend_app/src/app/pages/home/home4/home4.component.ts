import { AfterViewInit, Component, OnInit } from '@angular/core';

declare var jQuery: any;
declare var masonryBox: any;

@Component({
  selector: 'app-home4',
  templateUrl: './home4.component.html',
  styleUrls: ['./home4.component.css']
})
export class Home4Component implements OnInit, AfterViewInit {

  constructor() { }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {
    (function ($) {
      setTimeout(function () {
        masonryBox()
      }, 1000);
    })(jQuery);
  }

  about1 = [
    {
      image: "assets/images/construction/about/1.jpg",
      title: "Builder With Engineering",
      subtitle: "Nunc aliquet nulla nec dapibus max imus. Nam aliquam neque.",
      link: "/service-detail"
    },
    {
      image: "assets/images/construction/about/2.jpg",
      title: "Architecture & Engineering",
      subtitle: "Nunc aliquet nulla nec dapibus max imus. Nam aliquam neque.",
      link: "/service-detail"
    },
    {
      image: "assets/images/construction/about/3.jpg",
      title: "Consultant & Preparation",
      subtitle: "Nunc aliquet nulla nec dapibus max imus. Nam aliquam neque.",
      link: "/service-detail"
    },
    {
      image: "assets/images/construction/about/4.jpg",
      title: "Infrastucture & Customizing",
      subtitle: "Nunc aliquet nulla nec dapibus max imus. Nam aliquam neque.",
      link: "/service-detail"
    }
  ];

  about2 = {
    sectionImage: "assets/images/intro-pic4.png",
    title: "About Our Company",
    subtitle: "We're leading Construction Farm in USA",
    yearsOfExperience: "25+",
    description: "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of you need to be sure there embarrassing.",
    features: [
      {
        icon: "flaticon-briefing",
        title: "Research & Analysis",
        description: "Train with the best experts in body building field."
      },
      {
        icon: "flaticon-reliability",
        title: "Quality Product",
        description: "Our personal trainers will help you find a perfect workout."
      }
    ]
  };

  factsSection = {
    sectionBackground: "assets/images/construction/background/bg1.jpg",
    title: "Some Facts",
    subtitle: "Ready to Bring Bigger, Better, Faster & Stronger Projects Than Ever!!",
    videoThumbnail: "assets/images/construction/some-facts.jpg",
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
  };

  projects = [
    {
      title: "Energy",
      subtitle: "Mechanical engineering",
      image: "assets/images/construction/project2/1.jpg",
      author: "someone",
      link: "/project-single",
      category: "cat-1"
    },
    {
      title: "Industry",
      subtitle: "Oxim Energy Power INC",
      image: "assets/images/construction/project3/m2.jpg",
      author: "someone",
      link: "/project-single",
      category: "cat-2"
    },
    {
      title: "Construction",
      subtitle: "Flyover Construction",
      image: "assets/images/construction/project2/2.jpg",
      author: "someone",
      link: "/project-single",
      category: "cat-3"
    },
    {
      title: "Oil & Gas",
      subtitle: "Oil & Gas Filtering",
      image: "assets/images/construction/project2/3.jpg",
      author: "someone",
      link: "/project-single",
      category: "cat-4"
    },
    {
      title: "Automobile",
      subtitle: "Florida Chemicals Factory",
      image: "assets/images/construction/project3/m3.jpg",
      author: "someone",
      link: "/project-single",
      category: "cat-5"
    },
    {
      title: "Industrial",
      subtitle: "Chemical Research Center",
      image: "assets/images/construction/project3/m4.jpg",
      author: "someone",
      link: "/project-single",
      category: "cat-2"
    },
    {
      title: "Planning",
      subtitle: "Machinary Processing",
      image: "assets/images/construction/project2/4.jpg",
      author: "someone",
      link: "/project-single",
      category: "cat-3"
    },
    {
      title: "Repair",
      subtitle: "Welding Processing",
      image: "assets/images/construction/project2/5.jpg",
      author: "someone",
      link: "/project-single",
      category: "cat-1"
    },
    {
      title: "Engineering",
      subtitle: "Villy Manufacturing Inc",
      image: "assets/images/construction/project2/6.jpg",
      author: "someone",
      link: "/project-single",
      category: "cat-4"
    }
  ];

  testimonialsSection = {
    title: "Testimonial",
    subtitle: "Happy Client Says About Us",
    background: "assets/images/construction/background/bg3.jpg",
    testimonials: [
      {
        image: "assets/images/testimonials/pic1.jpg",
        name: "Mike Hardson",
        designation: "Director",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise."
      },
      {
        image: "assets/images/testimonials/pic2.jpg",
        name: "Edword Howells",
        designation: "Founder & CEO",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise."
      },
      {
        image: "assets/images/testimonials/pic3.jpg",
        name: "David Lee",
        designation: "Contractor",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise."
      },
      {
        image: "assets/images/testimonials/pic1.jpg",
        name: "Mike Hardson",
        designation: "Director",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise."
      },
      {
        image: "assets/images/testimonials/pic2.jpg",
        name: "Edword Howells",
        designation: "Founder & CEO",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise."
      },
      {
        image: "assets/images/testimonials/pic3.jpg",
        name: "David Lee",
        designation: "Contractor",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise."
      },
      {
        image: "assets/images/testimonials/pic1.jpg",
        name: "Mike Hardson",
        designation: "Director",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise."
      },
      {
        image: "assets/images/testimonials/pic2.jpg",
        name: "Edword Howells",
        designation: "Founder & CEO",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise."
      },
      {
        image: "assets/images/testimonials/pic3.jpg",
        name: "David Lee",
        designation: "Contractor",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise."
      }
    ]
  };

  teamSection = {
    title: "Team of Professionals",
    subtitle: "Expert Contractors",
    team: [
      {
        image: "assets/images/team/pic1.jpg",
        expertise: "Mechanical Engineer",
        name: "William Dixon",
        fb: "https://www.facebook.com",
        twitter: "https://twitter.com",
        linkedin: "https://in.linkedin.com",
        pin: "https://in.pinterest.com"
      },
      {
        image: "assets/images/team/pic2.jpg",
        expertise: "Industry Expert",
        name: "Gabriela Flores",
        fb: "https://www.facebook.com",
        twitter: "https://twitter.com",
        linkedin: "https://in.linkedin.com",
        pin: "https://in.pinterest.com"
      },
      {
        image: "assets/images/team/pic3.jpg",
        expertise: "Mechanical Engineer",
        name: "Juliana Bryant",
        fb: "https://www.facebook.com",
        twitter: "https://twitter.com",
        linkedin: "https://in.linkedin.com",
        pin: "https://in.pinterest.com"
      }
    ]
  };

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
