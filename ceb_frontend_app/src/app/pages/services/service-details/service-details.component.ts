import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-service-details',
  templateUrl: './service-details.component.html',
  styleUrls: ['./service-details.component.css']
})
export class ServiceDetailsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  services = [
    {
      title: "All Services",
      link: "/services"
    },
    {
      title: "Oil & Gas Engineering",
      link: "/service-detail"
    },
    {
      title: "Chemical Research",
      link: "/service-detail"
    },
    {
      title: "Agricultural Automation",
      link: "/service-detail"
    },
    {
      title: "Mechanical Engineering",
      link: "/service-detail"
    }
  ];

  brochures = {
    pdf: "javascript:void(0);",
    doc: "javascript:void(0);"
  };

  service = {
    description: "<div class='section-content service-full-info'><div class='services-etc m-b30'><div class='wt-media m-b30'>    <img src='assets/images/services/1.jpg' alt=''></div><div class='text-left'>    <h4 class='wt-title m-b20'>Chemical Research</h4></div><p>Engineering is concerned with the development, improvement, and implementation of    inte grated systems of people, money, knowledge, information, equipment, energy,    materials, analysis and synthesis, as well as the mathematical, physical and    social sciences together with the principles and methods of engineering design    to specify, predict, and evaluate the results to be obtained from such systems    or processes.</p><div class='wt-info'>    <p>Concerned with the development, improvement, and implementation of integrated        system of people, money, knowledge, information, equipment, energy,        materials, analysis and syn thesis, as well as the mathematical, physical        and social sciences together with the principle and methods of engineering        design to specify, predict, and evaluate the results to be obtained from        such systems or processes.</p>    <div class='row'>        <div class='col-md-6 col-lg-4 m-b30'><img src='assets/images/services/s/1.jpg'                alt=''></div>        <div class='col-md-6 col-lg-4 m-b30'><img src='assets/images/services/s/2.jpg'                alt=''></div>        <div class='col-md-6 col-lg-4 m-b30'><img src='assets/images/services/s/3.jpg'                alt=''></div>    </div>    <blockquote class='m-b30 site-bg-black p-a50'>        <i class='fa fa-quote-left font-20'></i>        <p>Raising a heavy fur muff that covered the whole of her lower arm towards            the viewer gregor then turned to look out        </p>        <div class='p-t15 text-uppercase'>            <strong>_William Jomurray</strong>        </div></blockquote></div></div><div class='service-provide p-a30  site-bg-gray-light'><h4 class='wt-title m-b20'>Why Choose Us?</h4><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor    incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam. Lorem    ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor    incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam. Lorem    ipsum dolor sit amet, consectetur adipisicing elit. </p><div class='row align-items-center'><div class='col-md-6'>        <div class='wt-media'>            <img src='assets/images/services/s/4.jpg' alt=''>        </div>    </div><div class='col-md-6'>        <ul class='list-angle-right'>            <li>100% Satisfaction Guarantee.</li>            <li> Accurate Testing Processes.</li>            <li> 35+ Years Of Experience.</li>            <li> Strong Building Materials.</li>            <li>Eco-Friendly Build Materials.</li>        </ul>    </div></div></div></div>"
  }

}
