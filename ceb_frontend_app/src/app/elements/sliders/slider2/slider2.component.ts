import { Component, OnInit } from '@angular/core';
declare  var jQuery:  any;
declare  var dz_rev_slider_2:  any;

@Component({
  selector: 'app-slider2',
  templateUrl: './slider2.component.html',
  styleUrls: ['./slider2.component.css']
})
export class Slider2Component implements OnInit {

  constructor() { }

  ngOnInit(): void {
    (function ($) {
      setTimeout(function(){
          dz_rev_slider_2();
        }, 500);
    })(jQuery);
  }

}
