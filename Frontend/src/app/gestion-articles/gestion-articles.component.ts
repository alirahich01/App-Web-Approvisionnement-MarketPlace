import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router,ActivatedRoute  } from '@angular/router';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-gestion-articles',
  templateUrl: './gestion-articles.component.html',
  styleUrls: ['./gestion-articles.component.css']
})
export class GestionArticlesComponent implements OnInit {
  articles:any;
  // idart:any;
  // nom_art:any;
  // pu_art: any;
  // qte_stock: any;
  constructor(private fb: FormBuilder,private http: HttpClient, private router: Router,private route: ActivatedRoute) { }
  ngOnInit(): void {  
      this.getarticle;
  }
  getarticle(): any{
    this.http.get<any>('http://localhost:8098/Articles').subscribe(
      (res: any) => {
            this.articles = res;
            console.log(this.articles);
      });
}
  supparticle(id: any){
        this.http.get<any>('http://localhost:8098/suppArtic/'+id).subscribe(
          (res: any) => {
                this.articles = res;
                console.log(this.articles);
          });
    }

//  update():any{
//       const data = {
//             nom_art: this.nom_art,
//             pu_art: this.pu_art,
//             qte_stock: this.qte_stock,
//       };
//       this.http.put('http:'+this.idart,data).subscribe(
//         ()=>{
//           window.location.reload();
//         }
//       );
//     }
  }