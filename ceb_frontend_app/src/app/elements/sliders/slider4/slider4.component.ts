import { Component, OnInit } from '@angular/core';
declare  var jQuery:  any;
declare  var dz_rev_slider_4:  any;

@Component({
  selector: 'app-slider4',
  templateUrl: './slider4.component.html',
  styleUrls: ['./slider4.component.css']
})
export class Slider4Component implements OnInit {

  constructor() { }

  ngOnInit(): void {
    (function ($) {
      setTimeout(function(){
          dz_rev_slider_4();
        }, 500);
    })(jQuery);
  }

}
