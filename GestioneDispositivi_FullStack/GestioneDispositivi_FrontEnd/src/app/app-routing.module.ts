import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PrenotazioniComponent} from "./prenotazioni/prenotazioni/prenotazioni.component";
import {HomeComponent} from "./home/home/home.component";

const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path:"prenotazioni",
    component: PrenotazioniComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
