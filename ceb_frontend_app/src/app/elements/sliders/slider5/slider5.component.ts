import { Component, OnInit } from '@angular/core';
declare  var jQuery:  any;
declare  var dz_rev_slider_5:  any;

@Component({
  selector: 'app-slider5',
  templateUrl: './slider5.component.html',
  styleUrls: ['./slider5.component.css']
})
export class Slider5Component implements OnInit {

  constructor() { }

  ngOnInit(): void {
    (function ($) {
      setTimeout(function(){
          dz_rev_slider_5();
        }, 500);
    })(jQuery);
  }

}
