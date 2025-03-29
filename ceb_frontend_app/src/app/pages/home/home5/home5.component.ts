import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home5',
  templateUrl: './home5.component.html',
  styleUrls: ['./home5.component.css']
})
export class Home5Component implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  about1 = [
    {
      image: "assets/images/transport/about/1.jpg",
      title: "Road Fright",
      subtitle: "Nunc aliquet nulla nec dapibus max imus. Nam aliquam neque.",
      link: "/service-detail"
    },
    {
      image: "assets/images/transport/about/2.jpg",
      title: "Warehouses",
      subtitle: "Nunc aliquet nulla nec dapibus max imus. Nam aliquam neque.",
      link: "/service-detail"
    },
    {
      image: "assets/images/transport/about/3.jpg",
      title: "Air Fright",
      subtitle: "Nunc aliquet nulla nec dapibus max imus. Nam aliquam neque.",
      link: "/service-detail"
    }
  ];

  about2 = {
    slider: [
      {
        image: "assets/images/transport/portrait-2/pic1.jpg",
        thumb: "assets/images/transport/thumb/pic1.jpg"
      },
      {
        image: "assets/images/transport/portrait-2/pic2.jpg",
        thumb: "assets/images/transport/thumb/pic2.jpg"
      },
      {
        image: "assets/images/transport/portrait-2/pic3.jpg",
        thumb: "assets/images/transport/thumb/pic3.jpg"
      },
      {
        image: "assets/images/transport/portrait-2/pic4.jpg",
        thumb: "assets/images/transport/thumb/pic4.jpg"
      },
      {
        image: "assets/images/transport/portrait-2/pic5.jpg",
        thumb: "assets/images/transport/thumb/pic5.jpg"
      }
    ],
    title: "About Our Company",
    subtitle: "Trusted Logistic Service Provider",
    features: [
      {
        title: "Our Vision",
        description: "Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS."
      },
      {
        title: "Our Mission",
        description: "Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS."
      },
      {
        title: "Our Value",
        description: "Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS."
      }
    ]
  };

  serviceSection = {
    title: "Our Services",
    subtitle: "Moving Your Products Across All Borders",
    description: "Our event unites athletic professionals and enthusiasts to pursue a great goal. We create and promote initiatives that enable people to become and remain physically active regardless and challenge inequality of access to physical activity.",
    services: [
      {
        title: "Ground Delivery",
        image: "assets/images/transport/project2/1.jpg",
        author: "someone",
        link: "/project-single"
      },
      {
        title: "Air Delivery",
        image: "assets/images/transport/project2/2.jpg",
        author: "someone",
        link: "/project-single"
      },
      {
        title: "Sea Delivery",
        image: "assets/images/transport/project2/3.jpg",
        author: "someone",
        link: "/project-single"
      },
      {
        title: "Packaging & Storage",
        image: "assets/images/transport/project2/4.jpg",
        author: "someone",
        link: "/project-single"
      }
    ]
  }

  factsSection = {
    videoThumbnail: "assets/images/transport/video.jpg",
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

  weLoveSection = [
    {
      sectionImage: "assets/images/transport/bg-1.jpg",
      title: "Number We love",
      subtitle: "Our Fun Facts",
      fields: [
        {
          field: "Road Transport",
          qualityPercentage: "80"
        },
        {
          field: "Logistics",
          qualityPercentage: "90"
        },
        {
          field: "Air Transport",
          qualityPercentage: "95"
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
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise"
      },
      {
        image: "assets/images/testimonials/pic2.jpg",
        name: "Edword Howells",
        designation: "Founder & CEO",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise"
      },
      {
        image: "assets/images/testimonials/pic3.jpg",
        name: "David Lee",
        designation: "Contractor",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise"
      },
      {
        image: "assets/images/testimonials/pic1.jpg",
        name: "Mike Hardson",
        designation: "Director",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise"
      },
      {
        image: "assets/images/testimonials/pic2.jpg",
        name: "Edword Howells",
        designation: "Founder & CEO",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise"
      },
      {
        image: "assets/images/testimonials/pic3.jpg",
        name: "David Lee",
        designation: "Contractor",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise"
      },
      {
        image: "assets/images/testimonials/pic1.jpg",
        name: "Mike Hardson",
        designation: "Director",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise"
      },
      {
        image: "assets/images/testimonials/pic2.jpg",
        name: "Edword Howells",
        designation: "Founder & CEO",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise"
      },
      {
        image: "assets/images/testimonials/pic3.jpg",
        name: "David Lee",
        designation: "Contractor",
        quote: "They are the expertly trained team members who take extra step and go the extra mile, to fulfill promise"
      }
    ]
  };

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

  blogSection = {
    title: "Blogs",
    subtitle: "Our Latest News",
    blogs: [
      {
        image: "assets/images/transport/blog/thum1.jpg",
        date: "20 Apr 2021",
        authorImage: "assets/images/testimonials/pic1.jpg",
        author: "Loretta Shelton",
        comments: "10",
        title: "Importers achieve cost savings through the First Sale rule! dolar sit amet",
        link: "/blog-single"
      },
      {
        image: "assets/images/transport/blog/thum2.jpg",
        date: "18 Apr 2021",
        authorImage: "assets/images/testimonials/pic2.jpg",
        author: "Loretta Shelton",
        comments: "10",
        title: "Importers achieve cost savings through the First Sale rule! dolar sit amet",
        link: "/blog-single"
      }
    ]
  };

}
