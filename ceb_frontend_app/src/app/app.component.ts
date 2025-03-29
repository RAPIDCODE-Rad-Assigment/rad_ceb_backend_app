import { AfterViewInit, Component, OnInit, Inject } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { filter } from 'rxjs/operators';
import { DOCUMENT } from '@angular/common';

declare var jQuery: any;
declare var onLoadMethods: any;
declare var onReadyFunctions: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements AfterViewInit, OnInit {
  title = 'indusza';

  constructor(private router: Router, @Inject(DOCUMENT) private document: Document) {
    
    this.router.events
      .pipe(filter(event => event instanceof NavigationEnd))
      .subscribe((event: NavigationEnd) => {
        this.updateTheme(event.url);
      });
  }

  ngOnInit(): void {
    
  }

  ngAfterViewInit(): void {
    this.router.events
      .pipe(filter(event => event instanceof NavigationEnd))
      .subscribe((event: NavigationEnd) => {
        this.reinitializeThings();
      });
  }

  reinitializeThings() {
    (function ($) {
      setTimeout(function () {
        // console.log('reinitializeThings');
        onLoadMethods();
        onReadyFunctions();
      }, 500);
    })(jQuery);
  }

  updateTheme(url: string) {
    if(url == "/index3") {
      this.loadStyle('skin-3');
    } else if(url == "/index4") {
      this.loadStyle('skin-7');
    } else if(url == "/index5") {
      this.loadStyle('skin-12');
    } else {
      this.loadStyle('skin-1');
    }
  }

  loadStyle(styleName: string) {
    const head = this.document.getElementsByTagName('head')[0];

    let themeLink = this.document.getElementById(
      'client-theme'
    ) as HTMLLinkElement;

    console.log(themeLink);
    if (themeLink) {
      themeLink.href = "assets/css/" + styleName + ".css";
    } else {
      const style = this.document.createElement('link');
      style.id = 'client-theme';
      style.rel = 'stylesheet';
      style.href = "assets/css/" + `${styleName}` + ".css";

      head.appendChild(style);
    }
  }

}
