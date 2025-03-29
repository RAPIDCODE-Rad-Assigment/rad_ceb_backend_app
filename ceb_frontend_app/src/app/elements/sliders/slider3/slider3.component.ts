import { Component, OnInit } from '@angular/core';
declare  var jQuery:  any;
declare  var dz_rev_slider_3:  any;

@Component({
  selector: 'app-slider3',
  templateUrl: './slider3.component.html',
  styleUrls: ['./slider3.component.css']
})
export class Slider3Component implements OnInit {

  constructor() { }

  ngOnInit(): void {
    (function ($) {
      setTimeout(function(){
          dz_rev_slider_3();
        }, 500);
    })(jQuery);
  }

}
