import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-blog-list',
  templateUrl: './blog-list.component.html',
  styleUrls: ['./blog-list.component.css']
})
export class BlogListComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  blogs = [
    {
      image: "assets/images/blog/list/bg1.jpg",
      day: "13",
      month: "July",
      field: "Factory",
      title: "Let us help you invest in sustainable infrastructure.",
      description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida. Risus commodo viverra maece sed do eiusmod tempor incididunt ut labore.",
      linkToReadMore: "/blog-single"
    },
    {
      image: "assets/images/blog/list/bg2.jpg",
      day: "13",
      month: "July",
      field: "Factory",
      title: "Manufacturing Relationships. Distributing Quality.",
      description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida. Risus commodo viverra maece sed do eiusmod tempor incididunt ut labore.",
      linkToReadMore: "/blog-single"
    },
    {
      image: "assets/images/blog/list/bg3.jpg",
      day: "13",
      month: "July",
      field: "Factory",
      title: "The factors that countries create are energy",
      description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida. Risus commodo viverra maece sed do eiusmod tempor incididunt ut labore.",
      linkToReadMore: "/blog-single"
    },
    {
      image: "assets/images/blog/list/bg4.jpg",
      day: "13",
      month: "July",
      field: "Factory",
      title: "The factors that countries create are energy",
      description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida. Risus commodo viverra maece sed do eiusmod tempor incididunt ut labore.",
      linkToReadMore: "/blog-single"
    }
  ];

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
