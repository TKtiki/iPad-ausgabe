import { HomeComponent } from "./home/home.component";
import { DatenverwaltungComponent } from "./datenverwaltung/datenverwaltung.component";
import { AdminComponent } from "./admin/admin.component";
import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";

const routes: Routes = [
  { path: "admin", component: AdminComponent },
  { path: "dv", component: DatenverwaltungComponent },
  { path: "home", component: HomeComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
