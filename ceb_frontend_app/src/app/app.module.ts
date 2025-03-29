import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoaderComponent } from './elements/loader/loader.component';
import { Home1Component } from './pages/home/home1/home1.component';
import { Home2Component } from './pages/home/home2/home2.component';
import { Home3Component } from './pages/home/home3/home3.component';
import { Home4Component } from './pages/home/home4/home4.component';
import { Home5Component } from './pages/home/home5/home5.component';
import { Header1Component } from './elements/header/header1/header1.component';
import { Header2Component } from './elements/header/header2/header2.component';
import { Header3Component } from './elements/header/header3/header3.component';
import { Header4Component } from './elements/header/header4/header4.component';
import { Header5Component } from './elements/header/header5/header5.component';
import { Footer1Component } from './elements/footer/footer1/footer1.component';
import { Footer2Component } from './elements/footer/footer2/footer2.component';
import { Footer3Component } from './elements/footer/footer3/footer3.component';
import { Footer4Component } from './elements/footer/footer4/footer4.component';
import { Footer5Component } from './elements/footer/footer5/footer5.component';
import { Slider1Component } from './elements/sliders/slider1/slider1.component';
import { Facts1Component } from './elements/facts_section/facts1/facts1.component';
import { AboutSection1Component } from './elements/about_section/about-section1/about-section1.component';
import { Team1Component } from './elements/team_section/team1/team1.component';
import { Team2Component } from './elements/team_section/team2/team2.component';
import { Services1Component } from './elements/service/services1/services1.component';
import { Buildfuture1Component } from './elements/buildfuture1/buildfuture1.component';
import { Testimonial1Component } from './elements/testimonials/testimonial1/testimonial1.component';
import { Updates1Component } from './elements/update_section/updates1/updates1.component';
import { Updates2Component } from './elements/update_section/updates2/updates2.component';
import { Ourclients1Component } from './elements/ourclients1/ourclients1.component';
import { About1Component } from './pages/about/about1/about1.component';
import { About2Component } from './pages/about/about2/about2.component';
import { Facts2Component } from './elements/facts_section/facts2/facts2.component';
import { AboutSection2Component } from './elements/about_section/about-section2/about-section2.component';
import { Features1Component } from './elements/features/features1/features1.component';
import { Features2Component } from './elements/features/features2/features2.component';
import { BlogGridComponent } from './pages/blog/blog-grid/blog-grid.component';
import { NewsBoxComponent } from './elements/update_section/news-box/news-box.component';
import { BlogSingleComponent } from './pages/blog/blog-single/blog-single.component';
import { BlogListComponent } from './pages/blog/blog-list/blog-list.component';
import { BoxAboutAuthorComponent } from './elements/box-about-author/box-about-author.component';
import { BoxSearchComponent } from './elements/box-search/box-search.component';
import { BoxRecentPostsComponent } from './elements/box-recent-posts/box-recent-posts.component';
import { BoxInstagramComponent } from './elements/box-instagram/box-instagram.component';
import { BoxCategoriesComponent } from './elements/box-categories/box-categories.component';
import { BoxTagsComponent } from './elements/box-tags/box-tags.component';
import { BlogShortComponent } from './elements/blog-short/blog-short.component';
import { BlogFullComponent } from './elements/blog-full/blog-full.component';
import { RelatedPostsComponent } from './elements/related-posts/related-posts.component';
import { CommentsSectionComponent } from './elements/comments-section/comments-section.component';
import { LeaveAReplyComponent } from './elements/leave-a-reply/leave-a-reply.component';
import { ContactUsComponent } from './pages/contact-us/contact-us.component';
import { Error404Component } from './pages/error404/error404.component';
import { FaqComponent } from './pages/faq/faq.component';
import { PageBannerComponent } from './elements/page-banner/page-banner.component';
import { FontIconComponent } from './pages/font-icon/font-icon.component';
import { Team3Component } from './elements/team_section/team3/team3.component';
import { Team4Component } from './elements/team_section/team4/team4.component';
import { OurTeamComponent } from './pages/team/our-team/our-team.component';
import { OurTeamDetailComponent } from './pages/team/our-team-detail/our-team-detail.component';
import { TeamProfileComponent } from './elements/team_section/team-profile/team-profile.component';
import { TeamSkillsComponent } from './elements/team_section/team-skills/team-skills.component';
import { FaqsComponent } from './elements/faq/faqs/faqs.component';
import { FaqFormComponent } from './elements/faq/faq-form/faq-form.component';
import { Pricing1Component } from './elements/pricing/pricing1/pricing1.component';
import { Pricing2Component } from './elements/pricing/pricing2/pricing2.component';
import { PricingComponent } from './pages/pricing/pricing.component';
import { Project1Component } from './pages/project/project1/project1.component';
import { Project2Component } from './pages/project/project2/project2.component';
import { ProjectSingleComponent } from './pages/project/project-single/project-single.component';
import { ProjectCarouselComponent } from './pages/project/project-carousel/project-carousel.component';
import { ProjectBox1Component } from './elements/project/project-box1/project-box1.component';
import { ProjectBox2Component } from './elements/project/project-box2/project-box2.component';
import { ProjectFullComponent } from './elements/project/project-full/project-full.component';
import { ProjectInfoComponent } from './elements/project/project-info/project-info.component';
import { BrochuresComponent } from './elements/project/brochures/brochures.component';
import { ProjectCarousel1Component } from './elements/project/project-carousel1/project-carousel1.component';
import { ProjectCarousel2Component } from './elements/project/project-carousel2/project-carousel2.component';
import { ProjectBox3Component } from './elements/project/project-box3/project-box3.component';
import { ServicesComponent } from './pages/services/services/services.component';
import { ServiceDetailsComponent } from './pages/services/service-details/service-details.component';
import { BoxService1Component } from './elements/service/box-service1/box-service1.component';
import { Testimonial2Component } from './elements/testimonials/testimonial2/testimonial2.component';
import { Slider2Component } from './elements/sliders/slider2/slider2.component';
import { Slider3Component } from './elements/sliders/slider3/slider3.component';
import { Slider4Component } from './elements/sliders/slider4/slider4.component';
import { Slider5Component } from './elements/sliders/slider5/slider5.component';
import { AboutSection3Component } from './elements/about_section/about-section3/about-section3.component';
import { BoxService2Component } from './elements/service/box-service2/box-service2.component';
import { Facts3Component } from './elements/facts_section/facts3/facts3.component';
import { ProjectBox4Component } from './elements/project/project-box4/project-box4.component';
import { Testimonial3Component } from './elements/testimonials/testimonial3/testimonial3.component';
import { AboutSection4Component } from './elements/about_section/about-section4/about-section4.component';
import { AboutSection5Component } from './elements/about_section/about-section5/about-section5.component';
import { AboutSection6Component } from './elements/about_section/about-section6/about-section6.component';
import { AboutSection7Component } from './elements/about_section/about-section7/about-section7.component';
import { Facts4Component } from './elements/facts_section/facts4/facts4.component';
import { Testimonial4Component } from './elements/testimonials/testimonial4/testimonial4.component';
import { Team5Component } from './elements/team_section/team5/team5.component';
import { ServiceSection1Component } from './elements/service/service-section1/service-section1.component';
import { Facts5Component } from './elements/facts_section/facts5/facts5.component';
import { Testimonial5Component } from './elements/testimonials/testimonial5/testimonial5.component';
import { BlogSection1Component } from './elements/blog-section1/blog-section1.component';
import { LoaderDirective } from './directives/loader/loader.directive';
import { RegisterComponent } from './pages/register/register.component';

