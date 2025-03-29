import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-about1',
  templateUrl: './about1.component.html',
  styleUrls: ['./about1.component.css']
})
export class About1Component implements OnInit {

  constructor() { }

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
  
}
