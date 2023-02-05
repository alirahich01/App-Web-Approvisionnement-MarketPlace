import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-liste-commandes',
  templateUrl: './liste-commandes.component.html',
  styleUrls: ['./liste-commandes.component.css']
})
export class ListeCommandesComponent implements OnInit {
  commandes:any;
  MntTot:any;

  constructor(private fb: FormBuilder,private http: HttpClient, private router: Router,private route: ActivatedRoute) { }
  ngOnInit(): void {
    this.MntTot=0;

    this.getCommands();
    
  }
  getCommands(): any{
    this.http.get<any>('http://localhost:8098/Commandes',
    {headers: {'Authorization': `Bearer ${localStorage.getItem("token")}`}}
    ).subscribe(
      (res: any) => {
            this.commandes = res;
            console.log(this.commandes);
            for(let r of res )
            {
              for(let pr of r.ligneCmds)
              {
                this.MntTot += pr.article.pu_art
              }

            }
      });
}
  


}
