import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router,ActivatedRoute  } from '@angular/router';
import { Observable } from 'rxjs';
import { observableToBeFn } from 'rxjs/internal/testing/TestScheduler';
import Swal from 'sweetalert2';
import { category } from '../model/category.model';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent implements OnInit {
  articles:any;
  id_articles: number[] = [];
  qtes: number[] = [];
  
  constructor(private fb: FormBuilder,private http: HttpClient, private router: Router,private route: ActivatedRoute) { }
   ngOnInit() {
    if(localStorage.getItem('token')){
      if(localStorage.getItem('role')=='false'){
        window.location.href='/error'
      }
      else{
         this.getarticles();
        
      } 
    } 
    // this.getarticles();
  }
  getArticlesId(){
    
  }
  getarticles(){
    this.http.get<any>('http://localhost:8098/ArticlesPanier',
    {headers: {'Authorization': `Bearer ${localStorage.getItem("token")}`}}
    ).subscribe(
      (res: any) => {
            this.articles = res;
            for( let r of res){
              this.id_articles.push(r['id']);
            }
            console.log(this.id_articles)
      });
      this.http.get<any>('http://localhost:8098/qtes',
      {headers: {'Authorization': `Bearer ${localStorage.getItem("token")}`}}
      ).subscribe(
        (res:any)=>{
          this.qtes=res;
          console.log(this.qtes)
        }
      );
  }


  commander():any{
    console.log('Bearer' + localStorage.getItem("token"))
    const data = {
      id_articles : this.id_articles,
      qtes:this.qtes, 
    }
    this.http.post('http://localhost:8098/ajtCommandes',data,
    {headers: {'Authorization': `Bearer ${localStorage.getItem("token")}`}}).subscribe(
      (res:any)=>{
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'votre commande est fait avec succes',
          showConfirmButton: false,
          timer: 1500
        });
        window.location.href = "http://localhost:4200/panier";
        this.ngOnInit();
      }   
    );
  }
 
  supparticles(id:any):any{
    this.http.delete<any>('http://127.0.0.1:8000/api/deletearticleP/'+id).subscribe(
      (res: any) => {
            this.articles = res;
            console.log(res);
            
      })
  }

}
