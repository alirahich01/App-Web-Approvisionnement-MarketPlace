import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cree-nv-article',
  templateUrl: './cree-nv-article.component.html',
  styleUrls: ['./cree-nv-article.component.css']
})
export class CreeNvArticleComponent implements OnInit {
  form!: FormGroup;
  urlImageaddd: string | undefined;
  constructor(private fb: FormBuilder,private http: HttpClient, private router: Router,private route: ActivatedRoute) { }

  
  nom_art: any;
  pu_art: any;
  qte_stock: any;
  ngOnInit(): void {
  }
  Ajouter(nom_art:any,pu_art:any,qte_stock:any){
    const data = {
      nom_art: nom_art,
      pu_art: pu_art,
      qte_stock: qte_stock,
    }
    this.http.post('http://localhost:8098/ajtArticles', data).subscribe(
      (res: any) => {
            console.log(res);
            Swal.fire({
              position: 'top-end',
              icon: 'success',
              title: 'article added',
              showConfirmButton: false,
              timer: 1500
            });
            this.nom_art="";
            this.pu_art="";
            this.qte_stock="";
      });
      
  }
}