@NgModule({
  declarations: [
    AppComponent,
    LoaderComponent,
    Home1Component,
    Home2Component,
    Home3Component,
    Home4Component,
    Home5Component,
    Header1Component,
    Header2Component,
    Header3Component,
    Header4Component,
    Header5Component,
    Footer1Component,
    Footer2Component,
    Footer3Component,
    Footer4Component,
    Footer5Component,
    Slider1Component,
    Facts1Component,
    AboutSection1Component,
    Team1Component,
    Team2Component,
    Services1Component,
    Buildfuture1Component,
    Testimonial1Component,
    Updates1Component,
    Updates2Component,
    Ourclients1Component,
    About1Component,
    About2Component,
    Facts2Component,
    AboutSection2Component,
    Features1Component,
    Features2Component,
    BlogGridComponent,
    NewsBoxComponent,
    BlogSingleComponent,
    BlogListComponent,
    BoxAboutAuthorComponent,
    BoxSearchComponent,
    BoxRecentPostsComponent,
    BoxInstagramComponent,
    BoxCategoriesComponent,
    BoxTagsComponent,
    BlogShortComponent,
    BlogFullComponent,
    RelatedPostsComponent,
    CommentsSectionComponent,
    LeaveAReplyComponent,
    ContactUsComponent,
    Error404Component,
    FaqComponent,
    PageBannerComponent,
    FontIconComponent,
    Team3Component,
    Team4Component,
    OurTeamComponent,
    OurTeamDetailComponent,
    TeamProfileComponent,
    TeamSkillsComponent,
    FaqsComponent,
    FaqFormComponent,
    Pricing1Component,
    Pricing2Component,
    PricingComponent,
    Project1Component,
    Project2Component,
    ProjectSingleComponent,
    ProjectCarouselComponent,
    ProjectBox1Component,
    ProjectBox2Component,
    ProjectFullComponent,
    ProjectInfoComponent,
    BrochuresComponent,
    ProjectCarousel1Component,
    ProjectCarousel2Component,
    ProjectBox3Component,
    ServicesComponent,
    ServiceDetailsComponent,
    BoxService1Component,
    Testimonial2Component,
    Slider2Component,
    Slider3Component,
    Slider4Component,
    Slider5Component,
    AboutSection3Component,
    BoxService2Component,
    Facts3Component,
    ProjectBox4Component,
    Testimonial3Component,
    AboutSection4Component,
    AboutSection5Component,
    AboutSection6Component,
    AboutSection7Component,
    Facts4Component,
    Testimonial4Component,
    Team5Component,
    ServiceSection1Component,
    Facts5Component,
    Testimonial5Component,
    BlogSection1Component,
    LoaderDirective,
    RegisterComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
