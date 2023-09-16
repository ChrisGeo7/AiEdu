import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ModuleComponent } from './module/module.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'module/:topic', component: ModuleComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule { }
