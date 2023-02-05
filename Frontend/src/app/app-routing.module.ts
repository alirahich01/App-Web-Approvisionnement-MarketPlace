import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ArticleComponent } from './article/article.component';
import { CreeNvArticleComponent } from './cree-nv-article/cree-nv-article.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { GestionArticlesComponent } from './gestion-articles/gestion-articles.component';
import { HomeComponent } from './home/home.component';
import { ListeCommandesComponent } from './liste-commandes/liste-commandes.component';
import { ListeLivFrournisseurComponent } from './liste-liv-frournisseur/liste-liv-frournisseur.component';
import { LoginComponent } from './login/login.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { PanierComponent } from './panier/panier.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './register/register.component';
import { UserComponent } from './user/user.component';



const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'clients', component: UserComponent },
  { path: 'panier', component: PanierComponent },
  { path: 'navbar', component: NavBarComponent },
  { path: '', component: HomeComponent },
  { path: 'GestArt', component: GestionArticlesComponent },
  { path: 'NouvArtc', component: CreeNvArticleComponent },
  // { path: 'article/:id', component: ArticleComponent },
  { path: 'articles', component: ArticleComponent },
  { path: 'error', component: ForbiddenComponent },
  { path: 'listeliv', component: ListeLivFrournisseurComponent },
  { path: 'listecmd', component: ListeCommandesComponent},
  { path: 'Profile', component: ProfileComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
