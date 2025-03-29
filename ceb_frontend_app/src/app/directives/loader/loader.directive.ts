import { AfterViewInit, Directive, OnInit, ElementRef, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appLoader]'
})
export class LoaderDirective implements OnInit, AfterViewInit {

  constructor(private elementRef: ElementRef, private renderer: Renderer2) { }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {
    setTimeout(() => {
      this.elementRef.nativeElement.style.display = 'none';
      // or 
      // this.renderer.setStyle(this.elementRef.nativeElement, 'display', 'none');
    }, 500);
  }
  
}
