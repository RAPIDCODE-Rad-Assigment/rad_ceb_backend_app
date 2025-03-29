import { Component, OnInit } from '@angular/core';
declare  var jQuery:  any;
declare  var dz_rev_slider_1:  any;

@Component({
  selector: 'app-slider1',
  templateUrl: './slider1.component.html',
  styleUrls: ['./slider1.component.css']
})
export class Slider1Component implements OnInit {

  constructor() { }

  ngOnInit(): void {
    (function ($) {
      setTimeout(function(){
          dz_rev_slider_1();
        }, 500);
    })(jQuery);
  }

}
