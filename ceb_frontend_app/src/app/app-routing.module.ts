import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { Home1Component } from './pages/home/home1/home1.component';
import { Home2Component } from './pages/home/home2/home2.component';
import { Home3Component } from './pages/home/home3/home3.component';
import { Home4Component } from './pages/home/home4/home4.component';
import { Home5Component } from './pages/home/home5/home5.component';
import { About1Component } from './pages/about/about1/about1.component';
import { About2Component } from './pages/about/about2/about2.component';
import { ServicesComponent } from './pages/services/services/services.component';
import { ServiceDetailsComponent } from './pages/services/service-details/service-details.component';
import { OurTeamComponent } from './pages/team/our-team/our-team.component';
import { OurTeamDetailComponent } from './pages/team/our-team-detail/our-team-detail.component';
import { FaqComponent } from './pages/faq/faq.component';
import { PricingComponent } from './pages/pricing/pricing.component';
import { Error404Component } from './pages/error404/error404.component';
import { FontIconComponent } from './pages/font-icon/font-icon.component';
import { Project1Component } from './pages/project/project1/project1.component';
import { Project2Component } from './pages/project/project2/project2.component';
import { ProjectCarouselComponent } from './pages/project/project-carousel/project-carousel.component';
import { ProjectSingleComponent } from './pages/project/project-single/project-single.component';
import { BlogGridComponent } from './pages/blog/blog-grid/blog-grid.component';
import { BlogSingleComponent } from './pages/blog/blog-single/blog-single.component';
import { BlogListComponent } from './pages/blog/blog-list/blog-list.component';
import { ContactUsComponent } from './pages/contact-us/contact-us.component';
import { RegisterComponent } from './pages/register/register.component';

const routes: Routes = [
  { path: '', component: Home1Component },
  { path: 'index', component: Home1Component },
  { path: 'index2', component: Home2Component },
  { path: 'index3', component: Home3Component },
  { path: 'index4', component: Home4Component },
  { path: 'index5', component: Home5Component },
  { path: 'about1', component: About1Component },
  { path: 'about2', component: About2Component },
  { path: 'services', component: ServicesComponent },
  { path: 'service-detail', component: ServiceDetailsComponent },
  { path: 'our-team', component: OurTeamComponent },
  { path: 'our-team-detail', component: OurTeamDetailComponent },
  { path: 'faq', component: FaqComponent },
  { path: 'pricing', component: PricingComponent },
  { path: 'error404', component: Error404Component },
  { path: 'icon-font', component: FontIconComponent },
  { path: 'project1', component: Project1Component },
  { path: 'project2', component: Project2Component },
  { path: 'project-carousel', component: ProjectCarouselComponent },
  { path: 'project-single', component: ProjectSingleComponent },
  { path: 'blog-grid', component: BlogGridComponent },
  { path: 'blog-list', component: BlogListComponent },
  { path: 'blog-single', component: BlogSingleComponent },
  { path: 'contact', component: ContactUsComponent },
  { path: 'register', component: RegisterComponent },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})

export class AppRoutingModule { }
