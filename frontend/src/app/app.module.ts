import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ModuleComponent } from './module/module.component';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';
import { TopicComponent } from './topic/topic.component';
import { MdbTabsModule } from 'mdb-angular-ui-kit/tabs';

@NgModule({
  declarations: [
    AppComponent,
    ModuleComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    NgbModule,
    HttpClientModule,
    MdbTabsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
