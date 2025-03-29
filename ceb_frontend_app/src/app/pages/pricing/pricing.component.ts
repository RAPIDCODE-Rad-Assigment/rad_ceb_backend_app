import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pricing',
  templateUrl: './pricing.component.html',
  styleUrls: ['./pricing.component.css']
})
export class PricingComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  pricing = [
    {
      plan: "Basic",
      price: "$29.00",
      tenure: "month",
      purchaseLink: "/about1",
      features: [
        {
          name: "Concept Project"
        },
        {
          name: "Site Planning"
        },
        {
          name: "Civil Work"
        },
        {
          name: "Hire Contractor"
        }
      ]
    },
    {
      plan: "Standard",
      price: "$49.00",
      tenure: "month",
      purchaseLink: "/about1",
      features: [
        {
          name: "Concept Project"
        },
        {
          name: "Site Planning"
        },
        {
          name: "Civil Work"
        },
        {
          name: "Hire Contractor"
        }
      ]
    },
    {
      plan: "Business",
      price: "$99.00",
      tenure: "month",
      purchaseLink: "/about1",
      features: [
        {
          name: "Concept Project"
        },
        {
          name: "Site Planning"
        },
        {
          name: "Civil Work"
        },
        {
          name: "Hire Contractor"
        }
      ]
    }
  ];

}
