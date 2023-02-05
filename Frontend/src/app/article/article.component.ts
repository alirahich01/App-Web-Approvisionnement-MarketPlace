import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router,ActivatedRoute  } from '@angular/router';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {
  qtcmd:any;
  articles:any;
  articlesAuPanier: any;
  userRole: any;
  constructor(private fb: FormBuilder,private http: HttpClient, private router: Router,private route: ActivatedRoute) { }
  ngOnInit(): void {
    this.userRole=localStorage.getItem("Role");
    this.getarticle();
  }
  getarticle(): any{
    this.http.get<any>('http://localhost:8098/Articles').subscribe(
      (res: any) => {
            this.articles = res;
            console.log(this.articles);
      });  
  }
  RetirerDuPanier(id: any){
    this.http.delete<any>('http://localhost:8098//deletarticle/'+id).subscribe(
  (res: any) => {
        this.ngOnInit();
        
  })
}
  AjouterAuPanier(id:any):any{
    console.log('Bearer' + localStorage.getItem("token"))
    const data = {
      articId : id,
      qtcmd : this.qtcmd,
    }
    this.http.post('http://localhost:8098/addarticleToPanier',data,
    {headers: {'Authorization': `Bearer ${localStorage.getItem("token")}`}}).subscribe(
      (res:any)=>{
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'votre article est bien ajouter au panier',
          showConfirmButton: false,
          timer: 1500
        });
        window.location.href = "http://localhost:4200/panier";
        this.ngOnInit();
      }
      
    );  
}


}
