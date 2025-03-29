import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-blog-single',
  templateUrl: './blog-single.component.html',
  styleUrls: ['./blog-single.component.css']
})
export class BlogSingleComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  blogDetails = {
    image1: "assets/images/blog/blog-single/1.jpg",
    date: "Mar 23, 2021",
    author: "Admin",
    comments: "10",
    title: "Importance of specialized focus in Projects, Oil & Gas Logistics?",
    description: "<p>The key to the success of any logistics contract is good logistics management. The key to good management is the ability to identify the needs of the client and the countries in which the work will take place, as well as being in a position to advise the best way forward. In today’s international and remote locations, experience and understanding of logistics operations and local networks is vital. With the many years of experience in our team, we have a detailed understanding of the criticality or every aspect of the logistics world.</p> <p> Focus can provide logistics personnel to meet the needs of your company or portfolio. From logistics managers to warehousemen, logistics controllers to transport coordinators, we can assist you. We provide personnel for one-off portfolio as well as long or short-term agency personnel, assist in the recruitment of permanent staff, or we can manage your logistics department for you.</p> <p>When travelling to a foreign country, most people are nervous of the obstacles that will be there for them to overcome. When a full marine crew travels en-mass to a vessel mobilisation, it is imperative that they arrive on time and safely, especially in a remote location.</p> <p>Focus provides meet-and-greet facilities through our network of specialist companies. From hotel reservations and taxi arrangements to a full pick-up facility, with or without armed guards, this can be arranged.</p> <blockquote class='site-bg-gray-light'> <i class='fa fa-quote-left'></i> A bene fraticinida. Est barbatus parma, cesaris. Regius era virtualiter imperiums palus est. Domesticus, dexter parmas sed mire magicae. </blockquote> <p>Ever had a last minute requirement for items to be in a country where you do not have a visa to enter? Are you frustrated at having to hand-carry important documents to your client, which takes you out of the office for days? Let Focus help you. Our personnel are available 24-hours-a-day for these important deliveries. This leaves you free to concentrate on your business.</p>",
    image2: "assets/images/blog/blog-single/2.jpg",
  };

  relatedPosts = [
    {
      image: "assets/images/blog/latest-2/b1.jpg",
      day: "13",
      month: "July",
      field: "Factory",
      title: "Cargo flow through better supply chain visibility.",
      description: "",
      linkToReadMore: "/blog-single"
    },
    {
      image: "assets/images/blog/latest-2/b2.jpg",
      day: "18",
      month: "July",
      field: "Industry",
      title: "he future of factories in the coming years",
      description: "",
      linkToReadMore: "/blog-single"
    },
    {
      image: "assets/images/blog/latest-2/b3.jpg",
      day: "19",
      month: "July",
      field: "Energy",
      title: "The factors that countries create are energy",
      description: "",
      linkToReadMore: "/blog-single"
    }
  ];

  commentsSection = {
    count: "3",
    comments: [
      {
        userimage: "assets/images/testimonials/pic1.jpg",
        username: "Janice Brown",
        date: "Apr 20 2021",
        comment: "long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using more-or-less letters.",
        replies: [
          {
            userimage: "assets/images/testimonials/pic2.jpg",
            username: "Betty Riley",
            date: "Apr 08 2021",
            comment: "Along with your plans, you should consider developing an action orientation that will keep you motivated to move forward at all times."
          }
        ]
      },
      {
        userimage: "assets/images/testimonials/pic3.jpg",
        username: "Janice Brown",
        date: "Apr 12 2021",
        comment: "Cras sit amet est eget dui viverra scelerisque. Duis semper pulvinar dui, nec mollis libero tincidunt quis. In hac habitasse platea dictumst.",
        replies: []
      }
    ]
  };

  author = {
    title: "About Author",
    image: "assets/images/team/pic1.jpg",
    name: "Rosalina D. Willaimson",
    description: "We are the dolor sit ametLorem Ipsum Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin.",
    fb: "https://www.facebook.com",
    twitter: "https://twitter.com",
    linkedin: "https://in.linkedin.com",
    pin: "https://in.pinterest.com"
  };

  recentPosts = [
    {
      title: "Recent Posts",
      posts: [
        {
          image: "assets/images/blog/recent-blog/pic1.jpg",
          date: "18 Apr, 2021",
          title: "Automating The Design to Manufacturing Lifecycle.",
          postLink: "/blog-single"
        },
        {
          image: "assets/images/blog/recent-blog/pic2.jpg",
          date: "24 Apr, 2021",
          title: "Fusce ac tellus ut libero ullamcorper maximus.",
          postLink: "/blog-single"
        },
        {
          image: "assets/images/blog/recent-blog/pic3.jpg",
          date: "30 Apr, 2021",
          title: "In eleifend lobortis tortor, at ornare tellus cursus quis.",
          postLink: "/blog-single"
        }
      ]
    }
  ];

  instagramPosts = [
    {
      image: "assets/images/insta-pic/1.jpg",
      link: "/blog-single"
    },
    {
      image: "assets/images/insta-pic/2.jpg",
      link: "/blog-single"
    },
    {
      image: "assets/images/insta-pic/3.jpg",
      link: "/blog-single"
    },
    {
      image: "assets/images/insta-pic/4.jpg",
      link: "/blog-single"
    },
    {
      image: "assets/images/insta-pic/5.jpg",
      link: "/blog-single"
    },
    {
      image: "assets/images/insta-pic/6.jpg",
      link: "/blog-single"
    }
  ];

  categories = [
    {
      title: "Oil, Gas & Coal",
      badge: "28",
      link: "/blog-single"
    },
    {
      title: "Mechanical Engineering",
      badge: "28",
      link: "/blog-single"
    },
    {
      title: "Chemical Research",
      badge: "05",
      link: "/blog-single"
    },
    {
      title: "Construction Industry",
      badge: "24",
      link: "/blog-single"
    },
    {
      title: "Electrical Engineering",
      badge: "15",
      link: "/blog-single"
    },
    {
      title: "Petroleum Refinery",
      badge: "20",
      link: "/blog-single"
    }
  ];

  tags = [
    {
      title: "Build",
      link: "/blog-single"
    },
    {
      title: "Factory",
      link: "/blog-single"
    },
    {
      title: "Engineering",
      link: "/blog-single"
    },
    {
      title: "Repairing",
      link: "/blog-single"
    },
    {
      title: "Industry",
      link: "/blog-single"
    },
    {
      title: "Materials",
      link: "/blog-single"
    },
    {
      title: "Mechanical",
      link: "/blog-single"
    },
    {
      title: "Buildings",
      link: "/blog-single"
    },
    {
      title: "Construction",
      link: "/blog-single"
    }
  ];

}
